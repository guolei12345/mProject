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
                            <c:forEach items="${scheduleMap}" var="map">
                            <li class="">
                                <a data-toggle="tab" href="#${map.key}">
                                    <i class="pink icon-dashboard bigger-110"></i>
                                    ${map.key}
                                </a>
                            </li>
                            </c:forEach>
                        </ul>

                        <div class="tab-content">
                            <c:forEach items="${scheduleMap}" var="map">
                            <div id="${map.key}" class="tab-pane">
                                <c:forEach items="${map.value}" var="schedule">
                                    <p>时间：${schedule.colum1} --- ${schedule.colum2}</p>
                                    <p> 演播厅：${schedule.hall.hallheats}</p>
                                </c:forEach>
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