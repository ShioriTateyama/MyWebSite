<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>ユーザー情報更新確認</title>

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




<form action="ItemSearchResultServlet" method="post" class="form-inline mt-2 mt-md-0">
        <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search" name="word">
        <button class="btn btn-outline-secondary my-2 my-sm-0" type="submit" value="search">Search</button>
      </form></div>
  </nav>
</header>






 <h3 class="text-center" style= "margin-top: 200px; margin-bottom: 100px">入力内容確認</h3>
<div class="container">
 <table class="table table-bordered">

 <c:if test="${updateUser != null}">

  <tbody>
    <tr>
      <th scope="row">名前</th>
      <td>${updateUser.name}</td>

    </tr>
    <tr>
      <th scope="row">ログインID</th>
      <td>${updateUser.loginId}</td>

    </tr>
    <tr>
      <th scope="row">住所</th>
      <td >${updateUser.address}</td>

    </tr>
     <tr>
      <th scope="row">パスワード</th>
      <td >${updateUser.password}</td>

    </tr>
  </tbody></c:if>

  <c:if test="${withoutPassword != null}">

  <tbody>
    <tr>
      <th scope="row">名前</th>
      <td>${withoutPassword.name}</td>

    </tr>
    <tr>
      <th scope="row">ログインID</th>
      <td>${withoutPassword.loginId}</td>

    </tr>
    <tr>
      <th scope="row">住所</th>
      <td >${withoutPassword.address}</td>

    </tr>

  </tbody></c:if>


</table>
</div>
<p  class="text-center" style= "margin-top: 40px">上記内容で更新してよろしいでしょうか?</p>

<form action="UserUpdateConfirmServlet" method="post">

<c:if test="${updateUser != null}">
<input type="hidden" name="userId" value="${updateUser.userId}">
<input type="hidden" name="loginId" value="${updateUser.loginId}">
<input type="hidden" name="name" value="${updateUser.name}">
<input type="hidden" name="address" value="${updateUser.address}">
<input type="hidden" name="password" value="${updateUser.password}">
</c:if>

<c:if test="${withoutPassword != null}">
<input type="hidden" name="userId" value="${withoutPassword.userId}">
<input type="hidden" name="loginId" value="${withoutPassword.loginId}">
<input type="hidden" name="name" value="${withoutPassword.name}">
<input type="hidden" name="address" value="${withoutPassword.address}">

</c:if>
  <button type="submit" class="btn btn-secondary" name="cancel" value="cancel" style="margin-top: 60px ; margin-right:30px">戻る</button>
  <button type="submit" class="btn btn-secondary" name="update" value="update" style="margin-top: 60px; margin-left:30px">更新</button></form>





</body>
</html>