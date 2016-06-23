<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.utku.model.*"%>
<%@page import="com.utku.dao.*"%>
<%@page import="com.utku.service.*"%>
<%@page import="java.util.List" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>Ürün İşlemleri | E-Ticaret</title>
 	<%@ include file="headerAdmin.jsp"%> 
</head>

<body>
<%if(session.getAttribute("admin")==null){
	response.sendRedirect("admin");}%>

    <div id="wrapper">

        <%@ include file="navbarAdmin.jsp"%>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Ürün İşlemleri</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
								<a href="urunEkle" class="btn btn-small btn-success btn-block" style="width:10%;float:left;margin-bottom:5px;">Ürün Ekle</a>
                                    <thead>
                                        <tr>
                                            <th>Ürün Adı</th>
											<th>Resim</th>
                                            <th>Açıklama</th>
                                            <th>Kategori</th>
                                            <th>Fiyat</th>
											<th>Stok</th>  
											<th>İşlemler</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <%AltAltKategoriService akts = new AltAltKategoriService(); %>
                                    <%UrunService us = new UrunService(); %>
                                    
                                    <% List<Urun> urunler = us.findAll();%>
                					<% for(Urun urun: urunler){ %>
                                        <tr class="odd gradeX" >
                                            <td><%=urun.getAd() %></td>
<%--                                             <td style="height:100px;" ><img src="resimgetir?urunResim=<%=urun.getU_id()%>" alt="" style="height:100%;"/></td> --%>
                                            <td style="height:100px;" ><img src="${pageContext.request.contextPath}/images/product/<%=urun.getAd()%>.jpg" alt="" style="height:100%;"/></td>
                                            <td><%=urun.getAciklama()%></td>
                                            <td class="center"><%=akts.findById(urun.getAltaltkategoriId().getAltaltk_id()).getAd()%></td>
                                            <td class="center"><%=urun.getFiyat() %></td>
											<td class="center"><%=urun.getStok()%></td>
											<td><a href="urunSil?sil=<%=urun.getU_id()%>" name="sil" class="btn btn-small btn-danger btn-block" style="width:30%;float:left;">Sil</a><a href="urunGuncelle?guncelle=<%=urun.getU_id()%>" class="btn btn-small btn-primary btn-block" style="width:45%;float:left;margin-top:0px;margin-left:2px;">Güncelle</a></td>
                                        </tr>
									<%} %>
									
                                        
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.table-responsive -->
                            
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    
    <script src="${pageContext.request.contextPath}/bower_components/jquery/dist/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/bower_components/metisMenu/dist/metisMenu.min.js"></script>
    <script src="${pageContext.request.contextPath}/bower_components/datatables/media/js/jquery.dataTables.min.js"></script>
    <script src="${pageContext.request.contextPath}/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/sb-admin-2.js"></script>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
                responsive: true
        });
    });
    </script>

</body>

</html>
