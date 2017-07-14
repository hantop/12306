<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<Meta http-equiv="Content-Type" Content="text/html; Charset=UTF-8">
<title>12306登录</title>
<style type="text/css">
.clearfix:after {
	clear: both;
	content: ".";
	display: block;
	height: 0;
	visibility: hidden;
}

.lay-sear-yp {
	height: 40px;
	margin-top: 10px;
}

.lay-sear {
	background: none repeat scroll 0 0 #EEF1F8;
	border: 1px solid #298CCE;
	border-radius: 3px;
	font-size: 14px;
	height: 40px;
	margin: 10px 0 10px;
	padding: 7px 0;
	position: relative;
}

.clearfix {
	display: block;
}

.inp-txt {
	background: none repeat scroll 0 0 #FFFFFF;
	border: 1px solid #CFCDC7;
	color: #999999;
	height: 35px;
	line-height: 18px;
	padding: 5px 0 5px 5px;
	width: 193px;
}

.btn122s {
	width: 122px;
	background-position: 0 0;
	color: #FFFFFF;
	height: 30px;
	line-height: 30px;
	background: url("./images/bg_btn.png") repeat-x scroll 0 0
		rgba(0, 0, 0, 0);
	border-radius: 4px;
	color: #333333;
	display: inline-block;
	text-align: center;
	text-decoration: none;
	color: white;
}

.t-list {
	border: 1px solid #298cce;
}

.mt10 {
	margin-top: 10px;
}

table {
	table-layout: fixed;
	word-wrap: break-word;
	margin-top: 0;
	background: url(./images/bg_tlisthd.png) top repeat-x;
	border-collapse: collapse;
	border-spacing: 0;
}

thead {
	display: table-header-group;
	vertical-align: middle;
	border-color: inherit;
}

.t-list th {
	height: 52px;
	background: url(./images/line_tlisth.png) right center no-repeat;
	color: #fff;
	overflow: hidden;
}

.t-list td {
	border-right: 1px solid #b0cedd;
	border-top: 1px solid #b0cedd;
	color: #999;
	height: 36px;
	padding: 2px 0;
	text-align: center;
}

div.dhx_modal_cover {
	border: currentColor;
	left: 0;
	top: 0;
	width: 100%;
	height: 100%;
	_height: 0;
	_overflow: hidden;
	position: fixed;
	filter: alpha(opacity = 50);
	opacity: .5;
	z-index: 19999;
	cursor: default;
	zoom: 1;
	background-color: rgba(0, 0, 0, 0.09);
}

.sear-sel-bd {
	border: 1px solid #3391d0;
	height: 44px;
	overflow: hidden;
	position: relative;
	padding: 3px 0;
}
.div-inline{ 
display:inline
} 
.div-font{
font-size : 0.8em;
color : #F79209;
margin-left: 10px;
}
</style>

<link type="text/css" href="./js/station.css" rel="stylesheet" >
<script type="text/javascript" src="js/jquery-1.8.3.js"> </script>
<script type="text/javascript">
	$(document).ready(function(){
		var myDate = new Date();  
		var year =  myDate.getFullYear();    //获取完整的年份(4位,1970-????)  
		var month =  myDate.getMonth()+1;       //获取当前月份(0-11,0代表1月)  
		var day = myDate.getDate();        //获取当前日(1-31)  
		var dd =  myDate.getDay();         //获取当前星期X(0-6,0代表星期天)
		var day2 = null;
		switch(dd){
			case 1:
				day2 = "周一";
				break;
			case 2:
				day2 = "周二";
				break;
			case 3:
				day2 = "周三";
				break;
			case 4:
				day2 = "周四";
				break;
			case 5:
				day2 = "周五";
				break;
			case 6:
				day2 = "周六";
				break;
			default:
				day2 = "周日";
				break;
		}
		var date = "<font style='font-weight: bold;font-size: 16px;color: #000;'>"
		+year+"-"+month+"-"+day+" </font> ( <font style='font-weight: bold;font-size: 20px;color: #000;'>"
		+day2+"</font> )";
		$("#spandate").html(date);
		//alert('${routeInfo.tid}');
	});
</script>
</head>
<body >
	<div>
		<div class="div-inline">
			<div class="div-inline" style="width: 30%" >
				<a href="http://www.12306.cn/"><img alt=""
					src="./images/12306_logo.png"> </a>
				</div>
				<div class="div-inline div-font" style="width: 70%">
					<span class="div-inline" style="color: #666666"><span>意见反馈:<a
							class="cursor colorA" href="mailto:12306yjfk@rails.com.cn">12306yjfk@rails.com.cn</a>
							&nbsp;&nbsp;&nbsp;&nbsp;${uuser.username}先生您好!!!
					</span>
				</div>
				<div class="div-inline div-font">
						<a href="/otn/appDownload/init" target="true">手机版</a>
					</div>
					<div class="div-inline div-font">
					<a href="${pageContext.request.contextPath}/orders_findAll.action" class="menu-bd" id="js-my">我已购买的票<b></b>
					</a>
			</div>
		</div>
	</div>
	<form action="${pageContext.request.contextPath}/ordersVo_orders_save.action" method="post">
		<h3>车次信息</h3>
		<div class="lay-sear lay-sear-yp clearfix" style="text-align: center;">
			<span id="spandate"></span>
			<font style="font-size:20px;font-weight: bold;color: blue"> ${routeInfo.tid}</font> 次
			<font style="font-size:20px;font-weight: bold;color: blue">${routeInfo.fromStation}</font> 站
			（<font style="font-size:20px;font-weight: bold;color: blue">${routeInfo.startime}</font> 开）—
			<font style="font-size:20px;font-weight: bold;color: blue">${routeInfo.toStation}</font> 站
			（<font style="font-size:20px;font-weight: bold;color: blue">${routeInfo.endtime}</font>到）<br/>
			硬座(￥${routeInfo.price})&nbsp;&nbsp;&nbsp;一等座(￥${routeInfo.price*2})&nbsp;&nbsp;&nbsp;特等座(￥${routeInfo.price*3})
		</div>
		<div style="width: 100%" id="title_div"></div>
		<h3>乘客信息</h3>
		<div class="lay-sear lay-sear-yp clearfix" style="text-align: center;">
			<input type="checkbox" name="name" value="${uuser.name}" checked="checked" />${uuser.name}&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
		<h3>座位信息</h3>
		<div class="lay-sear lay-sear-yp clearfix" style="text-align: center;">
			<input type="checkbox" name="seat" value="硬座"  checked="checked" />
			硬座(￥${routeInfo.price})&nbsp;&nbsp;&nbsp;&nbsp;
			 座位号:
			 <font style="font-size: 30px;color: red">${routeInfo.seatnumber}</font>号 &nbsp;
			 <font style="font-size: 30px;color: red">${routeInfo.gnumber}</font>车厢&nbsp;
			 
			 <!-- 传值 -->
			 <input type="hidden" name="train.id" value="${routeInfo.tid}" /> <!-- 车次 -->
			 <input type="hidden" name="ticket.startstation" value="${routeInfo.fromStation}" /><!-- 起始站 -->
			 <input type="hidden" name="ticket.endstation" value="${routeInfo.toStation}" /><!-- 终点站 -->
			 <input type="hidden" name="ticket.seatnumber" value="${routeInfo.seatnumber}" /> <!-- 座位号 -->
			 <input type="hidden" name="ticket.gnumber" value="${routeInfo.gnumber}" /> <!-- 车厢 -->
			 <input type="hidden" name="ticket.price" value="${routeInfo.price}" /> <!-- 价格 -->
			 
			 <input type="hidden" name="startTime" value="${routeInfo.startime}" />
			 <input type="hidden" name="endTime" value="${routeInfo.endtime}" />
			 			 
			<input type="checkbox" name="seat" value="一等座" />一等座(￥${routeInfo.price*2})&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="checkbox" name="seat" value="特等座" />特等座(￥${routeInfo.price*3})&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
		<input type="submit" value="确认购买" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</form>
	<!-- 遮罩 -->
	<div class="dhx_modal_cover" style="display: none; text-align: center margin-top: 20dp;">
		<img alt="" src="./images/loading.gif" style="margin-top: 240px;">
	</div>
</body>
</html>
