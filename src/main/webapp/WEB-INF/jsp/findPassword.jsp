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
            <form method="post" action="${pageContext.request.contextPath}/findPassword">
                <div class="form-group has-feedback">
                    <label class="sr-only"></label>
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user fa-fw"></i></span>
                        <input type="tel" id="loginPhone" class="form-control input-lg" name="phone" placeholder="请输入手机号码"/>
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
                        <input type="password" class="form-control input-lg" name="checkPassword" id="pas2" placeholder="请再次确认密码">
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

            var $phone = $("#registPhone").val();
            if(!(/^1[3456789]\d{9}$/.test($phone))){
                layer.msg("手机号非法");
            }else{

                $.post(
                    "${pageContext.request.contextPath}/checkCode",
                    {"phone":$phone},
                    function(result){

                        getCodeClick();
                        layer.msg(result);
                    }
                );
            }


        });

        $("#pas2").blur(function () {
            if ($("#pas2").val() !== $("#pas1").val())
            {

            }
            else {

            }
        });

    });


</script>
</body>
</html>
