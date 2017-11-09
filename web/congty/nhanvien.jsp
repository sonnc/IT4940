<%-- 
    Document   : canbo
    Created on : Nov 8, 2017, 3:02:32 AM
    Author     : sonnguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../head.jsp" %>
    </head>
    <%    if (session.getAttribute("NhanVien") == null) {
    %>
    <s:action name="CongTyGetNhanVien" executeResult="true"/>
    <%
        }
    %>
    <%
        if (session.getAttribute("NhanVien") != null) {
            session.removeAttribute("NhanVien");
    %>
    <body>
        <%@include file="../congty/ctheader.jsp" %>
        <section id="page-breadcrumb">
            <div class="vertical-center sun">
                <div class="container">
                    <div class="row">
                        <div class="action">
                            <div class="col-sm-12">
                                <h1 class="title">DANH SÁCH CÁN BỘ HƯỚNG DẪN</h1>
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
                                    <h3>QUẢN LÝ NHÂN VIÊN</h3>
                                    <form action="addNhanVien" method="post" enctype="multipart/form-data">
                                        <div class="row">
                                            <div class="col-lg-5">
                                                <p>Tạo tài khoản cho nhân viên</p>
                                                <div class="form-group">
                                                    <s:textfield type="email" placeholder="Email" name="nhanVien.email"  cssClass="form-control" required="required" />
                                                </div>
                                                <div class="form-group">
                                                    <s:textfield type="text" placeholder="Họ tên" name="nhanVien.hoTen" cssClass="form-control" required="required" />
                                                </div>
                                                <div class="form-group">
                                                    <s:textfield type="text" placeholder="Chức vụ" name="nhanVien.chucVu" cssClass="form-control" required="required" />
                                                </div>
                                                <div class="form-group">
                                                    <s:textfield type="text" placeholder="Điện thoại" name="nhanVien.dienThoai" cssClass="form-control" required="required" />
                                                </div>
                                            </div>
                                            <div class="col-lg-3">
                                                <p>Ảnh đại diện</p>
                                                <img id="output" style="height: 120px; width: 120px; border-radius: 100%; margin-bottom: 10px" />
                                                <s:textfield  name="myFile" type="file" accept="image/*" onchange="loadFile(event)" required="required"/>
                                                <script>
                                                    var loadFile = function (event) {
                                                        var reader = new FileReader();
                                                        reader.onload = function () {
                                                            var output = document.getElementById('output');
                                                            output.src = reader.result;
                                                        };
                                                        reader.readAsDataURL(event.target.files[0]);
                                                    };
                                                </script>
                                            </div>
                                            <div class="col-lg-3">
                                                <div class="form-group">
                                                    <input type="submit" name="submit" class="btn btn-submit" style="width: auto; float: right" value="Đăng ký">
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="single-blog two-column">
                                    <h3>DANH SÁCH NHÂN VIÊN</h3>
                                    <s:iterator value="lstGiangVienHuongDan">
                                        <div class="col-sm-4 text-center padding wow fadeIn animated" data-wow-duration="1000ms" data-wow-delay="300ms" style="visibility: visible; animation-duration: 1000ms; animation-delay: 300ms; animation-name: fadeIn; padding: 0px 0;">
                                            <div class="single-service">
                                                <div class="wow scaleIn animated" data-wow-duration="500ms" data-wow-delay="300ms" style="visibility: visible; animation-duration: 500ms; animation-delay: 300ms; animation-name: scaleIn;">
                                                    <a href="chitietnhanvien?id=<s:property value="id"/>"><img style="margin-bottom: 0px; height: 165px; width: 165px" src="<s:property value="avatar"/>" alt=""></a>
                                                </div>
                                                    <a href="chitietnhanvien?id=<s:property value="id"/>"><h4 style="margin-bottom: 0px;"><s:property value="hoTen"/></h4></a>
                                                <p><s:property value="chucVu"/></p>
                                                <p><s:property value="dienThoai"/></p>
                                                <p><s:property value="email"/></p>
                                            </div>
                                        </div>
                                    </s:iterator>
                                   
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