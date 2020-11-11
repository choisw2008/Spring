package com.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.domain.BoardDTO;

@Mapper//Mapper 영역은 데이터베이스와의 통신, 즉 SQL 쿼리를 호출하는 것
public interface BoardMapper {
	public int insertBoard(BoardDTO params);
	//게시글 생성하는 쿼리를 호출하는메서드
	public BoardDTO selectBoardDetail(Long idx);
	//하나의 게시글을 조회하는 SELECT 쿼리를 호출하는 메서드
	public int updateBoard(BoardDTO params);
	//게시글을 수정하는 UPDATE 쿼리를 호출하는 메서드
	public int deleteBoard(Long idx);
	//게시글을 삭제하는 DELETE 쿼리를 호출하는 메서드
	public List<BoardDTO> selectBoardList();
	//게시글 목록을 조회하는 SELECT 쿼리를 호출하는 메서드
	public int selectBoardTotalCount();
	//삭제 여부(delete_yn)가 'N'으로 지정된 게시글의 개수를 조회하는 SELECT 쿼리를 호출하는 메서드
}
