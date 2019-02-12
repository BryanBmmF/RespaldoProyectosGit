/* 
 * funciones requeridas para descargar un archivo
 */

 function descargarArchivo(contenidoEnBlob, nombreArchivo) {
    //creamos un FileReader para leer el Blob
    var reader = new FileReader();
    //Definimos la función que manejará el archivo
    //una vez haya terminado de leerlo
    reader.onload = function (event) {
        //Usaremos un link para iniciar la descarga 
        var save = document.createElement('a');
        save.href = event.target.result;
        save.target = '_blank';
        //Truco: así le damos el nombre al archivo 
        save.download = nombreArchivo || 'archivo.dat';
        var clicEvent = new MouseEvent('click', {
            'view': window,
            'bubbles': true,
            'cancelable': true
        });
        //Simulamos un clic del usuario
        //no es necesario agregar el link al DOM.
        save.dispatchEvent(clicEvent);
        //Y liberamos recursos...
        (window.URL || window.webkitURL).revokeObjectURL(save.href);
    };
    //Leemos el blob y esperamos a que dispare el evento "load"
    reader.readAsDataURL(contenidoEnBlob);
};
//Función de ayuda: reúne los datos a exportar en un
//solo objeto
function obtenerDatos() {
  return {
    contenido: document.getElementById('areaDeTexto').value
  };
};
 
//Genera un objeto Blob con los datos en un archivo TXT
function generarTexto(datos) {
  var texto = [];
  texto.push(datos.contenido);
  texto.push('\n');
  //El constructor de Blob requiere un Array en el primer 
  //parámetro así que no es necesario usar toString. El 
  //segundo parámetro es el tipo MIME del archivo
  return new Blob(texto, {
    type: 'text/plain'
  });
};
//ponemos el boton a la escucha
window.addEventListener('DOMContentLoaded', function(){
    var textArea = document.getElementById('areaDeTexto');   
        document.getElementById('boton-txt').addEventListener('click', function () {
            if (textArea.value=="") {   //evaluamos si hay contenido a descargar
                alert("TextArea vacio");   
            }else{
                var datos = obtenerDatos();
                descargarArchivo(generarTexto(datos), 'archivo.txt');
            }
       
        }, false);       
      
}, false);


