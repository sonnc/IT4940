<%-- 
    Document   : tailieu
    Created on : Sep 9, 2017, 10:26:15 PM
    Author     : sonnguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<div class="col-md-3 col-sm-4">
    <div class="sidebar blog-sidebar">
        <div class="sidebar-item  recent">
            <h3>Công ty</h3>
            <marquee direction="up" onmouseover="this.stop()" onmouseout="this.start()" scrollamount="2">
                <s:iterator value="%{#session.lstCongTy}">
                  <div class="media">
                    <div class="pull-left">
                        <a href="#" style="height: 20px; width: 20px"><img src="asset/images/aboutus/1.jpg" alt=""></a>
                    </div>
                    <div class="media-body">
                        <h4><a href="#"><s:property value="tenCongTy"/></a></h4>
                        <p><s:property value="email"/></p>
                    </div>
                </div>  
                </s:iterator>
                
                
            </marquee>
        </div>
        <div class="sidebar-item categories">
            <h3>Tài liệu</h3>
            <ul class="nav navbar-stacked" style="height: 250px; overflow:auto">
                <li class="active"><a href="#">Đăng ký thực tập<span class="pull-right">(1)</span></a></li>
                <li ><a href="#">CV<span class="pull-right">(8)</span></a></li>
                <li><a href="#">Báo cáo mẫu<span class="pull-right">(4)</span></a></li>
                <li><a href="#">Đánh giá<span class="pull-right">(9)</span></a></li>
                <li><a href="#">Chức năng<span class="pull-right">(3)</span></a></li>
                <li><a href="#">Mô tả công ty<span class="pull-right">(4)</span></a></li>
                <li><a href="#">File Sinh viên<span class="pull-right">(2)</span></a></li>
            </ul>
        </div>
        <div class="sidebar-item tag-cloud">
            <h3>Tag Cloud</h3>
            <ul class="nav nav-pills">
                <li><a href="#">Corporate</a></li>
                <li><a href="#">Joomla</a></li>
                <li><a href="#">Abstract</a></li>
                <li><a href="#">Creative</a></li>
                <li><a href="#">Business</a></li>
                <li><a href="#">Product</a></li>
            </ul>
        </div>
        <div class="sidebar-item popular">
            <h3>Latest Photos</h3>
            <ul class="gallery">
                <li><a href="#"><img src="asset/images/portfolio/popular1.jpg" alt=""></a></li>
                <li><a href="#"><img src="asset/images/portfolio/popular2.jpg" alt=""></a></li>
                <li><a href="#"><img src="asset/images/portfolio/popular3.jpg" alt=""></a></li>
                <li><a href="#"><img src="asset/images/portfolio/popular4.jpg" alt=""></a></li>
                <li><a href="#"><img src="asset/images/portfolio/popular5.jpg" alt=""></a></li>
                <li><a href="#"><img src="asset/images/portfolio/popular1.jpg" alt=""></a></li>
            </ul>
        </div>
    </div>
</div>
