package kr.co.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.service.BoardService;
import kr.co.vo.BoardVO;

@Controller
@RequestMapping(value="/board/*")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardService service;
	
	//게시판 목록 페이지 이동
	@RequestMapping(value = "/board_list.do")
	public String board_list() throws Exception {
		logger.info("board_list");
		
		return "/board/board_list";
	}
	
	//게시판 글 작성 폼 이동
	@RequestMapping(value = "/board_write_form.do")
	public String board_write_form() throws Exception {
		logger.info("board_write_form");
		
		return "/board/board_write_form";
	}
	
	//게시판 글 작성
	@RequestMapping(value = "/board_write.do", method = RequestMethod.POST)
	public String board_write(@ModelAttribute BoardVO board) throws Exception {
		logger.info("board_write");
		
		service.board_write(board);
		
		return "redirect:/board/board_list.do";
	}
	
}
