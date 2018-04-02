 <jsp:include page="header.jsp"></jsp:include>

  <header id="main-header" class="py-2 bg-primary text-white">
    <div class="container">
      <div class="row">
        <div class="col-md-6">
          <h2>Cadastrar Serviço</h2>
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
         ${msg }
          <div class="card">
            <div class="card-header">
              <h4>Cadastrar Serviço</h4>
            </div>
            <div class="card-block">
              <form action="cadastrar_servico" method="POST" role="form" enctype="multipart/form-data">
              
              <div class="form-group">
             <label for="categoria" class="form-control-label">Categoria</label>
             <select class="form-control" name="cat">
             	<option value="" disabled selected>Escolha a categoria</option>
		       <option value="iPhone">Serviço em iPhone</option>
		       <option value="iPad">Serviço em iPad</option>
    		</select>
             </div> 
              
                <div class="form-group">
                          <div class="main-img-preview">
                            <img class="thumbnail img-mostrar-1" src="http://dummyimage.com/800x600/4d494d/686a82.jpg&text=iPhone+Frente" title="Imagem do Serviço">
                        </div>
                        <hr>
                        <div class="input-group">
                            <div class="input-group-btn">
                              <div class="fileUpload btn btn-danger fake-shadow">
                                <span><i class="glyphicon glyphicon-upload"></i> Upload de imagem</span>
                                <input id="servico_imagem" name="servico_imagem" type="file" class="anexo_upload-1">
                            </div>
                        </div>
                        <input id="fakeUploadImagem-1" class="form-control fake-shadow" placeholder="Imagem do Serviço" disabled="disabled">
                    </div>
                    <small id="fileHelp" class="form-text text-muted">
                    <p class="help-block">* Imagem do serviço<br> Tamanho Máximo 3MB</p>
                    </small>
                </div>
                <div class="form-group">
                  <label for="nome" class="form-control-label">Nome</label>
                  <input type="text" name="nome" class="form-control" maxlength="40" placeholder="Digite nome do aparelho...">
                </div>
   
                <div class="form-group">
                <div class="row">
                <div class="col-md-9">
                  <label for="descricao" class="form-control-label">Descrição</label>
                  <input type="text" name="descricaoServ" class="form-control" maxlength="50" placeholder="Digite tipo do serviço...">
                </div>
                <div class="col-md-3">
                  <label for="preco" class="form-control-label">Preço </label>
                  <input type="text" name="precoServ" class="form-control" placeholder="Digite valor do serviço..." data-mask="#.##0,00" data-mask-reverse="true" data-mask-maxlength="true" maxlength="9">
                  </div>
                  </div>
                  <hr>
                  	<span class="input-group-btn">
                   		<button type="button" class="btn btn-success btn-add btn-md" style="width: 40px;"><b>+</b></button>
                	</span>
                </div>
                <small id="fileHelp" class="form-text text-muted text-left">
                    <p class="help-block">* Pressione <span class="fa fa-plus"></span> para adicionar campo no formulário <br>* Pressione <span class="fa fa-minus"></span> para remover o campo do formulário</p>
                </small>
                
                <hr>
                <div class="form-group">
                   <button type="submit" class="btn btn-success btn-md"><i class="fa fa-cog"></i> 
          Cadastrar</button>
          			<a href="servico.jsp" class="btn btn-info btn-md"><i class="fa fa-list-alt"></i> 
          Lista de serviços</a>
                </div> 
              </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  
<jsp:include page="footer.jsp"></jsp:include>