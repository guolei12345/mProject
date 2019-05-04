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
                                    <input type="checkbox" id="checkAll" onclick="orderCheck(this)" class="ace" />
                                    <span class="lbl"></span>
                                </label>
                            </td>
                            <th class="center">订单号</th>
                            <th>电影</th>
                            <th>影厅</th>
                            <th class="hidden-xs">开始时间</th>
                            <th>座位号</th>
                            <th>价格</th>
                            <th>支付状态</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${userScheduleList}" var="userSchedule" varStatus="idx">
                        <tr>
                            <th class="center">
                                <label>
                                    <input type="checkbox" name="onlyOne" id="${userSchedule.id}" onclick="orderCheck(this)" class="ace onlyOne" />
                                    <span class="lbl"></span>
                                </label>
                            </th>
                            <th class="center">${userSchedule.id}</th>
                            <th>${userSchedule.movie.movename}</th>
                            <th>${userSchedule.hall.hallheats}</th>
                            <th class="hidden-xs">${userSchedule.schedule.time}</th>
                            <th>${userSchedule.setnum}</th>
                            <th id="${idx.index}" class="price" name="price">${userSchedule.schedule.price}</th>
                            <th>
                                <c:if test="${userSchedule.colum1=='1'}">
                                    <span style="color:green">已支付</span>
                                </c:if>
                                <c:if test="${userSchedule.colum1!='1'}">
                                    <span style="color:red">未支付</span>
                                </c:if>
                            </th>
                            <th>
                                <c:if test="${userSchedule.colum1!='1'}">
                                    <a class="red" href="#" onclick="option('/movie/deleteOrder','userScheduleId',${userSchedule.id})">
                                        <i class="icon-trash bigger-130"></i>
                                    </a>
                                </c:if>
                            </th>
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
                            <span class="red" id="total"></span>
                            <span class="red">元</span>
                            <span class="red"><button class="btn btn-success" onclick="pay()">
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
        //选中所有
        if(date.id=='checkAll'){
            var checkedList = $(".onlyOne");
            for (i=0;i<checkedList.length;i++){
                checkedList[i].checked=date.checked;
            }
        }else{
            var checkedList = $(".onlyOne");
            var isChecked = true;
            for (i=0;i<checkedList.length;i++){
                if(!checkedList[i].checked){
                    isChecked = false;break;
                }
            }
            var check = $("#checkAll");
            check[0].checked = isChecked;
        }
        showAllPrice();
    }
    //显示选中订单的价格
    function showAllPrice() {
        var orderTab = $("#orderTab");
        //在table中找input下类型为checkbox属性为选中状态的数据
        var checked = $("table input[type=checkbox]:checked");
        var total = 0;
        for (i=0;i<checked.length;i++){
            var id = checked[i].id;
            if(id == "checkAll"){
                continue;
            }
            var url = "/movie/moviePrice";
            var price = 0;
            var data = {
                id:id
            };
            $.ajax({
                type:"post",
                url:url,
                async:false,
                data:JSON.stringify(data),
                contentType:"application/json;charset=utf-8",
                success:function(dt){
                    price = parseInt(dt.toString());
                }
            })
            total = total+price;
        };
        $("#total").html(total);
    }
    //支付
    function  pay() {
        var checked = $("table input[type=checkbox]:checked");
        var array=new Array();
        for(i=0;i<checked.length;i++){
            var id = checked[i].id;
            if(id == "checkAll"){
                continue;
            }
            array.push(id);
        }
        var data = {
            ids:array
        }
        var urls = "/movie/pay";
        $.ajax({
            type:"post",
            url:urls,
            data:JSON.stringify(data),
            contentType:"application/json;charset=utf-8",
            success:function(dt){
                $("#load").html(dt);
            }
        });
    }
</script>
</body>
</html>

