/*
 * Primer formulario con Swing
 */
package practicagrafica;

import javax.swing.JOptionPane;

/**
 *
 * @author bryan
 */

public class Formulario extends javax.swing.JFrame {

    /**
     * Creates new form Formulario
     */
    //variables a utilizar
    private static String generoElegido="";
    private static String estadoElegido="";
    private static String gustosElegidos="";
    
    public Formulario() {
        initComponents();
        dialogoResum= new DialogoResumen(this);
        this.lbError.setVisible(false);
        this.setLocationRelativeTo(null);
         
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        estadoCivil = new javax.swing.ButtonGroup();
        genero = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comboCarrera = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        rbtnSoltero = new javax.swing.JRadioButton();
        rbtnCasado = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        rbtnMasculino = new javax.swing.JRadioButton();
        rbtnFemenino = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        checkMusica = new javax.swing.JCheckBox();
        checkLectura = new javax.swing.JCheckBox();
        checkDeportes = new javax.swing.JCheckBox();
        checkComida = new javax.swing.JCheckBox();
        btnGuardar = new javax.swing.JButton();
        lbError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Formulario");
        setSize(new java.awt.Dimension(396, 359));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Nombre ");

        jLabel2.setText("Apellido");

        jLabel3.setText("Carrera");

        comboCarrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ingenieria en Ciencias y Sistemas", "Ingenieria Civil", "Ingenieria Industrial", "Ingenieria Mecanica", "Ingenieria Mecanica Industrial" }));

        jLabel4.setText("Estado Civil");

        estadoCivil.add(rbtnSoltero);
        rbtnSoltero.setText("Soltero");
        rbtnSoltero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnSolteroActionPerformed(evt);
            }
        });

        estadoCivil.add(rbtnCasado);
        rbtnCasado.setText("Casado");
        rbtnCasado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnCasadoActionPerformed(evt);
            }
        });

        jLabel5.setText("Genero");

        genero.add(rbtnMasculino);
        rbtnMasculino.setText("Masculino");
        rbtnMasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnMasculinoActionPerformed(evt);
            }
        });

        genero.add(rbtnFemenino);
        rbtnFemenino.setText("Femenino");
        rbtnFemenino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnFemeninoActionPerformed(evt);
            }
        });

        jLabel6.setText("Gustos");

        checkMusica.setText("Musica");

        checkLectura.setText("Lectura");

        checkDeportes.setText("Deportes");

        checkComida.setText("Comida");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        lbError.setForeground(new java.awt.Color(204, 0, 0));
        lbError.setText("*. El nombre y Apellido son Obligatorios");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(btnGuardar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(lbError, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNombre)
                                .addComponent(txtApellido)
                                .addComponent(comboCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(rbtnMasculino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rbtnSoltero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(checkMusica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(checkDeportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(rbtnFemenino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rbtnCasado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(checkComida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(checkLectura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(266, Short.MAX_VALUE)
                .addComponent(lbError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(comboCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(rbtnSoltero)
                        .addComponent(rbtnCasado))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(rbtnMasculino)
                        .addComponent(rbtnFemenino))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(checkMusica)
                        .addComponent(checkLectura))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(checkDeportes)
                        .addComponent(checkComida))
                    .addContainerGap(65, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //acciones de cada radio button
    private void rbtnSolteroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnSolteroActionPerformed
        estadoElegido= rbtnSoltero.getText();
    }//GEN-LAST:event_rbtnSolteroActionPerformed

    private void rbtnCasadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnCasadoActionPerformed
        estadoElegido=rbtnCasado.getText();
    }//GEN-LAST:event_rbtnCasadoActionPerformed

    private void rbtnMasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnMasculinoActionPerformed
        generoElegido= rbtnMasculino.getText();
    }//GEN-LAST:event_rbtnMasculinoActionPerformed

    private void rbtnFemeninoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnFemeninoActionPerformed
        generoElegido= rbtnFemenino.getText();
    }//GEN-LAST:event_rbtnFemeninoActionPerformed
    //accion de boton guardar en el formulario
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty()) {
            //datos incompletos
            this.lbError.setVisible(true);
        }else{
            int confirmar = JOptionPane.showConfirmDialog(null, "Esta Seguro de Guardar estos Datos?");
            if (confirmar==0) {
                gustosElegidos();//se acumulan los gustos elegidos en los CheckBox
                //se actualiza el area  de texto del Dialogo Resumen con cada dato
                dialogoResum.actualizarAreaDeTexto("Nombre: "+txtNombre.getText()
                                                +"\nApellido: "+txtApellido.getText()
                                                +"\nCarrera: "+comboCarrera.getSelectedItem()
                                                +"\nEstado Civil: "+estadoElegido
                                                +"\nGenero: "+generoElegido
                                                +"\nGustos: "+gustosElegidos);
                dialogoResum.setVisible(true); //se hace visible el Dialogo Resumen  
            }
            if(confirmar==1) this.lbError.setVisible(false);
            if(confirmar==2) resetearFormulario();
        }        
    }//GEN-LAST:event_btnGuardarActionPerformed
    //se verifican los gustos escogidos
    private void gustosElegidos() {                                             
        if(checkComida.isSelected())gustosElegidos=gustosElegidos+checkComida.getText()+", ";
        if(checkDeportes.isSelected())gustosElegidos=gustosElegidos+checkDeportes.getText()+", ";
        if(checkLectura.isSelected())gustosElegidos=gustosElegidos+checkLectura.getText()+", ";
        if(checkMusica.isSelected())gustosElegidos=gustosElegidos+checkMusica.getText()+", ";
    }  
    // reseteo del Formulario
    protected void resetearFormulario(){
        gustosElegidos="";
        txtApellido.setText(""); txtNombre.setText("");
        checkComida.setSelected(false);  checkDeportes.setSelected(false);
        checkLectura.setSelected(false); checkMusica.setSelected(false);
        estadoCivil.clearSelection(); genero.clearSelection();
        comboCarrera.setSelectedIndex(0); this.lbError.setVisible(false);
    }
    private DialogoResumen dialogoResum;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JCheckBox checkComida;
    private javax.swing.JCheckBox checkDeportes;
    private javax.swing.JCheckBox checkLectura;
    private javax.swing.JCheckBox checkMusica;
    private javax.swing.JComboBox<String> comboCarrera;
    private javax.swing.ButtonGroup estadoCivil;
    private javax.swing.ButtonGroup genero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbError;
    private javax.swing.JRadioButton rbtnCasado;
    private javax.swing.JRadioButton rbtnFemenino;
    private javax.swing.JRadioButton rbtnMasculino;
    private javax.swing.JRadioButton rbtnSoltero;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
