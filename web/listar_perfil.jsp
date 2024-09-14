
<%@page import="model.PerfilDAO"%>
<%@page import="model.Perfil"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<meta Charset="utf-8">	
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title> Loc System </title>
<link rel="shortcut icon" href="img/favicon.ico"/>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script language="JavaScript" src="https://code.jquery.com/jquery-1.11.1.min.js" type="text/javascript"></script>
<script language="JavaScript" src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js" type="text/javascript"></script>
<script language="JavaScript" src="https://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link href ="estilo/tabela.css" rel="stylesheet" type = "text/css"/>
<link href ="estilo/style.css" rel="stylesheet" type = "text/css"/>
<link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.css">



<body>
<%@include file="menu.jsp" %>
<%@include file="header.jsp" %>

<script>

    $(document).ready(function () {
        $('#datatable').dataTable();

        $("[data-toggle=tooltip]").tooltip();

    });


</script>

<script type =text/javascript>

    function confirmarExclusao(id, nome) {

        if (confirm('Deseja realmente excluir o perfil ' + nome + '?')) {
            location.href = 'gerenciar_perfil.do?acao=deletar&idPerfil=' + id;
        }
    }


</script>

<br><br><br><br><br>
<div class="container" id ="caixa">

    <div class="row"><br>
        <h2 class="text-center">LISTA DE PERFIS</h2>
    </div>

    <div>
        <a href ="cadastrar_perfil.jsp"><button type="button" class="btn-sm btn-primary btn-create" id="botao_form">+ Criar Novo Perfil</button></a>
    </div>
    <br><br><br>
    <div class="row">	
        <div class="col-md-12">     
            <table id="tabela" class="table table-striped table-bordered" cellspacing="0" width="100%"> 

                <thead>
                    <tr>
                        <th>#</th>
                        <th>Nome</th>
                        <th>Opções</th>
                    </tr>

                </thead>
                <jsp:useBean class="model.PerfilDAO" id ="pDAO"/>
                <tbody>
                    <c:forEach var ="p" items ="${pDAO.lista}">
                        <tr>
                            <td>${p.idPerfil}</td>
                            <td>${p.nome}</td>
                            <td>
                                <button class="btn-primary btn-xs" onclick="editarPerfil(${p.idPerfil})"><span class="glyphicon glyphicon-pencil"></span></button>
                                <button class="btn-danger btn-xs" onclick ="confirmarExclusao(${p.idPerfil}, '${p.nome}')"><span class="glyphicon glyphicon-trash" ></span></button>
                                <a class ="btn btn-default" href ="gerenciar_menu_perfil.do?acao=gerenciar&idPerfil=${p.idPerfil}">
                                    <i class ="glyphicon">Acessos</i>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script type="text/javascript">
    function editarPerfil(idPerfil) {
        var url = "gerenciar_perfil.do?acao=alterar&idPerfil=" + idPerfil;
        $.get(url, null, function (page) {
            var modal = $("#edit");
            modal.find('.modal-body').html(page);
            modal.modal('show');
        });
    }
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


<div class="modal fade" id="edit" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title custom_align" id="Heading">Editar Perfil</h4>
            </div>

            <div class="modal-body">

            </div>

            <!-- /.modal-content --> 
        </div>
        <!-- /.modal-dialog --> 
    </div>
</div><br><br>
 
</body>

