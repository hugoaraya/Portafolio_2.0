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
   else if(!apellido.value){
       alert("El campo Apellido es requerido .");
       apellido.focus();
       verificar = false;
   }
   else if(apellido.value.length < 3){
       alert("El campo debe tener un largo mayor a 3 caracteres .");
       apellido.focus();
       verificar = false;
   }
   else if(!expRegNombre.exec(apellido.value)){
       alert("Solo se acepta letras y espacios.");
       apellido.focus();
       verificar = false;
   }  
   //
    else  if(!cargo.value){
       alert("El campo Cargo es requerido.");
       cargo.focus();
       verificar = false;
   }
   else if(cargo.value.length < 4){
       alert("El campo debe tener un largo mayor a 4 caracteres .");
       cargo.focus();
       verificar = false;
   }
   else if(!expRegNombre.exec(cargo.value)){
       alert("Solo se acepta letras y espacios.");
       cargo.focus();
       verificar = false;
   } 
   //
   else if(!correo.value){
       alert("El campo Correo es requerido .");
       correo.focus();
       verificar = false;
   }
   else if(correo.value.length < 3){
       alert("El campo debe tener un largo mayor a 3 caracteres .");
       correo.focus();
       verificar = false;
   }
   else if(!regexCorreo.exec(correo.value)){
       alert("Ingrese un Correo Correcto.");
       correo.focus();
       verificar = false;
   }
   //
    else if(!telefono.value){
       alert("El campo telefono es requerido.");
       telefono.focus();
       verificar = false;
   }
   else if(isNaN(telefono.value)){
       alert("El campo debe ser numerico.");
       telefono.focus();
       verificar = false;
   }
    else if(telefono.value <= 0){
       alert("El telefono debe ser mayor a 0.");
       telefono.focus();
       verificar = false;
   } 
  //
  
    if(verificar){
        alert("Operacion Exitosa.");
        document.getElementById("agregar_huesped").submit();
    }
}
window.onload = function (){
    var botonEnviar;   
    botonEnviar = document.agregar_huesped.btn_enviar; 
    botonEnviar.onclick = validarForm();
};