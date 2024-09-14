<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<div style="padding: 20px">
    
    <div class="row">
        <form action ="gerenciar_endereco.do" method ="POST" >
            <div id ="input">

                <div class="form-group">
                    <input type ="hidden" name ="id_endereco" value ="${endereco.id_endereco}"/>

                    <label for="inputEmail4">CEP </label>
                    <input type="text" class="form-control" id="cep" name="cep" value ="${endereco.cep}"required="" maxlength="">
                    <br>
                  
                    <label for="link">Rua</label>
                    <input type="text" class="form-control" id="rua" name="rua" value ="${endereco.rua}"required="" maxlength="">
                    <br>
                    
                    <label for="link">Número</label>
                    <input type="text" class="form-control" id="numero" name="numero" value ="${endereco.numero}"required="" maxlength="">
                    <br>
                    
                    <label for="link">Bairro</label>
                    <input type="text" class="form-control" id="bairro" name="bairro" value ="${endereco.bairro}"required="" maxlength="">
                    <br>
                    
                    <label for="link">Cidade</label>
                    <input type="text" class="form-control" id="cidade" name="cidade" value ="${endereco.cidade}"required="" maxlength="">
                    <br>
                   
                     <label for="link">UF</label>
                    <input type="text" class="form-control" id="uf" name="uf" value ="${endereco.uf}"required="" maxlength="">
                    <br>
                     
                    <label for="icone">Complemento</label>
                    <input type="text" class="form-control" id="complemento" name="complemento" value ="${endereco.complemento}" maxlength=""required>
                    <br>
                    
                    <label for="exibir">Cliente</label>
                    <select id="inputState" class="form-control col-md-4" name ="id_cliente"required>
                        <option value="1"selected>Selecione o Cliente</option>
                        <jsp:useBean class="model.ClienteDAO" id="cliente"/> 
                        <c:forEach var ="c" items="${cliente.lista}">
                            <option value ="${c.id_cliente}"
                                    
                            <c:if test="${c.id_cliente==endereco.cliente.id_cliente}">selected=""
                            
                            </c:if>
                                    
                                    >${c.nome_razao}</option>
                        </c:forEach>

                    </select>
                     
                     
                        <br><br><br>
                <div class=" ">
        <button type="submit" class="btn-warning btn-lg" style="width: 100%;"><span class="glyphicon glyphicon-ok-sign"></span> Atualizar Endereço</button>
      </div>

            </div>
        </form>
    </div>
</div>	