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
                            <a href="chiTietCongTyGV?maCongTy=<s:property value="msct"/>" style="height: 20px; width: 20px"><img style="width:70px; height:70px;" src="<s:property value="avatar"/>" alt=""></a>
                        </div>
                        <div class="media-body">
                            <h4><a href="chiTietCongTyGV?maCongTy=<s:property value="msct"/>"><s:property value="tenCongTy"/></a></h4>
                            <p><s:property value="email"/></p>
                        </div>
                    </div>  
                </s:iterator>


            </marquee>
        </div>
        <div class="sidebar-item categories">
            <h3>Tài liệu</h3>
            <s:iterator value="%{#session.lstFile}">
                <ul class="nav navbar-stacked" style="height: 150px; overflow:auto">
                    <li ><a href="<s:property value="link"/>"><s:property value="tenFile"/><span class="pull-right"><s:property value="ngayThang"/></span></a></li>
                </ul>
            </s:iterator>
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
            <h3>Trường đối tác</h3>
            <ul class="gallery">
                <li><a href="#"><img src="asset/images/universite/hust.png" alt=""></a></li>
                <li><a href="#"><img src="asset/images/universite/inpg.png" alt=""></a></li>
                <li><a href="#"><img src="asset/images/universite/ltu.png" alt=""></a></li>
                <li><a href="#"><img src="asset/images/universite/nut.png" alt=""></a></li>
                <li><a href="#"><img src="asset/images/universite/troy.png" alt=""></a></li>
                <li><a href="#"><img src="asset/images/universite/upmf.png" alt=""></a></li>
            </ul>
        </div>
    </div>
</div>
