<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="../../base.jsp"%>
<!DOCTYPE html>
<html>

<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>数据 - AdminLTE2定制版</title>
    <meta name="description" content="AdminLTE2定制版">
    <meta name="keywords" content="AdminLTE2定制版">
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <!-- 页面meta /-->
</head>
<body>
<div id="frameContent" class="content-wrapper" style="margin-left:0px;">
    <!-- 内容头部 -->
    <section class="content-header">
        <h1>
            系统管理
            <small>用户管理</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="${ctx}"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li><a href="${ctx}/system/user/list.do">用户列表</a></li>
        </ol>
    </section>
    <!-- 内容头部 /-->

    <!-- 正文区域 -->
    <section class="content">

        <!--订单信息-->
        <div class="panel panel-default">
            <div class="panel-heading">用户信息</div>
            <form id="editForm" action="${ctx}/system/user/edit.do" method="post">

                <div class="row data-type" style="margin: 0px">
                    <div class="col-md-2 title">用户名称*</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="用户名称*" name="userName" required >
                    </div>

                    <div class="col-md-2 title">所在公司*</div>
                    <div class="col-md-4 data">
                        <select class="form-control" id="se" name="companyId" onchange="a(this.options[this.options.selectedIndex].value)">
                            <c:forEach items="${companyList}" var="item">
                                <option  value="${item.companyId}"  ${item.companyId=='1'?'selected':''}>${item.companyName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <script>


                        function a(b) {
                            if(b!=1) {

                                document.getElementById("xs").disabled=true;

                                document.getElementById("haha").disabled = !true;
                                document.getElementById("haha").checked=true;
                                document.getElementById("haha1").checked=!true;
                                document.getElementById('haha1').disabled = !false;
                                document.getElementById('haha2').disabled = !false;
                                document.getElementById('haha3').disabled = !false;
                                document.getElementById('haha4').disabled = !false;
                                document.getElementById('haha5').disabled = !false;

                            }else{
                                document.getElementById("xs").disabled=!true;
                                document.getElementById("haha1").checked=true;
                                document.getElementById("haha").checked=!true;
                                document.getElementById('haha').disabled = true;
                                document.getElementById('haha1').disabled = false;
                                document.getElementById('haha2').disabled = false;
                                document.getElementById('haha3').disabled = false;
                                document.getElementById('haha4').disabled = false;
                                document.getElementById('haha5').disabled = false;

                            }
                        }
                    </script>
                    <div class="col-md-2 title">邮箱</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="邮箱" name="userEmail" pattern="^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$" oninvalid="setCustomValidity('邮箱不合法')" oninput="setCustomValidity('')">
                    </div>

                    <div class="col-md-2 title">密码*</div>
                    <div class="col-md-4 data">
                        <input type="password" class="form-control" placeholder="密码" required name="password" >
                    </div>

                    <div class="col-md-2 title">薪水</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control"  id="xs" placeholder="薪水" name="wage" >
                    </div>



                    <div class="col-md-2 title">入职时间</div>
                    <div class="col-md-4 data">
                        <div class="input-group date">
                            <div class="input-group-addon">
                                <i class="fa fa-calendar"></i>
                            </div>
                            <input type="text" placeholder="入职时间"  name="createDate" class="form-control pull-right"
                                   id="datepicker">
                        </div>
                    </div>

                    <div class="col-md-2 title">职位*</div>
                    <div class="col-md-4 data">
                        <div class="form-group form-inline">
                            <div class="radio" ><label><input id="haha" type="radio" disabled name="position" value="客户">客户使用</label></div>
                            <div class="radio" ><label><input type="radio" id="haha1" name="position" checked value="司机">司机</label></div>
                            <div class="radio " ><label><input type="radio" id="haha2" name="position" value="老板">老板</label></div>
                            <div class="radio " ><label><input type="radio" id="haha3" name="position" value="财务">财务</label></div>
                            <div class="radio " ><label><input type="radio" id="haha4" name="position" value="入单">入单</label></div>
                            <div class="radio " ><label><input type="radio" id="haha5" name="position" value="管理">管理</label></div>
                        </div>
                    </div>






                    <div class="col-md-2 title">出生年月</div>
                    <div class="col-md-4 data">
                        <div class="input-group date">
                            <div class="input-group-addon">
                                <i class="fa fa-calendar"></i>
                            </div>
                            <input type="text" placeholder="出生年月" class="form-control pull-right" name="birthday"
                                   id="datepicker1">
                        </div>
                    </div>

                    <div class="col-md-2 title">备注</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="备注" name="remark">
                    </div>
                </div>
            </form>
        </div>
        <!--订单信息/-->

        <!--工具栏-->
        <div class="box-tools text-center">
            <button type="submit" form="editForm" class="btn bg-maroon">保存</button>
            <button type="button" class="btn bg-default" onclick="history.back(-1);">返回</button>
        </div>
        <!--工具栏/-->

    </section>
    <!-- 正文区域 /-->

</div>
<!-- 内容区域 /-->
</body>
<script src="../../plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="../../plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<link rel="stylesheet" href="../../css/style.css">
<script>
    $('#datepicker').datepicker({
        autoclose: true,
        format: 'yyyy-mm-dd'
    });
    $('#datepicker1').datepicker({
        autoclose: true,
        format: 'yyyy-mm-dd'
    });
</script>
</html>