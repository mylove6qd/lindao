<%--<%@ page contentType="text/html; charset=utf-8"%>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>

<%--<head>--%>
<%--    <meta charset="utf-8">--%>
<%--    <meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
<%--    <title>数据 - AdminLTE2定制版 | Log in</title>--%>
<%--    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">--%>
<%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">--%>
<%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">--%>
<%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">--%>
<%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">--%>
<%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">--%>
<%--</head>--%>

<%--<script>--%>
<%--    window.onload = function () {--%>
<%--        if (window.parent.window != window) {--%>
<%--            window.top.location = "/login.jsp";--%>
<%--        }--%>
<%--    }--%>
<%--</script>--%>

<%--<body class="hold-transition login-page">--%>
<%--<div class="login-box">--%>
<%--    <div class="login-logo">--%>
<%--        <a href="all-admin-index.html">SaaS外贸出口云平台</a>--%>
<%--    </div>--%>
<%--    <!-- /.login-logo -->--%>
<%--    <div class="login-box-body">--%>
<%--        <p class="login-box-msg">登录系统</p>--%>
<%--        <form action="${pageContext.request.contextPath}/login.do" method="post">--%>
<%--            <div class="form-group has-feedback">--%>
<%--                <input type="email" name="email" class="form-control" placeholder="Email" value="lw@export.com">--%>
<%--                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>--%>
<%--            </div>--%>
<%--            <div class="form-group has-feedback">--%>
<%--                <input type="password" name="password" class="form-control" placeholder="密码" >--%>
<%--                <span class="glyphicon glyphicon-lock form-control-feedback"></span>--%>
<%--            </div>--%>
<%--            <div class="row">--%>
<%--                <div class="col-xs-8">--%>
<%--                    <div class="checkbox icheck">--%>
<%--                        <label class="">${error}</label>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="col-xs-4">--%>
<%--                    <button type="submit" class="btn btn-primary btn-block btn-flat">登录</button>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </form>--%>
<%--        <div class="social-auth-links text-center">--%>
<%--            <p>- 或者 -</p>--%>
<%--            <a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-qq"></i> 腾讯QQ用户登录</a>--%>
<%--            <a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-weixin"></i> 微信用户登录</a>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<%--<script src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>--%>
<%--<script src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>--%>
<%--<script src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>--%>
<%--<script>--%>
<%--    $(function() {--%>
<%--        $('input').iCheck({--%>
<%--            checkboxClass: 'icheckbox_square-blue',--%>
<%--            radioClass: 'iradio_square-blue',--%>
<%--            increaseArea: '20%' // optional--%>
<%--        });--%>
<%--    });--%>
<%--</script>--%>
<%--</body>--%>
<%--</html>--%>









<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>数据 - AdminLTE2定制版 | Log in</title>
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
    <script src="plugins/vue/vue.js"></script>
    <script src="plugins/vue/jquery-1.12.4.min.js"></script>
    <script src="plugins/vue/axios.min.js"></script>
</head>

<script>
    window.onload = function () {
        if (window.parent.window != window) {
            window.top.location = "/login.jsp";
        }
    }
</script>

<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <a href="all-admin-index.html">福州林道云平台</a>
    </div>
    <!-- /.login-logo -->
    <div class="login-box-body">
        <p class="login-box-msg">登录系统</p>
        <form id="VueTest" @keyup.enter.native="handleSubmit" v-on:submit.prevent="submit" action="${pageContext.request.contextPath}/loginVue.do" method="post">
            <div class="form-group has-feedback">
                <%--                value="cgx@export.com"--%>
                <input type="text" name="userName" class="form-control" placeholder="用户名" @kepup.enter="submit" v-model="user.userName" required >
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <%--                value="123456"--%>
                <input type="password" name="password" class="form-control" placeholder="密码" v-model="user.password" required>
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="row">
                <div class="col-xs-8">
                    <div class="checkbox icheck">
                        <label class="">${error}</label>
                    </div>
                </div>
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat"  >登录</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
<script>

    var VueTest = new Vue({
        el:'#VueTest',
        data:{
            user:{userName:'', password:''}
        },
        methods:{
            submit:function () {
                axios.post("${pageContext.request.contextPath}/loginVue.do",this.user).then(
                    function (res){
                        if(res.data.status1=='-1'){
                            alert('用户名或密码不正确');
                        }else{
                            location.href = "${pageContext.request.contextPath}/home/main.do"
                        }

                    }
                ).catch(function (err) {
                    alert(err);
                })

            }
        }
    });


    $(function() {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' // optional
        });
    });
</script>
</body>
</html>
