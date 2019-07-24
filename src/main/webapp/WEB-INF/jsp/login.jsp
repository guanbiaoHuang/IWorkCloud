<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="styleSheet" href="${pageContext.request.contextPath}/css/index.css">
<link type="text/css" rel="styleSheet" href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/vendor/font-awesome/css/font-awesome.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>登陆</title>
</head>
<body>

	<div class="container">
			<div style="display: none" id="msg">
				<c:if test="${requestScope.msg!=null}">
					${requestScope.msg}
				</c:if>	
			</div>
            <div class="row" style="margin-top: 50px">
                <img class="img-responsive m-auto" id="iconImg" src="${pageContext.request.contextPath}/img/default.jpeg"/>
            </div>

            <div class="row" style="margin-top: 20px">
                <div class="col-md-4 m-auto">
                    <form method="post" action="${pageContext.request.contextPath}/log">
                        <div class="form-group has-feedback">
                            <label class="sr-only"></label>
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-user fa-fw"></i></span>
                                <input type="tel" id="loginPhone" class="form-control input-lg" name="phone" placeholder="手机号码"/>
                            </div>
                        </div>

        
                        <div class="form-group has-feedback">
                            <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>
                                    <input type="password" class="form-control input-lg" name="password" placeholder="密码"/>
                            </div>        
                        </div>
                
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" name="remember" value="yes">
                                <small>记住密码</small>
                            </label>
                            <span><a class="pull-right" href="${pageContext.request.contextPath}/page/findPassword"><small>忘记密码？</small></a></span>

                        </div>
                        <div class="form-group">
                            <label class="sr-only"></label>
                            <button type="submit" class="btn btn-block btn-success">登陆</button>
                        </div>
                        
        
                    </form>
    			</div>
            </div> 
            
            <div class="row">
                    <div class="col-md-4 m-auto" style="margin-top: 20px">
                        <p class="text-center">没有账号?<a href="${pageContext.request.contextPath}/page/register">创建账号</a></p>
                    </div>
            </div>
    
        </div>

    <script type="text/javascript" src="${pageContext.request.contextPath}/vendor/jquery/jquery.js" ></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.js" ></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/layer/layer.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/log.js"></script>
    <script type="text/javascript">
    	$(document).ready(function(){
    		$("#loginPhone").blur(function(){
    			$.get(
    				"${pageContext.request.contextPath}/getIcon",
    				{"phone":$("#loginPhone").val()},
    				function(result){
    					if(result.length>0){
    						$("#iconImg").attr("src","${pageContext.request.contextPath}/getImg?img="+result);
    					}else{
    						layer.msg("手机号未注册");	
    					}
    						
    				}		
    			)
    		});
    		msg();

    	});
        function msg(){
            var $msg = $("#msg").text().trim();
            if($msg!="") {
                if($msg=="success"){
                    layer.msg("登陆成功，即将跳转");
                    setTimeout(function (){$(location).attr('href', '${pageContext.request.contextPath}/index')},3000);
                }else if($msg=="notBind"){
                    bind();
                }else {
                    layer.msg($msg);
                }
            }
        }

        function bind(){
            layer.prompt({title: '请输入输入工号绑定', formType: 1},function(val, index){
                $.post(
                    "${pageContext.request.contextPath}/bindStaff",
                    {"staffID":val},
                    function (result) {
                        if(result=="success"){
                            layer.msg("绑定成功，即将跳转");
                            setTimeout(function (){$(location).attr('href', '${pageContext.request.contextPath}/index')},3000);
                        }else {
                            layer.msg(result);
                        }

                    }
                );
                layer.close(index);
            });
        }
    
    </script>
</body>
</html>