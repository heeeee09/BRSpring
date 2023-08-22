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
	public int getBoardListCount() {
		int result = bStore.selectBoardListCount(session);
		return result;
	}

	@Override
	public List<Board> selectBoardList(PageInfo pInfo) {
		List<Board> bList = bStore.selectBoardList(session, pInfo);
		return bList;
	}

}
