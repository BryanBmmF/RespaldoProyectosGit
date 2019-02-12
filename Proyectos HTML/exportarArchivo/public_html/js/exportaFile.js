/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
function obtenerDatos() {
    return {
        nombre: document.getElementById('textNombre').value,
        telefono: document.getElementById('textTelefono').value,
        fecha: (new Date()).toLocaleDateString()
    };
};
//function escaparXML(cadena) {
//    if (typeof cadena !== 'string') {
//        return '';
//    };
//    cadena = cadena.replace('&', '&amp;')
//                 .replace('<', '&lt;')
//                 .replace('>', '&gt;')
//                 .replace('"', '&quot;');
//    return cadena;
//};
function generarTexto(datos) {
    var texto = [];
    texto.push('Datos Personales:\n');
    texto.push('Nombre: ');
    texto.push(datos.nombre);
    texto.push('\n');
    texto.push('Teléfono: ');
    texto.push(datos.telefono);
    texto.push('\n');
    texto.push('Fecha: ');
    texto.push(datos.fecha);
    texto.push('\n');
    //El constructor de Blob requiere un Array en el primer 
    //parámetro así que no es necesario usar toString. El 
    //segundo parámetro es el tipo MIME del archivo
    return new Blob(texto, {
        type: 'text/plain'
    });
};
//function generarXml(datos) {
//    var texto = [];
//    texto.push('<?xml version="1.0" encoding="UTF-8" ?>\n');
//    texto.push('<datos>\n');
//    texto.push('\t<nombre>');
//    texto.push(escaparXML(datos.nombre));
//    texto.push('</nombre>\n');
//    texto.push('\t<telefono>');
//    texto.push(escaparXML(datos.telefono));
//    texto.push('</telefono>\n');
//    texto.push('\t<fecha>');
//    texto.push(escaparXML(datos.fecha));
//    texto.push('</fecha>\n');
//    texto.push('</datos>');
//    //No olvidemos especificar el tipo MIME correcto :)
//    return new Blob(texto, {
//        type: 'application/xml'
//    });
//};
window.addEventListener('DOMContentLoaded', function(){
 
//    document.getElementById('boton-xml').addEventListener('click', function () {
//          var datos = obtenerDatos();
//          descargarArchivo(generarXml(datos), 'archivo.xml');
//    }, false);
 
    document.getElementById('boton-txt').addEventListener('click', function () {
        var datos = obtenerDatos();
        descargarArchivo(generarTexto(datos), 'archivo.txt');
    }, false);
 
}, false);
