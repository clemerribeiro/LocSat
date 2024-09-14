<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<div style="padding: 20px">
    
    <div class="row">
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
                        <option value="1"
                        <c:if test="${cliente.tipo_cliente==1}">
                            selected=""
                        </c:if>
                        >Física</option>
                        
                        <option value="2"
                        <c:if test="${cliente.tipo_cliente==2}">
                            selected=""
                        </c:if>
                        >Jurídica</option>
                    </select>
                    <br><br><br>
                    <label for="exibir">Status</label>
                    <select id="inputState" class="form-control col-md-4" name ="status_cliente"required>
                        <option value="1"
                        <c:if test="${cliente.status_cliente==1}">
                            selected=""
                        </c:if>
                        >Ativo</option>
                        
                        <option value="2"
                        <c:if test="${cliente.status_cliente==2}">
                            selected=""
                        </c:if>
                        >Inativo </option>
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