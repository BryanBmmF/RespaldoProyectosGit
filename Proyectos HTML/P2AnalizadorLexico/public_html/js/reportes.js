/* 
 * generador de reportes
 */
function genera_tabla2() {
   
    var tabla = document.getElementById("tabla");
    var tblBody = document.getElementById("tablaCadenas");
    
    
    // Crea las celdas
    for (var i = 0; i < lexemasValidos.length; i++) {
        // Crea las hileras de la tabla
        var hilera = document.createElement("tr");
        // Crea un elemento <td> y un nodo de texto, hace que el nodo de
        // texto sea el contenido de <td>, ubica el elemento <td> al final
        // de la hilera de la tabla        
        for (var j = 0; j < 4; j++) {
            var celda = document.createElement("td");
            var textCelda;
            switch (j) {
                case 0:
                    textCelda=document.createTextNode(lexemasValidos[i].token);
                    break;
                case 1:
                    textCelda=document.createTextNode(lexemasValidos[i].lexema);
                    break;
                case 2:
                    textCelda=document.createTextNode(lexemasValidos[i].numeroDeFila);
                    break;
                default:
                    textCelda=document.createTextNode(lexemasValidos[i].numeroDeColumna);
                    break;
            }
            celda.appendChild(textCelda);
            hilera.appendChild(celda);
        }
        // agrega la hilera al final de la tabla (al final del elemento tblbody)
        tblBody.appendChild(hilera);
    }
    // posiciona el <tbody> debajo del elemento <table>
    tabla.appendChild(tblBody);
    
    tabla.setAttribute("border", "2");
}
function genera_tabla3() {
    
    var tabla = document.getElementById('tabla2');
    var tblBody = document.getElementById('tablaCadenas2');
    
    
    // Crea las celdas
    for (var i = 0; i < lexemasInvalidos.length; i++) {
        // Crea las hileras de la tabla
        var hilera = document.createElement("tr");
        // Crea un elemento <td> y un nodo de texto, hace que el nodo de
        // texto sea el contenido de <td>, ubica el elemento <td> al final
        // de la hilera de la tabla        
        for (var j = 0; j < 6; j++) {
            var celda = document.createElement("td");
            var textCelda;
            switch (j) {
                case 0:
                    textCelda=document.createTextNode(lexemasInvalidos[i].token);
                    break;
                case 1:
                    textCelda=document.createTextNode(lexemasInvalidos[i].lexema);
                    break;
                case 2:
                    textCelda=document.createTextNode(lexemasInvalidos[i].numeroDeFila);
                    break;
                case 3:
                    textCelda=document.createTextNode(lexemasInvalidos[i].numeroDeColumna);
                    break;
                case 4:
                    textCelda=document.createTextNode(lexemasInvalidos[i].numeroDeCaracter);
                    break;
                default:
                    textCelda=document.createTextNode(lexemasInvalidos[i].caracter);
                    break;
            }
            celda.appendChild(textCelda);
            hilera.appendChild(celda);
        }
        // agrega la hilera al final de la tabla (al final del elemento tblbody)
        tblBody.appendChild(hilera);
    }
    // posiciona el <tbody> debajo del elemento <table>
    tabla.appendChild(tblBody);
    tabla.setAttribute("border", "2");
}


