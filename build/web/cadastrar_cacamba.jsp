

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
            <h2 class="text-center">CADASTRO DE CAÇAMBAS</h2>
        </div>
        <br>
        <form action ="gerenciar_cacamba.do" method ="POST" >
            <div id ="input">

                <div class="form-group">
                    <input type ="hidden" name ="id_cacamba" value =""/>

                    <label for="inputEmail4">Numero da Caçamba </label>
                    <input type="text" class="form-control" id="nome" name="numero_cacamba" value =""required="" maxlength="">
                    <br>

                    <label for="exibir">Status da Caçamba</label>
                    <select id="inputState" class="form-control col-md-4" name ="status_cacamba"required>
                        <option value="1"selected>Livre</option>
                        <option value="2">Em uso</option>

                    </select>
                </div>

                <br><br>
                <div>
                    <button type="submit" class="btn-sm btn-primary btn-create" id="botao_enviar">Cadastrar Caçamba</button>
                    <a href="listar_cacamba.jsp" class="btn-sm btn-primary btn-create" id="botao_enviar_a">Voltar</a>
                </div>

            </div>
        </form>
    </div>
    
</body>



</html>
