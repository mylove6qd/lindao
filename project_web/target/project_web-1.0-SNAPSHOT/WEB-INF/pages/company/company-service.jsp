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
<div id="frameContent" class="content-wrapper" style="margin-left:0px;">
    <!-- 内容头部 -->
    <section class="content-header">
        <h1>
            订单管理
            <small>订单表单</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="all-admin-index.html"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li><a href="all-order-manage-list.html">企业管理</a></li>
            <li class="active">服务添加</li>
        </ol>
    </section>
    <!-- 内容头部 /-->

    <!-- 正文区域 -->
    <section class="content">

        <!--订单信息-->
        <div class="panel panel-default">
            <div class="panel-heading">订单信息</div>
            <form id="editForm" action="${ctx}/system/service/edit.do" method="post">
                <input type="hidden" name="serviceId" value="${service.serviceId}">
                <div class="row data-type" style="margin: 0px">
                    <div class="col-md-2 title">公司名称</div>
                    <div class="col-md-4 data">

                        <select class="form-control select2" name="companyId" style="width: 100%;">
                            <c:forEach items="${company}" var="item">
                            <option value="${item.companyId}">${item.companyName}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="col-md-2 title">服务名称</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" required placeholder="服务名称" name="remark" value="${service.remark}">
                    </div>

                    <div class="col-md-2 title">价格</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" required placeholder="价格" name="price" value="${service.price}">
                    </div>

                </div>
            </form>
        </div>
        <!--订单信息/-->

        <!--工具栏-->
        <div class="box-tools text-center">
            <button  type="submit" form="editForm" class="btn bg-maroon">保存</button>
            <button type="button" class="btn bg-default" onclick="history.back(-1);">返回</button>
        </div>
        <!--工具栏/-->

    </section>
    <!-- 正文区域 /-->

</div>
<!-- 内容区域 /-->
</body>

</html>