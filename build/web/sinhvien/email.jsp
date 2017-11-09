<%-- 
    Document   : email
    Created on : Oct 20, 2017, 2:32:29 AM
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
    <body>
        <%@include file="/sinhvien/svheader.jsp" %>
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
                                            <form id="main-contact-form" name="contact-form" method="post" action="sendemail.php">
                                                <div class="form-group">
                                                    <input type="text" name="tieude" class="form-control" required="required" placeholder="Tiêu đề">
                                                </div>
                                                <div class="form-group">
                                                    <input type="email" name="nguoinhan" class="form-control" required="required" placeholder="Người nhận">
                                                </div>
                                                <div class="form-group">
                                                    <textarea name="message" id="message" required="required" class="form-control" rows="8" placeholder="Nhập nội dung.........."></textarea>
                                                </div>                        
                                                <div class="form-group">
                                                    <input type="submit" name="submit" class="btn btn-submit" value="Gửi thư">
                                                </div>
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
                                    <div class="sidebar-item categories">
                                        <ul class="nav navbar-stacked" style="height: 100%; overflow:auto">
                                            <li><a href="#">Lorem ipsum<span class="pull-right">(1)</span></a></li>
                                            <li class="active"><a href="#">Dolor sit amet<span class="pull-right">(8)</span></a></li>
                                            <li><a href="#">Adipisicing elit<span class="pull-right">(4)</span></a></li>
                                            <li><a href="#">Sed do<span class="pull-right">(9)</span></a></li>
                                            <li><a href="#">Eiusmod<span class="pull-right">(3)</span></a></li>
                                            <li><a href="#">Mockup<span class="pull-right">(4)</span></a></li>
                                            <li><a href="#">Ut enim ad minim <span class="pull-right">(2)</span></a></li>
                                            <li><a href="#">Veniam, quis nostrud <span class="pull-right">(8)</span></a></li>
                                            <li><a href="#">Adipisicing elit<span class="pull-right">(4)</span></a></li>
                                            <li><a href="#">Sed do<span class="pull-right">(9)</span></a></li>
                                            <li><a href="#">Eiusmod<span class="pull-right">(3)</span></a></li>
                                            <li><a href="#">Mockup<span class="pull-right">(4)</span></a></li>
                                            <li><a href="#">Ut enim ad minim <span class="pull-right">(2)</span></a></li>
                                            <li><a href="#">Veniam, quis nostrud <span class="pull-right">(8)</span></a></li>
                                        </ul>
                                    </div>
                                </div>

                                <div id="Paris" class="tabcontent">
                                    <h3>Paris</h3>
                                    <p>Paris is the capital of France.</p> 
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
</html>


