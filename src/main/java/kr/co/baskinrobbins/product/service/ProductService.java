package kr.co.baskinrobbins.product.service;

import java.util.List;

import kr.co.baskinrobbins.member.domain.BRSystem;
import kr.co.baskinrobbins.product.domain.IceCream;
import kr.co.baskinrobbins.product.domain.PageInfo;
import kr.co.baskinrobbins.product.domain.Product;

public interface ProductService {

	/**
	 * 상품 등록을 위한 아이디 체크(관리자 계정인지)
	 * @param memberId
	 * @return
	 */
	BRSystem selectOneById(String memberId);

	/**
	 * 아이스크림 메뉴 등록
	 * @param iceCream
	 * @return
	 */
	int insertIceCream(IceCream iceCream);

	/**
	 * 메뉴 리스트 가져오기
	 * @param pInfo 
	 * @return
	 */
	List<Product> selectIceList(PageInfo pInfo);

	/**
	 * 아이스크림 메뉴 타입별로 갯수 가져오기
	 * @param menuType
	 * @return
	 */
	int selectTypeCount(String menuType);

	/**
	 * 메뉴 입력
	 * @param product
	 * @return
	 */
	int insertProduct(Product product);

}
