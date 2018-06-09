function validarForm(){
    // 
    var verificar = true;
    var expRegNombre =/^[a-zA-ZÑñÁáÉéÍíÓóÚú\s,]+$/;
    //
    var formulario = document.getElementById("agregar_habitacion_form");
    var nombre = document.getElementById("nombre");
    var accesorios = document.getElementById("accesorios");
    var precio = document.getElementById("precio");       
    var descripcion = document.getElementById("descripcion");
     var error = document.getElementById("error");
    //
    
    if(!nombre.value){
       error.innerHTML = "El campo Nombre es requerido .";
       nombre.focus();
       verificar = false;
   }
   else if(nombre.value.length < 3){
       error.innerHTML = "El campo debe tener un largo mayor a 3 caracteres .";
       nombre.focus();
       verificar = false;
   }
   else if(!expRegNombre.exec(nombre.value)){
       error.innerHTML = "Solo se acepta letras y espacios.";
       nombre.focus();
       verificar = false;
   }  
   //
    else  if(!accesorios.value){
       error.innerHTML = "El campo Accesorio es requerido.";
       accesorios.focus();
       verificar = false;
   }
   else if(accesorios.value.length < 1){
       error.innerHTML = "El campo debe tener un largo mayor a 1 caracteres .";
       nombre.focus();
       verificar = false;
   }
   else if(!expRegNombre.exec(accesorios.value)){
       error.innerHTML = "Solo se acepta letras y espacios.";
       nombre.focus();
       verificar = false;
   } 
   //
    else if(!precio.value){
       error.innerHTML = "El campo Precio es requerido.";
       precio.focus();
       verificar = false;
   }
   else if(isNaN(precio.value)){
      error.innerHTML = "El campo debe ser numerico.";
       precio.focus();
       verificar = false;
   }
    else if(precio.value <= 0){
      error.innerHTML = "El precio debe ser mayor a 0.";
       precio.focus();
       verificar = false;
   }
   //  
    else if(!descripcion.value){
       error.innerHTML = "El campo Descripcion es requerido.";
       descripcion.focus();
       verificar = false;
   }
   else if(descripcion.value.length < 1){
       error.innerHTML = "El campo debe tener un largo mayor a 1 caracteres .";
       nombre.focus();
       verificar = false;
   }
   
   //    
    if(verificar){
        error.innerHTML = "Operacion Exitosa.";
        document.getElementById("agregar_habitacion_form").submit();
    }
}

function limpiarForm(){
    document.getElementById("agregar_habitacion_form").reset();
}

window.onload = function (){
    var botonEnviar, botonlimpiar;
    botonlimpiar = document.getElementById("btn_limpiar");
    botonlimpiar.onclick = limpiarForm;    
    botonEnviar = document.agregar_habitacion_form.btn_enviar; 
    botonEnviar.onclick = validarForm();
};