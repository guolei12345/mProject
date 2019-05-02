<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>订单信息</title>
</head>

<body><%--增加电影信息--%>
<div class="position-relative">
    <div id="login-box" class="login-box visible widget-box no-border">
        <div class="widget-body">
            <div class="widget-main">
                <div>
                    <table class="table table-striped table-bordered" id="orderTab">
                        <thead>
                        <tr>
                            <td class="center">
                                <label>
                                    <input type="checkbox" id="checkAll" checked="checked" onclick="orderCheck(this)" class="ace" />
                                    <span class="lbl"></span>
                                </label>
                            </td>
                            <th class="center">订单号</th>
                            <th>电影</th>
                            <th>影厅</th>
                            <th class="hidden-xs">开始时间</th>
                            <th>座位号</th>
                            <th>价格</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${userScheduleList}" var="userSchedule">
                        <tr>
                            <td class="center">
                                <label>
                                    <input type="checkbox" name="onlyOne" id="${userSchedule.id}" checked="checked" onclick="orderCheck(this)" class="ace onlyOne" />
                                    <span class="lbl"></span>
                                </label>
                            </td>
                            <th class="center">${userSchedule.id}</th>
                            <th>${userSchedule.movie.movename}</th>
                            <th>${userSchedule.hall.hallheats}</th>
                            <th class="hidden-xs">${userSchedule.schedule.time}</th>
                            <th>${userSchedule.setnum}</th>
                            <th class="price">${userSchedule.schedule.price}</th>
                            <th><a class="red" href="#" onclick="option('/movie/deleteOrder','userScheduleId',${userSchedule.id})">
                                <i class="icon-trash bigger-130"></i>
                            </a></th>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>

                <div class="hr hr8 hr-double hr-dotted"></div>

                <div class="row">
                    <div class="col-sm-5 pull-right">
                        <h4 class="pull-right">
                            总价 :
                            <span class="red">X元</span>
                            <span class="red"><button class="btn btn-success">
                                支付
                            </button></span>
                        </h4>
                    </div>
                    <%--<div class="col-sm-7 pull-left">  </div>--%>
                </div>
            </div><!-- /widget-main -->
        </div><!-- /widget-body -->
    </div><!-- /login-box -->
</div><!-- /position-relative -->
<script type="text/javascript">
    function orderCheck(date) {
        debugger;
        //选中所有
        if(date.id=='checkAll'){
            var checkedList = $(".onlyOne");
            for (i=0;i<checkedList.length;i++){
                checkedList[i].checked=date.checked;
            }
            showAllPrice();
        }
    }
    function showAllPrice() {
        var orderTab = $("#orderTab");
        //在table中找input下类型为checkbox属性为选中状态的数据
        var checked = $("table input[type=checkbox]:checked");
        var total = 0;
        checked.each(function () {//遍历
            var row = $(this).parent("td").parent("tr");//获取选中行
            alert(row);
        })
    }
</script>
</body>
</html>

