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
	<script type="text/javascript" src='${pageContext.request.contextPath}/js/echarts.min.js'></script>
	<script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js" type="text/javascript"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/iwork.css" type="text/css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/time.css" type="text/css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/test.css" type="text/css">
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
			  <li><a href="#">日程</a></li>
			  <li class="active">日程表</li>
			</ol> 
			
			
		<div id="calendar" style="width: 400px;height:400px;float: left;">
            <h4>2019年7月</h4>
            <a href="##" class="a1">上月</a>
            <a href="##" class="a2">下月</a>
            <ul class="week">
                <li>日</li>
                <li>一</li>
                <li>二</li>
                <li>三</li>
                <li>四</li>
                <li>五</li>
                <li>六</li>

            </ul>
            <ul class="dateList"></ul>
        </div>

        <div style="margin-left: 30px;">
			 <center>
			<!-- Table goes in the document BODY -->
			<table class="imagetable" width="800" height="400">
			<tr colspan="8">作息表</tr>
			<tr>
			    <th>时间</th>
			    <th>星期一</th>
			    <th>星期二</th>
			    <th>星期三</th>
			    <th>星期四</th>
			    <th>星期五</th>
			    <th>星期六</th>
			    <th>星期天</th>
			</tr>
			<tr align="center">
			    <td>7:30-8:20</td>
			    <td>起床</td>
			    <td>起床</td>
			    <td>起床</td>
			    <td>起床</td>
			    <td>起床</td>
			    <td rowspan="3">工作2小时</td>
			    <td rowspan="3">学习1小时</td>
			</tr>
			<tr>
			<td colspan = "6" height="10">上班start</td>
			</tr>
			<tr align="center">
			    <td>8:45-11:55</td>
			    <td>工作</td>
			    <td>工作</td>
			    <td>工作</td>
			    <td>工作</td>
			    <td>工作</td>
			<tr>
			<td colspan = "8" height="50">午休时间90min</td>
			</tr>
			<tr align="center">
			    <td>13:30-15:30</td>
			    <td>工作</td>
			    <td>工作</td>
			    <td>工作</td>
			    <td>工作</td>
			    <td>工作</td>
			    <td rowspan="7">做毕设</td>
			    <td rowspan="7">工作2小时</td>
			</tr>
			<tr>
			<td colspan = "6" height="10">下午活动时间20min</td>
			</tr>
			<tr align="center">
			    <td>15:50-18:10</td>
			    <td>工作</td>
			    <td>工作</td>
			    <td>工作</td>
			    <td>工作</td>
			    <td>工作</td>
			</tr>
			<tr>
			<td colspan = "6" height="10">下班end</td>
			</tr>
			<tr align="center">
			    <td>19:30-22:00</td>
			    <td>学习、工作</td>
			    <td>学习、工作</td>
			    <td>学习、工作</td>
			    <td>学习、工作</td>
			    <td>学习、工作</td>
			</tr>
			<tr >
			<td colspan = "6" height="10" bgcolor="red">自由时间</td>
			</tr>
			<tr align="center">
			    <td>23:00 -</td>
			    <td>晚安</td>
			    <td>晚安</td>
			    <td>晚安</td>
			    <td>晚安</td>
			    <td>晚安</td>
			</tr>
			</table>
			</center>	
        </div>

        <script>
            $(function() {

                //必要的数据
                //今天的年 月 日 ；本月的总天数；本月第一天是周几？？？
                var iNow=0;
                
                function run(n) {

                    var oDate = new Date(); //定义时间
                    oDate.setMonth(oDate.getMonth()+n);//设置月份
                    var year = oDate.getFullYear(); //年
                    var month = oDate.getMonth(); //月
                    var today = oDate.getDate(); //日

                    //计算本月有多少天
                    var allDay = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31][month];

                    //判断闰年
                    if(month == 1) {
                        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                            allDay = 29;
                        }
                    }

                    //判断本月第一天是星期几
                    oDate.setDate(1); //时间调整到本月第一天
                    var week = oDate.getDay(); //读取本月第一天是星期几

                    //console.log(week);
                  $(".dateList").empty();//每次清空
                    //插入空白

                    for(var i = 0; i < week; i++) {
                        $(".dateList").append("<li></li>");
                    }

                    //日期插入到dateList
                    for(var i = 1; i <= allDay; i++) {
                        $(".dateList").append("<li>" + i + "</li>")
                    }
                    //标记颜色=====================
                    $(".dateList li").each(function(i, elm){
                        //console.log(index,elm);
                        var val = $(this).text();
                        //console.log(val);
                        if (n==0) {
                            if(val<today){
                            $(this).addClass('ccc')
                        }else if(val==today){
                            $(this).addClass('red')
                        }else if(i%7==0  ||  i%7==6   ){
                            $(this).addClass('sun')
                        }
                        }else if(n<0){
                            $(this).addClass('ccc')
                        }else if(i%7==0  ||  i%7==6   ){
                            $(this).addClass('sun')
                        }
                    });

                    //定义标题日期
                    $("#calendar h4").text(year + "年" + (month + 1) + "月");
                };
                run(0);
                
                $(".a1").click(function(){
                    iNow--;
                    run(iNow);
                });
                
                $(".a2").click(function(){
                    iNow++;
                    run(iNow);
                })
            });
        </script>

    		</div>
			
			
        </div>



<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    
        
    </div>
</div>
<script src=" http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>