<%@page import="persistencia.ClienteDao"%>
<jsp:include page="header.jsp"></jsp:include>

<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:useBean id="prodCli" class="managed.ClienteManaged"></jsp:useBean>
<jsp:useBean id="prodTel" class="managed.TelefoneManaged"></jsp:useBean>
<div> 
  <header id="main-header" class="py-2 bg-warning text-white">
    <div class="container">
      <div class="row">
        <div class="col-md-6">
          <h2><i class="fa fa-users"></i> Cliente</h2>
        </div>
      </div>
    </div>
  </header>
</div>

<style>
<!--
table.dataTable thead>tr>th.sorting_asc, table.dataTable thead>tr>th.sorting_desc, table.dataTable thead>tr>th.sorting, table.dataTable thead>tr>td.sorting_asc, table.dataTable thead>tr>td.sorting_desc, table.dataTable thead>tr>td.sorting {
  padding-rigth:50px;
-->
</style>
  <!-- ACTIONS -->
  <section id="actions" class="py-4 mb-4 bg-faded">
    <div class="container">
      <div class="row">
       <!-- <div class="col-md-6 offset-md-6">
          <div class="input-group">
            <input type="text" class="form-control" placeholder="Pesquisar...">
            <span class="input-group-btn">
              <button class="btn btn-warning">Buscar</button>
            </span>
          </div>
        </div> -->
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

  <!-- POSTS -->
  <section id="clientes">
    <div class="container">
      <div class="row">
        <div class="col">
          <div class="card">
            <div class="card-header">
              <h4>Cliente</h4>
            </div>
            ${msg }
             <div class="table table-responsive">
              <table id="tabela_cliente" class="table table-striped table-bordered" cellspacing="0" width="100%">
         <thead class="thead-inverse">
                  <tr>
                    <th style="padding-right:50px;">Nº</th>
                    <th style="padding-right:120px;">Nome</th>
                    <th>Email</th>
                    <th style="padding-right:70px;">Telefone</th>
                    <th style="padding-right:70px;">CEP</th>
                    <th style="padding-right:150px;">Endereço</th>
                    <th>Nº</th>
                    <th>Bairro</th>
                    <th>Cidade</th>
                    <th class="text-center" style="padding-right:40px;">Editar</th>
                    <th class="text-center" style="padding-right:40px;">Excluir</th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach items="${prodCli.listaCli }" var="cli">
                
                  <tr>
    				<c:set value="${fn:replace(prodTel.getListaTel(cli.idUsuario), '[','')}" var="tel"></c:set>
    				<c:set value="${fn:replace(tel, ']','')}" var="tel"></c:set>
    				<c:set value="${fn:replace(tel, ',','<br>')}" var="tel"></c:set>
                    <td scope="row">${cli.idUsuario }</td>
                   <td style="width:100%;">${cli.nome }</td>
                   <td>${cli.email }</td>
               		<td>${tel }</td>
                   <td>${cli.cep }</td>
                   <td>${cli.endereco.logradouro } </td>
                   <td>${cli.endereco.numero }</td>
                   <td>${cli.endereco.bairro }</td>
                   <td>${cli.endereco.cidade }</td>
                    <td><a href="editar_cliente?id=${cli.idUsuario }" class="btn btn-secondary"><i class="fa fa-angle-double-right"></i> Editar</a></td>
                    <td><a href="deletar_cliente?id=${cli.idUsuario }" class="btn btn-danger" onclick="return window.confirm('Deseja Realmente Excluir ${cli.nome} da sua lista de clientes?')"><i class="fa fa-trash"></i> Excluir</a></td>
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

