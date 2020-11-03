package com.edu.vo;


import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.thymeleaf.standard.processor.StandardSrcTagProcessor;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.java.Log;


@Getter
@ToString(exclude = "pageList")
//exclude = "pageList"는 toString처리에서 pageList필드는 제외
//그 이유는  상호 호출의 문제때문에
@Log
public class PageMaker<T> {
	
	private Page<T> result;
	// 제네릭 클래스.(선언은 T타입)
	// 선언을 단순하게 해두고, 사용 시 실제 객체 타입을 적용.

	private Pageable prePage;//이전
	private Pageable nextPage;//다음
	
	private int currentPageNum;
	// 현재 보여지는 페이지
	private int totalPageNum;
	// 전체 페이지 번호
	
	private Pageable currentPage;
	// 현재 페이지 정보
	
	private List<Pageable> pageList;
	// 페이지 저장 목록
	
	public PageMaker(Page<T> result) {
		// 생성자부분임 , 매개변수는 1개
		this.result = result;
		this.currentPage = result.getPageable();
		this.currentPageNum = currentPage.getPageNumber() + 1;
		// 내부적인 처리와 외부적인 처리의 차이로 +1.
		this.totalPageNum = result.getTotalPages();
		this.pageList = new ArrayList<>();
		
		calcPages();
	}	
	
	public void calcPages() {
		int tempEndNum = (int) (Math.ceil(this.currentPageNum / 10.0) * 10);
		int startNum = tempEndNum -9;
		
		Pageable startPage = this.currentPage;
		
		for (int i = startNum; i < this.currentPageNum; i++) {
			startPage = startPage.previousOrFirst();
		
		}
		
		this.prePage = startPage.getPageNumber() <= 0 ? null :startPage.previousOrFirst();
	}
}





















