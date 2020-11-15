<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" 		uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="layoutTag" 	tagdir="/WEB-INF/tags" %>
<layoutTag:layout>
<!DOCTYPE html>
<html>
<head>
  
  <style>
body {
    font: 400 15px/1.8 Lato, sans-serif;
    color: #777;
  }
 .container h2{
  font-family: Comic Sans MS;
  }
  h3, h4 {
    margin: 10px 0 30px 0;
    letter-spacing: 10px;      
    font-size: 20px;
    color: #111;
  }
  .container {
    padding: 80px 120px;
  }
  .container img{

    width: 120px;
    height: 120px
  }
  .person {
    border: 10px solid transparent;
    margin-left: 80px;
    margin-bottom: 25px;
    width: 80%;
    height: 80%;
    opacity: 0.7;
  }
  .person:hover {
    border-color: #f1f1f1;
  }
  .carousel-inner img {
    -webkit-filter: grayscale(45%);
    filter: grayscale(45%); /* make all photos black and white */ 
    width: 50%;
    margin: auto;
  }
  .carousel-caption h3 {
    color: #fff !important;
  }
  @media (max-width: 600px) {
    .carousel-caption {
      display: none; /* Hide the carousel text when the screen is less than 600 pixels wide */
    }
  }
  #soo {
    background: #2d2d30;
  }
   #soo h3 {color: #fff;}
   #soo p {font-style: italic;}
  .list-group-item:first-child {
    border-top-right-radius: 0;
    border-top-left-radius: 0;
  }
  .list-group-item:last-child {
    border-bottom-right-radius: 0;
    border-bottom-left-radius: 0;
  }
  .thumbnail {
    font-size: 12px;
    padding: 0 0 15px 0;
    border: none;
    border-radius: 0;
  }
  .thumbnail p {
    margin-top: 15px;
    color: #555;
  }
  .btn {
    padding: 10px 20px;
    background-color: #333;
    color: #f1f1f1;
    border-radius: 0;
    transition: .2s;
  }
  .btn:hover, .btn:focus {
    border: 1px solid #333;
    background-color: #fff;
    color: #000;
  }
  .modal-header, h4, .close {
    background-color: #333;
    color: #fff !important;
    text-align: center;
    font-size: 30px;
  }
  .modal-header, .modal-body {
    padding: 40px 50px;
  }
  .nav-tabs li a {
    color: #777;
  }
  #googleMap {
    width: 100%;
    height: 400px;
    -webkit-filter: grayscale(100%);
    filter: grayscale(100%);
  }  
  .navbar {
    font-family: Montserrat, sans-serif;
    margin-bottom: 0;
    background-color: #2d2d30;
    border: 0;
    font-size: 11px !important;
    letter-spacing: 4px;
    opacity: 0.9;
  }
  .navbar li a, .navbar .navbar-brand { 
    color: #d5d5d5 !important;
  }
  .navbar-nav li a:hover {
    color: #fff !important;
  }
  .navbar-nav li.active a {
    color: #fff !important;
    background-color: #29292c !important;
  }
  .navbar-default .navbar-toggle {
    border-color: transparent;
  }
  .open .dropdown-toggle {
    color: #fff;
    background-color: #555 !important;
  }
  .dropdown-menu li a {
    color: #000 !important;
  }
  .dropdown-menu li a:hover {
    background-color: red !important;
  }
  footer {
    background-color: #2d2d30;
    color: #f5f5f5;
    padding: 32px;
  }
  footer a {
    color: #f5f5f5;
  }
  footer a:hover {
    color: #777;
    text-decoration: none;
  }  
  .form-control {
    border-radius: 0;
  }
  textarea {
    resize: none;
  }
  .collapse{
  margin-left:5px;
  	text-align: center;
  }
  </style>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">

<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>


    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="./../wonsu/images/메인사진1.jpg" alt="메인 사진1" width="1100" height="550">
        <div class="carousel-caption">
          <h3>S급 제품</h3>
          <p>좋은 퀄리티의 제품과 보존도가 좋은 중고 제품들</p>
        </div>      
      </div>
      <div class="item">
        <img src="./../wonsu/images/메인사진2.jpg" alt="메인사진2" width="1100" height="550">
        <div class="carousel-caption">
          <h3>나만의 삼점</h3>
          <p>만들고 다른 사람에게도 자신의 캐릭터를 팔아보자</p>
        </div>      
      </div> 
      <div class="item">
        <img src="./../wonsu/images/메인사진3.jpg" alt="메인 사진3" width="1100" height="550">
        <div class="carousel-caption">
          <h3>자신의 캐릭터의 배경을 알리다</h3>
          <p>그저 팔기만 하지말고 자작 캐릭터의 설정특징을 알리고 팬으로 만들어 보자!</p>
        </div>      
      </div>
    </div>


    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
</div>


<!-- Container (The Band Section) -->
<div id="band" class="container">
  <h3 >THE OTAKU</h3>
  <p><em>We love Anime!</em></p>
  <p>저희는 그저 중고피규어 판매 사이트가 아닙니다.! 넘치고 넘치는 판매 사이트를 제외하고 어떻게 해야 저희 사이트를 선택할지? </p>
  <p>그저 판매가 아닌 즐거움 또한 느낄 수 있는 법이 없는지를 많은 고민을 했지만 저는 그거 즐기면 좋고 돈도 생기면 좋고 심심할 때 들어오면 좋은 사이트를 만드는 게 목표인 것을  떠 올렸습니다.</p>
  <p> 본 사이트는 방구석 1급 피규어제작자들이 자신의 피규어 자작 피규어를 만들어 다른 사람들이 그걸 보고 인정해 주고 즐거워해주길 봐라는 마음으로 제작되었습니다.</p>
  <p> 중고피규어를 판매하고 제작피규어를 판매하고 그리고 무엇보다도 자작피규어 설정을 만화, 소설, 일러스트 등등 다양한 방법으로 표현해 보세요.!</p>
  <br>
  
  
  <div class="row">
	    <div class="col-sm-4">
	      <p class="text-center"><strong>case 1</strong></p><br>
	      <a href="#demo" data-toggle="collapse">
	        <img src="./../wonsu/images/서브사진2.jpg" class="img-circle person" alt="Random Name" width="80" height="80">
	      </a>
	      <div id="demo" class="collapse">
	        <p>rem</p>
	        <p>Loves rem'</p>
	        <p>Member 김원준 since 1998</p>
	      </div>
	    </div>
	    <div class="col-sm-4">
	      <p class="text-center"><strong>case 2</strong></p><br>
	      <a href="#demo2" data-toggle="collapse">
	        <img src="./../wonsu/images/서브사진3.jpg" class="img-circle person" alt="Random Name" width="80" height="80">
	      </a>
	      <div id="demo2" class="collapse">
	        <p>렘 람</p>
	        <p>Loves oku</p>
	        <p>Member 최수원 since 2019</p>
	      </div>
	    </div>
	    <div class="col-sm-4">
	      <p class="text-center"><strong>case 3</strong></p><br>
	      <a href="#demo3" data-toggle="collapse">
	        <img src="./../wonsu/images/서브사진4.jpg" class="img-circle person" alt="Random Name" width="80" height="80">
	      </a>
	      <div id="demo3" class="collapse">
	        <p>나루토</p>
	        <p>Loves 람진</p>
	        <p>Member 박연호  since 2015</p>
	      </div>
	    </div>
	  </div>
</div>


<!-- Container (TOUR Section) -->
<div id="soo">
<div class="container">
  <h2>Filtering</h2>
  <p>희망하는 제품,제작자,캐릭터를 찾아 원하시는 목록을 쉽게 확인해보세요</p>  
  <input class="form-control" id="myInput" type="text" placeholder="Search..">
  <br>
  <table class="table table-bordered table-striped">
    <thead>
      <tr>
        <th>Expertname</th>
        <th>sellername</th>
        <th>Product name</th>
      </tr>
    </thead>
    <tbody id="myTable">
      <tr>
        <td>John</td>
        <td>Doe</td>
        <td>john@example.com</td>
      </tr>
      <tr>
        <td>Mary</td>
        <td>Moe</td>
        <td>mary@mail.com</td>
      </tr>
      <tr>
        <td>July</td>
        <td>Dooley</td>
        <td>july@greatstuff.com</td>
      </tr>
      <tr>
        <td>Anja</td>
        <td>Ravendale</td>
        <td>a_r@test.com</td>
      </tr>
    </tbody>
  </table>
  <p>Everyone in the world can buy what they want, but few can make what they want....</p>
</div>
     
   <h3 align="center">top3 Expert</h3>   
    
<div class="row text-center">
     <div class="col-sm-4">
        <div class="thumbnail">
          <img src="./../wonsu/images/프로필1.jpg" alt="Paris" width="400" height="300">
          <p><strong>프로필</strong></p>
          <p>닉네임:SyaByMe</p>
          <p>다양한 가면등을 제작하고 판매하고있습니다</p>
          <button class="btn" data-toggle="modal" data-target="#myModal">Buy Click</button>
        </div>
      </div>
    <div class="col-sm-4">
        <div class="thumbnail">
          <img src="./../wonsu/images/프로필2.jpg" alt="New York" width="400" height="300">
          <p><strong>프로필</strong></p>
          <p>닉네임:오라하르콘</p>
          <p>애니피규어를 주종목으로 하고있습니다.</p>
          <button class="btn" data-toggle="modal" data-target="#myModal">Buy Click</button>
        </div>
      </div>
    <div class="col-sm-4">
        <div class="thumbnail">
          <img src="./../wonsu/images/프로필3.jpg" alt="San Francisco" width="400" height="300">
          <p><strong>프로필</strong></p>
          <p>닉네임:내 귀에 유미 시발련아</p>
          <p>동물 피규어 및 애니피규어를 제작판매 하는 중 입니다.</p>
          <button class="btn" data-toggle="modal" data-target="#myModal">Buy Click</button>
        </div>
      </div>
    </div>
 </div> 
  
  <!-- 클릭시 팝업 창 -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
    
      <!-- Modal 팝업창 세부 내용-->
<div class="modal-content">
     <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">×</button>
          <h4><span class="glyphicon glyphicon-lock"></span> BUYS</h4>
       	</div>
    <div class="modal-body">
          <form role="form">
            <div class="form-group">
              <label for="psw"><span class="glyphicon glyphicon-shopping-cart"></span> 원하시는 작품을 검색하세요</label>
              <input type="number" class="form-control" id="psw" placeholder="Search list?">
            </div>
   <div class="form-group">
              <label for="usrname"><span class="glyphicon glyphicon-user"></span> 연락처를 남겨주세요</label>
              <input type="text" class="form-control" id="usrname" placeholder="Enter email">
            </div>
              <button type="submit" class="btn btn-block">Play 
                <span class="glyphicon glyphicon-ok"></span>
              </button>
          </form>
        </div>
  <div class="modal-footer">
          <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal">
            <span class="glyphicon glyphicon-remove"></span> Cancel
          </button>
          <p>Need <a href="#">help?</a></p>
        </div>
      </div>
    </div>
  </div>


<script>
$(document).ready(function(){
  // Initialize Tooltip
  $('[data-toggle="tooltip"]').tooltip(); 
  
  // Add smooth scrolling to all links in navbar + footer link
  $(".navbar a, footer a[href='#myPage']").on('click', function(event) {

    // Make sure this.hash has a value before overriding default behavior
    if (this.hash !== "") {

      // Prevent default anchor click behavior
      event.preventDefault();

      // Store hash
      var hash = this.hash;

      // Using jQuery's animate() method to add smooth page scroll
      // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
      $('html, body').animate({
        scrollTop: $(hash).offset().top
      }, 900, function(){
   
        // Add hash (#) to URL when done scrolling (default click behavior)
        window.location.hash = hash;
      });
    } // End if
  });
})
</script>

</body>
</html>
</layoutTag:layout>