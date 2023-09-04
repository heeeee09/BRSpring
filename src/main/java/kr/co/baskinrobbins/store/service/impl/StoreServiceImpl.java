package kr.co.baskinrobbins.store.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.baskinrobbins.store.domain.Store;
import kr.co.baskinrobbins.store.service.StoreService;
import kr.co.baskinrobbins.store.store.StoreStore;

@Service
public class StoreServiceImpl implements StoreService{
	
	@Autowired
	private SqlSession session;
	@Autowired
	private StoreStore sStore;
	
	@Override
	public List<Store> allStoreList() {
		List<Store> sList = sStore.allStoreList(session);
		return sList;
	}

}
