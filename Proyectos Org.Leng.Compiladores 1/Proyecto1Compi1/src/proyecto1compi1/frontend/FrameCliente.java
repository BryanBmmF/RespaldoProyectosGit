/*
 * Gui principal
 */
package proyecto1compi1.frontend;

import proyecto1compi1.backend.ControladorDeArchivos;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.StringReader;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.UndoManager;
import proyecto1compi1.Lexer;
import proyecto1compi1.backend.app.Cliente;
import proyecto1compi1.backend.app.Servidor;
import proyecto1compi1.parserEvaluador;

/**
 *
 * @author bryan
 */
public class FrameCliente extends javax.swing.JFrame implements Observer{

    /**
     * Creates new form FrameCliente
     */
    public static final String PATRON_ENC="' este patron fue encontrado en el texto.";
    public static final String PATRON_NO_ENC="' este patron no fue encontrado en el texto.";
    public static final String PATH_ICONO="src/proyecto1compi1/frontend/img/iconoAnalizador.png";
    
    private Lexer lexer;
    private parserEvaluador parser1;
    private Servidor servidor;
    private Thread hilo;
    
    public FrameCliente() {
        initComponents(); 
        this.lexer = new Lexer(new StringReader(""), this.txtRespuestas);
        this.parser1 = new parserEvaluador(lexer,this.txtRespuestas);
        this.servidor= new Servidor(5000);
        this.servidor.addObserver(this);//se agrega el primer observador en este caso this 
        this.hilo= new Thread(servidor);
        hilo.start();//arranca el servidor
        //clase toolkit devuelve la resolucion nativa del sistema huesped        
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        //colocacion de icono a la pantalla
        Image icono=miPantalla.getImage(PATH_ICONO);      
        setIconImage(icono);
        
        btnDeshacer.setEnabled(false);// deshabilitando botones de rehacer deshacer
        btnRehacer.setEnabled(false);
        
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
        btnAnalizar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtRespuestas = new javax.swing.JTextArea();
        jToolBar1 = new javax.swing.JToolBar();
        btnLimpiarArea = new javax.swing.JButton();
        btnCopiar = new javax.swing.JButton();
        btnPegar = new javax.swing.JButton();
        btnCortar = new javax.swing.JButton();
        btnDeshacer = new javax.swing.JButton();
        btnRehacer = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        itemGuardar = new javax.swing.JMenu();
        itemAbrirArchivo = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplicacion Cliente");

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        textArea.setBackground(new java.awt.Color(153, 153, 153));
        textArea.setColumns(20);
        textArea.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        textArea.setForeground(new java.awt.Color(0, 51, 255));
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

        btnAnalizar.setText("Analizar Contenido");
        btnAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarActionPerformed(evt);
            }
        });

        jButton1.setText("Enviar al Servidor");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAnalizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnalizar)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setText("Errores y Respuestas del Servidor:");

        txtRespuestas.setEditable(false);
        txtRespuestas.setBackground(new java.awt.Color(102, 153, 255));
        txtRespuestas.setColumns(20);
        txtRespuestas.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtRespuestas.setForeground(new java.awt.Color(255, 0, 0));
        txtRespuestas.setRows(5);
        jScrollPane2.setViewportView(txtRespuestas);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                .addContainerGap())
        );

        jToolBar1.setRollover(true);

        btnLimpiarArea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto1compi1/frontend/img/limpiar.png"))); // NOI18N
        btnLimpiarArea.setText("Limpiar Area de Texto");
        btnLimpiarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarAreaActionPerformed(evt);
            }
        });
        jToolBar1.add(btnLimpiarArea);

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

        btnCortar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto1compi1/frontend/img/cortar.png"))); // NOI18N
        btnCortar.setFocusable(false);
        btnCortar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCortar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCortar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCortarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCortar);

        btnDeshacer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto1compi1/frontend/img/deshacer.png"))); // NOI18N
        btnDeshacer.setFocusable(false);
        btnDeshacer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDeshacer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDeshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeshacerActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDeshacer);

        btnRehacer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto1compi1/frontend/img/rehacer.png"))); // NOI18N
        btnRehacer.setFocusable(false);
        btnRehacer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRehacer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRehacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRehacerActionPerformed(evt);
            }
        });
        jToolBar1.add(btnRehacer);

        itemGuardar.setText("Archivo");

        itemAbrirArchivo.setText("Abrir Archivo");
        itemAbrirArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAbrirArchivoActionPerformed(evt);
            }
        });
        itemGuardar.add(itemAbrirArchivo);

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 816, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarActionPerformed
        // TODO add your handling code here:
            txtRespuestas.setText("");
            parser1.limpiarListas();// limpiar listas del parser1 para una nueva avaluacion
            String entrada= textArea.getText();            
            this.lexer.yyreset(new StringReader(entrada));
            try {
                    this.parser1.parse();
            } catch (Exception ex) {
                    Logger.getLogger(FrameCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            /*Verificacion de Errores*/
            if (parser1.devolverErrores().isEmpty()) {
                    txtRespuestas.append("ANALISIS CORRECTO COMPLETADO!!!!"+"\n");
                    System.out.println("ANALISIS CORRECTO COMPLETADO!!!!");
                    Cliente c = new Cliente(6000, entrada);//se envia la entrada desde el cliente
                    Thread t = new Thread(c);
                    t.start();
            } else {
                    System.out.println("HAY ERRORES");
            }
        
           
            
    }//GEN-LAST:event_btnAnalizarActionPerformed

    private void btnLimpiarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarAreaActionPerformed
        // TODO add your handling code here:
            this.textArea.setText("");
    }//GEN-LAST:event_btnLimpiarAreaActionPerformed

    private void itemAbrirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAbrirArchivoActionPerformed
        // TODO add your handling code here:
            textArea.setText(abrirArchivo());//SE ABRE LA VENTANA PARA ABRIR ARCHIVO
            
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

                    // Ya que las líneas las cuenta desde 0
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

    private void textAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textAreaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_textAreaKeyPressed

    private void textAreaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textAreaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_textAreaKeyReleased

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
             JOptionPane.showMessageDialog(this,
             "Desarrollador: Bryan Monzon USAC-CUNOC \n Ingenieria en Ciencias y Sistemas 2019","Informacion",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItem2ActionPerformed
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
            btnDeshacer.setEnabled(undoManager.canUndo());//se habilita o deshabilita segun el manejador
            btnRehacer.setEnabled(undoManager.canRedo());
    }
    
    //metodo para actualizar el posicionamiento del cursor
    private void actualizarEstado(int linea, int columna) {
            status.setText("Linea: " + linea + " Columna: " + columna);
    }   

    //metodo para abriri un archivo
    private String abrirArchivo() {
            ControladorDeArchivos controlador= new ControladorDeArchivos();
             /**llamamos el metodo que permite cargar la ventana*/
            JFileChooser file=new JFileChooser();
            file.showOpenDialog(this);
            //txtArchivoOpen.setText(file.getSelectedFile().getName());//se actualiza el contenedor del nombre del archivo
            /**abrimos el archivo seleccionado*/
            return controlador.cargarArchivo(file.getSelectedFile());
            
    }
 
    //se declara un miembro manejador para el manejo de eventos Rehacer Deshacer cambios
    protected UndoManager undoManager = new UndoManager();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalizar;
    private javax.swing.JButton btnCopiar;
    private javax.swing.JButton btnCortar;
    private javax.swing.JButton btnDeshacer;
    private javax.swing.JButton btnLimpiarArea;
    private javax.swing.JButton btnPegar;
    private javax.swing.JButton btnRehacer;
    private javax.swing.JMenuItem itemAbrirArchivo;
    private javax.swing.JMenu itemGuardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField status;
    private javax.swing.JTextArea textArea;
    private javax.swing.JTextArea txtRespuestas;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        txtRespuestas.append((String)arg+"\n");//respuesta del Servidor
        
    }
}
