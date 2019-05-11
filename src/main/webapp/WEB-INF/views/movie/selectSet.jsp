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
      <h2><span><a href="#"> 更多影片 </a></span>正在上映推荐 </h2>
      <div class="inner022">
        <table width="100%" cellspacing="0" cellpadding="0" border="0">
          <tbody>
            <tr>
              <td width="140" height="135" align="center"><a href="#"><img width="120" height="100" src="/assets/movie/images/index_r_03_seo.gif"></a></td>
              <td><a href="#">超凡蜘蛛侠</a>
                <p>主演:成龙、谢霆锋</p></td>
            </tr>
            <tr>
              <td width="140" height="135" align="center"><a href="#"><img width="120" height="100" src="/assets/movie/images/index_r_03_seo2.gif"></a></td>
              <td><a href="#">复仇者联盟</a>
                <p>主演:周星驰、梁朝伟</p></td>
            </tr>
            <tr>
              <td width="140" height="135" align="center"><a href="#"><img width="120" height="100" src="/assets/movie/images/index_r_03_seo3.gif"></a></td>
              <td><a href="#">枕边凶灵</a>
                <p>主演:安德鲁·加菲尔德</p></td>
            </tr>
            <tr>
              <td width="140" height="135" align="center"><a href="#"><img width="120" height="100" src="/assets/movie/images/index_r_03_seo4.gif"></a></td>
              <td><a href="#">疯魔美女2</a>
                <p>主演:张静初·李冰冰</p></td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
    <div class="ad01"></div>
    <div class="left_2 top20px">
      <h2>公司新闻</h2>
      <div class="left_2_con">
        <ul class="sub_list">
          <li><a href="#">领悟科技、悟科技有限公司</a></li>
          <li><a href="#">河南郑州市金水区活动... </a></li>
          <li><a href="#">2010-10-30河南... </a></li>
          <li><a href="#">郑州金城国际广场.研讨会成功... </a></li>
          <li><a href="#"> 10年11月29日领悟科技... </a></li>
        </ul>
      </div>
    </div>
  </div>
  <div class="right">
    <div class="pbanner"><script language='javascript'>
				linkarr = new Array();
				picarr = new Array();
				textarr = new Array();
				var swf_width=728;
				var swf_height=190;
				var files = "";
				var links = "";
				var texts = "";
				
				//这里设置调用标记
				linkarr[1] = "http://www.baidu.com";
				picarr[1]  = "/assets/movie/images/b02.jpg";
				textarr[1] = "";
				linkarr[2] = "http://www.baidu.com";
				picarr[2]  = "/assets/movie/images/b01.jpg";
				textarr[2] = "";
					linkarr[3] = "http://www.baidu.com";
				picarr[3]  = "/assets/movie/images/b03.jpg";
				textarr[3] = "";
			
				
				for(i=1;i<picarr.length;i++){
				  if(files=="") files = picarr[i];
				  else files += "|"+picarr[i];
				}
				for(i=1;i<linkarr.length;i++){
				  if(links=="") links = linkarr[i];
				  else links += "|"+linkarr[i];
				}
				for(i=1;i<textarr.length;i++){
				  if(texts=="") texts = textarr[i];
				  else texts += "|"+textarr[i];
				}
				document.write('<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0" width="'+ swf_width +'" height="'+ swf_height +'">');
				document.write('<param name="movie" value="/assets/movie/images/bcastr3.swf"><param name="quality" value="high">');
				document.write('<param name="menu" value="false"><param name=wmode value="opaque">');
				document.write('<param name="FlashVars" value="bcastr_file='+files+'&bcastr_link='+links+'&bcastr_title='+texts+'">');
				document.write('<embed src="/assets/movie/images/bcastr3.swf" wmode="opaque" FlashVars="bcastr_file='+files+'&bcastr_link='+links+'&bcastr_title='+texts+'& menu="false" quality="high" width="'+ swf_width +'" height="'+ swf_height +'" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" />'); document.write('</object>'); 
				</script></div>
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
            <%--<p><span>订购张数：</span><select name="" class="xz">--%>
              <%--<option selected="selected">订购1张</option>--%>
              <%--<option>订购2张</option>--%>
              <%--<option>订购3张</option>--%>
              <%--<option>订购4张</option>--%>
            <%--</select></p>--%>
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
