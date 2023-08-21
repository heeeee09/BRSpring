package kr.co.baskinrobbins.member.store;

import org.apache.ibatis.session.SqlSession;

import kr.co.baskinrobbins.member.domain.Member;

public interface MemberStore {
	/**
	 * 회원가입
	 * @param sqlSession
	 * @param member
	 * @return
	 */
	public int insertMember(SqlSession session, Member member);

	/**
	 * 회원 정보 수정
	 * @param sqlSession
	 * @param member
	 * @return
	 */
	public int updateMember(SqlSession session, Member member);

	/**
	 * 회원 탈퇴
	 * @param sqlSession
	 * @param memberId
	 * @return
	 */
	public int deleteMember(SqlSession session, String memberId);

	/**
	 * 회원 탈퇴
	 * @param sqlSession
	 * @param mOne
	 * @return
	 */
	public Member checkLogin(SqlSession session, Member member);

	/**
	 * 아이디로 정보 검색
	 * @param sqlSession
	 * @param memberId
	 * @return
	 */
	public Member showOneById(SqlSession session, String memberId);

	/**
	 * 입력한 정보로 멤버 아이디 찾기(이름, 이메일)
	 * @param session
	 * @param member
	 * @return
	 */
	public Member selectOneMemberId(SqlSession session, Member member);

	/**
	 * 입력한 정보로 멤버 비밀번호 찾기(변경 전(아이디, 이름, 이메일))
	 * @param session
	 * @param member
	 * @return
	 */
	public Member selectOneMemberPw(SqlSession session, Member member);

	/**
	 * 비밀번호 재설정
	 * @param session
	 * @param member
	 * @return
	 */
	public int updateMemberPw(SqlSession session, Member member);
	
}