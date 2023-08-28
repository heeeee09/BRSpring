package kr.co.baskinrobbins.member.domain;

public class System {
	
	private String systemId;
	private String systemPw;
	private String systemName;
	
	public String getSystemId() {
		return systemId;
	}
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}
	public String getSystemPw() {
		return systemPw;
	}
	public void setSystemPw(String systemPw) {
		this.systemPw = systemPw;
	}
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	@Override
	public String toString() {
		return "관리자 [관리자 아이디=" + systemId + ", 관리자 비밀번호=" + systemPw + ", 관리자 이름=" + systemName + "]";
	}
	
	

}
