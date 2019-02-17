<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>功能查询</title>
</head>

<body>
    <script type="text/javascript">
        try{ace.settings.check('navbar' , 'fixed')}catch(e){}
    </script>

    <div class="navbar-container" id="navbar-container">
        <div class="row">
            <div class="col-xs-12">
                <h3 class="header smaller lighter blue">功能信息表</h3>
                <div class="table-header">
                    功能信息
                </div>
                <div class="col-sm-6"><div id="sample-table-2_length" class="dataTables_length">
                    <label>显示
                        <select size="1" id="offset" name="sample-table-2_length" aria-controls="sample-table-2">
                            <option value="5" <c:if test="${powerPage.offset==5}">selected="selected"</c:if>>5</option>
                            <option value="10" <c:if test="${powerPage.offset==10}">selected="selected"</c:if>>10</option>
                            <option value="20" <c:if test="${powerPage.offset==20}">selected="selected"</c:if>>20</option>
                        </select> 条记录</label>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="dataTables_filter">
                        <label>关键字: <input type="text" id="powerKey" aria-controls="sample-table-2">
                            <button class="btn btn-info" onclick="searchByKey('/power/search','powerKey',1)">
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
                            <th class="hidden">功能id</th>
                            <th class="hidden-320">功能名</th>
                            <th class="hidden-320">类型</th>
                            <th class="hidden-320">父目录</th>
                            <th class="hidden-320">地址</th>
                            <th class="hidden-320">功能描述</th>
                            <th class="hidden-320">状态</th>
                            <th class="hidden-320">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${powerPage.list}" var="power">
                        <tr>
                            <td class="center">
                                <label>
                                    <input type="checkbox" class="ace" />
                                    <span class="lbl"></span>
                                </label>
                            </td>
                            <th class="hidden">${power.powerid}</th>
                            <td class="hidden-320">${power.powername}</td>

                            <td class="hidden-320">
                                <c:if test="${power.type=='1'}">
                                    父目录
                                </c:if>
                                <c:if test="${power.type=='0'}">
                                    子目录
                                </c:if>
                            </td>
                            <td class="hidden-320">${power.parPower.powername}</td>
                            <td class="hidden-320">${power.url}</td>
                            <td class="hidden-320">${power.description}</td>
                            <td class="hidden-320">
                                <c:if test="${power.status=='1'}">
                                    可用
                                </c:if>
                                <c:if test="${power.status=='0'}">
                                    不可用
                                </c:if>
                            </td>
                            <td>
                                <div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">

                                    <a class="green" href="#" onclick="option('/power/edit','powerid',${power.powerid})">
                                        <i class="icon-pencil bigger-130"></i>
                                    </a>

                                    <a class="red" href="#" onclick="option('/power/delete','powerid',${power.powerid})">
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
                <li class="prev" onclick="searchByKey('/power/search','powerKey',1)">
                    <a href="#">
                        <i class="icon-double-angle-left"></i>
                    </a>
                </li>
                <c:forEach begin="1" end="${powerPage.total}" var="page">
                    <li class="prev" onclick="searchByKey('/power/search','powerKey',${page})">
                        <a href="#">${page}</a>
                    </li>
                </c:forEach>
                <li class="prev" onclick="searchByKey('/power/search','powerKey',${powerPage.total})">
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
