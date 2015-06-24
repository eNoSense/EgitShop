<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib   prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'goodslist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    This is my JSP page. <br>
    <table>
    	<thead>
    		<tr>
    			<td>商品编号</td>
    			<td>商品名称</td>
    			<td>商品价格</td>
    		</tr>
    	</thead>
    	<tbody>
    	<c:forEach items = "${requestScope.goodsList }" var = "goods">
    		<tr>
    			<td>${goods.goodsId}</td>
    			<td>${goods.goodsName}</td>
    			<td>${goods.price }</td>
    			<td><a href = "addToCart?goodsId=${ goods.goodsId}">将商品添加到购物车中</a></td>
    		</tr>	
    	</c:forEach>
    	</tbody>
    </table>
  </body>
</html>
