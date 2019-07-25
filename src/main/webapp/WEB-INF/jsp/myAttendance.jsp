<%--
  Created by IntelliJ IDEA.
  User: jason
  Date: 2019/7/19
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>添加日程</title>
    <link href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

</head>
<body>
<div class="container">
    <div class="row" style="margin-top: 20px">
        <div class="col-10 m-auto">
            <div class="card mb-3">
                <div class="card-header">
                    <i class="fa fa-pie-chart"></i>我的考勤</div>
                <div class="card-body">
                    <canvas id="myAttendancePie" width="100%" height="60"></canvas>
                </div>
            </div>
        </div>
    </div>

</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/vendor/jquery/jquery.js" ></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.js" ></script>
<script src="${pageContext.request.contextPath}/vendor/chart.js/Chart.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/layer/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/regist.js"></script>
<script>
    $(document).ready(function () {
        var index = parent.layer.getFrameIndex(window.name); //获取当前窗体索引
        $('#submit').on('click', function(){
            parent.layer.close(index); //执行关闭
        });
    });

    Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
    Chart.defaults.global.defaultFontColor = '#292b2c';
    // -- Area Chart Example
    var ctx = document.getElementById("myAttendancePie");
    var myPieChart = new Chart(ctx, {
        type: 'pie',
        data: {
            labels: [ "未签到", "迟到", "准时签到"],
            datasets: [{
                data: [${absence},${late},${inTime}],
                backgroundColor: ['#dc3545', '#ffc107', '#28a745'],
            }],
        },
    });


</script>
</body>
</html>
