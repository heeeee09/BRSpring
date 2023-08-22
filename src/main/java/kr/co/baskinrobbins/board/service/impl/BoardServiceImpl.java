package kr.co.baskinrobbins.board.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.baskinrobbins.board.domain.Board;
import kr.co.baskinrobbins.board.domain.PageInfo;
import kr.co.baskinrobbins.board.service.BoardService;
import kr.co.baskinrobbins.board.store.BoardStore;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardStore bStore;
	@Autowired
	private SqlSession session;
	
	@Override
	public int getBoardListCount(String boardWriter) {
		int result = bStore.selectBoardListCount(session, boardWriter);
		return result;
	}

	@Override
	public List<Board> selectBoardList(PageInfo pInfo) {
		List<Board> bList = bStore.selectBoardList(session, pInfo);
		return bList;
	}

	@Override
	public int insertBoard(Board board) {
		int result = bStore.insertBoard(session, board);
		return result;
	}

	@Override
	public int deleteBoard(int boardNo) {
		int result = bStore.deleteBoard(session, boardNo);
		return result;
	}

	@Override
	public Board selectBoardDetail(int boardNo) {
		Board result = bStore.selectBoardDetail(session, boardNo);
		return result;
	}

}
