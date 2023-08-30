package kr.co.baskinrobbins.product.domain;

public class PageInfo {
	private int currentPage;
	private String menuType;
	private int recordnaviCountPage;
	private int naviCountPerPage;
	private int startNavi;
	private int endNavi;
	private int totalCount;
	private int naviTotalCount;
	
	public PageInfo() {
		// TODO Auto-generated constructor stub
	}

	public PageInfo(int currentPage, String menuType, int recordnaviCountPage, int naviCountPerPage, int startNavi,
			int endNavi, int totalCount, int naviTotalCount) {
		super();
		this.currentPage = currentPage;
		this.menuType = menuType;
		this.recordnaviCountPage = recordnaviCountPage;
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
	public String getmenuType() {
		return menuType;
	}
	public void setmenuType(String menuType) {
		this.menuType = menuType;
	}
	public int getrecordnaviCountPage() {
		return recordnaviCountPage;
	}
	public void setrecordnaviCountPage(int recordnaviCountPage) {
		this.recordnaviCountPage = recordnaviCountPage;
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
		return "PageInfo [currentPage=" + currentPage + ", menuType=" + menuType + ", recordnaviCountPage="
				+ recordnaviCountPage + ", naviCountPerPage=" + naviCountPerPage + ", startNavi=" + startNavi
				+ ", endNavi=" + endNavi + ", totalCount=" + totalCount + ", naviTotalCount=" + naviTotalCount + "]";
	}
	
	

}
