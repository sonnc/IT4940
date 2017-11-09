<%-- 
    Document   : querySystem
    Created on : Nov 4, 2017, 9:32:57 AM
    Author     : sonnguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
    if (session.getAttribute("querySystemSinhVien") == null) {
        session.setAttribute("trangThai", "1");
%>
<s:action name="giangvien-detai-congty-dongy" executeResult="true"/>
<%
    }
%>

<%
    if (session.getAttribute("middle") != null) {
        session.removeAttribute("middle");
%>
%>