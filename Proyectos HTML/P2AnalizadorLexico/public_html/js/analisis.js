/* 
 * Analisis de caracteres
 */
// Declaramos un array donde guardar las cadenas de texto que contiene cada linea de nuestro contenido
// Declaramos un arreglos donde guardar las cadenas validas e invalidas que no pertenecen a ningun token
var lexemasInvalidos = []; 
var lexemasValidos = []; 

//clases
class Lexema {
  constructor(token, lexema, numeroDeFila, numeroDeColumna) {
    this.token = token;
    this.lexema = lexema;
    this.numeroDeFila=numeroDeFila;
    this.numeroDeColumna= numeroDeColumna;
  }
}
class LexemaInvalido {
  constructor(token, lexema, numeroDeFila, numeroDeColumna,numeroDeCaracter,caracter) {
    this.token = token;
    this.lexema = lexema;
    this.numeroDeFila=numeroDeFila;
    this.numeroDeColumna= numeroDeColumna;
    this.numeroDeCaracter=numeroDeCaracter;
    this.caracter=caracter;
  }
}
//constantes
const alfabetoLetras=['a','b','c','d','e','f','g','h','i','j','k','l','m',
                      'n','o','p','q','r','s','t','u','v','w','x','y','z',
                      'A','B','C','D','E','F','G','H','I','J','K','L','M',
                      'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'];
const alfabetoNumeros=['0','1','2','3','4','5','6','7','8','9'];
const alfabetoSigPuntuacion=['.',',',';',':'];
const alfabetoOperadores=['+','-','*','/','%'];
const alfabetoSigAgrupacion=['(',')','[',']','{','}'];

const tokenIdentificador="Identificador";
const tokenNumero="Numero";
const tokenDecimal="Decimal";
const tokenPuntuacion="Puntuacion";
const tokenOperador="Operador";
const tokenAgrupacion="Agrupacion";
const lexemaInvalido="Token No Permitido";


//funcion para evaluar una cadena de longitud 1
function evaluarCadenaSimple(simbolo,linea,columna) {
    var lexema;
    var lexemaIn;
    //si la longitud de esta cadena es uno se evalua si es un signo de agupacion, puntuacion u operador etc
            if (evaluarSimbolo(alfabetoSigAgrupacion,simbolo)) {
                //si es un signo de agrupacion
                lexema= new Lexema(tokenAgrupacion,simbolo,linea,columna);
                lexemasValidos.push(lexema)
            }else if (evaluarSimbolo(alfabetoSigPuntuacion,simbolo)) {
                    //si es un signo de puntuacion
                    lexema= new Lexema(tokenPuntuacion,simbolo,linea,columna);
                    lexemasValidos.push(lexema);
                }else if (evaluarSimbolo(alfabetoOperadores,simbolo)){
                        // si en dado caso es un operador
                        lexema= new Lexema(tokenOperador,simbolo,linea,columna);
                        lexemasValidos.push(lexema);
                    }else if(evaluarSimbolo(alfabetoNumeros,simbolo)){
                            // si en dado caso es un numero
                            lexema= new Lexema(tokenNumero,simbolo,linea,columna);
                            lexemasValidos.push(lexema);
                        }else if (evaluarSimbolo(alfabetoLetras,simbolo)){
                                //si en dado caso es una Letra
                                lexema= new Lexema(tokenIdentificador,simbolo,linea,columna);
                                lexemasValidos.push(lexema);
                            }else{
                                //si en dado caso no es un lexema Permitido
                                lexemaIn= new LexemaInvalido(lexemaInvalido,simbolo,linea,columna,1,simbolo);
                                lexemasInvalidos.push(lexema);
                            }
}

//funcion que permite evaluar una cadena completa
function evaluarCadenaCompleta(cadena,linea,columna) {
    var lexema;
    var lexemaIn;
    var simbolo;
    var esNumero= false;
    var esIdentificador= false;
    var esDecimal=false;
    var decimales;
    var partes;
    var modoPanico=false;
    var long= cadena.length;
    var punto=0;

    for (var j = 0; j < long; j++) {   
        simbolo=cadena.charAt(j); //se captura cada simbolo de la cadena y se evalua en algunos alfabetos
        if (evaluarSimbolo(alfabetoOperadores,simbolo)||evaluarSimbolo(alfabetoSigAgrupacion,simbolo)){
            //el lexema no es valido por contener alguno de sus simbolos en alguno de los alfabetos a los que no deberia pert.
            lexemaIn= new LexemaInvalido(tokenOperador,cadena,linea,columna,(j+1),simbolo);
            lexemasInvalidos.push(lexemaIn);
            modoPanico=true;
        }else if(evaluarSimbolo(alfabetoSigPuntuacion,simbolo)  && simbolo!='.'){
            //es un signo de puntuacio diferente del punto
                lexemaIn= new LexemaInvalido(tokenPuntuacion,cadena,linea,columna,(j+1),simbolo); 
                lexemasInvalidos.push(lexemaIn);
                modoPanico=true;
            }else if(evaluarSimbolo(alfabetoNumeros,simbolo)){
                    //si es un numero
                    esNumero=true;
                }else if (evaluarSimbolo(alfabetoLetras,simbolo)){
                        //si es letra entonces no puede ser numero y si identificador
                        esNumero=false;
                        esIdentificador=true;
                    }else if(simbolo==='.'){
                            //si es un punto podria llegar a ser decimal nos aseguramos de ello sumando el numero de puntos para luego comp.
                            esDecimal=true;
                            esNumero=false;
                            punto++;
                        }else{//en dado caso no cumpla nada 
                            lexemaIn= new LexemaInvalido(lexemaInvalido,cadena,linea,columna,(j+1),simbolo); 
                            lexemasInvalidos.push(lexemaIn);
                            modoPanico=true;
                        }
        
    }
    //verificando los resultados de evaluacion
    if (modoPanico===false) {
        if (esNumero && esIdentificador==false && punto===0) {
            // si en dado caso es un numero
            lexema= new Lexema(tokenNumero,cadena,linea,columna);
            lexemasValidos.push(lexema);
        }else if(esIdentificador){// se comprueba si es un identificador valido
                if (evaluarSimbolo(alfabetoLetras,cadena.charAt(0))) {
                    // si la primera letra del identificador es una letra entonces se guarda 
                    lexema= new Lexema(tokenIdentificador,cadena,linea,columna);
                    lexemasValidos.push(lexema);
                }else{
                    //es un identificador incorrecto
                    lexema= new LexemaInvalido(tokenIdentificador,cadena,linea,columna,1,cadena.charAt(0));
                    lexemasInvalidos.push(lexema);
                }     
            }else if (esDecimal) {// se comprueba si es decimal
                    if (punto===1) {
                        decimales=cadena.split('.');
                        for (var i = 0; i < decimales.length; i++) {
                            partes= decimales[i];
                            for (var j = 0; j < partes.length; j++) {
                                if (evaluarSimbolo(alfabetoNumeros,partes[j])) {
                                    esDecimal=true;//sigue siendo correcto
                                }else{
                                    esDecimal=false;
                                    //es un decimal incorrecto
                                    lexema= new LexemaInvalido(tokenDecimal,cadena,linea,columna,(j+1),partes[j]);
                                    lexemasInvalidos.push(lexema);
                                }
                            }
                        }
                        if (esDecimal) {//termino siendo decimal
                            lexema= new Lexema(tokenDecimal,cadena,linea,columna);
                            lexemasValidos.push(lexema);
                        }
                    }else{
                        //es un decimal incorrecto
                        lexema= new LexemaInvalido(tokenDecimal,cadena,linea,columna,0,'');
                        lexemasInvalidos.push(lexema);
                    }
                }
        
    }
}
//funcion para evaluar alfabetos
function evaluarSimbolo(alfabeto,simbolo) {
    var aprobar=false;
    for (var i = 0; i < alfabeto.length; i++) {
        if (alfabeto[i]===simbolo) {
            aprobar=true;
        }
    } 
    return aprobar;
}


