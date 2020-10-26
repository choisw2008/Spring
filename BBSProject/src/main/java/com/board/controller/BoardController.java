package com.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.board.dto.BoardDTO;
import com.board.service.BoardService;

@Controller
// url 요청이 /board 로 시작하는 것은 이곳에서 처리를 한다.
@RequestMapping("/board/")
public class BoardController {

	private static final Logger logger
		= LoggerFactory.getLogger(BoardController.class);

	@Inject
	private BoardService service;
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public void insertGET(BoardDTO board, Model model) throws Exception {
		logger.info("insertGET이 진입했습니다.");
	}
	
	@RequestMapping(value="/insert2", method=RequestMethod.POST)
	public String insertPOSTA(BoardDTO board, Model model,
			RedirectAttributes rttr) throws Exception {
		logger.info("insertPost가 시작되었습니다.");
		logger.info(board.toString());
		logger.info("작성자:" + board.getB_writer());
		
		rttr.addAttribute("b_no", board.getB_no());
		rttr.addAttribute("b_writer", board.getB_writer());
		rttr.addAttribute("b_title", board.getB_title());
		rttr.addAttribute("b_detail", board.getB_detail());
		
		//service.insert(board);
		//model.addAttribute("result", "게시판 등록이 완료되었습니다.");
		
		//return "/board/success";
		//새로운 글을 등록한 후 게시글 목록화면으로 이동한다.
		return "redirect:/board/insert";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insertPOST(BoardDTO board, Model model) throws Exception {
		logger.info("insertPost가 시작되었습니다.");
		logger.info(board.toString());
		logger.info("작성자:" + board.getB_writer());
		//service.insert(board);
		//model.addAttribute("result", "게시판 등록이 완료되었습니다.");
		
		//return "/board/success";
		//새로운 글을 등록한 후 게시글 목록화면으로 이동한다.
		//return "redirect:/board/list";
		return "/board/insert";
	}
	
	//게시글 목록
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void list(Model model) throws Exception {
		logger.info("BoardController list called.....");
		
		List<BoardDTO> list = null;
		//게시글 목록을 가져오기 위해서 서비스에게 일을 시킨다.
		list = service.listAll();
		//찾아온 값을 Model에 저장한다.
		model.addAttribute("list", list);
	};
	
	//게시글 상세 조회
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public void getView(@RequestParam("b_no") int b_no, Model model)
		throws Exception {
		logger.info("getView() Start.....");
		//b_no에 해당하는 회원정보를 가져온다.
		BoardDTO boardDTO = null;
		boardDTO = service.detail(b_no);
		logger.info(boardDTO.toString());
		
		//찾아온 회원정보를 View에 넘어갈 때 같이 보낸다.
		model.addAttribute("boardDTO", boardDTO);
	}
	
	//게시글 삭제
	//삭제할 게시번호를 받아서 서비스한테 게시번호를 주고 삭제작업을 의뢰한다.
	@RequestMapping("/delete")
	public String delete(@RequestParam("b_no") int b_no) throws Exception {
		logger.info(Integer.toString(b_no));
		
		service.delete(b_no);
		return "redirect:/board/list";
	}
	
	//게시글 수정
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String postUpdate(BoardDTO boardDTO) throws Exception {
		
		logger.info("BoardController Update() Start.....");
		logger.info("번  호 : " + boardDTO.getB_no());

		service.update(boardDTO);
		return "redirect:/board/list";
	}
	
	
}













