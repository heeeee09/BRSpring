package kr.co.baskinrobbins.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import kr.co.baskinrobbins.member.domain.Member;
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
			  @ModelAttribute Member member
			, Model model) {
		try {
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
				@ModelAttribute Member member
			, Model model) {
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
				@ModelAttribute Member member
			, HttpSession session
			, Model model
			) {
		try {
			System.out.println(member.toString());
			Member result = service.checkLogin(member);
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
			sessions.invalidate();
//			sessions.removeAttribute("memberId");
//			sessions.removeAttribute("memberName");
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
		Member mOne = service.showOneById(memberId);
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
	
	@RequestMapping(value="/member/modify.do", method = RequestMethod.GET)
	public String showMyInfoModify(
			@RequestParam("memberId") String memberId
			, Model model
			) {
		Member mOne = service.showOneById(memberId);
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
	
	@RequestMapping(value="/member/delete.do", method = RequestMethod.GET)
	public String showDeleteMember(
			@RequestParam("memberId") String memberId
			, Model model) {
		Member mOne = service.showOneById(memberId);
		if(mOne != null) {
			System.out.println(mOne.toString());
			model.addAttribute("member", mOne); 
			return "member/accountDelete";
		}else {
			model.addAttribute("title", "페이지 이동 실패");
			model.addAttribute("msg", "데이터를 찾을 수 없습니다.");
			model.addAttribute("url", "redirect:/index.jsp");
			model.addAttribute("btnMsg", "메인으로 이동");
			return "common/serviceResultOneBtn";
		}
	}
	
	@RequestMapping(value="/member/delete.do", method = RequestMethod.POST)
	public String delteMember(
			@ModelAttribute Member member
			, Model model
			) {
		System.out.println(member.toString());
		int result = service.deleteMember(member.getMemberId());
		if(result > 0) {
			return "redirect:/member/logout.do";
		}else {
			model.addAttribute("title", "회원 탈퇴 실패");
			model.addAttribute("msg", "회원 탈퇴를 완료하지 못했습니다.");
			model.addAttribute("urlIndex", "redirect:/index.jsp");
			model.addAttribute("btnMsgIndex", "메인으로 이동");
			model.addAttribute("urlBack", "/member/myPage.do"+member.getMemberId());
			model.addAttribute("btnMsgBack", "마이페이지 화면으로 이동");
			return "common/serviceResult";
		}
	}
	
	@RequestMapping(value="/member/findInfo.do", method=RequestMethod.GET)
	public String showFindMemberInfo() {
		return "member/findInfo";
	}
	
	@RequestMapping(value="/member/findId.do", method = RequestMethod.GET)
	public String showFindMemberId() {
		return "member/findId";
	}
	
	public void findMemberId(
			@ModelAttribute Member member
			, Model model
			) {
		Member mOne = service.searchMemberInfo(member);
		if(mOne != null) {
			
		}
	}
		
}
/*
 * 1. 회원가입 (접속 -> 완, 입력 -> 완)
 * 2. 로그인 (접속 -> 완, 입력 -> 완)
 * 3. 로그아웃 완 (true/false -> 실패, sessions.removeAttribute로 로그아웃 성공)
 * 4. 마이페이지 (접속 -> 완, 조회 -> 완, 수정 -> 완)
 * 5. 회원탈퇴 -> 완
 * 6. 아이디, 비밀번호 찾기 (선택 -> 완, 아이디 -> ing, 비밀번호)
 * 
 * 7. 1:1 문의 내역
 * 8. 1:1 문의 상세보기
 * 9. 1:1 문의 작성
 * 10. 1:1 문의 삭제
 * 
 */

