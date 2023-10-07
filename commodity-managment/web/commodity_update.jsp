<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改商品</title>
<base href="${pageContext.request.scheme}://${pageContext.request.serverName}:
			${pageContext.request.serverPort}${pageContext.request.contextPath}/">
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
	
	input {
		text-align: center;
	}
	div{
		background-image: url("static/img/6.jpg");
	}
	a:link,a:visited{
		color: black;
		background: wheat;
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
			<img class="logo_img" alt="" src="static/img/3.jpg" width="250" height="90">
			<span class="wel_word">修改商品</span>
			<div>
				<a href="CommodityServlet?way=doGetCommodityList&pageNo=1" style="color: black">商品管理</a>
				<a href="index.jsp" style="color: black">返回首页</a>
			</div>
		</div>
		
		<div id="main">
			<form action="CommodityServlet?way=doUpdateCommodity" method="post">
			<input type="hidden" name="Code"value="${commodity.code}">
				<table>
					<tr>
						<td>商品名称</td>
						<td><input name="Title" type="text" value="${commodity.title}"/></td>
					</tr>
					<tr>
						<td>商品类别</td>
						<td><input name="Category" type="text" value="${commodity.category}"/></td>
					</tr>
					<tr>
						<td>商品单价</td>
						<td><input name="Price" type="text" value="${commodity.price}"/></td>
					</tr>
					<tr>
						<td>商品库存</td>
						<td><input name="Stock" type="text" value="${commodity.stock}"/></td>
					</tr>
					<tr>
						<td colspan="2"> <input type="submit" value="提交"/></td>
					</tr>		
				</table>
			</form>
			
	
		</div>
		
		<div id="bottom">
			<span>
				商品管理.Commodity management &copy;2022
			</span>
		</div>
</body>
</html>