package kr.co.baskinrobbins.product.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.baskinrobbins.member.domain.System;
import kr.co.baskinrobbins.product.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService pService;
	
	@RequestMapping(value="/product/iceCream.do", method = RequestMethod.GET)
	public ModelAndView showIcecreamMenu (
			ModelAndView mv) {
		mv.setViewName("/product/menu_iceCream");
		return mv;
	}
	
	/**
	 * 관리자 계정으로 상품 등록하기
	 * 관리자 계정으로 접속했을 때만 접속 가능함
	 * @return
	 */
	@RequestMapping(value="/product/insert.do", method = RequestMethod.GET)
	public ModelAndView showProductInsert(
			ModelAndView mv
			, HttpSession session
			) {
		String memberId = (String)session.getAttribute("memberId");
		System member = pService.selectOneById(memberId);
		if(member != null){
			mv.setViewName("/product/insert");
		}else {
			mv.addObject("title", "잘못된 접근").addObject("msg", "잘못된 접근입니다.");
			mv.addObject("url", "redirect:/index.jsp").addObject("btnMsg", "메인으로 이동");
			mv.setViewName("common/serviceResultOneBtn");
			
		}
		return mv;
	}

}
