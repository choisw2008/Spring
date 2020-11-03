package com.edu.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity //테이블화할 bean 클래스.
@Table(name="tbl_webboards")
@EqualsAndHashCode(of="bno") //게시물 번호
//논리적 동등 비교를 위해서 equals와 hashcode를 오버라이드.
//그때 기준값(필드)이 bno - 게시물 번호
public class WebBoard {

	@Id //기본값 pk (primary key ===>> 역할: 레코드를 구분하는 유일한 값)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//기본키 생성 제약조건
	//mysql에서 알아서  pk 생성
	
	
	private Long bno;
	//그럼 이게 pk
	private String title;
	private String writer;
	private String content;
	
	@CreationTimestamp
	private Timestamp regdate;
	@CreationTimestamp
	private Timestamp updatedate;
	
	
}
