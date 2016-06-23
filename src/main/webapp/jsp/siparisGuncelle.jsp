<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="com.utku.service.*" %>
    <%@page import="com.utku.model.*" %>
<!DOCTYPE html>
<html lang="tr">

<head>
    <title>Ürün Güncelle | E-Ticaret</title>
   <%@ include file="headerAdmin.jsp"%> 
</head>

<body>
<%if(session.getAttribute("admin")==null){
	response.sendRedirect("admin");}%>
<%int id=Integer.parseInt(request.getParameter("siparisId")); %>
<%SiparisService ss = new SiparisService(); %>
<%Siparis siparis = new Siparis(); %>
<%siparis = ss.findById(id); %>
<%UrunService us = new UrunService(); %>
<%Urun urun = new Urun(); %>
<%urun = us.findById(siparis.getUrunId().getU_id()); %>

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Sipariş Bilgileri Güncelleyin</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form" method="post" action="SiparissGuncelle?siparisId=<%=siparis.getId()%>" >
                            <fieldset>                                
								<div class="form-group">Sipariş tarihi:
                                    <input class="form-control" placeholder="Sipariş Tarihi" name="siparisTarih" type="text" autofocus value="<%=siparis.getTarih()%>">
                                </div>
								<div class="form-group">Ürün Adet:
                                   <input class="form-control" placeholder="Urun Adeti" name="urunAdet" type="text" autofocus value="<%=siparis.getAdet()%>">
                                </div>
                                <div class="form-group">Sipariş Durumu:                                  
									<select class="form-control" name="siparisDurumu">
										<option value="Siparisiniz Hazirlaniyor..">Siparisiniz Hazirlaniyor..</option>
										<option value="Siparisiniz Kargoya Verildi..">Siparisiniz Kargoya Verildi..</option>
										<option value="Siparis Tamamlandi !">Siparis Tamamlandi !</option>
									</select>
                                </div>
                                
                                <!-- Change this to a button or input when using this as a form -->
                                <button type="submit" class="btn btn-lg btn-primary btn-block">Siparis Güncelle</button>
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
