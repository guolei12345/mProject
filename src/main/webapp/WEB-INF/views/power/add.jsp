<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>增加功能</title>
</head>

<body><%--增加用户信息--%>
<div class="position-relative">
    <div id="login-box" class="login-box visible widget-box no-border">
        <div class="widget-body">
            <div class="widget-main">
                <form action="/power/add" method="post">

                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right" for="roleid"> 父级功能 </label>
                        <div class="col-sm-9">
                            <select class="col-xs-10 col-sm-5" name="prapoerid" id="roleid">
                                <option value="0">无</option>
                                <c:forEach items="${powerList}" var="power">
                                    <option value="${power.powerid}">${power.powername}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label"> 本功能 </label>

                        <div class="col-sm-9">
                            <input type="text" id="powername" name="powername"  class="col-xs-10 col-sm-5" />
                        </div>
                    </div>
                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label"> 地址 </label>

                        <div class="col-sm-9">
                            <input type="text" id="url" name="url" class="col-xs-10 col-sm-5" />
                        </div>
                    </div>
                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right"> 功能描述 </label>

                        <div class="col-sm-9">
                            <input type="text" id="description" name="description" class="col-xs-10 col-sm-5" />
                        </div>
                    </div>
                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right"> 状态 </label>
                        <div class="col-sm-9">
                            <select class="col-xs-10 col-sm-5" name="status" id="status">
                                <option value="1">可用</option>
                                <option value="0">不可用</option>
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

