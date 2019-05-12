<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>选座</title>
<link href="/assets/movie/css/default.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/assets/movie/css/jquery.js"></script>
<link href="/assets/movie/css/sub.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="header">
  <div class="top_img">
    <div class="logo"><a href="#"><img src="/assets/movie/images/logo.gif" width="300" height="80" /></a></div>
    <div class="rx"><img src="/assets/movie/images/topad.gif" width="500" height="100" /></div>
    <div class="top_nav">
      <p><a href="#"> 快速订票系统入口</a> </p>
      <p><a href="#"> 最新优惠活动中心</a></p>
    </div>
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
      <h2>正在上映推荐 </h2>
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
    <div class="pbanner">
      <img src="/movie/getPicById?picId=${schedule.movie.picid}" width="1100" height="180"/>
    </div>
    <div class="right_con">
      <div class="curry">当前位置：<a href="#">电影</a>&nbsp;&nbsp;--&nbsp;&nbsp;<a href="#">蝙蝠侠前传3</a> &nbsp;&nbsp;--&nbsp;&nbsp;确认订购</div>
      <div class="right_content">
        <dl class="contact_list">
          <dt><img src="/assets/movie/images/contact_l.jpg" width="201" height="219" /></dt>
          <dd><img src="/assets/movie/images/order.jpg" width="400" height="80" />
            <input type="hidden" name="scheduleid" id="scheduleid" value="${schedule.scheduleid}"/>
            <p><span>选择影片：</span>${schedule.movie.movename}</p>
            <p><span>放映时间：</span>${schedule.time}</p>
            <p><span>选择影厅：</span>${schedule.hall.hallheats}</p>
            <p><span>电影版本：</span>3D</p>
            <p><span>单张票价：</span>${schedule.price}元</p>
            <p><span>选择座位：</span>
              <select name="setNum" id="setNum" class="xz">
                <c:forEach items="${schedule.hallSetList}" var="hallSet">
                  <c:if test="${!hallSet.isSelect}">
                   <option value="${hallSet.num}">${hallSet.num}</option>
                  </c:if>
                </c:forEach>
              </select></p>
            <p><span>手机号码：</span><input name="" type="text" style="_margin-top:15px;"></p>
            <p><input name="" type="button" class="dgbg022" value="确认选座" onclick="subOrder('/movie/subOrder?scheduleid=${schedule.scheduleid}&setNum=')" />
              <input type="button" onclick="orderInfo('/movie/orderInfo')"  class="dgbg022" value="查看订单"></input>
            </p>
          </dd>
        </dl>
      </div>
    </div>
  </div>
  <div class="clear"></div>
</div>
<script type="text/javascript">
  function subOrder(url){
    var setNum = $("#setNum").val();
    var urls = url+setNum;
    $.ajax({
      type:"get",
      url:urls,
      //data:JSON.stringify(data1),
      contentType:"application/json;charset=utf-8",
      success:function(data){
        //todo 选座完成后续
        location.reload()
      }
    })
  }
  function orderInfo(url) {
    location.href=url;
  }
</script>
</body>
</html>
