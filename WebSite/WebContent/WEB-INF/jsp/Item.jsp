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
    <title>商品一覧</title>

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
    			<a class="fas fa-user-circle"class="nav-link" href="LoginServlet" style="font-size: 30px; color:#FFF; margin-right: 20px;margin-left: 20px"></a>
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





      <div class="btn-group" style= "margin-top: 100px">
  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
   サイズ
  </button>
  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
    <a class="dropdown-item" href="#">ミトン</a>
    <a class="dropdown-item" href="#">ウォッシュタオル</a>
    <a class="dropdown-item" href="#">ハンドタオル</a>
    <a class="dropdown-item" href="#">フェイスタオル</a>
    <a class="dropdown-item" href="#">子供用バスタオル</a>
    <a class="dropdown-item" href="#">バスタオル</a>
    <a class="dropdown-item" href="#">ビッグバスタオル</a>


  </div>
</div>

<div class="btn-group" style= "margin-top: 100px">
<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    カラー
  </button>
  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
    <a class="dropdown-item" href="#">イエロー</a>
    <a class="dropdown-item" href="#">ブルー</a>
    <a class="dropdown-item" href="#">ホワイト</a>
    <a class="dropdown-item" href="#">グレー</a>
     <a class="dropdown-item" href="#">モーブ</a>
      <a class="dropdown-item" href="#">ブラウン</a>
       <a class="dropdown-item" href="#">パープル</a>
        <a class="dropdown-item" href="#">オレンジ色</a>
         <a class="dropdown-item" href="#">ピンク</a>
          <a class="dropdown-item" href="#">グリーン</a>
           <a class="dropdown-item" href="#">ナチュラル</a>
  </div>
</div>
<div class="btn-group" style= "margin-top: 100px; margin-left:10px">
<span class="align-baseline">価格：</span><a href="#">高い順</a><span class="align-baseline">｜</span><a href="#">安い順</a>
</div>
<div class="btn-group" style= "margin-top: 100px;margin-left:10px">
<button type="button" class="btn btn-outline-secondary">消去</button>
</div>

<div class="btn-group" style= "margin-top: 100px;margin-left:40px">
<form action="ItemSerchResultServlet" method="post" class="form-inline mt-2 mt-md-0">
        <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search" name="word">
        <button class="btn btn-outline-secondary my-2 my-sm-0" type="submit">Search</button>
      </form></div>




<div class="row" style= "margin-top: 100px;margin-left:40px;margin-right:40px">
<c:forEach var="item" items="${itemDataList}" >
<div class="col s12 m3">

<div class="card" style="width: 20rem">

<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img class="d-block w-100" src="img/${item.fileName.get(0)}" alt="First slide">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="img/${item.fileName.get(1)}" alt="Second slide">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="img/${item.fileName.get(2)}" alt="Third slide">
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


  <div class="card-body">
    <p class="card-text">${item.itemName}</p>
    <p class="card-text">${item.price}円</p>


    <c:if test="${loginUser !=null}">
    <form action="FavoriteServlet" method="post"><input type="hidden" name="itemDetailId" value="${item.itemDetailId}"><input type="hidden" name="userId" value="${loginUser.userId}">

    <c:if test="${item.favoriteFlg == false}">
    <button type="submit" value="addFavorite" class="far fa-star" style="color: black" onclick="{alert('お気に入りに追加しました')}"></button>
    </c:if>
    <c:if test="${item.favoriteFlg}">
    <button type="submit" value="deleteFavorite" class="fas fa-star" style="color: black" onclick="{alert('お気に入りから削除しました')}"></button>
    </c:if>
    </form></c:if>


  </div>
  </div>
</div>

</c:forEach></div>



  <div class="row">
  <div class="col-md-2 offset-md-5">



  <a href="IndexServlet"><button type="button" class="btn btn-secondary" style="margin-top: 60px">HOMEへ戻る</button></a>
   </div></div>



<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>