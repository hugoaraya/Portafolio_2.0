function validarForm() {
    // 
    var verificar = true; 

    //       
    var tipo_servicio = document.getElementById("servicio");
    var habitacion = document.getElementById("habitacion").checked;
     var huesped = document.getElementById("huesped").checked;
    var error = document.getElementById("error");
     

    //
    //
    
      
    //
     if (habitacion===false)
      { 
        error.innerHTML = "Seleccione al menos una Habitacion.";
        habitacion.focus();
         verificar =  false; 
      } 
        else if(tipo_servicio.value === '0'){
         error.innerHTML = "Seleccione un Servicio.";
       tipo_servicio.focus();
        verificar = false;
        }
     else if (huesped===false)
      { 
        error.innerHTML = "Seleccione al menos un huesped.";
        huesped.focus();
         verificar =  false; 
      }
     
    //
    

    if (verificar) {
        //error.innerHTML = "Operacion Exitosa.";
        document.getElementById("huesped_habitacion").submit();
    }
}
window.onload = function () {
    var botonEnviar;
    botonEnviar = document.huesped_habitacion.btn_enviar;
    botonEnviar.onclick = validarForm();
};