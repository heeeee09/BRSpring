package kr.co.baskinrobbins.member.service;

import kr.co.baskinrobbins.member.domain.Member;

public interface MemberService {

	public int registerMember(Member member);

	public int modifyMember(Member member);

	public int deleteMember(String memberId, Member mOne);

	public Member checkLogin(Member member);

	public Boolean userCheck(Member mOne);

	public Member findId(String memberId);
	
	public Member findPw(Member member);

	public int resetPw(Member member);

	public Member showOneById(String memberId);

}
