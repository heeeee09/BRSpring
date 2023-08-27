package kr.co.baskinrobbins.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
	
	@RequestMapping(value="/product/iceCream.do", method = RequestMethod.GET)
	public ModelAndView showIcecreamMenu (
			ModelAndView mv) {
		mv.setViewName("/product/menu_iceCream");
		return mv;
	}

}
