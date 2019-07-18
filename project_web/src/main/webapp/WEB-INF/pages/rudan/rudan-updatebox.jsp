<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../base.jsp"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="v-bind" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="on-bind" uri="http://www.springframework.org/tags/form" %>
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
    <script src="${ctx}/js/vuejs-2.5.16.js"></script>
    <script src="${ctx}/js/axios-0.18.0.js"></script>
    <script src="${ctx}/js/vuejs-2.5.16.js"></script>
    <script src="${ctx}/js/axios-0.18.0.js"></script>
</head>

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


                                <button type="button" class="btn btn-default" title="刷新" onclick="window.location.reload();"><i class="fa fa-refresh"></i> 刷新</button>
                                <i>FBA号:${id}</i>
<%--                                {{entityList[0].inw}}-{{entityList[0].inx}}-{{entityList[0].iny}}-{{entityList[0].inz}}--%>

                            </div>
                        </div>
                    </div>


                    <form id="rucang" action="${ctx}/rudan/rucang/adddate.do" method="post">
                    <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
                        <thead>

                        <tr>
                            <td></td>
                            <td></td>
                            <td><input type="number" id="w1" onkeyup="changeInput('w')" onchange="changeInput('w')"></td>
                            <td><input type="number" id="x1" onkeyup="changeInput('x')" onchange="changeInput('x')"></td>
                            <td><input type="number" id="y1"onkeyup="changeInput('y')" onchange="changeInput('y')"></td>
                            <td><input type="number" id="z1" onkeyup="changeInput('z')" onchange="changeInput('z')"></td>
                        </tr>


                        <tr>
                            <th class="sorting">序号</th>
                            <th class="sorting">FBA箱号</th>
                            <th class="sorting">入仓重量</th>
                            <th class="sorting">入仓长</th>
                            <th class="sorting">入仓宽</th>
                            <th class="sorting">入仓高</th>



                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach items="${list}" var="item" varStatus="a">
                            <tr>
                                <td>${item.outsideId}</td><input type="hidden" name="outsideId" value="${item.outsideId}"/>
                                <td>${item.fbaId}</td><input type="hidden" name="fbaId" value="${item.fbaId}"/>
                                <td><input type="number" class="w" name="inhomeWeight" required ></td>
                                <td><input type="number" class="x" name="inhomeX" required ></td>
                                <td><input type="number" class="y" name="inhomeY" required ></td>
                                <td><input type="number" class="z" name="inhomeZ" required></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    </form>

                </div>
            </div>

            <div class="box-tools text-center">
                <button type="submit"  form="rucang" class="btn bg-maroon">保存</button>
                <button type="button" class="btn bg-default" onclick="history.back(-1);">返回</button>
            </div>

        </div>

    </section>
</div>

<script type="text/javascript">

function changeInput(classString) {
    var classob = "";
    var c = "";
    if (classString == 'w') {
        classob = document.getElementsByClassName('w');
        c = document.getElementById('w1');
    }else if(classString == 'x'){
        classob = document.getElementsByClassName('x');
        c = document.getElementById('x1');
    }else if(classString == 'y'){
        classob = document.getElementsByClassName('y');
        c = document.getElementById('y1');
    }else if(classString == 'z'){
        classob = document.getElementsByClassName('z');
        c = document.getElementById('z1');
    }
    for (var i = 0; i<classob.length;i++){
        classob[i].value = c.value;
    }
}
</script>
</body>

</html>