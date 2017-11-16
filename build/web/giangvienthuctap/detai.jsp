<%-- 
    Document   : detai
    Created on : Nov 11, 2017, 12:53:49 PM
    Author     : sonnguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../head.jsp" %>
    </head>
    <%    if (session.getAttribute("DeTai") == null) {
    %>
    <s:action name="DeTaiGVTT" executeResult="true"/>
    <%
        }
    %>
    <%
        if (session.getAttribute("DeTai") != null) {
            session.removeAttribute("DeTai");
    %>
    <body>
        <%@include file="../giangvienthuctap/gvttheader.jsp" %>
        <section id="page-breadcrumb">
            <div class="vertical-center sun">
                <div class="container">
                    <div class="row">
                        <div class="action">
                            <div class="col-sm-12">
                                <h1 class="title">DANH SÁCH ĐỀ TÀI</h1>
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
                        <style>
                            #moTa {
                                line-height: 1.3em;
                                color: #3b5998!important;
                                margin: 0 0 5px;
                                -webkit-line-clamp: 2;
                                -webkit-box-orient: vertical;
                                overflow: hidden;
                                text-overflow: ellipsis;
                                display: -webkit-box;
                                max-height: 35px;
                            }
                        </style>
                        <div class="row">
                            <div class="col-lg-3"></div>
                            <div class="col-lg-3"></div>
                            <div class="col-lg-3">
                                <a href="danhSachDeTaiDongY"><input type="button" value="ĐỀ TÀI ĐÃ ĐỒNG Ý" class="btn btn-info" style="margin:20px; float:right"></a>
                            </div>
                            <div class="col-lg-3">
                                <a href="danhSachDeTaiTuChoi"><input type="button" value="ĐỀ TÀI ĐÃ TỪ CHỐI" class="btn btn-info" style="margin:20px; float:right"></a>
                            </div>
                            <%
                                if (session.getAttribute("DuyetDeTaiThanhCong") != null) {
                            %>
                            <p style="color: red; align-content: center">DUYỆT ĐỀ TÀI THÀNH CÔNG</p>
                            <%
                                    session.removeAttribute("DuyetDeTaiThanhCong");
                                }
                            %>
                            <%
                                if (session.getAttribute("DuyetDeTaiThatBai") != null) {
                            %>
                            <p style="color: red; align-content: center">DUYỆT ĐỀ TÀI THẤT BẠI</p>
                            <%
                                    session.removeAttribute("DuyetDeTaiThatBai");
                                }
                            %>

                            <div class="col-lg-12">
                                <s:iterator value="lstCTDT">
                                    <div class="row" style="margin-bottom: 25px">
                                        <div class="col-md-2">
                                            <div class="post-thumb">
                                                <a href="chiTietCongTy?maCongTy=<s:property value="msct"/>"><img style="width: 100%; height: 100%" src="<s:property value="avatar"/>" class="img-responsive" alt=""></a>
        <!--                                        <a href="dangKyDeTai?maDeTai=<s:property value="id"/>"><button class="btn btn-submit" style="height: 20%">Đăng ký</button></a>-->
                                            </div>
                                        </div>
                                        <div class="col-md-8">
                                            <div class="post-content overflow" style="padding: 0px">
                                                <h2 class="post-title bold"><a href="chiTietDeTaiGV?maDeTai=<s:property value="id"/>" style="font-size: 20px"><s:property value="tenDeTai"/></a></h2>
                                                <h3 class="post-author" style="font-size: 15px">Đăng bởi: <a href="chiTietCongTy?maCongTy=<s:property value="msct"/>" style="color: red"><s:property value="tenCongTy"/></a></h3>
                                                <p id="moTa">Nội dung: <s:property value="noiDung"/></p>
                                                <p id="moTa">Yêu cầu: <s:property value="yeuCau"/></p>
                                                <a href="chiTietDeTaiGV?maDeTai=<s:property value="id"/>" class="read-more">Xem thêm</a>
                                            </div>
                                        </div>
                                        <%
                                            if (session.getAttribute("DongYTuChoi") == null) {
                                        %>
                                        <div class="col-md-2">
                                            <div class="row">
                                                <div class="col-lg-12"><a href="dongYDeTai?maDeTai=<s:property value="id"/>"><input class="btn btn-success" style="margin-bottom: 10px" type="button" value="Đồng ý"/></a></div>
                                                <div class="col-lg-12"><a href="tuChoiDeTai?maDeTai=<s:property value="id"/>"><input class="btn btn-danger" style="margin-bottom: 10px" type="button" value="Từ chối"/></a></div>
                                            </div>
                                        </div>
                                        <%
                                            }
                                        %>
                                        <br/>
                                    </div>
                                </s:iterator>
                            </div>
                        </div>

                    </div>
                    <%@include file="../RightSidebar.jsp" %>
                </div>
            </div><!--/#testimonial-container-->
        </section>
        <!--/#features-->
        <%@include file="../footer.jsp" %>
        <%@include file="../js.jsp" %>
    </body>
    <%
        }
    %>
</html>
