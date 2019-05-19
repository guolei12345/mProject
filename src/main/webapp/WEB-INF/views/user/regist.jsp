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
    <title>注册页面</title>
    <link href="/assets/ace/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="/assets/ace/css/font-awesome.min.css" />
    <!-- ace styles -->
    <link rel="stylesheet" href="/assets/ace/css/ace.min.css" />
    <link rel="stylesheet" href="/assets/ace/css/ace-rtl.min.css" />
</head>

<body class="login-layout">

<div class="col-sm-10 col-sm-offset-1">
    <div class="login-container">
        <%--标题--%>
        <div class="center">
            <h1>
                <span class="red">XX</span>
                <span class="blue">后台管理系统</span>
            </h1>
            <h4 class="blue">&copy; 注册</h4>
        </div>

        <div class="space-6"></div>
        <%--注册--%>
        <div class="position-relative">
            <div id="login-box" class="login-box visible widget-box no-border">
                <div class="widget-body">
                    <div class="widget-main">
                        <h4 class="header blue lighter bigger">
                            <i class="icon-coffee green"></i>
                            请输入注册信息
                        </h4>
                        <div class="space-6"></div>
                        <form action="<%=basePath%>/user/regist" method="post">
                            <fieldset>
                                <label class="block clearfix">
                                    <span class="block input-icon input-icon-right">
                                        <%--<input type="text" id="loginname" name="loginname" class="form-control" placeholder="用户名" />--%>
                                        <input type="text" id="email" name="email" class="form-control" placeholder="邮箱" />
                                        <i class="icon-user"></i>
                                    </span>
                                </label>
                                <label class="block clearfix">
                                    <span class="block input-icon input-icon-right">
                                        <%--<input type="text" id="loginname" name="loginname" class="form-control" placeholder="用户名" />--%>
                                        <input type="text" id="tell" name="tell" class="form-control" placeholder="手机号" />
                                        <i class="icon-user"></i>
                                    </span>
                                </label>
                                <label class="block clearfix">
                                    <span class="block input-icon input-icon-right">
                                        <input type="password" id="password" name="password" class="form-control" placeholder="密码" />
                                        <i class="icon-lock"></i>
                                    </span>
                                </label>
                                <label class="block clearfix">
                                    <span class="block input-icon input-icon-right">
                                        <input type="password" id="password2" name="password2" class="form-control" placeholder="确认密码" />
                                        <i class="icon-lock"></i>
                                    </span>
                                </label>
                                <label class="block clearfix">
                                    <span class="block input-icon input-icon-right input-group">
                                        <input type="text" id="code" name="code" class="form-control" placeholder="验证码"
                                            style="width: 145px"/>
                                        <img src="<%=basePath%>/user/getVerify?" class="input-icon input-icon-right" width="145" height="33" id="identity" onload="btn.disabled=true;"
                                             onclick="this.src='<%=basePath%>/user/getVerify?'+Math.random();"/>
                                    </span>
                                </label>
                                <input type="submit" class="form-control" value="注册" />
                            </fieldset>
                        </form>
                    </div><!-- /widget-main -->
                    <%--注册--%>
                    <div class="toolbar clearfix">
                        <div>
                            <a href="<%=basePath%>/user/login" class="user-signup-link">
                                登陆
                                <i class="icon-arrow-left"></i>
                            </a>
                        </div>
                    </div>
                </div><!-- /widget-body -->
            </div><!-- /login-box -->
        </div><!-- /position-relative -->
    </div>
</div><!-- /.col -->
<script src="/assets/ace/js/jquery.min.js">
</script>
<script type="text/javascript">
    window.jQuery || document.write("<script src='/assets/ace/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
</script>
<script type="text/javascript">
    if("ontouchend" in document) document.write("<script src='/assets/ace/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>
<!-- inline scripts related to this page -->
<script type="text/javascript">
    function show_box(id) {
        jQuery('.widget-box.visible').removeClass('visible');
        jQuery('#'+id).addClass('visible');
    }
</script>
<%--自己的方法--%>
<script type="text/javascript">

</script>
</body>
</html>
