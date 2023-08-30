package kr.co.baskinrobbins.product.controller;

import java.text.SimpleDateFormat;
import java.io.File;
import java.io.IOException;
import java.lang.System;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.co.baskinrobbins.member.domain.BRSystem;
import kr.co.baskinrobbins.product.domain.IceCream;
import kr.co.baskinrobbins.product.domain.PageInfo;
import kr.co.baskinrobbins.product.domain.Product;
import kr.co.baskinrobbins.product.service.ProductService;

@Controller
@RequestMapping(value="/product")
public class ProductController {
	
	@Autowired
	private ProductService pService;
	
	/**
	 * 입력할 메뉴 선택하는 페이지
	 * 이동하면 메뉴 / 아이스크림 상세 입력 페이지로 이동할 수 있음
	 * 시스템 계정만 접근 가능하다.
	 * @param mv
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/selectInsert.do", method = RequestMethod.GET)
	public ModelAndView showSelectInsert (
			ModelAndView mv
			, HttpSession session) {
		String memberId = (String)session.getAttribute("memberId");
		BRSystem member = pService.selectOneById(memberId);
		if(member != null){
			mv.setViewName("/product/selectInsert");
		}else {
			mv.addObject("title", "잘못된 접근").addObject("msg", "잘못된 접근입니다.");
			mv.addObject("url", "redirect:/index.jsp").addObject("btnMsg", "메인으로 이동");
			mv.setViewName("common/serviceResultOneBtn");
		}
		return mv;
	}
	
	@RequestMapping(value="/menu.do", method = RequestMethod.GET)
	public ModelAndView showProductMenu (
			ModelAndView mv
			, @RequestParam(value="page", required = false, defaultValue = "1") Integer currentPage
			, @ModelAttribute Product product) {
		// totalCount는 아이스크림 테이블이 아니라 메뉴 테이블에서 구해옴
		// 메뉴 테이블에서 WHERE 조건에 입력할 데이터
		String menuType = product.getMenuType();
		// menuType과 일치하는 값의 총 갯수
		int totalCount = pService.selectTypeCount(menuType);
		PageInfo pInfo = this.getPageInfo(currentPage, menuType, totalCount);
		System.out.println(totalCount);
		List<Product> pList = pService.selectIceList(pInfo);
		System.out.println(pList.toString());
		mv.addObject("iceList", pList).addObject("pInfo", pInfo).setViewName("product/"+menuType);
		return mv;
	}
	/**
	 * 관리자 계정으로 상품 등록하기
	 * 관리자 계정으로 접속했을 때만 접속 가능함
	 * @return
	 */
	@RequestMapping(value="/insertIceCream.do", method = RequestMethod.GET)
	public ModelAndView showIceCreamInsert(
			ModelAndView mv
			, HttpSession session
			) {
		String memberId = (String)session.getAttribute("memberId");
		BRSystem member = pService.selectOneById(memberId);
		if(member != null){
			mv.setViewName("/product/insertIceCream");
		}else {
			mv.addObject("title", "잘못된 접근").addObject("msg", "잘못된 접근입니다.");
			mv.addObject("url", "redirect:/index.jsp").addObject("btnMsg", "메인으로 이동");
			mv.setViewName("common/serviceResultOneBtn");
		}
		return mv;
	}
	
	@RequestMapping(value="/insertIceCream.do", method = RequestMethod.POST)
	public ModelAndView IceCreamInsert(ModelAndView mv
			, @RequestParam(value="uploadFile", required = false) MultipartFile uploadFile
			, @ModelAttribute IceCream iceCream
			, HttpServletRequest request) {
		try {
			if(uploadFile != null && !uploadFile.getOriginalFilename().equals("")) {
				Map<String, Object> pMap = this.saveFile(request, uploadFile);
				iceCream.setIceImgName((String)pMap.get("fileName"));
				iceCream.setIceImgRename((String)pMap.get("fileRename"));
				iceCream.setIceImgPath((String)pMap.get("filePath"));
				iceCream.setIceImgLength((long)pMap.get("fileLength"));
			}
			int result = pService.insertIceCream(iceCream);
			if(result > 0) {
				mv.setViewName("/product/iceCream");
			} else {
				mv.addObject("title", "상품 입력 실패").addObject("msg", "상품 입력이 성공하지 않았습니다.");
				mv.addObject("url", "/product/insert.do").addObject("btnMsg", "이전으로 이동");
				mv.setViewName("common/serviceResultOneBtn");
			}
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("title", "상품 입력 실패").addObject("msg", "관리자에게 문의하시기 바랍니다."+e.getMessage());
			mv.addObject("url", "/product/insert.do").addObject("btnMsg", "이전으로 이동");
			mv.setViewName("common/serviceResultOneBtn");
		}
		return mv;
	}
	/**
	 * 관리자 계정으로 상품 등록하기
	 * 관리자 계정으로 접속했을 때만 접속 가능함
	 * @return
	 */
	@RequestMapping(value="/insertProduct.do", method = RequestMethod.GET)
	public ModelAndView showProductInsert(
			ModelAndView mv
			, HttpSession session
			) {
		String memberId = (String)session.getAttribute("memberId");
		BRSystem member = pService.selectOneById(memberId);
		if(member != null){
			mv.setViewName("/product/insertProduct");
		}else {
			mv.addObject("title", "잘못된 접근").addObject("msg", "잘못된 접근입니다.");
			mv.addObject("url", "redirect:/index.jsp").addObject("btnMsg", "메인으로 이동");
			mv.setViewName("common/serviceResultOneBtn");
		}
		return mv;
	}
	
	@RequestMapping(value="/insertProduct.do", method = RequestMethod.POST)
	public ModelAndView ProductInsert(ModelAndView mv
			, @RequestParam(value="uploadFile", required = false) MultipartFile uploadFile
			, @ModelAttribute Product product
			, HttpServletRequest request) {
		try {
			if(uploadFile != null && !uploadFile.getOriginalFilename().equals("")) {
				Map<String, Object> pMap = this.saveFile(request, uploadFile);
				product.setMenuImgName((String)pMap.get("fileName"));
				product.setMenuImgRename((String)pMap.get("fileRename"));
				product.setMenuImgPath((String)pMap.get("filePath"));
				product.setMenuImgLength((long)pMap.get("fileLength"));
			}
			String category = product.getMenuType();
			int result = 0; 
//					pService.insertProduct(product);
			if(result > 0) {
				mv.setViewName("/product/"+category);
			} else {
				mv.addObject("title", "상품 입력 실패").addObject("msg", "상품 입력이 성공하지 않았습니다.");
				mv.addObject("url", "/product/insert.do").addObject("btnMsg", "이전으로 이동");
				mv.setViewName("common/serviceResultOneBtn");
			}
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("title", "상품 입력 실패").addObject("msg", "관리자에게 문의하시기 바랍니다."+e.getMessage());
			mv.addObject("url", "/product/insert.do").addObject("btnMsg", "이전으로 이동");
			mv.setViewName("common/serviceResultOneBtn");
		}
		return mv;
	}
	
	/**
	 * 파일 업로드를 위한 메소드
	 * 1. resources의 경로 구하기 -> HttpServletRequest 이용
	 * 2. 파일 저장 경로 구하기 -> resources에서 구한 경로 통해
	 * 3. 파일 이름 구하기
	 * 4. 파일 확장자 구하기(확장자 상관 없이 업로드 받기 위해)
	 * 5. 파일 시간으로 리네임하기(실제 저장되는 파일 이름)
	 * 6. 파일을 저장하는 폴더 만들기(없으면 만들어지도록)
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	private Map<String, Object> saveFile(HttpServletRequest request, MultipartFile uploadFile) throws IllegalStateException, IOException {
		Map<String, Object> fileMap = new HashMap<String, Object>();
		// resources의 경로
		String root = request.getSession().getServletContext().getRealPath("resources");
		// 파일 저장 경로
		String savePath = root + "\\productImgFiles";
		// 파일 이름 구하기
		String fileName = uploadFile.getOriginalFilename();
		// 파일 확장자명 구하기(구해온 파일 이름의 마지막부터 .까지 제외(+1)하고 자른다.)
		String extension = fileName.substring(fileName.lastIndexOf(".")+1);
		// 파일 시간으로 리네임
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String fileRename = "P" + sdf.format(new Date(System.currentTimeMillis()))+"."+extension;
		// 파일 저장 전 폴더 만들기
		File saveFolder = new File(savePath);
		if(!saveFolder.exists()) {
			saveFolder.mkdir();
		}
		File saveFile = new File(savePath + "\\" + fileRename);
		// 실제 저장(예외처리 발생)
		uploadFile.transferTo(saveFile);
		long fileLength = uploadFile.getSize();
		// 파일 정보 리턴
		fileMap.put("fileName", fileName);
		fileMap.put("fileRename", fileRename);
		fileMap.put("filePath", "../resources/productImgFiles/"+fileRename);
		fileMap.put("fileLength", fileLength);
		return fileMap;
	}
	
	/**
	 * 파일 삭제를 위한 메소드
	 */
	
	
	/**
	 * 페이지 info
	 * @param totalCount 
	 * @param menuType 
	 * @param currentPage 
	 */
	private PageInfo getPageInfo(Integer currentPage, String menuType, int totalCount) {
		PageInfo pi = null;
		int recordnaviCountPage = 20;
		int naviCountPerPage = 5;
		int naviTotalCount;
		int startNavi;
		int endNavi;
		
		naviTotalCount = (int)((double)totalCount/recordnaviCountPage + 0.9);
		
		startNavi = ((int)((double)currentPage/naviCountPerPage + 0.9)-1)*naviCountPerPage + 1;
		endNavi = startNavi + naviCountPerPage -1;
		if(endNavi > naviTotalCount) {
			endNavi = naviTotalCount;
		}
		pi = new PageInfo(currentPage, menuType, recordnaviCountPage, naviCountPerPage, startNavi, endNavi, totalCount, naviTotalCount);
		return pi;
	}

}
