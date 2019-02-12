/*
 * InternalFrame para cargar archivos
 */
package proyectofinal.interfaz;

import proyectofinal.fabrica.archivo.Archivo;
import proyectofinal.fabrica.archivo.Lector;

/**
 *
 * @author bryan
 */
public class CargaArchivos extends javax.swing.JInternalFrame {

    /**
     * Creates new form CargaArchivos
     */
    public CargaArchivos() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtRuta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTiempo = new javax.swing.JTextField();
        abrir = new javax.swing.JButton();
        proceso = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaTexto = new javax.swing.JTextArea();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), new java.awt.Color(51, 51, 51)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombre del Archivo: ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 270, -1));

        jLabel2.setText("Ruta del Archivo: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));
        jPanel1.add(txtRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 270, -1));

        jLabel3.setText("Tiempo de Carga: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));
        jPanel1.add(txtTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 120, -1));

        abrir.setText("Abrir Archivo");
        abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirActionPerformed(evt);
            }
        });
        jPanel1.add(abrir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        proceso.setText("Procesar");
        proceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesoActionPerformed(evt);
            }
        });
        jPanel1.add(proceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, -1, -1));

        jLabel5.setText("Carga de Archivos ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel4.setText("Proceso de Instrucciones");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, 20));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        areaTexto.setEditable(false);
        areaTexto.setBackground(new java.awt.Color(153, 153, 255));
        areaTexto.setColumns(20);
        areaTexto.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        areaTexto.setForeground(new java.awt.Color(0, 0, 102));
        areaTexto.setRows(5);
        jScrollPane1.setViewportView(areaTexto);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 440, 230));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 740, 290));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirActionPerformed
        Archivo visualizarArchivo= new Archivo();
        visualizarArchivo.buscar();

        //imprimiendo nombre y ruta del archivo en las cajas de texto
        txtNombre.setText(visualizarArchivo.getNombreArchivo());
        txtRuta.setText(visualizarArchivo.getRuta());
    }//GEN-LAST:event_abrirActionPerformed

    private void procesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_procesoActionPerformed
        Archivo visualizarArchivo= new Archivo();
        Lector lector= new Lector();

        lector.lecturaDeInstruccion(visualizarArchivo.getRuta());

        String instrucciones=lector.abrirInstrucciones("src/Instrucciones.txt");
        areaTexto.setText(instrucciones);

    }//GEN-LAST:event_procesoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abrir;
    public static javax.swing.JTextArea areaTexto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton proceso;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRuta;
    private javax.swing.JTextField txtTiempo;
    // End of variables declaration//GEN-END:variables
}
