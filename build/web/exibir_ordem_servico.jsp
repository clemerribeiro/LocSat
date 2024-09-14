<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<div style="padding: 20px">

    <div class="row">
        <form action ="gerenciar_ordem_servico.do" method ="POST" >
            <div id="exibe" >

                <div class="form-group">
                    <input type ="hidden" name ="id_ordem_servico" value ="${ordemservico.id_ordem_servico}"/>

                    <label for="inputEmail4">Funcion�rio: </label> ${ordemservico.usuario.nome_usuario}
                    
                    <br>
                    <label for="inputEmail4">Cliente: </label> ${ordemservico.cliente.nome_razao}

                    <br>
                    <label for="exibir">Tipo do Servi�o: </label>

                    <c:if test="${ordemservico.tipo_servico==1}">
                        Loca��o
                    </c:if>


                    <c:if test="${ordemservico.tipo_servico==2}">
                      Troca
                    </c:if>
                      
                    <c:if test="${ordemservico.tipo_servico==3}">
                      Retirada
                    </c:if>  

                    </select>
                    <br>
                    <label for="inputEmail4">Ca�amba: </label> ${ordemservico.cacamba.numero_cacamba}
                    
                    <br>
                    <label for="inputEmail4">Endere�o: </label> ${ordemservico.endereco}
                    
                    <br>
                    <label for="inputEmail4">Valor do Servi�o: </label> ${ordemservico.valor_servico}
                    
                    <br>
                    <label for="inputEmail4">Placa do Caminh�o: </label> ${ordemservico.placa_caminhao}
                    
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
            </div>    
            


        </form>
    </div>
</div>	