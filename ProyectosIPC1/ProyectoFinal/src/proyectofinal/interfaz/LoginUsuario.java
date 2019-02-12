/*
 * Login de Usuarios
 */
package proyectofinal.interfaz;

import proyectofinal.fabrica.usuarios.Validacion;

/**
 *
 * @author bryan
 */
public class LoginUsuario extends javax.swing.JDialog {

    /**
     * Creates new form LoginUsuario
     */
    private boolean valida;
    public LoginUsuario() {
        
        initComponents();
        setLocationRelativeTo(null);

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbUser = new javax.swing.JLabel();
        lbPasword = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPasword = new javax.swing.JPasswordField();
        entrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        login.setBackground(new java.awt.Color(204, 204, 204));
        login.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinal/fabrica/imagenes/login.png"))); // NOI18N
        login.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 137, 158));

        lbUser.setText("Usuario: ");
        login.add(lbUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, -1, 20));

        lbPasword.setText("Contraseña: ");
        login.add(lbPasword, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, -1, -1));

        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });
        login.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 170, -1));

        txtPasword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPaswordActionPerformed(evt);
            }
        });
        login.add(txtPasword, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 170, -1));

        entrar.setText("Entrar");
        entrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        entrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                entrarMouseClicked(evt);
            }
        });
        entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarActionPerformed(evt);
            }
        });
        login.add(entrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, -1, -1));

        jLabel1.setFont(new java.awt.Font("FreeSans", 1, 18)); // NOI18N
        jLabel1.setText("Mi Muebleria");
        login.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 120, 30));

        jLabel3.setText("Iniciar Sesion");
        login.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, -1, -1));

        getContentPane().add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 250));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void entrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_entrarMouseClicked
        
        
    }//GEN-LAST:event_entrarMouseClicked

    private void entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarActionPerformed
         // Accion del boton Entrar:

        //obteniendo datos del usuario en las cajas de texto
        String user= new String (txtUser.getText());
        String pasword = new String(txtPasword.getPassword());
        
        //validacion para acceso al escritorio principal
        Validacion validacion= new Validacion();
        if(validacion.validar(user, pasword)){
                this.dispose();
        }
        else{
            this.setVisible(true);// sigue apareciendo el login
        }
        
       
    }//GEN-LAST:event_entrarActionPerformed

    private void txtPaswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPaswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaswordActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton entrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbPasword;
    private javax.swing.JLabel lbUser;
    private javax.swing.JPanel login;
    private javax.swing.JPasswordField txtPasword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
