/*
 * Gui principal
 */
package analizadorsintactico.gui;

import analizadorsintactico.backend.Analizador1;
import analizadorsintactico.backend.Analizador2;
import analizadorsintactico.backend.ControladorDeArchivos;
import analizadorsintactico.backend.EstructuraCl;
import analizadorsintactico.backend.Lexem;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.UndoManager;

/**
 *
 * @author bryan
 */
public class JFramePrincipal extends javax.swing.JFrame {

    /**
     * Creates new form JFramePrincipal
     */
    private boolean modificado;
    private boolean modificado2;
    private Analizador1 analizador1;
    private Analizador2 analizador2;
    public static final String ARCHIVO_NUEVO="Archivo Nuevo sin Guardar";
    public static final String GUARDAR_CAMBIOS="Desea Guardar Cambios al archivo abierto?";
    public static final String GUARDAR_ARCHIVO="Desea Guardar este Archivo?";
    public static final String PATRON_ENC="' este patron fue encontrado en el texto.";
    public static final String PATRON_NO_ENC="' este patron no fue encontrado en el texto.";
    public static final String PATH_ICONO="src/analizadorsintactico/gui/img/iconoAnalizador.png";
    private static ArrayList<Lexem> listaTokensEvaluados;
    public JFramePrincipal() {
        initComponents();   
        //clase toolkit devuelve la resolucion nativa del sistema huesped        
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        //colocacion de icono a la pantalla
        Image icono=miPantalla.getImage(PATH_ICONO);      
        setIconImage(icono);
        
        btnDeshacer.setEnabled(false);// deshabilitando botones de rehacer deshacer
        btnRehacer.setEnabled(false);
        
        //propiedades iniciales de txtestado y textArea
        //textArea.setLineWrap(true);
        //textArea.setWrapStyleWord(true);
        hilit = new DefaultHighlighter();
        painter = new DefaultHighlighter.DefaultHighlightPainter(Color.GREEN);
        painter2 = new DefaultHighlighter.DefaultHighlightPainter(Color.CYAN);
        textArea.setHighlighter(hilit);
        colorfondodefault = txtbuscar.getBackground();
        
        this.txtArchivoOpen.setText(ARCHIVO_NUEVO);
        this.modificado=false;
        this.modificado2=false;
        this.LanzarEventHacerRehacer();//lanza eventos de rehacer deshacer
        this.setLocationRelativeTo(null);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        status = new javax.swing.JTextField();
        txtbuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        estado = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCoincidencias = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbLexemasValidos = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbLexemasInvalidos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnLimpiatTabLexVal = new javax.swing.JButton();
        btnLimpiarTableLexInv = new javax.swing.JButton();
        txtArchivoOpen = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbEstructurasValidas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        listaErroresSintac = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        btnLimpiarArea = new javax.swing.JButton();
        btnAnalizar = new javax.swing.JButton();
        btnCopiar = new javax.swing.JButton();
        btnPegar = new javax.swing.JButton();
        btnCortar = new javax.swing.JButton();
        btnDeshacer = new javax.swing.JButton();
        btnRehacer = new javax.swing.JButton();
        btnDesmarcar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        itemGuardar = new javax.swing.JMenu();
        itemNuevo = new javax.swing.JMenuItem();
        itemAbrirArchivo = new javax.swing.JMenuItem();
        itemGuardarCambios = new javax.swing.JMenuItem();
        itemGuardarComo = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Analizador Sintactico 2.0");

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        textArea.setColumns(20);
        textArea.setRows(5);
        textArea.setToolTipText("");
        textArea.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textArea.setMargin(new java.awt.Insets(50, 50, 50, 50));
        textArea.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                textAreaCaretUpdate(evt);
            }
        });
        textArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textAreaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textAreaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(textArea);

        jLabel1.setText("Estado:");

        status.setEditable(false);

        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtbuscarKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/analizadorsintactico/gui/img/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar Patron");
        btnBuscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscar.setFocusable(false);
        btnBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel6.setText("No.Coincidencias:");

        txtCoincidencias.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(estado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCoincidencias, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtbuscar)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCoincidencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                .addGap(7, 7, 7))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tbLexemasValidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Token", "Lexema", "Fila", "Columna"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbLexemasValidos);

        tbLexemasInvalidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Token", "Lexema", "Fila", "Columna"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbLexemasInvalidos);

        jLabel3.setText("Tokens Validos");

        jLabel4.setText("Tokens Invalidos");

        btnLimpiatTabLexVal.setText("Limpiar");
        btnLimpiatTabLexVal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiatTabLexValActionPerformed(evt);
            }
        });

        btnLimpiarTableLexInv.setText("Limpiar");
        btnLimpiarTableLexInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarTableLexInvActionPerformed(evt);
            }
        });

        txtArchivoOpen.setBackground(new java.awt.Color(102, 255, 102));
        txtArchivoOpen.setForeground(new java.awt.Color(0, 0, 102));

        tbEstructurasValidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo", "Fila", "Columna"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbEstructurasValidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEstructurasValidasMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbEstructurasValidas);

        jLabel2.setText("Estructuras");

        jButton1.setText("Limpiar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        listaErroresSintac.setBackground(new java.awt.Color(204, 204, 204));
        listaErroresSintac.setForeground(new java.awt.Color(255, 0, 0));
        jScrollPane5.setViewportView(listaErroresSintac);

        jLabel5.setText("Errores Sintacticos");

        jButton2.setText("Limpiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpiatTabLexVal))
                    .addComponent(txtArchivoOpen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpiarTableLexInv))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane5)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiatTabLexVal)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(btnLimpiarTableLexInv))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtArchivoOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jToolBar1.setRollover(true);

        btnLimpiarArea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/analizadorsintactico/gui/img/limpiar.png"))); // NOI18N
        btnLimpiarArea.setText("Limpiar Area de Texto");
        btnLimpiarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarAreaActionPerformed(evt);
            }
        });
        jToolBar1.add(btnLimpiarArea);

        btnAnalizar.setText("Analisis Lex");
        btnAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAnalizar);

        btnCopiar.setText("Copiar");
        btnCopiar.setFocusable(false);
        btnCopiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCopiar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCopiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCopiarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCopiar);

        btnPegar.setText("Pegar");
        btnPegar.setFocusable(false);
        btnPegar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPegar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPegarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnPegar);

        btnCortar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/analizadorsintactico/gui/img/cortar.png"))); // NOI18N
        btnCortar.setFocusable(false);
        btnCortar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCortar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCortar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCortarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCortar);

        btnDeshacer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/analizadorsintactico/gui/img/deshacer.png"))); // NOI18N
        btnDeshacer.setFocusable(false);
        btnDeshacer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDeshacer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDeshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeshacerActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDeshacer);

        btnRehacer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/analizadorsintactico/gui/img/rehacer.png"))); // NOI18N
        btnRehacer.setFocusable(false);
        btnRehacer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRehacer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRehacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRehacerActionPerformed(evt);
            }
        });
        jToolBar1.add(btnRehacer);

        btnDesmarcar.setText("Desmarcar");
        btnDesmarcar.setFocusable(false);
        btnDesmarcar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDesmarcar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDesmarcar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesmarcarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDesmarcar);

        itemGuardar.setText("Archivo");

        itemNuevo.setText("Nuevo");
        itemNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevoActionPerformed(evt);
            }
        });
        itemGuardar.add(itemNuevo);

        itemAbrirArchivo.setText("Abrir Archivo");
        itemAbrirArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAbrirArchivoActionPerformed(evt);
            }
        });
        itemGuardar.add(itemAbrirArchivo);

        itemGuardarCambios.setText("Guardar");
        itemGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGuardarCambiosActionPerformed(evt);
            }
        });
        itemGuardar.add(itemGuardarCambios);

        itemGuardarComo.setText("Guardar Archivo Como..");
        itemGuardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGuardarComoActionPerformed(evt);
            }
        });
        itemGuardar.add(itemGuardarComo);

        jMenuBar1.add(itemGuardar);

        jMenu2.setText("Acerca de");

        jMenuItem2.setText("Desarrollador de la Aplicacion");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarActionPerformed
        // TODO add your handling code here:
            String texto= textArea.getText();            
            Analizador1 analizador1 = new Analizador1(texto,this);
            analizador1.analizar();
            
    }//GEN-LAST:event_btnAnalizarActionPerformed

    private void btnLimpiarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarAreaActionPerformed
        // TODO add your handling code here:
            this.textArea.setText("");
    }//GEN-LAST:event_btnLimpiarAreaActionPerformed

    private void itemAbrirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAbrirArchivoActionPerformed
        // TODO add your handling code here:
            ControladorDeArchivos controlador= new ControladorDeArchivos();
            if (controlador.getArch()!=null) {// si hay un archivo abierto
                    int confirmar = JOptionPane.showConfirmDialog(this, GUARDAR_CAMBIOS);
                    if (confirmar==0) {//si quiere guardar cambios
                          controlador.guardarCambiosArchivo(controlador.getArch().getPath(), textArea.getText());//se reescribe el archivO
                          controlador.setArch(null);// se vuelve al estado de ningun archivo abierto
                          reestablecerEstadoDoc();
                          textArea.setText(abrirArchivo());//SE ABRE LA VENTANA PARA ABRIR ARCHIVO
                    }
                    if (confirmar==1) {
                            //si no quiere guardar cambios el archivo queda tal y como esta
                            controlador.setArch(null);// se vuelve al estado de ningun archivo abierto
                            reestablecerEstadoDoc();
                            textArea.setText(abrirArchivo());//SE ABRE LA VENTANA PARA ABRIR ARCHIVO
                    }
            } else {// si no hay un archivo abierto se abre uno nuevo y se visualiza en el textArea
                        int confirmar = JOptionPane.showConfirmDialog(this,GUARDAR_ARCHIVO);
                        if (confirmar==0) {//si quiere guardar
                               guardarArchivoClose();
                               textArea.setText(abrirArchivo());
                        }
                        if (confirmar==1) {
                                textArea.setText(abrirArchivo());
                        }
                        
                        
            }
            
    }//GEN-LAST:event_itemAbrirArchivoActionPerformed
    //metodo para el control de estados de fila y columna del cursor en el Area de texto recibe evento CareEvent
    private void textAreaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_textAreaCaretUpdate
        // TODO add your handling code here:
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
    }//GEN-LAST:event_textAreaCaretUpdate
    //metodo para copiar texto en el Editor
    private void btnCopiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCopiarActionPerformed
        // TODO add your handling code here:
            textArea.copy();      
    }//GEN-LAST:event_btnCopiarActionPerformed
    //metodo para pegar texto en el Editor
    private void btnPegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPegarActionPerformed
        // TODO add your handling code here:
            textArea.paste();
    }//GEN-LAST:event_btnPegarActionPerformed
    //metodo para copiar cortar texto en el Editor
    private void btnCortarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCortarActionPerformed
        // TODO add your handling code here:
            textArea.cut();
    }//GEN-LAST:event_btnCortarActionPerformed
    //metodo para deshacer texto en el Editor
    private void btnDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeshacerActionPerformed
        // TODO add your handling code here:
            try {
                    undoManager.undo();//manejador deshace
            } catch (CannotRedoException cre) {
                    cre.printStackTrace();
            }
            updateButtons();
    }//GEN-LAST:event_btnDeshacerActionPerformed
    //metodo para rehacer texto en el Editor
    private void btnRehacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRehacerActionPerformed
        // TODO add your handling code here:
            try {
                    undoManager.redo();//manejador rehace
            } catch (CannotRedoException cre) {
                    cre.printStackTrace();
            }
            updateButtons();
    }//GEN-LAST:event_btnRehacerActionPerformed

    private void itemGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemGuardarComoActionPerformed
        // TODO add your handling code here:
            //guardarArchivo();//para txt docx y odt
            //guardarArchivoPDF();// para pdf
            exportador= new Exportador(this,textArea.getText());
            exportador.setVisible(true);
    }//GEN-LAST:event_itemGuardarComoActionPerformed

    private void txtbuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyPressed
       //eventos de teclado
    }//GEN-LAST:event_txtbuscarKeyPressed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        // TODO add your handling code here:
            //buscarTextoOrigin();
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void txtbuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyTyped
        // TODO add your handling code here:  
    }//GEN-LAST:event_txtbuscarKeyTyped

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
            buscaPatron(txtbuscar.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnDesmarcarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesmarcarActionPerformed
        // TODO add your handling code here:
            hilit.removeAllHighlights();//limpia el texto marcado
    }//GEN-LAST:event_btnDesmarcarActionPerformed

    private void btnLimpiatTabLexValActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiatTabLexValActionPerformed
        // TODO add your handling code here:
            limpiarTabla(this.tbLexemasValidos);
    }//GEN-LAST:event_btnLimpiatTabLexValActionPerformed

    private void btnLimpiarTableLexInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarTableLexInvActionPerformed
        // TODO add your handling code here:
            limpiarTabla(this.tbLexemasInvalidos);
    }//GEN-LAST:event_btnLimpiarTableLexInvActionPerformed

    private void textAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textAreaKeyPressed
        // TODO add your handling code here:
            modificado=true;
    }//GEN-LAST:event_textAreaKeyPressed

    private void itemNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevoActionPerformed
        // TODO add your handling code here:
            ControladorDeArchivos controlador= new ControladorDeArchivos();
            if (controlador.getArch()!=null) {// si hay un archivo abierto
                    int confirmar = JOptionPane.showConfirmDialog(this, GUARDAR_CAMBIOS);
                    if (confirmar==0) {//si quiere guardar cambios
                          controlador.guardarCambiosArchivo(controlador.getArch().getPath(), textArea.getText());//se reescribe el archivo
                          controlador.setArch(null);// se vuelve al estado de ningun arhivo abierto
                          reestablecerEstadoDoc();
                    }
                    if (confirmar==1) {//si no quiere guardar cambios el archivo queda tal y como esta
                            controlador.setArch(null);// se vuelve al estado de ningun archivo abierto
                            reestablecerEstadoDoc();
                    }
            } else {// si no hay un archivo abierto se abre uno nuevo en la ventana con texto vacio
                        int confirmar = JOptionPane.showConfirmDialog(this, GUARDAR_ARCHIVO);
                        if (confirmar==0) {//si quiere guardar
                               guardarArchivoClose();
                        }
                        if (confirmar==1) {//si no quiere guardar el archivo
                                controlador.setArch(null);// se vuelve al estado de ningun archivo abierto
                                reestablecerEstadoDoc();
                        }
                        
            }
    }//GEN-LAST:event_itemNuevoActionPerformed

    private void itemGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemGuardarCambiosActionPerformed
        // TODO add your handling code here:
            ControladorDeArchivos controlador= new ControladorDeArchivos();
            if (controlador.getArch()!=null) {// si hay un archivo abierto
                    controlador.guardarCambiosArchivo(controlador.getArch().getPath(), textArea.getText());//se reescribe el archivo
            } else {// si no hay un archivo abierto
                    guardarArchivo();
            }
    }//GEN-LAST:event_itemGuardarCambiosActionPerformed

    private void textAreaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textAreaKeyReleased
        // TODO add your handling code here:
            modificado2=true;
            
    }//GEN-LAST:event_textAreaKeyReleased

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
             JOptionPane.showMessageDialog(this,
                                 "Desarrollador: Bryan Monzon USAC-CUNOC \n Ingenieria en Ciencias y Sistemas 2018","Informacion",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void tbEstructurasValidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEstructurasValidasMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model =(DefaultTableModel)tbEstructurasValidas.getModel();
            
            if(tbEstructurasValidas.getSelectedRow()!=-1){//si se ha seleccionado algo en la tabla se rellenan los campo
                    String patronDeBusqueda = model.getValueAt(tbEstructurasValidas.getSelectedRow(), 0).toString(); //se captura el patron de busqueda
                    if (patronDeBusqueda.equalsIgnoreCase("CONDICIONAL")) {
                            buscaPatron("SI");
                    } else if (patronDeBusqueda.equalsIgnoreCase("ESCRITURA")) {
                                    buscaPatron("ESCRIBIR");
                            } else if (patronDeBusqueda.equalsIgnoreCase("ASIGNACION")) {
                                            buscaPatron(" = ");
                                    } else if (patronDeBusqueda.equalsIgnoreCase("REPETIR")) {
                                                    buscaPatron("REPETIR");
                                            } 
                    
            }
    }//GEN-LAST:event_tbEstructurasValidasMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
            limpiarTabla(tbEstructurasValidas);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
            limpiarListaErrSintac();
    }//GEN-LAST:event_jButton2ActionPerformed
    //metodo para poner a la escucha el Text Area de posibles cambios de edicion de texto
    public void LanzarEventHacerRehacer(){
            textArea.getDocument().addUndoableEditListener(
                    new UndoableEditListener() {
                            public void undoableEditHappened(UndoableEditEvent e) {
                                    undoManager.addEdit(e.getEdit());
                                    updateButtons();
                            }
                    }
            );
    
    }
    //actualizacion de botones
    public void updateButtons() {
//            btnDeshacer.setText("Se puede Deshacer");
//            btnRehacer.setText("Se puede Rehacer");
            btnDeshacer.setEnabled(undoManager.canUndo());//se habilita o deshabilita segun el manejador
            btnRehacer.setEnabled(undoManager.canRedo());
    }
    public void cargarTablaLexemasI(ArrayList<Lexem> lista, JTable tabla){
        DefaultTableModel model= (DefaultTableModel)tabla.getModel();
        for(Lexem lexema: lista){
            model.addRow(new Object[]{lexema.getToken(),lexema.getLexema(),lexema.getNumeroFila(),lexema.getNumeroColumna()});
        }                        
    }
     public void cargarTablaEstructI(ArrayList<EstructuraCl> lista, JTable tabla){
        DefaultTableModel model= (DefaultTableModel)tabla.getModel();
        for(EstructuraCl estruc: lista){
            model.addRow(new Object[]{estruc.getTipo().toString(),estruc.getLinea(),estruc.getColum()});
        }                        
    }
    //metodo para limpiar tablas
    public void limpiarTabla(JTable tabla){
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            int a = tabla.getRowCount()-1;
            for (int i = a; i >= 0; i--) {          
                    tb.removeRow(tb.getRowCount()-1);
            }
    }
    public void agregarErrorSintactico(ArrayList<String> lista){
            DefaultListModel modelo = new DefaultListModel();
            int cont =1;
            for (int i = 0; i < lista.size(); i++) {
                    if (i%2==0) {
                            modelo.addElement(""+cont+". "+lista.get(i)+"\n");
                            cont++;
                    } else {
                            modelo.addElement(lista.get(i)+"\n");
                            modelo.addElement("\n");
                            
                        }
            }
            listaErroresSintac.setModel(modelo);
            
    }
    public void limpiarListaErrSintac(){
            DefaultListModel modelo = new DefaultListModel();
            modelo.addElement("");
            listaErroresSintac.setModel(modelo);
            
    }
    public JTable devolverTablaLexVal(){
            return this.tbLexemasValidos;
    }
    public JTable devolverTablaLexInval(){
            return this.tbLexemasInvalidos;
    }
    public JTable devolverTablaEstrucValid(){
            return this.tbEstructurasValidas;
    }
    //metodo para actualizar el posicionamiento del cursor
    private void actualizarEstado(int linea, int columna) {
            status.setText("Linea: " + linea + " Columna: " + columna);
    }   
    //para c,pc desde diferentes componentes
    public Action getAccion(Action[] acciones,String nombreAccion){
            HashMap<Object, Action> acc = new HashMap<Object, Action>();
            for (int i = 0; i < acciones.length; i++) {
                    Action accion= acciones[i];
                    acc.put(accion.getValue(Action.NAME), accion);
        }
        return acc.get(nombreAccion);
    }
    public void iniciarAccionesTxA(){
            
    }
    //metodo para guardar un archivo POR DEFECTO
    private void guardarArchivo() {
            ControladorDeArchivos controlador= new ControladorDeArchivos();
             /**llamamos el metodo que permite cargar la ventana*/
            JFileChooser file=new JFileChooser();
            file.showSaveDialog(this);
            controlador.exportarAarchivo(file.getSelectedFile(), textArea.getText(),"");//por defecto sin extension
            if (controlador.getArch()!=null) {//si hay uno abierto se actualiza el contenedor
                    txtArchivoOpen.setText(controlador.getArch().getName());
            }
            
            
    }
    //guarda archivo y cierra
    private void guardarArchivoClose() {
            ControladorDeArchivos controlador= new ControladorDeArchivos();
             /**llamamos el metodo que permite cargar la ventana*/
            JFileChooser file=new JFileChooser();
            file.showSaveDialog(this);
            controlador.exportarAarchivo(file.getSelectedFile(), textArea.getText(),"");//por defecto sin extension
          
            controlador.setArch(null);// se vuelve al estado de ningun archivo abierto
            reestablecerEstadoDoc();      
    }
    //metodo para abriri un archivo
    private String abrirArchivo() {
            ControladorDeArchivos controlador= new ControladorDeArchivos();
             /**llamamos el metodo que permite cargar la ventana*/
            JFileChooser file=new JFileChooser();
            file.showOpenDialog(this);
            txtArchivoOpen.setText(file.getSelectedFile().getName());//se actualiza el contenedor del nombre del archivo
            /**abrimos el archivo seleccionado*/
            return controlador.cargarArchivo(file.getSelectedFile());
            
    }
    // metodo para buscar patrones simula a un automata 
    public void buscaPatron(String patron){
            hilit.removeAllHighlights();//limpia el texto marcado
            String patronDeBusqueda = patron; //se captura el patron de busqueda
            String contenido = textArea.getText(); //se extrae el contenido del textArea
            int indice=0;//indice de area de texto, indice del patron, contador de exitos
            int indicePatron=0;
            int contExitos=0;
            if (patronDeBusqueda.length()>0) {// se verifica si hay algo que buscar
                    for (indice = 0; indice < contenido.length(); indice++) {
                            if (contenido.charAt(indice)==patronDeBusqueda.charAt(indicePatron)) {
                                    indicePatron++; //se evalua la coincidencia de un caracter y se incrementa el indicePatron o lleva al siguiente estado
                            } else{
                                indicePatron=0;// si no coincide el caracter se reinicia el indice de patron o estado inicial
                            }
                            if (indicePatron==patronDeBusqueda.length()) {//si ya hay una coincidencia o llega a un estado de aceptacion
                                    //System.out.println(""+patronDeBusqueda+ " pos: "+((indice+1)-patronDeBusqueda.length()));
                                    indicePatron=0;//se reinicia el indice de patron para una nueva busqueda
                                    contExitos++; // se incrementa el contador de exitos
                                    try {   //se marca la coincidencia, desde-hasta con el color painter
                                            hilit.addHighlight((indice+1)-patronDeBusqueda.length(), (indice+1), painter); //recibe el inicio final, y color de la cadena 
                                    } catch (BadLocationException ex) {
                                            Logger.getLogger(JFramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    textArea.setCaretPosition(indice);//se indica la ultima coincidencia
                                    txtbuscar.setBackground(colorfondodefault);
                            }
                    }
 
            }
            if (contExitos>0) {
                    txtbuscar.setBackground(Color.CYAN);
                    estado.setText("'" + patronDeBusqueda + PATRON_ENC);
                    estado.setForeground(Color.BLUE);
                    txtCoincidencias.setText(""+contExitos);
            } else{
                    txtbuscar.setBackground(Color.ORANGE);
                    estado.setText("'" + patronDeBusqueda + PATRON_NO_ENC);
                    txtCoincidencias.setText(""+0);
            }
    }
    public boolean returnModificacion(){
            return this.modificado;
    }
    public void reestablecerEstadoDoc(){
            txtArchivoOpen.setText(ARCHIVO_NUEVO);
            textArea.setText("");
    }
    public static void almacenarTokensEvaluados(ArrayList<Lexem> lista){
            
           JFramePrincipal.listaTokensEvaluados = lista;
           System.out.println(""+listaTokensEvaluados.size());
    }
    public static ArrayList<Lexem> recuperarTokensEvaluados(){
           System.out.println(""+listaTokensEvaluados.size());
           return JFramePrincipal.listaTokensEvaluados;
    }
    public boolean realizarAnalisisSintactico(){
            int confirmar = JOptionPane.showConfirmDialog(this,"El Analisis Lexico a Sido correcto\n Desea realizar el sintactico??");
            
            if (confirmar==0) {
                    return  true;
            } else {
                    return  false;
                }
    }
    // miembros para manejar textos marcados
    private Color colorfondodefault;
    private Highlighter hilit;
    private Highlighter.HighlightPainter painter;
    private Highlighter.HighlightPainter painter2;
    //se declara un miembro manejador para el manejo de eventos Rehacer Deshacer cambios
    protected UndoManager undoManager = new UndoManager();
    private Exportador exportador;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCopiar;
    private javax.swing.JButton btnCortar;
    private javax.swing.JButton btnDeshacer;
    private javax.swing.JButton btnDesmarcar;
    private javax.swing.JButton btnLimpiarArea;
    private javax.swing.JButton btnLimpiarTableLexInv;
    private javax.swing.JButton btnLimpiatTabLexVal;
    private javax.swing.JButton btnPegar;
    private javax.swing.JButton btnRehacer;
    private javax.swing.JLabel estado;
    private javax.swing.JMenuItem itemAbrirArchivo;
    private javax.swing.JMenu itemGuardar;
    private javax.swing.JMenuItem itemGuardarCambios;
    private javax.swing.JMenuItem itemGuardarComo;
    private javax.swing.JMenuItem itemNuevo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JList<String> listaErroresSintac;
    private javax.swing.JTextField status;
    private javax.swing.JTable tbEstructurasValidas;
    private javax.swing.JTable tbLexemasInvalidos;
    private javax.swing.JTable tbLexemasValidos;
    private javax.swing.JTextArea textArea;
    private javax.swing.JLabel txtArchivoOpen;
    private javax.swing.JTextField txtCoincidencias;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}
