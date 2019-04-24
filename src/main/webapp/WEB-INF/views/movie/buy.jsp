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
            <img src="/movie/getPic?path=${movie.pic.picurl}" width="200" height="300" class="input-icon input-icon-right" width="145" height="33" id="identity"/>
            <form class="form-horizontal" action="/movie/order" method="post" >
                <div class="col-sm-6">
                    <div class="tabbable tabs-left">
                        <ul class="nav nav-tabs" id="myTab3">
                            <li class="">
                                <a data-toggle="tab" href="#Move">
                                    <i class="pink icon-dashboard bigger-110"></i>
                                    movie
                                </a>
                            </li>
                            <c:forEach items="${scheduleList}" var="schedule">
                            <li class="">
                                <a data-toggle="tab" href="#${schedule.scheduleid}">
                                    <i class="pink icon-dashboard bigger-110"></i>
                                    ${schedule.hall.hallheats}
                                </a>
                            </li>
                            </c:forEach>
                        </ul>

                        <div class="tab-content">
                            <div id="Move" class="tab-pane active">
                                Move
                            </div>
                            <c:forEach items="${scheduleList}" var="schedule">
                            <div id="${schedule.scheduleid}" class="tab-pane">
                                ${schedule.hall.halldescription}
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