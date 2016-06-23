<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="com.utku.model.*" %>
    <%@page import="java.util.ArrayList" %>
     <%@page import="java.util.List" %>
    
	<%@page import="com.utku.dao.*"%>
	<%@page import="com.utku.service.*" %>
<!DOCTYPE html>
<html lang="en">

<head>

   <%@ include file="headerAdmin.jsp"%>
   
</head>

<body>
	<%@ include file="navbarAdmin.jsp"%>
    <div id="wrapper">
<%if(session.getAttribute("admin")==null){
	response.sendRedirect("admin");}%>
        

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Welcome Mr.MALKOÇOĞLU</h1>
                </div>               
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-shopping-cart fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <%SiparisService sp=new SiparisService(); %>
                                    <div class="huge"><%=sp.findAll().size()%></div>
                                    <div>Yeni Sipariş!</div>
                                </div>
                            </div>
                        </div>
                        <a href="siparisAdmin">
                            <div class="panel-footer">
                                <span class="pull-left">Detaylara Git</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>                
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-8">
                    <div class="panel panel-default">
                        
                    <div class="chat-panel panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-comments fa-fw"></i>
                            İletişimden Gelenler                           
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <ul class="chat">
                                <li class="left clearfix">                                                                
                                    <div class="chat-body clearfix">
                                    <%IletisimService iletisimService = new IletisimService(); %>
                                    <% List<Iletisim> iletisimlist = iletisimService.findAll();%>
                						<% for(Iletisim iletisim: iletisimlist){ %>  
                                        <div class="header">                                        
                                            <strong class="primary-font"><%=iletisim.getIsim()%>----<%=iletisim.getKonu()%></strong>
                                            <small class="pull-right text-muted">                                             
                                            </small>
                                        </div>
                                        <p>
                                            <%=iletisim.getMesaj()%>
                                        </p>
                                        <%} %>	
                                    </div>
                                    															
                                </li>                                                                                  
                            </ul>
                        </div>
                        <!-- /.panel-body -->                    
                        <!-- /.panel-footer -->
                    </div>
                    <!-- /.panel .chat-panel -->
                </div>
                <!-- /.col-lg-4 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
    </div>

   <script src="${pageContext.request.contextPath}/bower_components/jquery/dist/jquery.min.js"></script>
<script>
$(document).ready(function(){
	console.log("Ajax Çalıştı");
	window.setInterval(function(){
		$.post( "sayigetir", function( data ) {
			if(data != ""){
			  //console.log("Sayı : " + data);
			  $(".huge").html(data);
			}
			});
		}, 1000);
})
</script>
    <script src="${pageContext.request.contextPath}/bower_components/jquery/dist/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/bower_components/raphael/raphael-min.js"></script>
    <script src="${pageContext.request.contextPath}/bower_components/morrisjs/morris.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/morris-data.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/sb-admin-2.js"></script>

</body>

</html>

