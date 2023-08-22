package kr.co.baskinrobbins.board.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.baskinrobbins.board.domain.Board;
import kr.co.baskinrobbins.board.domain.PageInfo;

public interface BoardStore {

	/**
	 * 문의사항 게시글 총 갯수
	 * @param session
	 * @return
	 */
	int selectBoardListCount(SqlSession session);

	/**
	 * 문의사항 페이지에서 표시될 게시글 리스트
	 * @param session
	 * @param pInfo
	 * @return
	 */
	List<Board> selectBoardList(SqlSession session, PageInfo pInfo);

}
