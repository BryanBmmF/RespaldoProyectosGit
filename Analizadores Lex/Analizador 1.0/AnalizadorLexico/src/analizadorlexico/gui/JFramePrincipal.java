/*
 * Gui principal
 */
package analizadorlexico.gui;

import analizadorlexico.backend.Procesador;
import analizadorlexico.backend.ControladorDeArchivos;
import analizadorlexico.backend.Lexema;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
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
    public JFramePrincipal() {
        initComponents();
        btnDeshacer.setEnabled(false);
        btnRehacer.setEnabled(false);
        
        estado.setText("Digite la palabra a buscar.");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        hilit = new DefaultHighlighter();
        painter = new DefaultHighlighter.DefaultHighlightPainter(Color.CYAN);
        textArea.setHighlighter(hilit);
        colorfondodefault = txtbuscar.getBackground();
        
        this.LanzarEventHacerRehacer();
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
        jLabel2 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbLexemasValidos = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbLexemasInvalidos = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbErrores = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        estado = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        btnLimpiarArea = new javax.swing.JButton();
        btnAnalizar = new javax.swing.JButton();
        btnCopiar = new javax.swing.JButton();
        btnPegar = new javax.swing.JButton();
        btnCortar = new javax.swing.JButton();
        btnDeshacer = new javax.swing.JButton();
        btnRehacer = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemAbrirArchivo = new javax.swing.JMenuItem();
        itemGuardarComo = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
        jScrollPane1.setViewportView(textArea);

        jLabel1.setText("Estado:");

        status.setEditable(false);

        jLabel2.setText("Buscar Patron:");

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtbuscar)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addGap(11, 11, 11))
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

        tbErrores.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tbErrores);

        jLabel3.setText("Tokens Validos");

        jLabel4.setText("Tokens Invalidos");

        jLabel5.setText("Errores");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(estado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jToolBar1.setRollover(true);

        btnLimpiarArea.setText("Limpiar Area de Texto");
        btnLimpiarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarAreaActionPerformed(evt);
            }
        });
        jToolBar1.add(btnLimpiarArea);

        btnAnalizar.setText("Analizar");
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

        btnCortar.setText("Cortar");
        btnCortar.setFocusable(false);
        btnCortar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCortar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCortar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCortarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCortar);

        btnDeshacer.setText("Deshacer");
        btnDeshacer.setFocusable(false);
        btnDeshacer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDeshacer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDeshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeshacerActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDeshacer);

        btnRehacer.setText("Rehacer");
        btnRehacer.setFocusable(false);
        btnRehacer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRehacer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRehacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRehacerActionPerformed(evt);
            }
        });
        jToolBar1.add(btnRehacer);

        btnBuscar.setText("Buscar Patron");
        btnBuscar.setFocusable(false);
        btnBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnBuscar);

        jMenu1.setText("Archivo");

        itemAbrirArchivo.setText("Abrir Archivo");
        itemAbrirArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAbrirArchivoActionPerformed(evt);
            }
        });
        jMenu1.add(itemAbrirArchivo);

        itemGuardarComo.setText("Guardar Archivo Como..");
        itemGuardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGuardarComoActionPerformed(evt);
            }
        });
        jMenu1.add(itemGuardarComo);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Acerca de");
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
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
            Procesador procesador = new Procesador(this);
            procesador.procesarTexto(texto);
            
    }//GEN-LAST:event_btnAnalizarActionPerformed

    private void btnLimpiarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarAreaActionPerformed
        // TODO add your handling code here:
            this.textArea.setText("");
    }//GEN-LAST:event_btnLimpiarAreaActionPerformed

    private void itemAbrirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAbrirArchivoActionPerformed
        // TODO add your handling code here:
            textArea.setText(abrirArchivo());
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
                    undoManager.undo();
            } catch (CannotRedoException cre) {
                    cre.printStackTrace();
            }
            updateButtons();
    }//GEN-LAST:event_btnDeshacerActionPerformed
    //metodo para rehacer texto en el Editor
    private void btnRehacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRehacerActionPerformed
        // TODO add your handling code here:
            try {
                    undoManager.redo();
            } catch (CannotRedoException cre) {
                    cre.printStackTrace();
            }
            updateButtons();
    }//GEN-LAST:event_btnRehacerActionPerformed

    private void itemGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemGuardarComoActionPerformed
        // TODO add your handling code here:
            guardarArchivo();
    }//GEN-LAST:event_itemGuardarComoActionPerformed

    private void txtbuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyPressed
        // TODO add your handling code here:
             if(evt.getKeyCode()==KeyEvent.VK_ESCAPE){
                    hilit.removeAllHighlights();
                    txtbuscar.setText("");
                    txtbuscar.setBackground(colorfondodefault);
            }
    }//GEN-LAST:event_txtbuscarKeyPressed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        // TODO add your handling code here:
            //buscarTexto();
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void txtbuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyTyped
        // TODO add your handling code here:
            
    }//GEN-LAST:event_txtbuscarKeyTyped

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
            //buscarTexto();
            buscaPatron();
    }//GEN-LAST:event_btnBuscarActionPerformed
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
            btnDeshacer.setText("Se puede Deshacer");
            btnRehacer.setText("Se puede Rehacer");
            btnDeshacer.setEnabled(undoManager.canUndo());//se habilita o deshabilita segun el manejador
            btnRehacer.setEnabled(undoManager.canRedo());
    }
    public void cargarTablaLexemas(ArrayList<Lexema> lista){
        DefaultTableModel model= (DefaultTableModel)tbLexemasValidos.getModel();
        for(Lexema lexema: lista){
            model.addRow(new Object[]{lexema.getToken(),lexema.getLexema(),lexema.getNumeroFila(),lexema.getNumeroColumna()});
        }                        
    }
    //metodo para limpiar tablas
    public void limpiarTabla(){
            DefaultTableModel tb = (DefaultTableModel) tbLexemasValidos.getModel();
            int a = tbLexemasValidos.getRowCount()-1;
            for (int i = a; i >= 0; i--) {          
                    tb.removeRow(tb.getRowCount()-1);
            }
    }
    //metodo para actualizar el posicionamiento del cursor
    private void actualizarEstado(int linea, int columna) {
            status.setText("Linea: " + linea + " Columna: " + columna);
    }   
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
    private void guardarArchivo() {
            ControladorDeArchivos controlador= new ControladorDeArchivos();
             /**llamamos el metodo que permite cargar la ventana*/
            JFileChooser file=new JFileChooser();
            file.showSaveDialog(this);
            controlador.exportarAarchivo(file.getSelectedFile(), textArea.getText());
    }
    private String abrirArchivo() {
            ControladorDeArchivos controlador= new ControladorDeArchivos();
             /**llamamos el metodo que permite cargar la ventana*/
            JFileChooser file=new JFileChooser();
            file.showOpenDialog(this);
            /**abrimos el archivo seleccionado*/
            return controlador.cargarArchivo(file.getSelectedFile());
    }
    public void buscaPatron(){
            hilit.removeAllHighlights();//limpia el texto marcado
            String patronDeBusqueda = txtbuscar.getText(); //se captura el patron de busqueda
            String contenido = textArea.getText(); //se extrae el contenido del textArea
            int indice=0;//indice de area de texto, indice del patron, contador de exitos
            int indicePatron=0;
            int contExitos=0;
            if (patronDeBusqueda.length()>0) {// se verifica si hay algo que buscar
                    for (indice = 0; indice < contenido.length(); indice++) {
                            if (contenido.charAt(indice)==patronDeBusqueda.charAt(indicePatron)) {
                                    indicePatron++; //se evalua la coincidencia de un caracter y se incremente el indice
                            } else{
                                indicePatron=0;// si no coincide el caracter se reinicia el indice de patron
                            }
                            if (indicePatron==patronDeBusqueda.length()) {//si ya hay una coincidencia
                                    System.out.println(""+patronDeBusqueda+ " pos: "+((indice+1)-patronDeBusqueda.length()));
                                    indicePatron=0;
                                    contExitos++;
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
            System.out.println("se encontraron "+contExitos+" conicidencias");
    }
    public void buscarTexto() {
            hilit.removeAllHighlights();
            String patronDeBusqueda = txtbuscar.getText();
            
            if (patronDeBusqueda.length() > 0) { //si hay algo que buscar
                    String contenido = textArea.getText(); //se extrae el contenido del textArea
                    int cont=1;
                    int indiceB=0;
                    boolean buscar=true;
                    while(buscar=true || cont<contenido.length()){
                            int index = contenido.indexOf(patronDeBusqueda, indiceB); //se busca el patron en el contenido inicia desde indice cero
                            if (index >= 0) {
                                    try {
                                            int end = index + patronDeBusqueda.length();
                                            hilit.addHighlight(index, end, painter); //recibe el inicio final, y color de la cadena 
                                            textArea.setCaretPosition(end);
                                            txtbuscar.setBackground(colorfondodefault);
                                            estado.setText("'" + patronDeBusqueda + "' fue encontrado. Presione ESC para finalizar la busqueda.");
                                            indiceB=index;//se actualiza la posicion para seguir buscando mas coincidencias
                                    } catch (BadLocationException e) {
                                            e.printStackTrace();
                                    }
                            } else {
                                    buscar=false;
                                    txtbuscar.setBackground(Color.ORANGE);
                                    estado.setText("'" + patronDeBusqueda + "' no se ha encontrado. Presione ESC para finalizar la busqueda.");
                            }
                        cont++;   
                        System.out.println("++++++++");
                    }
                    System.out.println("se encontraron : "+cont+" coincidencias");
            } else  {
                    estado.setText("Digite la palabra a buscar.");
            }
    }
    public void buscarTextoOrigin() {
            hilit.removeAllHighlights();
            String patronDeBusqueda = txtbuscar.getText();
            
            if (patronDeBusqueda.length() > 0) { //si hay algo que buscar
                    String contenido = textArea.getText(); //se extrae el contenido del textArea
                    
                    int index = contenido.indexOf(patronDeBusqueda, 0); //se busca el patron en el contenido
                    if (index >= 0) {
                            try {
                                    int end = index + patronDeBusqueda.length();
                                    hilit.addHighlight(index, end, painter);
                                    textArea.setCaretPosition(end);
                                    txtbuscar.setBackground(colorfondodefault);
                                    estado.setText("'" + patronDeBusqueda + "' fue encontrado. Presione ESC para finalizar la busqueda.");
                            } catch (BadLocationException e) {
                                    e.printStackTrace();
                            }
                    } else {
                            txtbuscar.setBackground(Color.ORANGE);
                            estado.setText("'" + patronDeBusqueda + "' no se ha encontrado. Presione ESC para finalizar la busqueda.");
                    }
            } else  {
                    estado.setText("Digite la palabra a buscar.");
            }
    }
    private Color colorfondodefault;
    private Highlighter hilit;
    private Highlighter.HighlightPainter painter;
    //se declara un miembro manejador para el manejo de eventos Rehacer Deshacer cambios
     protected UndoManager undoManager = new UndoManager();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCopiar;
    private javax.swing.JButton btnCortar;
    private javax.swing.JButton btnDeshacer;
    private javax.swing.JButton btnLimpiarArea;
    private javax.swing.JButton btnPegar;
    private javax.swing.JButton btnRehacer;
    private javax.swing.JLabel estado;
    private javax.swing.JMenuItem itemAbrirArchivo;
    private javax.swing.JMenuItem itemGuardarComo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField status;
    private javax.swing.JTable tbErrores;
    private javax.swing.JTable tbLexemasInvalidos;
    private javax.swing.JTable tbLexemasValidos;
    private javax.swing.JTextArea textArea;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}
