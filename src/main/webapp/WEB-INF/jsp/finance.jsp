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
			  <li><a href="#">财务</a></li>
			  <li class="active">支出</li>
			</ol> 
            </div>


            <div class="row" style="margin-right:20px ;">
                <div class="col-md-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">最新支出</div>
                        <div class="panel-body">
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>产品</th>
                                    <th>数量</th>
                                    <th>总金额</th>
                                    <th>业务员</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>产品名称1</td>
                                    <td>x</td>
                                    <td>y</td>
                                    <td>abc</td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>产品名称2</td>
                                    <td>x</td>
                                    <td>y</td>
                                    <td>abc</td>
                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td>产品名称3</td>
                                    <td>x</td>
                                    <td>y</td>
                                    <td>abc</td>
                                </tr>
                                </tbody>
                            </table>
                            <button type="button" class="btn btn-primary">查看详情 >></button>
                        </div>
                    </div>
                </div>


                <div class="col-md-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">月度支出</div>
                        <div class="panel-body">
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>产品</th>
                                    <th>数量</th>
                                    <th>总金额</th>
                                    <th>月份</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>产品名称1</td>
                                    <td>x</td>
                                    <td>y</td>
                                    <td>z</td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>产品名称2</td>
                                    <td>x</td>
                                    <td>y</td>
                                    <td>z</td>
                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td>产品名称3</td>
                                    <td>x</td>
                                    <td>y</td>
                                    <td>z</td>
                                </tr>
                                </tbody>
                            </table>
                            <button type="button" class="btn btn-primary">查看详情 >></button>
                        </div>
                    </div>
                </div>
                

                <div class="col-md-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">年度支出</div>
                        <div class="panel-body">
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>产品</th>
                                    <th>数量</th>
                                    <th>总金额</th>
                                    <th>业务员</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>产品名称1</td>
                                    <td>x</td>
                                    <td>y</td>
                                    <td>z</td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>产品名称2</td>
                                    <td>x</td>
                                    <td>y</td>
                                    <td>z</td>
                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td>产品名称3</td>
                                    <td>x</td>
                                    <td>y</td>
                                    <td>z</td>
                                </tr>
                                </tbody>
                            </table>
                            <button type="button" class="btn btn-primary">查看详情 >></button>
                        </div>
                    </div>
                </div>
                
                

                <div class="col-md-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">添加支出</div>
                        <div class="panel-body">
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>产品</th>
                                    <th>数量</th>
                                    <th>总金额</th>
                                    <th>业务员</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>产品名称1</td>
                                    <td>x</td>
                                    <td>y</td>
                                    <td>abc</td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>产品名称2</td>
                                    <td>x</td>
                                    <td>y</td>
                                    <td>abc</td>
                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td>产品名称3</td>
                                    <td>x</td>
                                    <td>y</td>
                                    <td>abc</td>
                                </tr>
                                </tbody>
                            </table>                        
                            <div style="text-align:center">
                            <button type="submit"  class="btn btn-primary">添加</button>
                            </div>
                        </div>
                    </div>
                </div>
            

                
                

                
                
            </div>
        </div>
    </div>
</div>
<script src=" http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>