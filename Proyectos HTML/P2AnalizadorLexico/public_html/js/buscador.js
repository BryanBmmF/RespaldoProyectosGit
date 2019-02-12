/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//clases
//class Cadena {
//  constructor(lexema, numeroDeFila, numeroDeColumna) {
//    this.lexema = lexema;
//    this.numeroDeFila=numeroDeFila;
//    this.numeroDeColumna= numeroDeColumna;
//  }
//}
function buscarPatrones() {
    var textArea = document.getElementById('areaDeTexto');
    var txtPatron= document.getElementById('txtPatron').value;
    var caracteresPatron;
    var lineasDeTexto;
    var listaCadenas;
    var numeroDeLinea;
    var numeroDeColumna;
    var contenido;
    var encontrada=false;
    //obteniendo el componente que contiene el texto
    lineasDeTexto = textArea.value.split('\n');    //separando las lineas del Texto a Evaluar
    caracteresPatron= txtPatron.split("");
    //buscando palabra
    var cont=0;
    var cont2=0;
    while((cont<lineasDeTexto.length) && (encontrada!=true)){
        //esta lista almacena el numero de cadenas que contiene cada linea respetando el espacio
        listaCadenas=lineasDeTexto[cont].split(" ");
        //Se recorre la lista de cadenas para almacenar cada propiedad que identifica a una cadena dentro de una linea
        while((cont2<listaCadenas.length) && (encontrada!=true)){
            numeroDeLinea=cont+1;
            numeroDeColumna=cont2+1;
            contenido=listaCadenas[cont2]; 
            console.log(contenido);
            if (contenido.length===caracteresPatron.length) {
                console.log(contenido.length,caracteresPatron.length);
                for (var i = 0; i < caracteresPatron.length; i++) {
                    console.log(contenido.charAt(i));
                    if (contenido.charAt(i)===caracteresPatron[i]) {
                        console.log("ok");
                        encontrada=true;
                    }else{
                        encontrada=false;
                    }
                }
            }
            cont2=cont2+1;
        }
        cont=cont+1;
    }
    if (encontrada) {
        alert(" Palabra encontrada");
    }else{
        alert(" Palabra no encontrada");
    }
}
