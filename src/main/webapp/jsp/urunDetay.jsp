
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
	</br>
	</br>

	<section>
		<div class="container">
			<div class="row">
				<%int id = Integer.parseInt(request.getParameter("id"));%>
				<%UrunService us = new UrunService(); %>
				<%Urun urun = us.findById(id);%>
				<div class="col-sm-9 padding-right">
					<div class="product-details">
						<!--product-details-->
						<div class="col-sm-5">
							<div class="view-product">
								<img
									src="${pageContext.request.contextPath}/images/product/<%=urun.getAd()%>.jpg"
									alt="" />

							</div>


						</div>
						<div class="col-sm-7">
							<div class="product-information">
								<!--/product-information-->
								
								<h2><%=urun.getAd()%></h2>
								
								<span> <span><%=urun.getFiyat()%> TL</span> <a
									href="sepetekle?urunID=<%=urun.getU_id()%>"
									class="btn btn-default add-to-cart"><i
										class="fa fa-shopping-cart"></i>Sepete Ekle</a>
								</span>
								<p>
									<b>Açıklama:</b>
									<%=urun.getAciklama()%>
								</p>
								<p>
									<b>Stok:</b>
									<%=urun.getStok()%>
									
								</p>
								</br> </br> </br> </br> </br> </br> <a href=""><img
									src="${pageContext.request.contextPath}/images/product-details/share.png"
									class="share img-responsive" alt="" /></a>
							</div>
							<!--/product-information-->
						</div>
					</div>
					<!--/product-details-->





				</div>
			</div>
		</div>
	</section>

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