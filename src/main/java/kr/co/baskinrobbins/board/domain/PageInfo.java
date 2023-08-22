package kr.co.baskinrobbins.board.domain;

public class PageInfo {
	private int currentPage;
	private String boardWriter;
	private int recordnaiCountPage;
	private int naviCountPerPage;
	private int startNavi;
	private int endNavi;
	private int totalCount;
	private int naviTotalCount;
	
	public PageInfo() {
		// TODO Auto-generated constructor stub
	}

	public PageInfo(int currentPage, String boardWriter, int recordnaiCountPage, int naviCountPerPage, int startNavi,
			int endNavi, int totalCount, int naviTotalCount) {
		super();
		this.currentPage = currentPage;
		this.boardWriter = boardWriter;
		this.recordnaiCountPage = recordnaiCountPage;
		this.naviCountPerPage = naviCountPerPage;
		this.startNavi = startNavi;
		this.endNavi = endNavi;
		this.totalCount = totalCount;
		this.naviTotalCount = naviTotalCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public int getRecordnaiCountPage() {
		return recordnaiCountPage;
	}
	public void setRecordnaiCountPage(int recordnaiCountPage) {
		this.recordnaiCountPage = recordnaiCountPage;
	}
	public int getNaviCountPerPage() {
		return naviCountPerPage;
	}
	public void setNaviCountPerPage(int naviCountPerPage) {
		this.naviCountPerPage = naviCountPerPage;
	}
	public int getStartNavi() {
		return startNavi;
	}
	public void setStartNavi(int startNavi) {
		this.startNavi = startNavi;
	}
	public int getEndNavi() {
		return endNavi;
	}
	public void setEndNavi(int endNavi) {
		this.endNavi = endNavi;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getNaviTotalCount() {
		return naviTotalCount;
	}
	public void setNaviTotalCount(int naviTotalCount) {
		this.naviTotalCount = naviTotalCount;
	}
	@Override
	public String toString() {
		return "PageInfo [currentPage=" + currentPage + ", boardWriter=" + boardWriter + ", recordnaiCountPage="
				+ recordnaiCountPage + ", naviCountPerPage=" + naviCountPerPage + ", startNavi=" + startNavi
				+ ", endNavi=" + endNavi + ", totalCount=" + totalCount + ", naviTotalCount=" + naviTotalCount + "]";
	}
	
	

}
