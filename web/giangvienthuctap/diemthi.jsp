<%-- 
    Document   : chamdiem
    Created on : Nov 11, 2017, 12:54:08 PM
    Author     : sonnguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../head.jsp" %>
        <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
        <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>
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
        <style>
            * {
                box-sizing: border-box;
            }

            #myInput {
                background-image: url('/css/searchicon.png');
                background-position: 10px 10px;
                background-repeat: no-repeat;
                width: 100%;
                font-size: 16px;
                padding: 12px 20px 12px 40px;
                border: 1px solid #ddd;
                margin-bottom: 12px;
            }

            #myTable {
                border-collapse: collapse;
                width: 100%;
                border: 1px solid #ddd;
                font-size: 12px;
            }

            #myTable th, #myTable td {
                text-align: left;
                padding: 12px;
            }

            #myTable tr {
                border-bottom: 1px solid #ddd;
            }

            #myTable tr.header, #myTable tr:hover {
                background-color: #f1f1f1;
            }
        </style>
    </head>
    <%        if (session.getAttribute("GVTTSinhVienThucTapDiemThi") == null) {
    %>
    <s:action name="GVTTSinhVienThucTapDiemThi" executeResult="true"/>
    <%
        }
    %>
    <%
        if (session.getAttribute("GVTTSinhVienThucTapDiemThi") != null) {
            session.removeAttribute("GVTTSinhVienThucTapDiemThi");
    %>
    <body>
        <%@include file="/giangvienthuctap/gvttheader.jsp" %>
        <section id="page-breadcrumb">
            <div class="vertical-center sun">
                <div class="container">
                    <div class="row">
                        <div class="action">
                            <div class="col-sm-12">
                                <h1 class="title">ĐIỂM THI SINH VIÊN</h1>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section id="blog" class="">
            <div class="container">
                <div class="row">

                    <div class="col-lg-9 col-sm-7">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="row" style="margin-bottom:20px">

                                    <div class="col-lg-7">
                                        <div class="row">  
                                            <s:iterator value="lstHeSoDiem">

                                                <div class="col-lg-6">
                                                    <p>Hệ số phản hồi: <strong><s:property value="heSoPhanHoi"/></strong></p>
                                                    <p>Hệ số Báo cáo Quá trình: <strong><s:property value="heSoBaoCaoQuaTrinh"/></strong></p>
                                                </div>
                                                <div class="col-lg-6">  
                                                    <p>Hệ số Quá trình: <strong><s:property value="heSoQuaTrinh"/></strong></p>
                                                    <p>Hệ số cuối kỳ: <strong><s:property value="heSoCuoiKy"/></strong></p> 
                                                </div>    
                                            </s:iterator>
                                            <%
                                                if (session.getAttribute("heSoDiem") != null) {
                                            %>
                                            <p><strong style="color: red; text-align: center">Xin hãy cập nhật các hệ số điểm ! </strong></p>
                                            <%
                                                    session.removeAttribute("heSoDiem");
                                                }
                                            %>
                                        </div>


                                    </div>
                                    <form>
                                        <div class="col-lg-3">
                                            <div class="row">
                                                <div class="col-lg-12" style="margin-bottom: 5px">
                                                    <input name="heSoPhanHoi" class="form-control" placeholder="HS phản hồi">
                                                </div>
                                                <div class="col-lg-12">
                                                    <input name="heSoCuoiKy" class="form-control" placeholder="HS cuối kỳ">
                                                </div>
                                            </div>

                                        </div>  
                                        <div class="col-lg-2">
                                            <a href="capNhatHeSoDiem"><input  class="form-control" type="button" value="LƯU"></a>
                                        </div>  
                                    </form>

                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="col-lg-6"> 
                                            <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Tìm kiếm MSSV, tên sinh viên ..." title="Type in a name">
                                        </div>
                                        <div class="col-lg-6">
                                            <a href="./giangvienthuctap/danhsachdiemthi.jsp"><input type="button" class="btn btn-info" style="float: right; height: 45px" value="DANH SÁCH ĐIỂM"> </a>
                                        </div>
                                    </div>
                                </div>
                                <table id="myTable" > 

                                    <tr class="header" id="tr">
                                        <th style="width:10%">MSSV</th>
                                        <th style="width:18%">Họ tên</th>
                                        <th style="width: 5%">Lớp</th>
                                        <th style="width: 16%">Điểm Công Ty</th>
                                        <th style="width: 10%">Điểm QT</th>
                                        <th style="width: 10%">Điểm CK</th>
                                        <th style="width: 10%">Đồng ý</th>
                                        <th style="width: 10%">Sửa điểm</th>
                                    </tr> 
                                    <s:iterator value="lstSinhVienDiem">
                                        <form action="capNhatDiemThi" method="post">
                                            <tr>
                                                <td><s:property value="mssv"/><input style="width: 0px; display: none" name="mssv" value="<s:property value="mssv"/>"></td>
                                                <td><a href="chiTietSinhVienGVTT?mssv=<s:property value="mssv"/>"><s:property value="hoTen"/></a></td>
                                                <td><s:property value="lop"/></td>
                                                <td>QT: <strong style="color: red"><s:property value="diemQuaTrinhCT"/></strong> - CK: <strong style="color: red"><s:property value="diemCuoiKyCT"/> - PH: <s:property value="soLuongPhanHoi"/></strong></td>
                                                <td><input id="diemQuaTrinh" name="diemQuaTrinh" style="width: 100%"></td>
                                                <td><input id="diemCuoiKy" name="diemCuoiKy" style="width: 100%"></td>  
                                                <td><input style="width: 100%" type="submit" class="btn btn-info" value="OK"  name="trangThai"></td>
                                                <td><input style="width: 100%" type="submit" class="btn btn-info" value="EDIT" name="trangThai"></td>
    <!--                                            <td><a href="capNhatDiemThi?mssv=<s:property value="mssv"/>&trangThai=FALSE&qt={$("#").val()}"><input style="width: 100%" type="button"  class="btn btn-danger" value="Sửa"></a></td>-->
                                            </tr>
                                        </form>
                                    </s:iterator>
                                </table>

                                <script>
                                    function myFunction() {
                                        var input, filter, table, tr, td0, td1, i, j, k, h, m, td1;
                                        input = document.getElementById("myInput");
                                        filter = input.value.toUpperCase();
                                        table = document.getElementById("myTable");
                                        tr = table.getElementsByTagName("tr");
                                        for (i = 0; i < tr.length; i++) {
                                            td0 = tr[i].getElementsByTagName("td")[0];
                                            td1 = tr[i].getElementsByTagName("td")[1];
                                            if (td0 || td1) {
                                                if (td0.innerHTML.toUpperCase().indexOf(filter) > -1 || td1.innerHTML.toUpperCase().indexOf(filter) > -1) {
                                                    tr[i].style.display = "";
                                                } else {
                                                    tr[i].style.display = "none";
                                                }
                                            }
                                        }
                                    }
                                </script>
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
