<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>iworkcloud</title>
	<link href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/iwork.css" type="text/css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/test.css" type="text/css">
	<script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js" type="text/javascript"></script>
</head>

<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#" style="font-size: 35px;"> iworkcloud</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

            
            
            <form class="navbar-form navbar-right" role="search">
            	<img src="${pageContext.request.contextPath}/img/touxiang.png" width="40" height="40" />&emsp;&emsp;&emsp;
            </form>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-2 sidebar">
			<div>			
			  <ul class="menu">
				  <li class="title"><span class="glyphicon glyphicon-user"></span>&emsp;个人中心</li>
				  <li class="content">
				    <ul>
				      <li><a href="#"></a></li>
				      <li><a href="#"></a></li>
				      <li><a href="#"></a></li>
				      <li><a href="#"></a></li>
				    </ul>
				  </li>
				</ul>
			  <ul class="menu">
			    <li class="title"><span class="glyphicon glyphicon-usd"></span>&emsp;财务</li>
			    <li class="content">
			      <ul>
			        <li><a href="finance.jsp">支出</a></li>
			        <li><a href="finance2.jsp">收入</a></li>
			        <li><a href="finance3.jsp">奖金</a></li>
			        <li><a href="finance4.jsp">补贴</a></li>
			      </ul>
			    </li>
			  </ul>
			  <ul class="menu">
			    <li class="title"><span class="glyphicon glyphicon-calendar"></span>&emsp;日程</li>
			    <li class="content">
			      <ul>
			        <li><a href="schedule.jsp">日程表</a></li>
			        <li><a href="schedule2.jsp">会议通知</a></li>
			        <li><a href="schedule3.jsp">请假</a></li>
			        <li><a href="schedule4.jsp">记事本</a></li>
			      </ul>
			    </li>
			  </ul>
			  <ul class="menu">
			    <li class="title"><span class="glyphicon glyphicon-map-marker"></span>&emsp;考勤</li>
			    <li class="content">
			      <ul>
			        <li><a href="attendance.jsp">查看考勤</a></li>
			        <li><a href="attendance2.jsp">查看出差</a></li>
			        <li><a href="attendance3.jsp">查看审批</a></li>
			        <li><a href="attendance4.jsp">优秀员工</a></li>
			      </ul>
			    </li>
			  </ul>
			  			  <ul class="menu">
			    <li class="title"><span class="glyphicon glyphicon-bell"></span>&emsp;活动</li>
			    <li class="content">
			      <ul>
			        <li><a href="#"></a></li>
			        <li><a href="#"></a></li>
			        <li><a href="#"></a></li>
			        <li><a href="#"></a></li>
			      </ul>
			    </li>
			  </ul>
			  			  			  <ul class="menu">
			    <li class="title"><span class="glyphicon glyphicon-lock"></span>&emsp;项目</li>
			    <li class="content">
			      <ul>
			        <li><a href="#"></a></li>
			        <li><a href="#"></a></li>
			        <li><a href="#"></a></li>
			        <li><a href="#"></a></li>
			      </ul>
			    </li>
			  </ul>
			  			  			  <ul class="menu">
			    <li class="title"><span class="glyphicon glyphicon-cog"></span>&emsp;系统</li>
			    <li class="content">
			      <ul>
			        <li><a href="#"></a></li>
			        <li><a href="#"></a></li>
			        <li><a href="#"></a></li>
			        <li><a href="#"></a></li>
			      </ul>
			    </li>
			  </ul>
			</div>
			
<script type="text/javascript">
$(function(){
  $(".content").hide();
  $(".title").click(function(){
    $(this).next().slideDown().parent().siblings().children(".content").slideUp();
  }).first().next().slideDown();
});
</script>	
			
        </div>

        <div class="col-md-10 col-md-offset-2">
            <div class="page-header">
			  <ol class="breadcrumb">
			  <li><a href="#">首页</a></li>
			  <li><a href="#">考勤</a></li>
			  <li class="active">优秀员工</li>
			</ol> 
            </div>


            <div class="row" style="margin-right:20px ;">            
                <div class="col-md-12" style="margin-top: 20px;">                                

				<div  align="center">
				<h4>优秀员工评选</h4>
					<table id="main" >
						<tr >
							<td>
								<input type="radio" name="option" checked="checked"/>王XX
							</td>
						</tr>
						<tr>
							<td style="width:550px">
								<div id=0 style="background-color:#acd6ff; width:98px; height:20px; border-width:0px;">
								</div>
							</td>
							<td>
								<label id="label0">98</label>票
							</td>
						</tr>
						<tr>
							<td>
								<input type="radio" name="option"  />李XX
							</td>
						</tr>
						<tr >
							<td>
								<div id=1 style="background-color:#0066cc; height:20px; width:253px; border-width:0px; border-color:blue; border-style:solid ; text-align:right;" ></div>
								
							</td>
							<td>
							<label id="label1">253</label>票
							</td>
						</tr>	
						<tr >
							<td>
								<input type="radio" name="option"  />张XX
							</td>
						</tr>
						<tr >
							<td>
								<div id=2 style="background-color:#ff7575; height:20px;width:75px;  border-width:0px; border-color:blue; border-style:solid ; text-align:right;" ></div>
								
							</td>
							<td>
							<label id="label2">75</label>票
							</td>
						</tr>	
						<tr>
							<td>
								<input type="radio" name="option" />刘XX
							</td>
						</tr>
						<tr >
							<td>
								<div id=3 style="background-color:#5cadad;height:20px;width:185px; border-width:0px; border-color:blue; border-style:solid ; text-align:right;" ></div>
								
							</td>
							<td>
							<label id="label3">185</label>票
							</td>
						</tr>
					
						<tr>
							<td><p>
								<input type="submit" value="确认投票" οnclick="vote()"/>		
							</td>
						</tr>
					</table>
				</div>
			
			<script>
			 
				//在每个投票选项后面写了个div，用div的宽度来代表当前该选项的投票数。
				function vote(){	//函数vote，当点击确认投票的时候，调用vote方法
					
					//for循环的条件是，所有投票选项的个数。
					for(var i = 0; i < document.getElementsByName("option").length; i++){
						
						//查找到是哪个投票选项被选中
						if(document.getElementsByName("option")[i].checked == true){
							var width = document.getElementById(i).style.width;	//获取到当前选项的宽度。
							width = parseInt(width);//将宽度转化为int型，因为获取到的width的单位是px
							width += 3;//改变width的值，这里就是定义每次投票的进度条的增速
							document.getElementById(i).style.width = width+"px";//修改原div的宽度
							
							var label = "label"+i;//lable标签里面写的是当前的投票数目。
							var num = document.getElementById(label).innerText;//获取到当前的票数
							document.getElementById(label).innerText = ++num;//票数加1，并修改原值
						}
					}
			 
					//alert("投票成功");
					
				}
			 
			</script>

              
                
            </div>
        </div>
    </div>
</div>
<script src=" http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</div>
</body>
</html>