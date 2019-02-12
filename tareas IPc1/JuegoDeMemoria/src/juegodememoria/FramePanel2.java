/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodememoria;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import static juegodememoria.FramePanel.getNombreJugador1;
import static juegodememoria.FramePanel.panelMenu;
import static juegodememoria.FramePanel.panelPrincipal;

/**
 *
 * @author bryan
 */
public class FramePanel2 extends FramePanel{
    
    //Constructor que recibe como parametro la dificultad enviada desde FramePanel
    public FramePanel2(int dificultad){
        
        this.dificultad=dificultad;
        
        //agregando menu de opciones heredado de FramePanel
        add(panelMenu,BorderLayout.NORTH);
        
         //creando panel principal de nueva partida de juego
        panelPrincipal= new JPanel();
        
        //asignacion de dificultad y numero de cartas
        selccionDificultad(dificultad);
        
        //caracteristicas de panel Principal para Partida Nueva
        panelPrincipal.setBackground(Color.YELLOW);
        panelPrincipal.setBorder(BorderFactory.createLoweredBevelBorder());
        
        //panelPrincipal.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        //agregando panel principal al Frame Panel2
        add(panelPrincipal,BorderLayout.CENTER);
        
        //agregando scroll al panel principa; adaptable vertical y hor.
        JScrollPane scroller= new JScrollPane(panelPrincipal);
        scroller.setPreferredSize(new Dimension(200,200));
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(scroller);
        
        //creano panel para turnos y punteos
        JPanel panelTurno=new JPanel();
        
        //fuente y dimension para label mostrarTurno y los que lo requieran 
        Font miFuente= new Font("Arial",Font.BOLD,20);
        Font miFuente2= new Font("Arial",Font.BOLD,15);
        Dimension dim= new Dimension(300,15); 
        Dimension dim2= new Dimension(300,30);
        
        //mostrando primer turno de juego
        mostrarTurno=new JLabel("Turno de "+primerTurno()+"    ");
        //agregando caracteristicas a mostrarTurno
        mostrarTurno.setFont(miFuente);
        mostrarTurno.setPreferredSize(dim2);
        
        //mostrando punteos de jugadores
        punteoJ1=new JLabel("            Jugador 1: "+getNombreJugador1()+"  punteo: "+punteoJugador1);
        punteoJ1.setFont(miFuente2);
        
        punteoJ2=new JLabel("        Jugador 2: "+getNombreJugador2()+"  Punteo: "+punteoJugador2);
        punteoJ2.setFont(miFuente2);
        
        //agregando labels al panelTurno
        panelTurno.add(mostrarTurno);
        panelTurno.add(punteoJ1);
        panelTurno.add(punteoJ2);
        add(panelTurno,BorderLayout.SOUTH);
        
    
    }
    //metodo para devolver el primer turno de la partida
    private String primerTurno(){
        String jugadorSeleccionado="";
        Random aleatorio = new Random();//declarando variables tipo random para aleatoriedad
            //eligiendo turno aleatorio si es 1 inicia Jugador1, si es 2 inicia Jugador2
            turno = (aleatorio.nextInt(2)+1);
            
            if(turno==1){  //si es 1 turno de Jugador1
                jugadorSeleccionado="Jugador 1: "+getNombreJugador1();
                //contadorDeTurnoJ1++;
                turnoJ1=true;
            }
            else{   //si es 2 turno de Jugador2
                jugadorSeleccionado="Jugador 2: "+getNombreJugador2();
                //contadorDeTurnoJ2++;
                contadorDeTurnoJ1=2;
                turnoJ2=true;
            }            
            //Retornando primer turno a mostrar en label
        return jugadorSeleccionado;
    }
    
    //metodo para asignar dificultad y No.cartas
    private void selccionDificultad(int dificult){
        
        //dificultad facil 5 pareejas
        if(dificult==0){
            //Gridlayout para rejilla  5 columnas 2 filas
            panelPrincipal.setLayout(new GridLayout(2,5));
            for(int i=0;i<10;i++){
                //agregando numero de cartas para el juego
                ponerCarta2(imagenCarta[i]=new ImageIcon("src/graficos2/r17.jpg"),numeroCarta[i]=i);
                numeroVolteadas=i;
                
            }
            min=1;
            max=5;
            //System.out.println(numeroVolteadas);
            almacenDePulsacion=new int[numeroVolteadas+1];
            coleccionTemporal= new int[max];
            contadorImagenRepetida= new int[max];
            for(int i: contadorImagenRepetida){
                contadorImagenRepetida[i]=1;
            }
            
        }
            //dificultad media 10 parejas
            else if(dificult==1){
                //Gridlayout para rejilla  7 columnas 3 filas
                panelPrincipal.setLayout(new GridLayout(3,7));
                for(int i=0;i<20;i++){
                //agregando numero de cartas para el juego
                ponerCarta2( imagenCarta[i]=new ImageIcon("src/graficos2/r17.jpg"),numeroCarta[i]=i);
                numeroVolteadas=i;
                }
                 min=1;
                 max=10;
                almacenDePulsacion=new int[numeroVolteadas+1];
                coleccionTemporal= new int[max];
                
                contadorImagenRepetida= new int[max];
                for(int i: contadorImagenRepetida){
                    contadorImagenRepetida[i]=1;
                }
                
            }
                //dificultad dificil 15 parejas
                else if(dificult==2){
                    //Gridlayout para rejilla  8 columnas 4 filas
                    panelPrincipal.setLayout(new GridLayout(4,8));
                    for(int i=0;i<30;i++){
                    
                    //agregando numero de cartas para el juego
                    ponerCarta2( imagenCarta[i]=new ImageIcon("src/graficos2/r17.jpg"),numeroCarta[i]=i);
                    numeroVolteadas=i;
                    }
                     min=1;
                     max=15;
                    almacenDePulsacion=new int[numeroVolteadas+1];
                    coleccionTemporal= new int[max];
                    
                    contadorImagenRepetida= new int[max];
                    for(int i: contadorImagenRepetida){
                        contadorImagenRepetida[i]=1;
                    }
            
                }              
    
    }
    
    /**
     * Creacion de metodo encargado de 
     * crear cartas de una forma mas
     * accesible
     **/
    
    //recibe parametros enviados desde ponerCarta2()
    private void ponerCarta2(ImageIcon rotulo, int numeroCarta){
        nuevaCarta=numeroCarta+1;
        //conversion de nuevaCarta a String cartaEnvio
        String cartaEnvio="";
        cartaEnvio=Integer.toString(nuevaCarta);
        //instanciacion de JButtom
        carta[nuevaCarta-1]=new JButton(cartaEnvio,rotulo);
        
        ActionListener voltear= new voltearCarta();
        //asignando a boton el evento voltear
        carta[nuevaCarta-1].addActionListener(voltear);
        
        carta[nuevaCarta-1].setVerticalTextPosition(JButton.BOTTOM);
        carta[nuevaCarta-1].setHorizontalAlignment(JButton.CENTER);
           
        //agregando carta al Panel2
        panelPrincipal.add(carta[nuevaCarta-1]);
           
    }
    //clase interna encargada de voltear carta
    private class  voltearCarta implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            //capturando numero de carta y almacenando en cartaRecibo
            String cartaRecibo=e.getActionCommand();
            
            //convirtiendo cartaRecibo a entero y almacenando 
            int numeroCar=Integer.parseInt(cartaRecibo);
            
            //buscando la carta que se desea voltear entre las que ya se han volteado
            buscarCarta(numeroVolteadas+1,numeroCar);
            
            turnoDeVoltear();
            
            //si llega a finalizar la partida
            if(parejasVolteadas==max){
                if(punteoJugador1>punteoJugador2){
                    JOptionPane.showMessageDialog(FramePanel2.this, "Felicidades  "+" "+getNombreJugador1()
                     +"Ganaste la partida\n Punteo Obtenido:  "+punteoJugador1, "Congratulation!!!", 2,new ImageIcon("src/graficos2/feliz.png"));
                    
                    //listaGanadores.add(new Ganador(getNombreJugador1(),punteoJugador1,"",getNombreJugador2()));
                    
                    nombres= new String[contadorDePartidas];
                    fechas= new String[contadorDePartidas];
                    perdedores= new String[contadorDePartidas];
                    punteos= new int[contadorDePartidas];
                    
                    nombres[contadorDePartidas]=getNombreJugador1();
                    punteos[contadorDePartidas]=punteoJugador1;
                    perdedores[contadorDePartidas]=getNombreJugador2();
                    fechas[contadorDePartidas]="03/04/2018";
                    
                    contadorDePartidas++;
                                        
                }
                else{
                     JOptionPane.showMessageDialog(FramePanel2.this, "Felicidades  "+" "+getNombreJugador2()
                     +"Ganaste la partida\n Punteo Obtenido:  "+punteoJugador2, "Congratulation!!!", 2,new ImageIcon("src/graficos2/feliz.png"));
                     //utilizando array list
                     //listaGanadores.add(new Ganador(getNombreJugador2(),punteoJugador2,"",getNombreJugador2()));
                     
                    nombres= new String[contadorDePartidas];
                    fechas= new String[contadorDePartidas];
                    perdedores= new String[contadorDePartidas];
                    punteos= new int[contadorDePartidas];
                    
                    nombres[contadorDePartidas]=getNombreJugador2();
                    punteos[contadorDePartidas]=punteoJugador2;
                    perdedores[contadorDePartidas]=getNombreJugador1();
                    fechas[contadorDePartidas]="03/04/2018";
                    
                    contadorDePartidas++;
                     
                     
                }
            }
        }
        
        
    
    }
    //metodo que devuelve una imagen seleccionada del ordenador
    private ImageIcon seleccionDeImagen(){
        
        //declaracion de miembro para almacenar y mandar imagen seleccionada
        ImageIcon seleccionAsignada= new ImageIcon();
        
        do{
            int numeroDeImagen;
            Random aleatorio = new Random();//declarando variables tipo random para aleatoriedad
            
            //eligiendo numero de Imagen a mandar
            numeroDeImagen = (aleatorio.nextInt(max)+min);
            String numeroConvertido="";
            numeroConvertido=Integer.toString(numeroDeImagen);
                
                int i=0;//buscando carta en coleccion temporal
                while(i<max&&coleccionTemporal[i]<numeroDeImagen){
                    i++;           
                }
                
                if(i==max){//no encuentra el numeroDeImagen
              
                        //escoger imagen con el numeroDeImagen y luego enviar
                        seleccionAsignada= new ImageIcon("src/graficos2/r"+numeroConvertido+".png");
                        
                        //almacenando carta en coleccion temporal
                        coleccionTemporal[contadorColeccion]=numeroDeImagen;  //verificar******
                        System.out.println("se almaceno imagen en la pos "+contadorColeccion);
                        contadorColeccion++;
                        
                        
                        //almacenando codigo de imagen para comparacion en turnos
                        codigoImagen[contadorCodigo]=numeroDeImagen;
                        contadorCodigo++;
                        
                        //almacenando cartas para eliminar despues //******************
                        eliminaCartas2[contadorElimina2]=numeroDeImagen;
                        contadorElimina2++;
                        
                        ordenamiento2(contadorColeccion);
                        encontrada=true;  //para detener el while
                        
                }
                else{
                    if(coleccionTemporal[i]==numeroDeImagen){//si encuentra el numeroDeimagen 
                       
                        //comparacion si no se ha repetido mas de 2 veces
                        if(contadorImagenRepetida[numeroDeImagen-1]<2){
                        //enviar misma imagen con el numeroDeImagen
                        seleccionAsignada= new ImageIcon("src/graficos2/r"+numeroConvertido+".png");
                        contadorImagenRepetida[numeroDeImagen-1]=2;
                        
                        //almacenando codigo de imagen para comparacion en turnos
                        codigoImagen[contadorCodigo]=numeroDeImagen;
                        contadorCodigo++;
                        
                        encontrada=true;  //para detener el while
                        }
                        //si ya se ha repetido dos veces busca otra carta 
                        else{encontrada=false;}
                    
                    }
                    
                    else{
                        //no encuentra el numeroDeImagen
 
                        //escoger imagen con el numeroDeImagen y luego enviar
                        seleccionAsignada= new ImageIcon("src/graficos2/r"+numeroConvertido+".png");
 
                        //almacenando carta en coleccion temporal
                        coleccionTemporal[contadorColeccion]=numeroDeImagen;
                        contadorColeccion++;
                        
                        //almacenando codigo de imagen para comparacion en turnos
                        codigoImagen[contadorCodigo]=numeroDeImagen;
                        contadorCodigo++;
                        
                        //almacenando cartas para eliminar despues //******************
                        eliminaCartas2[contadorElimina2]=numeroDeImagen;
                        contadorElimina2++;
                        
                        ordenamiento2(contadorColeccion);
                        encontrada=true;  //para detener el while
                        
                    }
                }
        }while(encontrada==false);         
    // retornando imagen seleccionada para colocar en el panel
    return seleccionAsignada;
    }
    
    //metodo de ordenamiento Burbuja parametro= array size   para almacen de pulsacion
    private void ordenamiento(int size){
    
        for (int i = 0; i < (size-1); i++) {
            for (int j = 0; j < (size-1); j++) {
                if(almacenDePulsacion[j]>almacenDePulsacion[j+1]){//si numero actual> numero siguiente
                    aux=almacenDePulsacion[j];
                    almacenDePulsacion[j]=almacenDePulsacion[j+1];
                    almacenDePulsacion[j+1]=aux;
                }
            }
        }
    }
    
    //metodo de ordenamiento Burbuja parametro= array size   para coleccion temporal
    private void ordenamiento2(int size){
    
        for (int i = 0; i < (size-1); i++) {
            for (int j = 0; j < (size-1); j++) {
                if(coleccionTemporal[j]>coleccionTemporal[j+1]){//si numero actual> numero siguiente
                    aux3=coleccionTemporal[j];
                    coleccionTemporal[j]=coleccionTemporal[j+1];
                    coleccionTemporal[j+1]=aux3;
                }
            }
        }
    }
    
    //metodo para buscar carta y asignar nueva carta a boton con la referencia recibida
    private void buscarCarta(int numeroVoltear, int no_Carta){
        
        //----------------------------------------------------------------------
                    
        //buscando la carta que se desea voltear entre las que ya se han volteado
        int i=0;
        while(i<numeroVoltear && almacenDePulsacion[i]<no_Carta){
                
            i++;
            
        }
            if(i==numeroVoltear){
                //no se ha hecho click sobre la carta ninguna vez
                //volteando carta(cambiandole imagen) al boton pulsado               
                carta[no_Carta-1].setIcon(seleccionDeImagen());
                
                //almacenando cartas a regresar en caso no se halle la pareja
                cartasDeRegreso[contadorDeRegreso]=no_Carta-1;
                contadorDeRegreso++;
                
                //ordenando arreglo de pulsaciones
                almacenDePulsacion[contadorDePuls]=(no_Carta);
                contadorDePuls++;
                
                //almacenando cartas para eliminar despues //******************
                eliminaCartas[contadorElimina]=no_Carta;
                contadorElimina++;
                ordenamiento(contadorDePuls);
                
                
                
            }
            else{
                if(almacenDePulsacion[i]==no_Carta){
                    //ya se ha hecho click una vez en esta carta
                    JOptionPane.showMessageDialog(FramePanel2.this, "Esta Carta ya ha sido volteada\n Intenta voltear otra carta","Alto",0);
                    
                    if(turnoJ1==true){  //sediendo nuevamente el turno al jugador
                        contadorDeTurnoJ1--;
                    }
                    else if(turnoJ2==true){
                        contadorDeTurnoJ2--;
                    }
                }
                else{
                    //no se ha hecho click sobre la carta ninguna vez
                    //volteando carta(cambiandole imagen) al boton pulsado
                    carta[no_Carta-1].setIcon(seleccionDeImagen());
                    
                    //almacenando cartas a regresar en caso no se halle la pareja
                    cartasDeRegreso[contadorDeRegreso]=no_Carta-1;
                    contadorDeRegreso++;
                    
                    //almacenando botones pulsados
                    almacenDePulsacion[contadorDePuls]=no_Carta;
                    contadorDePuls++;
                    
                    //almacenando cartas para eliminar despues/******************
                    eliminaCartas[contadorElimina]=no_Carta;
                    contadorElimina++;
                    ordenamiento(contadorDePuls);
                    
                }
            }
        
        //----------------------------------------------------------------------
    }
    //metodo que controla los turnos de jugador
    private void turnoDeVoltear(){
        
        //verificacion de turnos
            if(contadorDeTurnoJ1<2){
                //turno de jugador1
                if(contadorDeTurnoJ1==1){   //condicion si el jugador 1 lleva 2 turnos
   
                    punteo(1);//se envia como parametro el No.Jugador 1 para gestionar el punteo
                    
                }
                contadorDeTurnoJ1++; //se incrementa el turno de J1   
            }
            else if(contadorDeTurnoJ2<2){
                //turno de jugador2
                    if(contadorDeTurnoJ2==1){   //condicion si el jugador 2 lleva 2 turnos
  
                        punteo(2);//se envia como parametro el No.Jugador 2 para gestionar el punteo
                        
                    }
                    contadorDeTurnoJ2++; //se incrementa el turno de J2  
                
            }
       
    
    }
    //metodo que lleva el control de los punteos para cada jugador
    private void punteo(int numeroJugador){
        
        switch(numeroJugador){
            
            case 1:{
                //comparando si las ultimas dos cartas volteadas son iguales
                if(codigoImagen[0]==codigoImagen[1]){
                    
                        //el jugador acerto una pareja
                        punteoJugador1=punteoJugador1+50;
                        punteoJ1.setText("            Jugador 1: "+getNombreJugador1()+"  punteo: "+punteoJugador1);
                        
                        JOptionPane.showMessageDialog(FramePanel2.this,"Descubriste una pareja\nse te acredito un turno extra"
                                +"\nSigue Asi!!!!","Turno Ganado", 2,new ImageIcon("src/graficos2/feliz.png"));
                        //inabilitando cartas desvolteadas
                        carta[cartasDeRegreso[0]].setEnabled(false);
                        carta[cartasDeRegreso[1]].setEnabled(false);
                        
                        mostrarTurno.setText("Turno de Jugador 1: "+getNombreJugador1());
                        //vuelve a ser turno de J1
                        contadorDeTurnoJ1=-1;                       
                        contadorDeTurnoJ2=2;    //ahun no le toca a J2
                        turnoJ1=true;
                        turnoJ2=false;
                        
                        //el contador de codigo de imagen se reinicia
                        contadorCodigo=0;
                        
                        //contador de parejeas volteadas para llevar la cuenta
                        parejasVolteadas++;
                        
                        contadorDeRegreso=0;
                        contadorElimina=0;
                        contadorElimina2=0;
                        //contadorColeccion=contadorColeccion--;
                      
                    }
                    else{
                        //el jugador no acerto una pareja
                        if(punteoJugador1<10 || punteoJugador1==10){
                            //si el jugador posee menos de 10 puntos ya no se le puede restar mas
                            punteoJugador1=0;
                            punteoJ1.setText("            Jugador 1: "+getNombreJugador1()+"  punteo: "+punteoJugador1);
                            
                            JOptionPane.showMessageDialog(FramePanel2.this,"No acertaste esta vez \nSigue intentando"
                                +"\nEn el proximo turno","Turno Perdido", 2,new ImageIcon("src/graficos2/triste.png"));
                            
                            mostrarTurno.setText("Turno de Jugador 2: "+getNombreJugador2());
                            //finaliza turno de Jugador1 e inicia el turno de Jugador2
                            turnoJ1=false;
                            turnoJ2=true;
                            contadorDeTurnoJ2=0;    //reinicio de turno para Jugador2
                            contadorDeTurnoJ1=2;
                            //el contador de codigo de imagen se reinicia
                            contadorCodigo=0;
                            
                            //se regresan las cartas al estado inicial y se cambian de posicion
                            regresarCartas(cartasDeRegreso[0],cartasDeRegreso[1]);
                            contadorDeRegreso=0;
                            
                            //eliminando cartas del almacen de pulsaciones
                            eliminarCarta(eliminaCartas[0]);//******************
                            eliminarCarta(eliminaCartas[1]);
                            contadorElimina=0;
                            contadorDePuls=contadorDePuls-2;
                            
                            eliminarCarta2(eliminaCartas2[0]);//******************
                            eliminarCarta2(eliminaCartas2[1]);
                            contadorElimina2=0;
                            contadorColeccion=contadorColeccion-2;
                            
                        }
                        else{//si el jugador posee mas de 10 puntos se le hace la resta respectiva
                            punteoJugador1=punteoJugador1-10;
                            punteoJ1.setText("            Jugador 1: "+getNombreJugador1()+"  punteo: "+punteoJugador1);
                            
                             JOptionPane.showMessageDialog(FramePanel2.this,"No acertaste esta vez \nSigue intentando"
                                +"\nEn el proximo turno","Turno Perdido", 2,new ImageIcon("src/graficos2/triste.png"));
                            
                            mostrarTurno.setText("Turno de Jugador 2: "+getNombreJugador2());
                            //finaliza turno de de Jugador1 e inicia el turno de Jugador2
                            turnoJ1=false;
                            turnoJ2=true;
                            contadorDeTurnoJ2=0;    //reinicio de turno para Jugador2
                            contadorDeTurnoJ1=2;
                            //el contador de codigo de imagen se reinicia
                            contadorCodigo=0;
                            
                            //se regresan las cartas al estado inicial y se cambian de posicion
                            regresarCartas(cartasDeRegreso[0],cartasDeRegreso[1]);
                            contadorDeRegreso=0;
                            
                            //eliminando cartas del almacen de pulsacion
                            eliminarCarta(eliminaCartas[0]);//******************
                            eliminarCarta(eliminaCartas[1]);
                            contadorElimina=0;
                            contadorDePuls=contadorDePuls-2;
                            
                            //eliminando cartas de coleccionTemporal
                            eliminarCarta2(eliminaCartas2[0]);//******************
                            eliminarCarta2(eliminaCartas2[1]);
                            contadorElimina2=0;
                            contadorColeccion=contadorColeccion-2;
 
                        }
                        
                    
                    }                   
            
            break;
            }
            case 2:{
                //comparando si las ultimas dos cartas volteadas son iguales
                 if(codigoImagen[0]==codigoImagen[1]){
                    
                        //el jugador acerto una pareja
                        punteoJugador2=punteoJugador2+50;
                        punteoJ2.setText("            Jugador 2: "+getNombreJugador2()+"  punteo: "+punteoJugador2);
                        
                        JOptionPane.showMessageDialog(FramePanel2.this,"Descubriste una pareja\nse te acredito un turno extra"
                                +"\nSigue Asi!!!!","Turno Ganado", 2,new ImageIcon("src/graficos2/feliz.png"));
                        //inabilitando cartas desvolteadas
                        carta[cartasDeRegreso[0]].setEnabled(false);
                        carta[cartasDeRegreso[1]].setEnabled(false);
                        mostrarTurno.setText("Turno de Jugador 2: "+getNombreJugador2());
                        contadorDeTurnoJ2=-1;
                        contadorDeTurnoJ1=2;    //ahun no le toca a J1
                        //vuelve a ser turno de J2
                        turnoJ2=true;
                        turnoJ1=false;
                        
                        //el contador de codigo de imagen se reinicia
                        contadorCodigo=0;
                        
                        //contador de parejeas volteadas para llevar la cuenta
                        parejasVolteadas++;
                        
                        contadorDeRegreso=0;
                        contadorElimina=0;
                        contadorElimina2=0;
                        
                        //contadorColeccion=contadorColeccion--;
                    }
                    else{
                        //el jugador no acerto una pareja
                        if(punteoJugador2<10 || punteoJugador2==10){
                            //si el jugador posee menos de 10 puntos ya no se le puede restar mas
                            punteoJugador2=0;
                            punteoJ2.setText("            Jugador 2: "+getNombreJugador2()+"  punteo: "+punteoJugador2);
                            
                             JOptionPane.showMessageDialog(FramePanel2.this,"No acertaste esta vez \nSigue intentando"
                                +"\nEn el proximo turno","Turno Perdido", 2,new ImageIcon("src/graficos2/triste.png"));
                            
                            mostrarTurno.setText("Turno de Jugador 1: "+getNombreJugador1());
                            //finaliza turno de de Jugador2 e inicia el turno de Jugador1
                            turnoJ1=true;
                            turnoJ2=false;
                            contadorDeTurnoJ1=0;    //reinicio de tuno para Jugador1
                            contadorDeTurnoJ2=2;
                            //el contador de codigo de imagen se reinicia
                            contadorCodigo=0;
                            
                            //se regresan las cartas al estado inicial y se cambian de posicion
                            regresarCartas(cartasDeRegreso[0],cartasDeRegreso[1]);
                            contadorDeRegreso=0;
                            
                            //eliminando cartas del almacen de pulsacion
                            eliminarCarta(eliminaCartas[0]);//******************
                            eliminarCarta(eliminaCartas[1]);
                            contadorElimina=0;
                            contadorDePuls=contadorDePuls-2;
                            
                            //eliminando cartas de coleccionTemporal
                            eliminarCarta2(eliminaCartas2[0]);//******************
                            eliminarCarta2(eliminaCartas2[1]);
                            contadorElimina2=0;
                            contadorColeccion=contadorColeccion-2;
                           
                        }
                        else{//si el jugador posee mas de 10 puntos se le hace la resta respectiva
                            punteoJugador2=punteoJugador2-10;
                            punteoJ2.setText("            Jugador 2: "+getNombreJugador2()+"  punteo: "+punteoJugador2);
                            
                             JOptionPane.showMessageDialog(FramePanel2.this,"No acertaste esta vez \nSigue intentando"
                                +"\nEn el proximo turno","Turno Perdido", 2,new ImageIcon("src/graficos2/triste.png"));
                            
                            mostrarTurno.setText("Turno de Jugador 1: "+getNombreJugador1());
                            //finaliza turno de de Jugador2 e inicia el turno de Jugador1
                            turnoJ1=true;
                            turnoJ2=false;
                            contadorDeTurnoJ1=0;    //reinicio de tuno para Jugador1
                            contadorDeTurnoJ2=2;
                            //el contador de codigo de imagen se reinicia
                            contadorCodigo=0;
                            
                            //se regresan las cartas al estado inicial y se cambian de posicion
                            regresarCartas(cartasDeRegreso[0],cartasDeRegreso[1]);
                            contadorDeRegreso=0;
                            
                            //eliminando cartas de alamacenDePulsacion
                            eliminarCarta(eliminaCartas[0]);//******************
                            eliminarCarta(eliminaCartas[1]);
                            contadorElimina=0;
                            contadorDePuls=contadorDePuls-2;
                            
                            //eliminando cartas de coleccionTemporal
                            eliminarCarta2(eliminaCartas2[0]);//******************
                            eliminarCarta2(eliminaCartas2[1]);
                            contadorElimina2=0;
                            contadorColeccion=contadorColeccion-2;
                            
                        }
                        
                    
                    }                   
            
            break;
            }
        
        }
        
        
    }
    //metodo para voltear nuevamente la carta y cambiarla de posicion
    private void regresarCartas(int cartaRegreso1, int cartaRegreso2){
    
        //volteando cartas nuevamente              
         carta[cartaRegreso1].setIcon(new ImageIcon("src/graficos2/r17.jpg"));
         
         carta[cartaRegreso2].setIcon(new ImageIcon("src/graficos2/r17.jpg"));
    }
    
    private void eliminarCarta(int cartaEliminar){
        
        int i=0;       
        while(i<(numeroVolteadas+1) && almacenDePulsacion[i]<cartaEliminar){
        
            i++;
        }
        if(i==(numeroVolteadas+1)){
            //no encontro el elemento       
        }
        else {
            if(almacenDePulsacion[i]==cartaEliminar){
                //se encontro la carta y se procede a eliminarla del arreglo
                almacenDePulsacion[i]=0;             
            }
            else{
                //el elemento no se encontro
            }
        }
        
    
    }
    private void eliminarCarta2(int cartaEliminar2){
        int i=0;       
        while(i<(max) && coleccionTemporal[i]<cartaEliminar2){
        
            i++;
        }
        if(i==(max)){
            //no encontro el elemento       
        }
        else {
            if(coleccionTemporal[i]==cartaEliminar2){
                //se encontro la carta y se procede a eliminarla del arreglo
                coleccionTemporal[i]=0;             
            }
            else{
                //el elemento no se encontro
            }
        }
    
    }
    //clase para llenar tablaReporte
    public class LlenarTabla {
    
    public void pasarValores(JTable tab){
        
        DefaultTableModel columnas= new DefaultTableModel();
    
        for (int i = 0; i < contadorDePartidas; i++) {
            
            String[] filas={""+(i+1)+nombres[i],""+punteos[i],perdedores[i],fechas[i]};
            columnas.addRow(filas);
        }
        
        tab.setModel(columnas);
    }
    
}

     
     
    //encapsulamiento de miembros utilizados en el Frame Panel2
    private int dificultad;
    private int punteoJugador1=0,punteoJugador2=0;;
    private JLabel mostrarTurno;
    private JLabel punteoJ1,punteoJ2;
    private ImageIcon[] imagenCarta=new ImageIcon[30];
    private JButton[] carta=new JButton[30];
    private int parejasVolteadas=0;
    private int[] numeroCarta=new int[30];
    private int nuevaCarta;    
    private int turno,contadorDeTurnoJ1=0,contadorDeTurnoJ2=0;
    public  int  contadorDePartidas=1;   
    private int numeroVolteadas,contadorDeVolteadas=0;
    private int[] almacenDePulsacion;
    private int contadorDePuls=0;
    private int[] cartasDeRegreso= new int[2];
    private int[] eliminaCartas= new int [2];
    private int[] eliminaCartas2= new int[2];
    private int contadorDeRegreso=0;
    private int contadorElimina=0;
    private int contadorElimina2=0;
    private int aux,aux2=-3,aux3;
    private int[] contadorImagenRepetida;
    private int[] coleccionTemporal;
    private int contadorColeccion=0;
    private int[] codigoImagen=new int[2];
    private int contadorCodigo=0;
    private boolean encontrada= false,turnoJ1=false,turnoJ2=false;
    private int max,min;
    private String[] nombres,fechas,perdedores;
    private int[] punteos;
    
    }
