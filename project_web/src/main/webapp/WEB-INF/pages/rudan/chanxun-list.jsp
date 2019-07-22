<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../base.jsp"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
</head>
<script>

    function chb() {
        var elementById = document.getElementById('fa');
        var elementsByClassName = document.getElementsByClassName('chb');
        for (var i = 0 ;i<elementsByClassName.length;i++){
            elementsByClassName[i].checked=elementById.checked;
        }
    }
    
    function query(){

        //搜索页面关键字
        var query = document.getElementById("query").value;


        //操作page页面
        document.getElementById("queryhidden").value = query;

        document.getElementById("pageForm").submit()
    }


</script>
<body>
<div id="frameContent" class="content-wrapper" style="margin-left:0px;">
    <section class="content-header">
        <h1>
            客户管理
            <small>货件查询</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="all-admin-index.html"><i class="fa fa-dashboard"></i> 首页</a></li>
        </ol>
    </section>
    <section class="content">
        <div class="box box-primary">
            <div class="box-header with-border">
                <h3 class="box-title">用户列表</h3>
            </div>
            <div class="box-body">
                <div class="table-box">
                    <div class="pull-left">
                        <div class="form-group form-inline">
                            <div class="btn-group">


                                <button type="button" class="btn btn-default" title="刷新" onclick="window.location.reload();"><i class="fa fa-refresh"></i> 刷新</button>

                                    <div class="box-tools pull-right">
                                        <div class="has-feedback">
                                            <input id="query" type="text" class="form-control input-sm" placeholder="FBA号查询" value="${query}">
                                            <button type="button" class="btn btn-default" title="查询" onclick='query()'> 查询</button>
                                        </div>
                                    </div>
                            </div>
                        </div>
                    </div>

                    <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
                        <thead>
                        <tr>

                            <th class="sorting">FBA号</th>
                            <th class="sorting">详情</th>
                            <th class="sorting">承运商-单号</th>
                            <th class="sorting">寄件日期</th>
                            <th class="sorting">查询链接</th>
                            <th class="text-center">操作</th>

                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${page.list}" var="item" varStatus="a">

                            <form id="smallform" action="${ctx}/huojian/chaxun/work.do" method="post">
                            <tr>
                                <input value="${item.invoiceId}" type="hidden" name="invoiceId">
                                <td>${item.fbaId}</td>
                                <td>${item.remark}</td>
                                <td>${item.queryId}</td>
                                <td>${item.date}</td>
                                <td><a href="${item.link}" target="_blank">${item.linkTest}</a></td>
                                <th class="text-center">
                                    <button form="smallform" type="submit" class="btn bg-olive btn-xs" >确认签收</button>
                                </th>
                            </tr>
                            </form>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="box-footer">
                <jsp:include page="../common/page.jsp">
                    <jsp:param value="${ctx}/huojian/chaxun/list.do" name="pageUrl"/>
                </jsp:include>
            </div>
        </div>

    </section>
</div>
</body>

</html>