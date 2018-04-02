<jsp:include page="header.jsp"></jsp:include>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:useBean id="servBean" class="managed.ServicoManaged"></jsp:useBean>
  <header id="main-header" class="py-2 bg-success text-white">
    <div class="container">
      <div class="row">
        <div class="col-md-6">
          <h2><i class="fa fa-wrench" aria-hidden="true"></i> Serviço</h2>
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
  <!--  -->
  <section id="actions" class="py-4 mb-4 bg-faded">
    <div class="container">
      <div class="row">
      <!--  <div class="col-md-6 offset-md-6">
          <div class="input-group">
            <input type="text" class="form-control" placeholder="Pesquisar...">
            <span class="input-group-btn">
              <button class="btn btn-success">Buscar</button>
            </span>
          </div>
        </div>  --> 
        
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

  <!-- SERVIÇO-->
  <section id="servico">
    <div class="container">
      <div class="row">
        <div class="col">
          <div class="card">
            <div class="card-header">
            ${msg }
              <h4>Serviço</h4>
            </div>
             <div class="table table-responsive">
             
              <table id="tabela_servico" class="table table-striped table-bordered" cellspacing="0" width="100%">
         <thead class="thead-inverse">
                  <tr>
                    <th>Nº</th>
			        <th style="padding-right:60px;">Serviço</th>
			        <th style="padding-right:120px;">Nome</th>
			        <th style="padding-right:150px;">Descrição</th>
			        <th style="padding-right:60px;">Preço</th>
			        <th style="padding-right:50px;">Categoria</th>
			        <th class="text-center" style="padding-right:40px;">Editar</th>
			        <th class="text-center" style="padding-right:40px;">Excluir</th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach items="${servBean.listaServ }" var="s">
                  <tr>
                   	<td scope="row">${s.getCodigo() }</td>
                   	<td><img src='../upFotos/${s.foto }' style="width:70px;"></td>
                    <td>${s.nome }</td>
                
                   <td>
                    <c:forEach items="${servBean.getListaDesc(s.getCodigo())}" var="d">
                   		 ${d.descricao }<br>
                    </c:forEach>
                    </td>
                    <td>
                      <c:forEach items="${servBean.getListaDesc(s.getCodigo())}" var="d">
                    	<fmt:formatNumber value="${d.valor }" type="currency"></fmt:formatNumber><br>
                   	 </c:forEach>
                    </td>
                    <td>${s.categoria }</td>
                    <td><a href="editar_servico?cod=${s.getCodigo() }" class="btn btn-secondary"><i class="fa fa-angle-double-right"></i> Editar</a></td>
                    <td><a href="excluir_servico?cod=${s.getCodigo() }&f=${s.foto}" class="btn btn-danger"  onclick="return window.confirm('Deseja realmente excluir esse item ?')"><i class="fa fa-trash"></i> Excluir</a></td>
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