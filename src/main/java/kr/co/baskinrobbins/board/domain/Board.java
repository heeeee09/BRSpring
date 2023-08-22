package kr.co.baskinrobbins.board.domain;

public class Board {
	private int boardNo;
	private String boardSubject;
	private String boardContent;
	private String boardDate;
	private String boardWriter;
	private String boardWriterName;
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardSubject() {
		return boardSubject;
	}
	public void setBoardSubject(String boardSubject) {
		this.boardSubject = boardSubject;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public String getBoardWriterName() {
		return boardWriterName;
	}
	public void setBoardWriterName(String boardWriterName) {
		this.boardWriterName = boardWriterName;
	}
	@Override
	public String toString() {
		return "문의사항 [문의사항 번호=" + boardNo + ", 문의사항 제목=" + boardSubject + ", 문의사항 내용=" + boardContent
				+ ", 작성일=" + boardDate + ", 아이디=" + boardWriter + ", 이름="+boardWriterName + "]";
	}
	
	

}
