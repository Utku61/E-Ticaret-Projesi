<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.utku.model.*"%>
<%@page import="com.utku.dao.*"%>
<%@page import="com.utku.service.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
		<title>Giriş | E-Ticaret</title>
        <%@ include file="header.jsp"%>
    	
</head><!--/head-->

<body>
	
	<%@ include file="navbar.jsp"%>
	
	<section id="form"><!--form-->
		<div class="container">
			<div class="row">
				<div class="col-sm-4 col-sm-offset-1">
					<div class="login-form"><!--login form-->
						<h2>Hesabına Giriş yap</h2>
						<form role="form" method="post" action="musterilogin">							
							<input name="mail" type="email" placeholder="Mail Adresi" />
							<input name="sifre" type="password" placeholder="Şifre" />
							<span>
								<input type="checkbox" class="checkbox"> 
								Beni hatırla
							</span>
							<button type="submit" class="btn btn-default">Giriş</button>
						</form>
					</div><!--/login form-->
				</div>
				<div class="col-sm-1">
					<h2 class="or">Veya</h2>
				</div>
				<div class="col-sm-4">
					<div class="signup-form"><!--sign up form-->
						<h2>Üye değil misin? Hemen Kayıt Ol</h2>
						<form action="musterikayit">
							<input name="adSoyad" type="text" placeholder="Ad Soyad"/>
							<input name="ePosta" type="email" placeholder="Mail Adresi"/>
							<input name="password" type="password" placeholder="Şifre"/>
							<button type="submit" class="btn btn-default">Kaydol</button>
						</form>
					</div><!--/sign up form-->
				</div>
			</div>
		</div>
	</section><!--/form-->
	
	<%@ include file="footer.jsp"%>
	<%
	if(request.getAttribute("status")!=null){
		out.print("<script>alert(" + request.getAttribute("status")+ ")</script>");
	}
	%>

  
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.scrollUp.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/price-range.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.prettyPhoto.js"></script>
    <script src="${pageContext.request.contextPath}/js/main.js"></script>
</body>
</html>