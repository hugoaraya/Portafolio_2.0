function validarForm() {
    // 
    var verificar = true; 

    //       
    var numtrab = document.getElementById("numtrab");
    var error = document.getElementById("error");
      var fechaInicio = document.getElementById("fechaInicio").value;
    var fechaFin = document.getElementById("fechaFin").value;

    //
    //
    
      if(numtrab.value === '0'){
         error.innerHTML = "Seleccione Cantidad Trabajadores.";
       numtrab.focus();
        verificar = false;
        }
    //
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
        //error.innerHTML = "Operacion Exitosa.";
        document.getElementById("steps").submit();
    }
}
window.onload = function () {
    var botonEnviar;
    botonEnviar = document.steps.btn_enviar;
    botonEnviar.onclick = validarForm();
};