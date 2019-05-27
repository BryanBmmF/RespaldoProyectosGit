/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2compi1.frontend;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JViewport;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.*;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.UndoManager;
import proyecto2compi1.Lexer;
import proyecto2compi1.Lexer2;
import proyecto2compi1.backend.archivos.ControladorDeArchivos;
import proyecto2compi1.parser;
import proyecto2compi1.parserInterprete;

/**
 *
 * @author bryan
 */
public class JFramePrincipal extends javax.swing.JFrame {
    
//    private JScrollPane scrol;
//    private JTextArea textArea;
    public static final String ARCHIVO_NUEVO="Archivo Nuevo sin Guardar";
    public static final String GUARDAR_CAMBIOS="Desea Guardar Cambios al archivo?";
    public static final String GUARDAR_ARCHIVO="Desea Guardar este Archivo?";
    public static final String PATRON_ENC="' este patron fue encontrado en el texto.";
    public static final String PATRON_NO_ENC="' este patron no fue encontrado en el texto.";
    public static final String PATH_ICONO="src/proyecto2compi1/frontend/img/iconoAnalizador.png";
    
    private HashMap<String, Integer> variablesInstruc;
    private HashMap<String, Integer> variablesArchiv;
    //private HashMap<String, String> variablesArchi;
    private HashMap<String, Integer> variablesInteger;
    private HashMap<String, Boolean> variablesBoolean;
    private HashMap<String, String> variablesString;
    private Lexer lexer;
    private parser parser;
    
    private Lexer2 lexer2;
    private parserInterprete parser2;
    
    private SimpleAttributeSet normal;
    private SimpleAttributeSet boldBlue;
    private SimpleAttributeSet highAlert;
    
    private ControladorDeArchivos controlador;
    
    private String porError;
    private String porTipoError;
    private String porArchivo;
    
    private String lexicos;
    private String sintacticos;
    private String semanticos;
    
    private int contLexicos;
    private int contSemanticos;
    private int contSintacticos;
    
    private JTextPane jtp;
    private JScrollPane scrol2;

    /**
     * Creates new form JFramePrincipal
     */
    public JFramePrincipal() {
        initComponents();
        
        this.lexer2 = new Lexer2(new StringReader(""), this.txtErroresLexicos);
        this.parser2 = new parserInterprete(lexer2, this);
        
        //clase toolkit devuelve la resolucion nativa del sistema huesped        
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        //colocacion de icono a la pantalla
        Image icono=miPantalla.getImage(PATH_ICONO);      
        setIconImage(icono);
        
        btnDeshacer.setEnabled(false);// deshabilitando botones de rehacer deshacer
        btnRehacer.setEnabled(false);
        
        hilit = new DefaultHighlighter();
        painter = new DefaultHighlighter.DefaultHighlightPainter(Color.GREEN);
        painter2 = new DefaultHighlighter.DefaultHighlightPainter(Color.CYAN);
        
        //atributos del texto
        this.normal = new SimpleAttributeSet();
        this.boldBlue  = new SimpleAttributeSet(normal);
        this.highAlert  = new SimpleAttributeSet(boldBlue);
        
        this.controlador = new ControladorDeArchivos();
        this.porError = "";
        this.porTipoError = "";
        this.porArchivo = "";
        this.lexicos = "";
        this.semanticos = "";
        this.sintacticos = "";
        
        this.contLexicos = 1;
        this.contSintacticos = 1;
        this.contSemanticos = 1;
        
        this.jtp = new JTextPane();
        this.scrol2 = new JScrollPane();
        setLocationRelativeTo(null);
        
    }
    
    /*
    para guardar la ruta y el nombre de cada archivo que se abre , utilizar una tabla 
    hash map para asi manejar de una mejro manera todos los archivos abiertos
    */

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtErroresLexicos = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtInterpretacion = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnDeshacer = new javax.swing.JButton();
        btnRehacer = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        panel = new javax.swing.JTabbedPane();
        panel2 = new javax.swing.JTabbedPane();
        jLabel1 = new javax.swing.JLabel();
        status = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtErroresLexicos.setEditable(false);
        txtErroresLexicos.setColumns(20);
        txtErroresLexicos.setRows(5);
        jScrollPane1.setViewportView(txtErroresLexicos);

        jLabel2.setText("Errores lexicos - > Errores sintacticos");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identificador", "Tipo", "Valor Actual"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tabla);

        jLabel3.setText("Tabla de Variables:");

        txtInterpretacion.setEditable(false);
        txtInterpretacion.setColumns(20);
        txtInterpretacion.setRows(5);
        jScrollPane2.setViewportView(txtInterpretacion);

        jLabel4.setText("Codigo a Interpretar:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap(310, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jToolBar1.setRollover(true);

        jButton1.setText("agregar +");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setText("cerrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton3.setText("mostrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2compi1/frontend/img/limpiar.png"))); // NOI18N
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        btnDeshacer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2compi1/frontend/img/deshacer.png"))); // NOI18N
        btnDeshacer.setFocusable(false);
        btnDeshacer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDeshacer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDeshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeshacerActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDeshacer);

        btnRehacer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2compi1/frontend/img/rehacer.png"))); // NOI18N
        btnRehacer.setFocusable(false);
        btnRehacer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRehacer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRehacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRehacerActionPerformed(evt);
            }
        });
        jToolBar1.add(btnRehacer);

        jButton5.setText("Interpretar");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton5);

        jButton6.setText("probar");
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton6);

        jButton7.setText("ejecutar Todo");
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton7);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        panel.setBackground(new java.awt.Color(204, 255, 204));
        panel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        panel2.setBackground(new java.awt.Color(204, 255, 204));
        panel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Estado:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                    .addComponent(panel)))
        );

        jMenu1.setText("File");

        jMenuItem1.setText("Nuevo ");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem4.setText("Abrir ");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem2.setText("Guardar ");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Guardar como");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void reiniciarContadoresErrores(){
        this.contLexicos = 1;
        this.contSintacticos = 1;
        this.contSemanticos = 1;
    }
    
    public void reiniciarErrores(){
        this.lexicos = "";
        this.semanticos = "";
        this.sintacticos = "";
    }
    public void reiniciarPanelSalida(){
            this.jtp = new JTextPane();
            this.scrol2 = new JScrollPane();
    }
    public void agregarError(int linea, int columna, String error, int indexTab){
            porError+=" <error>\n"
                    + "     <linea>"+linea+"</linea>\n"
                    + "     <columna>"+columna+"</columna>\n"
                    + "     <descripcion>"+error+"</descripcion>\n"
                    + "     <archivo>"+panel.getTitleAt(indexTab)+"</archivo>"
                    + " </error>\n";
            
    }
    
    public void agregarErrorSemantico(int linea, int columna, String error, int indexTab){
            semanticos+=" <error"+contSemanticos+">\n"
                    + "     <linea>"+linea+"</linea>\n"
                    + "     <columna>"+columna+"</columna>\n"
                    + "     <descripcion>"+error+"</descripcion>\n"
                    + "     <archivo>"+panel.getTitleAt(indexTab)+"</archivo>"
                    + " </error"+contSemanticos+">\n";
            contSemanticos++;
    }
    public void agregarErrorSintactico(int linea, int columna, String error, int indexTab){
            sintacticos+=" <error"+contSintacticos+">\n"
                    + "     <linea>"+linea+"</linea>\n"
                    + "     <columna>"+columna+"</columna>\n"
                    + "     <descripcion>"+error+"</descripcion>\n"
                    + "     <archivo>"+panel.getTitleAt(indexTab)+"</archivo>"
                    + " </error"+contSintacticos+">\n";
            contSintacticos++;
    }
    public void agregarErrorLexico(int linea, int columna, String error, int indexTab){
            lexicos+=" <error"+contLexicos+">\n"
                    + "     <linea>"+linea+"</linea>\n"
                    + "     <columna>"+columna+"</columna>\n"
                    + "     <descripcion>"+error+"</descripcion>\n"
                    + "     <archivo>"+panel.getTitleAt(indexTab)+"</archivo>"
                    + " </error"+contLexicos+">\n";
            contLexicos++;
    }
    public void agregarErrorArchivo(int indexTab){
            porArchivo+="<archivo nombre=\""+panel.getTitleAt(indexTab)+"\">\n"
                    + " <Lexicos>\n"+lexicos+"\n </Lexicos>\n"
                    + " <Sintacticos>\n"+sintacticos+"\n </Sintacticos>\n"
                    + " <Semanticos>\n"+semanticos+"\n </Semanticos>\n"
                    + " </archivo>\n";
    }
    
    public void generarArchivoErrores(){
            String texto = "";
            
            texto+="<errores>"+"\n"+porError+"\n</errores>"+"\n\n"
                    +"<errores>"+"\n"
                    +"  <Semantico>\n"+semanticos+"\n</Semantico>\n"
                    +"  <Lexico>\n"+lexicos+"\n</Lexico>\n"
                    +"  <Sintactico>\n"+sintacticos+"\n</Sintactico>\n"
                    +"</errores>"+"\n\n"
                    +"<errores>"+"\n"+porArchivo+"\n</errores>"+"\n\n";
            controlador.exportarAarchivo(controlador.getArch(), texto, "");
    
    }
    
    
    public void reestablecerAtributosTexto(){
            //atributos del texto
        this.normal = new SimpleAttributeSet();
        //StyleConstants.setAlignment(normal, StyleConstants.ALIGN_LEFT);
        
        this.boldBlue  = new SimpleAttributeSet(normal);
        this.highAlert  = new SimpleAttributeSet(boldBlue);
            
    }
    
    public void establecerLetra(String tipo){
            //atributos del texto
        StyleConstants.setFontFamily(normal, tipo);
  
    }
    public void establecerTamLetra(int tam){
            //atributos del texto
        StyleConstants.setFontSize(normal, tam);
            
    }
    
    public void establecerAtributosColor(String color){
            //atributos del texto
        StyleConstants.setBold(boldBlue, true);
        StyleConstants.setForeground(boldBlue, Color.blue);
            
    }
    public void establecerAtributosFondo(String color, int tam){
            //atributos del texto
            StyleConstants.setFontSize(highAlert, tam);
            StyleConstants.setItalic(highAlert, true);
            StyleConstants.setForeground(highAlert, Color.red);
            
    }
    
    public void centrarTexto(String s){
            try {
            StyledDocument doc = (StyledDocument) jtp.getDocument(); //obteniendo model de jtp
            
            StyleConstants.setAlignment(normal, 12);
            
            doc.insertString(doc.getLength(), s + "\n", normal);
            
            //panel2.addTab("nuevo", jtp);
            
        } catch (BadLocationException ex) {
            Logger.getLogger(JFramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void mostrarTexto(String s){
        try {
            StyledDocument doc = (StyledDocument) jtp.getDocument();
            
            //establecerAtributosLetra(s, 20);
            //establecerAtributosColor(s);
            //establecerAtributosFondo(s, 20);
            
            //doc.insertString(doc.getLength(), s + "\n", normal);
            //doc.insertString(doc.getLength(), s + "\n", boldBlue);
            doc.insertString(doc.getLength(), s + "\n", highAlert);
            
            //panel2.addTab("nuevo", jtp);
            
        } catch (BadLocationException ex) {
            Logger.getLogger(JFramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JScrollPane scrol = new JScrollPane();
        JTextArea textArea= new JTextArea();
        //instanciando clase Oyente para evento caretUpdate
        EventoCaretUpdate miEvento= new EventoCaretUpdate();
        //instanciando clase Oyente para evento Rehacer
        LanzarEventHacerRehacer miEvento2= new LanzarEventHacerRehacer();
        
        //llamando metodo ActionListener enviando miEvento y miEvento2 para e 
        textArea.addCaretListener(miEvento);
        textArea.getDocument().addUndoableEditListener(miEvento2);
        textArea.setHighlighter(hilit);
        
        scrol.setViewportView(textArea);
        panel.addTab("nuevo", scrol);
    }//GEN-LAST:event_jButton1ActionPerformed
    public void agregaarSalidaNavegador(){
        scrol2.setViewportView(jtp);
        panel2.addTab("salida", scrol2);
        
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
            int confirmar = JOptionPane.showConfirmDialog(this, GUARDAR_CAMBIOS);
            JScrollPane scrol = (JScrollPane)panel.getComponentAt(panel.getSelectedIndex());    
            JViewport port = (JViewport)scrol.getComponent(0);
            JTextArea textArea= (JTextArea)port.getComponent(0);
            
                    //ControladorDeArchivos controlador= new ControladorDeArchivos();
                    if (confirmar==0) {//si quiere guardar cambios
                            System.out.println(panel.getTitleAt(panel.getSelectedIndex()));
                            if (controlador.retornarArchivo(panel.getTitleAt(panel.getSelectedIndex()))!=null) {
                                    //si es archivo ya abierto se guardan sus cambios
                                    controlador.guardarCambiosArchivo(controlador.retornarArchivo
                                            (panel.getTitleAt(panel.getSelectedIndex())).getPath(), textArea.getText());
                                    panel.removeTabAt(panel.getSelectedIndex());
                            } else {
                                    System.out.println(panel.getTitleAt(panel.getSelectedIndex()));
                                    guardarArchivo();//se guarda el archivo nuevo
                                    panel.removeTabAt(panel.getSelectedIndex());
                            }
                            
                    } 
                    if (confirmar==1) {
                            panel.removeTabAt(panel.getSelectedIndex());//solo se cierra la ventana
                    }
                    
                    
    }//GEN-LAST:event_jButton2ActionPerformed
    private void guardarArchivo() {
            JScrollPane scrol = (JScrollPane)panel.getComponentAt(panel.getSelectedIndex());    
            JViewport port = (JViewport)scrol.getComponent(0);
            JTextArea textArea= (JTextArea)port.getComponent(0);
            
            ControladorDeArchivos controlador= new ControladorDeArchivos();
             /**llamamos el metodo que permite cargar la ventana*/
            JFileChooser file=new JFileChooser();
            file.showSaveDialog(this);
            controlador.exportarAarchivo(file.getSelectedFile(), textArea.getText(),"");//por defecto sin extension
            
    }
    
    
    
    private void guardarArchivoErrores() {
            ControladorDeArchivos controlador= new ControladorDeArchivos();
             /**llamamos el metodo que permite cargar la ventana*/
            JFileChooser file=new JFileChooser();
            file.setDialogTitle("Guardar Archivo de Errores");
            file.showSaveDialog(this);
            
            controlador.setArch(file.getSelectedFile());//se guarda el archivo en donde guardar los errores
            //System.out.println(file.getSelectedFile().getName());
            
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
            //panel.getComponentAt(panel.getSelectedIndex());
            /*
                Obtenemos el componente seleccionado del panel de pestanas
                del scrolPane obtenemos el view port
                del view port obtenemos el text area finalmente
                todos suponiendo que se encuentran en la posicion 0 de los compenentes
            */
            JScrollPane scrol = (JScrollPane)panel.getComponentAt(panel.getSelectedIndex());    
            JViewport port = (JViewport)scrol.getComponent(0);
            JTextArea textArea= (JTextArea)port.getComponent(0);
            
            System.out.println(textArea.getText());            
            
            //panel.getTabComponentAt(panel.getSelectedIndex());
                    
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeshacerActionPerformed
        // TODO add your handling code here:
            try {
                    undoManager.undo();//manejador deshace
            } catch (CannotRedoException cre) {
                    cre.printStackTrace();
            }
            updateButtons();
    }//GEN-LAST:event_btnDeshacerActionPerformed

    private void btnRehacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRehacerActionPerformed
        // TODO add your handling code here:
            try {
                    undoManager.redo();//manejador rehace
            } catch (CannotRedoException cre) {
                    cre.printStackTrace();
            }
            updateButtons();
    }//GEN-LAST:event_btnRehacerActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
            JScrollPane scrol = (JScrollPane)panel.getComponentAt(panel.getSelectedIndex());    
            JViewport port = (JViewport)scrol.getComponent(0);
            JTextArea textArea= (JTextArea)port.getComponent(0);
            
            textArea.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        JScrollPane scrol = new JScrollPane();
        JTextArea textArea= new JTextArea();
        //instanciando clase Oyente para evento caretUpdate
        EventoCaretUpdate miEvento= new EventoCaretUpdate();
        //instanciando clase Oyente para evento Rehacer
        LanzarEventHacerRehacer miEvento2= new LanzarEventHacerRehacer();
        
        //llamando metodo ActionListener enviando miEvento y miEvento2 para e 
        textArea.addCaretListener(miEvento);
        textArea.getDocument().addUndoableEditListener(miEvento2);
        textArea.setHighlighter(hilit);
        
        /**llamamos el metodo que permite cargar la ventana*/
        JFileChooser file=new JFileChooser();
        file.showOpenDialog(this);
        
        //ControladorDeArchivos controlador= new ControladorDeArchivos();
        //guardando archivo para consulta
        controlador.agregarArchivo(file.getSelectedFile().getName(), file.getSelectedFile());
        //cargando texto en la nueva area
        textArea.setText(controlador.cargarArchivo(file.getSelectedFile()));
        
        //agregando al scroll el text area
        scrol.setViewportView(textArea);
        //agregando nueva pesta?a
        panel.addTab(file.getSelectedFile().getName(), scrol);        
        
        
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
            /*
                Obtenemos el componente seleccionado del panel de pestanas
                del scrolPane obtenemos el view port
                del view port obtenemos el text area finalmente
                todos suponiendo que se encuentran en la posicion 0 de los compenentes
            */
            this.lexer = new Lexer(new StringReader(""), this.txtErroresLexicos,this,panel.getSelectedIndex());
            this.parser = new parser(lexer, this,panel.getSelectedIndex());
            reiniciarPanelSalida();//reiniciando el panel que contendra la nueva salida
            //inicializarTablasVariables();//reiniciando tabla variables quitar comentario y probar
            reiniciarContadoresErrores();
            //reiniciarErrores();
            reestablecerAtributosTexto();
            JScrollPane scrol = (JScrollPane)panel.getComponentAt(panel.getSelectedIndex());    
            JViewport port = (JViewport)scrol.getComponent(0);
            JTextArea textArea= (JTextArea)port.getComponent(0);

            guardarArchivoErrores();
            String entrada = textArea.getText();
            System.out.println(entrada);
            txtErroresLexicos.setText("");//limpiando area de mensajes
            //txtErroresSintac.setText("");//limpiando area de mensajes

            System.out.println("Entrada a parsear: "+entrada);
            this.lexer.yyreset(new StringReader(entrada));
            try {
                    this.parser.parse();
            } catch (Exception ex) {
                    Logger.getLogger(JFramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println(parser.devolverCodigoHtmlFinal());
            txtInterpretacion.setText(parser.devolverCodigoHtmlFinal());
            
            agregarErrorArchivo(panel.getSelectedIndex());//errores Generados
            generarArchivoErrores();
            
            //////INTERPRETACION\
            //agregaarSalidaNavegador();//agregando ventana para interpretar
            String entrada2 = txtInterpretacion.getText();
            System.out.println("Entrada a Interpretar: "+entrada2);
            this.lexer2.yyreset(new StringReader(entrada2));
            try {
                    this.parser2.parse();
            } catch (Exception ex) {
                    Logger.getLogger(JFramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            agregaarSalidaNavegador();//agregando ventana para interpretar
            
            
            
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            // TODO add your handling code here:
            String s = new Date().toString();
            //JTextPane jtp = new JTextPane();
            //StyledDocument doc = (StyledDocument) jtp.getDocument();
            
            //ALINEAR TEXTO
//            StyleConstants.setAlignment(normal, StyleConstants.ALIGN_CENTER);
//            doc.setParagraphAttributes(0, doc.getLength(), normal, false);
//            doc.insertString(doc.getLength(), s + "\n", normal);
            
            //TEXTO NEGRILLA
//             StyleConstants.setBold(normal, true);
//             doc.insertString(doc.getLength(), s + "\n", normal);
             
            //TEXTO SUBRAYADO
//            StyleConstants.setUnderline(normal, true);
//            doc.insertString(doc.getLength(), s + "\n", normal);
            
            //TEXTO ITALICA
//            StyleConstants.setItalic(normal, true);
//            doc.insertString(doc.getLength(), s + "\n", normal);
            
            //TEXTO TACHADO
//            StyleConstants.setStrikeThrough(normal, true);
//            doc.insertString(doc.getLength(), s + "\n", normal);
            
            //TEXTO SUBINDICE
//            StyleConstants.setSubscript(normal, true);
//            doc.insertString(doc.getLength(), s + "\n", normal);

            //TEXTO SUPERINDICE
//            StyleConstants.setSuperscript(normal, true);
//            doc.insertString(doc.getLength(), s + "\n", normal);

            //doc.insertString(doc.getLength(), s + "\n", boldBlue);
            //doc.insertString(doc.getLength(), s + "\n", highAlert);
            
            //APLICANDO ATRIBUTOS POR SEPARADO
            aplicarAtributoSeparado("NEGRILLA", s);
            
            //atributos propios del jtp en este caso el body
            jtp.setBackground(Color.BLUE);//fondo
            jtp.setForeground(Color.RED);//texto
            panel2.addTab("nuevo", jtp);//ver ventana
        } catch (Exception ex) {
            Logger.getLogger(JFramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jButton6ActionPerformed
    public void aplicarColorFondo(String color){
        if (color.equalsIgnoreCase("black")) {
                jtp.setBackground(Color.BLACK);//fondo
        } else if (color.equalsIgnoreCase("red")) {
                jtp.setBackground(Color.RED);//fondo
        } else if (color.equalsIgnoreCase("blue")) {
                jtp.setBackground(Color.BLUE);//fondo
        } else if (color.equalsIgnoreCase("gray")) {
                jtp.setBackground(Color.GRAY);//fondo
        } else if (color.equalsIgnoreCase("green")) {
                jtp.setBackground(Color.GREEN);//fondo
        } else if (color.equalsIgnoreCase("white")) {
                jtp.setBackground(Color.WHITE);//fondo
        } else if (color.equalsIgnoreCase("purple")) {
                jtp.setBackground(Color.MAGENTA);//fondo
        } else if (color.equalsIgnoreCase("gray")) {
                jtp.setBackground(Color.GRAY);//fondo
        } else if (color.equalsIgnoreCase("yellow")) {
                jtp.setBackground(Color.YELLOW);//fondo
        }
    
    }
    public void aplicarTipoTextoFondo(String color){
        if (color.equalsIgnoreCase("black")) {
                jtp.setForeground(Color.BLACK);//fondo
        } else if (color.equalsIgnoreCase("red")) {
                jtp.setForeground(Color.RED);//fondo
        } else if (color.equalsIgnoreCase("blue")) {
                jtp.setForeground(Color.BLUE);//fondo
        } else if (color.equalsIgnoreCase("gray")) {
                jtp.setForeground(Color.GRAY);//fondo
        } else if (color.equalsIgnoreCase("green")) {
                jtp.setForeground(Color.GREEN);//fondo
        } else if (color.equalsIgnoreCase("white")) {
                jtp.setForeground(Color.WHITE);//fondo
        } else if (color.equalsIgnoreCase("purple")) {
                jtp.setForeground(Color.MAGENTA);//fondo
        } else if (color.equalsIgnoreCase("gray")) {
                jtp.setForeground(Color.GRAY);//fondo
        } else if (color.equalsIgnoreCase("yellow")) {
                jtp.setForeground(Color.YELLOW);//fondo
        }
    
    }
    public void aplicarAtributosBody(String tipo, String color){
            switch (tipo) {
                case "FONDO":{
                    aplicarColorFondo(color);
                    break;
                }
                case "TEXTO":{
                    aplicarTipoTextoFondo(color);
                    break;
                }

                default:
                    throw new AssertionError();
            }
    }
    
    public void aplicarVariosAtributos(HashMap<String, String> atributos, String texto){
            reestablecerAtributosTexto();
            StyledDocument doc = (StyledDocument) jtp.getDocument();
            for (String key: atributos.keySet()){
                    switch (key) {
                        case "ALINEACION":{
                                //StyleConstants.setBold(normal, true);
                                if (atributos.get(key).equalsIgnoreCase("center")) {
                                        StyleConstants.setAlignment(normal, StyleConstants.ALIGN_CENTER);
                                        doc.setParagraphAttributes(0, doc.getLength(), normal, false);
                                } else if (atributos.get(key).equalsIgnoreCase("left")) {
                                        StyleConstants.setAlignment(normal, StyleConstants.ALIGN_LEFT);
                                        doc.setParagraphAttributes(0, doc.getLength(), normal, false);
                                } else if (atributos.get(key).equalsIgnoreCase("right")) {
                                        StyleConstants.setAlignment(normal, StyleConstants.ALIGN_RIGHT);
                                        doc.setParagraphAttributes(0, doc.getLength(), normal, false);
                                } else if (atributos.get(key).equalsIgnoreCase("justified")) {
                                        StyleConstants.setAlignment(normal, StyleConstants.ALIGN_JUSTIFIED);
                                            doc.setParagraphAttributes(0, doc.getLength(), normal, false);
                                }
                            break;
                        }
                        case "COLOR_FONDO":{
                                aplicarAtributosBody("FONDO", atributos.get(key));
                            break;
                        }
                        case "TEXTO_FONDO":{
                                aplicarAtributosBody("TEXTO", atributos.get(key));
                            break;
                        }/*SEFUIR AGREANDO LOS DEMAS ATRIBUTOS....*/
                        case "TACHADO":{
                                StyleConstants.setStrikeThrough(normal, true);
                            break;
                        }
                        case "SUB":{
                                StyleConstants.setSubscript(normal, true);
                            break;
                        }
                        case "SUP":{
                                StyleConstants.setSuperscript(normal, true);
                            break;
                        }
                        case "TITULO":{
                                //StyleConstants.setSuperscript(normal, true);
                            break;
                        }
                        case "SIN_ATRIBUTO":{
                                //StyleConstants.setSuperscript(normal, true);
                            break;
                        }
                        
                        default:
                            //throw new AssertionError();
                    }
                    
                    //if (key.equals(var)) {
                    //valor =variablesString.get(key);    
                    //break;
                    //}
            
            }
            
         try {
            doc.insertString(doc.getLength(), texto + "\n", normal);
        } catch (BadLocationException ex) {
            Logger.getLogger(JFramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    public void aplicarAtributoSeparado(String tipo, String texto){
            reestablecerAtributosTexto();
            StyledDocument doc = (StyledDocument) jtp.getDocument();
            
            if (tipo.equalsIgnoreCase("center")) {
                    StyleConstants.setAlignment(normal, StyleConstants.ALIGN_CENTER);
                    doc.setParagraphAttributes(0, doc.getLength(), normal, false);
            } else if (tipo.equalsIgnoreCase("left")) {
                    StyleConstants.setAlignment(normal, StyleConstants.ALIGN_LEFT);
                    doc.setParagraphAttributes(0, doc.getLength(), normal, false);
            } else if (tipo.equalsIgnoreCase("right")) {
                    StyleConstants.setAlignment(normal, StyleConstants.ALIGN_RIGHT);
                    doc.setParagraphAttributes(0, doc.getLength(), normal, false);
            } else if (tipo.equalsIgnoreCase("justified")) {
                    StyleConstants.setAlignment(normal, StyleConstants.ALIGN_JUSTIFIED);
                        doc.setParagraphAttributes(0, doc.getLength(), normal, false);
            } else {
                    switch (tipo) {
                        case "NEGRILLA":{
                                StyleConstants.setBold(normal, true);
                            break;
                        }
                        case "SUBRAYADO":{
                                StyleConstants.setUnderline(normal, true);
                            break;
                        }
                        case "ITALICA":{
                                StyleConstants.setItalic(normal, true);
                            break;
                        }
                        case "TACHADO":{
                                StyleConstants.setStrikeThrough(normal, true);
                            break;
                        }
                        case "SUB":{
                                StyleConstants.setSubscript(normal, true);
                            break;
                        }
                        case "SUP":{
                                StyleConstants.setSuperscript(normal, true);
                            break;
                        }
                        case "TITULO":{
                                //StyleConstants.setSuperscript(normal, true);
                            break;
                        }
                        case "SIN_ATRIBUTO":{
                                //StyleConstants.setSuperscript(normal, true);
                            break;
                        }
                        
                        default:
                            //throw new AssertionError();
                    }
            
            }
            

        
        try {
            doc.insertString(doc.getLength(), texto + "\n", normal);
        } catch (BadLocationException ex) {
            Logger.getLogger(JFramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        JScrollPane scrol = new JScrollPane();
        JTextArea textArea= new JTextArea();
        //instanciando clase Oyente para evento caretUpdate
        EventoCaretUpdate miEvento= new EventoCaretUpdate();
        //instanciando clase Oyente para evento Rehacer
        LanzarEventHacerRehacer miEvento2= new LanzarEventHacerRehacer();
        
        //llamando metodo ActionListener enviando miEvento y miEvento2 para e 
        textArea.addCaretListener(miEvento);
        textArea.getDocument().addUndoableEditListener(miEvento2);
        textArea.setHighlighter(hilit);
        
        scrol.setViewportView(textArea);
        panel.addTab("nuevo", scrol);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
            JScrollPane scrol = (JScrollPane)panel.getComponentAt(panel.getSelectedIndex());    
            JViewport port = (JViewport)scrol.getComponent(0);
            JTextArea textArea= (JTextArea)port.getComponent(0);
                    if (controlador.retornarArchivo(panel.getTitleAt(panel.getSelectedIndex()))!=null) {
                                    //si es archivo ya abierto se guardan sus cambios
                                    controlador.guardarCambiosArchivo(controlador.retornarArchivo
                                            (panel.getTitleAt(panel.getSelectedIndex())).getPath(), textArea.getText());
                                    //panel.removeTabAt(panel.getSelectedIndex());
                            } else {
                                    System.out.println(panel.getTitleAt(panel.getSelectedIndex()));
                                    //guardarArchivo();//se guarda el archivo nuevo
                                    
                                     /**llamamos el metodo que permite cargar la ventana para guardar el archivo*/
                                    JFileChooser file=new JFileChooser();
                                    file.showSaveDialog(this);
                                    controlador.exportarAarchivo(file.getSelectedFile(), textArea.getText(),"");//por defecto sin extension
                                    //cerramos ventana actual
                                    panel.removeTabAt(panel.getSelectedIndex());
                                    
                                    //agregamos ek archivo
                                    controlador.agregarArchivo(file.getSelectedFile().getName(), file.getSelectedFile());
                                    
                                    JScrollPane scrol2 = new JScrollPane();
                                    JTextArea textArea2= new JTextArea();
                                    //instanciando clase Oyente para evento caretUpdate
                                    EventoCaretUpdate miEvento= new EventoCaretUpdate();
                                    //instanciando clase Oyente para evento Rehacer
                                    LanzarEventHacerRehacer miEvento2= new LanzarEventHacerRehacer();

                                    //llamando metodo ActionListener enviando miEvento y miEvento2 para e 
                                    textArea2.addCaretListener(miEvento);
                                    textArea2.getDocument().addUndoableEditListener(miEvento2);
                                    textArea2.setHighlighter(hilit);
                                    textArea2.setText(controlador.cargarArchivo(file.getSelectedFile()));

                                    //agregando al scroll el text area
                                    scrol2.setViewportView(textArea2);
                                    //agregando nueva pesta?a
                                    panel.addTab(file.getSelectedFile().getName(), scrol2);       
                            }
            
                    
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
            JScrollPane scrol = (JScrollPane)panel.getComponentAt(panel.getSelectedIndex());    
            JViewport port = (JViewport)scrol.getComponent(0);
            JTextArea textArea= (JTextArea)port.getComponent(0);
            
            exportador= new Exportador(this,textArea.getText());
            exportador.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
            /*
                Obtenemos el componente seleccionado del panel de pestanas
                del scrolPane obtenemos el view port
                del view port obtenemos el text area finalmente
                todos suponiendo que se encuentran en la posicion 0 de los compenentes
            */
            guardarArchivoErrores();
            txtErroresLexicos.setText("");//limpiando area de mensajes
            //obteniendo todos los componentes del text pane
            //por cada tab
            JScrollPane scrol;  
            JViewport port;
            JTextArea textArea;
            String entrada;
            /*EJECUCION DE TODOS LOS ARCHIVOS ABIERTOS*/
            for (int i = 0; i < panel.getTabCount(); i++) {
                    this.lexer = new Lexer(new StringReader(""), this.txtErroresLexicos,this,i);
                    this.parser = new parser(lexer, this,i);
                    reiniciarPanelSalida();//reiniciando el panel que contendra la nueva salida
                    inicializarTablasVariables();//reiniciando tabla variables
                    reiniciarContadoresErrores();
                    //reiniciarErrores();
                    reestablecerAtributosTexto();
                    scrol = (JScrollPane)panel.getComponentAt(i);    
                    port = (JViewport)scrol.getComponent(0);
                    textArea= (JTextArea)port.getComponent(0);
                    entrada = textArea.getText();
                    System.out.println("Entrada a parsear: "+entrada);
                    this.lexer.yyreset(new StringReader(entrada));
                    try {
                            this.parser.parse();
                    } catch (Exception ex) {
                            Logger.getLogger(JFramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    System.out.println(parser.devolverCodigoHtmlFinal());
                    txtInterpretacion.setText(parser.devolverCodigoHtmlFinal());
                    agregarErrorArchivo(i);//errores Generados para cada tab
                    
                    //////INTERPRETACION\
                    //agregaarSalidaNavegador();//agregando ventana para interpretar
                    String entrada2 = txtInterpretacion.getText();
                    System.out.println("Entrada a Interpretar: "+entrada2);
                    this.lexer2.yyreset(new StringReader(entrada2));
                    try {
                            this.parser2.parse();
                    } catch (Exception ex) {
                            Logger.getLogger(JFramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    agregaarSalidaNavegador();//agregando ventana para interpretar
                    
            }
            
            //generando archivo de errores
            generarArchivoErrores();
            
            
        
    }//GEN-LAST:event_jButton7ActionPerformed
     public void updateButtons() {
            btnDeshacer.setEnabled(undoManager.canUndo());//se habilita o deshabilita segun el manejador
            btnRehacer.setEnabled(undoManager.canRedo());
    }
     
    //creando clases internas para gestion de eventos   
    private class LanzarEventHacerRehacer implements UndoableEditListener{
        @Override
        public void undoableEditHappened(UndoableEditEvent evt) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            undoManager.addEdit(evt.getEdit());
            updateButtons();
            
        }
    
    }
    private class EventoCaretUpdate implements CaretListener{
        @Override
        public void caretUpdate(CaretEvent evt) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            //obtenemos una referencia del textArea
            JTextArea editArea = (JTextArea)evt.getSource();
            int linea = 1;
            int columna = 1;

            try {
                    /*
                    método .getCaretPosition().
                        Este método nos da la posición del cursor relativa al número de caracteres insertados.
                    método .getLineOfOffset() al que pasaremos la posición del cursor y nos devolverá la fila.
                    método .getLineStartOffset(), el cual, al pasarle la fila nos devolverá el número de caracteres 
                        que hay en las anteriores líneas. Así que restandoselo a la posición del cursor nos dará 
                        la columna de la fila actual.
                    */
                    int caretpos = editArea.getCaretPosition();//obtenemos la posicion
                    linea= editArea.getLineOfOffset(caretpos);
                    columna = caretpos - editArea.getLineStartOffset(linea);

                    // Ya que las líneas las cuenta desde la 0
                    linea += 1;
            } catch(Exception ex) { }

            // Actualizamos el estado
            actualizarEstado(linea, columna+1);//mas uno porque el lanza 0 al inicio
        }

    }
    //metodo para actualizar el posicionamiento del cursor
    private void actualizarEstado(int linea, int columna) {
            status.setText("Linea: " + linea + "    Columna: " + columna);
    }       
    
    public void agregarVariableInstruc(String nombre, Integer valor){
            variablesInstruc.put(nombre, valor);
    }
    
    public boolean verificarVariableInstruc(String var){
            boolean esta=false;
            for (String key: variablesInstruc.keySet()){
                    if (key.equals(var)) {
                    esta =true;    
                    break;
                    }
            
            }
            return esta;
    }
    public Integer retornarVariableInstruc(String var){
            Integer valor=null;
            for (String key: variablesInstruc.keySet()){
                    if (key.equals(var)) {
                    valor =variablesInstruc.get(key);    
                    break;
                    }
            
            }
            return valor;
    }
    
    public void asignarVariableInstruc(String var, Integer nuevoValor){
            for (String key: variablesInstruc.keySet()){
                    if (key.equals(var)) {
                        variablesInstruc.replace(key, nuevoValor);    
                    break;
                    }
            
            }
    }
    
    public void agregarVariableArchiv(String nombre, Integer valor){
            variablesArchiv.put(nombre, valor);
    }
    public boolean verificarVariableArchiv(String var){
            boolean esta=false;
            for (String key: variablesArchiv.keySet()){
                    if (key.equals(var)) {
                    esta =true;    
                    break;
                    }
            
            }
            return esta;
    }
    
    public Integer retornarVariableArchiv(String var){
            Integer valor=null;
            for (String key: variablesArchiv.keySet()){
                    if (key.equals(var)) {
                    valor =variablesArchiv.get(key);    
                    break;
                    }
            
            }
            return valor;
    }
    
    public void asignarVariableArchiv(String var, Integer nuevoValor){
            for (String key: variablesArchiv.keySet()){
                    if (key.equals(var)) {
                        variablesArchiv.replace(key, nuevoValor);    
                    break;
                    }
            
            }
    }
    
    //**********************tablas de variables***********************************
    public void agregarVariableInteger(String nombre, Integer valor){
            variablesInteger.put(nombre, valor);
    }
    public boolean verificarVariableInteger(String var){
            boolean esta=false;
            for (String key: variablesInteger.keySet()){
                    if (key.equals(var)) {
                    esta =true;    
                    break;
                    } 
            }
            return esta;
    }
    
    public Integer retornarVariableInteger(String var){
            Integer valor=null;
            for (String key: variablesInteger.keySet()){
                    if (key.equals(var)) {
                    valor =variablesInteger.get(key);    
                    break;
                    }
            
            }
            return valor;
    }
    
    public void asignarVariableInteger(String var, Integer nuevoValor){
            for (String key: variablesInteger.keySet()){
                    if (key.equals(var)) {
                        variablesInteger.replace(key, nuevoValor);    
                    break;
                    }
            
            }
    }
    
    //2
    public void agregarVariableBoolean(String nombre, Boolean valor){
            variablesBoolean.put(nombre, valor);
    }
    public boolean verificarVariableBoolean(String var){
            boolean esta=false;
            for (String key: variablesBoolean.keySet()){
                    if (key.equals(var)) {
                    esta =true;    
                    break;
                    }
            
            }
            return esta;
    }
    
    public Boolean retornarVariableBoolean(String var){
            Boolean valor=null;
            for (String key: variablesBoolean.keySet()){
                    if (key.equals(var)) {
                    valor =variablesBoolean.get(key);    
                    break;
                    }
            
            }
            return valor;
    }
    
    public void asignarVariableBoolean(String var, Boolean nuevoValor){
            for (String key: variablesBoolean.keySet()){
                    if (key.equals(var)) {
                        variablesBoolean.replace(key, nuevoValor);    
                    break;
                    }
            
            }
    }
    //3
    public void agregarVariableString(String nombre, String valor){
            variablesString.put(nombre, valor);
    }
    public boolean verificarVariableString(String var){
            boolean esta=false;
            for (String key: variablesString.keySet()){
                    if (key.equals(var)) {
                    esta =true;    
                    break;
                    }
            
            }
            return esta;
    }
    
    public String retornarVariableString(String var){
            String valor=null;
            for (String key: variablesString.keySet()){
                    if (key.equals(var)) {
                    valor =variablesString.get(key);    
                    break;
                    }
            
            }
            return valor;
    }
    
    public void asignarVariableString(String var, String nuevoValor){
            for (String key: variablesString.keySet()){
                    if (key.equals(var)) {
                        variablesString.replace(key, nuevoValor);    
                    break;
                    }
            
            }
    }
    
    //***** control de la tabla de simbolos
    public void cargarTablaSimbolos(){
        limpiarTabla();
        DefaultTableModel model= (DefaultTableModel)tabla.getModel();
        for (String key: variablesString.keySet()){
                    if (variablesString.get(key)!=null) {
                            model.addRow(new Object[]{key,"STRING",variablesString.get(key)});
                    } else {
                            model.addRow(new Object[]{key,"STRING",""});
                    }
                        
        }
        for (String key: variablesInteger.keySet()){
                    if (variablesInteger.get(key)!=null) {
                            model.addRow(new Object[]{key,"INTEGER",variablesInteger.get(key).toString()});
                    } else {
                            model.addRow(new Object[]{key,"INTEGER",""});
                    }
                        
        }
        for (String key: variablesBoolean.keySet()){
                    if (variablesBoolean.get(key)!=null) {
                            model.addRow(new Object[]{key,"BOOLEAN",variablesBoolean.get(key).toString()});
                    } else {
                            model.addRow(new Object[]{key,"BOOLEAN",""});
                    }
                        
        }
                     
    }
    public void agregarTablaSimbolos(String nombre, String Tipo, String valor){
        DefaultTableModel model= (DefaultTableModel)tabla.getModel();
        model.addRow(new Object[]{nombre,Tipo,valor});
                     
    }
    //metodo para limpiar tablas
    public void limpiarTabla(){
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            int a = tabla.getRowCount()-1;
            for (int i = a; i >= 0; i--) {          
                    tb.removeRow(tb.getRowCount()-1);
            }
    }

    public JTextArea getTxtErroresSintac() {
        return txtErroresLexicos;
    }

    public void setTxtErroresSintac(JTextArea txtErroresSintac) {
        this.txtErroresLexicos = txtErroresSintac;
    }
    
    public void inicializarTablasVariables(){
            this.variablesInteger = new HashMap<String, Integer>();
            this.variablesBoolean = new HashMap<String, Boolean>();
            this.variablesString = new HashMap<String, String>();
    }

    public HashMap<String, Integer> getVariablesInteger() {
        return variablesInteger;
    }

    public void setVariablesInteger(HashMap<String, Integer> variablesInteger) {
        this.variablesInteger = variablesInteger;
    }

    public HashMap<String, Boolean> getVariablesBoolean() {
        return variablesBoolean;
    }

    public void setVariablesBoolean(HashMap<String, Boolean> variablesBoolean) {
        this.variablesBoolean = variablesBoolean;
    }

    public HashMap<String, String> getVariablesString() {
        return variablesString;
    }

    public void setVariablesString(HashMap<String, String> variablesString) {
        this.variablesString = variablesString;
    }
    
    private Exportador exportador;
    // miembros para manejar textos marcados
    private Color colorfondodefault;
    private Highlighter hilit;
    private Highlighter.HighlightPainter painter;
    private Highlighter.HighlightPainter painter2;
    //se declara un miembro manejador para el manejo de eventos Rehacer Deshacer cambios
    protected UndoManager undoManager = new UndoManager();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeshacer;
    private javax.swing.JButton btnRehacer;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTabbedPane panel;
    private javax.swing.JTabbedPane panel2;
    private javax.swing.JTextField status;
    private javax.swing.JTable tabla;
    private javax.swing.JTextArea txtErroresLexicos;
    private javax.swing.JTextArea txtInterpretacion;
    // End of variables declaration//GEN-END:variables
}
