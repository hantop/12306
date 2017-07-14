<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增车站</title>
</head>
<body>
	<h3>新增车站信息</h3>
	
	<form action="${pageContext.request.contextPath }/station_save.action" method="post">
		<table>
		<tr>
			<td>车站代码</td>
			<td><input type="text" name="id" value="11"></td>
		</tr>
		<tr>
			<td>车站名</td>
			<td><input type="text" name="name" value="TT"></td>
		</tr>
			<tr>
			<td>拼音码</td>
			<td><input type="text" name="pinyin" value="XG"></td>
		</tr>
		</tr>
			<tr>
			<td>所属行政区</td>
			<td><input type="text" name="region" value="XG"></td>
		</tr>
		</tr>
			<tr>
			<td>车站等级</td>
			<td><input type="text" name="range" value="XG"></td>
		</tr>
		</tr>
			<tr>
			<td>所属铁路局</td>
			<td><input type="text" name="company" value="XG"></td>
		</tr>
		</tr>
			<tr>
			<td>联系地址</td>
			<td><input type="text" name="address" value="XG"></td>
		</tr>
		<tr>
			<td><input type="submit" value="新增"></td>
			<td><input type="reset" value="重置"></td>
		</tr>

	</table>
	</form>
</body>
</html>