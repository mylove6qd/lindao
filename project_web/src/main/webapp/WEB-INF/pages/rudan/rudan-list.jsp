<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../base.jsp"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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

    function query(){

        //搜索页面关键字
        var query = document.getElementById("query").value;


        //操作page页面
        document.getElementById("queryhidden").value = query;

        document.getElementById("pageForm").submit()
    }

    <%--function deleteById() {--%>
    <%--    var id = getCheckId()--%>
    <%--    if(id) {--%>
    <%--        if(confirm("你确认要删除此条记录吗？")) {--%>
    <%--          //  location.href="${ctx}/system/user/delete.do?id="+id;--%>
    <%--        }--%>
    <%--    }else{--%>
    <%--        alert("请勾选待处理的记录，且每次只能勾选一个")--%>
    <%--    }--%>
    <%--}--%>

    <%--function roleList() {--%>
    <%--    var id = getCheckId()--%>
    <%--    if(id) {--%>
    <%--        location.href="${ctx}/system/user/roleList.do?id="+id;--%>
    <%--    }else{--%>
    <%--        alert("请勾选待处理的记录，且每次只能勾选一个")--%>
    <%--    }--%>
    <%--}--%>
</script>
<body>
<div id="frameContent" class="content-wrapper" style="margin-left:0px;">
    <section class="content-header">
        <h1>
            入单管理
            <small>入仓</small>
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
                                <%--                            <shiro:hasPermission name="添加用户">--%>
<%--                                <button type="button" class="btn btn-default" title="新建" onclick='location.href="${ctx}/system/user/toAdd.do"'><i class="fa fa-file-o"></i> 新建</button>--%>
                                <%--                            </shiro:hasPermission>--%>

                                <%--                            <shiro:hasPermission name="删除用户">--%>
<%--                                <button type="button" class="btn btn-default" title="删除" onclick='deleteById()'><i class="fa fa-trash-o"></i> 删除</button>--%>
                                <%--                            </shiro:hasPermission>--%>


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
                            <th class="sorting">详细信息</th>

                            <th class="text-center">操作</th>

                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${page.list}" var="item" varStatus="a">
                            <tr>
                                <td>${item.fbaId}</td>
                                <td>${item.remark}</td>

                                <th class="text-center">
                                    <button type="button" class="btn bg-olive btn-xs" onclick='location.href="${ctx}/rudan/rucang/update.do?id=${item.invoiceId}"'>入仓</button>
                                </th>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="box-footer">
                <jsp:include page="../common/page.jsp">
                    <jsp:param value="${ctx}/rudan/rucang/list.do" name="pageUrl"/>
                </jsp:include>
            </div>
        </div>

    </section>
</div>
</body>

</html>