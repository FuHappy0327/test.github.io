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
<script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	function delBook(code,title) {
		if(confirm("确定删除【"+title+"】吗")){
			location.href="CommodityServlet?way=doDeleteCommodity&cCode="+code+"&cTitle="+title;
		}
	}
</script>
	<style>
		a:link,a:visited{
			color: darkgrey;
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
			<img class="logo_img" alt="" src="static/img/3.jpg" >
			<span class="wel_word">商品管理系统</span>
			<div>
				<a href="index.jsp" style="color: black">返回首页</a>
			</div>
	</div>
	
	<div id="main" style="background: #fff6d2">
		<form action="CommodityServlet?way=doGetCommodityByTitle" method="post">
			<h4>根据商品名称和编码查询商品:</h4> <input type="text" name="title">
			<input type="submit" value="查询">
			<h3 style="color: blue">${message}</h3>
			<!--由于session狱中的数据，不关闭浏览器会一直存在，所以显示一次后立即删除 -->
			<%
				session.removeAttribute("message");
			%>
		</form>
		<table>
			<tr>
				<td>商品名称</td>
				<td>商品类别</td>
				<td>商品单价</td>
				<td>商品库存</td>
				<td colspan="2">操作</td>
			</tr>
			<!-- 遍历当前页数据-->
			<c:forEach items="${page.list}" var="commodity">
			<tr>
				<td>${commodity.title}</td>
				<td>${commodity.category}</td>
				<td>${commodity.price}</td>
				<td>${commodity.stock}</td>
				<td><a href="CommodityServlet?way=doGetCommodityById&cCode=${commodity.code}" >修改商品</a></td>
				<td><a href="javascript:void(0)" onclick="delBook(${commodity.code},'${commodity.title}')">删除商品</a></td>
			</tr>
			</c:forEach>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="commodity_add.jsp">添加商品</a></td>
			</tr>	
		</table>
		<div id="page_nav">
			<c:if test="${page.pageNo>1}">
				<a href="CommodityServlet?way=doGetCommodityList&pageNo=1">首页</a>
				<a href="CommodityServlet?way=doGetCommodityList&pageNo=${page.pageNo-1}">上一页</a>
			</c:if>
			<c:if test="${page.pageNo<page.getTotalPageNo()}">
				<a href="CommodityServlet?way=doGetCommodityList&pageNo=${page.pageNo+1}">下一页</a>
				<a href="CommodityServlet?way=doGetCommodityList&pageNo=${page.getTotalPageNo()}">末页</a>
			</c:if>
			共${page.getTotalPageNo()}页，${page.totalRecord}条记录 ,
			当前第[<span style="font-size: 20px;color: red;font-weight: 900"
			>${page.pageNo}</span>]页
		</div>
		<div id="bottom">
		<span>
			商品管理.Commodity management &copy;2022
		</span>
		</div>
	</div>
	

</body>
</html>