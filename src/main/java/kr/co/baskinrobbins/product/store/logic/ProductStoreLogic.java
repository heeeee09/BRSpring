package kr.co.baskinrobbins.product.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.baskinrobbins.member.domain.System;
import kr.co.baskinrobbins.product.store.ProductStore;

@Repository
public class ProductStoreLogic implements ProductStore{

	@Override
	public System selectOneById(SqlSession session, String memberId) {
		System mOne = session.selectOne("SystemMapper.selectSystemId", memberId);
		return mOne;
	}

}
