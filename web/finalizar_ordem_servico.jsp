<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<div style="padding: 20px">

    <div class="row">
        <form action ="gerenciar_ordem_servico.do" method ="POST" >
            <div id="exibe" >

                <div class="form-group">
                    <input type ="hidden" name ="id_ordem_servico" value ="${ordemservico.id_ordem_servico}"/>

                    <label for="inputEmail4">Funcionário: </label> ${ordemservico.usuario.nome_usuario}
                    
                    <br>
                    <label for="inputEmail4">Cliente: </label> ${ordemservico.cliente.nome_razao}

                    <br>
                    <label for="exibir">Tipo do Serviço: </label>

                    <c:if test="${ordemservico.tipo_servico==1}">
                        Locação
                    </c:if>


                    <c:if test="${ordemservico.tipo_servico==2}">
                      Troca
                    </c:if>
                      
                    <c:if test="${ordemservico.tipo_servico==3}">
                     Retirada
                    </c:if> 
                      
                    

                    </select>
                    <br>
                        <label for="exibir">Caçamba</label>
                    <select id="inputState" class="form-control col-md-4" name ="id_cacamba"required>
                        <option value="1"selected>Selecione a Caçamba</option>
                        <jsp:useBean class="model.CacambaDAO" id="cacamba"/> 
                        <c:forEach var ="ca" items="${cacamba.lista}">
                            <option value ="${ca.id_cacamba}">${ca.numero_cacamba}</option>
                        </c:forEach>

                    </select>
                    
                        <br><br><br>
                    
                    <label for="inputEmail4">Endereço: </label> ${ordemservico.endereco}
                    
                    <br>
                    <label for="inputEmail4">Valor do Serviço: </label> ${ordemservico.valor_servico}
                    
                    <br>
                    <label for="inputEmail4">Placa do Caminhão: </label> ${ordemservico.placa_caminhao}
                    
                    <br>
                    <label for="link">CTR</label>
                    <input type="text" class="form-control" id="ctr" name="ctr" value ="" maxlength="">
                    
                    <br>
                    <label for="inputEmail4">CTR: </label>${ordemservico.ctr}
                    
                    <br>
                    <label for="exibir">Status: </label>

                    <c:if test="${ordemservico.status_ordem_servico==1}">
                        Pendente
                    </c:if>



                    <c:if test="${ordemservico.status_ordem_servico==2}">
                        Finalizada
                    </c:if>
                        
                        <c:if test="${ordemservico.status_ordem_servico==3}">
                        Cancelada
                    </c:if>



                </div>
                    <br>
                <div class=" ">
        <button type="submit" class="btn-warning btn-lg" style="width: 100%;"><span class="glyphicon glyphicon-ok-sign"></span> Finalizar OS</button>
      </div>
            </div>    
            

        </form>
    </div>
</div>	