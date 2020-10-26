package com.upload.controller;

import java.io.File;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

//컨트롤러의 역할을 부여하기 위해서 애노테이션 @Controller를 기술한다.
@Controller
public class UploadController {

	//로깅을 위한 코드
	private static final Logger logger
		= LoggerFactory.getLogger(UploadController.class);
	
	//servlet-confext.xml에 선언한 스트링 bean 참조
	@Resource(name="uploadPath")
	//String uploadPath = "c:/upload"; <= 직접 써도 괜찮다.
	private String uploadPath; //공통적으로 사용하기 위해서
	
	//업로드 폼 페이지로 이동
	@RequestMapping(value="/upload/uploadForm", method=RequestMethod.GET)
	public String uploadForm() {
		return "upload/uploadForm";
	}
	
	//업로드된 내용을 처리
	//MultipartFile file : 업로드한 파일이 저장된다(임시경로)
	@RequestMapping(value="/upload/uploadForm", method=RequestMethod.POST)
	public ModelAndView uploadForm(MultipartFile file, ModelAndView mav)
		throws Exception {
		
		logger.info("파일  이름:" + file.getOriginalFilename());
		logger.info("파일  크기:" + file.getSize());
		logger.info("컨테트타입:" + file.getContentType());
		
		String savedName = file.getOriginalFilename();
		savedName = uploadFile(savedName, file.getBytes());
		
		mav.setViewName("/upload/uploadResult"); //뷰의 이름
		mav.addObject("savedName", savedName);	 //전달할 데이터
		return mav; // uploadResult.jsp로 포워딩된다.
	}
	
	//파일 이름이 중복되지 않도록 처리한다.
	String uploadFile(String originalName, byte[] fileData)
		throws Exception {
		//Universal Unique IDentifier 범용고유식별자 
		//코드를 랜덤하게 만들어 낸다.
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString() + "_" + originalName;
		
		//new File(디렉토리, 파일이름)
		File target = new File(uploadPath, savedName);
		
		//첨부파일을 임시디렉토리에서 우리가 지정한 디렉토리로 복사한다.
		FileCopyUtils.copy(fileData, target);
		return savedName; //복사한 파일이름을 되돌려 준다.
	}
	
	//도로명 주소 사용하기
	@RequestMapping("/upload/address")
	public String address() {
		return "/upload/address";
	}
	
	
}















