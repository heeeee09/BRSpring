package kr.co.baskinrobbins.product.store;

import org.apache.ibatis.session.SqlSession;

import kr.co.baskinrobbins.member.domain.Member;
import kr.co.baskinrobbins.member.domain.System;

public interface ProductStore {

	/**
	 * 상품 등록을 위한 아이디 체크(관리자 계정인지)
	 * @param session 
	 * @param memberId
	 * @return
	 */
	System selectOneById(SqlSession session, String memberId);

}
