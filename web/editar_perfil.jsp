<div style="padding: 20px">
    
    <div class="row">
        <form action ="gerenciar_perfil.do" method ="POST" >
            <div id ="input">

                <div class="form-group">
                    <input type ="hidden" name ="idperfil" value ="${perfil.idPerfil}"/>

                    <label for="inputEmail4">Nome do Perfil</label>
                    <input type="text" class="form-control" id="nome" name="nome" value ="${perfil.nome}"required="" maxlength="">

                </div>

                <br>
                <div class=" ">
        <button type="submit" class="btn-warning btn-lg" style="width: 100%;"><span class="glyphicon glyphicon-ok-sign"></span>Atualizar</button>
      </div>

            </div>
        </form>
    </div>
</div>	