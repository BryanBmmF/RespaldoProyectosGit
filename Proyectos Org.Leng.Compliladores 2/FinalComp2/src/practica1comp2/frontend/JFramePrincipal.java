/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1comp2.frontend;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.IOException;
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
import practica1comp2.backend.analizadores.Lexer;
import practica1comp2.backend.archivos.ControladorDeArchivos;
import practica1comp2.backend.analizadores.Parser;
import practica1comp2.backend.analizadores.simbolos.TablaSimbolos;
import practica1comp2.backend.ast.Ast;
import practica1comp2.backend.ast.VerificadorPrograma;
import practica1comp2.backend.generadores.GeneradorCod;
import practica1comp2.backend.instrucciones.Instruccion;

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
    
    private Lexer lexer;
    private Parser parser;
    private TablaSimbolos sym;
    private GeneradorCod gen;
    
    private SimpleAttributeSet normal;
    private SimpleAttributeSet boldBlue;
    private SimpleAttributeSet highAlert;
    
    private ControladorDeArchivos controlador;
    
    
    private JTextPane jtp;
    private JScrollPane scrol2;

    /**
     * Creates new form JFramePrincipal
     */
    public JFramePrincipal() {
        initComponents();
        
        //clase toolkit devuelve la resolucion nativa del sistema huesped        
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        //colocacion de icono a la pantalla
        Image icono=miPantalla.getImage(PATH_ICONO);      
        setIconImage(icono);
        
        
        this.lexer = new Lexer(new StringReader(""));
        this.sym = new TablaSimbolos(lexer.getErrorsList());
        this.gen = new GeneradorCod(sym);
            
        this.parser = new Parser(lexer, gen, sym);
        
        
        btnDeshacer.setEnabled(false);// deshabilitando botones de rehacer deshacer
        btnRehacer.setEnabled(false);
        
        hilit = new DefaultHighlighter();
        painter = new DefaultHighlighter.DefaultHighlightPainter(Color.GREEN);
        painter2 = new DefaultHighlighter.DefaultHighlightPainter(Color.CYAN);
       
        this.controlador = new ControladorDeArchivos();
        
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
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnDeshacer = new javax.swing.JButton();
        btnRehacer = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        panel = new javax.swing.JTabbedPane();
        jLabel1 = new javax.swing.JLabel();
        status = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtCodigo3D = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtCodigoC = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
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
        txtErroresLexicos.setBackground(new java.awt.Color(204, 204, 204));
        txtErroresLexicos.setColumns(20);
        txtErroresLexicos.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtErroresLexicos.setForeground(new java.awt.Color(255, 0, 0));
        txtErroresLexicos.setRows(5);
        jScrollPane1.setViewportView(txtErroresLexicos);

        jLabel2.setText("Errores lexicos - > Errores sintacticos ->Semanticos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
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

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica1comp2/frontend/img/limpiar.png"))); // NOI18N
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        btnDeshacer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica1comp2/frontend/img/deshacer.png"))); // NOI18N
        btnDeshacer.setFocusable(false);
        btnDeshacer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDeshacer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDeshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeshacerActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDeshacer);

        btnRehacer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica1comp2/frontend/img/rehacer.png"))); // NOI18N
        btnRehacer.setFocusable(false);
        btnRehacer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRehacer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRehacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRehacerActionPerformed(evt);
            }
        });
        jToolBar1.add(btnRehacer);

        jButton5.setText("Compilar...");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton5);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        panel.setBackground(new java.awt.Color(204, 255, 204));
        panel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Estado:");

        status.setEditable(false);
        status.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        status.setForeground(new java.awt.Color(0, 0, 153));

        txtCodigo3D.setBackground(new java.awt.Color(153, 153, 255));
        txtCodigo3D.setColumns(20);
        txtCodigo3D.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCodigo3D.setForeground(new java.awt.Color(0, 0, 153));
        txtCodigo3D.setRows(5);
        jScrollPane2.setViewportView(txtCodigo3D);

        txtCodigoC.setBackground(new java.awt.Color(153, 153, 255));
        txtCodigoC.setColumns(20);
        txtCodigoC.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCodigoC.setForeground(new java.awt.Color(0, 102, 0));
        txtCodigoC.setRows(5);
        jScrollPane3.setViewportView(txtCodigoC);

        jLabel3.setText("Codigo 3D");

        jLabel4.setText("Codigo Final C");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(panel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jMenu1.setText("Archivo");

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

        jMenu2.setText("Acerca de");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JScrollPane scrol = new JScrollPane();
        JTextArea textArea= new JTextArea();
        
        //seteando lineas al text area
        TextLineNumber lineNumber = new TextLineNumber(textArea);
        scrol.setRowHeaderView(lineNumber);
        
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
            sym.cleanAll();
            sym.iniciarTiposBases();
            gen.limpiarListaCuart();
            txtErroresLexicos.setText("");
            txtCodigo3D.setText("");
            txtCodigoC.setText("");
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
            
            
            
            JScrollPane scrol = (JScrollPane)panel.getComponentAt(panel.getSelectedIndex());    
            JViewport port = (JViewport)scrol.getComponent(0);
            JTextArea textArea= (JTextArea)port.getComponent(0);

            String entrada = textArea.getText();
            System.out.println(entrada);
            sym.cleanAll();
            sym.iniciarTiposBases();
            gen.limpiarListaCuart();
            txtErroresLexicos.setText("");//limpiando area de mensajes
            txtCodigo3D.setText("");//limpiando area de mensajes
            txtCodigoC.setText("");//limpiando area de mensajes

            System.out.println("Entrada a parsear: "+entrada);
            this.lexer.yyreset(new StringReader(entrada));
            try {
                    Ast ast = (Ast)this.parser.parse().value;
                    if (ast!=null) {
                        VerificadorPrograma verific = new VerificadorPrograma(ast);
                        verific.verificar();
                    }
                    
            } catch (Exception ex) {
                    Logger.getLogger(JFramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            //revisando posibles errores
            if (this.lexer.getErrorsList().isEmpty()) {
                gen.imprimirCod3D(txtCodigo3D);
                gen.imprimirCodC(txtCodigoC);
                
                generarEjecutable();
            } else {
                for (String s: this.lexer.getErrorsList()){
                    txtErroresLexicos.append(s+"\n");
                }
            }
            
           
            
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        JScrollPane scrol = new JScrollPane();
        JTextArea textArea= new JTextArea();
        
         //seteando lineas al text area
        TextLineNumber lineNumber = new TextLineNumber(textArea);
        scrol.setRowHeaderView(lineNumber);
        
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
    
    public void generarEjecutable(){
        /**llamamos el metodo que permite cargar la ventana para guardar el archivo*/
        JFileChooser file=new JFileChooser();
        file.showSaveDialog(this);
        //file.setName("Ubicacion de Archivos de Salida 3D y C");
        controlador.exportarAarchivo(file.getSelectedFile(), txtCodigo3D.getText(),".3d");
      
        controlador.exportarAarchivo(file.getSelectedFile(), txtCodigoC.getText(),".c");
        
        //generando ejecutable
            try {
    	//String [] cmd = {"gcc","/home/bryan/Escritorio/nuevo.c","-o","/home/bryan/Escritorio/nuevo"}; //Comando de apagado en windows
        String [] cmd = {"gcc",file.getSelectedFile().getAbsolutePath()+".c","-o",file.getSelectedFile().getAbsolutePath()}; //Comando de apagado en windows
    	Runtime.getRuntime().exec(cmd);
        } catch (IOException ioe) {
            //System.out.println (ioe);
            System.out.println ("*********NO SE PUDO GENERAR EL EJECUTABLE DEBIDO A ERRORES**************");
        }
        
    
    }
    //metodo para actualizar el posicionamiento del cursor
    private void actualizarEstado(int linea, int columna) {
            status.setText("Linea: " + linea + "    Columna: " + columna);
    }       

    public JTextArea getTxtErroresSintac() {
        return txtErroresLexicos;
    }

    public void setTxtErroresSintac(JTextArea txtErroresSintac) {
        this.txtErroresLexicos = txtErroresSintac;
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
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
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
    private javax.swing.JTextField status;
    private javax.swing.JTextArea txtCodigo3D;
    private javax.swing.JTextArea txtCodigoC;
    private javax.swing.JTextArea txtErroresLexicos;
    // End of variables declaration//GEN-END:variables
}
