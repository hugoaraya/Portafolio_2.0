function validarForm(){
    // 
    var verificar = true;
    var expRegNombre =/^[a-zA-ZÑñÁáÉéÍíÓóÚú\s,]+$/;
   var regexCorreo = /^[a-zA-Z0-9]+\@[a-zA-Z]+\.[a-zA-Z]+$/;
    //    
  
    var nombre = document.getElementById("nombre");
    var apellido = document.getElementById("apellido");
    var cargo = document.getElementById("cargo");
    var correo = document.getElementById("correo");
    var telefono = document.getElementById("telefono");       
    var error = document.getElementById("error");
   
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
   else if(!apellido.value){
        error.innerHTML = "El campo Apellido es requerido .";
       apellido.focus();
       verificar = false;
   }
   else if(apellido.value.length < 3){
        error.innerHTML = "El campo debe tener un largo mayor a 3 caracteres .";
       apellido.focus();
       verificar = false;
   }
   else if(!expRegNombre.exec(apellido.value)){
        error.innerHTML = "Solo se acepta letras y espacios.";
       apellido.focus();
       verificar = false;
   }  
   //
    else  if(!cargo.value){
        error.innerHTML = "El campo Cargo es requerido.";
       cargo.focus();
       verificar = false;
   }
   else if(cargo.value.length < 4){
        error.innerHTML = "El campo debe tener un largo mayor a 4 caracteres .";
       cargo.focus();
       verificar = false;
   }
   else if(!expRegNombre.exec(cargo.value)){
        error.innerHTML = "Solo se acepta letras y espacios.";
       cargo.focus();
       verificar = false;
   } 
   //
   else if(!correo.value){
        error.innerHTML = "El campo Correo es requerido .";
       correo.focus();
       verificar = false;
   }
   else if(correo.value.length < 3){
       error.innerHTML = "El campo debe tener un largo mayor a 3 caracteres .";
       correo.focus();
       verificar = false;
   }
   else if(!regexCorreo.exec(correo.value)){
        error.innerHTML = "Ingrese un Correo Correcto.";
       correo.focus();
       verificar = false;
   }
   //
    else if(!telefono.value){
        error.innerHTML = "El campo telefono es requerido.";
       telefono.focus();
       verificar = false;
   }
   else if(isNaN(telefono.value)){
        error.innerHTML = "El campo debe ser numerico.";
       telefono.focus();
       verificar = false;
   }
    else if(telefono.value <= 0){
        error.innerHTML = "El telefono debe ser mayor a 0.";
       telefono.focus();
       verificar = false;
   } 
  //
  
    if(verificar){
         error.innerHTML = "Operacion Exitosa.";
        document.getElementById("agregar_huesped").submit();
    }
}
window.onload = function (){
    var botonEnviar;   
    botonEnviar = document.agregar_huesped.btn_enviar; 
    botonEnviar.onclick = validarForm();
};