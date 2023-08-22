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
	public int selectBoardListCount(SqlSession session, String boardWriter) {
		int result = session.selectOne("BoardMapper.selectBoardListCount", boardWriter);
		return result;
	}

	@Override
	public List<Board> selectBoardList(SqlSession session, PageInfo pInfo) {
		String boardWriter = pInfo.getBoardWriter();
		int limit = pInfo.getrecordnaviCountPage();
		int offset = (pInfo.getCurrentPage()-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Board> bList = session.selectList("BoardMapper.selectBoardList", boardWriter, rowBounds);
		return bList;
	}

	@Override
	public int insertBoard(SqlSession session, Board board) {
		int result = session.insert("BoardMapper.insertBoard", board);
		return result;
	}

	@Override
	public int deleteBoard(SqlSession session, int boardNo) {
		int result = session.delete("BoardMapper.deleteBoard", boardNo);
		return result;
	}

	@Override
	public Board selectBoardDetail(SqlSession session, int boardNo) {
		Board result = session.selectOne("BoardMapper.selectBoardDetail", boardNo);
		return result;
	}

	

}
