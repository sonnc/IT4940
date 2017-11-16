<%-- 
    Document   : chitietdetai
    Created on : Oct 20, 2017, 10:33:32 AM
    Author     : sonnguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../head.jsp" %>
    </head>
    <%
        if (session.getAttribute("ChiTietDeTai") != null) {
            session.removeAttribute("ChiTietDeTai");
    %>
    <body>
        <%@include file="../giangvienthuctap/gvttheader.jsp" %>
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
                                            <s:iterator value="lstCTDT">
                                                <div class="col-md-4">
                                                    <div class="post-thumb">
                                                        <a href="chiTietCongTy?maCongTy=<s:property value="msct"/>"><img style="height: 100%; width: 100%" src="<s:property value="avatar"/>" class="img-responsive" alt=""></a>
                                                        <div class="btn">
                                                            <div class="col-md-12">
                                                                <div class="row">
                                                                    <div class="col-lg-12"><a href="dongYDeTai?maDeTai=<s:property value="id"/>"><input class="btn btn-success" style="margin: 10px; width: 200px;height: 50px;" type="button" value="Đồng ý"/></a></div>
                                                                    <div class="col-lg-12"><a href="tuChoiDeTai?maDeTai=<s:property value="id"/>"><input class="btn btn-danger" style="margin: 10px; width: 200px;height: 50px;" type="button" value="Từ chối"/></a></div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-8">
                                                    <div class="project-name overflow">
                                                        <h5 class="bold"><strong>TÊN CÔNG TY: <s:property value="tenCongTy"/></strong> </h5>
                                                        <h5 class="bold"><strong>ĐỊA CHỈ: <s:property value="diaChi"/></strong> </h5>
                                                        <h5 class="bold"><strong>EMAIL: <s:property value="email"/></strong></h5>
                                                        <h5 class="bold"><strong>ĐIỆN THOẠI: <s:property value="dienThoai"/></strong></h5>
                                                        <h5 class="bold"><strong>WEBSITE: <s:property value="website"/></strong></h5>   
                                                    </div>

                                                    <div class="skills overflow">
                                                        <h5><strong>CHI TIẾT ĐỀ TÀI</strong> </h5>
                                                        <ul class="elements">
                                                            <li><i class="fa fa-angle-right"></i><strong>Mã đề tài</strong> <s:property value="id"/></li>
                                                            <li><i class="fa fa-angle-right"></i><strong>Tên đề tài</strong> <s:property value="tenDeTai"/></li>
                                                            <li><i class="fa fa-angle-right"></i><strong>Nội dung</strong> <s:property value="noiDung"/></li>
                                                            <li><i class="fa fa-angle-right"></i><strong>Yêu cầu</strong> <s:property value="yeuCau"/></li>
                                                            <li><i class="fa fa-angle-right"></i><strong>Số lượng</strong> <s:property value="soLuong"/></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </s:iterator>
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
