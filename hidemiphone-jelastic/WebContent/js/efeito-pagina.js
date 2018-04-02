  $(document).ready(function(){
  // Add smooth scrolling to all links in navbar + footer link
  $(".navbar a, footer a[href='#myPage']").on('click', function(event) {
    // Make sure this.hash has a value before overriding default behavior
    if (this.hash !== "") {
      // Prevent default anchor click behavior
      event.preventDefault();

      // Store hash
      var hash = this.hash;

      // Using jQuery's animate() method to add smooth page scroll
      // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
      $('html, body').animate({
        scrollTop: $(hash).offset().top
      }, 8000, function(){
   
        // Add hash (#) to URL when done scrolling (default click behavior)
        window.location.hash = hash;
      });
    } // End if
  });
  
  $(window).scroll(function() {
    $(".slideanim").each(function(){
      var pos = $(this).offset().top ;

      var winTop = $(window).scrollTop();
        if (pos < winTop + 600) {
          $(this).addClass("slide");
        }
    });
  });
});
  
//EFEITO PARA ECONDER OS ICONES DE REDES SOCIAIS
$(document).ready(function(){
    $("#botao_fixo").click(function(){
     $(".Rsocial").fadeToggle(2000);

     $(".Rsocial").on("click", function(){
      $(this).fadeOut (2000).on('hide');

    });

   });
  });

// EFEITO DO POPOVER NO ICONE COMPARTILHAR REDES SOCIAIS
$(function () {
  $('[data-toggle="popover"]').popover();
  console.log($('[data-toggle="popover"]').length);
});
