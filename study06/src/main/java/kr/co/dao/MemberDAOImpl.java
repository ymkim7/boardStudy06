package kr.co.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.co.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private SqlSession sql;

	@Override
	public int check_id(String id) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne("member.check_id", id);
	}

	@Override
	public int check_email(String email) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne("member.check_email", email);
	}

	@Override
	public int join_member(MemberVO member) throws Exception {
		// TODO Auto-generated method stub
		return sql.insert("member.join_member", member);
	}

	@Override
	@Transactional
	public int approval_member(MemberVO member) throws Exception {
		// TODO Auto-generated method stub
		return sql.update("member.approval_member", member);
	}

	@Override
	public MemberVO login(String id) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne("member.login", id);
	}

	@Override
	@Transactional
	public int update_log(String id) throws Exception {
		// TODO Auto-generated method stub
		return sql.update("member.update_log", id);
	}

	@Override
	@Transactional
	public String find_id(String email) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne("member.find_id", email);
	}

	@Override
	@Transactional
	public int update_pw(MemberVO member) throws Exception {
		// TODO Auto-generated method stub
		return sql.update("member.update_pw", member);
	}

	@Override
	@Transactional
	public int update_mypage(MemberVO member) throws Exception {
		// TODO Auto-generated method stub
		return sql.update("member.update_mypage", member);
	}

	@Override
	@Transactional
	public int withdrawal(MemberVO member) throws Exception {
		// TODO Auto-generated method stub
		return sql.delete("member.withdrawal", member);
	}

}
