<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%--<link href="/assets/movie/css/bootstrap.min.css" rel="stylesheet" />--%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>电影售票系统-首页</title>
<link href="/assets/movie/css/default.css" rel="stylesheet" type="text/css" />
<link href="/assets/movie/css/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/assets/movie/css/jquery.js"></script>
<script language="javascript" type="text/javascript" src="/assets/movie/css/yao.js"></script>

<!-- 滑动门 -->
<script  type="text/javascript">   

function scrollDoor(){
}
scrollDoor.prototype = {
	sd : function(menus,divs,openClass,closeClass){
		var _this = this;
		if(menus.length != divs.length)
		{
			alert("菜单层数量和内容层数量不一样!");
			return false;
		}				
		for(var i = 0 ; i < menus.length ; i++)
		{	
			_this.$(menus[i]).value = i;				
			_this.$(menus[i]).onmouseover = function(){
					
				for(var j = 0 ; j < menus.length ; j++)
				{						
					_this.$(menus[j]).className = closeClass;
					_this.$(divs[j]).style.display = "none";
				}
				_this.$(menus[this.value]).className = openClass;	
				_this.$(divs[this.value]).style.display = "block";				
			}
		}
		},
	$ : function(oid){
		if(typeof(oid) == "string")
		return document.getElementById(oid);
		return oid;
	}
}
window.onload = function(){
	var SDmodel = new scrollDoor();
	SDmodel.sd(["m01","m02","m03"],["c01","c02","c03"],"sd01","sd02");

}
</script>
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
        <li id="a6"><a href="/movie/index?url=index_xj">喜剧</a></li>
        <li id="a7"><a href="/movie/index?url=index_jq">剧情</a></li>
      <li id="a8"><a href="/movie/index?url=index_kh">科幻</a></li>
      <li id="a9"><a href="/movie/index?url=index_kb">恐怖</a></li>
    </ul>
  </div>
</div>
<div class="banner">
  <div id="YFocus">
    <div id="YImage">
      <p id="YPhotos">
          <c:forEach items="${sydklbt}" var="movie">
          <a href="/movie/videoInfo?movieid=${movie.moveid}"><img src="/movie/getPic?path=${movie.pic.picurl}" alt="22" />
              </c:forEach>
      </p>
    </div>
    <p id="YSamples">
        <c:forEach items="${sydklbt}" var="movie">
            <a href="/movie/videoInfo?movieid=${movie.moveid}"><img src="/movie/getPic?path=${movie.pic.picurl}" alt="22" />
        </c:forEach>
        <%--<a href="#1" class="current" title="2"><img src="/assets/movie/images/bx5.jpg" alt="22" /></a> <a href="#1" title="2"><img src="/assets/movie/images/bx1.jpg" alt="2" /></a> <a href="#1" title="2"><img src="/assets/movie/images/bx3.jpg" alt="2" /></a> <a href="#1" title="2"><img src="/assets/movie/images/bx4.jpg" alt="2" /></a> </p>--%>
  </div>
  <script language="javascript" type="text/javascript">
<!--
	YAO.YTabs({
		tabs: YAO.getEl('YSamples').getElementsByTagName('img'),
		contents: YAO.getEl('YPhotos').getElementsByTagName('img'),
		auto: true,
		scroll: true,
		scrollId: 'YPhotos'
	});
//-->
</script> 
</div>
<div class="contenter">
  <div class="left">
    <div class="left_1">
      <h2><span><a href="#">更多热映大片</a></span>全球抢先看 >></h2>
      <div class="left_1_con">
        <div class="left_1_l">
          <div class="scrolldoorFrame">
            <ul class="scrollUl">
              <c:forEach items="${syzklbt}" var="movie" varStatus="idx">
              <li class="sd0${idx.index+1}" id="m0${idx.index+1}"><a href="#">
                <dl class="hd_list">
                  <dt><img src="/movie/getPic?path=${movie.pic.picurl}" width="81" height="35" /></dt>
                  <dd>${movie.movename}</dd>
                  <dd>${movie.language}</dd>
                </dl>
                </a>
              </li>
              </c:forEach>
            </ul>
            <div class="cont">
              <c:forEach items="${syzklbt}" var="movie" varStatus="idx">
                <div id="c0${idx.index+1}"><a href="/movie/videoInfo?movieid=${movie.moveid}"><img src="/movie/getPic?path=${movie.pic.picurl}" width="449" height="193" /></a></div>
                </c:forEach>
            </div>
          </div>
        </div>
        <div class="left_1_r">
          <h3>热映大片</h3>
          <dl>
            <dt><a href="/movie/videoInfo?movieid=${syzklbt[0].moveid}"><img src="/movie/getPic?path=${syzklbt[0].pic.picurl}" width="80" height="65" /></a></dt>
            <dd><strong>${syzklbt[0].movename}</strong> <br />
              <a href="/movie/videoInfo?movieid=${syzklbt[0].moveid}">${syzklbt[0].director}</a></dd>
          </dl>
          <div class="clear"></div>
          <ul>
            <c:forEach items="${syzklbt}" var="movie" varStatus="idx">
            <li><a href="/movie/videoInfo?movieid=${movie.moveid}"><span>${movie.movename}</span>${movie.language} </a></li>
            </c:forEach>
          </ul>
        </div>
        <div class="clear"></div>
      </div>
    </div>
    <div class="left_4 top10px" style="height:auto;">
      <h2><a href="#">动作</a><span> ---- 畅享影业帮助您快速购票、享受便捷网络购票体验 </span></h2>
      <div class="inner">
        <c:forEach items="${dz}" var="movie">
        <dl class="anli_list">
          <dt><a href="/movie/videoInfo?movieid=${movie.moveid}"><img src="/movie/getPic?path=${movie.pic.picurl}" width="150" height="100" /></a></dt>
          <dd><a href="/movie/videoInfo?movieid=${movie.moveid}">${movie.movename}</a>
            <p style="font-weight:bold;">${movie.date}</p>
            <p>${movie.director}</p>
            <p>导演：${movie.actor}</p>
            <p><a href="/movie/videoInfo?movieid=${movie.moveid}"><input type="button" class="dgbg02" value="特惠购票" /></a></p>
          </dd>
        </dl>
        </c:forEach>
        <div class="clear"></div>
      </div>
    </div>
    <div class="left_5">
      <h2><a href="#">获奖影片展</a><span> ---- 畅享影业帮助您快速购票、享受便捷网络购票体验</span></h2>
      <div class="inner">
        <div id="demo" style="overflow:hidden; width:100%; margin:0 auto;">
          <table border="0" align="center" cellpadding="5" cellspacing="0" cellspace="0" >
            <tr>
              <td id="demo1" valign="top"><table border="0"  cellpadding="0">
                  <tr>
                    <td align="center"><dl class="anli_list">
                        <dt><a href="#"><img src="/assets/movie/images/al1.jpg" width="150" height="100" /></a></dt>
                        <dd><a href="#">十二生肖</a></dd>
                      </dl></td>
                    <td align="center"><dl class="anli_list">
                        <dt><a href="#"><img src="/assets/movie/images/al2.jpg" width="150" height="100" /></a></dt>
                        <dd><a href="#">青春期3</a></dd>
                      </dl></td>
                    <td align="center"><dl class="anli_list">
                        <dt><a href="#"><img src="/assets/movie/images/al3.jpg" width="150" height="100" /></a></dt>
                        <dd><a href="#">王者风范3</a></dd>
                      </dl></td>
                    <td align="center"><dl class="anli_list">
                        <dt><a href="#"><img src="/assets/movie/images/al4.jpg" width="150" height="100" /></a></dt>
                        <dd><a href="#">重来电影节</a></dd>
                      </dl></td>
                    <td align="center"><dl class="anli_list">
                        <dt><a href="#"><img src="/assets/movie/images/al2.jpg" width="150" height="100" /></a></dt>
                        <dd><a href="#">灵魂战车</a></dd>
                      </dl></td>
                    <td align="center"><dl class="anli_list">
                        <dt><a href="#"><img src="/assets/movie/images/al3.jpg" width="150" height="100" /></a></dt>
                        <dd><a href="#">重来电影</a></dd>
                      </dl></td>
                  </tr>
                </table></td>
              <td id="demo2" valign="top"></td>
            </tr>
          </table>
        </div>
        <script type="text/javascript">
                                    var speed=30;
                                    var demo = $("#demo");
                                    var demo1 = $("#demo1");
                                    var demo2 = $("#demo2");
                                    demo2.html(demo1.html());
                                    function Marquee(){ 
                                        if(demo.scrollLeft()>=demo1.width())
                                            demo.scrollLeft(0); 
                                        else{
                                            demo.scrollLeft(demo.scrollLeft()+1);
                                        }
                                    } 
                                    var MyMar=setInterval(Marquee,speed) 
                                    demo.mouseover(function() {
                                        clearInterval(MyMar);
                                    } )
                                    demo.mouseout(function() {
                                        MyMar=setInterval(Marquee,speed);
                                    } )		
                            </script> 
        <!-- 
          
         
        -->
        <div class="clear"></div>
      </div>
    </div>
  </div>
  <div class="right">
    <div class="right_1">
      <h2>快速订票入口 </h2>
      <div class="inner02">
        <dl style="border-bottom:0px #fff solid;">
          <dt><img src="/assets/movie/images/fa2.gif" width="56" height="45" /></dt>
          <dd style=" padding-top:10px;">
            <select name="movieId" id="movieId">
              <option selected="selected">影片搜索</option>
              <c:forEach items="${dz}" var="movie">
                <option value="${movie.moveid}">${movie.movename}</option>
              </c:forEach>
            </select>
          </dd>
          <div class="clear"></div>
        </dl>
        <dl style="height: 60px">
          <dt><img src="/assets/movie/images/fa4.gif" width="56" height="45" /></dt>
          <dd style=" padding-top:10px;">
            <input name="" type="button" class="dgbg" value="立即订购" onclick="subOrderKs('/movie/videoInfo?movieid=','movieId')" />
          </dd>
          <div class="clear"></div>
        </dl>
        <dl style="height: 60px">
              <dt><img src="/assets/movie/images/fa4.gif" width="56" height="45" /></dt>
              <dd style=" padding-top:10px;">
                  <input name="" type="button" class="dgbg" value="兴趣推荐" onclick="tuijian('/movie/InterestTuijian')" />
              </dd>
              <div class="clear"></div>
          </dl>
        <dl style="height: 150px">
          <div class="wxpd"><a href="#"><img src="/assets/movie/images/104.jpg" /></a></div>
        </dl>
      </div>
    </div>

    <div class="right_5 top10px">
      <h2>热门影片榜 </h2>
      <div class="inner02">
        <ul class="server_list">
          <c:forEach items="${syxklbt}" var="movie">
            <li><a href="/movie/videoInfo?movieid=${movie.moveid}"><span>${movie.language}</span>${movie.movename}</a></li>
          </c:forEach>
        </ul>
      </div>
    </div>
        <div class="right_4 top10px">
      <h2><span><a href="#"> 更多影片 </a></span>今日上映推荐 </h2>
      <div class="inner022">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <c:forEach items="${movieList}" var="movie">
          <tr>
            <td height="135" align="center" width="140"><a href="/movie/videoInfo?movieid=${movie.moveid}"><img src="/movie/getPicById?picId=${movie.picid}" width="120" height="100" /></a></td>
            <td><a href="#">${movie.movename}</a><p>导演:${movie.actor}</p></td>
          </tr>
          </c:forEach>
        </table>
      </div>
    </div>
  </div>
  <div class="clear"></div>
  <div class="clear"></div>
</div>
</body>
<script type="text/javascript">
  function subOrderKs(url,id){
    var id = $("#"+id).val();
    var urls = url+id;
    window.location.href=urls;
  }
  function tuijian(url) {
      location.href=url;
  }
</script>
</html>
