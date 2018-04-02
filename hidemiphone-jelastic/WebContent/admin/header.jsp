<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="admin/404.jsp"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>HidemiPhone | Admin</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="description" content="">
  <meta name="author" content="">
  <script src="https://code.jquery.com/jquery-3.2.1.min.js"
	integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"
	integrity="sha256-VazP97ZCwtekAsvgPBSUwPFKdrwD3unUfSGVYrahUqU="
	crossorigin="anonymous"></script>
  
  <!-- ICONE FAVICON -->
  <link rel="icon" type="image/png" sizes="32x32" href="img/favicon-32x32.png">
  <!-- inserindo css do Font Awesome -->
  <link rel="stylesheet" href="bootstrap/css/font-awesome.min.css" media="all"/>
  <!-- inserindo css do Bootstrap -->
  <link rel="stylesheet" href="bootstrap/css/bootstrap.css" media="all"/>
  <link rel="stylesheet" href="bootstrap/css/style.css">
  <link rel="stylesheet" href="bootstrap/css/efeito-imagem.css" />
  
  
  <!-- DataTables CSS -->
    <link href="bootstrap/css/dataTables.bootstrap4.min.css" rel="stylesheet">
    <script type="text/javascript" >

        $(document).ready(function() {

            function limpa_formulário_cep() {
                // Limpa valores do formulário de cep.
                $("#rua").val("");
                $("#bairro").val("");
                $("#cidade").val("");
                $("#uf").val("");
                $("#ibge").val("");
            }
            
            //Quando o campo cep perde o foco.
            $("#cep").blur(function() {

                //Nova variável "cep" somente com dígitos.
                var cep = $(this).val().replace(/\D/g, '');

                //Verifica se campo cep possui valor informado.
                if (cep != "") {

                    //Expressão regular para validar o CEP.
                    var validacep = /^[0-9]{8}$/;

                    //Valida o formato do CEP.
                    if(validacep.test(cep)) {

                        //Preenche os campos com "..." enquanto consulta webservice.
                        $("#rua").val("...");
                        $("#bairro").val("...");
                        $("#cidade").val("...");
                        $("#uf").val("...");
                        $("#ibge").val("...");

                        //Consulta o webservice viacep.com.br/
                        $.getJSON("//viacep.com.br/ws/"+ cep +"/json/?callback=?", function(dados) {

                            if (!("erro" in dados)) {
                                //Atualiza os campos com os valores da consulta.
                                $("#rua").val(dados.logradouro);
                                $("#bairro").val(dados.bairro);
                                $("#cidade").val(dados.localidade);
                                $("#uf").val(dados.uf);
                                $("#ibge").val(dados.ibge);
                            } //end if.
                            else {
                                //CEP pesquisado não foi encontrado.
                                limpa_formulário_cep();
                                alert("CEP não encontrado.");
                            }
                        });
                    } //end if.
                    else {
                        //cep é inválido.
                        limpa_formulário_cep();
                        alert("Formato de CEP inválido.");
                    }
                } //end if.
                else {
                    //cep sem valor, limpa formulário.
                    limpa_formulário_cep();
                }
            });
        });

    </script>
    
        <script>
    $(function(){
	$('.close').click(function(){
		$('.alert').hide();
	});
});
</script>
  
<style type="text/css">
.alert-danger {
	color: rgb(252, 248, 227);
	background-color: rgba(255, 22, 27, 0.5);
	border-color: #444444;
}

.alert-success {
	color: #333;
	background-color: rgba(82, 255, 9, 0.45);
	border-color: #797979;
}

.alert-dismissable, .alert-dismissible {
	padding-right: 35px;
}

.alert {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
}

.alert-dismissable .close, .alert-dismissible .close {
	position: relative;
	top: -15px;
	right: -12px;
	color: inherit;
}

</style>

</head>
<body>
<div class="container-fluid">
<nav class="navbar navbar-toggleable-sm navbar-inverse bg-inverse p-0">
    <div class="container-fluid">
    <header id="main-header" class="py-2 bg-inverse text-white">
 <div class="container">
  <div class="row">
   <div class="col-md-6">
    <a href="index.jsp" class="navbar-brand"> <img class="img img-responsive" src="./img/logo-hidemi-header.png" alt="Hidemiphone" style="width:60%;margin:0 auto;"></a>

   </div>
  </div>
 </div>
</header>
    
      <button class="navbar-toggler navbar-toggler-right" data-toggle="collapse" data-target="#navbarNav">
        <span class="navbar-toggler-icon"></span>
      </button>
      
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
          <li class="nav-item px-2">
            <a href="index.jsp" class="nav-link active">Painel de Controle</a>
          </li>
          <!-- <li class="nav-item px-2">
             <a href="produto.jsp" class="nav-link">Produto</a>
          </li>-->
          
        </ul>
        <ul class="navbar-nav ml-auto">
          <li class="nav-item dropdown mr-3">
            <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown"> Produto</a>
            <div class="dropdown-menu">
              <a href="cadastrar_produto.jsp" class="dropdown-item">
                <i class="fa fa-cog"></i> Cadastrar Produto
              </a>

            <a href="produto.jsp" class="dropdown-item">
              <i class="fa fa-list-alt"></i> Lista de Produto
            </a>
            </div>
          </li>
        </ul>
        
        <ul class="navbar-nav ml-auto">
          <li class="nav-item dropdown mr-3">
            <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown"> Serviço</a>
            <div class="dropdown-menu">
              <a href="cadastrar_servico.jsp" class="dropdown-item">
                <i class="fa fa-cog"></i> Cadastrar Serviço
              </a>

            <a href="servico.jsp" class="dropdown-item">
              <i class="fa fa-list-alt"></i> Lista de Serviço
            </a>
            </div>
          </li>
        </ul>
        
        <ul class="navbar-nav ml-auto">
          <li class="nav-item dropdown mr-3">
            <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown"><i class="fa fa-users"></i> Cliente</a>
            <div class="dropdown-menu">
              <a href="cadastrar_cliente.jsp" class="dropdown-item">
                <i class="fa fa-cog"></i> Cadastrar Cliente
              </a>

            <a href="cliente.jsp" class="dropdown-item">
              <i class="fa fa-list-alt"></i> Lista de Cliente
            </a>
            </div>
          </li>
        </ul>
        
        <ul class="navbar-nav ml-auto">
          <li class="nav-item dropdown mr-3">
            <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> Bem vindo, ${admin.nome }!</a>
            <div class="dropdown-menu">
              <a href="perfil.jsp" class="dropdown-item">
                <i class="fa fa-user-circle"></i> Perfil
              </a>
              <a href="Logout" class="dropdown-item">
              <i class="fa fa-user-times"></i> Sair
            </a>
            </div>
          </li>
         <!--  
          <li class="nav-item">
            <a href="../index.jsp" class="nav-link">
              <i class="fa fa-user-times"></i> Sair
            </a>
          </li>
         --> 
        </ul>
        
      </div>
    </div>
  </nav>
  	