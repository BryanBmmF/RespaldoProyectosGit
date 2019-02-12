/*
 * Ventana principal
 */
package examenfinal;

import static examenfinal.CarWash.listaClientes;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author bryan
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Prueba
     */
    long initialTime = System.currentTimeMillis();
    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btntAsignar = new javax.swing.JButton();
        btntRealizar = new javax.swing.JButton();
        btnIngresar = new javax.swing.JButton();
        txtNumero = new javax.swing.JTextField();
        comboPersonal = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuINgresarPersonal = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Numero de Clientes:");

        jLabel2.setText("Personal: ");

        jLabel3.setText("CarWash");

        btntAsignar.setText("Asignar Clientes a Empleado");

        btntRealizar.setText("Realizar");
        btntRealizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntRealizarActionPerformed(evt);
            }
        });

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btntRealizar)
                    .addComponent(btntAsignar)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboPersonal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumero)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIngresar)
                .addContainerGap(111, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnIngresar)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(btntAsignar)
                .addGap(18, 18, 18)
                .addComponent(btntRealizar)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        jMenu1.setText("Ingresar Personal");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        menuINgresarPersonal.setText("Ingresar Nuevo Personal");
        menuINgresarPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuINgresarPersonalActionPerformed(evt);
            }
        });
        jMenu1.add(menuINgresarPersonal);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        // TODO add your handling code here:
        int cantidad =Integer.parseInt(txtNumero.getText());
        for (int i = 0; i < cantidad; i++) {
            formularioCliente= new FormularioCliente(this);
            formularioCliente.setVisible(true);
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void menuINgresarPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuINgresarPersonalActionPerformed
        // ingresar personal
        formularioPersonal= new FormularioPersonal(this);
        formularioPersonal.setVisible(true);
    }//GEN-LAST:event_menuINgresarPersonalActionPerformed

    private void btntRealizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntRealizarActionPerformed
        // realializando lavado
        CarWash carwash= new CarWash();
        
        for(Cliente cliente: listaClientes){
            switch(cliente.getServicioSolicitado()){
                case "Lavado": car= new CarWash(String.valueOf(comboPersonal.getSelectedItem()), cliente, initialTime) ;break;
                case "Siliconeado": car= new CarWash(String.valueOf(comboPersonal.getSelectedItem()), cliente, initialTime) ;break;
                case "Aspirado": car= new CarWash(String.valueOf(comboPersonal.getSelectedItem()), cliente, initialTime);break;
            }
        }
    }//GEN-LAST:event_btntRealizarActionPerformed
    public void cargarComboPersonal(String personal){
        
        DefaultComboBoxModel model=(DefaultComboBoxModel)comboPersonal.getModel();
        model.addElement(personal);
        
    }
    private CarWash car;
    private FormularioPersonal formularioPersonal;
    private FormularioCliente formularioCliente;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btntAsignar;
    private javax.swing.JButton btntRealizar;
    private javax.swing.JComboBox<String> comboPersonal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem menuINgresarPersonal;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables
}
