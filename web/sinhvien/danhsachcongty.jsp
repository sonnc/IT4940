<%-- 
    Document   : danhsachcongty
    Created on : Sep 9, 2017, 11:35:18 PM
    Author     : sonnguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../head.jsp" %>
    </head>
    <%    if (session.getAttribute("DSCongTy") == null) {
    %>
    <s:action name="getAllCongTy" executeResult="true"/>
    <%
        }
    %>
    <%
        if (session.getAttribute("DSCongTy") != null) {
            session.removeAttribute("DSCongTy");
    %>
    <body>
        <%@include file="../sinhvien/svheader.jsp" %>
        <section id="page-breadcrumb">
            <div class="vertical-center sun">
                <div class="container">
                    <div class="row">
                        <div class="action">
                            <div class="col-sm-12">
                                <h1 class="title">DANH SÁCH CÔNG TY</h1>
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
                            <div class="col-md-12">
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
                                <s:iterator value="lstCongTySV">
                                    <div class="media">
                                        <div class="pull-left">
                                            <a href="chiTietCongTy?maCongTy=<s:property value="msct"/>"><img style="height: 81px; width: 81px" src="<s:property value="avatar"/>" alt=""></a>
                                        </div>
                                        <div class="media-body">
                                            <blockquote style="margin: 0 0 0px;"><a href="chiTietCongTy?maCongTy=<s:property value="msct"/>"><s:property value="tenCongTy"/></a></blockquote>
                                            <p id="moTa">Mô tả: <s:property value="moTa"/></p>
                                            <p style="margin: 0px">Địa chỉ: <s:property value="diaChi"/></p>
                                            <p style="margin: 0px">Điện thoại: <s:property value="dienThoai"/></p>
                                            <p style="margin: 0px">Website: <s:property value="website"/></p>
                                        </div>
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
