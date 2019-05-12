<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>电影简介</title>
<link href="/assets/movie/css/default.css" rel="stylesheet" type="text/css" />
<link href="/assets/movie/css/sub.css" rel="stylesheet" type="text/css" />
<style type="text/css">
#nav_content table{ margin:0 auto;  border: 1px solid #ccc; border-collapse: collapse;}
#nav_content th,#nav_content td {border: 1px solid #ccc; height: 42px; line-height: 42px; text-align:center;}
#nav_content tbody th {
    background: none repeat scroll 0 0 #F7F7F7;
    color: #000;
	height:30px;
	line-height:30px;
	font-weight:bold;
    text-align: center;
}
</style>
<script>
var net={};
net.tab={};
if (typeof($) == 'undefined') {
  $ = function(elem) {
    if (arguments.length > 1) {
      for (var i = 0, elems = [], length = arguments.length; i < length; i++)
        elems.push($(arguments[i]));
      return elems;
    }
    if (typeof elem == 'string') {
      return document.getElementById(elem);
    } else {
    	return elem;
    }
  };
}
//按钮点击时事件
net.tab.objSelect=function(clickobj,obj,elems){
	for(var i=0;i<obj.length;i++)
	{
		obj[i].className="";
		elems[i].style.display="none";
	}
	clickobj.className="selected";
	elems[clickobj.getAttribute("name")].style.display="";
}
//初始话按钮状态
//参数elem:按钮标签id
//参数num:初始时选中标签
net.tab.menuEvent=function(elem,num){
	var objs=$(elem).getElementsByTagName("li");
	var conobjs=$(elem+"_content").getElementsByTagName("div");
	objs[num].className="selected";
	conobjs[num].style.display="";
	net.tab.addEvent(objs,function (){
		net.tab.objSelect(this,objs,conobjs);
	});
}
//添加按钮事件
net.tab.addEvent=function(elems,fun){
	for (var i=0;i<elems.length;i++)
	{
		elems[i].setAttribute("name",i);
		elems[i].onclick=fun;
	}
}
window.onload=function(){
	net.tab.menuEvent("nav",0)
}
</script>
</head>
<body>
<div class="header">
  <div class="top_img">
    <div class="logo"><a href="#"><img src="/assets/movie/images/logo.gif" width="300" height="80" /></a></div>
    <div class="rx"><img src="/assets/movie/images/topad.gif" width="500" height="100" /></div>
    <div class="clear"></div>
  </div>
  <div class="menu">
    <ul>
      <li id="a1"><a href="index.html">首　页</a></li>
      <li id="a2"> <a href="websj.html">热门影片</a></li>
      <li id="a3"><a href="case.html">正在热映</a></li>
      <li id="a4"><a href="product.html">即将上映</a></li>
      <li id="a5"><a href="list.html">经典回味</a></li>
      <li id="a6"><a href="tuiguang.html">全球首映</a></li>
      <li id="a7"><a href="#">热门活动</a></li>
      <li id="a8"><a href="sub.html">优惠专区</a></li>
      <li id="a9"><a href="contact.html">放映时刻表</a></li>
    </ul>
  </div>
</div>
<div class="contenter">
  <div class="left">
    <div class="right_4">
      <h2><span><a href="#"> 更多影片 </a></span>正在上映推荐 </h2>
      <div class="inner022">
        <table width="100%" cellspacing="0" cellpadding="0" border="0">
          <tbody>
          <c:forEach items="${movieList}" var="movie">
              <tr>
                  <td height="135" align="center" width="140"><a href="/movie/videoInfo?movieid=${movie.moveid}"><img src="/movie/getPicById?picId=${movie.picid}" width="120" height="100" /></a></td>
                  <td><a href="#">${movie.movename}</a><p>导演:${movie.actor}</p></td>
              </tr>
          </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
    <div class="ad01"></div>
  </div>
  <div class="right">
    <div class="right_con">
      <div class="curry">当前位置：<a href="#">电影</a>&nbsp;--&nbsp;<a href="#"> ${movie.movename}</a></div>
      <div class="right_content">
        <div class="product_info">
          <div class="product_info_xx">
            <div class="product_info_img" align="center"> <img src="/movie/getPic?path=${movie.pic.picurl}"  /> </div>
            <div class="lineh_255" style="padding-left:10px;">
            <div class="t_14">${movie.movename}</div>
              <p><span>导演：</span>${movie.actor}</p>
              <p><span>主演：</span>${movie.actor}</p>
              <p><span>类型：</span>${movie.type.typename}</p>
              <p><span>国家：</span>${movie.language}</p>
              <p><span>片长：</span>118分钟</p>
              <p><span>上映日期：</span></p>
              <p><span>剧情简介：</span>${movie.director}</p>
            </div>
          </div>
        <div class="taber">
        <div id="nav">
            <ul>
                <li>影片排期</li>
                <li>大幅剧照</li>
                <li>故事梗概</li>
                <li>部分影评</li>
            </ul>
        </div>
<div id="nav_content">
   	<div style="display:none">
        <table style="width:100%;" >
        <tbody>
            <tr>
                <th width="15%">放映时间</th>
                <th width="15%">影厅空位</th>
                <th width="15%">语言</th>
                <th width="15%">版本</th>
                <th width="15%">票价</th>
                <th width="25%">购票</th>
            </tr>
            <c:forEach items="${scheduleList}" var="schedule" >
            <tr>
            	<td>${schedule.time}</td>
                <td>${schedule.hall.hallheats}</td>
                <td>${schedule.movie.language}</td>
                <td>${schedule.time}</td>
                <td>${schedule.price}</td>
                <td><a href="/movie/selectSet?scheduleid=${schedule.scheduleid}" type="button" class="dgbg02">马上选座</a></td>
            </tr>
            </c:forEach>
        </tbody>
    </table></div>
	<div style="display:none"><img src="/movie/getPic?path=${movie.pic.picurl}" width="650" height="436" /></div>
   	<div style="display:none">${movie.director}</div>
	<div style="display:none">${movie.director}</div>
        </div>
        <!--taber-->
        </div>
         
        </div>
      </div>
    </div>
  </div>
  <div class="clear"></div>
</div>
</body>
</html>
