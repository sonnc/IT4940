<%-- 
    Document   : danhgia
    Created on : Nov 7, 2017, 11:54:59 AM
    Author     : sonnguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../head.jsp" %>
    </head>
    <%        if (session.getAttribute("FileSinhVien") == null) {
    %>
    <s:action name="getSinhVienFile" executeResult="true"/>
    <%
        }
    %>
    <%
        if (session.getAttribute("FileSinhVien") != null) {
            session.removeAttribute("FileSinhVien");
    %>
    <body>
        <%@include file="/sinhvien/svheader.jsp" %>
        <section id="page-breadcrumb">
            <div class="vertical-center sun">
                <div class="container">
                    <div class="row">
                        <div class="action">
                            <div class="col-sm-12">
                                <h1 class="title">FILE SINH VIÊN</h1>
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
                                                    <form method="post" action="uploadFile" enctype="multipart/form-data" style="margin: 15px 15px 15px 15px;">
                                                        <div class="row">
                                                            <div class="col-md-4">
                                                                <s:textfield  name="myFile" type="file" accept="file/*"  required="required"/>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <s:label>Tên file (mô tả)</s:label>
                                                                <s:textfield  name="tenFile" required="required"/>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <s:label>Chọn loại file</s:label>
                                                                    <select name="loaiFile"  class="form-control" required="required">
                                                                        <option value="1">Báo cáo cuối kỳ</option>
                                                                        <option value="2">Báo cáo giữa kỳ</option>
                                                                        <option value="5">Báo cáo hàng tuần</option>
                                                                        <option value="6">File học tập</option>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                            <br/>
                                                            <p>Tất cả định dạng <strong style="color: red">tên file gốc</strong> và <strong style="color: red">tên file (mô tả)</strong>
                                                            phải có định dạng như sau: [mã số sinh viên]-[tên file viết liền không dấu]
                                                            </p>
                                                            <p> Ví dụ: <strong style="color: blue">20138374-BaoCaoCuoiKy</strong></p>
                                                            <br/>
                                                            <input type="submit" name="submit" class="btn btn-submit" style="width: auto; text-align: center" value="UPLOAD FILE">
                                                        </form>
                                                    </div>
                                                    <div class="post-thumb">
                                                        <h3 style="margin-top: 50px">FILE THỰC TẬP</h3>
                                                    <%
                                                        if (session.getAttribute("FileSinhVienNULL") != null) {
                                                    %>
                                                    <h5><strong style="color: red">BẠN KHÔNG CÓ FILE NÀO TRONG HỆ THỐNG</strong></h5>
                                                    <%
                                                    } else {
                                                    %>
                                                    <s:iterator value="lstSinhVienFile">
                                                        <p>[<s:property value="ngayThang"/>] <s:property value="tenFile"/>: <a href="<s:property value="link"/>">TẢI XUỐNG</a></p>
                                                    </s:iterator>
                                                    <%
                                                        }
                                                    %>
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


