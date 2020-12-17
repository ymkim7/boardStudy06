package kr.co.dao;

import kr.co.vo.BoardVO;

public interface BoardDAO {
	
	public int board_write(BoardVO board) throws Exception;

}
