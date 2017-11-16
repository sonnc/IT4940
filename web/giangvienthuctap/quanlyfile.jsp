<%-- 
    Document   : quanlyfile
    Created on : Nov 15, 2017, 1:39:56 PM
    Author     : sonnguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../head.jsp" %>
    </head>
    <%        if (session.getAttribute("getAllFileGVTT") == null) {
    %>
    <s:action name="getAllFileGVTT" executeResult="true"/>
    <%
        }
    %>
    <%
        if (session.getAttribute("getAllFileGVTT") != null) {
            session.removeAttribute("getAllFileGVTT");
    %>
    <body>
        <%@include file="/giangvienthuctap/gvttheader.jsp" %>
        <section id="page-breadcrumb">
            <div class="vertical-center sun">
                <div class="container">
                    <div class="row">
                        <div class="action">
                            <div class="col-sm-12">
                                <h1 class="title">QUẢN LÝ FILE</h1>
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
                                                    <h3 style="margin-top: 10px">UPLOAD FILE </h3>
                                                    <form method="post" action="uploadFileGiangVien" enctype="multipart/form-data" style="margin: 15px 15px 15px 15px;">
                                                        <div class="row">
                                                            <div class="col-md-4">
                                                                <s:textfield  name="myFile" type="file" accept="file/*"  required="required"/>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <s:label>Tên file (mô tả)</s:label>
                                                                <s:textfield  name="tenFile" required="required"/>
                                                            </div>
                                                            <input type="submit" name="submit" class="btn btn-submit" style="width: auto; text-align: center" value="UPLOAD FILE">
                                                        </div>
                                                    </form>
                                                </div>
                                                <div class="post-thumb">
                                                    <h3 style="margin-top: 50px">FILE GIẢNG VIÊN</h3>
                                                    <s:iterator value="lstGiangVienFile">
                                                        <p>[<s:property value="ngayThang"/>] <s:property value="tenFile"/>: <a href="<s:property value="link"/>">TẢI XUỐNG</a></p>
                                                    </s:iterator>
                                                    <h3 style="margin-top: 50px">BÁO CÁO QUÁ TRÌNH</h3>
                                                    <s:iterator value="lstSinhVienFileBCQT">
                                                        <p>[<s:property value="ngayThang"/>] <s:property value="tenFile"/>: <a href="<s:property value="link"/>">TẢI XUỐNG</a></p>
                                                    </s:iterator>
                                                    <h3 style="margin-top: 50px">BÁO CÁO CUỐI KỲ</h3>
                                                    <s:iterator value="lstSinhVienFileBCCK">
                                                        <p>[<s:property value="ngayThang"/>] <s:property value="tenFile"/>: <a href="<s:property value="link"/>">TẢI XUỐNG</a></p>
                                                    </s:iterator>
                                                    <h3 style="margin-top: 50px">FILE ĐÁNH GIÁ</h3>
                                                    <s:iterator value="lstSinhVienFileDG">
                                                        <p>[<s:property value="ngayThang"/>] <s:property value="tenFile"/>: <a href="<s:property value="link"/>">TẢI XUỐNG</a></p>
                                                    </s:iterator>
                                                    <h3 style="margin-top: 50px">FILE CHẤM CÔNG</h3>
                                                    <s:iterator value="lstSinhVienFileCC">
                                                        <p>[<s:property value="ngayThang"/>] <s:property value="tenFile"/>: <a href="<s:property value="link"/>">TẢI XUỐNG</a></p>
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



