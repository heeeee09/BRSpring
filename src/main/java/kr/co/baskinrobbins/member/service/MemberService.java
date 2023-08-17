package kr.co.baskinrobbins.member.service;

import kr.co.baskinrobbins.member.domain.Member;

public interface MemberService {

	/**
	 * 회원 가입 service
	 * @param member
	 * @return
	 */
	public int registerMember(Member member);

	/**
	 * 회원 탈퇴 service
	 * @param memberId
	 * @return
	 */
	public int deleteMember(String memberId);

	/**
	 * 회원 정보 수정 service
	 * @param member
	 * @return
	 */
	public int modifyMember(Member member);

	/**
	 * 로그인 service
	 * @param member
	 * @return
	 */
	public Member checkLogin(Member member);

	/**
	 *  아이디로 검색 service
	 * @param memberId
	 * @return
	 */
	public Member showOneById(String memberId);

	/**
	 * 입력한 정보로 멤버 아이디 찾기
	 * @param member
	 * @return
	 */
	public Member searchMemberInfo(Member member);

}
