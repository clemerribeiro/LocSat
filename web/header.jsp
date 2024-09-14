
<center>
    <header>

        <div class="container" id ="sair">
            <h1><font size = 8 face = Arial color = white align ="center"> </font></h1>	

        </div>

        <div id ="foto_header">
            <a href = "administracao.jsp">
                <img src="img/logolocsat.png" height="50px" align ="left">
            </a>
        </div><br>
        <div class="nav navbar-nav navbar-right" id="sair">
       <span class="glyphicon glyphicon-user"></span><c:if test="${ulogado!=null}">${ulogado.nome_usuario}</c:if>
            <a href="gerenciar_login.do"><span class="glyphicon glyphicon-log-in"></span>Sair</a>
        </div>
    </header>
</center>