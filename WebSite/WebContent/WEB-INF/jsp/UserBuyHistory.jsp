<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>購入履歴一覧</title>

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

      <form class="form-inline mt-2 mt-md-0">
        <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Search</button>
      </form>

    </div>
  </nav>
</header>







  <div class="col-md-2 offset-md-10">



  <a href="UserDataServlet"><button type="button" class="btn btn-secondary" style="margin-top: 100px">ユーザー情報へ戻る</button></a>
   </div>




 <h3 class="text-center" style= "margin-top: 100px; margin-bottom: 100px">購入履歴一覧</h3>

<div class="container">
 <table class="table table-bordered">
  <thead>
    <tr>
      <th scope="col"></th>
      <th scope="col">購入日時</th>
      <th scope="col">金額</th>

    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row"><a href="UserBuyHistoryDetail?buy_id=？" class="btn-floating btn waves-effect waves-light ">詳細<i class="far fa-hand-point-right"></i></a></th>
      <td>2019-01-22 22:29</td>
      <td>9990円</td>


    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Jacob</td>
      <td>Thornton</td>

    </tr>
    <tr>
      <th scope="row">3</th>
      <td>Larry</td>
      <td>the Bird</td>

    </tr>
  </tbody>


</table>
</div>




</body>
</html>



