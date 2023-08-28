package kr.co.baskinrobbins.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/product/iceCream")
public class IceCreamController {
	
	@RequestMapping(value="/31Yogurt.do", method = RequestMethod.GET)
	public ModelAndView show31Yogurt(ModelAndView mv) {
		mv.setViewName("product/icecream/31Yogurt");
		return mv;
	}

	@RequestMapping(value="/product/iceCream/greentea.do", method = RequestMethod.GET)
	public ModelAndView showGreentea(ModelAndView mv) {
		mv.setViewName("product/icecream/greentea");
		return mv;
	}
	@RequestMapping(value="/newYorkCheeseCake.do", method = RequestMethod.GET)
	public ModelAndView showNewYorkCheeseCake(ModelAndView mv) {
		mv.setViewName("product/icecream/newYorkCheeseCake");
		return mv;
	}
	@RequestMapping(value="/dinoJelly.do", method = RequestMethod.GET)
	public ModelAndView showDinoJelly(ModelAndView mv) {
		mv.setViewName("product/icecream/dinoJelly");
		return mv;
	}
	@RequestMapping(value="/ryanMangoMacaron.do", method = RequestMethod.GET)
	public ModelAndView showRyanMangoMacaron(ModelAndView mv) {
		mv.setViewName("product/icecream/ryanMangoMacaron");
		return mv;
	}
	@RequestMapping(value="/rainbowSherbet.do", method = RequestMethod.GET)
	public ModelAndView showRainbowSherbet(ModelAndView mv) {
		mv.setViewName("product/icecream/rainbowSherbet");
		return mv;
	}
	@RequestMapping(value="/mintChocolateChip.do", method = RequestMethod.GET)
	public ModelAndView showMintChocolateChip(ModelAndView mv) {
		mv.setViewName("product/icecream/mintChocolateChip");
		return mv;
	}
	@RequestMapping(value="/vanilla.do", method = RequestMethod.GET)
	public ModelAndView showVanilla(ModelAndView mv) {
		mv.setViewName("product/icecream/vanilla");
		return mv;
	}
	@RequestMapping(value="/twinBerryCheeseCake.do", method = RequestMethod.GET)
	public ModelAndView showTwinBerryCheeseCake(ModelAndView mv) {
		mv.setViewName("product/icecream/twinBerryCheeseCake");
		return mv;
	}
	@RequestMapping(value="/verryVerryStrawberry.do", method = RequestMethod.GET)
	public ModelAndView showVerryVerryStrawberry(ModelAndView mv) {
		mv.setViewName("product/icecream/verryVerryStrawberry");
		return mv;
	}
	@RequestMapping(value="/redRasberrySorbet.do", method = RequestMethod.GET)
	public ModelAndView showRedRasberrySorbet(ModelAndView mv) {
		mv.setViewName("product/icecream/redRasberrySorbet");
		return mv;
	}
	@RequestMapping(value="/blackSorbet.do", method = RequestMethod.GET)
	public ModelAndView showBlackSorbet(ModelAndView mv) {
		mv.setViewName("product/icecream/blackSorbet");
		return mv;
	}
	@RequestMapping(value="/loveStruckStrawberry.do", method = RequestMethod.GET)
	public ModelAndView showLoveStruckStrawberry(ModelAndView mv) {
		mv.setViewName("product/icecream/loveStruckStrawberry");
		return mv;
	}
	@RequestMapping(value="/fritzCoffeeIceCream.do", method = RequestMethod.GET)
	public ModelAndView showFritzCoffeeIceCream(ModelAndView mv) {
		mv.setViewName("product/icecream/fritzCoffeeIceCream");
		return mv;
	}
//	@RequestMapping(value="/rainbowSherbet.do", method = RequestMethod.GET)
//	public ModelAndView showRainbowSherbet(ModelAndView mv) {
//		mv.setViewName("product/icecream/rainbowSherbet");
//		return mv;
//	}
//	@RequestMapping(value="/rainbowSherbet.do", method = RequestMethod.GET)
//	public ModelAndView showRainbowSherbet(ModelAndView mv) {
//		mv.setViewName("product/icecream/rainbowSherbet");
//		return mv;
//	}
	
}
