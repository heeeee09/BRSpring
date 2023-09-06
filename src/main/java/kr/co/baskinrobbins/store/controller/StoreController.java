package kr.co.baskinrobbins.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.baskinrobbins.store.domain.Store;
import kr.co.baskinrobbins.store.service.StoreService;

@Controller
@RequestMapping(value="/store")
public class StoreController {

	@Autowired 
	private StoreService sService;
	
    @RequestMapping(value="/search.do", method = RequestMethod.GET)
    public ModelAndView showStore(ModelAndView mv) {
        List<Store> sList = sService.allStoreList();
        if(sList.size() > 0) {
        	mv.addObject("sList", sList);
        	mv.setViewName("/store/search");
        }
        return mv;
    }
	
}
