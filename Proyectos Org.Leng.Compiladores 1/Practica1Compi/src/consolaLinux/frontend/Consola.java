/*
 * Ventana que emula una Consola para la Aplicacion
 */
package consolaLinux.frontend;

import consolaLinux.Lexer;
import consolaLinux.backend.archivos.Archivo;
import consolaLinux.backend.controladores.ControladorArbol;
import consolaLinux.parser;
import java.awt.event.KeyEvent;
import java.io.StringReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

/**
 *
 * @author bryan
 */
public class Consola extends javax.swing.JFrame implements TreeSelectionListener{

    /**
     * Creates new form Consola
     */
        private static final String ROOT_PERMANENTE_CONSOLA = ":~$ ";
        private static final int LONG_ROOT_PERMANENTE = ROOT_PERMANENTE_CONSOLA.length();
	
	private Lexer lexer;
	private parser parser;
	private ControladorArbol controladorArbol;
	private String ubicacionActualEnLineaComandos;
        private String historialComandos="";
	private int indiceUltimaInstruccionEntrada;
        public Consola() {
            initComponents();
            this.controladorArbol = new ControladorArbol(this.arbol);
            this.lexer = new Lexer(new StringReader(""), this.txtAreaConsola);
            this.parser = new parser(lexer, controladorArbol, txtAreaConsola);
            
            this.cargarArbolInicial();
            this.txtAreaConsola.setText("");
            //se Establece la ubicacion actual en linea de comandos
            this.ubicacionActualEnLineaComandos = reestablecerUbicacionEnLineaComandos(controladorArbol.getUbicacionActual());
            this.txtAreaConsola.setText(this.ubicacionActualEnLineaComandos);
            this.indiceUltimaInstruccionEntrada = this.calcularIndiceUltimaInstruccionEntrada();
            
            //txtAreaConsola.setText("bryan@bryan~$:");
            setLocationRelativeTo(null);
        }
        
        /*
           Metodo que reestablece la ubicacion actual en linea de comandos y la devuelve
        */
        public String reestablecerUbicacionEnLineaComandos(String pathActual) {
		return pathActual + ROOT_PERMANENTE_CONSOLA;
	}
	
	public int calcularIndiceUltimaInstruccionEntrada() {
                /*  Metodo que devuelve el indice donde se encuentra la ultima coincidencia del root permanente de consola 
                    mas su propia longitud, esto con el fin de ubicar el puntero al final de la ultima entrada
                    para ingresar una nueva instruccion
                */
		return this.txtAreaConsola.getText().lastIndexOf(ROOT_PERMANENTE_CONSOLA) + LONG_ROOT_PERMANENTE;
	}
	/*
            Metodo que devuelve la ultima linea de instruccion en la consola
        */
	public String obtenerUltimaInstruccionConsola() {
		String entradaTotal = this.txtAreaConsola.getText();
		this.indiceUltimaInstruccionEntrada = this.calcularIndiceUltimaInstruccionEntrada();
		String ultimaInstruccion = entradaTotal.substring(indiceUltimaInstruccionEntrada, entradaTotal.length() - 1);
		return ultimaInstruccion;
	}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaConsola = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        arbol = new javax.swing.JTree();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Consola GNU");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        txtAreaConsola.setBackground(new java.awt.Color(153, 153, 255));
        txtAreaConsola.setColumns(20);
        txtAreaConsola.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        txtAreaConsola.setForeground(new java.awt.Color(0, 0, 102));
        txtAreaConsola.setRows(5);
        txtAreaConsola.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtAreaConsolaCaretUpdate(evt);
            }
        });
        txtAreaConsola.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAreaConsolaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txtAreaConsola);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("/");
        arbol.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane2.setViewportView(arbol);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAreaConsolaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAreaConsolaKeyReleased
        // TODO add your handling code here:
            /**
             * Si presiona la tecla enter se manda a traer la ultima instruccion en la consola.
             * Se guarda el ultimo comando
             * Se ejecuta el analisis Lexico y Sintactico
             **/
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) { //
                    String entrada = this.obtenerUltimaInstruccionConsola();
                    this.guardarComando(entrada);//se guarda el comando en el historial
                    this.lexer.yyreset(new StringReader(entrada));
                    try {
                            this.parser.parse();
                    } catch (Exception ex) {
                            Logger.getLogger(Consola.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    /**
                     * Se reestablece la Ubicacion Actual en Linea de Comandos
                     * Se agrega al textAreaConsola la UbicacionActual en Consola
                       despues de ejecutar la Instruccion o comando.
                     * Se guarda el indice de la ultima instruccion de Entrada
                    **/
                    this.ubicacionActualEnLineaComandos = this.reestablecerUbicacionEnLineaComandos(this.controladorArbol.getUbicacionActual());
                    this.txtAreaConsola.append("\n" + this.ubicacionActualEnLineaComandos);
                    this.indiceUltimaInstruccionEntrada = this.calcularIndiceUltimaInstruccionEntrada();
             /**
             * Si presiona la tecla retroceder(backspace) se verifica si el indice de la ultima instruccion de entrada es mayor que
               que la longitud de todo el contenido de la consola, si es asi se obliga a regresar hacia adelante agregando un espacio
             * Se guarda el ultimo comando
             * Se ejecuta el analisis Lexico y Sintactico
             **/
            } else if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                            if (this.indiceUltimaInstruccionEntrada > this.txtAreaConsola.getText().length()) {
                                    this.txtAreaConsola.append(" ");//se agrega un espacio extra
                            }
                    } 
    }//GEN-LAST:event_txtAreaConsolaKeyReleased
    
    private void txtAreaConsolaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtAreaConsolaCaretUpdate
        // TODO add your handling code here:
        /**
         * se calcula la posicion del indice en el ultimo caracter en consola
         * Se verifica si la ubicacion del indice en consola donde el usuario hace click es menor que el indice de la ultima 
           instruccion en consola, Y si la ultima Pusicion del Indice es mayor que el indice de la ultima instruccionEntrada
           SE ROTORNA EL INDICE A LA POSICION DEL ULTIMO CARACTER
         **/
            
            int indiceUltimoCaracter = this.txtAreaConsola.getText().length(); 
            if (evt.getDot() < this.indiceUltimaInstruccionEntrada && indiceUltimoCaracter >= this.indiceUltimaInstruccionEntrada) {
                    this.txtAreaConsola.setCaretPosition(indiceUltimoCaracter);
            }
    }//GEN-LAST:event_txtAreaConsolaCaretUpdate

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
            
            System.out.println("cerrando ventana..........");
            //se guarda el historial de archivos
            Archivo arc = new Archivo();
            arc.escrituraBasica("src/DatosPersistentes/respaldo.txt", historialComandos);
    }//GEN-LAST:event_formWindowClosing
    
    public void guardarComando(String comando){
            if (comando.contains("ls") ||comando.contains("pwd")) {
                    //no guardar el comando
            } else {
                    historialComandos+=comando+"\n";
            }
            
    
    }
    
    //se carga el arbol como habia quedado
    public void cargarArbolInicial(){
            Archivo arc = new Archivo();
            List<String> comandos = arc.leerArchivo("src/DatosPersistentes/respaldo.txt");
            for(String entrada: comandos){
                    this.guardarComando(entrada);//se guarda el comando en el historial
                    this.lexer.yyreset(new StringReader(entrada));
                    try {
                            this.parser.parse();
                    } catch (Exception ex) {
                            Logger.getLogger(Consola.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
            }               
    
    }
            
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree arbol;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtAreaConsola;
    // End of variables declaration//GEN-END:variables

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
