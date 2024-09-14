

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8"/>
        <meta name ="viewport" content ="widht-device-width, initial-scale-2.0"/>
        <title>Administração</title>
        <link rel="shortcut icon" href="img/favicon.ico" />
        <link href ="estilo/style.css" rel="stylesheet" type = "text/css"/>
        <link href ="estilo/menu.css" rel="stylesheet" type = "text/css"/>
        <link href ="css/bootstrap.min.css" rel="stylesheet" type = "text/css"/>
        <script type ="text/javascript" src = "js/jquery-3.4.1.min"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script type ="text/javascript" src = "js/bootstrap.min.js"></script>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="css/font-awesome.css" rel="stylesheet" type="text/css">	

        <script src="https://use.fontawesome.com/07b0ce5d10.js"></script>

    </head>

    <body>

        <%@include file="menu.jsp" %>
        <%@include file="header.jsp" %>

        <br<br><br><br><br>
        
        <div class="container" id ="caixa">                                             
            <div class="row" >
                <div class="col-lg-2 col-sm-6">
                    <div class="circle-tile">
                        <a href="#">
                            <div class="circle-tile-heading purple">
                                <i class="fa fa-shopping-cart fa-fw fa-3x"></i>
                            </div>
                        </a>
                        <div class="circle-tile-content purple">
                            <div class="circle-tile-description text-faded">
                                Ordens Pendentes
                            </div>
                            <div class="circle-tile-number text-faded">
                                0
                                <span id="sparklineC"></span>
                            </div>
                            <a href="listar_ordem_servico_pendente.jsp" class="circle-tile-footer">Ver Informações <i class="fa fa-chevron-circle-right"></i></a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-2 col-sm-6">
                    <div class="circle-tile">
                        <a href="#">
                            <div class="circle-tile-heading dark-blue">
                                <i class="fa fa-shopping-cart fa-fw fa-3x"></i>
                            </div>
                        </a>
                        <div class="circle-tile-content dark-blue">
                            <div class="circle-tile-description text-faded">
                                Ordens Finalizadas
                            </div>
                            <div class="circle-tile-number text-faded">
                                0
                                <span id="sparklineC"></span>
                            </div>
                            <a href="listar_ordem_servico_finalizada.jsp" class="circle-tile-footer">Ver Informações <i class="fa fa-chevron-circle-right"></i></a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-2 col-sm-6">
                    <div class="circle-tile">
                        <a href="#">
                            <div class="circle-tile-heading orange">
                                <i class="fa fa-bell fa-fw fa-3x"></i>
                            </div>
                        </a>
                        <div class="circle-tile-content orange">
                            <div class="circle-tile-description text-faded">
                                Locações <br> 
                                Feitas
                            </div>
                            <div class="circle-tile-number text-faded">
                                0
                            </div>
                            <a href="listar_locacao.jsp" class="circle-tile-footer">Ver Informações <i class="fa fa-chevron-circle-right"></i></a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-2 col-sm-6">
                    <div class="circle-tile">
                        <a href="#">
                            <div class="circle-tile-heading blue">
                                <i class="fa fa-tasks fa-fw fa-3x"></i>
                            </div>
                        </a>
                        <div class="circle-tile-content blue">
                            <div class="circle-tile-description text-faded">
                                Trocas <br>
                                Feitas
                            </div>
                            <div class="circle-tile-number text-faded">
                                0
                                <span id="sparklineB"></span>
                            </div>
                            <a href="listar_troca.jsp" class="circle-tile-footer">Ver Informações <i class="fa fa-chevron-circle-right"></i></a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-2 col-sm-6">
                    <div class="circle-tile">
                        <a href="#">
                            <div class="circle-tile-heading red">
                                <i class="fa fa-shopping-cart fa-fw fa-3x"></i>
                            </div>
                        </a>
                        <div class="circle-tile-content red">
                            <div class="circle-tile-description text-faded">
                                Retiradas <br>
                                Feitas
                            </div>
                            <div class="circle-tile-number text-faded">
                                0
                                <span id="sparklineC"></span>
                            </div>
                            <a href="listar_retirada.jsp" class="circle-tile-footer">Ver Informações <i class="fa fa-chevron-circle-right"></i></a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-2 col-sm-6">
                    <div class="circle-tile">
                        <a href="#">
                            <div class="circle-tile-heading purple">
                                <i class="fa fa-comments fa-fw fa-3x"></i>
                            </div>
                        </a>
                        <div class="circle-tile-content purple">
                            <div class="circle-tile-description text-faded">
                                Clientes Cadastrados
                            </div>
                            <div class="circle-tile-number text-faded">
                                0
                                <span id="sparklineD"></span>
                            </div>
                            <a href="listar_cliente.jsp" class="circle-tile-footer">Ver Informações <i class="fa fa-chevron-circle-right"></i></a>
                        </div>
                    </div>
                </div>
            </div>



        </div><!-- page-wrapper END-->
    </div><!-- container-1 END-->

<div class="container" id ="caixa">
    <h2 align="center">Sejam Bem-Vindos</h2>
    <br>
    <h5>A empresa foi criada em 08 de março de 2019, com o CNPJ 32.966.274/0001-26 e no ramo de locações de caçambas de entulho. Ela veio com os fins de suprir às necessidades do mercado em locações de equipamentos para construção civil, principalmente para caçambas de entulho, visando à qualidade, atendimento, comprometimento e preço ao cliente. Atualmente esta localizada no endereço SHIS QI 15 Bloco A sobreloja 47.
	 Os responsáveis pela empresa 	são Hudson Araújo de Sa Teles Rodrigues e Anderson Araújo de Sa Teles Rodrigues. Sua missão oferecer serviços com diferenciais, que agreguem valor aos clientes, ajudando-os a prosperar em seus ramos de negócios: industrial e civil no mercado nacional.
    </h5>
      </div>
    


</body>



</html>
