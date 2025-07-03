  const form = document.querySelector('.contact-form');

  form.addEventListener('submit', function(event) {
    event.preventDefault(); 

    Swal.fire({
      icon: 'success',
      title: 'Mensaje enviado',
      text: 'Gracias por contactarnos. Te responderemos pronto.',
      confirmButtonColor: '#e74c3c'
    });

    form.reset(); 
  });