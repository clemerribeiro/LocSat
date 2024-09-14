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
                    <c:forEach var ="e" items ="${enderecos}">
                        <tr>
                            <td>${e.id_endereco}</td>
                            <td>${e.cep}</td>
                            <td>${e.bairro}</td>
                            <td>${e.cidade}</td>
                            <td>${e.uf}</td>
                            <td>${e.cliente.nome_razao}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>                