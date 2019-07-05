<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<body>
<div class="pull-left">
    <div class="form-group form-inline">
        总共${page.pages} 页，共${page.total} 条数据。
        <select id="selectSize" class="form-control" onchange="setSize()">
                                    <option ${page.pageSize==5?'selected':''}>5</option>
                                    <option ${page.pageSize==10?'selected':''}>10</option>
                                    <option ${page.pageSize==15?'selected':''}>15</option>
                                    <option ${page.pageSize==20?'selected':''}>20</option>
                                </select> 条
    </div>
</div>

<div class="box-tools pull-right">
    <ul class="pagination" style="margin: 0px;">
        <li >
            <a href="javascript:goPage(1)" aria-label="Previous">首页</a>
        </li>
        <li><a href="javascript:goPage(${page.prePage})">上一页</a></li>
        <c:forEach begin="${page.navigateFirstPage}" end="${page.navigateLastPage}" var="i">
            <li class="paginate_button ${page.pageNum==i ? 'active':''}"><a href="javascript:goPage(${i})">${i}</a></li>
        </c:forEach>
        <li><a href="javascript:goPage(${page.nextPage})">下一页</a></li>
        <li>
            <a href="javascript:goPage(${page.pageSize})" aria-label="Next">尾页</a>
        </li>
    </ul>
</div>
<form id="pageForm" action="${param.pageUrl}" method="post">

    <input type="hidden" name="page" id="pageNum">
    <input type="hidden" name="size" id="size">
    <input type="hidden" name="query" id="queryhidden">
</form>
<script>
    function goPage(page) {
        document.getElementById("pageNum").value = page
        var object = document.getElementById("selectSize").value;
        document.getElementById("size").value = object;

        var query = document.getElementById("query").value;
        document.getElementById("queryhidden").value = query;

        document.getElementById("pageForm").submit()
    }
    function setSize() {
        var object = document.getElementById("selectSize").value;
        document.getElementById("size").value = object;

        var query = document.getElementById("query").value;
        document.getElementById("queryhidden").value = query;

        document.getElementById("pageForm").submit()

    }
</script>
</body>


<%--<body>--%>
<%--<div class="pull-left">--%>
<%--    <div class="form-group form-inline">--%>
<%--        总共${page.pages} 页，共${page.total} 条数据。--%>
<%--    </div>--%>
<%--</div>--%>

<%--<div class="box-tools pull-right">--%>
<%--    <ul class="pagination" style="margin: 0px;">--%>
<%--        <li >--%>
<%--            <a href="javascript:goPage(1)" aria-label="Previous">首页</a>--%>
<%--        </li>--%>
<%--        <li><a href="javascript:goPage(${page.prePage})">上一页</a></li>--%>
<%--        <c:forEach begin="${page.navigateFirstPage}" end="${page.navigateLastPage}" var="i">--%>
<%--            <li class="paginate_button ${page.pageNum==i ? 'active':''}"><a href="javascript:goPage(${i})">${i}</a></li>--%>
<%--        </c:forEach>--%>
<%--        <li><a href="javascript:goPage(${page.nextPage})">下一页</a></li>--%>
<%--        <li>--%>
<%--            <a href="javascript:goPage(${page.pages})" aria-label="Next">尾页</a>--%>
<%--        </li>--%>
<%--    </ul>--%>
<%--</div>--%>
<%--<form id="pageForm" action="${param.pageUrl}" method="post">--%>
<%--    <input type="hidden" name="page" id="pageNum">--%>
<%--</form>--%>
<%--<script>--%>
<%--    function goPage(page) {--%>
<%--        document.getElementById("pageNum").value = page--%>
<%--        document.getElementById("pageForm").submit()--%>
<%--    }--%>
<%--</script>--%>
</body>
</html>
