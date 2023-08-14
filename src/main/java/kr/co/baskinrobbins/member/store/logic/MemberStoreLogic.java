package kr.co.baskinrobbins.member.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.baskinrobbins.member.domain.BRMember;
import kr.co.baskinrobbins.member.store.MemberStore;

@Repository
public class MemberStoreLogic implements MemberStore {

	@Override
	public int insertMember(SqlSession session, BRMember member) {
		int result = session.insert("MemberMapper.insertMember", member);
		return result;
	}

	@Override
	public int updateMember(SqlSession session, BRMember member) {
		int result = session.update("MemberMapper.updateMember", member);
		return result;
	}

	@Override
	public int deleteMember(SqlSession session, BRMember mOne) {
		
		return 0;
	}

	@Override
	public BRMember checkLogin(SqlSession session, BRMember member) {
		BRMember result = session.selectOne("MemberMapper.checkLogin", member);
		return result;
	}

	@Override
	public BRMember checkPassword(SqlSession session, BRMember mOne) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BRMember findId(SqlSession session, String memberId) {
		return null;
	}

	@Override
	public BRMember findPw(SqlSession session, BRMember member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int resetPw(SqlSession session, BRMember member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BRMember showOneById(SqlSession session, String memberId) {
		BRMember result = session.selectOne("MemberMapper.showOneById", memberId);
		return result;
	}

}
