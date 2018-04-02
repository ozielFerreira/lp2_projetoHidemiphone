<jsp:include page="header.jsp"></jsp:include>
<header id="main-header" class="py-2 bg-primary text-white">
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<h2>
					<i class="fa fa-user"></i> Editar Perfil
				</h2>
			</div>
		</div>
	</div>
</header>

<!-- ACTIONS -->
<section id="actions" class="py-4 mb-4 bg-faded">
	<div class="container">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-5 mr-auto">
				<a href="index.jsp" class="btn btn-secondary btn-block"><i
					class="fa fa-arrow-left"></i> Voltar - Painel de Controle</a>
			</div>

			<div class="col-md-5">
				<a href="index.html" class="btn btn-success btn-block"
					data-toggle="modal" data-target="#senhaModal"><i
					class="fa fa-lock"></i> Alterar Senha</a>
			</div>
			<div class="col-md-1"></div>
		</div>
	</div>
</section>

<!-- PROFILE EDIT -->
<section id="editar-perfil">
	<div class="container">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<div class="card">
					<div class="card-header">
						<h4>Editar Perfil Admin</h4>
					</div>
					<div class="card-block">
						${msg }
						<form action="editar_perfil" method="POST">
							<div class="form-group">
								<label for="nome" class="form-control-label">Nome</label> <input
									type="hidden" value="${admin.idUsuario }" name="id"> <input
									type="text" class="form-control" name="nomePerfil"
									value="${admin.nome }">
							</div>
							<div class="form-group">
								<label for="email" class="form-control-label">Email</label> <input
									type="text" class="form-control" value="${admin.email }"
									name="email">
							</div>
							<div class="form-group">
								<label for="senha" class="form-control-label">Senha</label> <input
									type="password" class="form-control" name="senha" id="senha"
									required="required">
							</div>
							<p id="t"></p>
							<hr>
							<div class="form-group">

								<button type="submit" id="conf" class="btn btn-success">Editar</button>
								<button type="reset" class="btn btn-danger">Limpar</button>
							</div>

						</form>
					</div>
				</div>
			</div>
			<div class="col-md-1"></div>
		</div>
	</div>
</section>


<!-- PASSWORD MODAL -->
<div class="modal fade" id="senhaModal" style="margin-top: 86px;">
	<div class="modal-dialog modal-lg">
		<div class="modal-content" style="background-color: #c7c7c7;">
			<div class="modal-header bg-default text-white">
				<h3 class="modal-title text-center" id="senhaModalLabel"
					style="color: #000; text-align: center !important;">Editar
					Senha</h3>
				<button class="close" data-dismiss="modal">
					<span>×</span>
				</button>
			</div>
			<form action="mudar_senha" method="POST">
				<div class="modal-body">

					<div class="form-group">
						<input type="hidden" name="id" value="${admin.idUsuario }">
						<label for="password" class="form-control-label editarSenha">Senha
							Atual *</label> <input type="password" name="senhaAtual"
							class="form-control" placeholder="Digite senha atual..." required>
					</div>
					<div class="form-group">
						<label for="password2" class="form-control-label editarSenha">Nova
							Senha *</label> <input type="password" name="senhaNova"
							class="form-control" placeholder="Digite nova senha..." required>
					</div>
					<div class="form-group">
						<label for="password2" class="form-control-label editarSenha">Confirmar
							Nova Senha *</label> <input type="password" name="confirmarSenhaNova"
							class="form-control" placeholder="Confirmar nova senha..."
							required>
					</div>

				</div>
				<div class="modal-footer">
					<button class="btn btn-success" type="submit">Editar Senha</button>
					<button class="btn btn-danger" type="reset" data-dismiss="modal">Limpar</button>
				</div>
			</form>
		</div>
	</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
<script>
	$(document).ready(function() {
		var hash = window.location.hash;
		if (hash.substring(1) == 'trocaSenha') {
			$('#senhaModal').modal('show');
		}
	});
</script>


