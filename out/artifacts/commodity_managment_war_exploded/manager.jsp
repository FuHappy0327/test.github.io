<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品管理</title>
<base href="${pageContext.request.scheme}://${pageContext.request.serverName}:
			${pageContext.request.serverPort}${pageContext.request.contextPath}/">
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	div{
		background-image: url("static/img/1.jpg");
	}
	a:link,a:visited{
		color: black;
		/*background: wheat;*/
		/*display: block;*/
		text-decoration: none;
		text-align: center;

	}
	a:hover,a:active{
		background: white;
	}
</style>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/3.jpg" width="250" height="80">
			<span class="wel_word">商品管理系统</span>
			<div>
				<%-- 点击商品管理 进入CommodityServlet 调用doGetCommodityList方法,并且传入页码1--%>
				<a href="CommodityServlet?way=doGetCommodityList&pageNo=1" style="color: black">商品管理</a>
				<span>&nbsp&nbsp&nbsp</span>
				<!--<a href="index.jsp">返回首页</a>-->
			</div>
	</div>
	
	<div id="main" style="color: #ffe57d">
		<h1  style="font-size: 50px;line-height: 300px">欢迎进入商品管理系统</h1>
	</div>
	
	<div id="bottom">
		<span>
			商品管理.Commodity management &copy;2022
		</span>
	</div>
</body>
</html>