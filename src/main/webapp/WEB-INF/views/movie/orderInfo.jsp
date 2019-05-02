<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>订单信息</title>
</head>

<body><%--增加电影信息--%>
<div class="position-relative">
    <div id="login-box" class="login-box visible widget-box no-border">
        <div class="widget-body">
            <div class="widget-main">
                <div>
                    <table class="table table-striped table-bordered">
                        <thead>
                        <tr>
                            <th class="center">编号</th>
                            <th>电影</th>
                            <th>影厅</th>
                            <th class="hidden-xs">开始时间</th>
                            <th class="hidden-480">结束时间</th>
                            <th>座位号</th>
                            <th>价格</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${userScheduleList}" var="userSchedule">
                        <tr>
                            <th class="center">${userSchedule.id}</th>
                            <th>${userSchedule.id}</th>
                            <th>${userSchedule.id}</th>
                            <th class="hidden-xs">${userSchedule.id}</th>
                            <th class="hidden-480">${userSchedule.id}</th>
                            <th>${userSchedule.id}</th>
                            <th>${userSchedule.id}</th>
                            <th>${userSchedule.id}</th>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>

                <div class="hr hr8 hr-double hr-dotted"></div>

                <div class="row">
                    <div class="col-sm-5 pull-right">
                        <h4 class="pull-right">
                            Total amount :
                            <span class="red">$395</span>
                        </h4>
                    </div>
                    <div class="col-sm-7 pull-left"> Extra Information </div>
                </div>

                <div class="space-6"></div>
                <div class="well">
                    Thank you for choosing Ace Company products.
                    We believe you will be satisfied by our services.
                </div>
            </div><!-- /widget-main -->
        </div><!-- /widget-body -->
    </div><!-- /login-box -->
</div><!-- /position-relative -->
</body>
</html>

