
<%@page import="model.ClienteDAO"%>
<%@page import="model.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<meta Charset="utf-8">	
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title> Loc System</title>
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
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

<!------ Include the above in your HEAD tag ---------->
<link href ="estilo/menu.css" rel="stylesheet" type = "text/css"/>


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/css/bootstrap.min.css" integrity="sha384-y3tfxAZXuh4HwSYylfB+J125MxIs6mR5FOHamPBG064zB+AFeWH94NdvaCBm8qnd" crossorigin="anonymous">
    <!-- font awesome -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-T8Gy5hrqNKT+hzMclPo118YTQO6cYprQmhrYwIiQ/3axmI1hQomh7Ud2hPOy8SP1" crossorigin="anonymous">



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

        if (confirm('Deseja realmente excluir o cliente ' + nome + '?')) {
            location.href = 'gerenciar_cliente.do?acao=deletar&id_cliente=' + id;
        }
    }


</script>

<br><br><br><br><br>
<div class="container" id ="caixa">

    <div class="row"><br>
        <h2 class="text-center">LISTA DE CLIENTES</h2>
    </div>

    <div>
        <a href ="cadastrar_cliente.jsp"><button type="button" class="btn-sm btn-primary btn-create" id="botao_form">+ Criar Novo Cliente</button></a>
    </div>
    <br><br><br>
    <div class="row">	
        <div class="col-md-12">     
            <table id="tabela" class="table table-striped table-bordered" cellspacing="0" width="100%"> 

                <thead>
                    <tr>
                        <th>#</th>
                        <th>Nome/Razão Social</th>
                        <th>Tipo</th>
                        <th>Status</th>
                        <th>Opções</th>
                    </tr>

                </thead>
                <jsp:useBean class="model.ClienteDAO" id ="cDAO"/>
                <tbody>
                    <c:forEach var ="c" items ="${cDAO.lista}">
                        <tr>
                            <td>${c.id_cliente}</td>
                            <td>${c.nome_razao}</td>
                            <td>
                                <c:if test="${c.tipo_cliente==1}">
                                    Fisica
                                </c:if>
                                
                               <c:if test="${c.tipo_cliente==2}">
                                    Jurídica
                               </c:if>
                                
                            </td>
                            <td>
                                <c:if test="${c.status_cliente==1}">
                                    Ativo
                                </c:if>
                                
                               <c:if test="${c.status_cliente==2}">
                                    Inativo
                               </c:if>
                                
                            </td>
                            <td>
                                 <button  class="btn-warning btn-xs" onclick ="exibirCliente(${c.id_cliente})"><span class="glyphicon glyphicon-info-sign"></span></button>
                                 <button  class="btn-info btn-xs" onclick ="exibirEndereco(${c.id_cliente})"><span class="glyphicon glyphicon-home"></span></button>
                                <button class="btn-primary btn-xs" onclick="editarCliente(${c.id_cliente})"><span class="glyphicon glyphicon-pencil"></span></button>
                                <button class="btn-danger btn-xs" onclick ="confirmarExclusao(${c.id_cliente}, '${c.nome_razao}')"><span class="glyphicon glyphicon-trash" ></span></button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script type="text/javascript">
    function editarCliente(id_cliente) {
        var url = "gerenciar_cliente.do?acao=alterar&id_cliente=" + id_cliente;
        $.get(url, null, function (page) {
            var modal = $("#edit");
            modal.find('.modal-body').html(page);
            modal.modal('show');
        });
    }
    
    function exibirCliente(id_cliente) {
        var url = "gerenciar_cliente.do?acao=exibir&id_cliente=" + id_cliente;
        $.get(url, null, function (page) {
            var modal = $("#exibe");
            modal.find('.modal-body').html(page);
            modal.modal('show');
        });
    }
    
    function exibirEndereco(id_cliente) {
        var url = "gerenciar_cliente.do?acao=exibirend&id_cliente=" + id_cliente;
        $.get(url, null, function (page) {
            var modal = $("#exibeend");
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
                <h4 class="modal-title custom_align" id="Heading">Editar Cliente</h4>
            </div>

            <div class="modal-body">

            </div>

            <!-- /.modal-content --> 
        </div>
        <!-- /.modal-dialog --> 
    </div>
</div>

<div class="modal fade" id="exibe" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title custom_align" id="Heading">Informações do Cliente</h4>
            </div>

            <div class="modal-body">

            </div>

            <!-- /.modal-content --> 
        </div>
        <!-- /.modal-dialog --> 
    </div>
</div>

<div class="modal fade" id="exibeend" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title custom_align" id="Heading">Endereços do Cliente</h4>
            </div>

            <div class="modal-body">

            </div>

            <!-- /.modal-content --> 
        </div>
        <!-- /.modal-dialog --> 
    </div>
</div>
<br><br>
 
</body>


