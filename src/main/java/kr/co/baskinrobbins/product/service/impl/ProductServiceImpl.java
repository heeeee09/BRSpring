package kr.co.baskinrobbins.product.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.baskinrobbins.member.domain.BRSystem;
import kr.co.baskinrobbins.product.domain.IceCream;
import kr.co.baskinrobbins.product.domain.PageInfo;
import kr.co.baskinrobbins.product.service.ProductService;
import kr.co.baskinrobbins.product.store.ProductStore;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private SqlSession session;
	@Autowired
	private ProductStore pStore;
	@Override
	public BRSystem selectOneById(String memberId) {
		BRSystem mOne = pStore.selectOneById(session, memberId);
		return mOne;
	}
	@Override
	public int insertIceCream(IceCream iceCream) {
		int result = pStore.insertIceCream(session, iceCream);
		return result;
	}
	
	@Override
	public int selectTypeCount(String menuType) {
		int result = pStore.selectTypeCount(session, menuType);
		return 0;
	}
	@Override
	public List<IceCream> selectIceList(PageInfo pInfo) {
		List<IceCream> iceList = pStore.selectIceList(session, pInfo);
		return iceList;
	}

}
