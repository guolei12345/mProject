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
    <title>用户查询</title>
</head>

<body>
    <script type="text/javascript">
        try{ace.settings.check('navbar' , 'fixed')}catch(e){}
    </script>

    <div class="navbar-container" id="navbar-container">
        <div class="row">
            <div class="col-xs-12">
                <h3 class="header smaller lighter blue">用户信息表</h3>
                <div class="table-header">
                    用户信息
                </div>
                <div class="col-sm-6"><div id="sample-table-2_length" class="dataTables_length">
                    <label>Display
                        <select size="1" id="offset" name="sample-table-2_length" aria-controls="sample-table-2">
                            <option value="5" <c:if test="${pageInfo.offset==5}">selected="selected"</c:if>>5</option>
                            <option value="10" <c:if test="${pageInfo.offset==10}">selected="selected"</c:if>>10</option>
                            <option value="20" <c:if test="${pageInfo.offset==20}">selected="selected"</c:if>>20</option>
                        </select> records</label>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="dataTables_filter">
                        <label>关键字: <input type="text" id="userKey" aria-controls="sample-table-2">
                            <button class="btn btn-info" onclick="searchByKey('<%=basePath%>/user/search','userKey',1)">
                                <i class="icon-ok bigger-110"></i>
                                查询
                            </button>
                        </label>
                    </div>
                </div>
                <div class="table-responsive">
                    <table id="sample-table-2" class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th class="center">
                                <label>
                                    <input type="checkbox" class="ace" />
                                    <span class="lbl"></span>
                                </label>
                            </th>
                            <th class="hidden">用户id</th>
                            <th class="hidden-320">用户名</th>
                            <th class="hidden-320">姓名</th>
                            <th class="hidden-320">电话号</th>
                            <th class="hidden-320">邮箱</th>
                            <th class="hidden-320">生日</th>
                            <th class="hidden-320">性别</th>
                            <th class="hidden-320">个性签名</th>
                            <th class="hidden-320">角色</th>
                            <th class="hidden-320">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pageInfo.list}" var="user">
                        <tr>
                            <td class="center">
                                <label>
                                    <input type="checkbox" class="ace" />
                                    <span class="lbl"></span>
                                </label>
                            </td>
                            <th class="hidden">${user.userid}</th>
                            <td class="hidden-320">${user.loginname}</td>
                            <td class="hidden-320">${user.username}</td>
                            <td class="hidden-320">${user.tell}</td>
                            <td class="hidden-320">${user.email}</td>
                            <td class="hidden-320">${user.birthday}</td>
                            <td class="hidden-320">
                                <c:if test="${user.sex == '1'}">
                                    男
                                </c:if>
                                <c:if test="${user.sex == '0'}">
                                    女
                                </c:if>
                            </td>
                            <td class="hidden-320">${user.sign}</td>
                            <td class="hidden-320">${user.role.rolename}</td>
                            <td>
                                <div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">

                                    <a class="green" href="#" onclick="option('<%=basePath%>/user/edit','userid',${user.userid})">
                                        <i class="icon-pencil bigger-130"></i>
                                    </a>

                                    <a class="red" href="#" onclick="option('<%=basePath%>/user/delete','userid',${user.userid})">
                                        <i class="icon-trash bigger-130"></i>
                                    </a>
                                </div>
                            </td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <div class="modal-content">
            <ul class="pagination pull-right no-margin">
                <li class="prev" onclick="searchByKey('<%=basePath%>/user/search','userKey',1)">
                    <a href="#">
                        <i class="icon-double-angle-left"></i>
                    </a>
                </li>
                <c:forEach begin="1" end="${pageInfo.total}" var="page">
                <li class="prev" onclick="searchByKey('<%=basePath%>/user/search','userKey',${page})">
                    <a href="#">${page}</a>
                </li>
                </c:forEach>
                <li class="prev" onclick="searchByKey('<%=basePath%>/user/search','userKey',${pageInfo.total})">
                    <a href="#">
                        <i class="icon-double-angle-right"></i>
                    </a>
                </li>
            </ul>
        </div><!-- /.modal-content -->
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

</script>
</body>
</html>
