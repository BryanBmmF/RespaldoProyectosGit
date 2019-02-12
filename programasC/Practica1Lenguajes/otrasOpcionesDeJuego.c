
#include <stdio.h>

/*
 * codigo de otras opciones de juego
 */
//variables externas que hacen referencia a las globales en el main
extern char nombrePersonaje[50];
extern int puntosDeVida,puntosDeMana,puntosDeVidaEnemigo,enemigoVencido1,enemigoVencido2,enemigoVencido3
        ,oro,nivel,experiencia,articulo1,articulo2,articulo3,hpMaximo,mpMaximo;
//constantes
const int PRECIO_ARTICULO1=50,PRECIO_ARTICULO2=100,PRECIO_ARTICULO3=75,PRECIO_DORMIR=30;

void comprar(){
    int opcionCompra;//variables locales a utilizar
    char comprar='n';
    //mostrando en pantalla las opciones de la tienda
    printf("\nArticulos Disponibles:\n");
    printf("\nPRODUCTO   \tPRECIO   \tBENEFICIO");
    printf("\n1.Potion   \t50 oro   \tcura 25 HP");
    printf("\n2.Hi-Potion\t100 oro  \tcura 75 HP");
    printf("\n3.M-Potion \t75 oro   \trecupera 10 MP");
    printf("\n\nDesea comprar algun Articulo? [s]i, [n]o ? ");
    scanf(" %c", &comprar);
    if((comprar=='s')||(comprar=='S')){
        do{//validando la opcion seleccionada
            printf("\nIngrese numero de opcion: ");
            scanf("%i",&opcionCompra);    
        }while((opcionCompra<1)||(opcionCompra>3));
        //comparando la opcion de compra
        switch(opcionCompra){
            case 1://si el oro es suficiente se realiza la compra del articulo1, y se resta el oro    
                if(oro>=PRECIO_ARTICULO1){
                    articulo1=articulo1+1; oro=oro-PRECIO_ARTICULO1;
                    printf("\nCompra Exitosa");
                }else{
                    printf("\nOro Insuficiente Para Realizar esta Compra !!!");
                }
            break;
            case 2:////si el oro es suficiente se realiza la compra del articulo2, y se resta el oro   
                if(oro>=PRECIO_ARTICULO2){
                    articulo2=articulo2+1; oro=oro-PRECIO_ARTICULO2;
                    printf("\nCompra Exitosa");
                }else{
                    printf("\nOro Insuficiente Para Realizar esta Compra !!!");
                }
            break;
            case 3://si el oro es suficiente se realiza la compra del articulo3, y se resta el oro   
                if(oro>=PRECIO_ARTICULO3){
                    articulo3=articulo3+1; oro=oro-PRECIO_ARTICULO3;
                    printf("\nCompra Exitosa");
                }else{
                    printf("\nOro Insuficiente Para Realizar esta Compra !!!");
                }
            break;
        }
        
    }
    
}
void dormir(){
    printf("\n\nPara poder Dormir necesita al menos 30 de Oro");
    char opcionDormir;
    printf("\nDesea hacerlo?? [s]i, [n]o: ");
    scanf(" %c", &opcionDormir);
    if(opcionDormir=='s'||opcionDormir=='S'){
        if(oro>=PRECIO_DORMIR){//si el oro es suficiente recupera en su totalidad el HP y MP
            puntosDeVida=hpMaximo; puntosDeMana=mpMaximo;
             printf("\nRecuperacion Satisfactoria, MP y HP al MAXIMO!!!");
        }else{//sino lanza mensaje 
            printf("\nEl Oro que tienes no alcanza para Descansar y Recuperarte");
        }
    }
}
void status(){
    printf("\n\nNOMBRE:\t\t\t%s",nombrePersonaje);
    printf("\nPuntos De Vida (HP):\t%i",puntosDeVida);
    printf("\nPuntos De mana (MP):\t%i",puntosDeMana);
    printf("\nNivel: \t\t\t%i",nivel);    
    printf("\nExperiencia:\t\t%i",experiencia);
    printf("\nOro:    \t\t%i",oro);
    printf("\nPotion:\t\t\t%i",articulo1);
    printf("\nHi-Potion:\t\t%i",articulo2);
    printf("\nM-Potion:\t\t%i",articulo3);
    printf("\n\tEnemigos Vencidos:\t");
    printf("\nNombre:\t\t\tNo.Derrotas");
    printf("\nDark Wolf:\t\t%i",enemigoVencido1);
    printf("\nDragon:\t\t\t%i",enemigoVencido2);
    printf("\nMighty Golem:\t\t%i",enemigoVencido3);
}
