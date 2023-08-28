package kr.co.baskinrobbins.product.service;

import kr.co.baskinrobbins.member.domain.Member;
import kr.co.baskinrobbins.member.domain.System;

public interface ProductService {

	/**
	 * 상품 등록을 위한 아이디 체크(관리자 계정인지)
	 * @param memberId
	 * @return
	 */
	System selectOneById(String memberId);

}
