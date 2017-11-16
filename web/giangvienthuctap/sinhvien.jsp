<%-- 
    Document   : sinhvien
    Created on : Nov 11, 2017, 12:54:33 PM
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
    <%    if (session.getAttribute("DanhSachSinhVien") == null) {
    %>
    <s:action name="GVTTSinhVienThucTap" executeResult="true"/>
    <%
        }
    %>
    <%
        if (session.getAttribute("DanhSachSinhVien") != null) {
            session.removeAttribute("DanhSachSinhVien");
    %>
    <body>
        <%@include file="/giangvienthuctap/gvttheader.jsp" %>
        <section id="page-breadcrumb">
            <div class="vertical-center sun">
                <div class="container">
                    <div class="row">
                        <div class="action">
                            <div class="col-sm-12">
                                <h1 class="title">DUYỆT ĐỀ TÀI SINH VIÊN</h1>
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
                                <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Tìm kiếm MSSV, tên sinh viên ..." title="Type in a name">

                                <table id="myTable" > 

                                    <tr class="header" id="tr">
                                        <th>MSSV</th>
                                        <th>Họ tên</th>
                                        <th>Lớp</th>
                                        <th>Khóa</th>
                                        <th>Bắt đầu</th>
                                        <th>Kết thúc</th>
                                        <th>Số TT</th>
                                        <th></th>
                                    </tr> 
                                    <s:iterator value="lstSinhVienvaThucTap">
                                        <tr>
                                            <td><s:property value="mssv"/></td>
                                            <td><s:property value="hoTen"/></td>
                                            <td><s:property value="lop"/></td>
                                            <td><s:property value="khoa"/></td>
                                            <td><s:property value="thoiGianBatDau"/></td>
                                            <td><s:property value="thoiGianKetThuc"/></td>
                                            <td><s:property value="soLanThucTap"/></td>
                                            <td><a href="chiTietSinhVienGVTT?mssv=<s:property value="mssv"/>"><input style="width: auto; " type="submit" name="submit" class="btn btn-danger" value="Chi tiết"></a></td>

                                        </tr>
                                    </s:iterator>
                                </table>

                                <script>
                                    function myFunction() {
                                        var input, filter, table, tr, td0,td1, i, j, k, h, m, td1;
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
