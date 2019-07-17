<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link type="text/css" rel="styleSheet" href="${pageContext.request.contextPath}/css/index.css">
    <link type="text/css" rel="styleSheet" href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/vendor/font-awesome/css/font-awesome.css">

<title>注册</title>
<body>
	<div class="container">
			<div style="display: none" id="msg">
				<c:if test="${requestScope.msg!=null}">
					${requestScope.msg}
					<c:remove var="msg" scope="request"/>
				</c:if>	
			</div>
            <div class="row"  style="margin-top: 50px">
                <img class="img-responsive m-auto" id="iconImg" src="${pageContext.request.contextPath}/img/default.jpeg"/>
            </div>
            <div class="row" style="margin-top: 20px">
                <div class="col-md-4 m-auto">
                    <form method="post" action="${pageContext.request.contextPath}/reg" enctype="multipart/form-data" onsubmit="return check()">

                        <input type="file" id="icons" style="display: none" name="icon"/>

                        <div class="form-group has-feedback">
                            <label class="sr-only"></label>
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-user fa-fw"></i></span>
                                <input type="text" id="registPhone" class="form-control" name="phone" placeholder="手机号码"/>
                            </div>
        
                        </div>
    
                        <div class="form-group has-feedback">
                            <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>
                                    <input type="password" id="password" class="form-control" name="password" placeholder="密码"/>
                            </div>        
                        </div>

                        <div class="form-group has-feedback">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>
                                <input type="password" id="passwordSec" class="form-control" name="passwordSec" placeholder="再次输入密码"/>
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
                            <button type="submit" class="btn btn-block btn-success">注册</button>
                        </div>
                    </form>
                </div>
            </div> 

            <div class="row">
                    <div class="col-md-4 m-auto" style="margin-top: 20px">
                        <p class="text-center">已有账号?<a href="${pageContext.request.contextPath}/page/login">返回登陆</a></p>
                    </div>
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
    					
    		
    	});
    
    
    </script>
    
</body>
</html>