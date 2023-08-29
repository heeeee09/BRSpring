package kr.co.baskinrobbins.member.domain;

public class BRSystem {
	
	private String brSystemId;
	private String brSystemPw;
	private String brSystemName;
	
	public String getBrSystemId() {
		return brSystemId;
	}
	public void setBrSystemId(String brSystemId) {
		this.brSystemId = brSystemId;
	}
	public String getBrSystemPw() {
		return brSystemPw;
	}
	public void setBrSystemPw(String brSystemPw) {
		this.brSystemPw = brSystemPw;
	}
	public String getBrSystemName() {
		return brSystemName;
	}
	public void setBrSystemName(String brSystemName) {
		this.brSystemName = brSystemName;
	}
	@Override
	public String toString() {
		return "관리자 [아이디=" + brSystemId + ", 비밀번호=" + brSystemPw + ", 이름=" + brSystemName
				+ "]";
	}
	
	
	

}
