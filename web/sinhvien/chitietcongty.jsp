<%-- 
    Document   : chitietcongty
    Created on : Sep 10, 2017, 12:17:21 AM
    Author     : sonnguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../head.jsp" %>
    </head>
    <%    if (session.getAttribute("CTCongTy") == null) {
    %>
    <s:action name="getCongTy" executeResult="true"/>
    <%
        }
    %>
    <%
        if (session.getAttribute("CTCongTy") != null) {
            session.removeAttribute("CTCongTy");
    %>
    <body>
        <%@include file="../sinhvien/svheader.jsp" %>
        <section id="page-breadcrumb">
            <div class="vertical-center sun">
                <div class="container">
                    <div class="row">
                        <div class="action">
                            <div class="col-sm-12">
                                <h1 class="title">THÔNG TIN CHI TIẾT</h1>
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
                                                    <s:iterator value="lstCongTy">
                                                        <a href="#"><img style="height: 100%; width: 100%" src="<s:property value="avatar"/>" class="img-responsive" alt="<s:property value="avatar"/>"></a>
                                                     
                                                    </div>
                                                </div>
                                                <div class="col-md-8">
                                                    <div class="project-name overflow">

                                                        <h5 class="bold"><strong>TÊN CÔNG TY: <s:property value="tenCongTy"/></strong> </h5>
                                                        <h5 class="bold"><strong>ĐỊA CHỈ: <s:property value="diaChi"/></strong> </h5>
                                                        <h5 class="bold"><strong>EMAIL: <s:property value="email"/></strong></h5>
                                                        <h5 class="bold"><strong>ĐIỆN THOẠI: <s:property value="dienThoai"/></strong></h5>
                                                        <h5 class="bold"><strong>WEBSITE: <s:property value="website"/></strong></h5>   
                                                    </s:iterator>
                                                </div>
                                                <div class="project-info overflow">
                                                    <h5><strong>ĐẠI DIỆN CÔNG TY</strong></h5>
                                                    <ul class="elements">
                                                        <s:iterator value="lstDaiDienCongTy">
                                                            <li><i class="fa fa-angle-right"></i>Ông/bà: <a href="#"><s:property value="hoTen"/></a></li>
                                                            <li><i class="fa fa-angle-right"></i>Chức vụ: <s:property value="chucVu"/></li>
                                                            <li><i class="fa fa-angle-right"></i>Điện thoại:<s:property value="dienThoai"/></li>
                                                            <li><i class="fa fa-angle-right"></i>Email:<s:property value="email"/></li>
                                                            </s:iterator>
                                                    </ul>
                                                </div>
                                                <div class="project-info overflow">
                                                    <h5><strong>GIỚI THIỆU CÔNG TY</strong></h5>
                                                    <s:iterator value="lstCongTy">
                                                        <p><s:property value="moTa"/></p>
                                                    </s:iterator>
                                                    <!--                                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed tempus nibh sed elimttis adipiscing. Fusce in hendrerit purus. Suspendisse potenti. Proin quis eros odio, dapibus dictum mauris. Donec nisi libero, adipiscing id pretium eget, consectetur sit amet leo. Nam at eros quis mi egestas fringilla non nec purus.</p>
                                                                                                        <ul class="elements">
                                                                                                            <li><i class="fa fa-angle-right"></i> Lorem ipsum dolor sit amet, consectetur adipiscing elit.</li>
                                                                                                            <li><i class="fa fa-angle-right"></i> Donec tincidunt felis quis ipsum porttitor, non rutrum lorem rhoncus.</li>
                                                                                                            <li><i class="fa fa-angle-right"></i> Nam in quam consectetur nulla placerat dapibus ut ut nunc.</li>
                                                                                                        </ul>-->
                                                </div>
                                                <div class="skills overflow">
                                                    <h5><strong>LĨNH VỰC HOẠT ĐỘNG</strong> </h5>
                                                    <s:iterator value="lstCongTy">
                                                        <p><s:property value="linhVucHoatDong"/></p>
                                                    </s:iterator>
                                                    <!--                                                        <ul class="elements">
                                                                                                                <li><i class="fa fa-angle-right"></i> Lorem ipsum dolor sit amet, consectetur adipiscing elit.</li>
                                                                                                                <li><i class="fa fa-angle-right"></i> Donec tincidunt felis quis ipsum porttitor, non rutrum lorem rhoncus.</li>
                                                                                                                <li><i class="fa fa-angle-right"></i> Nam in quam consectetur nulla placerat dapibus ut ut nunc.</li>
                                                                                                                <li><i class="fa fa-angle-right"></i> Lorem ipsum dolor sit amet, consectetur adipiscing elit.</li>
                                                                                                                <li><i class="fa fa-angle-right"></i> Donec tincidunt felis quis ipsum porttitor, non rutrum lorem rhoncus.</li>
                                                                                                                <li><i class="fa fa-angle-right"></i> Nam in quam consectetur nulla placerat dapibus ut ut nunc.</li>
                                                                                                            </ul>-->
                                                </div>
                                                <div class="client overflow">
                                                    <h5><strong>CƠ SỞ VẬT CHẤT</strong> </h5>
                                                    <ul class="nav navbar-nav navbar-default">
                                                        <li><a href="#"><i class="fa fa-bolt"></i>Okler Themes</a></li>
                                                    </ul>
                                                </div>
                                                <div class="client overflow">
                                                    <h5><strong>DANH SÁCH PHỤ TRÁCH HƯỚNG DẪN THỰC TẬP</strong> </h5>
                                                    <div class="sidebar-item categories">
                                                        <ul class="nav navbar-stacked" style="height: 250px; overflow:auto">
                                                            <s:iterator value="lstGiangVienHuongDan">
                                                                <div class="media">
                                                                    <div class="pull-left">
                                                                        <a href="chitietGVHD?id=<s:property value="id"/>"><img src="asset/images/bk2017.jpg" style="height: 70px; width: 70px" alt=""></a>
                                                                    </div>
                                                                    <div class="media-body">
                                                                        <p style="margin: 0px; font-size: 14px">Họ tên: <a href="chitietGVHD?id=<s:property value="id"/>"><s:property value="hoTen"/></a></p>
                                                                        <p style="margin: 0px; font-size: 14px">Email: <s:property value="email"/></p>
                                                                        <p style="margin: 0px; font-size: 14px">Email: <s:property value="chucVu"/></p>
                                                                    </div>
                                                                </div>
                                                            </s:iterator>
                                                        </ul>
                                                    </div>

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
        <!--/#features-->
        <%@include file="../footer.jsp" %>
        <%@include file="../js.jsp" %>
    </body>
    <%
        }
    %>
</html>