 $(document).ready(function() {
        var brand = document.getElementById('servico_imagem');
        brand.className = 'anexo_upload-1';
        brand.onchange = function() {
            document.getElementById('fakeUploadImagem-1').value = this.value.substring(12);

        };

    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            
            reader.onload = function(e) {
                $('.img-mostrar-1').attr('src', e.target.result);
            };
            reader.readAsDataURL(input.files[0]);
        }

    }

    $("#servico_imagem").change(function() {
        readURL(this);
    });
    
});
 