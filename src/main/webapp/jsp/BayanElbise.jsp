
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
<title>Bayan Elbise | E-Ticaret</title>

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



						<div class="shipping text-center">
							<img
								src="${pageContext.request.contextPath}/images/home/shipping.jpg"
								alt="" />
						</div>

					</div>
				</div>



			


				<div class="col-sm-9 padding-right">
					<div class="features_items">
						
						<h2 class="title text-center">Bayan Elbise</h2>
						<%UrunService us = new UrunService(); %>
						<% List<Urun> urunler = us.bayanElbiseGetir();%>
						<% for(Urun urun: urunler){ %>
						<div class="col-sm-4">
							<div class="product-image-wrapper">
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
							</div>
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