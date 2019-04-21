<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>影厅信息</title>
</head>

<body><%--修改影厅信息--%>
<div class="position-relative">
    <div id="login-box" class="login-box visible widget-box no-border">
        <div class="widget-body">
            <div class="widget-main">
                <form action="/hall/edit" method="post">
                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label"> 影厅名 </label>
                        <div class="col-sm-9">
                            <input type="text" id="hallheats" name="hallheats" value="${hallEdit.hallheats}" class="col-xs-10 col-sm-5" />
                            <input type="hidden" id="hallid" name="hallid" value="${hallEdit.hallid}" />
                        </div>
                    </div>
                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label"> 影厅描述 </label>
                        <div class="col-sm-9">
                            <input type="text" id="halldescription" name="halldescription" value="${hallEdit.halldescription}" class="col-xs-10 col-sm-5" />
                        </div>
                    </div>
                    <div class="form-group center col-sm-7">
                            <button class="btn btn-info" type="button" onclick="editRole('/hall/edit')">
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
        var hallheats = $("#hallheats").val();
        var hallid = $("#hallid").val();
        var halldescription = $("#halldescription").val();
        var data = {
            hallid:hallid,
            hallheats:hallheats,
            halldescription:halldescription
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

