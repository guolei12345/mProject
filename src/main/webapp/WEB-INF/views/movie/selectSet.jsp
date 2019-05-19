<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>选座</title>
<link href="/assets/movie/css/default.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/assets/movie/css/jquery.js"></script>
<link href="/assets/movie/css/sub.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="/assets/movie/css/reset.css" />
    <script type="text/javascript" src="/assets/movie/js/jquery.min.js"></script>
    <script type="text/javascript" src="/assets/movie/js/jquery.seat-charts.min.js"></script>
</head>
<body>
<div class="header">
  <div class="top_img">
    <div class="logo"><a href="#"><img src="/assets/movie/images/logo.gif" width="300" height="80" /></a></div>
    <div class="clear"></div>
  </div>
  <div class="menu">
    <ul>
        <li id="a1"><a href="/movie/index">首　页</a></li>
        <li id="a2"> <a href="/movie/index?url=index_aq">爱情</a></li>
        <li id="a3"><a href="/movie/index?url=index_dz">动作</a></li>
        <li id="a4"><a href="/movie/index?url=index_fz">犯罪</a></li>
        <li id="a5"><a href="/movie/index?url=index_gz">古装</a></li>
        <li id="a6"><a href="/movie/index?url=index_gw">国外</a></li>
        <li id="a7"><a href="/movie/index?url=index_jq">剧情</a></li>
        <li id="a8"><a href="/movie/index?url=index_kh">科幻</a></li>
        <li id="a9"><a href="/movie/index?url=index_kb">恐怖</a></li>
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
        <%--座位--%>
        <table>
            <tr>
                <c:forEach items="${schedule.hallSetList}" var="setNum">
                <td>
                    <c:if test="${!setNum.isSelect}">
                        <a style="color: #3e8f3e" href="#"class="btn btn-xs btn-success seatCharts-seat seatCharts-cell available" onclick="optionMovie('/movie/subOrder?scheduleid=${schedule.scheduleid}&setNum=${setNum.num}')">${setNum.num}</a>
                    </c:if>
                    <c:if test="${setNum.isSelect}">
                        <a style="color: #8a3104" class="btn btn-xs btn-info seatCharts-seat seatCharts-cell available" href="#" >${setNum.num}</a>
                    </c:if>
                </td>
                <c:if test="${setNum.num%10==0}">
            </tr><tr>
            </c:if>
            </c:forEach>
        </table>
    </div>
    <div class="right_con">
      <div class="curry">当前位置：<a href="#">电影</a>&nbsp;&nbsp;--&nbsp;&nbsp;<a href="#">${schedule.movie.movename}</a> &nbsp;&nbsp;--&nbsp;&nbsp;${msg}</div>
      <div class="right_content">
        <dl class="contact_list">
          <dt><img src="/assets/movie/images/contact_l.jpg" width="201" height="219" /></dt>
          <dd>
              <%--<img src="/assets/movie/images/order.jpg" width="400" height="80" />--%>
            <input type="hidden" name="scheduleid" id="scheduleid" value="${schedule.scheduleid}"/>
            <p><span>选择影片：</span>${schedule.movie.movename}</p>
            <p><span>放映日期：</span>${schedule.time}</p>
            <p><span>具体时间：</span>${schedule.colum1}--${schedule.colum2}</p>
            <p><span>选择影厅：</span>${schedule.hall.hallheats}</p>
            <p><span>电影版本：</span>3D</p>
            <p><span>单张票价：</span>${schedule.price}元</p>

            <p><input type="button" onclick="orderInfo('/movie/orderInfo')"  class="dgbg022" value="查看订单"></input></p>
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
  function optionMovie(url){
      $.ajax({
          type:"get",
          url:url,
          //data:JSON.stringify(data1),
          contentType:"application/json;charset=utf-8",
          success:function(){
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
