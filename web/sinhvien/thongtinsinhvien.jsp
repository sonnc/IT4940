<%-- 
    Document   : ThongTinCaNhan
    Created on : Sep 9, 2017, 3:52:48 PM
    Author     : sonnguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../head.jsp" %>
    </head>
    <body>
        <%            if (session.getAttribute("role").equals("0")) {
        %>
        <%@include file="/sinhvien/svheader.jsp" %>
        <%
        } else if (session.getAttribute("role").equals("1")) {
        %>
        <%@include file="/giangvienthuctap/gvttheader.jsp" %>
        <%
        } else if (session.getAttribute("role").equals("2")) {
        %>
      
        <%
        } else if (session.getAttribute("role").equals("3")) {
        %>
        <%@include file="/congty/ctheader.jsp" %>
        <%
        } else if (session.getAttribute("role").equals("4")) {
        %>
        <%@include file="ddctheader.jsp" %>
        <%
            }
        %>
        <section id="page-breadcrumb">
            <div class="vertical-center sun">
                <div class="container">
                    <div class="row">
                        <div class="action">
                            <div class="col-sm-12">
                                <h1 class="title">THÔNG TIN SINH VIÊN</h1>
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
                                            <s:iterator value="lstSinhVien">
                                                <div class="col-md-4">
                                                    <div class="post-thumb">
                                                        <a><img style="height: 100%; width: 100%" src="<s:property value="avatar"/>" class="img-responsive" alt=""></a>

                                                    </div>
                                                </div>
                                            </s:iterator>

                                            <div class="col-md-8"> 
                                                <s:iterator value="lstSinhVien">
                                                    <div class="project-name overflow">
                                                        <h5 class="bold"><strong>HỌ TÊN: <s:property value="hoTen"/></strong> </h5>
                                                        <h5 class="bold"><strong>NGÀY SINH: <s:property value="ngaySinh"/></strong> </h5>
                                                        <h5 class="bold"><strong>LỚP: <s:property value="lop"/><s:property value="khoa"/></strong></h5>
                                                        <h5 class="bold"><strong>KHOA/VIỆN: <s:property value="vienKhoa"/></strong></h5>
                                                        <h5 class="bold"><strong>EMAIL: <s:property value="email"/></strong></h5>
                                                        <h5 class="bold"><strong>ĐIỆN THOẠI: <s:property value="dienThoai"/></strong></h5>
                                                        <h5 class="bold"><strong>ĐỊA CHỈ: <s:property value="diaChi"/></strong> </h5>
                                                    </div>
                                                </s:iterator>
                                                <!--                                                <div class="project-info overflow">
                                                                                                    <h5><strong>THỰC TẬP</strong></h5>
                                                                                                    <ul class="elements">
                                                                                                        <li><i class="fa fa-angle-right"></i> <a href=""><s:property value="tenCongTy"/></li>
                                                                                                        <li><i class="fa fa-angle-right"></i> <s:property value=""/></li>
                                                                                                        <li><i class="fa fa-angle-right"></i> <s:property value=""/></li>
                                                                                                        <li><i class="fa fa-angle-right"></i> <s:property value=""/></li>
                                                                                                        <li><i class="fa fa-angle-right"></i> <s:property value=""/></li>
                                                                                                        <li><i class="fa fa-angle-right"></i> <s:property value=""/></li>
                                                                                                    </ul>
                                                                                                </div>-->
                                                <s:iterator value="lstKNLT">
                                                    <div class="skills overflow">
                                                        <h5><strong>CÁC KỸ NĂNG/ LẬP TRÌNH</strong> </h5>
                                                            <ul class="elements">
                                                                 <li><a><i class="fa fa-check-square"></i><s:property value="kyNang"/></a></li>
                                                                <li><a><i class="fa fa-check-square"></i><s:property value="lapTrinh"/></a></li>
                                                            </ul>
                                                    </div>
                                                </s:iterator>
                                                <s:iterator value="lstMucTieu">
                                                    <div class="client overflow">
                                                        <h5><strong>DỰ ĐINH TƯƠNG LAI/ MỤC TIÊU:</strong> </h5>
                                                           <ul class="elements"> 
                                                               <li><a><i class="fa fa-check-square"></i><s:property value="viTriMongMuon"/></a></li>
                                                            <li><a><i class="fa fa-check-square"></i><s:property value="loaiCongViec"/></a></li>
                                                            <li><a><i class="fa fa-check-square"></i><s:property value="nganhNgheMongMuon"/></a></li>
                                                            <li><a><i class="fa fa-check-square"></i><s:property value="noiLamViecYeuThich"/></a></li>
                                                            <li><a><i class="fa fa-check-square"></i><s:property value="khac"/></a></li>
                                                            </ul>
                                                    </div>
                                                </s:iterator>
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
</html>
