<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="styleSheet" href="${pageContext.request.contextPath}/css/index.css">
<link type="text/css" rel="styleSheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>注册</title>
<body>
	<div class="container">
			<div style="display: none" id="msg">
				<c:if test="${requestScope.msg!=null}">
					${requestScope.msg}
					<c:remove var="msg" scope="request"/>
				</c:if>	
			</div>
            <div class="row">
                <img class="img-responsive center-block" id="iconImg" src="${pageContext.request.contextPath}/img/default.jpeg"/>
            </div>
            <div class="row">
                <div class="col-md-6 col-md-offset-3" style="margin-top: 20px">
                    <form method="post" action="${pageContext.request.contextPath}/reg" enctype="multipart/form-data" onsubmit="return check()">
                        <input type="file" id="icons" class="hidden" name="icon"/>
                        <div class="form-group has-feedback">
                            <label class="sr-only"></label>
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-user fa-fw"></i></span>
                                <input type="text" id="registPhone" class="form-control input-lg" name="phone" placeholder="手机号码"/>
                            </div>
        
                        </div>
    
                        <div class="form-group has-feedback">
                            <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>
                                    <input type="password" id="password" class="form-control input-lg" name="password" placeholder="密码"/>
                            </div>        
                        </div>

                        <div class="form-group has-feedback">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>
                                <input type="password" id="passwordSec" class="form-control input-lg" name="passwordSec" placeholder="再次输入密码"/>
                            </div>        
                        </div>

                        <div class="form-group has-feedback">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-keyboard-o fa-fw"></i></span>
                                <input type="text" id="verifyCode" class="form-control input-lg" placeholder="输入验证码" name="verifyCode"/>
                                <span class="input-group-btn">
                                
                                    <button type="button" class="btn btn-default btn-lg" id="getCode">获取验证码</button>
                                </span> 
                            </div>       
                        </div>

                
                        <div class="form-group">
                            <label class="sr-only"></label>
                            <button type="submit" class="btn btn-block btn-success btn-lg">注册</button>
                        </div>
                    </form>
    
            </div> 
            
            <div class="row">
                    <div class="col-md-4 col-md-offset-4" style="margin-top: 20px">
                        <p class="text-center">已有账号?<a href="${pageContext.request.contextPath}/login">返回登陆</a></p>
                    </div>
            </div>
    
        </div>
    </div>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js" ></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js" ></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/layer/layer.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/regist.js"></script>
    <script type="text/javascript">
    	$(document).ready(function(){
    		
    		$("#getCode").click(function(){
    			
    			var $phone = $("#registPhone").val();
    			if(!(/^1[3456789]\d{9}$/.test($phone))){
    	    		layer.msg("手机号非法");
    	    	 }else{
    	    		 getCodeClick();
    	    		 $.post(
    	     				"${pageContext.request.contextPath}/checkCode",
    	     				{"phone":$phone},
    	     				function(result){
								layer.msg(result);
    	     				}
    	     			); 
    	    	 }
    			
    				
    		});
    					
    		
    	});
    
    
    </script>
    
</body>
</html>