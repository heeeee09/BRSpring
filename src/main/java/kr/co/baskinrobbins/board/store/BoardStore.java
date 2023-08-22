package kr.co.baskinrobbins.board.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.baskinrobbins.board.domain.Board;
import kr.co.baskinrobbins.board.domain.PageInfo;

public interface BoardStore {

	/**
	 * 문의사항 게시글 총 갯수
	 * @param session
	 * @param boardWriter 
	 * @return
	 */
	int selectBoardListCount(SqlSession session, String boardWriter);

	/**
	 * 문의사항 페이지에서 표시될 게시글 리스트
	 * @param session
	 * @param pInfo
	 * @return
	 */
	List<Board> selectBoardList(SqlSession session, PageInfo pInfo);

	/**
	 * 문의사항 작성
	 * @param session
	 * @param board
	 * @return
	 */
	int insertBoard(SqlSession session, Board board);

	/**
	 * 문의사항 삭제
	 * @param session
	 * @param boardNo
	 * @return
	 */
	int deleteBoard(SqlSession session, int boardNo);

	/**
	 * 문의사항 상세 조회(내가 쓴 게시글 확인)
	 * @param session
	 * @param boardNo
	 * @return
	 */
	Board selectBoardDetail(SqlSession session, int boardNo);

}
