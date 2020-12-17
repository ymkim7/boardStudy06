package kr.co.dao;

import kr.co.vo.MemberVO;

public interface MemberDAO {
	
	//아이디 중복 검사
	public int check_id(String id) throws Exception;
	
	//이메일 중복 검사
	public int check_email(String email) throws Exception;
	
	//회원가입
	public int join_member(MemberVO member) throws Exception;
	
	//이메일 인증
	public int approval_member(MemberVO member) throws Exception;
	
	//로그인 검사
	public MemberVO login(String id) throws Exception;
	
	//로그인 접속일자 변경
	public int update_log(String id) throws Exception;
	
	//아이디 찾기
	public String find_id(String email) throws Exception;
	
	//비밀번호 찾기
	public int update_pw(MemberVO member) throws Exception;
	
	//비밀번호 찾기
	public int update_mypage(MemberVO member) throws Exception;
	
	//회원탈퇴
	public int withdrawal(MemberVO member) throws Exception;

}
