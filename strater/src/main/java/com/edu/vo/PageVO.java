package com.edu.vo;

import javax.print.DocFlavor.STRING;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageVO {
	//페이징 처리를 위한 bean 생성
	
	private static final int DEFAULT_SIZE=10;
	private static final int DEFAULT_MAX_SIZE=50;
	
	private int page;
	private int size;
	
	private String keyword;
	private STRING type;
	//size는 게시물 개수. 한 화면에 몇 개의 페이지를 보여줄 것인지를 담당.	
	
	public PageVO() {
		super();
	}
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page < 0 ? 1: page;
		// 최소값 한정. 3항 연산자
		// 최소값이 0보다 작아진다면, 1을 유지. 최소값은 항상 1
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size < DEFAULT_SIZE || size > DEFAULT_MAX_SIZE ? DEFAULT_SIZE : size;;
		//size는 기본 사이즈보다 작거나 기본 최대사이즈보다 크다면 기본 사이즈를 유지하고
		//그렇지 않다면 현재 사이즈 유지.
	}

	public STRING getType() {
		return type;
	}

	public void setType(STRING type) {
		this.type = type;
	}

	public static int getDefaultSize() {
		return DEFAULT_SIZE;
	}

	public static int getDefaultMaxSize() {
		return DEFAULT_MAX_SIZE;
	}
	
	public Pageable makePageable(int direction, String...props) {
		
		// direction : 게시물 정렬 방식
		// String... props : 페이징 처리를 위한 속성들 (String...은 가변인자라 동일타입으로 늘어날 수 있음)
		Sort.Direction dir = direction == 0 ? Sort.Direction.DESC : 
			Sort.Direction.ASC;	
		//어센던트(asc) sort : 매개변수에 함수형으로 리턴값을 a-b로
		//디센던트(desc) sort : 매개변수에 함수형으로 리턴값을 b-a로

		return PageRequest.of(this.page-1, this.size, dir, props);
		//this.page는 내부적으로 0부터 시작.
		//외부적으로는 1부터 처리.
		//그렇기 때문에 -1을 해야 내부 페이지 값과 일치.
	}
	
	
}










