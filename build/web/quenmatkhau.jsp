<%-- 
    Document   : quenmatkhau
    Created on : Nov 17, 2017, 11:34:38 AM
    Author     : sonnguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html >
    <head>
        <meta charset="UTF-8">
        <title>Quên mật khẩu</title>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

        <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>

        <link rel="stylesheet" href="assetlogin/css/style.css">


    </head>

    <body>
        <div class="logmod">
            <div class="logmod__wrapper">
                <div class="logmod__form">
                    <form accept-charset="utf-8" action="getPass" method="post" class="simform">
                        <div class="sminputs">
                            <div class="input full">
                                <h4 style="text-align: center">Lấy lại mật khẩu</h4>
                                <%
                                if(session.getAttribute("resetPass") != null){
                                %>
                                <p style="color: red">Mật khẩu của bạn đã được gửi.</p>
                                <%
                                }
                                %>
                                <label class="string optional" for="user-name">Email</label>
                                <input style="height: 40px; background-color: #e3e3e3" name="email" class="string optional" maxlength="255" id="user-email" type="email" size="150" />
                                <label class="string optional" for="user-name">Điện thoại</label>
                                <input style="height: 40px; background-color: #e3e3e3" name="dienThoai" class="string optional" maxlength="255" id="user-email" size="150" />
                            </div>
                            <input style="margin-top: 150px; margin-left: 200px;margin-bottom: 20px;background-color: burlywood;" type="submit" class="btn btn-error" value="Lấy mật khẩu" >
                        </div>
                    </form>
                </div> 
            </div>
        </div>
        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

        <script  src="assetlogin/js/index.js"></script>

    </body>
</html>