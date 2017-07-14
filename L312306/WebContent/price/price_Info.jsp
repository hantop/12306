<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>票价信息</title>
</head>
<body>
<h3>票价信息管理</h3>
	<table border="1">
		<tr>
			<td>票价率编号</td>
			<td>车厢类型</td>
			<td>车厢车体类型</td>
			<td>席位类型</td>
			<td>票价率</td>
			<td>比例</td>
		</tr>
		<c:forEach items="${priceListFromServer}" var="st">
			<tr>
				<td>${st.id }</td>
				<td>${st.traintype }</td>
				<td>${st.trainbodytype }</td>
				<td>${st.seattype }</td>
				<td>${st.rate}</td>
				<td>${st.scale }</td>
				<td>
				<a href="${pageContext.request.contextPath }/price_delete.action?id=${st.id }" onClick="return confirm('是否确定删除？');">删除</a> 
				<a href="${pageContext.request.contextPath }/price_find_findById.action?id=${st.id }&type=update">更新</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="${pageContext.request.contextPath }/price/price_save.jsp">新增车票</a>
	<br />
	<br />
	<form action="${pageContext.request.contextPath }/price_find_findById.action" method="post">
		车票编号：<input type="text" name="id"> 
		<input type="submit" value="根据编号查询" />
	</form>
</body>
</html>