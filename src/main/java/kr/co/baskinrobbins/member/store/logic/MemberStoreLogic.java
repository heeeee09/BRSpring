package kr.co.baskinrobbins.member.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.baskinrobbins.member.domain.Member;
import kr.co.baskinrobbins.member.store.MemberStore;

@Repository
public class MemberStoreLogic implements MemberStore {

	@Override
	public int insertMember(SqlSession session, Member member) {
		int result = session.insert("MemberMapper.insertMember", member);
		return result;
	}

	@Override
	public int updateMember(SqlSession session, Member member) {
		int result = session.update("MemberMapper.updateMember", member);
		return result;
	}

	@Override
	public int deleteMember(SqlSession session, Member mOne) {
		
		return 0;
	}

	@Override
	public Member checkLogin(SqlSession session, Member member) {
		Member result = session.selectOne("MemberMapper.checkLogin", member);
		return result;
	}

	@Override
	public Member checkPassword(SqlSession session, Member mOne) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member findId(SqlSession session, String memberId) {
		return null;
	}

	@Override
	public Member findPw(SqlSession session, Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int resetPw(SqlSession session, Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Member showOneById(SqlSession session, String memberId) {
		Member result = session.selectOne("MemberMapper.showOneById", memberId);
		return result;
	}

}
