<%@ page contentType="text/html; charset=ISO-8859-1" language="java" import="java.sql.*" errorPage="404.jsp" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <!-- Meta, title, CSS, favicons, etc. -->
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">
  
  <link rel="icon" type="image/png" sizes="32x32" href="img/favicon-32x32.png">

  <title>HidemiPhone | Admin</title>

  <!-- Bootstrap -->
  <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Font Awesome -->
  <link href="bootstrap/css/font-awesome.min.css" rel="stylesheet">
  <!-- NProgress -->
  <link href="bootstrap/css/nprogress.css" rel="stylesheet">
  <!-- Animate.css -->
  <link href="bootstrap/css/animate.min.css" rel="stylesheet">

  <!-- Custom Theme Style -->
  <link href="bootstrap/css/custom.min.css" rel="stylesheet">
  
  <script>
$(function(){
	$('.close').click(function(){
		$('.alert').hide();
	});
});
</script>
</head>
<body class="login" style="background:;">
  <div>
    <a class="hiddenanchor" id="signup"></a>
    <a class="hiddenanchor" id="signin"></a>

    <div class="login_wrapper" style="margin-top:80px;">
      <h1 class="text-center">Painel Admistrativo</h1>
      <div class="animate form login_form">
        <section class="login_content">

          <form action="login" name="formlogin" id="login" method="post">
            <h1> Login </h1>
            <div>
              <input type="text" name="ademail" class="form-control" placeholder="Digite seu email..." required="" />
            </div>
            <div>
              <input type="password" name="adsenha" class="form-control" placeholder="Digite sua senha..." required="" />
            </div>
            <div>
              <button type="submit" class="btn btn-default submit"> Entrar</button>
            </div>

            <div class="clearfix"></div>

            <div class="separator">
              <p class="change_link">Esqueceu sua senha, clique aqui!
                <a href="#signup" class="to_register"> Recuperar senha</a>
              </p>
				<br>
			${conf }
              <div class="clearfix"></div>
              <br />

              <div>
                <img class="img img-responsive" src="img/logo-login.png" alt="Hidemiphone" style="width:35%;margin:0 auto;margin-left:105px;">
                <p><a href="https://www.hidemiphone.com.br" target="_blank" title="hidemiphone">&copy;2017 Todos direitos reservados </a><br>| <br>Desenvolvida pela Turma <br>Técnico em Informática Senac Niterói 2016.3</p>
              </div>
              <hr>
              ${msg }
            </div>
          </form>
        </section>
      </div>

      <div id="register" class="animate form registration_form">
        <section class="login_content">
          <div class="conteudo">
            <h1> Recuperar senha </h1>
            <!-- <div>
              <input type="email" class="form-control" placeholder="Digite seu email..." required="" />
            </div> -->
            <div>
              <p>Não lembrou da senha, clique aqui!
                <a href="solicita" class="to_register"> Solicitar senha </a>
              </p>
            </div>
			
            <div class="clearfix"></div>

            <div class="separator">
              <a class="btn btn-default submit" href="#signin"> Login </a>
              <div class="clearfix"></div>
              <br />

              <div>
                <img class="img img-responsive" src="img/logo-login.png" alt="Hidemiphone" style="width:35%;margin:0 auto;margin-left:105px;">
                 <p><a href="https://www.hidemiphone.com.br" target="_blank" title="hidemiphone">&copy;2017 Todos direitos reservados </a><br>| <br>Desenvolvida pela Turma <br>Técnico em Informática Senac Niterói 2016.3</p>
              </div>
            </div>
          </div>
        </section>
      </div>
    </div>
  </div>
  <script src="js/jquery.min.js"></script>
  
  <script src="js/bootstrap.min.js"></script>
  
	<script>
		$(function() {
			$("#esquecisenha").on(
					'click',
					function() {
						var email = $("#email").val();
						if (email.length == 0) {
							$("resp").html('');
						} else {
							$(this).hide();

							$.post('EsqueciSenha', {
								email : email
							}, function(resultado) {
								$("#resp").html(
										'<div class="alert alert-info">'
												+ resultado + "</div>");
								$("#esquecisenha").show();
							});
						}
						return false;

					});
		});
	</script>

  <script>
$(function(){
	$('#conf').fadeOut(10000);
});
</script>
</body>
</html>
