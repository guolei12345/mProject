<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>电影信息</title>
</head>

<body><%--修改电影信息--%>
<div class="position-relative">
    <div id="login-box" class="login-box visible widget-box no-border">
        <div class="widget-body">
            <div class="widget-main">
                <form action="/movie/edit" method="post">
                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label"> 电影名 </label>
                        <div class="col-sm-9">
                            <input type="text" id="movename" name="movename" value="${movieEdit.movename}" class="col-xs-10 col-sm-5" />
                            <input type="hidden" id="moveid" name="moveid" value="${movieEdit.moveid}" />
                        </div>
                    </div>
                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label"> 电影描述 </label>
                        <div class="col-sm-9">
                            <input type="text" id="director" name="director" value="${movieEdit.director}" class="col-xs-10 col-sm-5" />
                        </div>
                    </div>
                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right"> 导演 </label>
                        <div class="col-sm-9">
                            <input type="text" id="actor" name="actor" value="${movieEdit.actor}" class="col-xs-10 col-sm-5" />
                        </div>
                    </div>
                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right"> 主演 </label>
                        <div class="col-sm-9">
                            <input type="text" id="colum1" name="colum1" value="${movieEdit.colum1}" class="col-xs-10 col-sm-5" />
                        </div>
                    </div>
                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right"> 片长 </label>
                        <div class="col-sm-9">
                            <input type="text" id="colum2" name="colum2" value="${movieEdit.colum2}" class="col-xs-10 col-sm-5" />
                        </div>
                    </div>
                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right"> 上映时间 </label>
                        <div class="col-sm-9">
                            <input type="text" id="colum3" name="colum3" value="${movieEdit.colum3}" class="col-xs-10 col-sm-5" />
                        </div>
                    </div>
                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right"> 语言 </label>
                        <div class="col-sm-9">
                            <input type="text" id="language" name="language" value="${movieEdit.language}" class="col-xs-10 col-sm-5" />
                        </div>
                    </div>
                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right"> 类型 </label>
                        <div class="col-sm-9">
                            <select class="col-xs-10 col-sm-5" name="typeid" id="typeid">
                                <c:forEach items="${typeList}" var="type">
                                    <option value="${type.typeid}" <c:if test="${type.typeid==movieEdit.typeid}">selected="selected"</c:if>>${type.typename}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group center col-sm-12">
                        <label class="col-sm-3 control-label no-padding-right"> 图片 </label>
                        <%--<div class="col-sm-9">--%>
                            <input type="image" src="/movie/getPic?path=${movieEdit.pic.picurl}" width="100" height="120" class="input-icon input-icon-right" width="145" height="33" id="identity"/>
                        <%--</div>--%>
                    </div>
                    <div class="form-group center col-sm-7">
                            <button class="btn btn-info" type="button" onclick="editRole('/movie/edit')">
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
        var movename = $("#movename").val();
        var moveid = $("#moveid").val();
        var director = $("#director").val();
        var actor = $("#actor").val();
        var language = $("#language").val();
        var typeid = $("#typeid").val();
        var data = {
            moveid:moveid,
            movename:movename,
            director:director,
            actor:actor,
            language:language,
            typeid:typeid
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

