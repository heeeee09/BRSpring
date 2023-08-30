package kr.co.baskinrobbins.product.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.baskinrobbins.member.domain.Member;
import kr.co.baskinrobbins.product.domain.IceCream;
import kr.co.baskinrobbins.product.domain.PageInfo;
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

	/**
	 * 아이스크림 메뉴 리스트로 가져오기
	 * @param session
	 * @param pInfo 
	 * @return
	 */
	List<IceCream> selectIceList(SqlSession session, PageInfo pInfo);

	/**
	 * 메뉴 타입별로 총 갯수 구하기
	 * @param session
	 * @param menuType
	 * @return
	 */
	int selectTypeCount(SqlSession session, String menuType);

}
