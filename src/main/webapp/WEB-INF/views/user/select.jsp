<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
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
                        <select size="1" name="sample-table-2_length" aria-controls="sample-table-2">
                        <option value="10" selected="selected">10</option>
                            <option value="5">5</option>
                            <option value="10">10</option>
                            <option value="20">20</option>
                        </select> records</label>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="dataTables_filter" id="sample-table-2_filter">
                        <label>Search: <input type="text" aria-controls="sample-table-2"></label>
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
                            <th class="hidden-320">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${userList}" var="user">
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
                            <td class="hidden-320">${user.sex}</td>
                            <td class="hidden-320">${user.sign}</td>
                            <td>
                                <div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">

                                    <a class="green" href="#" onclick="option('/user/edit',${user.userid})">
                                        <i class="icon-pencil bigger-130"></i>
                                    </a>

                                    <a class="red" href="#" onclick="option('/user/delete',${user.userid})">
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

        <div id="modal-table" class="modal fade" tabindex="-1">
            <div class="modal-content">
                <ul class="pagination pull-right no-margin">
                    <li class="prev disabled">
                        <a href="#">
                            <i class="icon-double-angle-left"></i>
                        </a>
                    </li>

                    <li class="active">
                        <a href="#">1</a>
                    </li>

                    <li>
                        <a href="#">2</a>
                    </li>

                    <li>
                        <a href="#">3</a>
                    </li>

                    <li class="next">
                        <a href="#">
                            <i class="icon-double-angle-right"></i>
                        </a>
                    </li>
                </ul>
            </div><!-- /.modal-content -->
        </div><!-- /.main-content -->
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

    function option(url,userid){
        var urls = url+"?userid="+userid;
        $("#load").load(urls)
    }
</script>
</body>
</html>
