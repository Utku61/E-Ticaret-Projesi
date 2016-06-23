<%@page import="com.utku.model.*"%>
<%@page import="com.utku.dao.*"%>
<%@page import="com.utku.service.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@page import="java.util.List" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>Müşteri İşlemleri | E-Ticaret</title>
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
                    <h1 class="page-header">Müşteri İşlemleri</h1>
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
								
                                    <thead>
                                        <tr>
                                            <th>İsim</th>
											<th>Mail</th>
                                            <th>Şifre</th>                                            
											<th>İşlemler</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <%MusteriService ms = new MusteriService(); %>
                                    <% List<Musteri> musteriler = ms.findAll();%>
                					<% for(Musteri musteri: musteriler){ %>
                                        <tr class="odd gradeX">
                                            <td><%=musteri.getIsim() %></td>
                                            
                                            <td><%=musteri.getMail()%></td>
                                            <td class="center"><%=musteri.getSifre()%></td>
                                           
											<td><a href="musteriSil?sil=<%=musteri.getM_id()%>" name="sil" class="btn btn-small btn-danger btn-block" style="width:30%;float:left;">Sil</a></td>
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
