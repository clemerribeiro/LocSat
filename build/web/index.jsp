
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<html>

    <head>

        <meta Charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title> Login | Loc System </title>
        <link rel="shortcut icon" href="img/favicon.ico"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css">
        <link href ="estilo/acesso.css" rel="stylesheet" type = "text/css"/>
    </head>
    <!--Coded with love by Mutiullah Samim-->
    <body>
        <div class="container h-100">
            <div class="d-flex justify-content-center h-100">
                <div class="user_card">
                    <div class="d-flex justify-content-center">
                        <div class="brand_logo_container">
                            <img src="img/logolocsat.png" class="brand_logo" alt="Logo">
                        </div>
                    </div>
                    <div id ="caixa_login">
                        <div class="d-flex justify-content-center form_container">
                            <%
                                String mensagem =(String)request.getSession().getAttribute("mensagem");
                                if(mensagem !=null){
                                   request.getSession().removeAttribute("mensagem"); 
                                
                            
                            %>
                            <div class ="alert alert-info"><%=mensagem%></div>
                            <%
                            }
                            %>
                            <form action= "gerenciar_login.do" method = "POST">
                                <label>Login</label>
                                <div class="input-group mb-3">
                                    <div class="input-group-append">
                                        <span class="input-group-text"><i class="fas fa-user"></i></span>
                                    </div>
                                    <input type="text" name="login_usuario" class="form-control input_user" id ="login_usuario"value="" placeholder="Usuário">
                                </div>

                                <label>Senha</label>
                                <div class="input-group mb-2">
                                    <div class="input-group-append">
                                        <span class="input-group-text"><i class="fas fa-key"></i></span>
                                    </div>

                                    <input type="password" name="senha_usuario" class="form-control input_pass" id ="senha_usuario" value="" placeholder="Senha">
                                </div>
                                <br>

                                <div class="d-flex justify-content-center mt-3 login_container">
                                    <button type="submit" name="button" class="btn login_btn">Entrar</button>
                                </div>
                        </div>
                        </form>
                    </div>


                </div>
            </div>
        </div>
    </body>
</html>
