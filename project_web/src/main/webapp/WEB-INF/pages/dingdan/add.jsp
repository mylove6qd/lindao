<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../base.jsp"%>
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
<div id="frameContent">
    <!-- 内容头部 -->
    <section class="content-header" class="content-wrapper" style="margin-left:0px;">
        <h1>
            客户管理
            <small>下单管理</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="all-admin-index.html"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li><a href="all-order-manage-list.html">客户管理</a></li>
            <li class="active">下单管理</li>
        </ol>
    </section>
    <!-- 内容头部 /-->

    <!-- 正文区域 -->
    <section class="content">

        <!--订单信息-->
        <div class="panel panel-default">
            <div class="panel-heading">下单管理</div>
            <form id="editForm" action="${ctx}/xiadan/edit.do" method="post">
                <%--                <input type="hidden" name="id" value="${company.companyId}">--%>
                <div class="row data-type" style="margin: 0px">

                    <div class="col-md-2 title">FBA号</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" required placeholder="FBA号" name="fbaId" >
                    </div>

                    <div class="col-md-2 title">发件公司</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" required placeholder="发件公司" name="invoiceFromCompany" >
                    </div>


                    <div class="col-md-2 title">收件地址</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" required placeholder="收件地址" name="toAdress"   >
                    </div>

                    <div class="col-md-2 title">目的地国家</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" required placeholder="目的地国家" name="country"  >
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

</html>