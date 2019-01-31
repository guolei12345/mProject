<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>用户信息</title>
</head>

<body><%--修改用户信息--%>
<div class="position-relative">
    <div id="login-box" class="login-box visible widget-box no-border">
        <div class="widget-body">
            <div class="widget-main">
                <form action="/user/edit" method="post">

                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label"> 用户名 </label>

                        <div class="col-sm-9">
                            <input type="text" id="username" name="username" value="${userEdit.username}" class="col-xs-10 col-sm-5" />
                            <input type="hidden" id="userid" name="userid" value="${userEdit.userid}" />
                        </div>
                    </div>
                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label"> 昵称 </label>

                        <div class="col-sm-9">
                            <input type="text" id="loginname" name="loginname" value="${userEdit.loginname}" class="col-xs-10 col-sm-5" />
                        </div>
                    </div>
                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right" for="loginname"> 电话号 </label>

                        <div class="col-sm-9">
                            <input type="text" id="tell" name="tell" value="${userEdit.tell}" class="col-xs-10 col-sm-5" />
                        </div>
                    </div>
                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right" for="email"> 邮箱 </label>
                        <div class="col-sm-9">
                            <input type="text" id="email" name="email" value="${userEdit.email}" class="col-xs-10 col-sm-5" />
                        </div>
                    </div>
                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right" for="roleid"> 分配角色 </label>
                        <div class="col-sm-9">
                            <select class="col-xs-10 col-sm-5" name="roleid" id="roleid">
                                <c:forEach items="${roleList}" var="role">
                                    <option value="${role.roleid}">${role.rolename}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group center col-sm-7">
                        <input type="submit" class="form-control col-sm-6" value="修改" />
                    </div>
                </form>
            </div><!-- /widget-main -->
        </div><!-- /widget-body -->
    </div><!-- /login-box -->
</div><!-- /position-relative -->
</body>
</html>

