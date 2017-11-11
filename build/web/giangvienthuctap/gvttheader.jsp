<%-- 
    Document   : gvttheard
    Created on : Nov 11, 2017, 12:52:29 PM
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
                    <li class="dropdown"><a>Sinh viên<i class="fa fa-angle-down"></i></a>
                        <ul role="menu" class="sub-menu">
                            <li><a href="./giangvienthuctap/sinhvien.jsp">Danh sách sinh viên</a></li>
                            <li><a href="./giangvienthuctap/detaisinhvien.jsp">Duyệt đề tài sinh viên</a></li>
                            <li><a href="./giangvienthuctap/quanlyfile.jsp">Quản lý file</a></li>
                        </ul>
                    </li>                    
                    <li class="dropdown"><a>Thực tập<i class="fa fa-angle-down"></i></a>
                        <ul role="menu" class="sub-menu">
                            <li><a href="./giangvienthuctap/danhsachcongty.jsp">Danh sách công ty</a></li>
                            <li><a href="./giangvienthuctap/duyetdetaicongty.jsp">Duyệt đề tài công ty</a></li>
                            <li><a href="./giangvienthuctap/lichtrinh.jsp">Lịch trình</a></li>
                            <li><a href="./giangvienthuctap/email.jsp">Email</a></li>
                        </ul>
                    </li>
                    <!--                    <li><a href="./sinhvien/lichtrinh.jsp">Lịch trình</a></li>                  -->
                    <s:iterator value="%{#session.lstGiangVienThucTap}">
                        <li class="dropdown"><a><img style="height: 20px; width: 20px" src="<s:property value="avatar"/>"/><i class="fa fa-angle-down"></i></a>
                            <ul role="menu" class="sub-menu">
                                <li><a><s:property value="hoTen"/></a></li>
                                <li><a href="./giangvienthuctap/thongtincanhan.jsp">Thông tin cá nhân</a></li>
                                <script type="text/javascript">
                                    window.onload = function () {Clear();
                                    }
                                    function Clear() {
                                        var Backlen = history.length;
                                        if (Backlen > 0)
                                            history.go(-Backlen);
                                    }
                                </script>
                                <li><a href="giangVienThucTapLogout" onclick="Clear">Đăng xuất</a></li>
                            </ul>
                        </li> 
                    </s:iterator>
                                       
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
