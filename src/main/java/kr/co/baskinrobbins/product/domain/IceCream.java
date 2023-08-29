package kr.co.baskinrobbins.product.domain;

public class IceCream {
	private String iceName;
	private String menuExplain;
	private String fileName;
	private String fileRename;
	private String filePath;
	private long fileLength;
	private String iceCreate;
	private String iceUpdate;
	private char iceStatus;
	
	
	public String geticeName() {
		return iceName;
	}
	public void seticeName(String iceName) {
		this.iceName = iceName;
	}
	public String getMenuExplain() {
		return menuExplain;
	}
	public void setMenuExplain(String menuExplain) {
		this.menuExplain = menuExplain;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileRename() {
		return fileRename;
	}
	public void setFileRename(String fileRename) {
		this.fileRename = fileRename;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public long getFileLength() {
		return fileLength;
	}
	public void setFileLength(long fileLength) {
		this.fileLength = fileLength;
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
		return "아이스크림 [이름=" + iceName + ", 설명=" + menuExplain + ", 파일 이름=" + fileName
				+ ", 파일 리네임=" + fileRename + ", 파일 경로=" + filePath + ", 파일 크기=" + fileLength
				+ ", 입력일=" + iceCreate + ", 수정일=" + iceUpdate + ", 판매여부=" + iceStatus + "]";
	}
	
	
	
}
