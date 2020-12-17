package kr.co.service;

import javax.servlet.http.HttpServletResponse;

import kr.co.vo.MemberVO;

public interface MemberService {
	
	//아이디 중복 검사
	public void check_id(String id, HttpServletResponse response) throws Exception;
	
	//이메일 중복 검사
	public void check_email(String email, HttpServletResponse response) throws Exception;
	
	//회원가입
	public int join_member(MemberVO member, HttpServletResponse response) throws Exception;

	public String create_key() throws Exception;
	
	public void send_mail(MemberVO member, String div) throws Exception;
	
	public void approval_member(MemberVO member, HttpServletResponse response) throws Exception;
	
	//로그인 검사
	public MemberVO login(MemberVO member, HttpServletResponse response) throws Exception;
	
	//로그인 접속일자 변경
	public int update_log(String id, HttpServletResponse response) throws Exception;
	
	//로그아웃
	public void logout(HttpServletResponse response) throws Exception;
	
	//아이디 찾기
	public String find_id(String email, HttpServletResponse response) throws Exception;
	
	//비밀번호 찾기
	public void find_pw(MemberVO member, HttpServletResponse response) throws Exception;
	
	//회원정보수정
	public MemberVO update_mypage(MemberVO member) throws Exception;
	
	//비밀번호 변경
	public MemberVO update_pw(MemberVO member, String old_pw, HttpServletResponse response) throws Exception;
	
	//회원탈퇴
	public boolean withdrawal(MemberVO member, HttpServletResponse response) throws Exception;
	
}
