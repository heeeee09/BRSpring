package kr.co.baskinrobbins.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.baskinrobbins.board.domain.Board;
import kr.co.baskinrobbins.board.domain.PageInfo;
import kr.co.baskinrobbins.board.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@RequestMapping(value="board/insert.do", method=RequestMethod.GET)
	public String showInsertBoard(
			HttpSession session
			, Model model
			) {
		String memberId = (String)session.getAttribute("memberId");
		System.out.println(memberId);
		return "board/insert";
	}
	
	public String insertBoard() {
		/*
		 * 문의내용 입력 후 버튼 누르면 
		 * 세션에 저장된 아이디를 받아서 
		 * 문의사항이 DB에 저장됨(memberId == boardWriter)
		 */
		return "";
	}
	
	@RequestMapping(value="board/list.do", method = RequestMethod.GET)
	public String showBoardList(
		@RequestParam(value="page", required = false, defaultValue = "1") Integer currentPage
		, @RequestParam("memberId") String boardWriter
		, HttpSession session
		, Model model) {
		try {
			String memberId = (String)session.getAttribute("memberId");
			int totalCount = service.getBoardListCount(); // 게시글 총 갯수를 구해오는 식
			PageInfo pInfo = this.getPageInfo(currentPage, boardWriter, totalCount); 
			// 페이지 정보(현재 페이지(보여지는 페이지), 작성자, 게시글 총 갯수)
			System.out.println(pInfo.toString());
			List<Board> bList = service.selectBoardList(pInfo);
			if(!bList.isEmpty()) {
				model.addAttribute("pInfo", pInfo);
				model.addAttribute("bList", bList);
				return "board/list";
			}else {
				model.addAttribute("title", "문의내역 조회 실패");
				model.addAttribute("msg", "데이터를 찾을 수 없습니다.");
				model.addAttribute("url", "member/myPage.do?memberId="+boardWriter);
				model.addAttribute("btnMsg", "이전으로 이동");
				return "common/serviceResultOneBtn";
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
		int recordnaiCountPage = 5;	// 한 페이지에 보여줄 게시물(전체 게시물의 값이 필요)
		int naviCountPerPage = 5;	// 한 페이지에 보여줄 페이지의 개수(currentPage의 값이 필요)
		int naviTotalCount;		// 범위의 총 갯수(currentPage의 값이 필요)
		int startNavi;
		int endNavi;
		
		// (int) 강제 형변환, (double) 자동 형변환
		// 네비게이터의 총 갯수 = 총 게시물 / 한 페이지당 보여지는 게시물 + 0.9
		naviTotalCount = (int)((double)totalCount/recordnaiCountPage+0.9);
													// +0.9하면 알아서 반올림
		// currentPage값이 1~5일 때 startNavi가 1로 고정되도록 구해주는 식
		startNavi = ((int)((double)currentPage/naviCountPerPage+0.9)-1)*naviCountPerPage + 1;
		endNavi = startNavi + naviCountPerPage -1;
		// endNavi는 startNavi에 무조건 naviCountPerPage값을 더하므로 실제 최대값보다 커질 수 있음
		if(endNavi > naviTotalCount) {
			endNavi = naviTotalCount;
		}
		pi = new PageInfo(currentPage, boardWriter, recordnaiCountPage, naviCountPerPage, startNavi, endNavi, totalCount, naviTotalCount);
		return pi;
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
 * 7. 1:1 문의 내역
 * 8. 1:1 문의 상세보기
 * 9. 1:1 문의 작성
 * 10. 1:1 문의 삭제
 * 
 */
