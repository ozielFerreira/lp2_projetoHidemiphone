 $(document).ready(function() {
        var brand = document.getElementById('frente');
        brand.className = 'anexo_upload-1';
        brand.onchange = function() {
            document.getElementById('fakeUploadImagem-1').value = this.value.substring(12);

        };

    // Source: http://stackoverflow.com/a/4459419/6396981
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            
            reader.onload = function(e) {
                $('.img-visualizar-1').attr('src', e.target.result);
            };
            reader.readAsDataURL(input.files[0]);
        }

    }

    $("#frente").change(function() {
        readURL(this);
    });
    
});

    $(document).ready(function() {
        var brand = document.getElementById('verso');
        brand.className = 'anexo_upload-2';
        brand.onchange = function() {
            document.getElementById('fakeUploadImagem-2').value = this.value.substring(12);

        };

    // Source: http://stackoverflow.com/a/4459419/6396981
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            
            reader.onload = function(e) {
                $('.img-visualizar-2').attr('src', e.target.result);
            };
            reader.readAsDataURL(input.files[0]);
        }

    }

    $("#verso").change(function() {
        readURL(this);
    });
    
});

    $(document).ready(function() {
        var brand = document.getElementById('lateral');
        brand.className = 'anexo_upload-3';
        brand.onchange = function() {
            document.getElementById('fakeUploadImagem-3').value = this.value.substring(12);

        };

    // Source: http://stackoverflow.com/a/4459419/6396981
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            
            reader.onload = function(e) {
                $('.img-visualizar-3').attr('src', e.target.result);
            };
            reader.readAsDataURL(input.files[0]);
        }

    }

    $("#lateral").change(function() {
        readURL(this);
    });
    
});