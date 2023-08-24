package kr.co.baskinrobbins.board.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.co.baskinrobbins.board.domain.Board;
import kr.co.baskinrobbins.board.domain.PageInfo;
import kr.co.baskinrobbins.board.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@RequestMapping(value="/board/insert.do", method=RequestMethod.GET)
	public String showInsertBoard(
			HttpSession session
			, Model model
			) {
		String memberId = (String)session.getAttribute("memberId");
		System.out.println(memberId);
		return "board/insert";
	}
	
	/*
	 * 파일 업로드 위해 3가지 수정
	 * 1. inset.jsp의 form태그에 enctype="multipart/form-data" 추가, <input>태그 추가(name=@RequestParam으로 가져오는 값)
	 * 2. pom.xml에 파일 업로드 관련 라이브러리 추가
	 * 3. root-context.xml에 파일 업로드 빈 등록
	 */
	@RequestMapping(value="/board/insert.do", method = RequestMethod.POST)
	public ModelAndView insertBoard(
			@RequestParam(value="uploadFile", required = false) MultipartFile uploadFile
			, HttpSession session
			, HttpServletRequest request
			, @ModelAttribute Board board
			, ModelAndView mv
			) {
		/*
		 * 문의내용 입력 후 버튼 누르면 
		 * 세션에 저장된 아이디를 받아서 
		 * 문의사항이 DB에 저장됨(memberId == boardWriter)
		 */
		String memberId = (String)session.getAttribute("memberId");
		try {
			board.setBoardWriter(memberId);
			// 업로드할 파일이 있는지 확인
			if(uploadFile != null && !uploadFile.getOriginalFilename().equals("")) {
				Map<String, Object> nMap = this.saveFile(uploadFile, request);
				// 변수로 만들어서 하기, 바로 board.set해서 넣어도 됨!
				String fileRename = (String)nMap.get("fileRename");
				String fileName = (String)nMap.get("fileName");
				String filePath = (String)nMap.get("filePath");
				long fileLength = (long)nMap.get("fileLength");
				board.setBoardFileName(fileName);
				board.setBoardFileRename(fileRename);
				board.setBoardFilePath(filePath);
				board.setBoardFileLength(fileLength);
			}
			int result = service.insertBoard(board);
				if(result > 0) {
					mv.addObject("title", "문의사항 작성 성공").addObject("msg", "문의사항 작성을 완료했습니다.");
					mv.addObject("urlIndex", "/board/list.do").addObject("btnMsgIndex", "문의사항 내역으로 이동");
					mv.addObject("urlBack", "/member/myPage.do").addObject("btnMsgBack", "마이페이지로 이동");
					mv.setViewName("common/serviceResult");
					return mv;
				}else {
					mv.addObject("title", "문의사항 작성 실패").addObject("msg", "문의사항 작성이 실패했습니다.");
					mv.addObject("urlIndex", "/board/list.do").addObject("btnMsgIndex", "문의사항 내역으로 이동");
					mv.addObject("urlBack", "/member/myPage.do").addObject("btnMsgBack", "마이페이지로 이동");
					mv.setViewName("common/serviceResult");
					return mv;
				}
			} catch (Exception e) {
				mv.addObject("title", "문의내역 작성 보기 실패").addObject("msg", e.getMessage());
				mv.addObject("urlIndex", "/board/list.do").addObject("btnMsgIndex", "문의사항 내역으로 이동");
				mv.addObject("urlBack", "/member/myPage.do").addObject("btnMsgBack", "마이페이지로 이동");
				mv.setViewName("common/serviceResult");
				return mv;
		}
	}
	
	// 파일 처리 메소드화
	private Map<String, Object> saveFile(MultipartFile uploadFile, HttpServletRequest request) throws IllegalStateException, IOException {
		// HashMap 사용해서 파일 저장하기
		Map<String, Object> infoMap = new HashMap<String, Object>();
		// ===================== 파일 이름 설정하기 ==========================
		String fileName = uploadFile.getOriginalFilename();
		
		// ===================== 파일 경로 ==============================
		String root = request.getSession().getServletContext().getRealPath("resources");
		/*
		 * getServletContext() : 서블릿에 관련된 모든 정보를 가짐
		 * getTealPath("resources") : resources에 대한 경로를 가지고 옴
		 */
		String saveFolder = root + "\\buploadFiles";
		// 파일 객체 만들기
		File folder = new File(saveFolder);
		if(!folder.exists()) {
			folder.mkdir();
		}
		// ===================== 파일 리네임(시간으로) ========================
		SimpleDateFormat sdf = new SimpleDateFormat("yyyMMddHHmmss");
		String strResult = sdf.format(new Date(System.currentTimeMillis()));
		
		// ===================== 확장자명 구하기 =====================
		String ext = fileName.substring(fileName.lastIndexOf(".")+1);
		// 설정한 파일리네임 = B(파일 구분용) + 시간으로 리네임한 이름 + . + 확장자명
		String fileRename = "B" + strResult + "." + ext;
		// 최종 저장 경로 = 저장할 폴더(resources + 저장하는 폴더 위치 + \\ + 설정한 파일리네임)
		String savePath = saveFolder + "\\" + fileRename;
		// 파일 크기 구하기
		long fileLength = uploadFile.getSize();
		// ==================== 진짜 파일 저장 =======================
		File file = new File(savePath);
		uploadFile.transferTo(file); // 예외처리 해주기
		// HashMap에 데이터 put 하기
		infoMap.put("fileName", fileName);
		infoMap.put("fileRename", fileRename);
		infoMap.put("filePath", savePath);
		infoMap.put("fileLength", fileLength);

		return infoMap;
	}

	@RequestMapping(value="/board/delete.do", method = RequestMethod.GET)
	public String deleteBoard(
			HttpSession session
			, @RequestParam("boardNo") int boardNo
			, Model model
			) {
		String memberId = (String)session.getAttribute("memberId");
		int result = service.deleteBoard(boardNo);
		if(result > 0) {
			model.addAttribute("title", "문의사항 삭제 성공");
			model.addAttribute("msg", "문의사항 작성에 성공했습니다.");
			model.addAttribute("url", "member/myPage.do?memberId="+memberId);
			model.addAttribute("btnMsg", "문의사항 내역으로 이동");
			return "common/serviceResultOneBtn";
		}else {
			model.addAttribute("title", "문의사항 작성 실패");
			model.addAttribute("msg", "문의사항 작성이 실패했습니다.");
			model.addAttribute("urlIndex", "/board/list.do");
			model.addAttribute("btnMsgIndex", "문의사항 내역으로 이동");
			model.addAttribute("urlBack", "/member/myPage.do");
			model.addAttribute("btnMsgBack", "마이페이지로 이동");
			return "common/serviceResult";
		}
	}
	
	
	@RequestMapping(value="board/list.do", method = RequestMethod.GET)
	public String showBoardList(
		@RequestParam(value="page", required = false, defaultValue = "1") Integer currentPage
		, HttpSession session
		, Model model) {
		String boardWriter = (String)session.getAttribute("memberId");
		/*
		 *  페이지 네비게이션이 모든 게시물의 정보를 가지고 출력이 되어(모든 유저의 게시글을 가져와)
		 *  totalCount를 구할 때 세션에서 가져온 boardWriter를 넘겨주어 처음부터 로그인한 유저의 글만 가져오도록함
		 *  class파일들과 mapper까지 모두 수정했음 
		 */
		try {
			int totalCount = service.getBoardListCount(boardWriter); // 게시글 총 갯수를 구해오는 식
			PageInfo pInfo = this.getPageInfo(currentPage, boardWriter, totalCount); 
			// 페이지 정보(현재 페이지(보여지는 페이지), 작성자, 게시글 총 갯수)
			System.out.println(pInfo.toString());
			List<Board> bList = service.selectBoardList(pInfo);
			if(!bList.isEmpty()) {
				model.addAttribute("pInfo", pInfo);
				model.addAttribute("bList", bList);
				return "board/list";
			}else {
				model.addAttribute("pInfo", pInfo);
				model.addAttribute("bList", bList);
				return "board/list";
			}
			
		}catch (Exception e) {
			model.addAttribute("title", "문의내역 조회 실패");
			model.addAttribute("msg", e.getMessage());
			model.addAttribute("url", "member/myPage.do?memberId="+boardWriter);
			model.addAttribute("btnMsg", "이전으로 이동");
			return "common/serviceResultOneBtn";
		}
	}
	/*
	 * 게시글 총 갯수 카운트 성공
	 * 페이지 정보를 가진 객체 생성(PageInfo pInfo)
	 * 
	 */

	private PageInfo getPageInfo(Integer currentPage, String boardWriter, int totalCount) {
		PageInfo pi = null;
		int recordnaviCountPage = 5;	// 한 페이지에 보여줄 게시물(전체 게시물의 값이 필요)
		int naviCountPerPage = 5;	// 한 페이지에 보여줄 페이지의 개수(currentPage의 값이 필요)
		int naviTotalCount;		// 범위의 총 갯수(currentPage의 값이 필요)
		int startNavi;
		int endNavi;
		
		// (int) 강제 형변환, (double) 자동 형변환
		// 네비게이터의 총 갯수 = 총 게시물 / 한 페이지당 보여지는 게시물 + 0.9
		naviTotalCount = (int)((double)totalCount/recordnaviCountPage+0.9);
													// +0.9하면 알아서 반올림
		// currentPage값이 1~5일 때 startNavi가 1로 고정되도록 구해주는 식
		startNavi = ((int)((double)currentPage/naviCountPerPage+0.9)-1)*naviCountPerPage + 1;
		endNavi = startNavi + naviCountPerPage -1;
		// endNavi는 startNavi에 무조건 naviCountPerPage값을 더하므로 실제 최대값보다 커질 수 있음
		if(endNavi > naviTotalCount) {
			endNavi = naviTotalCount;
		}
		pi = new PageInfo(currentPage, boardWriter, recordnaviCountPage, naviCountPerPage, startNavi, endNavi, totalCount, naviTotalCount);
		return pi;
	}
	
	@RequestMapping(value="/board/detail.do", method = RequestMethod.GET)
	public ModelAndView showBoardDetail(
			ModelAndView mv
			, @RequestParam("boardNo") Integer boardNo
			, HttpSession session
			, Model model
			) {
		String boardWriter = (String)session.getAttribute("memberId");
		Board board = new Board(boardNo, boardWriter);
		Board bPost = service.selectBoardDetail(board);
		if(bPost != null) {
			mv.addObject("board", bPost);
		}else {
			mv.addObject("title", "문의내역 상세 보기 실패");
			mv.addObject("msg", "데이터를 찾을 수 없습니다.");
			mv.addObject("url", "member/myPage.do");
			mv.addObject("btnMsg", "이전으로 이동");
		}
		return mv;
	}
	
	@RequestMapping(value="/board/modify.do", method = RequestMethod.GET)
	public ModelAndView showModifyBoard(
			ModelAndView mv
			, @RequestParam("boardNo") Integer boardNo
			, HttpSession session
			) {
		/*
		 * 문의사항 디테일 : 세션에 저장된 아이디와 보드에 저장된 보드번호로 할 예정
		 * SELECT * FROM BOARD_TBL WHERE BOARD_NO=#{boardNo } AND BOARD_WRITER=#{memberId }
		 */
		String boardWriter = (String)session.getAttribute("memberId");
		Board board = new Board(boardNo, boardWriter);
		Board bPost = service.selectBoardDetail(board);
		System.out.println(board);
		if(bPost != null) {
			mv.addObject("board", bPost);
		}else {
			mv.addObject("title", "문의내역 수정 페이지 조회 실패");
			mv.addObject("msg", "데이터를 찾을 수 없습니다.");
			mv.addObject("url", "board/detail.do");
			mv.addObject("btnMsg", "이전으로 이동");
		}
		return mv;
	}
	
}

/*
 * 1. 회원가입 (접속 -> 완, 입력 -> 완)
 * 2. 로그인 (접속 -> 완, 입력 -> 완)
 * 3. 로그아웃 완 (true/false -> 실패, sessions.removeAttribute로 로그아웃 성공)
 * 4. 마이페이지 (접속 -> 완, 조회 -> 완, 수정 -> 완)
 * 5. 회원탈퇴 -> 완
 * 6. 아이디, 비밀번호 찾기 (선택 -> 완, 아이디 -> 완, 비밀번호-> 완)
 * 
 * 7. 1:1 문의 내역(로그인 후 리스트 출력 완)
 * 8. 1:1 문의 상세보기(완)
 * 9. 1:1 문의 작성(작성페이지 이동 완, 문의글 작성 -> 완)
 * 10. 1:1 문의 삭제(완)
 * 
 */
