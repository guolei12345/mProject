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
    <title>排片信息查询</title>
</head>

<body>
    <script type="text/javascript">
        try{ace.settings.check('navbar' , 'fixed')}catch(e){}
    </script>

    <div class="navbar-container" id="navbar-container">
        <div class="row">
            <div class="col-xs-12">
                <h3 class="header smaller lighter blue">排片信息信息表</h3>
                <div class="table-header">
                    排片信息信息
                </div>
                <div class="col-sm-6"><div id="sample-table-2_length" class="dataTables_length">
                    <label>显示
                        <select size="1" id="offset" name="sample-table-2_length" aria-controls="sample-table-2">
                            <option value="5" <c:if test="${schedulePage.offset==5}">selected="selected"</c:if>>5</option>
                            <option value="10" <c:if test="${schedulePage.offset==10}">selected="selected"</c:if>>10</option>
                            <option value="20" <c:if test="${schedulePage.offset==20}">selected="selected"</c:if>>20</option>
                        </select> 条记录</label>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="dataTables_filter">
                        <label>关键字: <input type="text" id="scheduleKey" aria-controls="sample-table-2">
                            <button class="btn btn-info" onclick="searchByKey('<%=basePath%>/schedule/search','scheduleKey',1)">
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
                            <th class="hidden">排片信息id</th>
                            <th class="hidden-320">电影名</th>
                            <th class="hidden-320">电影描述</th>
                            <th class="hidden-320">导演</th>
                            <th class="hidden-320">语言</th>

                            <th class="hidden-320">影厅名</th>
                            <th class="hidden-320">影厅描述</th>

                            <th class="hidden-320">开始时间</th>
                            <th class="hidden-320">结束时间</th>

                            <th class="hidden-320">价格</th>
                            <th class="hidden-320">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${schedulePage.list}" var="schedule">
                        <tr>
                            <td class="center">
                                <label>
                                    <input type="checkbox" class="ace" />
                                    <span class="lbl"></span>
                                </label>
                            </td>
                            <th class="hidden">${schedule.scheduleid}</th>
                            <td class="hidden-320">${schedule.movie.movename}</td>
                            <td class="hidden-320">${schedule.movie.director}</td>
                            <td class="hidden-320">${schedule.movie.actor}</td>
                            <td class="hidden-320">${schedule.movie.language}</td>

                            <td class="hidden-320">${schedule.hall.hallheats}</td>
                            <td class="hidden-320">${schedule.hall.halldescription}</td>

                            <td class="hidden-320">${schedule.time}</td>
                            <td class="hidden-320">${schedule.colum1}</td>
                            <td class="hidden-320">${schedule.price}</td>
                            <td>
                                <div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
                                    <a class="red" href="#" onclick="option('<%=basePath%>/schedule/delete','scheduleid',${schedule.scheduleid})">
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
                <li class="prev" onclick="searchByKey('<%=basePath%>/schedule/search','scheduleKey',1)">
                    <a href="#">
                        <i class="icon-double-angle-left"></i>
                    </a>
                </li>
                <c:forEach begin="1" end="${schedulePage.total}" var="page">
                    <li class="prev" onclick="searchByKey('<%=basePath%>/schedule/search','scheduleKey',${page})">
                        <a href="#">${page}</a>
                    </li>
                </c:forEach>
                <li class="prev" onclick="searchByKey('<%=basePath%>/schedule/search','scheduleKey',${schedulePage.total})">
                    <a href="#">
                        <i class="icon-double-angle-right"></i>
                    </a>
                </li>
            </ul>
        </div><!-- /.modal-content -->
    </div><!-- /.main-container-inner -->
</div><!-- /.main-container -->

<script src="/assets/ace/js/jquery.min.js"></script>
<script type="text/javascript">
    window.jQuery || document.write("<script src='/assets/ace/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
</script>
<script type="text/javascript">
    window.jQuery || document.write("<script src='/assets/ace/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<script type="text/javascript">
    if("ontouchend" in document) document.write("<script src='/assets/ace/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>
<script src="/assets/ace/js/bootstrap.min.js"></script>
<script src="/assets/ace/js/typeahead-bs2.min.js"></script>

<script src="/assets/ace/js/jquery.dataTables.min.js"></script>
<script src="/assets/ace/js/jquery.dataTables.bootstrap.js"></script>

<script src="/assets/ace/js/ace-elements.min.js"></script>
<script src="/assets/ace/js/ace.min.js"></script>

<script type="text/javascript">

</script>
</body>
</html>
