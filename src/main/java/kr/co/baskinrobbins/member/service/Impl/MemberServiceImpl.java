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
	private SqlSession session;
	
	@Override
	public int registerMember(Member member) {
		int result = mStore.insertMember(session, member);
		return result;
	}

	@Override
	public int modifyMember(Member member) {
		int result = mStore.updateMember(session, member);
		return result;
	}

	@Override
	public int resetMemberPw(Member member) {
		int result = mStore.updateMemberPw(session, member);
		return result;
	}

	@Override
	public int deleteMember(String memberId) {
		int result = mStore.deleteMember(session, memberId);
		return result;
	}

	@Override
	public Member checkLogin(Member member) {
		Member result = mStore.checkLogin(session, member);
		return result;
	}


	@Override
	public Member showOneById(String memberId) {
		Member result = mStore.showOneById(session, memberId);
		return result;
	}

	@Override
	public Member searchMemberIdInfo(Member member) {
		Member result = mStore.selectOneMemberId(session, member);
		return result;
	}

	@Override
	public Member searchMemberPwInfo(Member member) {
		Member result = mStore.selectOneMemberPw(session, member);
		return result;
	}

}
