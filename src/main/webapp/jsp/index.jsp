
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.utku.model.*"%>
<%@page import="com.utku.dao.*"%>
<%@page import="com.utku.service.*"%>
<!DOCTYPE html>
<html lang="tr">
<head>
<%@ include file="header.jsp"%>

</head>

<body>

	<%@ include file="navbar.jsp"%>

	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-3">
					<div class="left-sidebar">
						<h2></h2>
						</br>
						</br>
						</br>
						</br>
						</br>
						</br>
						</br>
						</br>
						</br>
						</br>
						</br>
<!-- 						<h2>Kategoriler</h2> -->
<!-- 						<div class="panel-group category-products" id="accordian"> -->
<%-- 							<%KategoriService kse=new KategoriService(); %> --%>
<%-- 							<% List<Kategori> kategoriler=kse.findAll();%> --%>
<%-- 							<%for(Kategori kategori:kategoriler) { %> --%>
<!-- 							<div class="panel panel-default"> -->
<!-- 								<div class="panel-heading"> -->
<!-- 									<h4 class="panel-title"> -->
<%-- 										<a href="<%=kategori.getAdi()%>"><%=kategori.getAdi()%></a> --%>
<!-- 									</h4> -->
<!-- 								</div> -->
<!-- 							</div> -->
<%-- 							<%} %> --%>
<!-- 						</div> -->


						<div class="shipping text-center">
							<img
								src="${pageContext.request.contextPath}/images/home/shipping.jpg"
								alt="" />
						</div>

					</div>
				</div>



				<%-- <div class="recommended_items">
						<h2 class="title text-center">ÇOK SATILANLAR</h2>
						
						<div id="recommended-item-carousel" class="carousel slide" data-ride="carousel">
							<div class="carousel-inner">
								
								<div class="item active">
								<% ArrayList<Urun> coksatilanlar = UrunDAO.cokSatilanGetir();%>
                				<% for(Urun urun: coksatilanlar){ %>
								<div class="col-sm-4">
										<div class="product-image-wrapper">
											<div class="single-products">
												<div class="productinfo text-center">
													<img src="resimgetir?urunResim=<%=urun.getUrunId()%>" alt=""/>
													<h2><%=urun.getUrunFiyat()%> TL</h2>
													<p><%=urun.getUrunAd()%></p>
													<a href="sepetekle?urunID=<%=urun.getUrunId()%>" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Sepete Ekle</a>
												</div>
												
											</div>
										</div>
									</div>
								
									<%} %>
								</div>	
								
								<div class="item" >
								<% ArrayList<Urun> coksatilanlar2 = UrunDAO.cokSatilanGetir();%>
                				<% for(Urun urun: coksatilanlar2){ %>
								<div class="col-sm-4">
										<div class="product-image-wrapper">
											<div class="single-products">
												<div class="productinfo text-center">
													<img src="resimgetir?urunResim=<%=urun.getUrunId()%>" alt=""/>
													<h2><%=urun.getUrunFiyat()%> TL</h2>
													<p><%=urun.getUrunAd()%></p>
													<a href="sepetekle?urunID=<%=urun.getUrunId()%>" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Sepete Ekle</a>
												</div>
												
											</div>
										</div>
									</div>
								
									<%} %>
								
								
								</div>
							</div>
							 <a class="left recommended-item-control" href="#recommended-item-carousel" data-slide="prev">
								<i class="fa fa-angle-left"></i>
							  </a>
							  <a class="right recommended-item-control" href="#recommended-item-carousel" data-slide="next">
								<i class="fa fa-angle-right"></i>
							  </a>			
						</div>
					</div> --%>


				<div class="col-sm-9 padding-right">
					<div class="features_items">
						
						<h2 class="title text-center">ÜRÜNLER</h2>
						<% UrunService us = new UrunService(); %>
						<% List<Urun> urunler = us.findAll(); %>
						<% for(Urun urun: urunler){ %>
						<div class="col-sm-4">
							<div class="product-image-wrapper"><a href="urunDetay?id=<%=urun.getU_id()%>">
								<div class="single-products">
									<div class="productinfo text-center">
										<img src="${pageContext.request.contextPath}/images/product/<%=urun.getAd()%>.jpg" alt=""
											style="height: 237px;" />
										<h2><%=urun.getFiyat()%>
											TL
										</h2>
										<p><%=urun.getAd()%></p>
										<a href="sepetekle?urunID=<%=urun.getU_id()%>"
											class="btn btn-default add-to-cart"><i
											class="fa fa-shopping-cart"></i>Sepete Ekle</a>
									</div>
								</div>
							</div></a>
						</div>
						<%} %>
					</div>
				</div>
			</div>
		</div>
	</section>


	<%@ include file="footer.jsp"%>

	<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/jquery.scrollUp.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/price-range.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/jquery.prettyPhoto.js"></script>
	<script src="${pageContext.request.contextPath}/js/main.js"></script>







</body>
</html>