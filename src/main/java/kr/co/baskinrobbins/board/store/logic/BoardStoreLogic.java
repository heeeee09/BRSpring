package kr.co.baskinrobbins.board.store.logic;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.baskinrobbins.board.domain.Board;
import kr.co.baskinrobbins.board.domain.PageInfo;
import kr.co.baskinrobbins.board.store.BoardStore;

@Repository
public class BoardStoreLogic implements BoardStore{

	@Override
	public int selectBoardListCount(SqlSession session) {
		int result = session.selectOne("BoardMapper.selectBoardListCount");
		return result;
	}

	@Override
	public List<Board> selectBoardList(SqlSession session, PageInfo pInfo) {
		String boardWriter = pInfo.getBoardWriter();
		int limit = pInfo.getRecordnaiCountPage();
		int offset = (pInfo.getCurrentPage()-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Board> bList = session.selectList("BoardMapper.selectBoardList", boardWriter, rowBounds);
		return bList;
	}
	

}
