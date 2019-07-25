<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: jason
  Date: 2019/7/18
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>IWorkCLoud</title>
    <link href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/iworkcloud.css" rel="stylesheet">
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <a class="navbar-brand" href="#">IWorkCloud</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="首页">
                <a class="nav-link" href="${pageContext.request.contextPath}/page/index">
                    <i class="fa fa-fw fa-dashboard"></i>
                    <span class="nav-link-text">首页</span>
                </a>
            </li>

            <c:if test="${sessionScope.department eq 'Finance' || sessionScope.department eq 'boss'}">
                <li class="nav-item" data-toggle="tooltip" data-placement="right" title="财务">
                    <a class="nav-link" href="${pageContext.request.contextPath}/page/bill">
                        <i class="fa fa-fw fa-area-chart"></i>
                        <span class="nav-link-text">财务</span>
                    </a>
                </li>
            </c:if>

            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="日程">
                <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseSchedule" data-parent="#exampleAccordion">
                    <i class="fa fa-fw fa-calendar"></i>
                    <span class="nav-link-text">日程</span>
                </a>
                <ul class="sidenav-second-level collapse" id="collapseSchedule">
                    <li>
                        <a href="${pageContext.request.contextPath}/page/schedule">日程&请假</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/page/note">记事本</a>
                    </li>
                </ul>
            </li>
            <c:if test="${sessionScope.department eq 'Manager' || sessionScope.department eq 'boss'}">
                <li class="nav-item" data-toggle="tooltip" data-placement="right" title="考勤">
                    <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseComponents" data-parent="#exampleAccordion">
                        <i class="fa fa-fw fa-male"></i>
                        <span class="nav-link-text">考勤</span>
                    </a>
                    <ul class="sidenav-second-level collapse" id="collapseComponents">
                        <li>
                            <a href="${pageContext.request.contextPath}/page/attendance">考勤统计</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/page/excellentStaff">请假批示&优秀员工</a>
                        </li>
                    </ul>
                </li>
            </c:if>

            <c:if test="${sessionScope.department eq 'Manager' || sessionScope.department eq 'boss'}">
                <li class="nav-item" data-toggle="tooltip" data-placement="right" title="活动">
                    <a class="nav-link" href="${pageContext.request.contextPath}/page/activities">
                        <i class="fa fa-fw fa-child"></i>
                        <span class="nav-link-text">活动</span>
                    </a>
                </li>
            </c:if>



            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="项目">
                <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseProjects" data-parent="#exampleAccordion">
                    <i class="fa fa-fw fa-wrench"></i>
                    <span class="nav-link-text">项目</span>
                </a>
                <ul class="sidenav-second-level collapse" id="collapseProjects">
                    <li>
                        <a href="${pageContext.request.contextPath}/page/projects">项目</a>
                    </li>
                    <c:if test="${sessionScope.department eq 'projectManager' || sessionScope.department eq 'boss'}">
                        <li>
                            <a href="${pageContext.request.contextPath}/page/projectsManage">项目管理</a>
                        </li>
                    </c:if>
                </ul>
            </li>
            <c:if test="${sessionScope.department eq 'Personel' || sessionScope.department eq 'boss'}">
                <li class="nav-item" data-toggle="tooltip" data-placement="right" title="部门管理">
                    <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseMulti" data-parent="#exampleAccordion">
                        <i class="fa fa-fw fa-sitemap"></i>
                        <span class="nav-link-text">部门管理</span>
                    </a>
                    <ul class="sidenav-second-level collapse" id="collapseMulti">
                        <li>
                            <a href="${pageContext.request.contextPath}/page/staffManage">人员变动</a>
                        </li>
                    </ul>
                </li>
            </c:if>

        </ul>

        <ul class="navbar-nav sidenav-toggler">
            <li class="nav-item">
                <a class="nav-link text-center" id="sidenavToggler">
                    <i class="fa fa-fw fa-angle-left"></i>
                </a>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item dropdown">
                <div class="dropdown-menu dropdown-menu-right bg-dark" aria-labelledby="alertsDropdown">
                    <h6 class="dropdown-header">用户:</h6>
                    <div class="dropdown-divider"></div>
                    <div class="dropdown-item" onclick="modifyPassword()">
                        <small style="color: #868e96;">修改密码</small>
                    </div>
                    <div class="dropdown-divider"></div>
                    <div class="dropdown-item" id="logOut">
                        <small style="color: #868e96;">登出</small>
                    </div>
                </div>
                <div class="nav-link dropdown-toggle mr-lg-2" id="alertsDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fa fa-fw fa-user"></i>
                    <span class="d-lg-none">用户</span>
                </div>
            </li>
        </ul>
    </div>
</nav>
<div class="content-wrapper">
    <div class="container-fluid">
        <!-- Breadcrumbs-->
        <ol class="breadcrumb">
            <li class="breadcrumb-item">
                <a href="index.html">Dashboard</a>
            </li>
            <li class="breadcrumb-item active">优秀员工展示及出差状况</li>
        </ol>
        <div class="row">
            <div class="col-xl-6 col-sm-6 mb-3">
                <div class="card text-white bg-primary o-hidden h-100">
                    <div class="card-body">
                        <div class="card-body-icon">
                            <i class="fa fa-fw fa-hand-paper-o"></i>
                        </div>
                        <a class="mr-5" href="#">评选</a>
                    </div>
                    <a class="card-footer text-white clearfix small z-1" href="#">
                        <span class="float-left">评选优秀员工</span>
                        <span class="float-right">
                <i class="fa fa-angle-right"></i>
              </span>
                    </a>
                </div>
            </div>
            <div class="col-xl-6 col-sm-6 mb-3">
                <div class="card text-white bg-warning o-hidden h-100">
                    <div class="card-body">
                        <div class="card-body-icon">
                            <i class="fa fa-fw fa-list"></i>
                        </div>
                        <div class="mr-5"></div>
                    </div>
                    <a class="card-footer text-white clearfix small z-1" href="${pageContext.request.contextPath}/page/iframe/outInfo">
                        <span class="float-left">新增出差计划</span>
                        <span class="float-right">
                <i class="fa fa-angle-right"></i>
              </span>
                    </a>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <div class="card">
                    <div class="card-header">请假批示名单</div>
                    <div class="card-body">
                        <table class="table table-bordered table-hover" id="dataTable">
                    <thead>
                    <tr>
                        <th>工号</th>
                        <th>开始日期</th>
                        <th>结束日期</th>
                        <th>理由</th>
                        <th>是否批准</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="holiday" items="${holidayList}">
                    <tr>
                        <td>${holiday.staff}</td>
                        <td>${holiday.timeStart}</td>
                        <td>${holiday.timeEnd}</td>
                        <td>${holiday.reason}</td>
                        <td>
                            <div class="row">
                                <div class="col-12 m-auto">
                                    <a class="btn btn-success col-5" href="${pageContext.request.contextPath}/page/ratifyHoliday?holidayId=${holiday.id}">允许</a>
                                    <a class="btn btn-danger col-5" href="${pageContext.request.contextPath}/page/refuseHoliday?holidayId=${holiday.id}">拒绝</a>
                                </div>
                            </div>
                        </td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
                    </div>
                    <div class="card-footer"></div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <div class="card">
                    <div class="card-header">最近一周出差计划</div>
                    <div class="card-body">
                        <table class="table table-bordered table-hover" id="outTable">
                            <thead>
                            <tr>
                                <th>工号</th>
                                <th>开始日期</th>
                                <th>结束日期</th>
                                <th>删除</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="out" items="${outList}">
                                <tr>
                                    <td>${out.staff}</td>
                                    <td>${out.dateStart}</td>
                                    <td>${out.dateEnd}</td>
                                    <td>
                                        <div class="row">
                                            <a class="btn btn-danger col-8 m-auto" href="${pageContext.request.contextPath}/page/deleteOut?id=${out.id}">删除</a>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer"></div>
                </div>
            </div>
        </div>

    </div>
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    <footer class="sticky-footer">
        <div class="container">
            <div class="text-center">
                <small>Copyright © Nanchang University </small>
            </div>
        </div>
    </footer>
    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fa fa-angle-up"></i>
    </a>

    <!-- Bootstrap core JavaScript-->
    <script src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="${pageContext.request.contextPath}/vendor/jquery-easing/jquery.easing.min.js"></script>
    <script src="${pageContext.request.contextPath}/layer/layer.js"></script>
    <!-- Page level plugin JavaScript-->
    <script src="${pageContext.request.contextPath}/vendor/chart.js/Chart.min.js"></script>
    <script src="${pageContext.request.contextPath}/vendor/datatables/jquery.dataTables.js"></script>
    <script src="${pageContext.request.contextPath}/vendor/datatables/dataTables.bootstrap4.js"></script>
    <!-- Custom scripts for all pages-->
    <script src="${pageContext.request.contextPath}/js/sb-admin.min.js"></script>
    <!-- Custom scripts for this page-->
    <script src="${pageContext.request.contextPath}/js/sb-admin-datatables.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/sb-admin-charts.js"></script>

    <script>
        $(document).ready(function(){
            $("#logOut").click(function(){
                layer.confirm('确定注销登陆？', {
                    btn: ['确定','取消'] //按钮
                }, function(){
                    layer.msg("已注销");
                    setTimeout(function (){$(location).attr('href', '${pageContext.request.contextPath}/page/invalidateSession')},2000);
                }, function(){
                    layer.msg("取消",{icon:2})
                });
            })

        })
        function modifyPassword() {
            layer.open({
                type: 2,title: '修改密码',area: ['500px','420px'],scrollbar: false,offset: 'auto',
                content: '${pageContext.request.contextPath}/page/iframe/modifyPassword',
            })
        }
    </script>
</div>
</body>


</html>

