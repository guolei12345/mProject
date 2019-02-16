<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>功能信息</title>
</head>

<body><%--修改功能信息--%>
<div class="position-relative">
    <div id="login-box" class="login-box visible widget-box no-border">
        <div class="widget-body">
            <div class="widget-main">
                <form action="/power/edit" method="post">

                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label"> 功能名 </label>

                        <div class="col-sm-9">
                            <input type="text" id="powername" name="powername" value="${powerEdit.powername}" class="col-xs-10 col-sm-5" />
                            <input type="hidden" id="powerid" name="powerid" value="${powerEdit.powerid}" />
                        </div>
                    </div>
                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label"> 类型 </label>

                        <div class="col-sm-9">
                            <select class="col-xs-10 col-sm-5" name="type">
                                <option value="1" <c:if test="${powerEdit.type=='1'}">selected="selected"</c:if>>父目录</option>
                                <option value="0" <c:if test="${powerEdit.type=='0'}">selected="selected"</c:if>>子目录</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right"> 地址 </label>

                        <div class="col-sm-9">
                            <input type="text" id="url" name="url" value="${powerEdit.url}" class="col-xs-10 col-sm-5" />
                        </div>
                    </div>
                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right"> 功能描述 </label>
                        <div class="col-sm-9">
                            <input type="text" id="description" name="description" value="${powerEdit.description}" class="col-xs-10 col-sm-5" />
                        </div>
                    </div>
                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right" for="status"> 状态 </label>
                        <div class="col-sm-9">
                            <select class="col-xs-10 col-sm-5" name="status" id="status">
                                <option value="1" <c:if test="${powerEdit.status=='1'}">selected="selected"</c:if>>可用</option>
                                <option value="0" <c:if test="${powerEdit.status=='0'}">selected="selected"</c:if>>不可用</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group center col-sm-7">
                            <button class="btn btn-info" type="button" onclick="editPower('/power/edit')">
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
    function editPower(urls){
        var powerid = $("#powerid").val();
        var powername = $("#powername").val();
        var type = $("#type").val();
        var url = $("#url").val();
        var description = $("#description").val();
        var status = $("#status").val();
        var data = {
            powerid:powerid,
            powername:powername,
            type:type,
            url:url,
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

