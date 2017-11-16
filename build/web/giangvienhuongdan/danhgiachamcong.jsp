<%-- 
    Document   : danhgia
    Created on : Nov 16, 2017, 4:21:52 AM
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
    <%        if (session.getAttribute("DiemThi") == null) {
    %>
    <s:action name="GVHDFile" executeResult="true"/>
    <%
        }
    %>
    <%
        if (session.getAttribute("DiemThi") != null) {
            session.removeAttribute("DiemThi");
    %>
    <body>
        <%@include file="/giangvienhuongdan/gvhdheader.jsp" %>
        <section id="page-breadcrumb">
            <div class="vertical-center sun">
                <div class="container">
                    <div class="row">
                        <div class="action">
                            <div class="col-sm-12">
                                <h1 class="title">ĐÁNH GIÁ/ CHẤM CÔNG</h1>
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
                                <%
                                    if (session.getAttribute("ThanhCong") != null) {
                                %>
                                <p><strong style="color: red">ĐÃ GỬI BÁO CÁO THÀNH CÔNG</strong></p>
                                    <%
                                        }
                                    %>
                                <table id="myTable" > 

                                    <tr class="header" id="tr">
                                        <th>MSSV</th>
                                        <th>Họ tên</th>
                                        <th>Lớp</th>
                                        <th>File đánh giá</th>
                                        <th>File chấm công</th>
                                        <th></th>
                                    </tr> 
                                    <s:iterator value="lstSinhVienvaThucTap">  
                                        <form action="upFileByGVHD" method="post" enctype="multipart/form-data">
                                            <tr>
                                                <td><s:property value="mssv"/><input style="width: 0px; display: none" name="mssv" value="<s:property value="mssv"/>"></td>
                                                <td><a href="chiTietSinhVienGVHD?mssv=<s:property value="mssv"/>"><s:property value="hoTen"/></a></td>
                                                <td><s:property value="lop"/></td>
                                                <td> <input style="width: 175px" name="myFileDanhGia" type="file" accept="file/*" onchange="loadFile2(event)" required="required"/></td>
                                                <td><input style="width: 175px"  name="myFile" type="file" accept="file/*" onchange="loadFile(event)" required="required"/></td>  
                                                <td><input style="width: 100%" type="submit" class="btn btn-info" value="GỬI FILE"></td>                                      
                                            </tr>   
                                        </form>    
                                    </s:iterator>
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

