/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodememoria;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;

/**
 *
 * @author bryan
 */
public class FramePanel extends JPanel{
    
    //constructor
    public FramePanel(){
        
        //layout de framePanel    
        setLayout(new BorderLayout());
        
        //creando panel para menu
        panelMenu= new JPanel();
             
        //creando barra de menu
        JMenuBar barraMenu= new JMenuBar();
        
        //fuente y dimension para cada opcion de menu 
        Font miFuente= new Font("Arial",Font.BOLD,20);
        Dimension dim= new Dimension(115,30); 
        Dimension dim2= new Dimension(160,30);
        
        //*---------------------------------------------------------------------
        //creando opciones de menu
        JMenu juego= new JMenu("Juego");
        JMenu reportes= new JMenu("Reportes");
        JMenu acercaDe= new JMenu("Acerca De");
        JMenu ayuda= new JMenu("Ayuda");
             
        //aplicando dimension y fuente a cada opcion de menu
        juego.setPreferredSize(dim);
        juego.setFont(miFuente);        
        reportes.setPreferredSize(dim);
        reportes.setFont(miFuente);        
        acercaDe.setPreferredSize(dim);
        acercaDe.setFont(miFuente);        
        ayuda.setPreferredSize(dim);
        ayuda.setFont(miFuente);
        
        
        //agregando opciones de menu a la barra
        barraMenu.add(juego);
        barraMenu.add(reportes);
        barraMenu.add(acercaDe);
        barraMenu.add(ayuda);
        
        //----------------------------------------------------
        //creando submenus
        JMenuItem iniciarJuego=new JMenuItem("Iniciar Partida");
        
        //instanciando accion GestionaMenu para iniciar juego
        IniciarPartida iniciarPartida = new IniciarPartida();
        iniciarJuego.addActionListener(iniciarPartida);
        
        
        JMenuItem salirJuego=new JMenuItem("Salir del Juego");
        
        JMenuItem historialJugador=new JMenuItem("Historial de Ganadores");
        JMenuItem desarrollo=new JMenuItem("Desarrollador");
        JMenuItem version=new JMenuItem("Juego");
        
        //instanciando accion reporteJugadores
        reporteJugadores nuevoReporte = new reporteJugadores();
        historialJugador.addActionListener(nuevoReporte);
        
        JMenuItem mejorJugador=new JMenuItem("Mejor Jugador");
        
        //instanciando accion mejorJugador
        reporteMejorJugador nuevoReporte2= new reporteMejorJugador();
        mejorJugador.addActionListener(nuevoReporte2);
        
        //
        
        
        JMenuItem manual=new JMenuItem("Manual de Usuario");
        
         //instanciando accion Ayuda para manual de Usuario
        Ayuda1 opcionManual = new Ayuda1();
        manual.addActionListener(opcionManual);
        
        JMenuItem resumen=new JMenuItem("Como Jugar");
        
        //instanciando accion Ayuda para manual de Usuario
        Ayuda2 opcionResumen = new Ayuda2();
        resumen.addActionListener(opcionResumen);
        
        //instanciando accion acerca de
        AcercaDeJuego vers = new AcercaDeJuego();
        version.addActionListener(vers);
        
        //instanciando accion acercade
        AcercaDeCreador cread = new AcercaDeCreador();
        desarrollo.addActionListener(cread);
        
        //agregando submenus al menu principal de opciones
        juego.add(iniciarJuego);
        juego.add(salirJuego);
        
        reportes.add(historialJugador);
        reportes.add(mejorJugador);
        ayuda.add(manual);
        ayuda.add(resumen);
        acercaDe.add(desarrollo);
        acercaDe.add(version);
        
        //creando Spinner de fecha y Hora
        fechaHora=new JSpinner(new SpinnerDateModel());
        fechaHora.setEnabled(false);
        fechaHora.setPreferredSize(dim2);
        
        //*---------------------------------------------------------------------
        //agregando barraMenu al panel        
        panelMenu.add(barraMenu);
         //agregando spinner de fecha hora
        panelMenu.add(new JLabel("  Fecha y Hora: "));
        panelMenu.add(fechaHora);
        
        //borde menu
        panelMenu.setBorder(BorderFactory.createRaisedBevelBorder());
        panelMenu.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(),"Menu De Opciones"));
        
        //agregando layout
        add(panelMenu,BorderLayout.NORTH);
        
        //*----------------------------------------------------------------------
        
        //creando panel principal
        panelPrincipal= new JPanel();
        
        //Gridlayout para rejilla  5 columnas 2 filas
        panelPrincipal.setLayout(new GridLayout(2,5));
        
        /**
         * Agregando imagenes de cartas de forma practica
         * Usando metodo ponerCarta()
         **/
        
        /* parametro se almacena en rotulo
         */      
        ponerCarta(new ImageIcon("src/graficos/d5.png"));
        ponerCarta(new ImageIcon("src/graficos/d6.png"));
        ponerCarta(new ImageIcon("src/graficos/d7.png"));
        ponerCarta(new ImageIcon("src/graficos/d8.png"));
        ponerCarta(new ImageIcon("src/graficos/d9.png"));
        ponerCarta(new ImageIcon("src/graficos/d1.png"));
        ponerCarta(new ImageIcon("src/graficos/d2.png"));
        ponerCarta(new ImageIcon("src/graficos/d3.png"));
        ponerCarta(new ImageIcon("src/graficos/d4.png"));
        ponerCarta(new ImageIcon("src/graficos/d10.png"));
        
        //caracteristicas de panel principal
        panelPrincipal.setBackground(Color.YELLOW);
        panelPrincipal.setBorder(BorderFactory.createLoweredBevelBorder());
        //agregando panel principal al Frame Panel
        add(panelPrincipal,BorderLayout.CENTER);
        
        //agregando scroll al panel principa; adaptable vertical y hor.
        JScrollPane scroller= new JScrollPane(panelPrincipal);
        scroller.setPreferredSize(new Dimension(200,200));
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(scroller);
        
    
    }
    
    /**
     * Creacion de metodo encargado de 
     * crear cartas de una forma mas
     * accesible
     **/
    
    //recibe parametros enviados desde ponerCarta()
    private void ponerCarta(ImageIcon rotulo){
        
        //instanciacion de JLabel
        JLabel carta=new JLabel(rotulo);
        carta.setVerticalTextPosition(JLabel.BOTTOM);
        carta.setHorizontalAlignment(JLabel.CENTER);
        carta.setBorder(BorderFactory.createLoweredBevelBorder());
        
        //agregando carta al Panel2
        panelPrincipal.add(carta);
    
    }
    
    //Gestion de eventos para el menu Juego 
    private class IniciarPartida implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            JOptionPane.showMessageDialog(FramePanel.this, "Hola!! Bienvenidos al juego para iniciar deben tomar en cuenta lo siguiente:"
                    + "\n1.Ingresar el nombre de los dos Jugadores.\n2.Elegir Dificultad del Juego."
                    + "\n3.El primer turno es Aleatorio.\n4.Para voltear una carta hacer 'click' sobre ella. ", "Nueva Partida", 2,new ImageIcon("src/graficos2/info.png"));
            
            nombreJugador1=JOptionPane.showInputDialog(FramePanel.this,"Nombre: ","Jugador 1",3);
            nombreJugador2=JOptionPane.showInputDialog(FramePanel.this,"Nombre: ","Jugador 2",3);
            
            //System.out.println("los nombres ingresados son: "+nombreJugador1+"  "+nombreJugador2);
            
            dificultad=JOptionPane.showOptionDialog(FramePanel.this, "Opciones (No.Parejas)", "Dificultad de Juego",1,1, null,opciones, null);
            
            
        //creando nueva ventana para juego
        PlayerFrame2 frame2= new PlayerFrame2(dificultad);
        
        frame2.setTitle("Partida Nueva");
        frame2.setBounds(500,300,500,350);
        
        //haciendo visible el Frame
        frame2.setVisible(true);
        
        //accion de cierre
        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        //ventana completa
        frame2.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        //FramePanel2 nuevoPanel= new FramePanel2();
        
        //frame2.add(nuevoPanel);
                          
        }
    }
    
    private class AcercaDeCreador implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            JOptionPane.showMessageDialog(FramePanel.this, "Desarrollador: Bryan Monzon "
                    + "\nExperiencia: 4 meses"
                    + "\nUniversidad: CUNOC-USAC"
                    + ""+"Carrera: Ingenieria En Ciencias y Sistemas", "Acerca del Desarrollador",2,new ImageIcon("src/graficos2/des.png"));
            
        }
    
        
    }
    
    private class AcercaDeJuego implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            JOptionPane.showMessageDialog(FramePanel.this, "Nombre: Juego de Memoria "
                    + "\nVersion:1.0"
                    + ""+"","Acerca del Juego",2,new ImageIcon("src/graficos2/info.png"));
            
        }
    
        
    }
    
    
    private class Ayuda1 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            //creando nueva ventana para juego
        FrameManual frame2= new FrameManual();
        
        frame2.setTitle("Ayuda al Usuario");
        frame2.setBounds(500,300,500,350);
        
        //haciendo visible el Frame
        frame2.setVisible(true);
        
        //accion de cierre
        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        //ventana completa
        frame2.setExtendedState(JFrame.MAXIMIZED_BOTH);                        
            
        }
        
    }
    private class Ayuda2 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            JOptionPane.showMessageDialog(FramePanel.this, "1. Dirijete a la opcion 'Juego' del menu de Opciones "
                    + "\n\n2.Haz click sobre la opcion 'Iniciar Partida'"
                    + "\n\n3.Lee las instrucciones breves que se te daran antes de iniciar el juego.\n\n"
                    + "4.Ya puedes jugar(verifica siempre tu turno en la parte baja)"+"\n\n5. Si ahun no entiendes dale un vistazo al manual de usuario", "Como Jugar",2,new ImageIcon("src/graficos2/info.png"));
            
        }
    
        
    }
    
    private class reporteJugadores implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        
        try{
            //creando nueva ventana para juego
        FrameReporte frame3= new FrameReporte();
        
        frame3.setTitle("Historial de Ganadores");
        frame3.setBounds(400,100,600, 400);
        
        //haciendo visible el Frame
        frame3.setVisible(true);
        
        //accion de cierre
        frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        //ventana completa
        //frame3.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
        catch(Exception excepcionDeTabla){
        
            JOptionPane.showMessageDialog(FramePanel.this, "El Reporte de Ganadores esta Vacio\n incicia una Nueva Partida", "",0);
        }
        }
    
    
    }
    
    private class reporteMejorJugador implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            
        }
    
    }

    //encapsulando miPanel2 principio  y pantalla para ser accedidos dentro de la clase
    public static JPanel panelMenu;
    public static JPanel panelPrincipal;
    private JSpinner fechaHora;
    private static String nombreJugador1;
    private static String nombreJugador2;
    private int dificultad;
    private String[] opciones={"Facil (5 P)","Medio (10 P)","Dificil (15 P)"};

    public static String getNombreJugador1() {
        return nombreJugador1;
    }

    public static void setNombreJugador1(String nombreJugador1) {
        FramePanel.nombreJugador1 = nombreJugador1;
    }

    public static String getNombreJugador2() {
        return nombreJugador2;
    }

    public static void setNombreJugador2(String nombreJugador2) {
        FramePanel.nombreJugador2 = nombreJugador2;
    }
    
    
    
}