package kr.co.baskinrobbins.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IceCreamController {
	
	@RequestMapping(value="/product/iceCream/31Yogurt.do", method = RequestMethod.GET)
	public ModelAndView show31Yogurt(ModelAndView mv) {
		mv.setViewName("product/icecream/31Yogurt");
		return mv;
	}

	@RequestMapping(value="/product/iceCream/greentea.do", method = RequestMethod.GET)
	public ModelAndView showGreentea(ModelAndView mv) {
		mv.setViewName("product/icecream/greentea");
		return mv;
	}
}
