<%-- 
    Document   : ThongTinCaNhan
    Created on : Sep 9, 2017, 3:52:48 PM
    Author     : sonnguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../head.jsp" %>
    </head>
    <body>
        <%@include file="/sinhvien/svheader.jsp" %>
        <section id="page-breadcrumb">
            <div class="vertical-center sun">
                <div class="container">
                    <div class="row">
                        <div class="action">
                            <div class="col-sm-12">
                                <h1 class="title">THÔNG TIN CÁ NHÂN</h1>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section id="blog" class="">
            <div class="container">
                <div class="row">
                    <div class="col-md-9 col-sm-7">
                        <div class="row">
                            <div class="col-md-12 col-sm-12">
                                <div class="single-blog two-column">
                                    <div class="post-content overflow">
                                        <div class="row">
                                            <div class="col-md-4">
                                                <div class="post-thumb">
                                                    <a href="blogdetails.html"><img style="height: 100%; width: 100%" src="asset/images/blog/7.jpg" class="img-responsive" alt=""></a>
                                                    <div class="btn">
                                                        <a href="capnhatthongtin.jsp" class="btn btn-common uppercase">Cập nhật ?</a>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-8">
                                                <div class="project-name overflow">
                                                    <h5 class="bold"><strong>HỌ TÊN: NGUYỄN CÔNG SƠN</strong> </h5>
                                                    <h5 class="bold"><strong>NGÀY SINH: 22/02/1995</strong> </h5>
                                                    <h5 class="bold"><strong>LỚP: INPG12</strong></h5>
                                                    <h5 class="bold"><strong>KHOA/VIỆN: ĐÀO TẠO QUỐC TẾ</strong></h5>
                                                    <h5 class="bold"><strong>EMAIL: SON.NGUYENCONG.HUST@GMAIL.COM</strong></h5>
                                                    <h5 class="bold"><strong>ĐIỆN THOẠI: 0898595657</strong></h5>
                                                    <h5 class="bold"><strong>ĐỊA CHỈ: BÁCH KHOA HÀ NỘI</strong> </h5>
                                                </div>
                                                <div class="project-info overflow">
                                                    <h5><strong>KINH NGHIÊM/ PROJECT</strong></h5>
                                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed tempus nibh sed elimttis adipiscing. Fusce in hendrerit purus. Suspendisse potenti. Proin quis eros odio, dapibus dictum mauris. Donec nisi libero, adipiscing id pretium eget, consectetur sit amet leo. Nam at eros quis mi egestas fringilla non nec purus.</p>
                                                    <ul class="elements">
                                                        <li><i class="fa fa-angle-right"></i> Lorem ipsum dolor sit amet, consectetur adipiscing elit.</li>
                                                        <li><i class="fa fa-angle-right"></i> Donec tincidunt felis quis ipsum porttitor, non rutrum lorem rhoncus.</li>
                                                        <li><i class="fa fa-angle-right"></i> Nam in quam consectetur nulla placerat dapibus ut ut nunc.</li>
                                                    </ul>
                                                </div>
                                                <div class="skills overflow">
                                                    <h5><strong>CÁC KỸ NĂNG:</strong> </h3>
                                                        <ul class="nav navbar-nav navbar-default">
                                                            <li><a href="#"><i class="fa fa-check-square"></i>Design</a></li>
                                                            <li><a href="#"><i class="fa fa-check-square"></i>HTML/CSS</a></li>
                                                            <li><a href="#"><i class="fa fa-check-square"></i>Javascript</a></li>
                                                            <li><a href="#"><i class="fa fa-check-square"></i>Backend</a></li>
                                                        </ul>
                                                </div>
                                                <div class="client overflow">
                                                    <h5><strong>DỰ ĐINH TƯƠNG LAI:</strong> </h5>
                                                    <ul class="nav navbar-nav navbar-default">
                                                        <li><a href="#"><i class="fa fa-bolt"></i></a></li>
                                                    </ul>
                                                </div>

                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                    <%@include file="../RightSidebar.jsp" %>
                </div>
            </div>
        </section>
        <!--/#blog-->
        <%@include file="../footer.jsp" %>
        <%@include file="../js.jsp" %>
    </body>
</html>
