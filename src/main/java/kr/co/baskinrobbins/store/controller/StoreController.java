package kr.co.baskinrobbins.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

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
        // jackson objectMapper 객체 생성(jackson 라이브러리 추가함)
        ObjectMapper objectMapper = new ObjectMapper();

        
        
        if(sList.size() > 0) {
        	for(Store store : sList) {
        		mv.addObject("title", store.getStoreName());
        		mv.addObject("address", store.getStoreAddress());
        		mv.addObject("lat", store.getStoreLat());
        		mv.addObject("lng", store.getStoreLng());
        		mv.addObject("size", sList.size());
        	}
        	mv.setViewName("/store/search");
        }
        return mv;
    }
	
}
