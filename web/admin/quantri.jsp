<%-- 
    Document   : quantri
    Created on : Nov 16, 2017, 9:00:15 PM
    Author     : sonnguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../head.jsp" %>
    </head>
    <body>
        <section id="blog" class="padding-top">
            <p style="text-align: center">Xin chào: <strong>${sessionScope.email}</strong>  - <a href="logoutAdmin">Đăng xuất</a></p>
            <div class="container">
                <div class="row">
                    <div class="col-md-12" style="margin-bottom: 40px">
                        <div class="col-lg-3">
                            <a href="./admin/quanlytaikhoan.jsp"><input type="button" class="btn btn-info" style="height: 150px; width: 100%; font-size: 20px; margin: 10px" value="QUẢN LÝ TÀI KHOẢN"></a>
                        </div>
                        <div class="col-lg-3">
                            <a href="./admin/quanlysinhvien.jsp"><input type="button" class="btn btn-info" style="height: 150px; width: 100%; font-size: 20px; margin: 10px" value="QUẢN LÝ SINH VIÊN"></a>
                        </div>
                        <div class="col-lg-3">
                            <a href="./admin/quanlydiem.jsp"><input type="button" class="btn btn-info" style="height: 150px; width: 100%; font-size: 20px; margin: 10px" value="QUẢN LÝ ĐIỂM THI"></a>
                        </div>
                        <div class="col-lg-3">
                            <a href="./admin/quanlygiangvien.jsp"><input type="button" class="btn btn-info" style="height: 150px; width: 100%; font-size: 20px; margin: 10px" value="QUẢN LÝ GIẢNG VIÊN"></a>
                        </div>
                    </div>
                    <div class="col-md-12" style="margin-bottom: 20px">
                        <div class="col-lg-3">
                            <a href="./admin/quanlycongty.jsp"><input type="button" class="btn btn-info" style="height: 150px; width: 100%; font-size: 20px; margin: 10px" value="QUẢN LÝ CÔNG TY"></a>
                        </div>
                        <div class="col-lg-3">
                            <a href="./admin/quanlydetai.jsp"><input type="button" class="btn btn-info" style="height: 150px; width: 100%; font-size: 20px; margin: 10px" value="QUẢN LÝ ĐỀ TÀI"></a>
                        </div>
                        <div class="col-lg-3">
                            <a href="./admin/quanlythongbao.jsp"><input type="button" class="btn btn-info" style="height: 150px; width: 100%; font-size: 20px; margin: 10px" value="QUẢN LÝ THÔNG BÁO"></a>
                        </div>
                        <div class="col-lg-3">
                            <a href="./admin/quanlylogs.jsp"> <input type="button" class="btn btn-info" style="height: 150px; width: 100%; font-size: 20px; margin: 10px" value="QUẢN LÝ NHẬT KÝ"></a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
