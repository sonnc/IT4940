<%-- 
    Document   : danhsachdkdt
    Created on : Nov 17, 2017, 4:07:35 AM
    Author     : sonnguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../head.jsp" %>
    </head>
    <body>
        <%@include file="../sinhvien/svheader.jsp" %>
        <section id="page-breadcrumb">
            <div class="vertical-center sun">
                <div class="container">
                    <div class="row">
                        <div class="action">
                            <div class="col-sm-12">
                                <h1 class="title">DANH SÁCH ĐỀ TÀI ĐÃ ĐĂNG KÝ</h1>
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

                        <s:iterator value="lstDanhSachDeTaiDK">
                            <div class="row" style="margin-bottom: 25px">
                                <div class="col-md-2">
                                    <div class="post-thumb">
                                        <a href="chiTietCongTy?maCongTy=<s:property value="msct"/>"><img style="width: 100%; height: 70px" src="asset/images/logo.png" class="img-responsive" alt=""></a>
                                        <a href="dangKyDeTai?maDeTai=<s:property value="id"/>"><button class="btn btn-submit" style="height: 20%">Đăng ký</button></a>
                                    </div>
                                </div>
                                <div class="col-md-10">
                                    <div class="post-content overflow" style="padding: 0px">
                                        <h2 class="post-title bold"><a href="chiTietDeTai?maDeTai=<s:property value="id"/>" style="font-size: 20px"><s:property value="tenDeTai"/></a></h2>
                                        <h3 class="post-author" style="font-size: 15px">Đăng bởi: <a href="chiTietCongTy?maCongTy=<s:property value="msct"/>" style="color: red"><s:property value="tenCongTy"/></a></h3>
                                        <p id="moTa">Nội dung: <s:property value="noiDung"/></p>
                                        <p id="moTa">Yêu cầu: <s:property value="yeuCau"/></p>
                                    </div>
                                </div>
                                <br/>
                            </div>
                        </s:iterator>
                    </div>
                    <%@include file="../RightSidebar.jsp" %>
                </div>
            </div><!--/#testimonial-container-->
        </section>
        <!--/#features-->
        <%@include file="../footer.jsp" %>
        <%@include file="../js.jsp" %>
    </body>
</html>

