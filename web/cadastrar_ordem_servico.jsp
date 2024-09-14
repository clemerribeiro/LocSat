

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8"/>
    <meta name ="viewport" content ="widht-device-width, initial-scale-2.0"/>
    <title>Loc System</title>
    <link rel="shortcut icon" href="img/favicon.ico" />
    <link href ="estilo/style.css" rel="stylesheet" type = "text/css"/>
    <link href ="estilo/menu.css" rel="stylesheet" type = "text/css"/>
    <link href ="css/bootstrap.min.css" rel="stylesheet" type = "text/css"/>
    <script type ="text/javascript" src = "js/jquery-3.4.1.min"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script type ="text/javascript" src = "js/bootstrap.min.js"></script>


</head>

<body>

    <%@include file="menu.jsp" %>
    <%@include file="header.jsp" %>
    
    <br><br><br><br><br>
    <div class="container" id ="caixa">	

        <div class="row"><br>
            <h2 class="text-center">CADASTRAR ORDEM DE SERVIÇO</h2>
        </div>
        <br>
        <form action ="gerenciar_ordem_servico.do" method ="POST" >
            <div id ="input">

                <div class="form-group">
                    <input type ="hidden" name ="id_ordem_servico" value =""/>
                        
                    
                     <label for="exibir">Funcionário</label>
                    <select id="inputState" class="form-control col-md-4" name ="id_usuario"required>
                        <option value="1"selected>Selecione o Funcionário</option>
                        <jsp:useBean class="model.UsuarioDAO" id="usuario"/> 
                        <c:forEach var ="u" items="${usuario.lista}">
                            <option value ="${u.id_usuario}">${u.nome_usuario}</option>
                        </c:forEach>

                    </select>
                       <br><br><br> 
                   <div class="form-group">
                       <label for="exibir">Cliente</label> 
                    <select id="inputState" class="form-control col-md-4" name ="id_cliente"required>
                        <option value="1"selected>Selecione o Cliente</option>
                        <jsp:useBean class="model.ClienteDAO" id="cliente"/> 
                        <c:forEach var ="c" items="${cliente.lista}">
                            <option value ="${c.id_cliente}">${c.nome_razao}</option>
                        </c:forEach>

                    </select> 
                   </div>
                     <br>
                        <label for="exibir">Tipo de Serviço</label>
                    <select id="inputState" class="form-control col-md-4" name ="tipo_servico"required>
                        <option>Selecione o Serviço</option>
                        <option value="1">Locação</option>
                        <option value="2">Troca</option>
                        <option value="3">Retirada</option>

                    </select>
                        <br><br><br>
                        <label for="exibir">Caçamba</label>
                    <select id="inputState" class="form-control col-md-4" name ="id_cacamba"required>
                        <option value="1"selected>Selecione a Caçamba</option>
                        <jsp:useBean class="model.CacambaDAO" id="cacamba"/> 
                        <c:forEach var ="ca" items="${cacamba.lista}">
                            <option value ="${ca.id_cacamba}">${ca.numero_cacamba}</option>
                        </c:forEach>

                    </select>
                       
                        <br><br><br> 
                        <label for="exibir">Status</label>
                    <select id="inputState" class="form-control col-md-4" name ="status_ordem_servico"required>
                        
                        <option value="1">Pendente</option>
                        <option value="2">Finalizada</option>
                        <option value="3">Cancelada</option>

                    </select>
                        <br><br> 
                        
                        <br>
                        <label for="link">Endereço</label>
                    <input type="text" class="form-control" id="endereco" name="endereco" value ="" maxlength="">
                        
                        <br>
                        <label for="link">Valor do Serviço</label>
                    <input type="double" class="form-control" id="valor_servico" name="valor_servico" value ="" maxlength="">
                       
                        <br>
                        <label for="link">Placa do Caminhao</label>
                    <input type="text" class="form-control" id="placa_caminhao" name="placa_caminhao" value ="" maxlength="">
                         
                        <br>
                        <label for="link">CTR</label>
                    <input type="text" class="form-control" id="ctr" name="ctr" value ="" maxlength="">
                          
                    
                </div>
                        
                <br><br>
                <div>
                    <button type="submit" class="btn-sm btn-primary btn-create" id="botao_enviar">Cadastrar Ordem de Serviço</button>
                    <a href="listar_ordem_servico.jsp" class="btn-sm btn-primary btn-create" id="botao_enviar_a">Voltar</a>
                </div>

            </div>
        </form>
    </div>
   
    
    
    
    
</script>                                



<div class="modal fade" id="escolhe" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title custom_align" id="Heading">Escolher Cliente</h4>
            </div>

            <div class="modal-body">

            </div>

            <!-- /.modal-content --> 
        </div>
        <!-- /.modal-dialog --> 
    </div>
</div>



</body>



</html>
