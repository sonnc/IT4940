<%-- 
    Document   : duyetdetai
    Created on : Nov 12, 2017, 10:19:03 AM
    Author     : sonnguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../head.jsp" %>
    </head>
    <%    if (session.getAttribute("DeTai") == null) {
    %>
    <s:action name="DeTaiGVTT" executeResult="true"/>
    <%
        }
    %>
    <%
        if (session.getAttribute("DeTai") != null) {
            session.removeAttribute("DeTai");
    %>
    <body>
        <%@include file="../giangvienthuctap/gvttheader.jsp" %>
        <section id="page-breadcrumb">
            <div class="vertical-center sun">
                <div class="container">
                    <div class="row">
                        <div class="action">
                            <div class="col-sm-12">
                                <h1 class="title">DUYỆT ĐỀ TÀI CÔNG TY</h1>
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
                        <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Tìm kiếm theo đề tài, ngôn ngữ lập trình hoặc theo người hướng dẫn ..." title="Type in a name">

                        <table id="myTable" > 

                            <tr class="header" id="tr">
                                <th style="width:60%;">Tên đề tài</th>
                                <th style="width:15%;">Số lượng</th>
                                <th style="width:10%;">Xóa</th>
                                <th style="width:15%;">Chi tiết</th>
                            </tr> 
                            <s:iterator value="lstCTDT">
                                <tr>
                                    <td>
                                        <div class="row">
                                            <div class="col-lg-12">
                                                <a href="chiTietDeTai?maDeTai=<s:property value="id"/>"><s:property value="tenDeTai"/></a>
                                            </div>
                                            <div class="col-lg-12">
                                                <h2 class="post-title bold"><a href="chiTietDeTai?maDeTai=<s:property value="id"/>" style="font-size: 20px"><s:property value="tenDeTai"/></a></h2>
                                                <h3 class="post-author" style="font-size: 15px">Đăng bởi: <a href="chiTietCongTy?maCongTy=<s:property value="msct"/>" style="color: red"><s:property value="tenCongTy"/></a></h3>
                                            </div>
                                        </div>
                                    </td>
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
                        <s:iterator value="lstCTDT">
                            <div class="row" style="margin-bottom: 25px">
                                <div class="col-md-2">
                                    <div class="post-thumb">
                                        <a href="chiTietCongTy?maCongTy=<s:property value="msct"/>"><img style="width: 100%; height: 100%" src="<s:property value="avatar"/>" class="img-responsive" alt=""></a>
<!--                                        <a href="dangKyDeTai?maDeTai=<s:property value="id"/>"><button class="btn btn-submit" style="height: 20%">Đăng ký</button></a>-->
                                    </div>
                                </div>
                                <div class="col-md-10">
                                    <div class="post-content overflow" style="padding: 0px">
                                        <h2 class="post-title bold"><a href="chiTietDeTai?maDeTai=<s:property value="id"/>" style="font-size: 20px"><s:property value="tenDeTai"/></a></h2>
                                        <h3 class="post-author" style="font-size: 15px">Đăng bởi: <a href="chiTietCongTy?maCongTy=<s:property value="msct"/>" style="color: red"><s:property value="tenCongTy"/></a></h3>
                                        <p id="moTa">Nội dung: <s:property value="noiDung"/></p>
                                        <p id="moTa">Yêu cầu: <s:property value="yeuCau"/></p>
                                        <a href="chiTietDeTai?maDeTai=<s:property value="id"/>" class="read-more">Xem thêm</a>
                                    </div>
                                </div>
                                <br/>
                            </div>
                        </s:iterator>
                        <%@include file="../RightSidebar.jsp" %>
                    </div>
                </div><!--/#testimonial-container-->
        </section>
        <!--/#features-->
        <%@include file="../footer.jsp" %>
        <%@include file="../js.jsp" %>
    </body>
    <%
        }
    %>
</html>
