<%--
  Created by IntelliJ IDEA.
  User: jason
  Date: 2019/7/16
  Time: 10:12
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
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <a class="navbar-brand" href="#">IWorkCloud</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Dashboard">
                <a class="nav-link" href="index.html">
                    <i class="fa fa-fw fa-dashboard"></i>
                    <span class="nav-link-text">Dashboard</span>
                </a>
            </li>
            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Charts">
                <a class="nav-link" href="charts.html">
                    <i class="fa fa-fw fa-area-chart"></i>
                    <span class="nav-link-text">Charts</span>
                </a>
            </li>
            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
                <a class="nav-link" href="tables.html">
                    <i class="fa fa-fw fa-table"></i>
                    <span class="nav-link-text">Tables</span>
                </a>
            </li>

            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Components">
                <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseComponents" data-parent="#exampleAccordion">
                    <i class="fa fa-fw fa-wrench"></i>
                    <span class="nav-link-text">Components</span>
                </a>
                <ul class="sidenav-second-level collapse" id="collapseComponents">
                    <li>
                        <a href="navbar.html">Navbar</a>
                    </li>
                </ul>
            </li>

            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Menu Levels">
                <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseMulti" data-parent="#exampleAccordion">
                    <i class="fa fa-fw fa-sitemap"></i>
                    <span class="nav-link-text">Menu Levels</span>
                </a>
                <ul class="sidenav-second-level collapse" id="collapseMulti">
                    <li>
                        <a href="#">Second Level Item</a>
                    </li>
                </ul>

            </li>

            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Link">
                <a class="nav-link" href="#">
                    <i class="fa fa-fw fa-link"></i>
                    <span class="nav-link-text">Link</span>
                </a>
            </li>
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
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="alertsDropdown">
                    <h6 class="dropdown-header">用户:</h6>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">
                        修改资料
                    </a>
                </div>
                <a class="nav-link dropdown-toggle mr-lg-2" id="alertsDropdown" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fa fa-fw fa-user"></i>
                    <span class="d-lg-none">Alerts
              <span class="badge badge-pill badge-warning">6 New</span>
            </span>
                </a>
            </li>
        </ul>
    </div>
</nav>
<div class="content-wrapper">
    <div class="container-fluid">
        <ol class="breadcrumb">
            <li class="breadcrumb-item">
                <a href="#">Dashboard</a>
            </li>
            <li class="breadcrumb-item active">My Dashboard</li>
        </ol>
        <div class="row">
            <div class="col-xl-3 col-sm-6 mb-3">
                <div class="card text-white bg-primary o-hidden h-100">
                    <div class="card-body">
                        <div class="card-body-icon">
                            <i class="fa fa-fw fa-comments"></i>
                        </div>
                        <div class="mr-5">26 New Messages!</div>
                    </div>
                    <a class="card-footer text-white clearfix small z-1" href="#">
                        <span class="float-left">View Details</span>
                        <span class="float-right">
                <i class="fa fa-angle-right"></i>
              </span>
                    </a>
                </div>
            </div>
            <div class="col-xl-3 col-sm-6 mb-3">
                <div class="card text-white bg-warning o-hidden h-100">
                    <div class="card-body">
                        <div class="card-body-icon">
                            <i class="fa fa-fw fa-list"></i>
                        </div>
                        <div class="mr-5">11 New Tasks!</div>
                    </div>
                    <a class="card-footer text-white clearfix small z-1" href="#">
                        <span class="float-left">View Details</span>
                        <span class="float-right">
                <i class="fa fa-angle-right"></i>
              </span>
                    </a>
                </div>
            </div>
            <div class="col-xl-3 col-sm-6 mb-3">
                <div class="card text-white bg-success o-hidden h-100">
                    <div class="card-body">
                        <div class="card-body-icon">
                            <i class="fa fa-fw fa-shopping-cart"></i>
                        </div>
                        <div class="mr-5">123 New Orders!</div>
                    </div>
                    <a class="card-footer text-white clearfix small z-1" href="#">
                        <span class="float-left">View Details</span>
                        <span class="float-right">
                <i class="fa fa-angle-right"></i>
              </span>
                    </a>
                </div>
            </div>
            <div class="col-xl-3 col-sm-6 mb-3">
                <div class="card text-white bg-danger o-hidden h-100">
                    <div class="card-body">
                        <div class="card-body-icon">
                            <i class="fa fa-fw fa-support"></i>
                        </div>
                        <div class="mr-5">13 New Tickets!</div>
                    </div>
                    <a class="card-footer text-white clearfix small z-1" href="#">
                        <span class="float-left">View Details</span>
                        <span class="float-right">
                <i class="fa fa-angle-right"></i>
              </span>
                    </a>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <!-- Example Notifications Card-->
                <div class="card mb-3">
                    <div class="card-header">
                        <i class="fa fa-bell-o"></i> Feed Example</div>
                    <div class="list-group list-group-flush small">
                        <a class="list-group-item list-group-item-action" href="#">
                            <div class="media">
                                <img class="d-flex mr-3 rounded-circle" src="http://placehold.it/45x45" alt="">
                                <div class="media-body">
                                    <strong>David Miller</strong>posted a new article to
                                    <strong>David Miller Website</strong>.
                                    <div class="text-muted smaller">Today at 5:43 PM - 5m ago</div>
                                </div>
                            </div>
                        </a>
                        <a class="list-group-item list-group-item-action" href="#">
                            <div class="media">
                                <img class="d-flex mr-3 rounded-circle" src="http://placehold.it/45x45" alt="">
                                <div class="media-body">
                                    <strong>Samantha King</strong>sent you a new message!
                                    <div class="text-muted smaller">Today at 4:37 PM - 1hr ago</div>
                                </div>
                            </div>
                        </a>
                        <a class="list-group-item list-group-item-action" href="#">
                            <div class="media">
                                <img class="d-flex mr-3 rounded-circle" src="http://placehold.it/45x45" alt="">
                                <div class="media-body">
                                    <strong>Jeffery Wellings</strong>added a new photo to the album
                                    <strong>Beach</strong>.
                                    <div class="text-muted smaller">Today at 4:31 PM - 1hr ago</div>
                                </div>
                            </div>
                        </a>
                        <a class="list-group-item list-group-item-action" href="#">
                            <div class="media">
                                <img class="d-flex mr-3 rounded-circle" src="http://placehold.it/45x45" alt="">
                                <div class="media-body">
                                    <i class="fa fa-code-fork"></i>
                                    <strong>Monica Dennis</strong>forked the
                                    <strong>startbootstrap-sb-admin</strong>repository on
                                    <strong>GitHub</strong>.
                                    <div class="text-muted smaller">Today at 3:54 PM - 2hrs ago</div>
                                </div>
                            </div>
                        </a>
                        <a class="list-group-item list-group-item-action" href="#">View all activity...</a>
                    </div>
                    <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                </div>
            </div>
        </div>
        <!-- Example DataTables Card-->
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
    <!-- Page level plugin JavaScript-->
    <script src="${pageContext.request.contextPath}/vendor/chart.js/Chart.min.js"></script>
    <script src="${pageContext.request.contextPath}/vendor/datatables/jquery.dataTables.js"></script>
    <script src="${pageContext.request.contextPath}/vendor/datatables/dataTables.bootstrap4.js"></script>
    <!-- Custom scripts for all pages-->
    <script src="${pageContext.request.contextPath}/js/sb-admin.min.js"></script>
    <!-- Custom scripts for this page-->
    <script src="${pageContext.request.contextPath}/js/sb-admin-datatables.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/sb-admin-charts.min.js"></script>
</div>
</body>

</html>

