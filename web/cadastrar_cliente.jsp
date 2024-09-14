

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
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

    <!------ Include the above in your HEAD tag ---------->
    <link href ="estilo/menu.css" rel="stylesheet" type = "text/css"/>


    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/css/bootstrap.min.css" integrity="sha384-y3tfxAZXuh4HwSYylfB+J125MxIs6mR5FOHamPBG064zB+AFeWH94NdvaCBm8qnd" crossorigin="anonymous">
    <!-- font awesome -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-T8Gy5hrqNKT+hzMclPo118YTQO6cYprQmhrYwIiQ/3axmI1hQomh7Ud2hPOy8SP1" crossorigin="anonymous">


</head>

<body>
    <%@include file="menu.jsp" %>
    <%@include file="header.jsp" %>

    <br><br><br><br><br>
    <div class="container" id ="caixa">	

        <div class="row"><br>
            <h2 class="text-center">CADASTRO DE CLIENTE</h2>
        </div>
        <br>
        <form action ="gerenciar_cliente.do" method ="POST" >
            <div id ="input">

                <div class="form-group">
                    <input type ="hidden" name ="id_cliente" value ="${cliente.id_cliente}"/>

                    <label for="inputEmail4">Nome/Razão Social </label>
                    <input type="text" class="form-control" id="nome_razao" name="nome_razao" value ="${cliente.nome_razao}"required="" maxlength="">
                    
                    <br>
                    <label for="inputEmail4">CPF/CNPJ </label>
                    <input type="text" class="form-control" id="cpf_cnpj" name="cpf_cnpj" value ="${cliente.cpf_cnpj}"required="" maxlength="11">
                    
                    <br>
                    <label for="inputEmail4">RG/IE </label>
                    <input type="text" class="form-control" id="rg_ie" name="rg_ie" value ="${cliente.rg_ie}"required="" maxlength="11">
                    
                    <br>
                    <label for="inputEmail4">Telefone </label>
                    <input type="text" class="form-control" id="telefone_cliente" name="telefone_cliente" value ="${cliente.telefone_cliente}"required="" maxlength="11">
                    
                    <br>
                    <label for="inputEmail4">Responsável</label>
                    <input type="text" class="form-control" id="responsavel_obra" name="responsavel_obra" value ="${cliente.responsavel_obra}"required="" maxlength="11">
                   
                    <br>
                    <label for="inputEmail4">E-mail</label>
                    <input type="text" class="form-control" id="email_cliente" name="email_cliente" value ="${cliente.email_cliente}"required="" maxlength="45">
                    
                    <br>
                    <label for="inputEmail4">Observação</label>
                    <input type="text-area" class="form-control" id="email_cliente" name="obs_cliente" value ="${cliente.obs_cliente}"required="" maxlength="11">
                    
                    <br>
                    <label for="exibir">Tipo</label>
                    <select id="inputState" class="form-control col-md-4" name ="tipo_cliente"required>
                        <option value="1"selected>Física</option>
                        <option value="2">Jurídica</option>

                    </select>
                    
                    <br><br><br>
                    <label for="exibir">Status</label>
                    <select id="inputState" class="form-control col-md-4" name ="status_cliente"required>
                        <option value="1"selected>Ativo</option>
                        <option value="2">Inativo</option>

                    </select>
                </div>

                <br><br>
                <div>
                    <button type="submit" class="btn-sm btn-primary btn-create" id="botao_enviar">Cadastrar Cliente</button>
                    <a href="listar_cliente.jsp" class="btn-sm btn-primary btn-create" id="botao_enviar_a">Voltar</a>
                </div>

            </div>
        </form>
    </div>

</body>



</html>
