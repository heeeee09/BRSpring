package kr.co.baskinrobbins.member.service.Impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.baskinrobbins.member.domain.BRMember;
import kr.co.baskinrobbins.member.service.MemberService;
import kr.co.baskinrobbins.member.store.MemberStore;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberStore mStore;
	@Autowired
	private SqlSession SqlSession;
	
	@Override
	public int registerMember(BRMember member) {
		int result = mStore.insertMember(SqlSession, member);
		return result;
	}

	@Override
	public int modifyMember(BRMember member) {
		int result = mStore.updateMember(SqlSession, member);
		return result;
	}

	@Override
	public int deleteMember(String memberId, BRMember mOne) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BRMember checkLogin(BRMember member) {
		BRMember result = mStore.checkLogin(SqlSession, member);
		return result;
	}

	@Override
	public Boolean userCheck(BRMember mOne) {
		return null;
	}

	@Override
	public BRMember findId(String memberId) {
		return null;
	}

	@Override
	public BRMember findPw(BRMember member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int resetPw(BRMember member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BRMember showOneById(String memberId) {
		BRMember result = mStore.showOneById(SqlSession, memberId);
		return result;
	}

}
