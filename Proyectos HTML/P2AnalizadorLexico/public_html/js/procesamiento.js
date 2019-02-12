/* 
 * procesamiento de cadenas
 */

//******************************************************************************
// Función para procesar el contenido del Area de Texto 
function procesarContenido() {
 var textArea = document.getElementById('areaDeTexto');   
 var lineasDeTexto;
    if (textArea.value=="") {
        alert("TextArea vacio");
    
    }
    else{
        //eliminamos el texto que tenemos
        lexemasInvalidos.length=0;
        lexemasValidos.length=0;
        //obteniendo el componente que contiene el texto
        lineasDeTexto = textArea.value.split('\n');    //separando las lineas del Texto a Evaluar
        //variables a utilizar en el evaluo de cada linea 
        var listaCadenas;
        var numeroDeLinea;
        var numeroDeColumna;
        var contenido;
        var idCadena;
        //Almacenando propiedades de cada linea capturada
        for (var j = 0; j < lineasDeTexto.length; j++) {
            //esta lista almacena el numero de cadenas que contiene cada linea respetando el espacio
            listaCadenas=lineasDeTexto[j].split(" ");
            //Se recorre la lista de cadenas para almacenar cada propiedad que identifica a una cadena dentro de una linea
            for (var i = 0; i < listaCadenas.length; i++) {
                numeroDeLinea=j+1;
                numeroDeColumna=i+1;
                contenido=listaCadenas[i];            
                //si la cadena es de longitud 1 se evalua una cadena simple de un solo simbolo
                if (contenido.length===1) {
                    evaluarCadenaSimple(contenido,numeroDeLinea,numeroDeColumna);
                }else { //en caso que la longitud sea mayor que uno se evalua la cadena completa
                    evaluarCadenaCompleta(contenido,numeroDeLinea,numeroDeColumna);
                }
            }
        }
        if (lexemasInvalidos.length!=0) {
            genera_tabla3();//se genera la tabla respectiva
        }else{
            genera_tabla2();//se genera la tabla respectiva
        }
        
    } 
}
//*****************************************************************************


