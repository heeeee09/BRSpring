package kr.co.baskinrobbins.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import jdk.nashorn.api.scripting.ScriptUtils;
import kr.co.baskinrobbins.member.domain.BRMember;
import kr.co.baskinrobbins.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@RequestMapping(value = "/member/register.do", method = RequestMethod.GET)
	public String showRegisterForm() {
		return "member/register";
	}
	
	@RequestMapping(value="/member/register.do", method = RequestMethod.POST)
	public String registerMember(
			  @RequestParam("member-id") String memberId
			, @RequestParam("member-pw") String memberPw
			, @RequestParam("member-name") String memberName
			, @RequestParam("member-birthday") String memberBirth
			, @RequestParam("member-gender") String memberGender
			, @RequestParam("member-email") String memberEmail
			, @RequestParam("member-phone") String memberPhone
			, @RequestParam("member-address") String memberAddress
			, Model model) {
		try {
			BRMember member = new BRMember(memberId, memberPw, memberName, memberBirth, memberGender, memberEmail, memberPhone, memberAddress);
			int result = service.registerMember(member);
			if(result > 0) {
				model.addAttribute("msg", "회원가입이 완료되었습니다.");
				model.addAttribute("url", "redirect:/index.jsp");
				return "common/alert";
			}else {
				return "common/serviceResult";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/serviceResult";
		}
	}
	
	@RequestMapping(value="/member/modify.do", method = RequestMethod.POST)
	public String modifyMember(
			  @RequestParam("member-id") String memberId
			, @RequestParam("member-pw") String memberPw
			, @RequestParam("member-email") String memberEmail
			, @RequestParam("member-phone") String memberPhone
			, @RequestParam("member-address") String memberAddress
			, Model model) {
		BRMember member = new BRMember(memberId, memberPw, memberEmail, memberPhone, memberAddress);
		int result = service.modifyMember(member);
		if(result > 0) {
			model.addAttribute("title", "회원 정보 수정 완료");
			model.addAttribute("msg", "회원 정보 수정을 완료했습니다.");
			model.addAttribute("urlIndex", "/index.jsp");
			model.addAttribute("btnMsgIndex", "메인으로 이동");
			model.addAttribute("urlBack", "/member/myPage.do");
			model.addAttribute("btnMsgBack", "마이 페이지 화면으로 이동");
			return "common/serviceResult.do";			
		}else {
			model.addAttribute("title", "회원 정보 수정 실패");
			model.addAttribute("msg", "회원 정보 수정을 완료하지 못했습니다.");
			model.addAttribute("urlIndex", "redirect:/index.jsp");
			model.addAttribute("btnMsgIndex", "메인으로 이동");
			model.addAttribute("urlBack", "/member/modify.do");
			model.addAttribute("btnMsgBack", "이전 화면으로 이동");
			return "common/serviceResult";
		}
	}

	@RequestMapping(value="/member/login.do", method = RequestMethod.GET)
	public String showLogin() {
		return "member/login";
	}
	
	
	@RequestMapping(value="/member/login.do", method = RequestMethod.POST)
	public String checkLogin(HttpServletRequest request,
			  @RequestParam("member-id") String memberId
			, @RequestParam("member-pw") String memberPw
			, HttpSession session
			, Model model
			) {
		try {
			BRMember member = new BRMember(memberId, memberPw);
			BRMember result = service.checkLogin(member);
			
			if(result != null) {
				System.out.println(result.toString());
				System.out.println(result.getMemberId());
				session.setAttribute("memberId", result.getMemberId());
				session.setAttribute("memberName", result.getMemberName());
//				model.addAttribute("memberId", result.getMemberId());
//				model.addAttribute("memberName", result.getMemberName());
				return "redirect:/index.jsp";
			}else {
				model.addAttribute("title", "로그인 실패");
				model.addAttribute("msg", "아이디 또는 비밀번호가 틀립니다.");
				model.addAttribute("urlIndex", "redirect:/index.jsp");
				model.addAttribute("btnMsgIndex", "메인으로 이동");
				model.addAttribute("urlBack", "/member/login.do");
				model.addAttribute("btnMsgBack", "로그인 화면으로 이동");
				return "common/serviceResult";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/serviceResult";
		}
	}
	
	@RequestMapping(value="/member/logout.do", method = RequestMethod.GET)
	public String memberLogout(
			SessionStatus session
			, HttpSession sessions
			, Model model
			) {
		if(session != null) {
			sessions.removeAttribute("memberId");
			sessions.removeAttribute("memberName");
			session.setComplete();
			System.out.println(session.isComplete());
//			if(session.isComplete()) {
//			}
			return "redirect:/index.jsp";
		}else {
			model.addAttribute("title", "로그아웃 실패");
			model.addAttribute("msg", "로그아웃을 완료하지 못했습니다.");
			model.addAttribute("url", "redirect:/index.jsp");
			model.addAttribute("btnMsg", "메인으로 이동");
			return "common/serviceResultOneBtn";
		}
	}
	
	@RequestMapping(value="/member/myPage.do", method = RequestMethod.GET)
	public String showMyPage(
			@RequestParam("memberId") String memberId
			, Model model) {
		BRMember mOne = service.showOneById(memberId);
		if(mOne != null) {
			model.addAttribute("member", mOne); 
			return "member/myPage";
		}else {
			model.addAttribute("title", "마이페이지 조회 실패");
			model.addAttribute("msg", "데이터를 찾을 수 없습니다.");
			model.addAttribute("url", "redirect:/index.jsp");
			model.addAttribute("btnMsg", "메인으로 이동");
			return "common/serviceResultOneBtn";
		}
	}
	
	@RequestMapping(value="member/modify.do", method = RequestMethod.GET)
	public String showMyInfoModify(
			@RequestParam("memberId") String memberId
			, Model model
			) {
		BRMember mOne = service.showOneById(memberId);
		if(mOne != null) {
			System.out.println(mOne.toString());
			model.addAttribute("member", mOne); 
			return "member/userInfoModify";
		}else {
			model.addAttribute("title", "마이페이지 조회 실패");
			model.addAttribute("msg", "데이터를 찾을 수 없습니다.");
			model.addAttribute("url", "redirect:/index.jsp");
			model.addAttribute("btnMsg", "메인으로 이동");
			return "common/serviceResultOneBtn";
		}
	}
	
		
}
/*
 * 1. 회원가입 (접속 -> 완, 입력 -> 완)
 * 2. 로그인 (접속 -> 완, 입력 -> 완)
 * 3. 로그아웃 완 (true/false -> 실패, sessions.removeAttribute로 로그아웃 성공)
 * 4. 마이페이지 (접속 -> 완, 조회 -> 완, 수정)
 * 5. 회원탈퇴
 * 6. 아이디, 비밀번호 찾기
 * 
 * 7. 1:1 문의 내역
 * 8. 1:1 문의 상세보기
 * 9. 1:1 문의 작성
 * 10. 1:1 문의 삭제
 * 
 */

