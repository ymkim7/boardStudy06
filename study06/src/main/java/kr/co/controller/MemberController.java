package kr.co.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.service.MemberService;
import kr.co.vo.MemberVO;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService service;
	
	//회원가입 폼 이동
	@RequestMapping(value = "/memberJoinForm.do")
	public String memberJoinForm() throws Exception {
		logger.info("memberJoinForm");
		
		return "/member/memberJoinForm";
	}
	
	//아이디 중복 검사(ajax)
	@RequestMapping(value = "/check_id.do", method = RequestMethod.POST)
	public void check_id(@RequestParam("id") String id, HttpServletResponse response) throws Exception {
		logger.info("check_id");
		
		service.check_id(id, response);
	}
	
	//이메일 중복 검사(ajax)
	@RequestMapping(value = "/check_email.do", method = RequestMethod.POST)
	public void check_email(@RequestParam("email") String email, HttpServletResponse response) throws Exception {
		logger.info("check_email");
		
		service.check_email(email, response);
	}
	
	//이메일 중복 검사(ajax)
	@RequestMapping(value = "/join_member.do", method = RequestMethod.POST)
	public String join_member(@ModelAttribute MemberVO member
							, RedirectAttributes rttr
							, HttpServletResponse response) throws Exception {
		logger.info("join_member");
		
		rttr.addFlashAttribute("result", service.join_member(member, response));
		
		return "redirect:/memberJoinForm.do";
	}
	
	//회원인증
	@RequestMapping(value = "/approval_member.do", method = RequestMethod.POST)
	public void approval_member(@ModelAttribute MemberVO member
								, HttpServletResponse response) throws Exception {
		logger.info("approval_member");
		
		service.approval_member(member, response);
	}
	
	//로그인 폼 이동
	@RequestMapping(value = "/login_form.do", method = RequestMethod.GET)
	public String login_form() throws Exception {
		logger.info("login_form");
		
		return "/member/loginForm";
	}
	
	//로그인
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(@ModelAttribute MemberVO member
						,HttpSession session
						,HttpServletResponse response) throws Exception {
		logger.info("login");
		
		member = service.login(member, response);
		session.setAttribute("member", member);
		
		return "home";
	}
	
	//로그아웃
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public void logout(HttpSession session, HttpServletResponse response) throws Exception {
		logger.info("logout");
		
		session.invalidate();
		service.logout(response);
	}
	
	//아이디 찾기 폼
	@RequestMapping(value = "/find_id_form.do")
	public String find_id_form() throws Exception {
		logger.info("find_id_form");
		
		return "/member/find_id_form";
	}
	
	//아이디 찾기
	@RequestMapping(value = "/find_id.do")
	public String find_id(HttpServletResponse response
						, @RequestParam("email") String email
						, Model model) throws Exception {
		logger.info("find_id");
		
		model.addAttribute("id", service.find_id(email, response));
		
		return "/member/find_id";
	}
	
	//비밀번호 찾기 폼
	@RequestMapping(value = "/find_pw_form.do")
	public String find_pw_form() throws Exception {
		logger.info("find_pw_form");
		
		return "/member/find_pw_form";
	}
	
	//비밀번호 찾기 
	@RequestMapping(value = "/find_pw.do")
	public void find_pw(@ModelAttribute MemberVO member
						, HttpServletResponse response) throws Exception {
		logger.info("find_pw");
		
		service.find_pw(member, response);
	}
	
	//마이페이지 이동
	@RequestMapping(value = "/mypage.do")
	public String mypage() throws Exception {
		logger.info("mypage");
		
		return "/member/mypage";
	}
	
	//mypage 수정
	@RequestMapping(value = "/update_mypage.do", method = RequestMethod.POST)
	public String update_mypage(@ModelAttribute MemberVO member
								,HttpSession session
								,RedirectAttributes rttr) throws Exception {
		logger.info("update_mypage");
		
		session.setAttribute("member", service.update_mypage(member));
		rttr.addFlashAttribute("msg", "회원정보 수정 완료");
		
		return "redirect:/member/mypage.do";
	}
	
	//비밀번호 변경
	@RequestMapping(value = "update_pw.do", method = RequestMethod.POST)
	public String update_pw(@ModelAttribute MemberVO member
							,@RequestParam("old_pw") String old_pw
							,HttpSession session
							,HttpServletResponse response
							,RedirectAttributes rttr) throws Exception {
		logger.info("update_pw");
		
		session.setAttribute("member", service.update_pw(member, old_pw, response));
		rttr.addFlashAttribute("msg", "비밀번호 수정 완료");
		
		return "redirect:/member/mypage.do";
	}
	
	//회원탈퇴
	@RequestMapping(value = "/withdrawal.do", method = RequestMethod.POST)
	public String withdrawal_form(@ModelAttribute MemberVO member
								, HttpSession session
								, HttpServletResponse response) throws Exception {
		logger.info("withdrawal_form");
		
		if(service.withdrawal(member, response)) {
			session.invalidate();
		}
		return "redirect:/home";
	}

}
