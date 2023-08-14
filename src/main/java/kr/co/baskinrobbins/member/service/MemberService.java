package kr.co.baskinrobbins.member.service;

import kr.co.baskinrobbins.member.domain.BRMember;

public interface MemberService {

	public int registerMember(BRMember member);

	public int modifyMember(BRMember member);

	public int deleteMember(String memberId, BRMember mOne);

	public BRMember checkLogin(BRMember member);

	public Boolean userCheck(BRMember mOne);

	public BRMember findId(String memberId);
	
	public BRMember findPw(BRMember member);

	public int resetPw(BRMember member);

	public BRMember showOneById(String memberId);

}
