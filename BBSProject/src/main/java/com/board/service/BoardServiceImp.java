package com.board.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.board.controller.BoardController;
import com.board.dao.BoardDAO;
import com.board.dto.BoardDTO;

@Service
public class BoardServiceImp implements BoardService {

	private static final Logger logger
	= LoggerFactory.getLogger(BoardService.class);

	@Inject
	private BoardDAO boardDAO;
	
	@Override
	public void insert(BoardDTO boardDTO) throws Exception {
		boardDAO.insert(boardDTO);
	}

	@Override
	public void update(BoardDTO boardDTO) throws Exception {
		logger.info("BoardService update() Start.....");
		boardDAO.update(boardDTO);
	}

	@Override
	public void delete(Integer b_no) throws Exception {
		logger.info("BoardService delete() Start.....");
		logger.info(Integer.toString(b_no));
		boardDAO.delete(b_no);
	}

	@Override
	public BoardDTO detail(Integer b_no) throws Exception {
		logger.info("BoardService detail() Start.....");
		return boardDAO.detail(b_no);
	}

	@Override
	public List<BoardDTO> listAll() throws Exception {
		return boardDAO.listAll();
	}

}









