

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
            <h2 class="text-center">CADASTRO DE ENDEREÇO</h2>
        </div>
        <br>
        <form action ="gerenciar_endereco.do" method ="POST" >
            <div id ="input">

                <div class="form-group">
                    <input type ="hidden" name ="id_endereco" value =""/>

                    <label for="inputEmail4">CEP </label>
                    <input type="text" class="form-control" id="cep" name="cep" value =""required="" maxlength="">
                    <br>
                  
                    <label for="link">Rua</label>
                    <input type="text" class="form-control" id="rua" name="rua" value =""required="" maxlength="">
                    <br>
                    
                    <label for="link">Número</label>
                    <input type="text" class="form-control" id="numero" name="numero" value =""required="" maxlength="">
                    <br>
                    
                    <label for="link">Bairro</label>
                    <input type="text" class="form-control" id="bairro" name="bairro" value =""required="" maxlength="">
                    <br>
                    
                    <label for="link">Cidade</label>
                    <input type="text" class="form-control" id="cidade" name="cidade" value =""required="" maxlength="">
                    <br>
                    
                     <label for="link">UF</label>
                    <input type="text" class="form-control" id="uf" name="uf" value =""required="" maxlength="">
                    <br>
                     
                    <label for="icone">Complemento</label>
                    <input type="text" class="form-control" id="complemento" name="complemento" value ="" maxlength=""required>
                    <br>
                    
                    <label for="exibir">Cliente</label>
                    <select id="inputState" class="form-control col-md-4" name ="id_cliente"required>
                        <option value="1"selected>Selecione o Cliente</option>
                        <jsp:useBean class="model.ClienteDAO" id="cliente"/> 
                        <c:forEach var ="c" items="${cliente.lista}">
                            <option value ="${c.id_cliente}">${c.nome_razao}</option>
                        </c:forEach>

                    </select>
                     
                     
                </div>

                <br><br>
                <div>
                    <button type="submit" class="btn-sm btn-primary btn-create" id="botao_enviar">Cadastrar Endereço</button>
                    <a href="listar_endereco.jsp" class="btn-sm btn-primary btn-create" id="botao_enviar_a">Voltar</a>
                </div>

            </div>
        </form>
    </div>
    
</body>



</html>
