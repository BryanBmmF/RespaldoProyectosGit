/**
 * Funcion utilizada para cargar un archivo
 */

function processFiles(id) {
        var archivos=document.getElementById(id).files;
        var areaDeText = document.getElementById("areaDeTexto");
        var archivo = archivos[0];
        if (areaDeText.value=="") {
            var reader = new FileReader();
            reader.onload = function (e) {
                // Cuando éste evento se dispara, los datos están ya disponibles.
                areaDeText.textContent = e.target.result;
            };
            reader.readAsText(archivo);
        
        }else{
            alert("Pulse Reset Para Limpiar Area de Texto");
        }
        
}
//funcion que resetea los valores predeterminados
function resetTextArea() {
   var areaDeTexto = document.getElementById("areaDeTexto");
   areaDeTexto= areaDeTexto.textContent="";
   areaDeTexto.reset();   
}


