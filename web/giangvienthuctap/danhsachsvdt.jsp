<%-- 
    Document   : danhsachsvdt
    Created on : Nov 13, 2017, 1:04:51 PM
    Author     : sonnguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../head.jsp" %>
    </head>
    <%    if (session.getAttribute("DuyetDeTaiSinhVien") == null) {
    %>
    <s:action name="DuyetDeTaiSinhVien" executeResult="true"/>
    <%
        }
    %>
    <%
        if (session.getAttribute("DuyetDeTaiSinhVien") != null) {
            session.removeAttribute("DuyetDeTaiSinhVien");
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

                        <div class="col-lg-3"></div>
                        <div class="col-lg-3"></div>
                        <div class="col-lg-3"></div>
                        <div class="col-lg-3">
                            <a href="danhSachDeTaiSinhVienDongY"><input type="button" value="ĐỀ TÀI SINH VIÊN ĐÃ DUYỆT" class="btn btn-info" style="margin:20px; float:right"></a>
                        </div>

                        <div class="col-lg-12">
                            <s:iterator value="lstSinhVienDeTai">
                                <div class="row" style="margin-bottom: 25px">
                                    <div class="col-md-12">
                                        <div class="post-content overflow" style="padding: 0px">
                                            <h2 class="post-title bold">
                                                <a href="chiTietSinhVienGVTT?mssv=<s:property value="mssv"/>" style="font-size: 20px">
                                                    <s:property value="mssv"/> - <s:property value="hoTen"/> - <s:property value="lop"/> - K<s:property value="khoa"/> - <strong style="color: red"><s:property value="chiSoSoKhop"/></strong>
                                                </a></h2>
                                            <p id="moTa">Tên đề tài <s:property value="tenDeTai"/></p>
                                            <p id="moTa">Công Ty: <s:property value="tenCongTy"/></p>
                                        </div>
                                    </div>
                                    <br/>
                                </div>
                            </s:iterator>
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


