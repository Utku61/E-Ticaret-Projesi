
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="com.utku.dao.*" %>
<%@page import="com.utku.model.*" %>
<%@page import="com.utku.service.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="header.jsp"%>
         
   
</head><!--/head-->

<body>
	<%ArrayList<Urun> cart2 = new ArrayList<Urun>(); %>
	<%request.getSession().setAttribute("cart", cart2);%>
	<%@ include file="navbar.jsp"%>
	
	<section>
		<div class="container">
			<div class="row">
				<%-- <div class="col-sm-3">
					<div class="left-sidebar">
						<h2>Kategoriler</h2>
						<div class="panel-group category-products" id="accordian"><!--category-products-->
							<% ArrayList<Kategori> kategoriler=KategoriDAO.tumKatagoriler();%>							
							<%for(Kategori kategori:kategoriler) { %>
								<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="<%=kategori.getKategoriAdı()%>"><%=kategori.getKategoriAdı()%></a></h4>
								</div>
								</div>
							<%} %>
																																			
						</div>
																					
						<div class="shipping text-center"><!--shipping-->
							<img src="${pageContext.request.contextPath}/images/home/shipping.jpg" alt="" />
						</div><!--/shipping-->					
					</div>
				</div>																
						 --%>																	
				<div class="col-sm-9 padding-right">
					<div class="features_items"><!--features_items-->
						<h2 class="title text-center"></h2>
						<h2>Siparişiniz Alınmıştır.</h2>
						</br>
						</br>
						</br>
						</br>
						</br>
						</br>
						</br>
						</br>
						</br>
									
					</div>																																					
				</div>
			</div>
		</div>
	</section>
	
	
	<%@ include file="footer.jsp"%>

  
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.scrollUp.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/price-range.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.prettyPhoto.js"></script>
    <script src="${pageContext.request.contextPath}/js/main.js"></script>
</body>
</html>