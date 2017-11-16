<%-- 
    Document   : thongtincanhan
    Created on : Nov 11, 2017, 12:53:37 PM
    Author     : sonnguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../head.jsp" %>
        <style>
            * {box-sizing: border-box}
            body {font-family: "Lato", sans-serif;}

            /* Style the tab */
            div.tab {
                float: left;
                border: 1px solid #ccc;
                background-color: #f1f1f1;
                width: 20%;
                height: 20%;
            }

            /* Style the buttons inside the tab */
            div.tab button {
                display: block;
                background-color: inherit;
                color: black;
                padding: 22px 16px;
                width: 100%;
                border: none;
                outline: none;
                text-align: left;
                cursor: pointer;
                transition: 0.3s;
                font-size: 17px;
            }

            /* Change background color of buttons on hover */
            div.tab button:hover {
                background-color: #ddd;
            }

            /* Create an active/current "tab button" class */
            div.tab button.active {
                background-color: #ccc;
            }

            /* Style the tab content */
            .tabcontent {
                float: left;
                padding: 0px 12px;
                border: 1px solid #ccc;
                width: 80%;
                border-left: none;
                height: 100%;
            }
        </style>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6/jquery.min.js" type="text/javascript"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"
        type="text/javascript"></script>
        <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
              rel="Stylesheet" type="text/css" />
    </head>
    <body>
        <%@include file="../giangvienthuctap/gvttheader.jsp" %>
        <section id="page-breadcrumb">
            <div class="vertical-center sun">
                <div class="container">
                    <div class="row">
                        <div class="action">
                            <div class="col-sm-12">
                                <h1 class="title">THÔNG TIN CHI TIẾT</h1>
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
                                <form method="post" action="updateTaiKhoanGVHD" enctype="multipart/form-data">
                                    <div class="row">
                                        <div class="col-lg-4">
                                            <div class="form-group">
                                                <s:textfield type="text" value="%{giangVienHuongDan.hoTen}" name="giangVienHuongDan.hoTen" cssClass="form-control" required="required" placeholder="Họ tên" />
                                            </div>
                                            <div class="form-group">
                                                <s:textfield  value="%{giangVienHuongDan.diaChi}" type="text" name="giangVienHuongDan.diaChi" cssClass="form-control" required="required" placeholder="Viện/ Khoa"/>
                                            </div>                        
                                            <div class="form-group">
                                                <s:textfield  value="%{giangVienHuongDan.dienThoai}" type="number" name="giangVienHuongDan.dienThoai" cssClass="form-control" required="required" placeholder="Điện thoại"/>
                                            </div>   
                                        </div>
                                        <div class="col-lg-4">
                                            <div class="form-group">
                                                <s:textfield value="%{giangVienHuongDan.truong}" name="giangVienHuongDan.truong" cssClass="form-control" required="required" placeholder="Ngày sinh: dd-mm-yyyy"/>
                                            </div>   
                                            <div class="form-group">
                                                <s:textfield  value="%{giangVienHuongDan.khoaVien}" type="text" name="giangVienHuongDan.khoaVien" cssClass="form-control" required="required" placeholder="Địa chỉ"/>
                                            </div>                        

                                        </div>
                                        <div class="col-lg-4">
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
                                    </div>

                                    <h3>THÔNG TIN CHI TIẾT</h3>
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <h4>Các môn giảng dạy</h4>
                                            <s:textarea cssClass="form-control" name="sinhVienKnvaLt.kyNang" cssStyle="width: 100%; height:150px" required="required"/>
                                        </div>
                                        <div class="col-lg-12">
                                            <h4>Hướng nghiên cứu</h4>
                                            <s:textarea cssClass="form-control" name="sinhVienKnvaLt.lapTrinh" cssStyle="width: 100%; height:150px" required="required"/>
                                        </div>
                                        <div class="col-lg-12">
                                            <h4>Công trình nghiên cứu</h4>
                                            <s:textarea cssClass="form-control" name="sinhVienKnvaLt.kyNang" cssStyle="width: 100%; height:150px" required="required"/>
                                        </div>
                                        <div class="col-lg-12">
                                            <h4>Sách xuất bản</h4>
                                            <s:textarea cssClass="form-control" name="sinhVienKnvaLt.lapTrinh" cssStyle="width: 100%; height:150px" required="required"/>
                                        </div>
                                        <div class="col-lg-12">
                                            <h4>Thông tin khác</h4>
                                            <s:textarea cssClass="form-control" name="sinhVienKnvaLt.lapTrinh" cssStyle="width: 100%; height:150px" required="required"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
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


