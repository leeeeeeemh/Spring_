package com.spring.biz.board;

import java.util.List;

import com.spring.biz.board.impl.BoardDAO;

public class BoardTest {

	public static void main(String[] args) {
		BoardVO vo = new BoardVO();
		vo.setSeq(2);
		vo.setTitle("출첵");
		vo.setWriter("포동애비");
		vo.setContent("ㅊㅊ");
		
		BoardDAO dao = new BoardDAO();
		
//		dao.insertBoard(vo);
		
//		dao.updateBoard(vo);
		
//		dao.deleteBoard(vo);
		
//		BoardVO board = dao.getBoard(vo);
//		System.out.println("board : " + board);
		
		List<BoardVO> board = dao.getBoardList();
		System.out.println("board : " + board);
		
	}

}
