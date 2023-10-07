<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加商品</title>
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
	/*div{
		background-image: url("static/img/4.jpg");
	}*/
	div{
		background-image: url("static/img/5.jpg");
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
			<img class="logo_img" alt="" src="static/img/3.jpg"width="250" height="90" >
			<span class="wel_word">添加商品</span>
			<div>
				<a href="CommodityServlet?way=doGetCommodityList&pageNo=1" style="color: black">商品管理</a>
				<a href="index.jsp" style="color: black">返回首页</a>
			</div>
		</div>
		
		<div  id="main" >
			<form action="CommodityServlet?way=doAddCommodity" method="post">
				<table>
					<tr>
						<td>商品名称</td>
						<td><input name="cTitle" type="text" value=""/></td>
					</tr>
					<tr>
						<td>商品类别</td>
						<td><input name="cCategory" type="text" value=""/></td>
					</tr>
					<tr>
						<td>商品单价</td>
						<td><input name="cPrice" type="text" value=""/></td>
					</tr>
					<tr>
						<td>商品库存</td>
						<td><input name="cStock" type="text" value=""/></td>
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