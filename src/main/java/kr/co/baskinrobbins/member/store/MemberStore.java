package kr.co.baskinrobbins.member.store;

import org.apache.ibatis.session.SqlSession;

import kr.co.baskinrobbins.member.domain.BRMember;

public interface MemberStore {
	
	public int insertMember(SqlSession sqlSession, BRMember member);

	public int updateMember(SqlSession sqlSession, BRMember member);

	public int deleteMember(SqlSession sqlSession, BRMember mOne);

	public BRMember checkLogin(SqlSession sqlSession, BRMember member);

	public BRMember checkPassword(SqlSession sqlSession, BRMember mOne);

	public BRMember findId(SqlSession sqlSession, String memberId);
	
	public BRMember findPw(SqlSession sqlSession, BRMember member);

	public int resetPw(SqlSession sqlSession, BRMember member);

	public BRMember showOneById(SqlSession sqlSession, String memberId);
	
}