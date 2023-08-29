package kr.co.baskinrobbins.product.store;

import org.apache.ibatis.session.SqlSession;

import kr.co.baskinrobbins.member.domain.Member;
import kr.co.baskinrobbins.product.domain.IceCream;
import kr.co.baskinrobbins.member.domain.BRSystem;

public interface ProductStore {

	/**
	 * 상품 등록을 위한 아이디 체크(관리자 계정인지)
	 * @param session 
	 * @param memberId
	 * @return
	 */
	BRSystem selectOneById(SqlSession session, String memberId);

	/**
	 * 아이스크림 메뉴 등록
	 * @param session
	 * @param iceCream
	 * @return
	 */
	int insertIceCream(SqlSession session, IceCream iceCream);

}
