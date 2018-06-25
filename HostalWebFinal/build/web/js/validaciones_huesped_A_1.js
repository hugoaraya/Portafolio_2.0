function validarForm() {
    // 
    var verificar = true;
    var expRegNombre = /^[a-zA-ZÑñÁáÉéÍíÓóÚú\s,]+$/;
    var regexCorreo = /^[a-zA-Z0-9]+\@[a-zA-Z]+\.[a-zA-Z]+$/;
    var regexDv = /^[k0-9]/i;

    //    
    var rut = document.getElementById("rut");
    var dv = document.getElementById("dv");
    var nombre = document.getElementById("nombre");
    var apellido = document.getElementById("apellido");
     var cargo = document.getElementById('cargo'); 
    var correo = document.getElementById("correo");
    var telefono = document.getElementById("telefono");
    var error = document.getElementById("error");
     var estado = document.getElementById('estado'); 

    //
    //
    if (!rut.value) {
        error.innerHTML = "El campo Rut es requerido.";
        rut.focus();
        verificar = false;
    } else if (isNaN(rut.value)) {
        error.innerHTML = "El campo debe ser numerico.";
        rut.focus();
        verificar = false;
    } else if (rut.value < 6 && rut.value > 8) {
        error.innerHTML = "Ingrese largo correcto.";
        rut.focus();
        verificar = false;
    }
    //
    else if (!dv.value) {
        error.innerHTML = "El campo dv es requerido.";
        dv.focus();
        verificar = false;
    } else if (!regexDv.exec(dv.value)) {
        error.innerHTML = "Ingrese un digito verificador correcto.";
        dv.focus();
        verificar = false;
    }
    //
    else if (!nombre.value) {
        error.innerHTML = "El campo Nombre es requerido .";
        nombre.focus();
        verificar = false;
    } else if (nombre.value.length < 3) {
        error.innerHTML = "El campo debe tener un largo mayor a 3 caracteres .";
        nombre.focus();
        verificar = false;
    } else if (!expRegNombre.exec(nombre.value)) {
        error.innerHTML = "Solo se acepta letras y espacios.";
        nombre.focus();
        verificar = false;
    }
    //   
    else if (!apellido.value) {
        error.innerHTML = "El campo Apellido es requerido .";
        apellido.focus();
        verificar = false;
    } else if (apellido.value.length < 3) {
        error.innerHTML = "El campo debe tener un largo mayor a 3 caracteres .";
        apellido.focus();
        verificar = false;
    } else if (!expRegNombre.exec(apellido.value)) {
        error.innerHTML = "Solo se acepta letras y espacios.";
        apellido.focus();
        verificar = false;
    }
    //
     else if(cargo.value === '0'){
         error.innerHTML = "Seleccione un cargo.";
       cargo.focus();
        verificar = false;
        }
    //
    else if (!correo.value) {
        error.innerHTML = "El campo Correo es requerido .";
        correo.focus();
        verificar = false;
    } else if (correo.value.length < 3) {
        error.innerHTML = "El campo debe tener un largo mayor a 3 caracteres .";
        correo.focus();
        verificar = false;
    } else if (!regexCorreo.exec(correo.value)) {
        error.innerHTML = "Ingrese un Correo Correcto.";
        correo.focus();
        verificar = false;
    }
    //
    else if (!telefono.value) {
        error.innerHTML = "El campo telefono es requerido.";
        telefono.focus();
        verificar = false;
    } else if (isNaN(telefono.value)) {
        error.innerHTML = "El campo debe ser numerico.";
        telefono.focus();
        verificar = false;
    } else if (telefono.value <= 0) {
        error.innerHTML = "El telefono debe ser mayor a 0.";
        telefono.focus();
        verificar = false;
    }
    //
     else if(estado.value === '0'){
         error.innerHTML = "Seleccione un estado.";
       estado.focus();
       verificar = false;
        }
    //

    if (verificar) {
        error.innerHTML = "Operacion Exitosa.";
        document.getElementById("agregar_huesped").submit();
    }
}
window.onload = function () {
    var botonEnviar;
    botonEnviar = document.agregar_huesped.btn_enviar;
    botonEnviar.onclick = validarForm();
};