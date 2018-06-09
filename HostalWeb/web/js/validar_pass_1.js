function validarForm() {
    // 
    var verificar = true;

    var pass = document.getElementById("pass");
    var formulario = document.getElementById("cambiar_clave");
    var repass = document.getElementById("repass");
    var regex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}$/;
    //   
   var error = document.getElementById("error");
    //
    if (!pass.value) {    
        error.innerHTML ='Contraseña No puede ir en blanco.';
            pass.focus();
            verificar = false;              
    }
    else  if (pass.value.length < 4) {
             error.innerHTML ='Contraseña debe tener más de 4 caracteres';
            formulario.pass.focus();
            verificar = false;
        }
     else  if (regex.exec(pass.value)) {
             error.innerHTML ='Usar al menos una mayuscula, una minuscula y números';
            pass.focus();
            verificar = false;
        }

    //validar que las constraseñas coincidan
    else if (pass.value !== repass.value) {
        error.innerHTML ='Contraseñas NO coinciden, debe digitar la misma contraseña';
        repass.focus();
        verificar = false;
    }

    //
    if (verificar) {
        error.innerHTML ="Se cambio la clave con Exito.";
        document.getElementById("cambiar_clave").submit();
    }
}

window.onload = function () {
    var botonEnviar;
    botonEnviar = document.cambiar_clave.btn_enviar;
    botonEnviar.onclick = validarForm();
};