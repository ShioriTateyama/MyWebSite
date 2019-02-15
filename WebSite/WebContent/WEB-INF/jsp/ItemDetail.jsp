<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>商品詳細</title>

    <!-- Bootstrap core CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="signin.css" rel="stylesheet">
  </head>

  <body class="text-center" >
  <header>
  <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="#">SHIORI</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <a class="nav-link" href="IndexServlet">Home <span class="sr-only">(current)</span></a>
        </li>

       <li class="nav-item">


        <c:if test="${loginUser == null}" >
    			<a class="fas fa-user-circle"class="nav-link" href="LoginServlet" style="font-size: 30px; color:#FFF; margin-right: 20px;margin-left: 20px"></a>
    	</c:if>

    	<form action="UserDataServlet" method="post">

    	<c:if test="${loginUser !=null}">
    	<a class="fas fa-user-circle"class="nav-link" href="UserDataServlet?userId=${loginUser.userId}" style="font-size: 30px; color:#FFF; margin-right: 20px;margin-left: 20px">

    	</a>
    	</c:if>

    	</form>


  			</li>
  		<li class="nav-item">
    			<a  class="fas fa-shopping-cart"class="nav-link" href="CartServlet" style="font-size: 30px; color:#FFF; margin-right: 10px"><span style="margin-right: 2rem"></span></a>
  			</li>

<li class="nav-item active">
          <a class="nav-link" href="ItemServlet?categoryId=1">TOWELS<span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item active">
          <a class="nav-link" href="ItemServlet?categoryId=2">BATHMATS<span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item active">
          <a class="nav-link" href="ItemServlet?categoryId=3">BATHROBES<span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item active">
          <a class="nav-link" href="ItemServlet?categoryId=4">ACCESSORIES<span class="sr-only">(current)</span></a>
        </li>


      </ul>







    </div>
  </nav>
</header>






<div class="btn-group" style= "margin-top: 100px;margin-left:40px">
<form action="ItemSearchResultServlet" method="post" class="form-inline mt-2 mt-md-0">
        <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search" name="word">
        <button class="btn btn-outline-secondary my-2 my-sm-0" type="submit" value="search">Search</button>
      </form></div>



<div class="row">
<div class="col">
<div id="carouselExampleControls" class="carousel slide data-ride" style="width: 30rem;margin-left:400px ;margin-top: 50px">

  <div class="carousel-inner">
    <div class="carousel-item active">
      <img class="d-block w-100" src="img/${itemDetailData.fileName.get(0)}" alt="First slide">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="img/${itemDetailData.fileName.get(1)}" alt="Second slide">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="img/${itemDetailData.fileName.get(2)}" alt="Third slide">
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
</div>

<div class="col">
  <div style= "margin-top: 200px">
    <h3>${itemDetailData.itemName}</h3>
    <h3>${itemDetailData.price}円</h3>


  </div>

  <form action="ItemAddServlet" method="post" style="margin-top: 20px">

  <input type="hidden" name="itemDetailId" value="${itemDetailData.itemDetailId}">

  <input type="hidden" name="categoryId" value="${itemDetailData.categoryId}">

<div class="row">
<div class="col-md-2 offset-md-5">

<c:if test="${itemDetailData.categoryId !=3 }">
	<input type="hidden" name="sizeId" value="${itemDetailData.sizeId}">

    	数量<input type="number" name="quantity" min="1" max="30" value="1">
    	</c:if>

    	<c:if test="${itemDetailData.categoryId ==3 }">
<div class="form-group">
    <label for="exampleFormControlSelect1">サイズ</label>
    <select name="sizeId" class="form-control" id="exampleFormControlSelect1">
      <option value="20">S</option>
      <option value="15">M</option>
      <option value="16">L</option>
      <option value="17">XL</option>

    </select>
  </div>
    	数量<input type="number" name="quantity" min="1" max="30" value="1">
    	</c:if>




  	</div>
  	</div>





<div class="row">
<div class="col-md-4 offset-md-4">

  	<button class="btn btn-dark btn-block" type="submit" style= "margin-top: 20px">買い物カゴに追加する</button></div>
  	</div></form>

<c:if test="${loginUser !=null}">
  	<form action="FavoriteServlet" method="post" style="margin-top: 50px">
  	<input type="hidden" name="itemDetailId" value="${itemDetailData.itemDetailId}"><input type="hidden" name="userId" value="${loginUser.userId}"><input type="hidden" name="favorite" value="favorite">
  	お気に入り<p></p>
  	<c:if test="${itemDetailData.favoriteFlg == false}">
    <button type="submit" value="addFavorite" class="far fa-star" style="color: black" onclick="{alert('お気に入りに追加しました')}"></button>
    </c:if>
    <c:if test="${itemDetailData.favoriteFlg}">
    <button type="submit" value="deleteFavorite" class="fas fa-star" style="color: black" onclick="{alert('お気に入りから削除しました')}"></button>
    </c:if>
    </form></c:if>



  	<div class="row">
<div class="col-md-6 offset-md-3" style= "margin-top: 20px">
  	<p>${itemDetailData.detail}</p>

</div>
  	</div>

</div>
</div>









<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>