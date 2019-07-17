<%--
  Created by IntelliJ IDEA.
  User: jason
  Date: 2019/7/16
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link type="text/css" rel="styleSheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
    <title>绑定</title>
</head>
<body>
    <div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <form action="bindStaff" method="post">
                <div class="form-group">
                    <div class="input-group">
                        <input type="text" class="form-control input-lg" placeholder="请输入工号" name="StaffID"/>
                        <span class="input-group-btn">
                            <button type="submit" class="btn btn-default btn-lg">绑定</button>
                        </span>
                    </div>
                </div>
            </form>
        </div>
    </div>
    </div>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>

</body>
</html>
