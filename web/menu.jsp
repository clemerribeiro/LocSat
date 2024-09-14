<%@page import="model.Usuario"%>
<%@page import="controller.GerenciarLogin"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    Usuario ulogado = GerenciarLogin.verificarAcesso(request, response);
    request.setAttribute("ulogado", ulogado);

%>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

<!------ Include the above in your HEAD tag ---------->
<link href ="estilo/menu.css" rel="stylesheet" type = "text/css"/>


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/css/bootstrap.min.css" integrity="sha384-y3tfxAZXuh4HwSYylfB+J125MxIs6mR5FOHamPBG064zB+AFeWH94NdvaCBm8qnd" crossorigin="anonymous">
    <!-- font awesome -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-T8Gy5hrqNKT+hzMclPo118YTQO6cYprQmhrYwIiQ/3axmI1hQomh7Ud2hPOy8SP1" crossorigin="anonymous">

<div class="container">
    <div class="row">
        <div id="wrapper">
            <div class="overlay"></div>
            <script>

                $(document).ready(function () {
                    var trigger = $('.hamburger'),
                            overlay = $('.overlay'),
                            isClosed = false;

                    trigger.click(function () {
                        hamburger_cross();
                    });

                    function hamburger_cross() {

                        if (isClosed == true) {
                            overlay.hide();
                            trigger.removeClass('is-open');
                            trigger.addClass('is-closed');
                            isClosed = false;
                        } else {
                            overlay.show();
                            trigger.removeClass('is-closed');
                            trigger.addClass('is-open');
                            isClosed = true;
                        }
                    }

                    $('[data-toggle="offcanvas"]').click(function () {
                        $('#wrapper').toggleClass('toggled');
                    });
                });
            </script>
            <!-- Sidebar -->
            
            <nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
                <ul class="nav sidebar-nav">
                    <li class="sidebar-brand">
                        <a href = "index.php">
                            <img src="img/logolocsat.png" height="50px" align ="">
                        </a>
                    </li>
                    <br>
                    <c:if test="${ulogado!=null && ulogado.perfil!=null}">
                        <c:forEach var ="menu" items="${ulogado.perfil.menus}">
                            <c:if test="${menu.exibir==1}">
                                <li>
                                    <a href="${menu.link}">
                                        <img src="img/logolocsat.png" height="30px" align ="center">${menu.nome}
                                    </a>
                                 </li>
                            </c:if>
                        </c:forEach>
                    </c:if>
                </ul>
            </nav>
            <!-- /#sidebar-wrapper -->

            <!-- Page Content -->
            <div id="page-content-wrapper">
                <button type="button" class="hamburger is-closed" data-toggle="offcanvas">
                    <span class="hamb-top"></span>
                    <span class="hamb-middle"></span>
                    <span class="hamb-bottom"></span>
                </button>



                <div class="container">

                    <div class="row">

                    </div>
                </div>
            </div>
            <!-- /#page-content-wrapper -->

        </div>
    </div>
</div>
