<%-- 
    Document   : detai
    Created on : Nov 8, 2017, 3:02:47 AM
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
                font-size: 18px;
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
    <%    if (session.getAttribute("GetAllDeTai") == null) {
    %>
    <s:action name="CongTyGetAllDeTai" executeResult="true"/>
    <%
        }
    %>
    <%
        if (session.getAttribute("GetAllDeTai") != null) {
            session.removeAttribute("GetAllDeTai");
    %>
    <body>
        <%@include file="/congty/ctheader.jsp" %>
        <section id="page-breadcrumb">
            <div class="vertical-center sun">
                <div class="container">
                    <div class="row">
                        <div class="action">
                            <div class="col-sm-12">
                                <h1 class="title">EMAIL</h1>
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
                                <button class="btn btn-lg btn-danger" onclick="if (document.getElementById('spoiler').style.display == 'none') {
                                            document.getElementById('spoiler').style.display = ''
                                        } else {
                                            document.getElementById('spoiler').style.display = 'none'
                                        }" title="Click to show/hide" type="button" style="margin: 10px 0 10px 0px">Đăng đề tài</button> 
                                <div id="spoiler" style="display: none; margin-top: 10px; margin-bottom: 10px">
                                    <div class="col-md-12 col-lg-12">
                                        <div class="contact-form bottom">
                                            <form id="form_register" method="post" action="addDeTai">
                                                <div class="row">
                                                    <div class="col-lg-9">
                                                        <div class="form-group">
                                                            <input type="text" name="deTai.tenDeTai" class="form-control" required="required" placeholder="Tên đề tài">
                                                        </div>
                                                    </div>
                                                    <div class="col-lg-3">
                                                        <div class="form-group">
                                                            <input id="soluong" name="deTai.soLuong" class="form-control"  placeholder="Số lượng" required="required"/>
                                                            <span id="soluong_error"></span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-lg-6">
                                                        <div class="form-group">
                                                            <textarea style="height: 150px" type="text" name="deTai.noiDung" class="form-control" required="required" placeholder="Nội dung ..."></textarea>
                                                        </div>
                                                    </div>
                                                    <div class="col-lg-6">
                                                        <div class="form-group">
                                                            <textarea style="height: 150px" type="text" name="deTai.yeuCau" class="form-control" required="required" placeholder="Yêu cầu ..."></textarea>
                                                        </div>
                                                    </div>
                                                </div>     
                                                <div class="row">
                                                    <div class="col-lg-12">
                                                        <p>Hãy chọn giảng viên hướng dẫn cho đề tài này</p>
                                                        <select name="giangVienHD" class="form-group" style="width: auto">
                                                            <s:iterator value="lstGiangVienHuongDan">
                                                                <option value="<s:property value="id"/>"> <s:property value="hoTen"/></option>
                                                            </s:iterator>
                                                        </select>
                                                    </div>
                                                    <p style="color: red; text-align: center">CHÚ Ý</p>
                                                    <p style="color: red; text-align: center">Trong nội dung "Yêu cầu" phải có định dạng: [tên ngôn ngữ lập trình - xếp loại]</p>
                                                    <p style="color: red; text-align: center">Ví dụ: [Java - RT] [HTML - RT]</p>
                                                </div>
                                                <div class="form-group">
                                                    <%
                                                        if (session.getAttribute("soLuongGVHD").equals(0)) {
                                                    %>
                                                    <p style="color: red">Bạn phải đăng ký giảng viên hướng dẫn</p>
                                                    <input style="width: auto;" disabled="true" type="submit" name="submit" class="btn btn-submit" value="GỬI NGAY">
                                                    <%
                                                        }
                                                    %>
                                                    <input style="width: auto;" type="submit" name="submit" class="btn btn-submit" value="GỬI NGAY">
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <br/>
                            <div class="col-lg-12">
                                <h3>DANH SÁCH ĐỀ TÀI</h3>
                                <%
                                    if (session.getAttribute("success") != null) {

                                %>
                                <p style="color: red; text-align: center">Bạn đã xóa thành công đề tài này ra khỏi hệ thống.</p>
                                <%                                        session.removeAttribute("success");
                                    }
                                %>
                                <%
                                    if (session.getAttribute("error") != null) {

                                %>
                                <p style="color: red; text-align: center">Bạn không thể xóa đề tài này. Đề tài này đã có sinh viên đang ký hoặc đang trong chế độ chờ.</p>
                                <%                                        session.removeAttribute("error");
                                    }
                                %>
                                <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Tìm kiếm theo đề tài, ngôn ngữ lập trình hoặc theo người hướng dẫn ..." title="Type in a name">

                                <table id="myTable" > 

                                    <tr class="header" id="tr">
                                        <th style="width:60%;">Tên đề tài</th>
                                        <th style="width:15%;">Số lượng</th>
                                        <th style="width:10%;">Xóa</th>
                                        <th style="width:15%;">Chi tiết</th>
                                    </tr> 
                                    <s:iterator value="lstDeTai">
                                        <tr>
                                            <td><s:property value="tenDeTai"/></td>
                                            <td><s:property value="soLuong"/></td>
                                            <td><a href="xoaDeTai?maDeTai=<s:property value="id"/>"><input style="width: auto; " type="submit" name="submit" class="btn btn-danger" value="XÓA"></a></td>
                                            <td><a href="chiTietDeTaiCT?maDeTai=<s:property value="id"/>"><input style="width: auto; " type="submit" name="submit" class="btn btn-info" value="CHI TIẾT"></a></td>
                                        </tr>
                                    </s:iterator>
                                </table>

                                <script>
                                    function myFunction() {
                                        var input, filter, table, tr, td, i, j, k, h, m, td1;
                                        input = document.getElementById("myInput");
                                        filter = input.value.toUpperCase();
                                        table = document.getElementById("myTable");
                                        tr = table.getElementsByTagName("tr");
                                        for (i = 0; i < tr.length; i++) {
                                            td = tr[i].getElementsByTagName("td")[0];
                                            if (td) {
                                                if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                                                    tr[i].style.display = "";
                                                } else {
                                                    tr[i].style.display = "none";
                                                }
                                            }
                                        }
                                    }
                                </script>
                            </div>

                            <!--                            <div class="row" style="margin-bottom: 25px">
                                                            <input type="text" id="myInput2" onkeyup="myFunction2()" placeholder="Tìm kiếm " title="Type in a name">
                                                            <ul id="myUL">
                                                                <li>
                                                                    <div class="col-md-2">
                                                                        <div class="post-thumb">
                                                                            <a href=""><img style="width: 100%; height: 70px" src="asset/images/logo.png" class="img-responsive" alt=""></a>
                                                                            <a href=""><button class="btn btn-submit" style="height: 20%">Đăng ký</button></a>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-md-10">
                                                                        <div class="post-content overflow" style="padding: 0px">
                                                                            <h2 class="post-title bold" id="theh2"><a href="" style="font-size: 20px">Lập trình java</a></h2>
                                                                            <h3 class="post-author" style="font-size: 15px">Đăng bởi: <a href="" style="color: red">cvdassbfa</a></h3>
                                                                            <p id="moTa">Nội dung: csdavdab</p>
                                                                            <p id="moTa">Yêu cầu:,uo.y,mtgvedv</p>
                                                                            <a href="chiTietDeTai?maDeTai=<s:property value="id"/>" class="read-more">Xem thêm</a>
                                                                        </div>
                                                                    </div>
                                                                </li>
                                                                <li>
                                                                    <div class="col-md-2">
                                                                        <div class="post-thumb">
                                                                            <a href=""><img style="width: 100%; height: 70px" src="asset/images/logo.png" class="img-responsive" alt=""></a>
                                                                            <a href=""><button class="btn btn-submit" style="height: 20%">Đăng ký</button></a>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-md-10">
                                                                        <div class="post-content overflow" style="padding: 0px">
                                                                            <h2 class="post-title bold" id="theh2"><a href="" style="font-size: 20px">Lập trình web</a></h2>
                                                                            <h3 class="post-author" style="font-size: 15px">Đăng bởi: <a href="" style="color: red">cvdassbfa</a></h3>
                                                                            <p id="moTa">Nội dung: csdavdab</p>
                                                                            <p id="moTa">Yêu cầu:,uo.y,mtgvedv</p>
                                                                            <a href="chiTietDeTai?maDeTai=<s:property value="id"/>" class="read-more">Xem thêm</a>
                                                                        </div>
                                                                    </div>
                                                                </li>
                                                            </ul>
                            
                            
                            
                                                            <script>
                                                                // lấy thẻ input
                                                                var input = document.getElementById("myInput2");
                                                                // định nghĩa hàm xử lý myFunction
                                                                function myFunction2() {
                                                                    var filter, ul, li, a, i;
                                                                    // lấy giá trị người dùng nhập
                                                                    filter = input.value.toUpperCase();
                                                                    ul = document.getElementById("myUL");
                                                                    li = ul.getElementsByTagName("li");
                                                                    // Nếu filter không có giá trị thị ẩn phần kết quare\
                            
                                                                    // lặp qua tất cả các thẻ li chứa kết quả
                                                                    for (i = 0; i < li.length; i++) {
                                                                        // lấy thẻ a trong các thẻ li
                                                                        a = li[i].getElementsByTagName("h2")[0];
                                                                        // kiểm tra giá trị nhập có tôn tại trong nội dung thẻ a
                                                                        if (a.innerHTML.toUpperCase().indexOf(filter) > -1) {
                                                                            //nếu có hiển thị phàn tử ul và các thẻ li đó
                                                                            ul.style.display = "block";
                                                                            li[i].style.display = "";
                                                                        } else {
                                                                            // nếu không ẩn các thẻ li
                                                                            li[i].style.display = "none";
                            
                                                                        }
                            
                                                                    }
                                                                }
                                                                //gán sự kiện cho thẻ input
                                                                input.addEventListener("keyup", myFunction);
                                                            </script>
                                                        </div>-->

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
    <!--    <script>
            // lấy thẻ input
            var input = document.getElementById("myInput");
            // định nghĩa hàm xử lý myFunction
            function myFunction() {
                var filter, table, tr, td, i;
                // lấy giá trị người dùng nhập
                filter = input.value.toUpperCase();
    
                // lấy phần bảng hiển thị kết quả
                table = document.getElementById("myTable");
                // lấy tất cả các thẻ tr
                tr = table.getElementsByTagName("tr");
    
                //Nếu filter không có giá trị ẩn các kết quả
    
                // lặp qua tất cả các thẻ tr
                for (i = 0; i < tr.length; i++) {
                    // lấy giá trị của thẻ td đầu tiên đại diện cho tên club
                    td = tr[i].getElementsByTagName("td")[0];
                    if (td) {
                        // kiểm tra giá trị filter có tồn tại trong thẻ tr không
                        if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                            //nếu có hiển thị chúng
                            table.style.display = "table";
                            tr[i].style.display = "";
                        } else {
                            // nếu không ẩn chúng
                            tr[i].style.display = "none";
                        }
                    }
                }
    
            }
            //gán sự kiện cho thẻ input
            input.addEventListener("keyup", myFunction);
        </script>-->
</html>


