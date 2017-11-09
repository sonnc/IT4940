<%-- 
    Document   : l
    Created on : Sep 9, 2017, 10:52:16 AM
    Author     : sonnguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!--<!DOCTYPE html>
<html>
    <head>
        <title>Internship Sign In & Sign Up Form a Responsive Widget Template :: w3layouts</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Internship Sign In & Sign Up Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
         Custom Theme files 
        <link href="assetLogin/css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all">
        <link href="assetLogin/css/snow.css" rel="stylesheet" type="text/css" media="all" />
        <link href="assetLogin/css/style.css" rel="stylesheet" type="text/css" media="all" />
         //Custom Theme files 
         web font 
        <link href="//fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">
        <link href="//fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">

         //web font 
        <style>
            span.errorMessage{
                color: red;
                text-transform: initial;
                background: brown;
            }
        </style>

    </head>
    <body>
<%
    Cookie[] listCookie = request.getCookies();
    String email = "";
    String pass = "";
    int co = 0;
    if (listCookie != null) {
        while (co < listCookie.length) {
            if (listCookie[co].getName().equals("email")) {
                email = listCookie[co].getValue();
            }
            if (listCookie[co].getName().equals("password")) {
                pass = listCookie[co].getValue();
            }
            co++;
        }

    }
%>
${error}
<div class="snow-container">
    <div class="snow foreground"></div>
    <div class="snow foreground layered"></div>
    <div class="snow middleground"></div>
    <div class="snow middleground layered"></div>
    <div class="snow background"></div>
    <div class="snow background layered"></div>
</div>

<div class="top-buttons-agileinfo">
    <a href="index.html"  class="active">Sign In</a><a href="signup.html">Sign Up</a>
</div>
<h1>THỰC TẬP DOANH NGHIỆP</h1>
<div class="main-agileits">
    form-stars-here
    <div class="form-w3-agile">
        <h2 class="sub-agileits-w3layouts">ĐĂNG NHẬP VÀO HỆ THỐNG</h2>
        <form action="login" method="post">
<s:textfield type="email" name="email" placeholder="Tài khoản" required="required"/>
                    <input type="email" name="email" placeholder="Tài khoản" required="required" />
<s:textfield type="password" name="password" placeholder="Mật khẩu" required="required" />
<div>
    <a href="#" class="forgot-w3layouts">Quên mật khẩu ?</a>
    <p>Bạn là công ty và chưa có tài khoản? Hãy </p><a href="dangky.jsp" class="forgot-w3layouts"><strong>ĐĂNG KÝ</strong></a>
</div>

<div class="submit-w3l">
    <input type="submit" value="ĐĂNG NHẬP">
</div>
                            <p class="p-bottom-w3ls"><a href="signup.html">Sign Up here</a>if u do not have an account yet.</p>
</form>
</div>
</div>
//form-ends-here
copyright 
<div class="copyright w3-agile">
<p> © 2017 -HUST - SIE - Thực tập doanh nghiệp</p>
</div>
//copyright  
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>

</body>
</html>-->
<!DOCTYPE html>
<html >
    <head>
        <meta charset="UTF-8">
        <title>Login/Sign-In</title>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

        <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>

        <link rel="stylesheet" href="assetlogin/css/style.css">


    </head>

    <body>
        <div class="logmod">
            <div class="logmod__wrapper">
                <span class="logmod__close">Close</span>
                <div class="logmod__container">
                    <ul class="logmod__tabs">
                        <li data-tabtar="lgm-2"><a href="#">Đăng nhập</a></li>
                        <li data-tabtar="lgm-1"><a href="#">Đăng ký</a></li>
                    </ul>
                    <div class="logmod__tab-wrapper">
                        <div class="logmod__tab lgm-1">
                            <div class="logmod__heading" style="padding: 0px">
                                <p style="color: blue">Chức năng này chỉ dành cho CÔNG TY</p>
                                 <p style="color: red; font-size: 14px"><s:label name="error"/><p>
                            </div>
                            <div class="logmod__form">
                                <form accept-charset="utf-8" action="createAccount" method="post" class="simform">
                                    <div class="sminputs">
                                        <div class="input full">
                                            <label class="string optional" for="user-name">Email*</label>
                                            <input name="email" class="string optional" maxlength="255" id="user-email" placeholder="Email" type="email" size="50" />
                                        </div>
                                    </div>
                                    <div class="sminputs">
                                        <div class="input string optional">
                                            <label class="string optional" for="user-pw">Mật khẩu *</label>
                                            <input name="password" class="string optional" maxlength="255" id="user-pw" placeholder="Password" type="text" size="50" />
                                        </div>
                                        <div class="input string optional">
                                            <label class="string optional" for="user-pw-repeat">Nhập lại mật khẩu *</label>
                                            <input name="repeatPassword" class="string optional" maxlength="255" id="user-pw-repeat" placeholder="Repeat password" type="text" size="50" />
                                        </div>
                                    </div>
                                    <div class="simform__actions">
                                        <input class="sumbit" type="submit" value="Tạo tài khoản" />
                                        <span class="simform__actions-sidetext">Việc tạo tài khoản đồng nghĩa bạn chấp nhận các <a class="special" href="#" target="_blank" role="link">QUY ĐỊNH</a> của chúng tôi</span>
                                    </div> 
                                </form>
                            </div> 
                            
                        </div>
                        <div class="logmod__tab lgm-2" style="">
                            <div class="logmod__heading" style="padding: 0px">
                                <p style="color: red; font-size: 14px"><s:label name="error"/><p>
                            </div> 
                            <div class="logmod__form">
                                <form accept-charset="utf-8" action="login" method="post" class="simform">
                                    <div class="sminputs">
                                        <div class="input full">
                                            <label class="string optional" for="user-name">Email*</label>
                                            <s:textfield name="email" cssClass="string optional" maxlength="255" id="user-email" placeholder="Email" type="email" size="50" />
                                        </div>
                                    </div>
                                    <div class="sminputs">
                                        <div class="input full">
                                            <label class="string optional" for="user-pw">Mật khẩu *</label>
                                            <s:textfield name="password" cssClass="string optional" maxlength="255" id="user-pw" placeholder="Password" type="password" size="50" />
                                            <span class="hide-password">Hiện</span>
                                        </div>
                                    </div>
                                    <div class="simform__actions">
                                        <input class="sumbit" type="submit" value="Đăng nhập"/>
                                        <span class="simform__actions-sidetext"><a class="special" role="link" href="#">Quên mật khẩu?<br> Nhấn vào đây</a></span>
                                    </div> 
                                </form>
                            </div> 
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

        <script  src="assetlogin/js/index.js"></script>

    </body>
</html>