package kr.co.baskinrobbins.board.service;

import java.util.List;

import kr.co.baskinrobbins.board.domain.Board;
import kr.co.baskinrobbins.board.domain.PageInfo;

public interface BoardService {

	/**
	 * 문의사항 게시글 총 갯수
	 * @return
	 */
	int getBoardListCount();
	
	/**
	 * 문의사항 페이지에서 표시될 게시글 리스트
	 * @param pInfo
	 * @return
	 */
	List<Board> selectBoardList(PageInfo pInfo);

}
