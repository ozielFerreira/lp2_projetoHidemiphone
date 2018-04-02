<jsp:include page="header.jsp"></jsp:include>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="">
<jsp:useBean id="prodCli" class="managed.ClienteManaged"></jsp:useBean>
<jsp:useBean id="prodBean" class="managed.ProdutoManaged"></jsp:useBean>
<jsp:useBean id="servBean" class="managed.ServicoManaged"></jsp:useBean>

  <header id="main-header" class="py-2 bg-primary text-white">
    <div class="container">
      <div class="row">
        <div class="col-md-6">
          <h2><i class="fa fa-gear"></i> Painel de Controle</h2>
        </div>
      </div>
    </div>
  </header>
</div>
  <!-- BOTOES MODAL SECTION -->
  <section id="actions" class="py-4 mb-4 bg-faded">
    <div class="container">
      <div class="row">
        <div class="col-md-4">
          <a href="cadastrar_produto.jsp" class="btn btn-primary btn-block"><i class="fa fa-plus"></i> Cadastrar Produto</a>
        </div>
        <div class="col-md-4">
          <a href="cadastrar_servico.jsp" class="btn btn-success btn-block"><i class="fa fa-plus"></i> Cadastrar Serviço</a>
        </div>
        <div class="col-md-4">
          <a href="cadastrar_cliente.jsp" class="btn btn-warning btn-block"><i class="fa fa-plus"></i> Cadastrar Cliente</a>
        </div>
      </div>
    </div>
  </section>

  <!-- PRODUTO -->
  <section id="posts">
    <div class="container">
      <div class="row">
        <div class="col-md-9">
          <div class="card">
            <div class="card-header">
              <h4>Produtos</h4>
            </div>
             <div class="table table-responsive">
                   <table id="tabela_produto" class="table table-striped table-bordered" cellspacing="0" width="100%">
       <thead class="thead-inverse">
        <tr>
         <th style="padding-right:40px;">Nº</th>
         <th style="padding-right:60px;">Produto</th>
         <th style="padding-right:120px;">Nome</th>
         <th style="padding-right:170px;">Descrição</th>
         
         <th style="padding-right:60px;">Preço</th>
         <th style="padding-right:40px;">Categoria</th>
         <th class="text-center" style="padding-right:50px;">Editar</th>
         <th class="text-center" style="padding-right:50px;">Excluir</th>
        </tr>
       </thead>
       <tbody>
       <c:forEach items="${prodBean.listaProd }" var="p">
        <tr>

         <td scope="row
         ">${p.codigo }</td>
         <td><img src='../upFotos/${p.foto }' style="width:70px;"></td>
         <td>${p.nome }</td>
         <td>${p.descricao }</td>
         
         <td><fmt:formatNumber value="${p.preco }" type="currency"></fmt:formatNumber></td>
         <td>${p.categoria }</td>
         <td class="text-center"><a href="editar?cod=${p.codigo }" class="btn btn-secondary"><i
           class="fa fa-angle-double-right"></i> Editar</a></td>
         <td class="text-center"><a href="excluir?cod=${p.codigo }&f=${p.foto}" onclick="return window.confirm('Deseja realmente excluir esse item?')" class="btn btn-danger"><i
           class="fa fa-trash"></i> Excluir</a></td>

        </tr>
      </c:forEach>
       </tbody>
      </table>
            </div>
          </div>
        </div>
        <div class="col-md-3">
          <div class="card text-center card-primary text-white mb-3">
            <div class="card-block">
              <h3>Produto</h3>
              <h1 class="display-4"><i class="fa fa-pencil-square-o" aria-hidden="true""></i> ${fn:length(prodBean.listaProd ) }</h1>
              <a href="produto.jsp" class="btn btn-sm btn-outline-secondary text-white">Visualizar</a>
            </div>
          </div>

          <div class="card text-center card-success text-white mb-3">
            <div class="card-block">
              <h3>Serviço</h3>
              <h1 class="display-4"><i class="fa fa-folder-open-o"></i> ${fn:length(servBean.listaServ)}</h1>
              <a href="servico.jsp" class="btn btn-sm btn-outline-secondary text-white">Visualizar</a>
            </div>
          </div>

          <div class="card text-center card-warning text-white mb-3">
            <div class="card-block">
              <h3>Cliente</h3>
              <h1 class="display-4"><i class="fa fa-users"></i> ${fn:length(prodCli.listaCli) }</h1>
              <a href="cliente.jsp" class="btn btn-sm btn-outline-secondary text-white">Visualizar</a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>

 <jsp:include page="footer.jsp"></jsp:include>
