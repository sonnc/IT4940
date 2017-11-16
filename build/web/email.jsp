<%-- 
    Document   : email
    Created on : Nov 16, 2017, 12:44:02 AM
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
    </head>
    <%    if (session.getAttribute("GetAllEmail") == null) {
    %>
    <s:action name="GetAllEmail" executeResult="true"/>
    <%
        }
    %>
    <%
        if (session.getAttribute("GetAllEmail") != null) {
            session.removeAttribute("GetAllEmail");
    %>
    <body>
        <%            if (session.getAttribute("role").equals("0")) {
        %>
        <%@include file="./sinhvien/svheader.jsp" %>
        <%
        } else if (session.getAttribute("role").equals("1")) {
        %>
        <%@include file="./giangvienthuctap/gvttheader.jsp" %>
        <%
        } else if (session.getAttribute("role").equals("2")) {
        %>
        <%@include file="./giangvienhuongdan/gvhdheader.jsp" %>
        <%
        } else if (session.getAttribute("role").equals("3")) {
        %>
        <%@include file="./congty/ctheader.jsp" %>
        <%
            }
        %>

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
                                <p>Hộp thư của bạn: </p>
                                <button class="btn btn-lg btn-danger" onclick="if (document.getElementById('spoiler').style.display == 'none') {
                                            document.getElementById('spoiler').style.display = ''
                                        } else {
                                            document.getElementById('spoiler').style.display = 'none'
                                        }" title="Click to show/hide" type="button" style="margin: 10px 0 10px 0px">Gửi thư</button> 
                                <div id="spoiler" style="display: none; margin-top: 10px; margin-bottom: 10px">
                                    <div class="col-md-12 col-lg-12">
                                        <div class="contact-form bottom">
                                            <form method="post" action="GuiEmail">
                                                <div class="form-group">
                                                    <input type="text" name="tieuDe" class="form-control" required="required" placeholder="Tiêu đề">
                                                </div>
                                                <div class="form-group">
                                                    <input type="email" name="nguoiNhan" class="form-control" required="required" placeholder="Người nhận">
                                                </div>
                                                <div class="form-group">
                                                    <textarea name="noiDung" id="message" required="required" class="form-control" rows="8" placeholder="Nhập nội dung.........."></textarea>
                                                </div>  
                                                <%
                                                    if (session.getAttribute("role").equals("2")) {
                                                %>
                                                <div class="form-group">
                                                    <label>MÃ SÔ SINH VIÊN</label>
                                                    <input name="mssv" required="required">
                                                </div>
                                                <%
                                                    }
                                                %>
                                               
                                                <input type="checkbox" name="typeEmail" value="responed"> GỬI PHẢN HỒI<br>
                                                <div class="form-group">
                                                    <input type="submit" name="submit" class="btn btn-submit" value="GỬI THƯ">
                                                </div>
                                                <p style="margin-bottom: 40px">Lưu ý: Chức năng <strong>GỬI PHẢN HỒI</strong> chỉ dành cho Giảng viên hướng dẫn thực tập và giảng viên phụ trách thực tập tại trường.</p>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <br/>
                            <div class="col-lg-12">
                                <div class="tab">
                                    <button class="tablinks" onclick="openCity(event, 'London')" id="defaultOpen">Hộp thư đến</button>
                                    <button class="tablinks" onclick="openCity(event, 'Paris')">Hộp thư đi</button>
                                </div>
                                <div id="London" class="tabcontent">
                                    <div id="accordion-container">
                                        <div class="panel-group" id="accordion">
                                            <s:iterator value="lstHopThuDen">
                                                <div class="panel panel-default">
                                                    <div class="panel-heading">
                                                        <h4 class="panel-title">
                                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapse<s:property value="id"/>" aria-expanded="false" class="collapsed">
                                                                <strong><s:property value="tieuDe"/></strong>
                                                            </a>
                                                        </h4>
                                                    </div>
                                                    <div id="collapse<s:property value="id"/>" class="panel-collapse collapse" aria-expanded="false" style="">
                                                        <div class="panel-body">
                                                            <div style="margin-left: 15px">
                                                                <p style="color: blue; font-size: 12px">Người gửi: <s:property value="nguoiGui"/> - <s:property value="thoiGian"/></p>
                                                                <p style="font-size: 12px"><s:property value="noiDung"/></p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div> <!-- nọi dung-->
                                            </s:iterator>
                                        </div><!--/#accordion-->
                                    </div>
                                </div>  



                                <div id="Paris" class="tabcontent">
                                    <div id="accordion-container">
                                        <div class="panel-group" id="accordion">
                                            <s:iterator value="lstHopThuDi">
                                                <div class="panel panel-default">
                                                    <div class="panel-heading">
                                                        <h4 class="panel-title">
                                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapse<s:property value="id"/>" aria-expanded="false" class="collapsed">
                                                                <strong><s:property value="tieuDe"/></strong>
                                                            </a>
                                                        </h4>
                                                    </div>
                                                    <div id="collapse<s:property value="id"/>" class="panel-collapse collapse" aria-expanded="false" style="">
                                                        <div class="panel-body">
                                                            <div style="margin-left: 15px">
                                                                <p style="color: blue; font-size: 12px">Người nhận: <s:property value="nguoiNhan"/> - <s:property value="thoiGian"/></p>
                                                                <p style="font-size: 12px"><s:property value="noiDung"/></p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div> <!-- nọi dung-->
                                            </s:iterator>
                                        </div><!--/#accordion-->
                                    </div>
                                </div>

                                <script>
                                    function openCity(evt, cityName) {
                                        var i, tabcontent, tablinks;
                                        tabcontent = document.getElementsByClassName("tabcontent");
                                        for (i = 0; i < tabcontent.length; i++) {
                                            tabcontent[i].style.display = "none";
                                        }
                                        tablinks = document.getElementsByClassName("tablinks");
                                        for (i = 0; i < tablinks.length; i++) {
                                            tablinks[i].className = tablinks[i].className.replace(" active", "");
                                        }
                                        document.getElementById(cityName).style.display = "block";
                                        evt.currentTarget.className += " active";
                                    }

                                    // Get the element with id="defaultOpen" and click on it
                                    document.getElementById("defaultOpen").click();
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



