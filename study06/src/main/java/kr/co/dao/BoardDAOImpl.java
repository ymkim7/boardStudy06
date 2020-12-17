package kr.co.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Autowired
	private SqlSession sql;

	@Override
	public int board_write(BoardVO board) throws Exception {
		// TODO Auto-generated method stub
		return sql.insert("board.board_write", board);
	}

}
