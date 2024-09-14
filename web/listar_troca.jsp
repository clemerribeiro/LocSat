

<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8" />
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
</head>


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

    function Desativar(id, nome) {

        if (confirm('Deseja realmente desativar o usuario ' + nome + '?')) {
            location.href = 'gerenciar_usuario.do?acao=desativar&id_usuario=' + id;
        }
    }
    
    function Ativar(id, nome) {

        if (confirm('Deseja realmente ativar o usuario ' + nome + '?')) {
            location.href = 'gerenciar_usuario.do?acao=ativar&id_usuario=' + id;
        }
    }


</script>



<br><br><br><br><br>
<div class="container" id ="caixa_tabela">

    <div class="row"><br>
        <h2 class="text-center">ORDENS DE SERVIÇO FINALIZADAS</h2>
    </div>

    <div>
        <a href ="cadastrar_ordem_servico.jsp"><button type="button" class="btn-sm btn-primary btn-create" id="botao_form">+ Nova Ordem de Serviço</button></a>
    </div>
    <br><br><br>
    <div class="row">	
        <div class="col-md-12">     
            <table id="listar_usuario" class="table table-striped table-bordered" cellspacing="0" width="100%"> 

                <thead>
                    <tr>
                        <th>#</th>
                        <th>Status</th>
                        <th>Data de Criação</th>
                        <th>Cliente</th>
                        <th>Funcionário</th>
                        <th>Serviço</th>
                        <th>N° Caçamba</th>
                        <th>Opções</th>
                    </tr>

                </thead>
                 <jsp:useBean class="model.OrdemServicoDAO" id ="osDAO"/>
                <tbody>
                    <c:forEach var ="os" items ="${osDAO.listaTroca}">
                        <tr>
                            <td>${os.id_ordem_servico}</td>
                            <td>
                                <c:if test="${os.status_ordem_servico==1}">
                                    Pendente
                                </c:if>
                                
                               <c:if test="${os.status_ordem_servico==2}">
                                    Finalizada
                               </c:if>
                                
                                <c:if test="${os.status_ordem_servico==3}">
                                   Cancelada
                               </c:if>    
                            </td>
                            <td><fmt:formatDate pattern="dd/MM/YYYY" value="${os.data_criacao}"/></td>
                            <td>${os.cliente.nome_razao}</td>
                            <td>${os.usuario.nome_usuario}</td>
                            
                            <td>
                                <c:if test="${os.tipo_servico==1}">
                                    Locacação
                                </c:if>
                                
                               <c:if test="${os.tipo_servico==2}">
                                    Troca
                               </c:if>
                                    
                               <c:if test="${os.tipo_servico==3}">
                                    Retirada
                               </c:if>
     
                                
                            </td>
                            <td>${os.cacamba.numero_cacamba}</td>
                            
                            <td>
                                <button  class="btn-warning btn-xs" onclick ="ExibirOS(${os.id_ordem_servico})"><span class="glyphicon glyphicon-info-sign"></span></button>
                                <button type="button" class="btn-success btn-xs" onclick ="Finalizar(${os.id_ordem_servico})"><span class="glyphicon glyphicon-ok-circle"></span></button>
                                <button type="button" class="btn-danger btn-xs"  onclick ="Desativar(${u.id_usuario}, '${u.nome_usuario}')"><span class="glyphicon glyphicon-remove"></span></button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script type="text/javascript">
    function ExibirOS(id_ordem_servico) {
        var url = "gerenciar_ordem_servico.do?acao=exibir&id_ordem_servico=" + id_ordem_servico;
        $.get(url, null, function (page) {
            var modal = $("#edit");
            modal.find('.modal-body').html(page);
            modal.modal('show');
        });
    }
    
    function Finalizar(id_ordem_servico) {
        var url = "gerenciar_ordem_servico.do?acao=alterar&id_ordem_servico=" + id_ordem_servico;
        $.get(url, null, function (page) {
            var modal = $("#finalizar");
            modal.find('.modal-body').html(page);
            modal.modal('show');
        });
    }
    $(document).ready(function () {
        $("#listar_usuario").dataTable({
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
                <h4 class="modal-title custom_align" id="Heading">Detalhes da Ordem de Serviço</h4>
            </div>

            <div class="modal-body">

            </div>

            <!-- /.modal-content --> 
        </div>
        <!-- /.modal-dialog --> 
    </div>
</div>

<div class="modal fade" id="finalizar" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title custom_align" id="Heading">Finalizar Ordem de Serviço</h4>
            </div>

            <div class="modal-body">

            </div>

            <!-- /.modal-content --> 
        </div>
        <!-- /.modal-dialog --> 
    </div>
</div>
 
</body>


