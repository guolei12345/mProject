<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>增加电影类型</title>
</head>

<body><%--增加电影类型信息--%>
<div class="position-relative">
    <div id="login-box" class="login-box visible widget-box no-border">
        <div class="widget-body">
            <div class="widget-main">
                <form action="<%=basePath%>/type/add" method="post" enctype="multipart/form-data">
                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right" for="typename">电影类型</label>
                        <div class="col-sm-9">
                            <input type="text" id="typename" name="typename"  class="col-xs-10 col-sm-5" />
                        </div>
                    </div>
                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right" for="colum1">展示地址</label>
                        <div class="col-sm-9">
                            <select class="col-xs-10 col-sm-5" name="colum1" id="colum1">
                                <c:forEach items="${movieShowPath}" var="type">
                                    <option value="${type.name()}">${type.name()}</option>
                                </c:forEach>
                            </select>
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

