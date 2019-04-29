/*
 * Panel Grafico
 */
package practica2compi1.frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.geom.Line2D;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import practica2compi1.Lexer;
import practica2compi1.backend.archivos.ControladorDeArchivos;
import practica2compi1.parser;

/**
 *
 * @author bryan
 */
public class PanelGrafico extends javax.swing.JPanel {
    private List<Line2D> listaLineas;
    private HashMap<String, Integer> variablesInstruc;
    private HashMap<String, Integer> variablesArchiv;
    
    private int centroX;
    private int centroY;
    private int actualX;
    private int actualY;
    private int LimX;
    private int LimY;
    private int RotDerecha;
    private int RotIzquierda;
    private double mActual;
    private boolean pluma;
    private boolean sobreX;
    private boolean tortuga;
    private boolean borrador;
    private boolean sobreY;
    private boolean negativoX;
    private boolean negativoY;
    
    private Color color;
    
    
    private Lexer lexer;
    private parser parser;
    
    private FramePrincipal principal;
    /**
     * Creates new form PanelGrafico
     * @param principal
     */
    public PanelGrafico(FramePrincipal principal) {
        initComponents();
        definirCentro();
        this.principal=principal;
        this.lexer = new Lexer(new StringReader(""), this.txtMensajes);
        this.parser = new parser(lexer, this, "instrucciones");
        listaLineas= new ArrayList();
        variablesArchiv = new HashMap<String, Integer>();
        variablesInstruc = new HashMap<String, Integer>();
        color= new Color(0,0,0);

    }
    public void agregarLinea(int x1,int y1,int xf,int yf){
            listaLineas.add(new Line2D.Double(x1,y1, xf, yf));
    }
    
    public void agregarVariableInstruc(String nombre, Integer valor){
            variablesInstruc.put(nombre, valor);
    }
    
    public void agregarVariableArchiv(String nombre, Integer valor){
            variablesArchiv.put(nombre, valor);
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
    
    
    /*en una signacion, si no existe la variable se crea y se asigna su valor, si ya existe solo se setea su valor
        para una busqueda devolver el nombre , si devuleve null es porque no se encontro la variable*/
    
    public void vaciarListaLineas(){
        listaLineas.clear();
    }
    
    public void establecerColorHexa(String colorStr) {
            color = new Color(
            Integer.valueOf( colorStr.substring( 1, 3 ), 16 ),
            Integer.valueOf( colorStr.substring( 3, 5 ), 16 ),
            Integer.valueOf( colorStr.substring( 5, 7 ), 16 ) );
    }
    
    public void establecerColor(int n){
            switch (n) {
            case 1:
                color = new Color(0,0,0);
                break;
            case 2:
                color = new Color(255,0,0);
                break;
            case 3:
                color = new Color(0,255,0);
                break;
            case 4:
                color = new Color(0,0,255);
                break;
            case 5:
                color = new Color(255,255,0);
                break;
            case 6:
                color = new Color(0,255,255);
                break;
            case 7:
                color = new Color(255,0,255);
                break;
            case 8:
                color = new Color(255,255,255);
                break;
            default:
                throw new AssertionError();
        }
    }
    
    @Override
    public void paint(Graphics g)  {

        /*si esta activada la pluma dibujar las lineas de la lista
        si no unicamente mover de posicion la imagen de la tortuga..*/

        super.paint(g);
        int cont = 0;
        Graphics2D g2 = (Graphics2D)g;
        g2.setPaint(getColor());
        if (listaLineas.isEmpty()) {
                g.drawImage(img, getCentroX()-15, getCentroY()-5, null);///tambien para posiciones
        } else {
                
                if (isTortuga()) {
                    for(Line2D line:listaLineas){
                        g2.draw(line);
                        if (cont == listaLineas.size()-1) {
                            g.drawImage(img, (int)line.getP2().getX()-15, (int)line.getP2().getY()-5, null);
                        }
                        cont++;
                    }
                
                } else {
                    for(Line2D line:listaLineas){
                        g2.draw(line);
                    }
                }

        }

        //g2.draw(new Line2D.Double(100, 200, 100, 500));


        try {
            img= ImageIO.read(new File("src/practica2compi1/frontend/img/tg2.png"));

            //g.drawRect(100, 200, 100, 500);
        } catch (IOException ex) {
            Logger.getLogger(PanelGrafico.class.getName()).log(Level.SEVERE, null, ex);
        }

        //g.drawImage(img, 100, 100, null);

    }
    public void rep(){
            this.repaint();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMensajes = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        textArea.setColumns(20);
        textArea.setRows(5);
        textArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textAreaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(textArea);

        jLabel1.setText("Comandos:");

        txtMensajes.setEditable(false);
        txtMensajes.setColumns(20);
        txtMensajes.setRows(5);
        jScrollPane2.setViewportView(txtMensajes);

        jLabel2.setText("Mensajes:");

        jToolBar1.setBackground(new java.awt.Color(51, 51, 255));
        jToolBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToolBar1.setRollover(true);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(204, 204, 204));
        jButton1.setText("1");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setBackground(new java.awt.Color(204, 0, 0));
        jButton2.setForeground(new java.awt.Color(204, 204, 204));
        jButton2.setText("2");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton3.setBackground(new java.awt.Color(0, 204, 0));
        jButton3.setText("3");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton4.setBackground(new java.awt.Color(0, 0, 255));
        jButton4.setText("4");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        jButton5.setBackground(new java.awt.Color(255, 255, 0));
        jButton5.setText("5");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton5);

        jButton6.setBackground(new java.awt.Color(0, 255, 255));
        jButton6.setText("6");
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton6);

        jButton7.setBackground(new java.awt.Color(255, 0, 204));
        jButton7.setText("7");
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton7);

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica2compi1/frontend/img/limpiar.png"))); // NOI18N
        jButton10.setFocusable(false);
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton10);

        jButton8.setText("Guardar");
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton8);

        jButton9.setText("Abrir");
        jButton9.setFocusable(false);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton9);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(240, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        color = new Color(255,255,0);
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void textAreaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textAreaKeyReleased
        // TODO add your handling code here:
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) { //
                    txtMensajes.setText("");//limpiando area de mensajes
                    String entrada = this.obtenerUltimaInstruccionConsola();
                    System.out.println("Intruccion: "+entrada);
                    this.lexer.yyreset(new StringReader(entrada));
                    try {
                            this.parser.parse();
                    } catch (Exception ex) {
                            Logger.getLogger(PanelGrafico.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
    }//GEN-LAST:event_textAreaKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
            color = new Color(0,0,0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
            color = new Color(255,0,0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
            color = new Color(0,255,0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
            color = new Color(0,0,255);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
            color = new Color(0,255,255);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
            color = new Color(255,0,255);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:            
            guardarArchivo();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
            edicion = new EdicionKok(getPrincipal(),this);
            edicion.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        textArea.setText("");
    }//GEN-LAST:event_jButton10ActionPerformed
    //metodo para guardar un archivo POR DEFECTO
    private void guardarArchivo() {
            ControladorDeArchivos controlador= new ControladorDeArchivos();
             /**llamamos el metodo que permite cargar la ventana*/
            JFileChooser file=new JFileChooser();
            file.showSaveDialog(this);
            controlador.exportarAarchivo(file.getSelectedFile(), textArea.getText(),".kok");//por defecto sin extension

    }
    
    public void definirCentro(){
            Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
            int height = pantalla.height;
            int width = pantalla.width;
            int x= (width/2)-40;
            int y = (height/2)-150;
            int xLim = x*2;
            int yLim = y*2;
            
            setCentroX(x);
            setCentroY(y);
            setActualX(x);
            setActualY(y);
            
            setLimX(xLim);
            setLimY(yLim);
            setRotDerecha(0);
            setRotIzquierda(0);
            setSobreY(true);
            setSobreX(false);
            setNegativoX(false);
            setNegativoY(false);
            setmActual(0);
            
            setPluma(true);
            setTortuga(true);
            setBorrador(false);
            
    }
    /*
        Metodo que devuelve la ultima linea de instruccion en la consola
    */
    public String obtenerUltimaInstruccionConsola() {
            String[] lineas = textArea.getText().split("\n");
            return lineas[lineas.length-1];
    }

    public int obtenerC(int a, int b){
            int operando = (int)(Math.pow(a, 2)+ Math.pow(b, 2));
            double raiz = (double) Math.sqrt(operando);
            
            return (int)Math.round(raiz);
            
    }
    public int obtenerX(int h, double m){
//            double operando = (double)Math.pow(h, 2)/(double)Math.pow(m, 2)+1;
//            double raiz = (double) Math.sqrt(operando);
//            System.out.println(""+raiz);
//            
            double result = h*(Math.sin(m));
            return (int)Math.round(result);
            
            
    
    }
    
    public int obtenerY(int h, double m){
//            double operando = (double)Math.pow(h, 2)/((1/m)+1);
//            double raiz = (double) Math.sqrt(operando);
//            System.out.println(""+raiz);
            
             double result = h*(Math.cos(m));
            return (int)Math.round(result);
    
    }
    
    public double convertRad(int g){
        return Math.toRadians(g);
    }
    
    public int getCentroX() {
        return centroX;
    }

    public void setCentroX(int centroX) {
        this.centroX = centroX;
    }

    public int getCentroY() {
        return centroY;
    }

    public void setCentroY(int centroY) {
        this.centroY = centroY;
    }

    public int getActualX() {
        return actualX;
    }

    public void setActualX(int actualX) {
        this.actualX = actualX;
    }

    public int getActualY() {
        return actualY;
    }

    public void setActualY(int actualY) {
        this.actualY = actualY;
    }

    public double getmActual() {
        return mActual;
    }

    public void setmActual(double mActual) {
        this.mActual = mActual;
    }

    

    public boolean isSobreX() {
        return sobreX;
    }

    public void setSobreX(boolean sobreX) {
        this.sobreX = sobreX;
    }

    public boolean isSobreY() {
        return sobreY;
    }

    public void setSobreY(boolean sobreY) {
        this.sobreY = sobreY;
    }

    public boolean isNegativoX() {
        return negativoX;
    }

    public void setNegativoX(boolean negativoX) {
        this.negativoX = negativoX;
    }

    public boolean isNegativoY() {
        return negativoY;
    }

    public void setNegativoY(boolean negativoY) {
        this.negativoY = negativoY;
    }

    public boolean isTortuga() {
        return tortuga;
    }

    public void setTortuga(boolean tortuga) {
        this.tortuga = tortuga;
    }

    public boolean isBorrador() {
        return borrador;
    }

    public void setBorrador(boolean borrador) {
        this.borrador = borrador;
    }

    
    
    public boolean isPluma() {
        return pluma;
    }

    public void setPluma(boolean pluma) {
        this.pluma = pluma;
    }

    public int getLimX() {
        return LimX;
    }

    public void setLimX(int LimX) {
        this.LimX = LimX;
    }

    public int getLimY() {
        return LimY;
    }

    public void setLimY(int LimY) {
        this.LimY = LimY;
    }

    public int getRotDerecha() {
        return RotDerecha;
    }

    public void setRotDerecha(int RotDerecha) {
        this.RotDerecha = RotDerecha;
    }

    public int getRotIzquierda() {
        return RotIzquierda;
    }

    public void setRotIzquierda(int RotIzquierda) {
        this.RotIzquierda = RotIzquierda;
    }
    
    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }

    public JTextArea getTxtMensajes() {
        return txtMensajes;
    }

    public void setTxtMensajes(JTextArea txtMensajes) {
        this.txtMensajes = txtMensajes;
    }

    public FramePrincipal getPrincipal() {
        return principal;
    }

    public void setPrincipal(FramePrincipal principal) {
        this.principal = principal;
    }
    
    
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public HashMap<String, Integer> getVariablesInstruc() {
        return variablesInstruc;
    }

    public void setVariablesInstruc(HashMap<String, Integer> variablesInstruc) {
        this.variablesInstruc = variablesInstruc;
    }

    public HashMap<String, Integer> getVariablesArchiv() {
        return variablesArchiv;
    }

    public void setVariablesArchiv(HashMap<String, Integer> variablesArchiv) {
        this.variablesArchiv = variablesArchiv;
    }
    
    
    
    
    private EdicionKok edicion;
    private Image img;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextArea textArea;
    private javax.swing.JTextArea txtMensajes;
    // End of variables declaration//GEN-END:variables
}
