<%-- 
    Document   : detai
    Created on : Oct 20, 2017, 9:34:39 AM
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
    <s:action name="getAllDeTai" executeResult="true"/>
    <%        
        }
    %>
    <%    
        if (session.getAttribute("DeTai") != null) {
            session.removeAttribute("DeTai");
    %>
    <body>
        <%@include file="../sinhvien/svheader.jsp" %>
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
                        <%                        
                            if (session.getAttribute("SoDeTaiDK").equals("no")) {
                        %>
                        <h3 style="color: red; margin: 0px 0px 30px 0px; text-align: center"><strong>Hiện tại bạn chưa đăng ký đề tài nào </strong>!</h3>
                        <%    
                        } else if (session.getAttribute("QuaSoLuongDKDT") != null) {
                        %>
                        <h3 style="color: red; margin: 0px 0px 30px 0px; text-align: center">
                            <strong>Bạn đã đăng ký  <strong style="color: blue; "> 3 </strong>
                            </strong> đề tài! Bạn không thể đăng ký thêm đề tài. <a href="getSoLuongDeTaiDK">Xem danh sách</a></h3>
                            <%        
                            } else if (session.getAttribute("TrungDeTai") != null) {
                            %>
                        <h3 style="color: red; margin: 0px 0px 30px 0px; text-align: center">
                            <p style="color: blue"><strong>BẠN ĐÃ ĐĂNG KÝ ĐỀ TÀI NÀY</strong></p>
                            <strong>Bạn đã đăng ký  <strong style="color: blue"><%= session.getAttribute("SoDeTaiDK")%> </strong>>
                            </strong> đề tài! <a href="getSoLuongDeTaiDK">Xem danh sách</a></h3>
                            <%
                            } else {
                            %>
                        <h3 style="color: red; margin: 0px 0px 30px 0px; text-align: center">
                            <strong>Bạn đã đăng ký  <strong style="color: blue"><%= session.getAttribute("SoDeTaiDK")%> </strong>>
                            </strong> đề tài! <a href="getSoLuongDeTaiDK">Xem danh sách</a></h3>
                            <%
                                }
                            %>

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
                      
                        <s:iterator value="lstCTDT">
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
                                        <a href="chiTietDeTai?maDeTai=<s:property value="id"/>" class="read-more">Xem thêm</a>
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
    <%
        }
        session.removeAttribute("TrungDeTai");
    %>
</html>
