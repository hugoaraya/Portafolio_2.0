function validarForm(){
    // 
    var verificar = true;
    var expRegNombre =/^[a-zA-ZÑñÁáÉéÍíÓóÚú\s,]+$/;
    //   
    var nombre = document.getElementById("nombre");  
    //
    
    if(!nombre.value){
       alert("El campo Nombre es requerido .");
       nombre.focus();
       verificar = false;
   }
   else if(nombre.value.length < 3){
       alert("El campo debe tener un largo mayor a 3 caracteres .");
       nombre.focus();
       verificar = false;
   }
   else if(!expRegNombre.exec(nombre.value)){
       alert("Solo se acepta letras y espacios.");
       nombre.focus();
       verificar = false;
   }  
  
    if(verificar){
        alert("Operacion Exitosa.");
        document.getElementById("agregar_comedor").submit();
    }
}

function limpiarForm(){
    document.getElementById("agregar_comedor").reset();
}

window.onload = function (){
    var botonEnviar, botonlimpiar;
    botonlimpiar = document.getElementById("btn_limpiar");
    botonlimpiar.onclick = limpiarForm;    
    botonEnviar = document.agregar_comedor.btn_enviar; 
    botonEnviar.onclick = validarForm();
};