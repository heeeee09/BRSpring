package kr.co.baskinrobbins.member.service.Impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.baskinrobbins.member.domain.Member;
import kr.co.baskinrobbins.member.service.MemberService;
import kr.co.baskinrobbins.member.store.MemberStore;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberStore mStore;
	@Autowired
	private SqlSession SqlSession;
	
	@Override
	public int registerMember(Member member) {
		int result = mStore.insertMember(SqlSession, member);
		return result;
	}

	@Override
	public int modifyMember(Member member) {
		int result = mStore.updateMember(SqlSession, member);
		return result;
	}

	@Override
	public int deleteMember(String memberId, Member mOne) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Member checkLogin(Member member) {
		Member result = mStore.checkLogin(SqlSession, member);
		return result;
	}

	@Override
	public Boolean userCheck(Member mOne) {
		return null;
	}

	@Override
	public Member findId(String memberId) {
		return null;
	}

	@Override
	public Member findPw(Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int resetPw(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Member showOneById(String memberId) {
		Member result = mStore.showOneById(SqlSession, memberId);
		return result;
	}

}
