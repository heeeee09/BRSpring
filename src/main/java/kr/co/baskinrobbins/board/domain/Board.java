package kr.co.baskinrobbins.board.domain;

public class Board {
	private int boardNo;
	private String boardSubject;
	private String boardContent;
	private String boardDate;
	private String boardUpdate;
	private String boardWriter;
	private String boardFileName;
	private String boardFileRename;
	private String boardFilePath;
	private long boardFileLength;
	
	public Board() {
	}

	public Board(int boardNo, String boardWriter) {
		super();
		this.boardNo = boardNo;
		this.boardWriter = boardWriter;
	}

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
	public String getBoardUpdate() {
		return boardUpdate;
	}
	public void setBoardUpdate(String boardUpdate) {
		this.boardUpdate = boardUpdate;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	
	public String getBoardFileName() {
		return boardFileName;
	}
	public void setBoardFileName(String boardFileName) {
		this.boardFileName = boardFileName;
	}
	public String getBoardFileRename() {
		return boardFileRename;
	}
	public void setBoardFileRename(String boardFileRename) {
		this.boardFileRename = boardFileRename;
	}
	public String getBoardFilePath() {
		return boardFilePath;
	}
	public void setBoardFilePath(String boardFilePath) {
		this.boardFilePath = boardFilePath;
	}
	public long getBoardFileLength() {
		return boardFileLength;
	}
	public void setBoardFileLength(long boardFileLength) {
		this.boardFileLength = boardFileLength;
	}
	
	@Override
	public String toString() {
		return "문의사항 [문의사항 번호=" + boardNo + ", 문의사항 제목=" + boardSubject + ", 문의사항 내용=" + boardContent
				+ ", 작성일=" + boardDate + ", 수정일="+boardUpdate + ", 아이디=" + boardWriter + ", 파일이름=" + boardFileName + ", 파일리네임=" + boardFileRename
				+ ", 파일경로=" + boardFilePath + ", 파일크기="+ boardFileLength +"]";
	}
	
	
	
	

}
