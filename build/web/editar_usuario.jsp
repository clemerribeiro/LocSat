<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<div style="padding: 20px">
    
    <div class="row">
        <form action ="gerenciar_usuario.do" method ="POST" >
            <div id ="input">

                <div class="form-group">
                    <input type ="hidden" name ="id_usuario" value ="${usuario.id_usuario}"/>

                    <label for="inputEmail4">Nome</label>
                    <input type="text" class="form-control" id="nome" name="nome_usuario" value ="${usuario.nome_usuario}"required="" maxlength="">
                    <br>
                    <label for="inputEmail4">Login</label>
                    <input type="text" class="form-control" id="nome" name="login_usuario" value ="${usuario.login_usuario}"required="" maxlength="">
                    <br>
                    <label for="inputEmail4">Senha</label>
                    <input type="text" class="form-control" id="nome" name="senha_usuario" value ="${usuario.senha_usuario}" maxlength="">
                    <br>
                    <label for="exibir">Status</label>
                    <select id="inputState" class="form-control col-md-4" name ="status_usuario"required>
                        <option value="1"
                        <c:if test="${usuario.status_usuario==1}">
                            selected=""
                        </c:if>
                        >Ativo</option>
                        
                        <option value="2"
                        <c:if test="${usuario.status_usuario==2}">
                            selected=""
                        </c:if>
                        >Inativo </option>

                    </select>
                    <br><br><br>
                    <label for="exibir">Perfil</label>
                    <select id="inputState" class="form-control col-md-4" name ="idperfil"required>
                        <option value="1"selected>Selecione o Perfil</option>
                        <jsp:useBean class="model.PerfilDAO" id="perfil"/> 
                        <c:forEach var ="p" items="${perfil.lista}">
                            <option value ="${p.idPerfil}"
                                    
                            <c:if test="${p.idPerfil==usuario.perfil.idPerfil}">selected=""
                            
                            </c:if>
                                    
                                    >${p.nome}</option>
                        </c:forEach>

                    </select>
                </div>

                    <br><br>
                <div class=" ">
        <button type="submit" class="btn-warning btn-lg" style="width: 100%;"><span class="glyphicon glyphicon-ok-sign"></span> Atualizar Usuário</button>
      </div>

            </div>
        </form>
    </div>
</div>	