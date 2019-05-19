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
    <title>角色信息</title>
</head>

<body><%--修改角色信息--%>
<div class="position-relative">
    <div id="login-box" class="login-box visible widget-box no-border">
        <div class="widget-body">
            <div class="widget-main">
                <form action="<%=basePath%>/role/edit" method="post">
                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label"> 角色名 </label>
                        <div class="col-sm-9">
                            <input type="text" id="rolename" name="rolename" value="${roleEdit.rolename}" class="col-xs-10 col-sm-5" />
                            <input type="hidden" id="roleid" name="roleid" value="${roleEdit.roleid}" />
                        </div>
                    </div>
                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label"> 类型 </label>
                        <div class="col-sm-9">
                            <input type="text" id="type" name="type" value="${roleEdit.type}" class="col-xs-10 col-sm-5" />
                        </div>
                    </div>
                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right"> 角色描述 </label>
                        <div class="col-sm-9">
                            <input type="text" id="description" name="description" value="${roleEdit.description}" class="col-xs-10 col-sm-5" />
                        </div>
                    </div>
                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right" for="status"> 状态 </label>
                        <div class="col-sm-9">
                            <select class="col-xs-10 col-sm-5" name="status" id="status">
                                <option value="1" <c:if test="${roleEdit.status=='1'}">selected="selected"</c:if>>可用</option>
                                <option value="0" <c:if test="${roleEdit.status=='0'}">selected="selected"</c:if>>不可用</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group center col-sm-7">
                            <button class="btn btn-info" type="button" onclick="editRole('<%=basePath%>/role/edit')">
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
<script type="text/javascript">
    function editRole(urls){
        var rolename = $("#rolename").val();
        var roleid = $("#roleid").val();
        var type = $("#type").val();
        var description = $("#description").val();
        var status = $("#status").val();
        var data = {
            roleid:roleid,
            rolename:rolename,
            type:type,
            description:description,
            status:status
        };
        $.ajax({
            type:"post",
            url:urls,
            data:JSON.stringify(data),
            contentType:"application/json;charset=utf-8",
            success:function(dt){
                $("#load").html(dt);
            }
        })
    }
</script>
</body>
</html>

