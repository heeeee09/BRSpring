package kr.co.baskinrobbins.product.store.logic;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.baskinrobbins.member.domain.BRSystem;
import kr.co.baskinrobbins.product.domain.IceCream;
import kr.co.baskinrobbins.product.domain.PageInfo;
import kr.co.baskinrobbins.product.domain.Product;
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
		int result = session.insert("IceCreamMapper.insertIceCream", iceCream);
		return result;
	}

	@Override
	public int selectTypeCount(SqlSession session, String menuType) {
		int result = session.selectOne("ProductMapper.selectTypeCount", menuType);
		return result;
	}

	@Override
	public List<Product> selectIceList(SqlSession session, PageInfo pInfo) {
		String menuType = pInfo.getmenuType();
		int limit = pInfo.getrecordnaviCountPage();
		int offset = (pInfo.getCurrentPage()-1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Product> pList = session.selectList("ProductMapper.selectIceList", menuType, rowBounds);
		return pList;
	}

	@Override
	public int insertProduct(SqlSession session, Product product) {
		int result = session.insert("ProductMapper.insertProduct", product);
		return result;
	}

}
