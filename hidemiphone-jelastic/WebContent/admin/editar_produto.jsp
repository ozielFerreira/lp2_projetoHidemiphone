 <jsp:include page="header.jsp"></jsp:include>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <header id="main-header" class="py-2 bg-primary text-white">
    <div class="container">
      <div class="row">
        <div class="col-md-6">
          <h2>Editar Produto</h2>
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
  <section id="editar_produto">
    <div class="container">
      <div class="row">
        <div class="col">
       <div class="card">
            <div class="card-header">
              <h4>Editar Produto</h4>
            </div>
            <div class="card-block">
              <form action="atualizar" method="POST" enctype="multipart/form-data">
                <div class="form-group">
              <div class="main-img-preview">
                <img class="thumbnail img-mostrar-2" src="../upFotos/${produto.foto }" title="Imagem Produto">
            	<input type="hidden" name="foto" value="${produto.foto }">
            </div>
            <hr>
            <div class="input-group">
                <div class="input-group-btn">
                  <div class="fileUpload btn btn-danger fake-shadow">
                    <span><i class="glyphicon glyphicon-upload"></i> Upload de imagem</span>
                    <input id="imagem_produto" name="imagem_produto" type="file" class="upload-1" >
                    <input type="hidden" name="txtFoto" value="${produto.foto }"/>
                </div>
            </div>
            <input id="fakeUpImagem-1" class="form-control fake-shadow" placeholder="Imagem do produto" disabled="disabled">
        </div>
        <small id="fileHelp" class="form-text text-muted">
                    <p class="help-block">* Imagem da produto<br> Tamanho Máximo 3MB</p>
                  </small>
    	</div>
                <div class="form-group">
                <input type="hidden" name="id" value="${produto.codigo }"/>
                  <label for="title" class="form-control-label">Nome</label>
                  <input type="text" name="nome" class="form-control" value="${produto.nome }" placeholder="Nome do produto...">
                </div>
                <div class="form-group">
                  <label for="descricao">Descrição</label>
                  <textarea name="descricao" class="form-control" rows="2" maxlength="283" style="resize: none;" placeholder="Descrição do produto...">${produto.descricao }</textarea>
                </div>
                <div class="form-group">
                  <label for="title" class="form-control-label">Preço</label>
                  <input type="text" name="preco" class="form-control" value="<fmt:formatNumber value='${produto.preco }' type='currency'></fmt:formatNumber>" placeholder="Preço do produto...">
                </div>
                <div class="form-group">
                   <button type="submit" class="btn btn-success btn-md"><i class="fa fa-cog"></i> 
          Editar</button>
          			<a href="produto.jsp" class="btn btn-info btn-md"><i class="fa fa-list-alt"></i> 
          Lista de produtos</a>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  
<jsp:include page="footer.jsp"></jsp:include>