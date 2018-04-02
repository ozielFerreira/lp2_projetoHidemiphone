/* Mostra imagem produto */

 $(document).ready(function() {
        var brand = document.getElementById('imagem_produto');
        brand.className = 'upload-1';
        brand.onchange = function() {
            document.getElementById('fakeUpImagem-1').value = this.value.substring(12);

        };

    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            
            reader.onload = function(e) {
                $('.img-mostrar-2').attr('src', e.target.result);
            };
            reader.readAsDataURL(input.files[0]);
        }

    }

    $("#imagem_produto").change(function() {
        readURL(this);
    });
    
});

 