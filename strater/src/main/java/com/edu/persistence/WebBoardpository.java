package com.edu.persistence;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.edu.domain.QWebBoard;
import com.edu.domain.WebBoard;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

public interface WebBoardpository extends CrudRepository<WebBoard, Long>, QuerydslPredicateExecutor<WebBoard> {
		//부모 인터페이스로 아래의 기능을 제공하는 리파지토리(정보 저장소) 인터페이스
		//CrudRepository<T, ID>
		//c : create
		//r : read
		//u : update
		//d : delete
		// repository : 저장소
		//<T, ID> : <타입, pk 자료형>
	
		// QuerydslPredicateExecutor<T>는 뭐냐 ==>> jpa를 이용하여 value object생성 시
		// 자동으로 테이블 생성이 되는데
		// 이때 사용되는 query문 비슷하게 객체에서 사용하는 언어.

		// Predicate : 확신, 검증
		// Executor : 실행기.
	public default Predicate makePredicate(String type, String keyword) {
		
		// 검색 타입과 검색어를 받아서 목록 검색 처리 메소드
		BooleanBuilder builder = new BooleanBuilder();
		
		// 맞다, 틀리다의 결과 메소드 리턴.
		QWebBoard board = QWebBoard.webBoard;
		
		// gt : 비교표현식 (>)
		//즉 풀어서 써보면, 게시판테이블에서 게시물 번호가 0초과라면.
		builder.and(board.bno.gt(0));
		
		if (type == null) {
			return builder;
		}
		switch (type) {
		case "t": //String으로 받아서 "" 사용.
			builder.and(board.title.like("%" + keyword + "%"));
			break;
		case "c":
			builder.and(board.content.like("%" + keyword + "%"));
			break;
		case "w":
			builder.and(board.writer.like("%" + keyword + "%"));
			break;
		}
		builder.and(board.bno.gt(0));
		return builder;
	}
}
//검색처리를 담당






























