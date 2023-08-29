package kr.co.baskinrobbins.product.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.baskinrobbins.member.domain.BRSystem;
import kr.co.baskinrobbins.product.domain.IceCream;
import kr.co.baskinrobbins.product.store.ProductStore;

@Repository
public class ProductStoreLogic implements ProductStore{

	@Override
	public BRSystem selectOneById(SqlSession session, String memberId) {
		BRSystem mOne = session.selectOne("BRSystemMapper.selectSystemId", memberId);
		return mOne;
	}

	@Override
	public int insertIceCream(SqlSession session, IceCream iceCream) {
		int result = session.insert("iceCreamMapper.insertIceCream", iceCream);
		return result;
	}

}
