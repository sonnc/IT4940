<%-- 
    Document   : quanlydiem
    Created on : Nov 16, 2017, 11:51:24 PM
    Author     : sonnguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản trị thực tập</title>
        <%@include file="../head.jsp" %>
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
        <script type="text/javascript">
            function show_comfirm()
            {
                var comfirmBox;
                comfirmBox = confirm("BẠN CÓ CHẮC KHÔNG ?");

                if (comfirmBox == true) {
                    alert("Đã xóa khỏi cơ sỏ dữ liệu");
                    return true;
                } else {
                    alert("Quá trình đã được hủy");
                    return false;
                }
            }
        </script>
    </head>
    <body>
        <%    if (session.getAttribute("QuanLyDiem") == null) {
        %>
        <s:action name="QuanLyDiem" executeResult="true"/>
        <%
            }
        %>
        <%
            if (session.getAttribute("QuanLyDiem") != null) {
                session.removeAttribute("QuanLyDiem");
        %>

        <section id="page-breadcrumb">
            <div class="vertical-center sun">
                <div class="container">
                    <div class="row">
                        <div class="action">
                            <div class="col-sm-12">
                                <div class="row">
                                    <div class="col-lg-6"><p>Xin Chào: <strong>${sessionScope.email}</strong></p></div>
                                    <div class="col-lg-6"><a style="float: right; font-size: 20px" href="./admin/quantri.jsp">TRANG CHỦ</a></div>
                                </div> 
                                <h1 class="title">QUẢN LÝ ĐIỂM</h1>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section id="blog" class="">
            <div class="container">
                <div class="row">
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

                    <div class="row">
                        <div class="col-lg-12" style="margin: 0px ">   
                            <%
                                if (session.getAttribute("ThanhCong") != null) {
                            %>
                            <p style="color: red">THÀNH CÔNG</p>
                            <%
                                    session.removeAttribute("ThanhCong");
                                }
                            %>
                            <%
                                if (session.getAttribute("ThatBai") != null) {
                            %>
                            <p style="color: red">CÓ LỖI XẢY RA</p>
                            <%
                                    session.removeAttribute("ThatBai");
                                }
                            %>
                            <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Tìm kiếm mssv, họ tên ..." title="Type in a name">

                            <table id="myTable" >
                                <tr class="header" id="tr">
                                    <th>MSSV</th>
                                    <th>Điểm phản hồi</th>
                                    <th>Điểm BCQT</th>
                                    <th>Điểm QT</th>
                                    <th>Điểm CK</th>
                                    <th>Trạng thái</th>
                                    <th></th>
                                    <th></th>
                                </tr> 
                                <s:iterator value="lstSinhVienDiem">
                                    <tr>
                                        <td><s:property value="mssv"/></td>
                                        <td><s:property value="diemPhanHoi"/></td>
                                        <td><s:property value="diemBaoCaoQuaTrinh"/></td>
                                        <td><s:property value="quaTrinh"/></td>
                                        <td><s:property value="cuoiKy"/></td>
                                        <td><s:property value="trangThai"/></td>
                                        <td><a href="capNhatDiem?mssv=<s:property value="mssv"/>"><input onclick="return show_comfirm()" style="width: auto; " type="submit" name="submit" class="btn btn-danger" value="CẬP NHẬT ĐIỂM"></a></td>
                                        <td><a href="xoaDiem?mssv=<s:property value="mssv"/>"><input onclick="return show_comfirm()" style="width: auto; " type="submit" name="submit" class="btn btn-danger" value="XÓA ĐIỂM THI"></a></td>

                                    </tr>
                                </s:iterator>
                            </table>
                        </div>
                    </div>
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
            </div><!--/#testimonial-container-->
        </section>
    </body>
    <%
        }
    %>
</html>
