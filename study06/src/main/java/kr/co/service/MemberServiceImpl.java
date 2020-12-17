package kr.co.service;

import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dao.MemberDAO;
import kr.co.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO dao;

	@Override
	public void check_id(String id, HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		out.println(dao.check_id(id));
		out.close();
	}

	@Override
	public void check_email(String email, HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		out.println(dao.check_email(email));
		out.close();
	}

	@Override
	public int join_member(MemberVO member, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(dao.check_id(member.getId()) == 1) {
			out.println("<script>");
			out.println("alert('동일한 아이디가 있습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return 0;
		} else if(dao.check_email(member.getEmail()) == 1) {
			out.println("<script>");
			out.println("alert('동일한 이메일이 있습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return 0;
		} else {
			member.setApproval_key(create_key());
			dao.join_member(member);
			send_mail(member, "join");
			return 1;
		}
	}

	@Override
	public String create_key() throws Exception {
		String key = "";
		Random rd = new Random();
		
		for(int i=0; i<8; i++) {
			key += rd.nextInt(10);
		}
		
		return key;
	}

	@Override
	public void send_mail(MemberVO member, String div) throws Exception {
		
		//Mail Server 설정
		String charSet = "utf-8";
		String hostSMTP = "smtp.naver.com";
		String hostSMTPid = "";
		String hostSMTPpwd = "";
		
		//보내는 사람 Email, 제목, 내용
		String fromEmail = "";
		String fromName = "Spring Homepage";
		String subject = "";
		String msg = "";
		
		if(div.equals("join")) {
			//회원가입 메일 내용
			subject = "Spring Homepage 회원가입 인증 메일입니다.";
			msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
			msg += "	<h3 style='color:blue;'>";
			msg += 			member.getId() + "님 회원가입을 환영합니다.";
			msg += "	</h3>";
			msg += "	<div style='font-size:130%;'>";
			msg += "		하단의 인증 버튼 클릭 시 정상적으로 회원가입이 완됩니다.";
			msg += "	</div>";
			msg += "	<br/>";
			msg += "	<form method='post' action='http://localhost:8006/member/approval_member.do'>";
			msg += "		<input type='hidden' name='email' value='"+ member.getEmail() +"'/>";
			msg += "		<input type='hidden' name='approval_key' value='"+ member.getApproval_key() +"'/>";
			msg += "		<input type='submit' value='인증'/>";
			msg += "	</form>";
			msg += "	<br/>";
			msg += "</div>";
		} else if(div.equals("find_pw")) {
			subject = "Spring Homepage 임시 비밀번호 입니다.";
			msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
			msg += "	<h3 style='color:blue;'>";
			msg += 			member.getId() + "님의 임시 비밀번호 입니다. 변경후 사용하세요.";
			msg += "	</h3>";
			msg += "	<p>임시 비밀번호 :" + member.getPw() + "</p>";
			msg += "</div>";
		}
		
		//받는 사람 Email 주소
		String mail = member.getEmail();
		
		try {
			HtmlEmail email = new HtmlEmail();
			email.setDebug(true);
			email.setCharset(charSet);
			email.setSSL(true);
			email.setHostName(hostSMTP);
			email.setSmtpPort(587);
			email.setAuthentication(hostSMTPid, hostSMTPpwd);
			email.setTLS(true);
			email.addTo(mail, charSet);
			email.setFrom(fromEmail, fromName, charSet);
			email.setSubject(subject);
			email.setHtmlMsg(msg);
			email.send();
		} catch(Exception e) {
			System.out.println("이메일 발송 실패 :"+ e);
		}
		
	}

	@Override
	public void approval_member(MemberVO member, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(dao.approval_member(member) == 0) {
			out.println("<script>");
			out.println("alert('잘못된 접근입니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		} else {
			out.println("<script>");
			out.println("alert('인중이 완료되었습니다. 로그인 후 이용하세요.');");
			out.println("location.href='../home.jsp';");
			out.println("</script>");
			out.close();
		}
		
	}

	@Override
	public MemberVO login(MemberVO member, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(dao.check_id(member.getId()) == 0) {
			out.println("<script>");
			out.println("alert('등록된 아이디가 있습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return null;
		} else {
			String pw = member.getPw();
			member = dao.login(member.getId());
			
			if(!member.getPw().equals(pw)) {
				out.println("<script>");
				out.println("alert('비밀번호가 다릅니다.');");
				out.println("history.go(-1);");
				out.println("</script>");
				out.close();
				return null;
			} else if(!member.getApproval_status().equals("true")) {
				out.println("<script>");
				out.println("alert('이메일 인증 후 로그인 하세요.');");
				out.println("history.go(-1);");
				out.println("</script>");
				out.close();
				return null;
			} else {
				dao.update_log(member.getId());
				return member;
			}
		}
	}

	@Override
	public int update_log(String id, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return dao.update_log(id);
	}

	@Override
	public void logout(HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<script>");
		out.println("location.href=document.referren;");
		out.println("</script>");
		out.close();
		
	}

	@Override
	public String find_id(String email, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String id = dao.find_id(email);
		
		if(id == null) {
			out.println("<script>");
			out.println("alert('가입된 아이디가 없습니다');");
			out.println("</script>");
			out.close();
			return null;
		} else {
			return id;
		}
	}

	@Override
	public void find_pw(MemberVO member, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//아이디가 없으면
		if(dao.check_id(member.getId()) == 0) {
			out.print("아이디가 없습니다.");
			out.close();
			
		//가입에 사용한 이메일이 아니면
		} else if(!member.getEmail().equals(dao.login(member.getId()).getEmail())) {
			out.print("잘못된 이메일 입니다.");
			out.close();
			
		//임시 비밀번호 생성
		} else {
			String pw = "";
			for(int i = 0; i < 12; i++) {
				pw += (char) ((Math.random() * 26) + 97);
			}
			
			member.setPw(pw);
			dao.update_pw(member);
			send_mail(member, "find_pw");
			
			out.print("이메일로 임시 비밀번호를 발송하였습니다.");
			out.close();
		}
		
	}

	@Override
	public MemberVO update_mypage(MemberVO member) throws Exception {
		dao.update_mypage(member);
		
		return dao.login(member.getId());
	}

	@Override
	public MemberVO update_pw(MemberVO member, String old_pw, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(!old_pw.equals(dao.login(member.getId()).getPw())) {
			out.println("<script>");
			out.println("alert('기존 비밀번호가 다릅니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return null;
		} else {
			dao.update_pw(member);
			return dao.login(member.getId());
		}
	}

	@Override
	public boolean withdrawal(MemberVO member, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(dao.withdrawal(member) != 1) {
			out.println("<script>");
			out.println("alert('회원탈퇴 실패!');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return false;
		} else {
			return false;
		}
	}

}
