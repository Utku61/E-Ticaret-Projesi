<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.utku.model.*" %>
<%@page import="com.utku.dao.*" %>
<%@page import="com.utku.service.*" %>
<%@page import="java.util.ArrayList" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    
    <title>Sepetim | E-Ticaret</title>
    <%@ include file="header.jsp"%>
         
  
</head>
<body>

	<%@ include file="navbar.jsp"%>

	<section id="cart_items">
		<div class="container">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
				  <li><a href="#">Home</a></li>
				  <li class="active">Sepetim</li>
				</ol>
			</div>
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Ürün</td>
							<td class="description">Açıklama</td>
							<td class="price">Fiyat</td>														
							<td></td>
						</tr>
					</thead>
					<tbody>
					<%if(session.getAttribute("cart")!=null){%>
						<%ArrayList<Urun> urun=(ArrayList<Urun>)session.getAttribute("cart");%>
						<%int i=0;%>
						<%int toplam=0;%>
						<%for(Urun urun2:urun) { %>
						<%toplam+=urun2.getFiyat();%>						
						<tr>
							<td class="cart_product" style="height:100%;">
<%-- 								<a href=""><img src="resimgetir?urunResim=<%=urun2.getU_id()%>" alt="" style="height:100px;"/></a> --%>
									<a href=""><img src="${pageContext.request.contextPath}/images/product/<%=urun2.getAd()%>.jpg" alt="" style="height:100px;"/></a>
							</td>
							<td class="cart_description">
								<h4><a href=""><%=urun2.getAd()%></a></h4>
								<p><%=urun2.getAciklama()%></p>
							</td>
							<td class="cart_price">
								<p><%=urun2.getFiyat()%> TL</p>
							</td>														
							<td class="cart_delete">
								<a class="cart_quantity_delete" href="sepettencikar?urunid=<%=i%>"><i class="fa fa-times"></i></a>
							</td>
						</tr>
							<%i++;
							}
						}%>						
						
					</tbody>
				</table>   
				             
			</div>
		</div>
		
	</section> <!--/#cart_items-->
	
	<div style="padding-left:1300px">
	
	<a  class="btn btn-default check_out" href="siparisTamamla">Satın Al</a>
	</div><br><br><br><br>
	
	
	<%@ include file="footer.jsp"%>
	

    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.scrollUp.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/price-range.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.prettyPhoto.js"></script>
    <script src="${pageContext.request.contextPath}/js/main.js"></script>
</body>
</html>