package kr.co.baskinrobbins.store.domain;

public class Store {

	private int storeNo;
	private String storeName;
	private String storeAddress;
	private String storeTell;
	private String storeLat;
	private String storeLng;
	
	public int getStoreNo() {
		return storeNo;
	}
	public void setStoreNo(int storeNo) {
		this.storeNo = storeNo;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreAddress() {
		return storeAddress;
	}
	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}
	public String getStoreTell() {
		return storeTell;
	}
	public void setStoreTell(String storeTell) {
		this.storeTell = storeTell;
	}
	public String getStoreLat() {
		return storeLat;
	}
	public void setStoreLat(String storeLat) {
		this.storeLat = storeLat;
	}
	public String getStoreLng() {
		return storeLng;
	}
	public void setStoreLng(String storeLng) {
		this.storeLng = storeLng;
	}
	
	@Override
	public String toString() {
		return "매장 [매장 번호=" + storeNo + ", 매장명=" + storeName + ", 주소=" + storeAddress
				+ ", 전화번호=" + storeTell + ", 위도=" + storeLat + ", 경도=" + storeLng + "]";
	}
	
	
	
}
