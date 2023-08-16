package kr.co.baskinrobbins.member.domain;

public class Member {
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberBirth;
	private String memberGender;
	private String memberEmail;
	private String memberPhone;
	private String memberAddress;

	public Member() {
	}

	public Member(String memberId, String memberPw, String memberName, String memberBirth, String memberGender,
			String memberEmail, String memberPhone, String memberAddress) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberBirth = memberBirth;
		this.memberGender = memberGender;
		this.memberEmail = memberEmail;
		this.memberPhone = memberPhone;
		this.memberAddress = memberAddress;
	}

	public Member(String memberId, String memberPw) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
	}

	public Member(String memberId, String memberPw, String memberEmail, String memberPhone,
			String memberAddress) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberEmail = memberEmail;
		this.memberPhone = memberPhone;
		this.memberAddress = memberAddress;
	}
	
	public Member(String memberId, String memberEmail, String memberPhone) {
		super();
		this.memberId = memberId;
		this.memberEmail = memberEmail;
		this.memberPhone = memberPhone;
	}

	public Member(String memberEmail) {
		super();
		this.memberEmail = memberEmail;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberBirth() {
		return memberBirth;
	}

	public void setMemberBirth(String memberBirth) {
		this.memberBirth = memberBirth;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	@Override
	public String toString() {
		return "BaskinRobbins [memberId=" + memberId + ", memberPw=" + memberPw + ", memberName=" + memberName
				+ ", memberBirth=" + memberBirth + ", memberGender=" + memberGender + ", memberEmail=" + memberEmail
				+ ", memberPhone=" + memberPhone + ", memberAddress=" + memberAddress + "]";
	}
}
