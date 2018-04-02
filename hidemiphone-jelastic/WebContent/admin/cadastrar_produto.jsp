 <jsp:include page="header.jsp"></jsp:include>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
  <header id="main-header" class="py-2 bg-primary text-white">
    <div class="container">
      <div class="row">
        <div class="col-md-6">
          <h2>Cadastrar Produto</h2>
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
  <section id="cadastrar_produto">
    <div class="container">
      <div class="row">
        <div class="col">
                  ${msg }
          <div class="card">
            <div class="card-header">
              <h4>Cadastrar Produto</h4>
            </div>
            <div class="card-block">
              <form action="cadastrar_produto" method="post" role="form" enctype="multipart/form-data">
                
             <div class="form-group">
             <label for="title" class="form-control-label">Categoria</label>
             <select class="form-control" name="cat">
             	<option value="" disabled selected>Escolha a categoria</option>
		       <option value="iPhone">iPhone</option>
		       <option value="iPad">iPad</option>
		       <option value="Acessórios">Acessórios</option>
    		</select>
             </div> 
               
            <div class="form-group">
              <div class="main-img-preview">
                <img class="thumbnail img-mostrar-2" src="http://dummyimage.com/600x400/4d494d/686a82.jpg&text=imagem+produto" title="Imagem Produto">
            </div>
            <hr>
            <div class="input-group">
                <div class="input-group-btn">
                  <div class="fileUpload btn btn-danger fake-shadow">
                    <span><i class="glyphicon glyphicon-upload"></i> Upload de imagem</span>
                    <input id="imagem_produto" name="imagem_produto" type="file" class="upload-1">
                </div>
            </div>
            <input id="fakeUpImagem-1" class="form-control fake-shadow" placeholder="Imagem do produto" disabled="disabled">
        </div>
        <small id="fileHelp" class="form-text text-muted">
                    <p class="help-block">* Imagem da produto<br> Tamanho Máximo 3MB</p>
                  </small>
    	</div>
        
                <div class="form-group">
                  <label for="nomeprod" class="form-control-label">Nome</label>
                  <input type="text" name="nomeProd" class="form-control" placeholder="Nome do produto...">
                </div>
                <div class="form-group">
                  <label for="descricao">Descrição</label>
                  <textarea name="descricaoProd" class="form-control" rows="4" maxlength="283" style="resize: none;" placeholder="Descrição do produto..."></textarea>
                </div>
                <div class="form-group">
                  <label for="preco" class="form-control-label">Preço</label>
                  <input type="text" name="preco" class="form-control" placeholder="Preço do produto..." data-mask="#.##0,00" data-mask-reverse="true" data-mask-maxlength="true" maxlength="9">
                </div>
                <div class="form-group">
                   <button type="submit" class="btn btn-success btn-md"><i class="fa fa-cog"></i> 
          Cadastrar</button>
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