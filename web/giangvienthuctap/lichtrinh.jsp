<%-- 
    Document   : lichtrinh
    Created on : Nov 11, 2017, 12:56:01 PM
    Author     : sonnguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../head.jsp" %>
    </head>
    <%        if (session.getAttribute("GetAllLichTrinh") == null) {
    %>
    <s:action name="GetAllLichTrinh" executeResult="true"/>
    <%
        }
    %>
    <%
        if (session.getAttribute("GetAllLichTrinh") != null) {
            session.removeAttribute("GetAllLichTrinh");
    %>
    <body>
        <%@include file="/giangvienthuctap/gvttheader.jsp" %>
        <section id="page-breadcrumb">
            <div class="vertical-center sun">
                <div class="container">
                    <div class="row">
                        <div class="action">
                            <div class="col-sm-12">
                                <h1 class="title">LỊCH TRÌNH / THÔNG BÁO THỰC TẬP</h1>
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
                                            <div class="col-md-12">
                                                <div class="post-thumb" style="border-style: double;">
                                                    <h3 style="margin-top: 10px; margin-left: 10px">ĐĂNG LỊCH TRÌNH/ THÔNG BÁO</h3>
                                                    <form method="post" action="DangLichTrinh" style="margin: 15px 15px 15px 15px;">
                                                        <div class="row">
                                                            <div class="col-lg-12" >
                                                                <label>Tiêu đề: </label>
                                                                <input name="tieuDe" style="width: 100%" placeholder="Tiêu đề"> 
                                                            </div>
                                                            <div class="col-lg-12">
                                                                <label>Nội dung: </label>
                                                                <textarea name="noiDung" style="width: 100%; height: 250px" placeholder="Nội dung ........"> </textarea>
                                                            </div>
                                                            <input type="submit" name="submit" class="btn btn-submit" style="width: auto; text-align: center; margin-top: 15px; margin-left: 20px" value="ĐĂNG NGAY">
                                                        </div>
                                                    </form>
                                                </div>
                                                <div class="post-thumb">
                                                    <h3 style="margin-top: 50px">LỊCH TRÌNH / THÔNG BÁO ĐÃ ĐĂNG</h3>
                                                    <s:iterator value="lstThongBaoLichTrinh">
                                                        <div class="col-md-12 col-sm-12">
                                                            <div class="single-blog two-column">
                                                                <div class="post-content overflow">
                                                                    <h2 class="post-title bold"><a href="#"><s:property value="tieuDe"/></a></h2>
                                                                    <div class="row">
                                                                        <div class="col-md-4">
                                                                            <div class="post-thumb">
                                                                                <a href="blogdetails.html"><img style="height: 100%; width: 100%" src="asset/images/bk2017.jpg" class="img-responsive" alt=""></a>
                                                                                <div class="post-overlay">
                                                                                    <span class="uppercase"><a href="#"><s:property value="thoiGian"/></a></span>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-md-8">
                                                                            <h3 class="post-author"><a href="#"><s:property value="nguoiDang"/></a></h3>
                                                                            <p><s:property value="noiDung"/></p>
                                                                            <a href="#" class="read-more">View More</a>
                                                                        </div>
                                                                    </div>

                                                                </div>
                                                            </div>
                                                        </div>


                                                    </s:iterator>

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

    <%
        }
    %>
</html>

