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
        <form class="col-10 m-auto" method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/page/addStaffXls">
            <div class="form-group" style="display: none;">
                <label class="sr-only"></label>
                <input type="file" class="form-control" name="file" id="file">
            </div>

            <div class="alert alert-success" role="alert" id="fileName">
                这里是文件名
            </div>
            <div class="form-group">
                <label class="sr-only"></label>
                <input type="button" id="fileBtn" class="form-control btn btn-block btn-info" value="点击选择Xls文件">
            </div>

            <div class="form-group" style="margin-top: 80px">
                <label class="sr-only"></label>
                <button type="submit" id="submit" class="btn btn-block btn-success">导入员工</button>
            </div>

        </form>
    </div>

</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/vendor/jquery/jquery.js" ></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/layer/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/regist.js"></script>
<script>
    $(document).ready(function () {
        var index = parent.layer.getFrameIndex(window.name); //获取当前窗体索引
        $('#submit').on('click', function(){
            parent.layer.close(index); //执行关闭
        });


        $("#fileBtn").click(function () {
            $("#file").click();
        })

        $("#file").change(function (e) {
            var files = e.currentTarget.files;
            $("#fileName").text(files[0].name);
        })

    })



</script>
</body>
</html>
