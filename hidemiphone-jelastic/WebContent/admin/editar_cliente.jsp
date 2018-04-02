 <jsp:include page="header.jsp"></jsp:include>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:useBean id="prodTel" class="managed.TelefoneManaged"></jsp:useBean>
<header id="main-header" class="py-2 bg-primary text-white">
    <div class="container">
      <div class="row">
        <div class="col-md-6">
          <h2><i class="fa fa-user"></i> Editar Cliente</h2>
        </div>
      </div>
    </div>
  </header>

  <!-- ACTIONS -->
  <section id="actions" class="py-4 mb-4 bg-faded">
    <div class="container">
      <div class="row">
        <div class="col-md-5 mr-auto">
          <a href="index.jsp" class="btn btn-secondary btn-block"><i class="fa fa-arrow-left"></i> Voltar Painel de Controle</a>
        </div>
		<div class="col-md-2">
          
        </div>
        <div class="col-md-5">
          
        </div>
      </div>
    </div>
  </section>

  <!-- EDITAR PRODUTOS -->
  <section id="editar_produtos">
    <div class="container">
      <div class="row">
        <div class="col">
          <div class="card">
            <div class="card-header">
              <h4>Editar Cliente</h4>
            </div>
            <div class="card-block">
              <form action="atualizar_cliente" method="post">
             <c:set value="${c.idUsuario }" var="tel"></c:set>
              <input type="hidden" value="${c.endereco.idEndereco }" name="idEnd"/>
              <input type="hidden" value="${c.idUsuario }" name="idUser">
              <input type="hidden" name="telSize" value="${fn:length(prodTel.getListaTel(tel)) }"/>
                <div class="form-group">
                  <label for="title" class="form-control-label">Nome</label>
                  <input type="text" name="nome" class="form-control" value="${c.nome }">
                </div>
                <div class="form-group">
                  <label for="title" class="form-control-label">Email</label>
                  <input type="text" name="email" class="form-control" value="${c.email }">
                </div>
                <div class="form-group">
                    <label>Telefone</label>
                    <c:forEach items="${prodTel.getListaTel(tel)  }" var="t">
                    <input type="hidden" value="${t.id }" name="idTel"/>
                    <div class="form-group input-group">
           
                        <input type="text" name="telefone" id="" class="form-control" value="${t.getNumero()}">
                      
                    </div>
                    </c:forEach>
                     
                    
                </div>
                <div class="form-group">
                  <label for="title" class="form-control-label">CEP</label>
                  <input type="text" name="cep" class="form-control" value="${c.cep }">
                </div>
                
                <div class="form-group">
                <div class="row">
                <div class="col-md-9">
                  <label for="title" class="form-control-label">Endereço</label>
                  <input type="text" name="endereco" class="form-control" value="${c.endereco.logradouro }">
                </div>
                <div class="col-md-3">
                  <label for="title" class="form-control-label">Nº </label>
                  <input type="text" name="numero" class="form-control" value="${c.endereco.numero }">
                  </div>
                  </div>
                </div>
                <div class="form-group">
                  <label for="title" class="form-control-label">Bairro</label>
                  <input type="text" name="bairro" class="form-control" value="${c.endereco.bairro }">
                </div>
                <div class="form-group">
                  <label for="title" class="form-control-label">Cidade</label>
                  <input type="text" name="cidade" class="form-control" value="${c.endereco.cidade }">
                </div>
                <div class="form-group">
                   <button type="submit" class="btn btn-success btn-md"><i class="fa fa-pencil"></i> 
          Editar</button>
          			<a href="cliente.jsp" class="btn btn-info btn-md"><i class="fa fa-list-alt"></i> 
          Lista de clientes</a>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  
<jsp:include page="footer.jsp"></jsp:include>