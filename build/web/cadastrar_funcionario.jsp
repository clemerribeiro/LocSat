

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
            <h2 class="text-center">CADASTRO DE FUNCIONÁRIO</h2>
        </div>
        <br>
        <form action ="gerenciar_usuario.do" method ="POST" >
            <div id ="input">

                <div class="form-group">
                    <input type ="hidden" name ="id_usuario" value =""/>

                    <label for="inputEmail4">Nome </label>
                    <input type="text" class="form-control" id="nome" name="nome_usuario" value =""required="" maxlength="">
                    <br>

                    <label for="link">Data de Nascimento</label>
                    <input type="text" class="form-control" id="nome" name="login_usuario" value =""required="" maxlength="">
                    <br>

                    <label for="icone">Senha </label>
                    <input type="text" class="form-control" id="nome" name="senha_usuario" value ="" maxlength=""required>
                    <br>

                    <label for="exibir">Perfil</label>
                    <select id="inputState" class="form-control col-md-4" name ="idperfil"required>
                        <option value="1"selected>Selecione o Perfil</option>
                        <jsp:useBean class="model.PerfilDAO" id="perfil"/> 
                        <c:forEach var ="p" items="${perfil.lista}">
                            <option value ="${p.idPerfil}">${p.nome}</option>
                        </c:forEach>

                    </select>
                     
                        <br><br><br>
                     <label for="exibir">Status</label>
                    <select id="inputState" class="form-control col-md-4" name ="status_usuario"required>
                        <option value="1"selected>Ativo</option>
                        <option value="2">Inativo</option>

                    </select>
                </div>

                <br><br>
                <div>
                    <button type="submit" class="btn-sm btn-primary btn-create" id="botao_enviar">Cadastrar Usuário</button>
                    <a href="listar_usuario.jsp" class="btn-sm btn-primary btn-create" id="botao_enviar_a">Voltar</a>
                </div>

            </div>
        </form>
    </div>
    
</body>



</html>
