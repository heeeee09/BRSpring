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
        
        // Jackson ObjectMapper 객체 생성
        ObjectMapper storeMapper = new ObjectMapper();

        try {
            // Store 객체 목록을 JSON 문자열로 변환
            String jSList = storeMapper.writeValueAsString(sList);

            // 이제 jsonStoreList에는 Store 객체 목록의 JSON 표현이 포함됩니다.
            // 이 JSON 데이터를 원하는 방식으로 사용할 수 있습니다.
            if(sList.size() > 0) {
            	for(Store store : sList) {
//            		mv.addObject("title", store.getStoreName());
//            		mv.addObject("address", store.getStoreAddress());
//            		mv.addObject("lat", store.getStoreLat());
//            		mv.addObject("lng", store.getStoreLng());
            		mv.addObject("jSList", jSList);
            	}
            	mv.setViewName("/store/search");
            }
        } catch (Exception e) {
            // 예외 처리 로직 추가
        }
        return mv;
    }
}
