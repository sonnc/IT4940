<%-- 
    Document   : head
    Created on : Sep 9, 2017, 11:59:39 AM
    Author     : sonnguyen
--%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <%
        StringBuffer url = new StringBuffer();
        int port = request.getServerPort();
        if (port < 0) {
            port = 80; // Work around java.net.URL bug
        }
        String scheme = request.getScheme();
        url.append(scheme);
        url.append("://");
        url.append(request.getServerName());
        if (("http".equals(scheme) && (port != 80)) || ("https".equals(scheme) && (port != 443))) {
            url.append(':');
            url.append(port);
        }
        url.append(request.getContextPath());
        String URL = url.toString() + "/";
    %>
    <base href="<%=URL%>">

    <title>SIE | Thực tập doanh nghiệp</title>
    <link href="asset/css/bootstrap.min.css" rel="stylesheet">
    <link href="asset/css/font-awesome.min.css" rel="stylesheet">
    <link href="asset/css/animate.min.css" rel="stylesheet"> 
    <link href="asset/css/lightbox.css" rel="stylesheet"> 
    <link href="asset/css/main.css" rel="stylesheet">
    <link href="asset/css/responsive.css" rel="stylesheet">

    <!--[if lt IE 9]>
            <script src="js/html5shiv.js"></script>
            <script src="js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">

    <%       
        if (session.getAttribute("email") == null) {
            response.sendRedirect("../login.jsp");
        }
    %>
</head><!--/head-->
