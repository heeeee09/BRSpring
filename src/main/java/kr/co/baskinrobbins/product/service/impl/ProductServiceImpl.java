package kr.co.baskinrobbins.product.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.baskinrobbins.member.domain.System;
import kr.co.baskinrobbins.product.service.ProductService;
import kr.co.baskinrobbins.product.store.ProductStore;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private SqlSession session;
	@Autowired
	private ProductStore pStore;
	@Override
	public System selectOneById(String memberId) {
		System mOne = pStore.selectOneById(session, memberId);
		return mOne;
	}

}
