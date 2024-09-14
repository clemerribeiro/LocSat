<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<div style="padding: 20px">
    
        <div class="row">	
        <div class="col-md-12">     
            <table id="listar_usuario" class="table table-striped table-bordered" cellspacing="0" width="100%"> 

                <thead>
                    <tr>
                        <th>#</th>
                        <th>Cep</th>
                        <th>Bairro</th>
                        <th>Cidade</th>
                        <th>UF</th>
                        <th>Cliente</th>
                    </tr>

                </thead>
                <tbody>
                    <c:forEach var ="e" items ="${clientes}">
                        <tr>
                            <td>${c.id_cliente}</td>
                            <td>${c.nome_razao}</td>
                            <td>
                                <c:if test="${c.tipo_cliente==1}">
                                    Fisica
                                </c:if>
                                
                               <c:if test="${c.tipo_cliente==2}">
                                    Jurídica
                               </c:if>
                                
                            </td>
                            <td>
                                <c:if test="${c.status_cliente==1}">
                                    Ativo
                                </c:if>
                                
                               <c:if test="${c.status_cliente==2}">
                                    Inativo
                               </c:if>
                                
                            </td>
                            
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>                