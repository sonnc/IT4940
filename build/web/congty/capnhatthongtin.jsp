<%-- 
    Document   : capnhatthongtin
    Created on : Nov 8, 2017, 4:37:32 AM
    Author     : sonnguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../head.jsp" %>
    </head>
    <body>
        <%@include file="../congty/ctheader.jsp" %>
        <section id="page-breadcrumb">
            <div class="vertical-center sun">
                <div class="container">
                    <div class="row">
                        <div class="action">
                            <div class="col-sm-12">
                                <h1 class="title">CẬP NHẬT THÔNG TIN</h1>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section id="blog" class="">
            <div class="container">
                <div class="row">
                    <div class="col-md-9 col-sm-8">
                        <div style="margin-bottom: 70px">
                            <h3>TÀI KHOẢN</h3>
                            <div id="spoiler" style="">
                                <form method="post" action="capNhatThongTinDDCT" enctype="multipart/form-data">
                                    <div class="row">
                                        <div class="col-lg-4">
                                            <div class="form-group">
                                                <s:textfield type="text" value="%{daiDien.hoTen}" name="daiDien.hoTen" cssClass="form-control" required="required" placeholder="Họ tên" />
                                            </div>
                                            <div class="form-group">
                                                <s:textfield  value="%{daiDien.chucVu}" type="text" name="daiDien.chucVu" cssClass="form-control" required="required" placeholder="Chức vụ"/>
                                            </div>  
                                        </div>100
                                        <div class="col-lg-4">
                                            <div class="form-group">
                                                <s:textfield  value="%{daiDien.diaChi}" type="text" name="daiDien.diaChi" cssClass="form-control" required="required" placeholder="Địa chỉ"/>
                                            </div>  
                                            <div class="form-group">
                                                <s:textfield  value="%{daiDien.dienThoai}" type="text" name="daiDien.dienThoai" cssClass="form-control" required="required" placeholder="Điện thoại"/>
                                            </div>           
                                        </div>
                                        <div class="col-lg-4">
                                            <p>Ảnh đại diện</p>
                                            <img id="output" style="height: 100px; width: 100px; border-radius: 100%; margin-bottom: 10px" />
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
                                    </div>

                                    <h3>CÔNG TY</h3>
                                    <div class="row">
                                        <div class="col-lg-4">
                                            <div class="form-group">
                                                <s:textfield type="text" value="%{congTy.tenCongTy}" name="congTy.tenCongTy" cssClass="form-control" required="required" placeholder="Tên công ty" />
                                            </div>
                                            <div class="form-group">
                                                <s:textfield  value="%{congTy.diaChi}" type="text" name="congTy.diaChi" cssClass="form-control" required="required" placeholder="Địa chỉ"/>
                                            </div>  
                                        </div>
                                        <div class="col-lg-4">
                                            <div class="form-group">
                                                <s:textfield  value="%{congTy.dienThoai}" type="text" name="congTy.dienThoai" cssClass="form-control" required="required" placeholder="Điện thoại"/>
                                            </div>  
                                            <div class="form-group">
                                                <s:textfield  value="%{congTy.email}" type="text" name="congTy.email" cssClass="form-control" required="required" placeholder="Email"/>
                                            </div>           
                                            <div class="form-group">
                                                <s:textfield  value="%{congTy.website}" type="text" name="congTy.website" cssClass="form-control" required="required" placeholder="Website"/>
                                            </div>           
                                        </div>
                                        <div class="col-lg-4">
                                            <p>LOGO</p>
                                            <img id="output2" style="height: 100px; width: 100px; border-radius: 100%; margin-bottom: 10px" />
                                            <s:textfield  name="myFileLOGO" type="file" accept="image/*" onchange="loadFile2(event)" required="required"/>
                                            <script>
                                                var loadFile2 = function (event) {
                                                    var reader = new FileReader();
                                                    reader.onload = function () {
                                                        var output = document.getElementById('output2');
                                                        output.src = reader.result;
                                                    };
                                                    reader.readAsDataURL(event.target.files[0]);
                                                };
                                            </script>
                                        </div>
                                        <div class="col-lg-12">
                                            <h5>Mô tả công ty</h5>
                                            <s:textarea cssClass="form-control" type="text" name="congTy.moTa" cssStyle="width: 95%; height:150px" required="required"/>
                                        </div>
                                        <div class="col-lg-12">
                                            <h5>Lĩnh vực hoạt động</h5>
                                            <s:textarea cssClass="form-control" type="text" name="congTy.linhVucHoatDong" cssStyle="width: 95%; height:150px" required="required"/>
                                        </div>
                                    </div>
                                        <div class="form-group" style="margin-top: 10px">
                                        <input type="submit" name="submit" class="btn btn-submit" style="width: auto; float: right" value="Cập nhật">
                                    </div>
                                </form>
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
</html>
