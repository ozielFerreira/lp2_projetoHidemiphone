<jsp:include page="header.jsp"></jsp:include>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:useBean id="prodBean" class="managed.ProdutoManaged"></jsp:useBean>
<header id="main-header" class="py-2 bg-primary text-white">
 <div class="container">
  <div class="row">
   <div class="col-md-6">
    <h2>
     <i class="fa fa-pencil-square-o" aria-hidden="true"></i> Produto
    </h2>
   </div>
  </div>
 </div>
</header>
<style>
<!--
table.dataTable thead>tr>th.sorting_asc, table.dataTable thead>tr>th.sorting_desc, table.dataTable thead>tr>th.sorting, table.dataTable thead>tr>td.sorting_asc, table.dataTable thead>tr>td.sorting_desc, table.dataTable thead>tr>td.sorting {
    padding-right: 50px;
-->
</style>
<!-- BUSCAR -->
<section id="actions" class="py-4 mb-4 bg-faded">
 <div class="container">
  <div class="row">
   <!--  <div class="col-md-6 offset-md-6">
          <div class="input-group">
            <input type="text" class="form-control" placeholder="Pesquizar...">
            <span class="input-group-btn">
              <button class="btn btn-primary">Buscar</button>
            </span>
          </div>
        </div> -->
   <div class="col-md-5 mr-auto">
    <a href="index.jsp" class="btn btn-secondary btn-block"><i
     class="fa fa-arrow-left"></i> Voltar Painel de Controle</a>
   </div>
   <div class="col-md-2"></div>
   <div class="col-md-5"></div>
  </div>
 </div>
</section>

<!-- PRODUTOS-->
<section id="produto">
 <div class="container">
  <div class="row">
   <div class="col">
    <div class="card">
     <div class="card-header">
      <h4>Produto</h4>
     </div>
     <div class="table table-responsive">
      <table id="tabela_produto" class="table table-striped table-bordered" cellspacing="0" width="100%">
       <thead class="thead-inverse">
        <tr>
         <th>Nº</th>
         <th style="padding-right:60px;">Produto</th>
         <th style="padding-right:120px;">Nome</th>
         <th style="padding-right:170px;">Descrição</th>
         
         <th style="padding-right:60px;">Preço</th>
         <th style="padding-right:40px;">Categoria</th>
         <th class="text-center" style="padding-right:40px;">Editar</th>
         <th class="text-center" style="padding-right:40px;">Excluir</th>
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
  </div>
 </div>
</section>

<jsp:include page="footer.jsp"></jsp:include>