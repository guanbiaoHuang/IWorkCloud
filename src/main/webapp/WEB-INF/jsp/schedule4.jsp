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
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/note.css" type="text/css">
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
			  <li><a href="#">日程</a></li>
			  <li class="active">记事本</li>
			</ol> 
            </div>


<h1>记事本</h1> 
<div class="main"> 
    <div class="write" id="write"> 
        标题: <input id="title" type="text" placeholder="请输入标题"><br><br> 
        分类: <select id="type"> 
                <option value="默认" selected>-请选择-</option> 
                <option value="美食">美食</option> 
                <option value="代码">代码</option> 
                <option value="生活">生活</option> 
            </select> 
        <br><br> 
        <textarea name="" id="cont" cols="30" rows="10" placeholder="今天想说点啥..."></textarea> 
        <div class="send" id="add">添加</div> 
    </div> 
    <div class="list" id="list"> 
        标题: <input id="title1" type="text" placeholder="查询标题"><br><br> 
        分类: <select id="type1"> 
                <option value="默认" selected>-请选择-</option> 
                <option value="美食">美食</option> 
                <option value="代码">代码</option> 
                <option value="生活">生活</option> 
            </select> 
        <div id="search" class="send">查询</div><br><br> 
        <div id="noteList"></div> 
    </div> 
</div> 
<script type="template" id="temp"> 
    <div class="item"> 
        <div class="title">@title<span>@type: @date</span></div> 
        <div class="content">@cont</div> 
    </div> 
</script> 
<script> 
$(function(){ 
    var init = {title:'这是标题', 
        date:new Date().toLocaleString(), 
        type:'示例', 
        cont:'这是一个笔记应用,不需要联网,也不需要数据库,可以直接把数据储存在本地.方便易用!^_^'}; 
    function show(notes){ 
        var temp = $('#temp').html(); 
        var tempStr= ''; 
        //如果不是数组,变成数组 
        if(!Array.isArray(notes)){ 
            notes = [notes]; 
        } 
        for(var i=notes.length-1;i>-1;i--){ 
            var note = notes[i]; 
            tempStr += temp.replace('@title',note.title) 
                    .replace('@date',note.date) 
                    .replace('@type',note.type) 
                    .replace('@cont',note.cont); 
        } 
        $('#noteList').html(tempStr); 
    } 
 
    //读取所有数据 
    function showList(){ 
        var notes = localStorage.getItem('notes'); 
        if(!notes){ 
            show(init); 
        }else{ 
            notes = JSON.parse(notes); 
            show(notes); 
        } 
        //第一个展开 
        $('#noteList .item:first').find('.title').trigger('click'); 
    } 
 
    $('#add').click(function(){ 
        var title = $('#title').val(); 
        var cont = $('#cont').val(); 
        var type = $('#type').val(); 
        if(title == ''){ 
            alert('标题不能为空!'); 
            return; 
        } 
        var data = {title:title,cont:cont,type:type,date:new Date().toLocaleString()}; 
        var notes = localStorage.getItem('notes'); 
        if(!notes){ 
            notes = []; 
        }else{ 
            notes = JSON.parse(notes); 
        } 
        notes.push(data); 
        localStorage.setItem('notes',JSON.stringify(notes)); 
        showList(); 
    }); 
 
    $('#search').click(function(){ 
        var title = $('#title1').val(); 
        var type = $('#type1').val(); 
        var notes = localStorage.getItem('notes'); 
        if(!notes){ 
            alert('没有本地笔记数据!'); 
            return; 
        }else{ 
            notes = JSON.parse(notes); 
        } 
        var note = []; 
        for(var i=0;i<notes.length;i++){ 
            //notes[i] json对象 
            var flag = false; 
            if(!title){ 
                flag = notes[i].type==type; 
            }else if(!type){ 
                flag = notes[i].title.indexOf(title)>-1; 
            }else{ 
                flag = notes[i].title.indexOf(title)>-1 && notes[i].type==type; 
            } 
            if(flag){ 
                note.push(notes[i]); 
            } 
        } 
        if(note.length == 0){ 
            alert('抱歉~没有对应的笔记!'); 
        }else{ 
            show(note); 
        } 
    }); 
 
    $('body').on('click','#noteList .title', function(){ 
        $(this).next().slideToggle(); 
    }); 
 
    showList(); 
}) 
</script> 
  

                
                

                
                
            </div>
        </div>
    </div>
</div>
<script src=" http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>