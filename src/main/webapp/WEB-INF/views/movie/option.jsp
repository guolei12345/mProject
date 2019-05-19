<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>角色对应权限查询</title>
</head>

<body>
    <script type="text/javascript">
        try{ace.settings.check('navbar' , 'fixed')}catch(e){}
    </script>

    <div class="navbar-container" id="navbar-container">
        <div class="row">
            <div class="col-xs-12">
                <h3 class="header smaller lighter blue">${role.rolename} 对应权限表</h3>
                <div class="table-header">
                    权限信息<input type="hidden" id="roleid" value="${role.roleid}"/>
                </div>
                <div class="table-responsive">
                    <table id="sample-table-2" class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th class="center">
                                <label>
                                    <input type="checkbox" class="ace" id="allboxs" onclick="allcheck()"/>
                                    <span class="lbl"></span>
                                </label>
                            </th>
                            <th class="hidden">功能id</th>
                            <th class="hidden-320">角色名</th>
                            <th class="hidden-320">功能名</th>
                            <th class="hidden-320">类型</th>
                            <th class="hidden-320">地址</th>
                            <th class="hidden-320">功能描述</th>
                            <th class="hidden-320">状态</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${role.powerList}" var="power">
                            <tr>
                                <td class="center">
                                    <label>
                                        <input type="checkbox" name="check" value="${power.powerid}" checked="checked" class="ace" />
                                        <span class="lbl"></span>
                                    </label>
                                </td>
                                <th class="hidden">${power.powerid}</th>
                                <td class="hidden-320">${role.rolename}</td>
                                <td class="hidden-320">${power.powername}</td>

                                <td class="hidden-320">
                                    <c:if test="${power.type=='1'}">
                                        <span style="color:brown">父目录</span>
                                    </c:if>
                                    <c:if test="${power.type=='0'}">
                                        <span style="color:blueviolet">子目录</span>
                                    </c:if>
                                </td>
                                <td class="hidden-320">${power.url}</td>
                                <td class="hidden-320">${power.description}</td>
                                <td class="hidden-320">
                                    <c:if test="${power.status=='1'}">
                                        <span style="color:green">可用</span>
                                    </c:if>
                                    <c:if test="${power.status=='0'}">
                                        <span style="color:red">不可用</span>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                        <c:forEach items="${noPowerList}" var="power">
                            <tr>
                                <td class="center">
                                    <label>
                                        <input type="checkbox" value="${power.powerid}" name="check" class="ace" />
                                        <span class="lbl"></span>
                                    </label>
                                </td>
                                <th class="hidden">${power.powerid}</th>
                                <td class="hidden-320">${role.rolename}</td>
                                <td class="hidden-320">${power.powername}</td>

                                <td class="hidden-320">
                                    <c:if test="${power.type=='1'}">
                                        <span style="color:brown">父目录</span>
                                    </c:if>
                                    <c:if test="${power.type=='0'}">
                                        <span style="color:blueviolet">子目录</span>
                                    </c:if>
                                </td>
                                <td class="hidden-320">${power.url}</td>
                                <td class="hidden-320">${power.description}</td>
                                <td class="hidden-320">
                                    <c:if test="${power.status=='1'}">
                                        <span style="color:green">可用</span>
                                    </c:if>
                                    <c:if test="${power.status=='0'}">
                                        <span style="color:red">不可用</span>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="form-group center">
                    <button class="btn btn-info" type="button" onclick="savePower('/role/savePower')">
                        <i class="icon-ok bigger-110"></i>
                        保存
                    </button>

                    &nbsp; &nbsp;
                    <button class="btn" type="reset">
                        <i class="icon-undo bigger-110"></i>
                        重置
                    </button>
                </div>
            </div>
        </div>
    </div><!-- /.main-container-inner -->
</div><!-- /.main-container -->

<script src="<%=basePath%>/assets/ace/js/jquery.min.js"></script>
<script type="text/javascript">
    window.jQuery || document.write("<script src='<%=basePath%>/assets/ace/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
</script>
<script type="text/javascript">
    window.jQuery || document.write("<script src='<%=basePath%>/assets/ace/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<script type="text/javascript">
    if("ontouchend" in document) document.write("<script src='<%=basePath%>/assets/ace/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>
<script src="<%=basePath%>/assets/ace/js/bootstrap.min.js"></script>
<script src="<%=basePath%>/assets/ace/js/typeahead-bs2.min.js"></script>

<script src="<%=basePath%>/assets/ace/js/jquery.dataTables.min.js"></script>
<script src="<%=basePath%>/assets/ace/js/jquery.dataTables.bootstrap.js"></script>

<script src="<%=basePath%>/assets/ace/js/ace-elements.min.js"></script>
<script src="<%=basePath%>/assets/ace/js/ace.min.js"></script>

<script type="text/javascript">
    function savePower(url) {
        var roleid = $("#roleid").val();
        var namebox = $("input[name^='check']");  //获取name值为boxs的所有input
        var selectList = jQuery(".table tbody input[type=checkbox]:checked").map(function () {
            return jQuery(this).val();
        }).get().join(',');
        var urls = url+"?powerList="+selectList+"&roleid="+roleid;
        $("#load").load(urls);
    }

    function allcheck() {
        var nn = $("#allboxs").is(":checked"); //判断th中的checkbox是否被选中，如果被选中则nn为true，反之为false
        var namebox = $("input[name^='check']");  //获取name值为boxs的所有input
        for(i = 0; i < namebox.length; i++) {
            namebox[i].checked=nn;    //js操作选中checkbox
        }
    }
</script>
</body>
</html>
