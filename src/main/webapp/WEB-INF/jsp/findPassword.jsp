<%--
  Created by IntelliJ IDEA.
  User: 温康康
  Date: 2019/7/24
  Time: 9:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link type="text/css" rel="styleSheet" href="${pageContext.request.contextPath}/css/index.css">
    <link type="text/css" rel="styleSheet" href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/vendor/font-awesome/css/font-awesome.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>找回密码</title>
</head>
<body>
<div class="container">
    <div style="display: none" id="msg">
        <c:if test="${requestScope.msg!=null}">
            ${requestScope.msg}
        </c:if>
    </div>

    <div class="row" style="margin-top: 80px">
        <div class="col-md-4 m-auto">
            <form method="post" action="${pageContext.request.contextPath}/findPassword" onsubmit="return checkWhenFindPassword()">
                <div class="form-group has-feedback">
                    <label class="sr-only"></label>
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user fa-fw"></i></span>
                        <input type="tel" id="newPhone" class="form-control input-lg" name="newPhone" placeholder="请输入手机号码"/>
                    </div>
                </div>

                <div class="form-group has-feedback">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>
                        <input type="password" class="form-control input-lg" name="password" id="pas1" placeholder="请输入新密码"/>
                    </div>
                </div>

                <div class="form-group has-feedback">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-key fa-fw"></i> </span>
                        <input type="password" class="form-control input-lg" id="pas2" placeholder="请再次确认密码">
                    </div>
                </div>

                <div class="form-group has-feedback">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-keyboard-o fa-fw"></i></span>
                        <input type="text" id="verifyCode" class="form-control" placeholder="输入验证码" name="verifyCode"/>
                        <span class="input-group-btn">
                                    <button type="button" class="btn btn-group btn-toolbar" id="getCode">获取验证码</button>
                                </span>
                    </div>
                </div>

                <div class="form-group">
                    <label class="sr-only"></label>
                    <button type="submit" class="btn btn-block btn-success">确定</button>
                </div>

            </form>
        </div>
    </div>

</div>


<script type="text/javascript" src="${pageContext.request.contextPath}/vendor/jquery/jquery.js" ></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/layer/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/regist.js"></script>
<script type="text/javascript">
    $(document).ready(function(){

        $("#getCode").click(function(){
            var $newPhone = $("#loginPhone").val();
            if(!(/^1[3456789]\d{9}$/.test($newPhone))){
                layer.msg("手机号非法");
            }else{
                $.post(
                    "${pageContext.request.contextPath}/checkCode",
                    {"newPhone":$newPhone},
                    function(result){
                        getCodeClick();
                        layer.msg(result);
                    }
                );
            }
        });
    });

    function checkWhenFindPassword() {
        var $newPhone = $("#newPhone").val();
        var $password = $("#pas1").val();
        var $passwordSec = $("#pas2").val();
        var $verifyCode = $("#verifyCode").val();

        if(!(/^1[3456789]\d{9}$/.test($newPhone))){
            layer.msg("手机号非法");
            return false;
        }
        if(!(/^(?![A-Z]+$)(?![a-z]+$)(?!\d+$)\S{8,16}$/.test($password))){
            layer.msg("密码必须由字母开头的8-16位字母加数字组成");
            return false;
        }
        if(!($password==$passwordSec)){
            layer.msg("两次密码不一致");
            return false;
        }
        if(!(/\d{6}$/.test($verifyCode))){
            layer.msg("验证码为6位数字");
            return false;
        }
        return true;
    }
</script>
</body>
</html>
