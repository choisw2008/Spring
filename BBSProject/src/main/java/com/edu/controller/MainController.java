package com.edu.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.edu.dto.ProductDTO;

@Controller
public class MainController {

	private static final Logger logger
		= LoggerFactory.getLogger(MainController.class);
	
	//시작 페이지로 이동
	@RequestMapping("/") //url pattern mapping
	public String main(Model model) {
		logger.info("mainController start.....");
		//Mode : 데이터를 담는 그릇 역할을 한다. map구조로 저장된다.
		//model.addAttribute("변수명", 값);
		model.addAttribute("message", "향단이");
		//Controller에서 view페이지로 넘어갈 때
		//prefix와 subfix가 정의되어 있는 servlet-context.xml를 참조하여
		//view페이지로 이동하게 한다.
		//<beans:property name="prefix" value="/WEB-INF/views/" />
		//main
		//<beans:property name="subfix" value=".jsp" />
		//최종적으로 /WEB-INF/views/main.jsp가 된다.
		return "main";
	} // End - public String main(Model model)
	
	//@RequestMapping("gugu.dan") : 이렇게 사용하면 GET, POST에 상관없이 사용할 수 있다. 
	@RequestMapping(value="gugu.dan", method=RequestMethod.GET) //GET방식으로만 사용한다.
	//public String gugu(Model model) {
	//public String gugu(int dan, Model model) {
	//public String gugu(@RequestParam int dan, Model model) {
	public String gugu(@RequestParam(defaultValue="3") int dan, Model model) {
		logger.info("gugu Controller에 진입했습니다.");
		
		//int dan = 7;
		String result = "";
		for(int i = 1; i <= 9; i++) {
			result += dan + " x " + i + " = " + dan*i + "<br>";
		}
		//데이터를 넘기기 전에 model에 저장해야 한다.
		//스프링을 사용하기 전의 JSP에서는 출력페이지에서 사용할 수 있도록 
		//request 영역에 저장해야 했다.
		//예) request.setAttribute("score", score);
		model.addAttribute("result", result);
		return "test/gugu"; // /WEB-INF/views/test/gugu.jsp
		
		//menu.jsp에서 구구단의 단을 불러오려면?
		//public String gugu(HttpServletRequest request, Model model) {
		//int dan = Integer.parseInt(request.getParameter("dan"));
		
		//Spring에서는 GET방식에서 위와 같은 방식으로 사용하지 않는다.
		//좀 더 쉬운방법은 아래와 같이 선언부를 사용한다.
		//변수이름을 똑같이 사용한다.(int dan)
		//public String gugu(int dan, Model model) {
		
		//값을 넘겨주는 페이지에서는 String으로 넘어오지만,
		//Spring에서는 정수형으로도 잘 받는다.
		
		//public String gugu(@RequestParam int dan, Model model) {
		//실제적으로는 @RequestParam이 숨어있는 것이다. 이것은 명시하지 않아도 된다.
		//@RequestParam을 적지 않아도 실행하는데 상관은 없으나,
		//이것을 붙이면 int dan이 단독변수가 아니라,
		//앞의 페이지에서 넘어오는 값을 저장하는 변수라는 것을 알 수 있다.
		
		//(@RequestParam(defaultValue="3") int dan, Model model)
		//dan에 값이 없으면 defaultValue의 값으로 실행한다.
	} // End - public String gugu(Model model)
	
	//리턴 타입이 void인 경우 RequestMapping과 동일한 페이지로 넘어간다.
	//호출하는 프로그램에는 test.do로 정의되어 있다. <a href="${path}/test.do">
	//url 이름과 프로그램이 똑같으면 void로 만들수 있다.
	@RequestMapping("test")
	public String test() {
		return "test";
	}
	
	@RequestMapping("test/testA")
	public String testA(Model model) {
		model.addAttribute("message", "A 홈페이지 방문을 환영합니다.");
		return "test/testA";
	}
	
	@RequestMapping("test/testB")
	public String testB(Model model) {
		model.addAttribute("message", "B 홈페이지 방문을 환영합니다.");
		return "test/testA";
	}
	
	//forward  : 주소는 그대로. 화면 전환. 대량의 데이터 전달
	//redirect : 주소가 바뀐다. 화면 전환. 소량의 get방식 데이터를 전달.
	//redirect는 출력이 목적이 아니라 페이지를 다른 주소로 이동시키는 것이다.
	
	//ModelAndView : Model(데이터 저장소), View(화면)
	@RequestMapping("test/testC")
	public ModelAndView testC() {
		Map<String, Object> map = new HashMap<String, Object>();
		//맵에 객체를 저장한다.
		map.put("product", new ProductDTO("연필", 1000));
		//new ModelAndView("view의 이름", "맵변수명", 맵);
		//변수(맵변수명)는 한개밖에 못넘긴다.
		//return new ModelAndView("test/testC", "name", "연필", "price", "1000")
		//이렇게는 할 수 없다.
		return new ModelAndView("test/testC", "map", map);
		//map속에 product변수가 들어가 있으므로,
		//view화면에서 사용할 때는
		//${map.product.name} 이렇게 사용해야 한다.
	}
	
}



















