 <jsp:include page="header.jsp"></jsp:include>
<header id="main-header" class="py-2 bg-primary text-white">
    <div class="container">
      <div class="row">
        <div class="col-md-6">
          <h2><i class="fa fa-user"></i> Cadastrar Cliente</h2>
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
          ${msg }
            <div class="card-header">
              <h4>Cadastrar Cliente</h4>
            </div>
            <div class="card-block">
              <form action="cadastro" method="post">
                <div class="form-group">
                  <label for="nome" class="form-control-label">Nome</label>
                  <input type="text" name="nome" class="form-control" maxlength="50" placeholder="Digite o nome...">
                </div>
                <div class="form-group">
                  <label for="email" class="form-control-label">Email</label>
                  <input type="text" name="email" class="form-control" maxlength="42" placeholder="Digite o email...">
                </div>
                <div class="form-group">
                    <label for="telefone1" class="form-control-label">Telefone</label>
                    <div class="form-group input-group">
                         <input type="text" name="telefone" class="form-control simple-field-data-mask placehoder"
					data-mask="(00) 0000-0000" maxlength="15" placeholder="Digite o telefone...">  
                    </div>
                    <label for="telefone2" class="form-control-label">Celular</label>
                    <div class="form-group input-group">
                       <input type="text" name="telefone" class="form-control simple-field-data-mask placehoder"
					data-mask="(00) 00000-0000" maxlength="15" placeholder="Digite o celular...">  
                    </div>
                </div>
                <div class="form-group">
                  <label for="cep" class="form-control-label">CEP</label>
                  <input type="text" name="cep" id="cep" class="form-control simple-field-data-mask placehoder"
					data-mask="00000-000" maxlength="9" placeholder="Digite o cep...">
                </div>
                
                <div class="form-group">
                <div class="row">
                <div class="col-md-9">
                  <label for="end" class="form-control-label">Endereço</label>
                  <input type="text" name="endereco" id="rua" class="form-control" maxlength="50" placeholder="Digite o endereço...">
                </div>
                <div class="col-md-3">
                  <label for="numero" class="form-control-label">Nº </label>
                  <input type="text" name="numero" class="form-control" maxlength="5" placeholder="Digite o Nº">
                  </div>
                  </div>
                </div>
                <div class="form-group">
                  <label for="bairro" class="form-control-label">Bairro</label>
                  <input type="text" name="bairro" id="bairro" class="form-control" maxlength="50" placeholder="Digite o bairro...">
                </div>
                <div class="form-group">
                  <label for="cidade" class="form-control-label">Cidade</label>
                  <input type="text" name="cidade" id="cidade" class="form-control" maxlength="50" placeholder="Digite a cidade...">
                </div>
                <div class="form-group">
                
                   <button type="submit" class="btn btn-success btn-md"><i class="fa fa-pencil"></i> 
          Cadastrar</button>
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