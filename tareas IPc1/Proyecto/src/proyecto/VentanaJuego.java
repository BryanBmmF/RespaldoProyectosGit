/*
 *
 */
package proyecto;

/**
 *
 * @author bryan
 */
public class VentanaJuego extends javax.swing.JFrame {
    
    

    /**
     * Creates new form VentanaJuego
     */
    public VentanaJuego() {
        initComponents();
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        opcionJuego = new javax.swing.JMenu();
        iniciarJuego = new javax.swing.JMenuItem();
        finalizarJuego = new javax.swing.JMenuItem();
        opcionReporte = new javax.swing.JMenu();
        historialJugador = new javax.swing.JMenuItem();
        mejorJugador = new javax.swing.JMenuItem();
        opcionAcerca = new javax.swing.JMenu();
        opcionAyuda = new javax.swing.JMenu();

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 208, Short.MAX_VALUE)
        );

        opcionJuego.setText("Juego");

        iniciarJuego.setText("Iniciar Juego");
        iniciarJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarJuegoActionPerformed(evt);
            }
        });
        opcionJuego.add(iniciarJuego);

        finalizarJuego.setText("Finalizar Juego");
        opcionJuego.add(finalizarJuego);

        jMenuBar1.add(opcionJuego);

        opcionReporte.setText("Reportes");

        historialJugador.setText("Historial de Jugadores");
        opcionReporte.add(historialJugador);

        mejorJugador.setText("Mejor Jugador");
        opcionReporte.add(mejorJugador);

        jMenuBar1.add(opcionReporte);

        opcionAcerca.setText("Acerca De");
        jMenuBar1.add(opcionAcerca);

        opcionAyuda.setText("Ayuda");
        jMenuBar1.add(opcionAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void iniciarJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarJuegoActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_iniciarJuegoActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem finalizarJuego;
    private javax.swing.JMenuItem historialJugador;
    private javax.swing.JMenuItem iniciarJuego;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem mejorJugador;
    private javax.swing.JMenu opcionAcerca;
    private javax.swing.JMenu opcionAyuda;
    private javax.swing.JMenu opcionJuego;
    private javax.swing.JMenu opcionReporte;
    // End of variables declaration//GEN-END:variables
}
