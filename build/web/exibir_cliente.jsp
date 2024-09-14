<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<div style="padding: 20px">

    <div class="row">
        <form action ="gerenciar_cliente.do" method ="POST" >
            <div id="exibe" >

                <div class="form-group">
                    <input type ="hidden" name ="id_cliente" value ="${cliente.id_cliente}"/>

                    <label for="inputEmail4">Nome/Razão Social: </label> ${cliente.nome_razao}
                    <br>
                    <label for="inputEmail4">CPF/CNPJ: </label> ${cliente.cpf_cnpj}


                    <br>
                    <label for="inputEmail4">RG/IE: </label> ${cliente.rg_ie}


                    <br>
                    <label for="inputEmail4">Telefone: </label> ${cliente.telefone_cliente}


                    <br>
                    <label for="inputEmail4">Responsável: </label> ${cliente.responsavel_obra}


                    <br>
                    <label for="inputEmail4">E-mail: </label> ${cliente.email_cliente}


                    <br>
                    <label for="inputEmail4">Observação: </label> ${cliente.obs_cliente}


                    <br>
                    <label for="exibir">Tipo</label>

                    <c:if test="${cliente.tipo_cliente==1}">
                        Física 
                    </c:if>


                    <c:if test="${cliente.tipo_cliente==2}">
                        Jurídica
                    </c:if>

                    </select>
                    <br>
                    <label for="exibir">Status: </label>

                    <c:if test="${cliente.status_cliente==1}">
                        Ativo
                    </c:if>



                    <c:if test="${cliente.status_cliente==2}">
                        Inativo
                    </c:if>



                </div>
            </div>    
            


        </form>
    </div>
</div>	