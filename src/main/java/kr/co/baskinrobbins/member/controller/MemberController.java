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
				model.addAttribute("msg", "ȸ�������� �Ϸ�Ǿ����ϴ�.");
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
			model.addAttribute("title", "ȸ�� ���� ���� �Ϸ�");
			model.addAttribute("msg", "ȸ�� ���� ������ �Ϸ��߽��ϴ�.");
			model.addAttribute("urlIndex", "/index.jsp");
			model.addAttribute("btnMsgIndex", "�������� �̵�");
			model.addAttribute("urlBack", "/member/myPage.do");
			model.addAttribute("btnMsgBack", "���� ������ ȭ������ �̵�");
			return "common/serviceResult.do";			
		}else {
			model.addAttribute("title", "ȸ�� ���� ���� ����");
			model.addAttribute("msg", "ȸ�� ���� ������ �Ϸ����� ���߽��ϴ�.");
			model.addAttribute("urlIndex", "redirect:/index.jsp");
			model.addAttribute("btnMsgIndex", "�������� �̵�");
			model.addAttribute("urlBack", "/member/modify.do");
			model.addAttribute("btnMsgBack", "���� ȭ������ �̵�");
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
				model.addAttribute("title", "�α��� ����");
				model.addAttribute("msg", "���̵� �Ǵ� ��й�ȣ�� Ʋ���ϴ�.");
				model.addAttribute("urlIndex", "redirect:/index.jsp");
				model.addAttribute("btnMsgIndex", "�������� �̵�");
				model.addAttribute("urlBack", "/member/login.do");
				model.addAttribute("btnMsgBack", "�α��� ȭ������ �̵�");
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
			model.addAttribute("title", "�α׾ƿ� ����");
			model.addAttribute("msg", "�α׾ƿ��� �Ϸ����� ���߽��ϴ�.");
			model.addAttribute("url", "redirect:/index.jsp");
			model.addAttribute("btnMsg", "�������� �̵�");
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
			model.addAttribute("title", "���������� ��ȸ ����");
			model.addAttribute("msg", "�����͸� ã�� �� �����ϴ�.");
			model.addAttribute("url", "redirect:/index.jsp");
			model.addAttribute("btnMsg", "�������� �̵�");
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
			model.addAttribute("title", "���������� ��ȸ ����");
			model.addAttribute("msg", "�����͸� ã�� �� �����ϴ�.");
			model.addAttribute("url", "redirect:/index.jsp");
			model.addAttribute("btnMsg", "�������� �̵�");
			return "common/serviceResultOneBtn";
		}
	}
	
		
}
/*
 * 1. ȸ������ (���� -> ��, �Է� -> ��)
 * 2. �α��� (���� -> ��, �Է� -> ��)
 * 3. �α׾ƿ� �� (true/false -> ����, sessions.removeAttribute�� �α׾ƿ� ����)
 * 4. ���������� (���� -> ��, ��ȸ -> ��, ����)
 * 5. ȸ��Ż��
 * 6. ���̵�, ��й�ȣ ã��
 * 
 * 7. 1:1 ���� ����
 * 8. 1:1 ���� �󼼺���
 * 9. 1:1 ���� �ۼ�
 * 10. 1:1 ���� ����
 * 
 */

