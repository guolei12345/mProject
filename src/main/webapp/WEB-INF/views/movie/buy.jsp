<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>电影排片信息</title>
	</head>
	<body>
	<div id="user-profile-3" class="user-profile row">
		<div class="col-sm-offset-1 col-sm-10">
			<div class="space"></div>
            <form class="form-horizontal" action="/movie/order" method="post" >
                <div class="col-sm-12">
                    <img src="/movie/getPic?path=${movie.pic.picurl}" width="200" height="300" class="col-sm-4" width="145" height="33" id="identity"/>
                    <div class="tabbable tabs-top col-sm-8">
                        <ul class="nav nav-tabs" id="myTab3">
                            <c:forEach items="${scheduleMap}" var="map" varStatus="idx">
                                <c:if test="${idx.index=='0'}">
                                <li class="active">
                                </c:if>
                                <c:if test="${idx.index!='0'}">
                                    <li class="">
                                </c:if>
                                <a data-toggle="tab" href="#${map.key}">
                                    <i class="pink icon-dashboard bigger-110"></i>
                                    ${map.key}
                                </a>
                            </li>
                            </c:forEach>
                        </ul>

                        <div class="tab-content tabs-right col-sm-8">
                            <c:forEach items="${scheduleMap}" var="map">
                            <div id="${map.key}" class="tab-pane">
                                <%--内层--%>
                                <ul class="nav tabs-left nav-tabs" id="myTab2">
                                    <c:forEach items="${map.value}" var="schedule" varStatus="idx">
                                        <%--<c:if test="${idx.index=='0'}">--%>
                                            <%--<li class="active">--%>
                                        <%--</c:if>--%>
                                        <%--<c:if test="${idx.index!='0'}">--%>
                                            <%--<li class="">--%>
                                        <%--</c:if>--%>
                                        <li class="">
                                        <a data-toggle="tab" href="#${schedule.scheduleid}">
                                            <i class="pink icon-dashboard bigger-110"></i>
                                                ${schedule.colum1}--${schedule.colum2}
                                        </a>
                                    </li>
                                    </c:forEach>
                                </ul>

                                <div class="tab-content">
                                    <c:forEach items="${map.value}" var="schedule">
                                    <div id="${schedule.scheduleid}" class="tab-pane">
                                        <p> 演播厅：${schedule.hall.hallheats}</p>
                                        <p>时间：${schedule.colum1} --- ${schedule.colum2}</p>
                                        <%--座位--%>
                                        <table>
                                            <tr>
                                        <c:forEach items="${schedule.hallSetList}" var="setNum">
                                            <%--<c:if test="${setNum.num%8==0}">--%>
                                                <%--<tr>--%>
                                            <%--</c:if>--%>
                                            <td>
                                                <c:if test="${!setNum.isSelect}">
                                                    <a href="#"class="btn btn-xs btn-success" onclick="optionMovie('/movie/subOrder?setNum=${setNum.num}','scheduleid','${schedule.scheduleid}')">${setNum.num}</a>
                                                </c:if>
                                                <c:if test="${setNum.isSelect}">
                                                    <a class="btn btn-xs btn-info" href="#">${setNum.num}</a>
                                                </c:if>
                                            </td>
                                            <c:if test="${setNum.num%8==0}">
                                                </tr><tr>
                                            </c:if>
                                        </c:forEach>
                                        </table>
                                    </div>
                                    </c:forEach>
                                </div>
                            </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
				<div class="clearfix form-actions">
					<div class="col-md-offset-3 col-md-9">
						<button class="btn btn-info" type="submit">
							<i class="icon-ok bigger-110"></i>
							保存
						</button>

						&nbsp; &nbsp;
						<button class="btn" type="reset">
							<i class="icon-undo bigger-110"></i>
							重置
						</button>
					</div>
				</div>
			</form>
		</div><!-- /span -->
	</div><!-- /user-profile -->
	<script type="text/javascript">
		jQuery(function($) {
			$('#user-profile-3').end().find('.date-picker').datepicker().next().on(ace.click_event, function(){
				$(this).prev().focus();
			});
		});
	</script>
	</body>
</html>