function validarForm() {
    // 
    var verificar = true;
    var expRegNombre = /^[a-zA-ZÑñÁáÉéÍíÓóÚú\s,]+$/;
    //   
    var nombre = document.getElementById("nombre");
    var fechaInicio = document.getElementById("fechaInicio").value;
    var fechaFin = document.getElementById("fechaFin").value;
    var error = document.getElementById("error");
    //

    if (!nombre.value) {
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
    else if (!fechaInicio) {
        error.innerHTML = "Debe seleccionar una fecha Inicio.";
        fechaInicio.focus();
        verificar = false;
    } else if (!fechaFin) {
        error.innerHTML = "Debe seleccionar una fecha Fin.";
        fechaFin.focus();
        verificar = false;
    }

    if (verificar) {
        error.innerHTML = "Operacion Exitosa.";
        document.getElementById("agregar_minuta").submit();
    }
}


window.onload = function () {
    var botonEnviar;
    botonEnviar = document.agregar_minuta.btn_enviar;
    botonEnviar.onclick = validarForm();
};
