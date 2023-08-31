package kr.co.baskinrobbins.product.domain;

public class Product {
	
	private String menuPkName;
	private String menuName;
	private String menuEngName;
	private String menuExplain;
	private String menuType;
	private String menuFlavor;
	private String menuHotIce;
	private int menuPrice;
	private String menuImgName;
	private String menuImgRename;
	private String menuImgPath;
	private long menuImgLength;
	private String menuCreate;
	private String menuUpdate;
	private char menuStatus;
	
	
	public String getMenuFlavor() {
		return menuFlavor;
	}
	public void setMenuFlavor(String menuFlavor) {
		this.menuFlavor = menuFlavor;
	}
	public String getMenuPkName() {
		return menuPkName;
	}
	public void setMenuPkName(String menuPkName) {
		this.menuPkName = menuPkName;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuEngName() {
		return menuEngName;
	}
	public void setMenuEngName(String menuEngName) {
		this.menuEngName = menuEngName;
	}
	public String getMenuExplain() {
		return menuExplain;
	}
	public void setMenuExplain(String menuExplain) {
		this.menuExplain = menuExplain;
	}
	public String getMenuType() {
		return menuType;
	}
	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}
	public String getMenuHotIce() {
		return menuHotIce;
	}
	public void setMenuHotIce(String menuHotIce) {
		this.menuHotIce = menuHotIce;
	}
	public int getMenuPrice() {
		return menuPrice;
	}
	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}
	public String getMenuImgName() {
		return menuImgName;
	}
	public void setMenuImgName(String menuImgName) {
		this.menuImgName = menuImgName;
	}
	public String getMenuImgRename() {
		return menuImgRename;
	}
	public void setMenuImgRename(String menuImgRename) {
		this.menuImgRename = menuImgRename;
	}
	public String getMenuImgPath() {
		return menuImgPath;
	}
	public void setMenuImgPath(String menuImgPath) {
		this.menuImgPath = menuImgPath;
	}
	public long getMenuImgLength() {
		return menuImgLength;
	}
	public void setMenuImgLength(long menuImgLength) {
		this.menuImgLength = menuImgLength;
	}
	public String getMenuCreate() {
		return menuCreate;
	}
	public void setMenuCreate(String menuCreate) {
		this.menuCreate = menuCreate;
	}
	public String getMenuUpdate() {
		return menuUpdate;
	}
	public void setMenuUpdate(String menuUpdate) {
		this.menuUpdate = menuUpdate;
	}
	public char getMenuStatus() {
		return menuStatus;
	}
	public void setMenuStatus(char menuStatus) {
		this.menuStatus = menuStatus;
	}
	@Override
	public String toString() {
		return "메뉴 [ 메뉴 고유 이름="+ menuPkName+ "메뉴 이름=" + menuName + ", 메뉴 리네임=" + menuEngName + ", 메뉴 설명=" + menuExplain
				+ ", 메뉴 카테고리=" + menuType + ", 아이스크림 맛=" +menuFlavor+ ", HOT/ICE=" + menuHotIce + ", 가격=" + menuPrice
				+ ", 이미지 이름=" + menuImgName + ", 이미지 리네임=" + menuImgRename + ", 이미지 경로=" + menuImgPath
				+ ", 이미지 크기=" + menuImgLength + ", 등록일=" + menuCreate + ", 수정일=" + menuUpdate
				+ ", 판매여부=" + menuStatus + "]";
	}
	
	

}
