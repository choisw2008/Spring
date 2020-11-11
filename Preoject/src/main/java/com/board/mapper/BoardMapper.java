package com.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.domain.BoardDTO;

@Mapper//Mapper ������ �����ͺ��̽����� ���, �� SQL ������ ȣ���ϴ� ��
public interface BoardMapper {
	public int insertBoard(BoardDTO params);
	//�Խñ� �����ϴ� ������ ȣ���ϴ¸޼���
	public BoardDTO selectBoardDetail(Long idx);
	//�ϳ��� �Խñ��� ��ȸ�ϴ� SELECT ������ ȣ���ϴ� �޼���
	public int updateBoard(BoardDTO params);
	//�Խñ��� �����ϴ� UPDATE ������ ȣ���ϴ� �޼���
	public int deleteBoard(Long idx);
	//�Խñ��� �����ϴ� DELETE ������ ȣ���ϴ� �޼���
	public List<BoardDTO> selectBoardList();
	//�Խñ� ����� ��ȸ�ϴ� SELECT ������ ȣ���ϴ� �޼���
	public int selectBoardTotalCount();
	//���� ����(delete_yn)�� 'N'���� ������ �Խñ��� ������ ��ȸ�ϴ� SELECT ������ ȣ���ϴ� �޼���
}
