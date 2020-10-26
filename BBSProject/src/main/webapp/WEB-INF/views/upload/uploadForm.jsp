<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>파일 올리기 (Form)</title>
	<%@ include file="../include/header.jsp" %>
	<style>
	iframe {
		width:			800px;
		height:			200px;
		border:			1px;
		border-style:	solid;
	}
	</style>
</head>
<body>
<%@ include file="../include/topmenu.jsp" %>

<!-- 파일 업로드를 위한 필수 속성
	 enctype="multipart/form-data" -->
	 
<!-- target="iframeTarget" 
	 파일을 올리면 원래는 action="${path}/upload/uploadForm"으로 가야하는데
	 페이지를 넘어가지 않기 위해서 제출된 결과를 iframe으로 보낸다.
 -->
<form action="${path}/upload/uploadForm" method="post"
	enctype="multipart/form-data" target="iframeTarget">
	<!-- name="file"의 변수명과 
	     컨트롤러의 MultipartFile file과 일치해야 한다. -->
	<input type="file" name="file"/>
	<input type="submit" value="파일올리기"/>	
</form>

<!-- iframe에 업로드된 결과를 출력한다. -->
<iframe name="iframeTarget"></iframe>

<%@ include file="../include/footer.jsp" %>
</body>
</html>















