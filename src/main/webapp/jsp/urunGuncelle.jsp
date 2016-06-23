<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="com.utku.service.*" %>
    <%@page import="com.utku.model.*" %>
    <%@page import="javax.servlet.http.HttpServletRequest" %>
    <%@page import="javax.servlet.http.HttpServletResponse" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Ürün Güncelle | E-Ticaret</title>
   <%@ include file="headerAdmin.jsp"%> 
</head>

<body>
<%if(session.getAttribute("admin")==null){
	response.sendRedirect("admin");}%>
<%UrunService us = new UrunService();%>
<%int id = Integer.parseInt(request.getParameter("guncelle"));%>
<%Urun urun=new Urun(); %>
<%urun=us.findById(id); %>
<%AltAltKategoriService akts = new AltAltKategoriService(); %>
<%AltAltKategori k=new AltAltKategori(); %>
<%k=akts.findById(urun.getAltaltkategoriId().getAltaltk_id());%>
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Ürün Bilgileri Güncelleyin</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form" method="post" action="UrunnGuncelle?urunId=<%=urun.getU_id()%>" enctype="multipart/form-data">
                            <fieldset>                                
                                <div class="form-group">Ürünün Şuanki kategorisi: <%=k.getAd()%>                                   
									<select class="form-control" name="formKategori" value="<%=urun.getAltaltkategoriId()%>">
										<option value="1">Erkek--T-Shirt</option>
										<option value="3">Erkek--Ceket</option>
										<option value="4">Erkek--Kazak</option>
										<option value="5">Erkek--Jean</option>
										<option value="6">Erkek--Eşortman</option>
										<option value="2">Bayan--Mont</option>
										<option value="7">Bayan--Bluz</option>
										<option value="8">Bayan--Elbise</option>
										<option value="9">Bayan--Jean</option>
										<option value="10">Bayan--Etek</option>
									</select>
                                </div>
								<div class="form-group">
                                    Ürün Adı:<input class="form-control" placeholder="Ürün Adı" name="urunAd" type="text" autofocus value="<%=urun.getAd()%>">
                                </div>
								<div class="form-group">
                                    Açıklama:<input class="form-control" placeholder="Açıklama" name="urunAciklama" type="text" autofocus value="<%=urun.getAciklama()%>">
                                </div>
								<div class="form-group">
                                    Fiyat:<input class="form-control" placeholder="Fiyat" name="urunFiyat" type="text" autofocus value="<%=urun.getFiyat()%>">
                                </div>
								<div class="form-group">
                                   Stok:<input class="form-control" placeholder="Stok" name="urunStok" type="text" autofocus value="<%=urun.getStok()%>">
                                </div>
<!--                                 <div class="form-group"> -->
<%-- 									Resim Yükle<input type="file" name="resim" value="<%=urun.getResim()%>"> --%>
<!-- 								</div> -->
                                <!-- Change this to a button or input when using this as a form -->
                                <button type="submit" class="btn btn-lg btn-primary btn-block">Ürün Güncelle</button>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="${pageContext.request.contextPath}/bower_components/jquery/dist/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/bower_components/metisMenu/dist/metisMenu.min.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/sb-admin-2.js"></script>

</body>

</html>
