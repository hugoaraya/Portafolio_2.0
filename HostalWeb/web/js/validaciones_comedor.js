function validarForm(){
    // 
    var verificar = true;
    var expRegNombre =/^[a-zA-ZÑñÁáÉéÍíÓóÚú\s,]+$/;
    //   
    var nombre = document.getElementById("nombre");  
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
  
    if(verificar){
         error.innerHTML = "Operacion Exitosa.";
        document.getElementById("agregar_comedor").submit();
    }
}



window.onload = function (){
    var botonEnviar;
    botonEnviar = document.agregar_comedor.btn_enviar; 
    botonEnviar.onclick = validarForm();
};