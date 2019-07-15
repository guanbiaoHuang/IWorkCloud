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
<title>登陆</title>
</head>
<body>

	<div class="container">
			<p style="display: none" id="msg">
				<c:if test="${requestScope.msg!=null}">
					${requestScope.msg}
				</c:if>	
			</p>	
            <div class="row">
                <img class="img-responsive center-block" id="iconImg" src="${pageContext.request.contextPath}/img/default.jpeg"/>
            </div>

            <div class="row">
                <div class="col-md-4 col-md-offset-4" style="margin-top: 20px">
                    <form method="post" action="${pageContext.request.contextPath}/log">
                        <div class="form-group has-feedback">
                            <label class="sr-only"></label>
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-user fa-fw"></i></span>
                                <input type="tel" id="loginPhone" class="form-control input-lg" name="phone" placeholder="手机号码"/>
                            </div>
        					<p id="phoneAlert" class="help-block hidden">text</p>
                        </div>

        
                        <div class="form-group has-feedback">
                            <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>
                                    <input type="password" class="form-control input-lg" name="password" placeholder="密码"/>
                            </div>        
                        </div>
                
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" name="remember" value="yes">记住密码
                            </label>
                            <span><a class="pull-right" href="#">忘记密码？</a></span>

                        </div>
                        <div class="form-group">
                            <label class="sr-only"></label>
                            <button type="submit" class="btn btn-block btn-success btn-lg">登陆</button>
                        </div>
                        
        
                    </form>
    			</div>
            </div> 
            
            <div class="row">
                    <div class="col-md-4 col-md-offset-4" style="margin-top: 20px">
                        <p class="text-center">没有账号?<a href="${pageContext.request.contextPath}/register">创建账号</a></p>
                    </div>
            </div>
    
        </div>

	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js" ></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js" ></script>
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
    						$("#iconImg").attr("src",result);
    					}else{
    						layer.msg("手机号未注册");	
    					}
    						
    				}		
    			)
    		}); 
    		msg();
    	})
    
    </script>
</body>
</html>