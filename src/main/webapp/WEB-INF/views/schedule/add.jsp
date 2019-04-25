<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>增加排片信息</title>
</head>

<body><%--增加排片信息--%>
<div class="position-relative">
    <div id="login-box" class="login-box visible widget-box no-border">
        <div class="widget-body">
            <div class="widget-main">
                <form action="/schedule/add" method="post" enctype="multipart/form-data">
                    <%--电影信息--%>
                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right"> 电影信息 </label>
                        <div class="col-sm-9">
                            <select class="col-xs-10 col-sm-5" name="moveid" id="moveid">
                                <c:forEach items="${movieList}" var="movie">
                                    <option value="${movie.moveid}">${movie.movename}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <%--影厅信息--%>
                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right"> 电影信息 </label>
                        <div class="col-sm-9">
                            <select class="col-xs-10 col-sm-5" name="hallid" id="hallid">
                                <c:forEach items="${hallList}" var="hall">
                                    <option value="${hall.hallid}">${hall.hallheats}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right"> 价格 </label>
                        <div class="col-sm-9">
                            <input type="number" id="price" name="price" class="col-xs-10 col-sm-5" />
                        </div>
                    </div>
                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right"> 日期 </label>
                        <div class="col-sm-9">
                            <input type="date" id="time" name="time" class="col-xs-10 col-sm-5" />
                        </div>
                    </div>
                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right"> 开始时间 </label>
                        <div class="col-sm-9">
                            <input type="time" id="colum1" name="colum1" class="col-xs-10 col-sm-5" />
                        </div>
                    </div>
                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right"> 截止时间 </label>
                        <div class="col-sm-9">
                            <input type="time" id="colum2" name="colum2" class="col-xs-10 col-sm-5" />
                        </div>
                    </div>
                    <div class="form-group center">
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
                </form>
            </div><!-- /widget-main -->
        </div><!-- /widget-body -->
    </div><!-- /login-box -->
</div><!-- /position-relative -->
</body>
</html>

