package kr.co.baskinrobbins.board.service;

import java.util.List;

import kr.co.baskinrobbins.board.domain.Board;
import kr.co.baskinrobbins.board.domain.PageInfo;

public interface BoardService {

	/**
	 * 문의사항 게시글 총 갯수
	 * @param boardWriter 
	 * @return
	 */
	int getBoardListCount(String boardWriter);
	
	/**
	 * 문의사항 페이지에서 표시될 게시글 리스트
	 * @param pInfo
	 * @return
	 */
	List<Board> selectBoardList(PageInfo pInfo);

	/**
	 * 문의사항 작성
	 * @param board
	 * @return
	 */
	int insertBoard(Board board);

	/**
	 * 문의사항 삭제
	 * @param boardNo
	 * @return
	 */
	int deleteBoard(int boardNo);

	/**
	 * 문의사항 상세 조회(내가 쓴 게시글 확인)
	 * @param boardNo
	 * @return
	 */
	Board selectBoardDetail(int boardNo);

	/**
	 * 문의사항 상세 조회(세션 아이디, 글 번호)
	 * @param bPost
	 * @return
	 */
	Board selectBoardDetail(Board board);

}
