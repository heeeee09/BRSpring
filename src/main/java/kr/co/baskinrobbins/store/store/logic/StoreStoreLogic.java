package kr.co.baskinrobbins.store.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.baskinrobbins.store.domain.Store;
import kr.co.baskinrobbins.store.store.StoreStore;

@Repository
public class StoreStoreLogic implements StoreStore{

	@Override
	public List<Store> allStoreList(SqlSession session) {
		List<Store> sList = session.selectList("StoreMapper.allStoreList");
		return sList;
	}

}
