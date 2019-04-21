<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>增加影厅</title>
</head>

<body><%--增加影厅信息--%>
<div class="position-relative">
    <div id="login-box" class="login-box visible widget-box no-border">
        <div class="widget-body">
            <div class="widget-main">
                <form action="/hall/add" method="post" enctype="multipart/form-data">
                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right" for="hallheats">影厅名</label>
                        <div class="col-sm-9">
                            <input type="text" id="hallheats" name="hallheats"  class="col-xs-10 col-sm-5" />
                        </div>
                    </div>
                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right"> 影厅描述 </label>
                        <div class="col-sm-9">
                            <input type="text" id="halldescription" name="halldescription" class="col-xs-10 col-sm-5" />
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

