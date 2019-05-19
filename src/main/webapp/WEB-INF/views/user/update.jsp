<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>修改密码页面</title>
    <link href="<%=basePath%>/assets/ace/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="<%=basePath%>/assets/ace/css/font-awesome.min.css" />
    <!-- ace styles -->
    <link rel="stylesheet" href="<%=basePath%>/assets/ace/css/ace.min.css" />
    <link rel="stylesheet" href="<%=basePath%>/assets/ace/css/ace-rtl.min.css" />
</head>

<body class="login-layout">

<div class="col-sm-10 col-sm-offset-1">
    <div class="login-container">

        <div class="space-6"></div>
        <%--修改密码--%>
        <div class="position-relative">
            <div id="login-box" class="login-box visible widget-box no-border">
                <div class="widget-body">
                    <div class="widget-main">
                        <h4 class="header blue lighter bigger">
                            <i class="icon-coffee green"></i>
                            请输入密码信息
                        </h4>
                        <div class="space-6"></div>
                        <form action="<%=basePath%>/user/update" method="post">
                            <fieldset>
                                <label class="block clearfix">
                                    <span class="block input-icon input-icon-right">
                                        <input type="text" id="num" name="num" class="form-control" value="${user.tell}" placeholder="用户名" />
                                        <i class="icon-user"></i>
                                    </span>
                                </label>
                                <label class="block clearfix">
                                    <span class="block input-icon input-icon-right">
                                        <input type="password" id="password" name="password" class="form-control" placeholder="旧密码" />
                                        <i class="icon-lock"></i>
                                    </span>
                                </label>
                                <label class="block clearfix">
                                    <span class="block input-icon input-icon-right">
                                        <input type="password" id="password2" name="password2" class="form-control" placeholder="新密码" />
                                        <i class="icon-lock"></i>
                                    </span>
                                </label>
                                <label class="block clearfix">
                                    <span class="block input-icon input-icon-right">
                                        <input type="password" id="password3" name="password3" class="form-control" placeholder="确认密码" />
                                        <i class="icon-lock"></i>
                                    </span>
                                </label>
                                <input type="submit" class="form-control" value="修改" />
                            </fieldset>
                        </form>
                    </div><!-- /widget-main -->
                </div><!-- /widget-body -->
            </div><!-- /login-box -->
        </div><!-- /position-relative -->
    </div>
</div><!-- /.col -->
<script src="<%=basePath%>/assets/ace/js/jquery.min.js">
</script>
<script type="text/javascript">
    window.jQuery || document.write("<script src='<%=basePath%>/assets/ace/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
</script>
<script type="text/javascript">
    if("ontouchend" in document) document.write("<script src='<%=basePath%>/assets/ace/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>
<!-- inline scripts related to this page -->
<script type="text/javascript">
    function show_box(id) {
        jQuery('.widget-box.visible').removeClass('visible');
        jQuery('#'+id).addClass('visible');
    }
</script>
</body>
</html>
