<%-- 
    Document   : header
    Created on : Sep 9, 2017, 11:57:35 AM
    Author     : sonnguyen
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<header id="header">      
    <div class="container">
        <div class="row">
            <div class="col-sm-12 overflow">
                <div class="social-icons pull-right">
                    <ul class="nav nav-pills">
                        <li><a href=""><i class="fa fa-facebook"></i></a></li>
                        <li><a href=""><i class="fa fa-twitter"></i></a></li>
                        <li><a href=""><i class="fa fa-google-plus"></i></a></li>
                        <li><a href=""><i class="fa fa-dribbble"></i></a></li>
                        <li><a href=""><i class="fa fa-linkedin"></i></a></li>
                    </ul>
                </div> 
            </div>
        </div>
    </div>
    <div class="navbar navbar-inverse" role="banner">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>

                <a class="navbar-brand" href="home.jsp">
                    <div class="row">
                        <div class="col-md-12 col-lg-12 col-xs-12">
                            <img class="col-md-12 col-lg-12 col-xs-12" src="asset/images/logo.png" alt="logo" style="height: 60px">
                        </div>
                    </div>
                </a>

            </div>
           
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li class="active"><a href="home.jsp">Trang chủ</a></li>
                    <li class="dropdown"><a href="#">Sinh viên<i class="fa fa-angle-down"></i></a>
                        <ul role="menu" class="sub-menu">
                            <li><a href="service.html">Báo cáo</a></li>
                            <li><a href="service.html">Gửi mail</a></li>
                        </ul>
                    </li>                    
                    <li class="dropdown"><a href="blog.html">Thực tập <i class="fa fa-angle-down"></i></a>
                        <ul role="menu" class="sub-menu">
                            <li><a href="blog.html">Công ty</a></li>
                            <li><a href="blogtwo.html">Đề tài</a></li>
                            <li><a href="blogone.html">Điểm thi</a></li>
                        </ul>
                    </li>
                    <li><a href="home.jsp">Lịch trình</a></li>                  
                    <li class="dropdown"><a><img style="height: 20px; width: 20px" src="asset/images/ico/apple-touch-icon-114-precomposed.png"/></a>
                        <ul role="menu" class="sub-menu">
                            <li><a href="aboutus.html">Thông tin cá nhân</a></li>
                            <li><a href="aboutus.html">Đăng xuất</a></li>
                        </ul>
                    </li>                    
                </ul>
            </div>
            <div class="search">
                <form role="form">
                    <i class="fa fa-search"></i>
                    <div class="field-toggle">
                        <input type="text" class="search-form" autocomplete="off" placeholder="Search">
                    </div>
                </form>
            </div>
        </div>
    </div>
</header>
<!--/#header-->
