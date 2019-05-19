<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>增加电影</title>
</head>

<body><%--增加电影信息--%>
<div class="position-relative">
    <div id="login-box" class="login-box visible widget-box no-border">
        <div class="widget-body">
            <div class="widget-main">
                <form action="/movie/add" method="post" enctype="multipart/form-data">
                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right" for="movename">电影名</label>
                        <div class="col-sm-9">
                            <input type="text" id="movename" name="movename"  class="col-xs-10 col-sm-5" />
                        </div>
                    </div>
                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right" for="movename">电影图片</label>
                        <div class="col-sm-9">
                            <input type="file" id="file" name="file"  class="col-xs-10 col-sm-5" />
                        </div>
                    </div>
                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right"> 电影描述 </label>
                        <div class="col-sm-9">
                            <input type="text" id="director" name="director" class="col-xs-10 col-sm-5" />
                        </div>
                    </div>
                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right"> 导演 </label>
                        <div class="col-sm-9">
                            <input type="text" id="actor" name="actor" class="col-xs-10 col-sm-5" />
                        </div>
                    </div>
                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right"> 主演 </label>
                        <div class="col-sm-9">
                            <input type="text" id="colum1" name="colum1" class="col-xs-10 col-sm-5" />
                        </div>
                    </div>
                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right"> 片长 </label>
                        <div class="col-sm-9">
                            <input type="text" id="colum2" name="colum2" class="col-xs-10 col-sm-5" />
                        </div>
                    </div>
                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right"> 上映时间 </label>
                        <div class="col-sm-9">
                            <input type="text" id="colum3" name="colum3" class="col-xs-10 col-sm-5" />
                        </div>
                    </div>
                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right"> 语言 </label>
                        <div class="col-sm-9">
                            <input type="text" id="language" name="language" class="col-xs-10 col-sm-5" />
                        </div>
                    </div>
                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right"> 类型 </label>
                        <div class="col-sm-9">
                            <select class="col-xs-10 col-sm-5" name="typeid" id="typeid">
                                <c:forEach items="${typeList}" var="type">
                                    <option value="${type.typeid}">${type.typename}</option>
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

