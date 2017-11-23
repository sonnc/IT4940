<%-- 
    Document   : diemthi
    Created on : Oct 20, 2017, 1:46:28 AM
    Author     : sonnguyen
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../head.jsp" %>
    </head>
    <%        if (session.getAttribute("CheckDiem") == null) {
    %>
    <s:action name="getDiemThiSinhVien" executeResult="true"/>
    <%
        }
    %>
    <%
        if (session.getAttribute("CheckDiem") != null) {
            session.removeAttribute("CheckDiem");
    %>
    <body>
        <%@include file="/sinhvien/svheader.jsp" %>
        <section id="page-breadcrumb">
            <div class="vertical-center sun">
                <div class="container">
                    <div class="row">
                        <div class="action">
                            <div class="col-sm-12">
                                <h1 class="title">THÔNG TIN ĐIỂM THI</h1>
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
                        <div class="row">
                            <div class="col-md-12 col-sm-12">
                                <div class="single-blog two-column">
                                    <div class="post-content overflow">
                                        <div class="row">
                                            <div class="col-md-3">
                                                <s:iterator value="%{#session.sinhVien}">
                                                    <div class="post-thumb">
                                                        <a href="blogdetails.html"><img style="height: 100%; width: 100%" src="<s:property value="avatar"/>" class="img-responsive" alt=""></a>
                                                    </div>
                                                </s:iterator>
                                            </div>
                                            <div class="col-md-9">
                                                <div class="project-name overflow">
                                                    <s:iterator value="%{#session.sinhVien}">
                                                        <h5 class="bold"><strong>MSVV: <s:property value="mssv"/></strong> </h5>
                                                        <h5 class="bold"><strong>HỌ TÊN: <s:property value="hoTen"/></strong> </h5>
                                                        <h5 class="bold"><strong>LỚP: <s:property value="lop"/><s:property value="sinhVien.khoa"/></strong></h5>
                                                        <h5 class="bold"><strong>KHOA/VIỆN: <s:property value="vienKhoa"/></strong></h5>
                                                    </s:iterator>                
                                                </div>
                                                <div>
                                                    <br />
                                                    <br />
                                                </div>
                                                <div class="project-name overflow">
                                                    <h5 class="bold" style="color: blue; text-align: center; font-size: 40px"><strong>ĐIỂM THỰC TẬP</strong></h5>
                                                    <br/>  
                                                    <%
                                                        String c = (String) session.getAttribute("sinhVienDiem");
                                                        if (c.equals("no")) {
                                                    %>
                                                    <p style="color: red; text-align: center"><strong>CHƯA CÓ ĐIỂM THI TRONG HỆ THỐNG</strong></p>
                                                    <%
                                                        }
                                                    %>
                                                    <%
                                                        if (session.getAttribute("sinhVienDiem").equals("yesFalse")) {
                                                    %>
                                                    <p style="color: red; text-align: center"><strong>Điểm thi do cán bộ hướng dẫn thực tập chấm</strong></p>
                                                    <p style="color: red; text-align: center"><strong>ĐIỂM CHƯA CHÍNH THỨC</strong></p>
                                                    <%
                                                        }
                                                    %>
                                                    <%
                                                        if (session.getAttribute("sinhVienDiem").equals("yesTrue")) {
                                                    %>
                                                    <p style="color: red; text-align: center"><strong>Điểm thi do Giảng viên phụ trách thực tập chấm</strong></p>
                                                    <p style="color: red; text-align: center"><strong>ĐIỂM CHÍNH THỨC</strong></p>
                                                    <%
                                                        }
                                                    %>
                                                    <s:iterator value="lstSinhVienDiem">
                                                        <table style="width:100%; font-size: 18px; ">
                                                            <tr>
                                                                <th style="text-align: center">Quá trình</th>
                                                                <th style="text-align: center">Cuối kỳ</th> 
                                                            </tr>
                                                            <tr style="font-size: 40px; color: red; font-style: oblique; text-align: center">
                                                                <td style="padding-top: 15px"><strong><s:property value="quaTrinh"/></strong></td>
                                                                <td  style="padding-top: 15px"><strong><s:property value="cuoiKy"/></strong></td>
                                                            </tr>
                                                        </table>    
                                                    </s:iterator>
                                                    <br/>
                                                    <s:iterator value="lstCongTySV">
                                                        <div id="alert-container">
                                                            <%
                                                                if (session.getAttribute("ThucTapFalse") != null) {
                                                            %>
                                                            <div class="alert alert-danger fade in">
                                                                <h4>CHƯƠNG TRÌNH THỰC TẬP THẤT BẠI</h4>
                                                                <p>Bạn đã không hoàn thành chương trình thực tập tại doanh nghiệp.</p>
                                                                <p>Tên công ty: <s:property value="tenCongTy"/></p>
                                                                <s:iterator value="lstDeTaiSV">
                                                                    <p>Đề tài: <s:property value="tenDeTai"/></p> 
                                                                </s:iterator>
                                                                <p>Đề biết thêm thông tin, xin vui lòng click vào tab Thông tin chi tiết</p>
                                                            </div>
                                                            <%
                                                            } else {
                                                            %>
                                                            <div class="alert alert-success fade in">
                                                                <h4>CHƯƠNG TRÌNH THỰC TẬP THÀNH CÔNG</h4>
                                                                <p>Bạn đã hoàn thành chương trình thực tập tại doanh nghiệp.</p>
                                                                <p>Tên công ty: <s:property value="tenCongTy"/></p>
                                                                <s:iterator value="lstDeTaiSV">
                                                                    <p>Đề tài: <s:property value="tenDeTai"/></p> 
                                                                </s:iterator>
                                                                <p>Đề biết thêm thông tin, xin vui lòng click vào tab Thông tin chi tiết</p>  
                                                            </div>
                                                            <%
                                                                }
                                                            %>
                                                        </div> 
                                                    </s:iterator>
                                                </div>
                                                <br/> 

                                                <div class="project-info overflow">
                                                    <h5><strong> THÔNG TIN CHI TIẾT</strong></h5>
<!--                                                    <div id="tab-container">
                                                        <ul id="tab2" class="nav nav-pills">
                                                            <li class="active"><a href="#tab2-item1" data-toggle="tab" aria-expanded="true">Quá trình</a></li>
                                                            <li class=""><a href="#tab2-item2" data-toggle="tab" aria-expanded="false">Cuối kỳ</a></li>
                                                        </ul>
                                                        <div class="tab-content">
                                                            <div class="tab-pane fade active in" id="tab2-item1">
                                                                <p>Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan american apparel, butcher voluptate nisi qui.</p>
                                                                <p>Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan american apparel, butcher voluptate nisi qui.</p>
                                                                <p>Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan american apparel, butcher voluptate nisi qui.</p>
                                                            </div>
                                                            <div class="tab-pane fade" id="tab2-item2">
                                                                <p>Food truck fixie locavore, accusamus mcsweeney's marfa nulla single-origin coffee squid. Exercitation +1 labore velit, blog sartorial PBR leggings next level wes anderson artisan four loko farm-to-table craft beer twee. Qui photo booth letterpress, commodo enim craft beer mlkshk aliquip jean shorts ullamco ad vinyl cillum PBR. Homo nostrud organic, assumenda labore aesthetic magna delectus mollit. Keytar helvetica VHS salvia yr, vero magna velit sapiente labore stumptown. Vegan fanny pack odio cillum wes anderson 8-bit, sustainable jean shorts beard ut DIY ethical culpa terry richardson biodiesel. Art party scenester stumptown, tumblr butcher vero sint qui sapiente accusamus tattooed echo park.</p>
                                                                <p>Food truck fixie locavore, accusamus mcsweeney's marfa nulla single-origin coffee squid. Exercitation +1 labore velit, blog sartorial PBR leggings next level wes anderson artisan four loko farm-to-table craft beer twee. Qui photo booth letterpress, commodo enim craft beer mlkshk aliquip jean shorts ullamco ad vinyl cillum PBR. Homo nostrud organic, assumenda labore aesthetic magna delectus mollit. Keytar helvetica VHS salvia yr, vero magna velit sapiente labore stumptown. Vegan fanny pack odio cillum wes anderson 8-bit, sustainable jean shorts beard ut DIY ethical culpa terry richardson biodiesel. Art party scenester stumptown, tumblr butcher vero sint qui sapiente accusamus tattooed echo park.</p>
                                                                <p>Food truck fixie locavore, accusamus mcsweeney's marfa nulla single-origin coffee squid. Exercitation +1 labore velit, blog sartorial PBR leggings next level wes anderson artisan four loko farm-to-table craft beer twee. Qui photo booth letterpress, commodo enim craft beer mlkshk aliquip jean shorts ullamco ad vinyl cillum PBR. Homo nostrud organic, assumenda labore aesthetic magna delectus mollit. Keytar helvetica VHS salvia yr, vero magna velit sapiente labore stumptown. Vegan fanny pack odio cillum wes anderson 8-bit, sustainable jean shorts beard ut DIY ethical culpa terry richardson biodiesel. Art party scenester stumptown, tumblr butcher vero sint qui sapiente accusamus tattooed echo park.</p>
                                                            </div>
                                                        </div>
                                                    </div>-->
                                                </div>


                                            </div>
                                        </div>

                                    </div>
                                </div>
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

