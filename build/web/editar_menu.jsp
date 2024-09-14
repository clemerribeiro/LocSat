<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<div style="padding: 20px">
    
    <div class="row">
        <form action ="gerenciar_menu.do" method ="POST" >
            <div id ="input">

                <div class="form-group">
                    <input type ="hidden" name ="idmenu" value ="${menu.idmenu}"/>

                    <label for="inputEmail4">Nome do Menu</label>
                    <input type="text" class="form-control" id="nome" name="nome" value ="${menu.nome}"required="" maxlength="">
                    <br>
                    <label for="inputEmail4">Link do Menu</label>
                    <input type="text" class="form-control" id="nome" name="link" value ="${menu.link}"required="" maxlength="">
                    <br>
                    <label for="inputEmail4">Icone do Menu</label>
                    <input type="text" class="form-control" id="nome" name="icone" value ="${menu.icone}" maxlength="">
                    <br>
                    <label for="exibir">Exibir</label>
                    <select id="inputState" class="form-control col-md-4" name ="exibir"required>
                        <option value="1"
                        <c:if test="${menu.exibir==1}">
                            selected=""
                        </c:if>
                        >Sim </option>
                        
                        <option value="2"
                        <c:if test="${menu.exibir==2}">
                            selected=""
                        </c:if>
                        >Não </option>

                    </select>

                </div>

                    <br><br>
                <div class=" ">
        <button type="submit" class="btn-warning btn-lg" style="width: 100%;"><span class="glyphicon glyphicon-ok-sign"></span>Atualizar</button>
      </div>

            </div>
        </form>
    </div>
</div>	