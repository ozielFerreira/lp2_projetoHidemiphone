
<br>
<div class="footer">
    <footer id="main-footer" class="bg-inverse text-white mt-5 p-5">
      <div class="container" id="footer">
        <a href="#myPage" title="To Top">
          <span class="glyphicon glyphicon-chevron-up"></span>
        </a>
        <!-- <p class="text-muted">Place sticky footer content here.</p> -->
        <p class="lead text-center">Copyright &copy; 2017 HidemiPhone</p>
      </div>
    </footer>
</div>
</div>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="http://code.jquery.com/qunit/qunit-1.11.0.js"></script>
	<script src="bootstrap/js/jquery-2.1.js"></script>
	<script src="bootstrap/js/jquery.mask.js"></script>
	 
	<script src="bootstrap/js/jquery.min.js"></script>
	<script src="bootstrap/js/tether.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	
	<script src="bootstrap/js/jquery.dataTables.min.js"></script>
	<script src="bootstrap/js/dataTables.bootstrap4.min.js"></script>

<script>
  $(document).ready(function() {
    $('#tabela_produto').DataTable({
      "language": {
            "lengthMenu": "<div style='margin-left:40px;'>Mostrando _MENU_ registros por página</div>",
            "zeroRecords": "<div style='margin-left:40px;'>Nada encontrado</div>",
            "info": "<div style='margin-left:40px;'>Mostrando _START_ de _END_ no total de _TOTAL_ registros</div>",
            "infoEmpty": "<div style='margin-left:40px;'>Nenhum registro disponível</div>",
            "infoFiltered": "<div style='margin-left:40px;'>(filtrado de _MAX_ registros no total)</div>"
        }
    });
    $('#tabela_servico').DataTable({
        "language": {
              "lengthMenu": "<div style='margin-left:40px;'>Mostrando _MENU_ registros por página</div>",
              "zeroRecords": "<div style='margin-left:40px;'>Nada encontrado</div>",
              "info": "<div style='margin-left:40px;'>Mostrando _START_ de _END_ no total de _TOTAL_ registros</div>",
              "infoEmpty": "<div style='margin-left:40px;'>Nenhum registro disponível</div>",
              "infoFiltered": "<div style='margin-left:40px;'>(filtrado de _MAX_ registros no total)</div>"
          }
      });
    $('#tabela_cliente').DataTable({
        "language": {
              "lengthMenu": "<div style='margin-left:40px;'>Mostrando _MENU_ registros por página</div>",
              "zeroRecords": "<div style='margin-left:40px;'>Nada encontrado</div>",
              "info": "<div style='margin-left:40px;'>Mostrando _START_ de _END_ no total de _TOTAL_ registros</div>",
              "infoEmpty": "<div style='margin-left:40px;'>Nenhum registro disponível</div>",
              "infoFiltered": "<div style='margin-left:40px;'>(filtrado de _MAX_ registros no total)</div>"
          }
      });
});

</script>

<script>
$( document ).on( 'click', '.btn-add', function ( event ) {
	event.preventDefault();

	var field = $(this).closest( '.form-group' );
	var field_new = field.clone();

	$(this)
		.toggleClass( 'btn-success' )
		.toggleClass( 'btn-add' )
		.toggleClass( 'btn-danger' )
		.toggleClass( 'btn-remove' )
		.html( '<span class="fa fa-minus"></span>' );

	field_new.find( 'input' ).val( '' );
	field_new.insertAfter( field );
} );

$( document ).on( 'click', '.btn-remove', function ( event ) {
	event.preventDefault();
	$(this).closest( '.form-group' ).remove();
} );
</script>


<script>
$(function(){
	$('#div').fadeOut(5000);
});
</script>

<script src="bootstrap/js/efeito-mostrar-imagem.js"></script>
<script src="bootstrap/js/efeito-mostrar-imagem-produto.js"></script>
</body>
</html>