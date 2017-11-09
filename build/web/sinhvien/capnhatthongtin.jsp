<%-- 
    Document   : capnhatthongtin
    Created on : Oct 25, 2017, 10:28:32 AM
    Author     : sonnguyen
--%>

<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
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
        <%@include file="../sinhvien/svheader.jsp" %>
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
                                <form method="post" action="updateTaiKhoan" enctype="multipart/form-data">
                                    <div class="row">
                                        <div class="col-lg-4">
                                            <div class="form-group">
                                                <s:textfield type="text" value="%{sinhVien.hoTen}" name="sinhVien.hoTen" cssClass="form-control" required="required" placeholder="Họ tên" />
                                            </div>
                                            <div class="row">
                                                <div class="col-lg-6">
                                                    <div class="form-group">
                                                        <select name="sinhVien.lop" class="form-control" required="required">
                                                            <option value="Null">Chọn lớp</option>
                                                            <option value="INPG">INPG</option>
                                                            <option value="LTU">LTU</option>
                                                            <option value="LUH">LUH</option>
                                                            <option value="NUT">NUT</option>
                                                            <option value="UPMF">UPMF</option>
                                                        </select> 
                                                    </div> 
                                                </div>
                                                <div class="col-lg-6">
                                                    <div class="form-group">
                                                        <select name="sinhVien.khoa" class="form-control" required="required">
                                                            <option value="Null">Chọn khóa</option>
                                                            <%                                                                int year = Calendar.getInstance().get(Calendar.YEAR);
                                                                for (int i = year - 1956 - 10; i < year - 1956 + 10; i++) {
                                                            %>
                                                            <option value="<%=i%>"><%=i%></option>
                                                            <%
                                                                }
                                                            %>
                                                        </select> 
                                                    </div> 
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <s:textfield  value="%{sinhVien.vienKhoa}" type="text" name="sinhVien.vienKhoa" cssClass="form-control" required="required" placeholder="Viện/ Khoa"/>
                                            </div>                        
                                            <div class="form-group">
                                                <s:textfield  value="%{sinhVien.dienThoai}" type="number" name="sinhVien.dienThoai" cssClass="form-control" required="required" placeholder="Điện thoại"/>
                                            </div>   
                                        </div>
                                        <div class="col-lg-4">
                                            <div class="form-group">
                                                <s:textfield value="%{sinhVien.ngaySinh}" name="ngaySinh" cssClass="form-control" required="required" placeholder="Ngày sinh: dd-mm-yyyy"/>
                                            </div>   
                                            <div class="form-group">
                                                <s:textfield  value="%{sinhVien.diaChi}" type="text" name="sinhVien.diaChi" cssClass="form-control" required="required" placeholder="Địa chỉ"/>
                                            </div>                        
                                            <div class="form-group">
                                                <select name="sinhVien.lapTop" class="form-control" required="required"> 
                                                    <option value="Null">LapTop</option>
                                                    <option value="True">Có</option>
                                                    <option value="False">Không</option>
                                                </select>
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

                                    <h3>KỸ NĂNG VÀ LẬP TRÌNH</h3>
                                    <div class="alert alert-info fade in">
                                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">X</button>
                                        <h4>Xin làm theo hướng dẫn sau:</h4>
                                        <p>* Kỹ năng</p>
                                        <p>&nbsp;&nbsp;&nbsp; <strong>[Tên kỹ năng - Trình độ]</strong></p>
                                        <p>&nbsp;&nbsp;&nbsp; Ví dụ: [Thuyết trình - RT] [Tin học văn phòng - RT]</p>
                                        <p>* Lập trình</p>
                                        <p>&nbsp;&nbsp;&nbsp; <strong>[Loại lập trình - Ngôn ngữ 1/trình độ]</strong></p>
                                        <p>&nbsp;&nbsp;&nbsp; Ví dụ: [Lập trình web - java/B - html/TT] [Lập trình android - java/TT]</p>
                                        <p>&nbsp;&nbsp;&nbsp; Trình độ bao gồm: không biết (KB), biết (B), tốt (T), rất tốt (RT), thành thạo (TT) </p>
                                    </div>


                                    <div class="row">
                                        <div class="col-lg-6">
                                            <h4>Kỹ năng</h4>
                                            <s:textarea cssClass="form-control" name="sinhVienKnvaLt.kyNang" cssStyle="width: 100%; height:150px" required="required"/>
                                        </div>
                                        <div class="col-lg-6">
                                            <h4>Lập trình</h4>
                                            <s:textarea cssClass="form-control" name="sinhVienKnvaLt.lapTrinh" cssStyle="width: 100%; height:150px" required="required"/>
                                        </div>
                                    </div>

                                    <h3>MỤC TIÊU</h3>
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <div class="col-lg-12" style="margin-bottom: 10px">
                                                <s:textfield name="sinhVienMucTieu.viTriMongMuon" cssClass="form-control" required="required" placeholder="Vị trí mong muốn"/>
                                            </div>
                                            <div class="col-lg-12" style="margin-bottom: 10px">
                                                <s:textfield name="sinhVienMucTieu.loaiCongViec"  cssClass="form-control" required="required" placeholder="Loại công việc"/>
                                            </div>
                                            <div class="col-lg-12" style="margin-bottom: 10px">
                                                <s:textfield name="sinhVienMucTieu.nganhNgheMongMuon"  cssClass="form-control" required="required" placeholder="Ngành nghề mong muốn"/>
                                            </div>
                                            <div class="col-lg-12" style="margin-bottom: 10px">
                                                <s:textfield  name="sinhVienMucTieu.noiLamViecYeuThich" cssClass="form-control" required="required" placeholder="Nơi làm việc yêu thích"/>
                                            </div>
                                        </div>
                                        <div class="col-lg-6">
                                            <s:textarea   name="sinhVienMucTieu.khac" cssStyle="height:150px" cssClass="form-control" required="required" placeholder="Nội dung khác"/>
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

