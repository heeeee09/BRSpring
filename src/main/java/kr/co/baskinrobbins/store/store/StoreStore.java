package kr.co.baskinrobbins.store.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.baskinrobbins.store.domain.Store;

public interface StoreStore {

	List<Store> allStoreList(SqlSession session);

}
