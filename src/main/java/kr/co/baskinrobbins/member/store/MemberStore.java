package kr.co.baskinrobbins.member.store;

import org.apache.ibatis.session.SqlSession;

import kr.co.baskinrobbins.member.domain.Member;

public interface MemberStore {
	
	public int insertMember(SqlSession sqlSession, Member member);

	public int updateMember(SqlSession sqlSession, Member member);

	public int deleteMember(SqlSession sqlSession, Member mOne);

	public Member checkLogin(SqlSession sqlSession, Member member);

	public Member checkPassword(SqlSession sqlSession, Member mOne);

	public Member findId(SqlSession sqlSession, String memberId);
	
	public Member findPw(SqlSession sqlSession, Member member);

	public int resetPw(SqlSession sqlSession, Member member);

	public Member showOneById(SqlSession sqlSession, String memberId);
	
}