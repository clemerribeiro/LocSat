

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
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
            <h2 class="text-center">CADASTRO DE PERFIL</h2>
        </div>
        <br>
        <form action ="gerenciar_perfil.do" method ="POST" >
            <div id ="input">

                <div class="form-group">
                    <input type ="hidden" name ="idperfil" value ="${perfil.idperfil}"/>

                    <label for="inputEmail4">Nome do Perfil * </label>
                    <input type="text" class="form-control" id="nome" name="nome" value ="${perfil.nome}"required="" maxlength="">

                </div>

                <br><br>
                <div>
                    <button type="submit" class="btn-sm btn-primary btn-create" id="botao_enviar">Cadastrar Perfil</button>
                    <a href="listar_perfil.jsp" class="btn-sm btn-primary btn-create" id="botao_enviar_a">Voltar</a>
                </div>

            </div>
        </form>
    </div>
        
</body>



</html>
