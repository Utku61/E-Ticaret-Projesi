 <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="indexAdmin">E-Ticaret Yönetim Paneli</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">                                                                                     
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> Utku Malkoçoğlu <i class="fa fa-caret-down"></i>
                        
                    </a>
                    <ul class="dropdown-menu dropdown-user">                       
                        <li><a href="adminCikis"><i class="fa fa-sign-out fa-fw"></i> Çıkış Yap</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                            </div>
                            <!-- /input-group -->
                        </li>
                        <li>
                            <a href="indexAdmin"><i class="fa fa-dashboard fa-fw"></i> Anasayfa</a>
                        </li>
                        <li>
                            <a href="urunAdmin"><i class="fa fa-bar-chart-o fa-fw"></i> Ürün İşlemleri</a>                                            
                        </li>
                        <li>
                            <a href="adminMusteri"><i class="fa fa-lock"></i> Müşteri İşlemleri</a>
                        </li>
                        <li>
                            <a href="siparisAdmin"><i class="fa fa-credit-card"></i> Siparişler</a>
                        </li>                   
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>