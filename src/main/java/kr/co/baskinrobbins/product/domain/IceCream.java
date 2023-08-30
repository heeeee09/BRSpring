package kr.co.baskinrobbins.product.domain;

public class IceCream {
	
	/*
	 *     
	ICE_NAME VARCHAR2(40) PRIMARY KEY,
    MENU_EXPLAIN VARCHAR2(200),
    MENU_TYPE VARCHAR2(15) NOT NULL,
    ICE_IMG_NAME VARCHAR2(50),
    ICE_IMG_RENAME VARCHAR2(200),
    ICE_IMG_PATH VARCHAR2(300) NOT NULL,
    ICE_IMG_LENGTH NUMBER,
    ICE_CREATE DATE DEFAULT SYSDATE,
    ICE_UPDATE DATE DEFAULT SYSDATE,
    ICE_STATUS CHAR(1) DEFAULT 'Y'
	 */
	
	private String iceName;
	private String iceEngName;
	private String menuExplain;
	private String menuType;
	private String iceImgName;
	private String iceImgRename;
	private String iceImgPath;
	private long iceImgLength;
	private String iceCreate;
	private String iceUpdate;
	private char iceStatus;
	
	public String getIceName() {
		return iceName;
	}
	public void setIceName(String iceName) {
		this.iceName = iceName;
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
	public String getIceImgName() {
		return iceImgName;
	}
	public void setIceImgName(String iceImgName) {
		this.iceImgName = iceImgName;
	}
	public String getIceImgRename() {
		return iceImgRename;
	}
	public void setIceImgRename(String iceImgRename) {
		this.iceImgRename = iceImgRename;
	}
	public String getIceImgPath() {
		return iceImgPath;
	}
	public void setIceImgPath(String iceImgPath) {
		this.iceImgPath = iceImgPath;
	}
	public String getIceEngName() {
		return iceEngName;
	}
	public void setIceEngName(String iceEngName) {
		this.iceEngName = iceEngName;
	}
	public long getIceImgLength() {
		return iceImgLength;
	}
	public void setIceImgLength(long iceImgLength) {
		this.iceImgLength = iceImgLength;
	}
	public String getIceCreate() {
		return iceCreate;
	}
	public void setIceCreate(String iceCreate) {
		this.iceCreate = iceCreate;
	}
	public String getIceUpdate() {
		return iceUpdate;
	}
	public void setIceUpdate(String iceUpdate) {
		this.iceUpdate = iceUpdate;
	}
	public char getIceStatus() {
		return iceStatus;
	}
	public void setIceStatus(char iceStatus) {
		this.iceStatus = iceStatus;
	}
	@Override
	public String toString() {
		return "아이스크림 [이름=" + iceName + ", 영어 이름="+iceEngName+", 설명=" + menuExplain + ", 카테고리=" + menuType
				+ ", 이미지 이름=" + iceImgName + ", 이미지 리네임=" + iceImgRename + ", 이미지 경로=" + iceImgPath
				+ ", 이미지 크기=" + iceImgLength + ", 입력일=" + iceCreate + ", 수정일=" + iceUpdate
				+ ", 판매 여부=" + iceStatus + "]";
	}
	
		
	
	
}
