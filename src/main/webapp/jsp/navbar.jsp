
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.utku.dao.*"%>
	<%@page import="com.utku.service.*" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@page import="com.utku.model.*" %>
<header id="header">
<%
Musteri musteri = (Musteri)session.getAttribute("musteri");

%>
		<div class="header_top">
			<div class="container">
				<div class="row">
					<div class="col-sm-6">
						<div class="contactinfo">
							<ul class="nav nav-pills">
								<li><a href="#"><i class="fa fa-phone"></i> 0554 738 19 64</a></li>
								<li><a href="#"><i class="fa fa-envelope"></i> utku.malkocoglu@bil.omu.edu.tr</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="social-icons pull-right">
							<ul class="nav navbar-nav">
								<li><a href="#"><i class="fa fa-facebook"></i></a></li>
								<li><a href="#"><i class="fa fa-twitter"></i></a></li>
								<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
								<li><a href="#"><i class="fa fa-dribbble"></i></a></li>
								<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header_top-->
		
		<div class="header-middle">
			<div class="container">
				<div class="row">
					<div class="col-sm-4">
						<div class="logo pull-left">
							<a href="index"><img src="${pageContext.request.contextPath}/images/home/logo.png" alt="" /></a>
						</div>					
					</div>
					<div class="col-sm-8">
						<div class="shop-menu pull-right">
							<ul class="nav navbar-nav">
								<li><a href="cart"><i class="fa fa-shopping-cart"></i> Sepet</a></li>
								
								<%
								if(session.getAttribute("musteri") != null){
									Musteri m=(Musteri)session.getAttribute("musteri");
									if(m.getIsim()!=null){
									%>
									  <li class="dropdown"><a href="login"><%=musteri.getIsim()%><i class="fa fa-angle-down"></i></a>
                                      <ul role="menu" class="sub-menu">
                                        <li><a method="post" href="cikis" style="background-color: #696763;">Çıkış</a></li>
                                      </ul>
                                      </li>
									<%}else{%>
										<li><a href="login"><i class="fa fa-lock"></i> Giriş</a></li><%
									}
								}
								else{%>
									<li><a href="login"><i class="fa fa-lock"></i> Giriş</a></li><%
								}%>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-middle-->
	
		<div class="header-bottom">
			<div class="container">
				<div class="row">
					<div class="col-sm-9">
						<!-- <div class="mainmenu pull-left">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<li><a href="index" class="active">Anasayfa</a></li>
								<%KategoriService ks=new KategoriService(); %>
								<% List<Kategori> kategoriler2=ks.findAll();%>							
							    <%for(Kategori kategori:kategoriler2) { %>
							          <li ><a href="<%=kategori.getAdi()%>"><%=kategori.getAdi()%></a></li>
							    <%} %>
								
								<li><a href="contact">İletişim</a></li>
							</ul>
						</div>-->
						
						<div class="btn-group">
						    <a href="index"><button type="button"  href="index" class="btn btn-default dropdown-toggle">Anasayfa</button></a>
						</div>
<%-- 						<%KategoriService ks2=new KategoriService(); %> --%>
<%-- 								<% List<Kategori> kategoriler3=ks2.findAll();%>							 --%>
<%-- 							    <%for(Kategori kategori:kategoriler3) { %> --%>
<!-- 							    	<div class="btn-group"> -->
<%-- 									    <a href="<%=kategori.getAdi()%>"><button type="button"  class="btn btn-default dropdown-toggle"><%=kategori.getAdi()%></button></a> --%>
<!-- 									</div> -->
							          
<%-- 							    <%} %> --%>
						
						
						<div class="btn-group">
						    <button type="button" data-toggle="dropdown" class="btn btn-default dropdown-toggle">Erkek<span class="caret"></span></button>
						    <ul class="dropdown-menu">
						        <li><a href="ErkekUstGiyim">Üst Giyim</a></li>
						        <li style="margin-left:2em;"><a href="ErkekTshirt">T-Shirt</a></li>
						        <li style="margin-left:2em;"><a href="ErkekCeket">Ceket</a></li>
						        <li style="margin-left:2em;"><a href="ErkekKazak">Kazak</a></li>
						        <li><a href="ErkekAltGiyim">Alt Giyim</a></li>
						        <li style="margin-left:2em;"><a href="ErkekJean">Jean</a></li>
						        <li style="margin-left:2em;"><a href="ErkekEsortman">Eşortman</a></li>
						    </ul>
						</div>
						
						<div class="btn-group">
						    <button type="button" data-toggle="dropdown" class="btn btn-default dropdown-toggle">Bayan<span class="caret"></span></button>
						    <ul class="dropdown-menu">
						        <li><a href="BayanUstGiyim">Üst Giyim</a></li>
						        <li style="margin-left:2em;"><a href="BayanMont">Mont</a></li>
						        <li style="margin-left:2em;"><a href="BayanBluz">Bluz</a></li>
						        <li style="margin-left:2em;"><a href="BayanElbise">Elbise</a></li>
						        <li style="color:blue;"><a href="BayanAltGiyim">Alt Giyim</a></li>
						        <li style="margin-left:2em;"><a href="BayanJean">Jean</a></li>
						        <li style="margin-left:2em;"><a href="BayanEtek">Etek</a></li>
						        
						    </ul>
						</div>
						
						<div class="btn-group">
						    <a href="contact"><button type="button"  class="btn btn-default dropdown-toggle">İletişim</button></a>
						</div>
												
					</div>
					<div class="col-sm-3">
						<div class="search_box pull-right">
							<input type="text" placeholder="Search"/>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>