<%@ tag language="java" pageEncoding="UTF-8"%>

<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/board/Main">suwon-studio</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="./../wonsu/catalog.html">catalog</a></li>
				<li><a href=#>BAND</a></li>
				<li><a href=#>Figure</a></li>
				<li><a href=#>producer</a></li>
			
				<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">로그인<span class="caret"></span></a>	
						<ul class="dropdown-menu">
							<li><a href="${path}/member/login">로그인 (Session)</a></li>
							<li><a href="${path}/member/logout">로그아웃 (Session)</a></li>
						</ul>
				</li>
			
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">MORE <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="./../wonsu/more01.html">중고용품</a></li>
						<li><a href="./../wonsu/more02.html">수제작</a></li>
						<li><a href="/board/list">게시판</a></li>
						<li><a href="/board/listDate">게시글 목록(Date Picker)</a></li>
					</ul>
				</li>
					
				<li><a href="#"><span class="glyphicon glyphicon-search"></span></a></li>
			</ul>
		</div>
	</div>
</nav>



















