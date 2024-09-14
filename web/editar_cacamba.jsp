<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<div style="padding: 20px">
    
    <div class="row">
        <form action ="gerenciar_cacamba.do" method ="POST" >
            <div id ="input">

                <div class="form-group">
                    <input type ="hidden" name ="id_cacamba" value ="${cacamba.id_cacamba}"/>

                    <label for="inputEmail4">Número da Caçamba</label>
                    <input type="text" class="form-control" id="nome" name="numero_cacamba" value ="${cacamba.numero_cacamba}"required="" maxlength="">
                    <br>
                    <label for="exibir">Status da Caçamba</label>
                    <select id="inputState" class="form-control col-md-4" name ="status_cacamba"required>
                        <option value="1"
                        <c:if test="${cacamba.status_cacamba==1}">
                            selected=""
                        </c:if>
                        >Livre </option>
                        
                        <option value="2"
                        <c:if test="${cacamba.status_cacamba==2}">
                            selected=""
                        </c:if>
                        >Em uso </option>

                    </select>

                </div>

                    <br><br>
                <div class=" ">
        <button type="submit" class="btn-warning btn-lg" style="width: 100%;"><span class="glyphicon glyphicon-ok-sign"></span> Atualizar Caçamba</button>
      </div >

            </div>
        </form>
    </div>
</div>	