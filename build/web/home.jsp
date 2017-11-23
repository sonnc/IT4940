<%-- 
    Document   : home
    Created on : Sep 9, 2017, 12:02:16 PM
    Author     : sonnguyen
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>

<html>
    <head>
        <%@include file="../head.jsp" %>
    </head>
    <%    if (session.getAttribute("SQLHome") == null) {
    %>
    <s:action name="actionHome" executeResult="true"/>
    <%
        }
    %>
    <%
        if (session.getAttribute("SQLHome") != null) {
            session.removeAttribute("SQLHome");
    %>
    <body>
        <%            if (session.getAttribute("role").equals("0")) {
        %>
        <%@include file="./sinhvien/svheader.jsp" %>
        <%
        } else if (session.getAttribute("role").equals("1")) {
        %>
        <%@include file="./giangvienthuctap/gvttheader.jsp" %>
        <%
        } else if (session.getAttribute("role").equals("2")) {
        %>
        <%@include file="./giangvienhuongdan/gvhdheader.jsp" %>
        <%
        } else if (session.getAttribute("role").equals("3")) {
        %>
        <%@include file="./congty/ctheader.jsp" %>
        <%
        } 
        %>

        <section id="home-slider">
            <div class="container">
                <div id="myCarousel" class="carousel slide" data-ride="carousel">
                    <!-- Indicators -->
                    <ol class="carousel-indicators">
                        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                        <li data-target="#myCarousel" data-slide-to="1"></li>
                        <li data-target="#myCarousel" data-slide-to="2"></li>
                    </ol>

                    <!-- Wrapper for slides -->
                    <div class="carousel-inner">
                        <div class="item active">
                            <div class="row">
                                <div class="main-slider">
                                    <div class="slide-text">
                                        <h1>Đại học Bách Khoa Hà Nội</h1>
                                        <p>Được thành lập năm 1956, là trường đào tạo hàng đầu về công nghệ thông tin, các sản phẩm đột phá</p>
                                        <a href="login.jsp" class="btn btn-common">Xem thêm</a>
                                    </div>
                                    <img src="asset/images/home/slider/hill.png" class="slider-hill" alt="slider image">
                                    <img src="asset/images/home/slider/house.png" class="slider-house" alt="slider image">
                                    <img src="asset/images/home/slider/sun.png" class="slider-sun" alt="slider image">
                                    <img src="asset/images/home/slider/birds1.png" class="slider-birds1" alt="slider image">
                                    <img src="asset/images/home/slider/birds2.png" class="slider-birds2" alt="slider image">
                                </div>
                            </div>
                        </div>

                        <div class="item">
                            <div class="row">
                                <div class="main-slider">
                                    <div class="slide-text">
                                        <h1>Đại học Bách Khoa Hà Nội</h1>
                                        <p>Được thành lập năm 1956, là trường đào tạo hàng đầu về công nghệ thông tin, các sản phẩm đột phá</p>
                                        <a href="login.jsp" class="btn btn-common">XEM THÊM</a>
                                    </div>
                                    <img src="asset/images/bk2017.jpg" class="slider-hill" alt="slider image">
                                </div>
                            </div>
                        </div>

                        <div class="item">
                            <div class="row">
                                <div class="main-slider">
                                    <div class="slide-text">
                                        <h1>Đại học Bách Khoa Hà Nội</h1>
                                        <p>Được thành lập năm 1956, là trường đào tạo hàng đầu về công nghệ thông tin, các sản phẩm đột phá</p>
                                        <a href="login.jsp" class="btn btn-common">XEM THÊM</a>
                                    </div>
                                    <img src="asset/images/bk2017.jpg" class="slider-hill" alt="slider image">
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Left and right controls -->
                    <a class="left" href="#myCarousel" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="right " href="#myCarousel" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>    

            </div>
            <div class="preloader"><i class="fa fa-sun-o fa-spin"></i></div>
        </section>
        <!--/#home-slider-->






        <section id="blog" class="padding-top">
            <div class="container">
                <div class="row">
                    <div class="col-md-9 col-sm-7">
                        <div class="row">
                            <style>
                                #moTa {
                                    line-height: 1.3em;
                                    color: #3b5998!important;
                                    margin: 0 0 5px;
                                    -webkit-line-clamp: 5;
                                    -webkit-box-orient: vertical;
                                    overflow: hidden;
                                    text-overflow: ellipsis;
                                    display: -webkit-box;
                                    max-height: 125px;
                                }
                            </style>
                            <s:iterator value="lstThongBao">
                                <div class="col-md-12 col-sm-12">
                                    <div class="single-blog two-column">
                                        <div class="post-content overflow">
                                            <h2 class="post-title bold"><a href="#"><s:property value="tieuDe"/></a></h2>
                                            <div class="row">
                                                <div class="col-md-4">
                                                    <div class="post-thumb">
                                                        <a href="#"><img style="height: 100%; width: 100%" src="asset/images/bk2017.jpg" class="img-responsive" alt=""></a>
                                                        <div class="post-overlay">
                                                            <span class="uppercase"><a style="margin-left: 8px;font-weight: 700;font-size: 20px;line-height: 30px; position: absolute;op: 50px;" href="#"><s:property value="thoiGian"/></a></span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-8">
                                                    <h3 class="post-author"><a href="#"><s:property value="nguoiDang"/></a></h3>
                                                    <p id="moTa"><s:property value="noiDung"/></p>
                                                    <a href="#" class="read-more">View More</a>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </s:iterator>
                        </div>
                        <!--                        <div class="blog-pagination">
                                                    <ul class="pagination">
                                                        <li><a href="#">left</a></li>
                                                        <li><a href="#">1</a></li>
                                                        <li><a href="#">2</a></li>
                                                        <li class="active"><a href="#">3</a></li>
                                                        <li><a href="#">4</a></li>
                                                        <li><a href="#">5</a></li>
                                                        <li><a href="#">6</a></li>
                                                        <li><a href="#">7</a></li>
                                                        <li><a href="#">8</a></li>
                                                        <li><a href="#">9</a></li>
                                                        <li><a href="#">right</a></li>
                                                    </ul>
                                                </div>-->
                    </div>
                    <%@include file="RightSidebar.jsp" %>

                </div>
            </div>
        </section>
        <!--/#blog-->
        <%@include file="footer.jsp" %>
        <%@include file="js.jsp" %>
    </body>
    <%
        }
    %>
</html>
