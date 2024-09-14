

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8"/>
    <meta name ="viewport" content ="widht-device-width, initial-scale-2.0"/>
    <title>Loc System</title>
    <link rel="shortcut icon" href="img/favicon.ico" />
    <link href ="estilo/style.css" rel="stylesheet" type = "text/css"/>
    <link href ="estilo/menu.css" rel="stylesheet" type = "text/css"/>
    <link href ="estilo/tabela.css" rel="stylesheet" type = "text/css"/>
    <link href ="css/bootstrap.min.css" rel="stylesheet" type = "text/css"/>
    <script type ="text/javascript" src = "js/jquery-3.4.1.min"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script type ="text/javascript" src = "js/bootstrap.min.js"></script>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <script language="JavaScript" src="https://code.jquery.com/jquery-1.11.1.min.js" type="text/javascript"></script>
    <script language="JavaScript" src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js" type="text/javascript"></script>
    <script language="JavaScript" src="https://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.css">


</head>

<body>

    <%@include file="menu.jsp" %>
    <%@include file="header.jsp" %>

    <br><br><br><br>
    <div class="container" id ="caixa">	

        <div class="row"><br>
            <h2 class="text-center">GERENCIAR PERFIL</h2>
        </div>
        <br>
        <form action ="gerenciar_menu_perfil.do" method ="POST" >
            <div id ="input">

                <div class="form-group">
                    <input type ="hidden" name ="idPerfil" value ="${perfilv.idPerfil}"/>

                    <label for="inputEmail4">${perfilv.nome}</label>

                </div>

                <div class="form-group">    
                    <br>
                    <label for="menu">Menus</label> 
                    <select id="inputState" class="form-control col-md-4" name ="idmenu"required>
                        <option value=""selected>Selecione o Menu</option>
                        <c:forEach var ="m" items ="${perfilv.naoMenus}">
                            <option value ="${m.idmenu}">${m.nome}</option>
                        </c:forEach>

                    </select>
                </div>

                <br><br>
                <div>
                    <button type="submit" class="btn-sm btn-primary btn-create" id="botao_enviar">Vincular Menu</button>
                    <a href="listar_perfil.jsp" class="btn-sm btn-primary btn-create" id="botao_enviar_a">Voltar</a>
                </div>

            </div>
        </form>


        <script>

            $(document).ready(function () {
                $('#datatable').dataTable();

                $("[data-toggle=tooltip]").tooltip();

            });


        </script>

        <script type =text/javascript>

            function Desvincular(idmenu, nome, idPerfil) {

                if (confirm('Deseja realmente desvincular o menu ' + nome + '?')) {
                    location.href = 'gerenciar_menu_perfil.do?acao=desvincular&idmenu=' + idmenu + '&idPerfil=' + idPerfil;
                }
            }


        </script>




        <br><br><br>
        <div class="row">	
            <div class="col-md-12">     
                <table id="tabela" class="table table-striped table-bordered" cellspacing="0" width="100%"> 

                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Nome</th>
                            <th>Link</th>
                            <th>Icone</th>
                            <th>Exibir</th>
                            <th>Desvincular</th>
                        </tr>

                    </thead>

                    <tbody>
                        <c:forEach var ="m" items ="${perfilv.menus}">
                            <tr>
                                <td>${m.idmenu}</td>
                                <td>${m.nome}</td>
                                <td>${m.link}</td>
                                <td>${m.icone}</td>
                                <td>
                                    <c:if test="${m.exibir==1}">
                                        Sim
                                    </c:if>

                                    <c:if test="${m.exibir==2}">
                                        Não
                                    </c:if>
                                <td>

                                    <button type="button" class="btn-danger btn-xs" onclick ="Desvincular(${m.idmenu}, '${m.nome}', ${perfilv.idPerfil})"><span class="glyphicon glyphicon-remove" ></span></button>
                                        
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <script type="text/javascript">

        $(document).ready(function () {
            $("#tabela").dataTable({
                "bjQueryUI": true,
                "oLanguage": {
                    "sProcessing": "Processando...",
                    "sLengthMenu": "Mostrar _MENU_ registros",
                    "sZeroRecords": "Não foram encontrados resultados",
                    "sInfo": "Mostrar de _START_ ate _END_ de _TOTAL_ registros",
                    "sInfoEmpty": "Mostrando de 0 até 0 de 0",
                    "sInfoFiltered": "",
                    "sInfoPostFix": "",
                    "sSearch": "Pesquisar",
                    "sUrl": "",
                    "oPaginate": {
                        "sFirst": "Primeiro",
                        "sPrevious": "Anterior",
                        "sNext": "Próximo",
                        "sLast": "Ultimo"
                    }
                }
            })

        })
    </script>                                


    <br><br>


</body>



</html>
