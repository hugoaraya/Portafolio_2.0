function validarForm(){
    // 
    var verificar = true;
    var expRegNombre =/^[a-zA-ZÑñÁáÉéÍíÓóÚú\s,]+$/;
    //   
    var nombre = document.getElementById("nombre");
    var fechaInicio = document.getElementById("fechaInicio").value;
    var fechaFin = document.getElementById("fechaFin").value;
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
   //
   else if(!fechaInicio){
       alert("Debe seleccionar una fecha Inicio.");
       fechaInicio.focus();
       verificar = false;
   } 
  else if(!fechaFin){
       alert("Debe seleccionar una fecha Fin.");
       fechaFin.focus();
       verificar = false;
   } 
   
    if(verificar){
        alert("Operacion Exitosa.");
        document.getElementById("agregar_minuta").submit();
    }
}


window.onload = function (){
    var botonEnviar; 
    botonEnviar = document.agregar_minuta.btn_enviar; 
    botonEnviar.onclick = validarForm();
};
