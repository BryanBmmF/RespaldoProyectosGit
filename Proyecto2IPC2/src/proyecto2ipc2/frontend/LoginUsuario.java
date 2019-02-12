/*
 * Login de los Usuarios
 */
package proyecto2ipc2.frontend;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import proyecto2ipc2.backend.Hotel.Hotel;
import proyecto2ipc2.backend.Restaurante.Restaurante;
import proyecto2ipc2.backend.User.ControladorUsuarios;
import proyecto2ipc2.backend.User.Logger;

/**
 *
 * @author bryan
 */
public class LoginUsuario extends javax.swing.JDialog {
    private String tipoUsuario;
    public static final String TIPO_1="Gerente_General"; 
    public static final String TIPO_2="Recepcionista";
    public static final String TIPO_3="Mesero";
    public static final String TIPO_4="Gerente_Hotel";
    public static final String TIPO_5="Gerente_Restaurante";
    public static final String ADVERTENCIA="Su Usuario no esta Asignado a ningun \n establecimiento de la Empresa";
    public static final String ERROR_DE_AUTENTICACION="User y/o Password Incorrectos \n Intente nuevamente";
    private Restaurante rest;
    private Hotel hotel;
    private JFramePrincipal ventana;
    /**
     * Creates new form LoginUsuario
     */
    public LoginUsuario(JFramePrincipal ventana) {
            initComponents();
            this.ventana= ventana;
            setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLogin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login de Usuario Empresa \"Comer y Dormir\"");
        setResizable(false);

        panelLogin.setBackground(new java.awt.Color(204, 204, 204));
        panelLogin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Login del Sistema");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2ipc2/frontend/img/login.png"))); // NOI18N

        jLabel3.setText("User:");

        jLabel4.setText("Password:");

        jButton1.setText("Ingresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3)
                                .addComponent(txtUser)
                                .addComponent(jLabel4)
                                .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)))))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            // TODO add your handling code here:
            // Accion del boton Entrar:
            //obteniendo datos del usuario en las cajas de texto
            String user= new String (txtUser.getText());
            String password = new String(txtPassword.getPassword());
            ControladorUsuarios control= new ControladorUsuarios();
            //recuperando tipo de Usuario
            tipoUsuario=control.ValidarIngreso(user, password);
            if (tipoUsuario!=null) {
                    switch (tipoUsuario) {
                            case TIPO_1:
                                    ventana.habilitarOpsGerente(user);
                                    asignarLogger(user, null, 0);
                                    visualizarVentana();
                                    break;
                            case TIPO_2:
                                    hotel= control.consultarHotelAsignado(user);
                                    if (hotel!=null) {
                                            ventana.habilitarOpsRecepcionista(user,hotel.getNombre(),hotel.getId());
                                            asignarLogger(user, hotel.getNombre(), hotel.getId());
                                            visualizarVentana();
                                    } else {
                                                JOptionPane.showMessageDialog(null,ADVERTENCIA);
                                        }
                                    
                                    break;
                            case TIPO_3:
                                    rest= control.consultarRestAsignado(user);
                                    if (rest!=null) {
                                            ventana.habilitarOpsEncargadoRestaurante(user,rest.getNombre(),rest.getId());
                                            asignarLogger(user, rest.getNombre(), rest.getId());
                                            visualizarVentana();
                                    } else {
                                                JOptionPane.showMessageDialog(null,ADVERTENCIA);
                                        }
                                    break;
                            case TIPO_4:
                                    hotel= control.consultarHotelAsignado(user);
                                    if (hotel!=null) {
                                            ventana.habilitarOpsGerenteHotel(user,hotel.getNombre(),hotel.getId());
                                            asignarLogger(user, hotel.getNombre(), hotel.getId());
                                            visualizarVentana();
                                    } else {
                                                JOptionPane.showMessageDialog(null,ADVERTENCIA);
                                        }
                                    break;
                            case TIPO_5:
                                    rest= control.consultarRestAsignado(user);
                                    if (rest!=null) {
                                            ventana.habilitarOpsGerenteRestaurante(user,rest.getNombre(),rest.getId());
                                            asignarLogger(user, rest.getNombre(), rest.getId());
                                            visualizarVentana();
                                    } else {
                                                JOptionPane.showMessageDialog(null,ADVERTENCIA);
                                        }
                                    break;
                            default:
                                    throw new AssertionError();
                    }
            
            }else{
                    //this.setVisible(true);
                    JOptionPane.showMessageDialog(null,ERROR_DE_AUTENTICACION);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed
    private void visualizarVentana(){
            this.dispose();
            ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
            ventana.setVisible(true);
            
    }
    private void asignarLogger(String user,String establecimiento,int idEstablecimiento){
            Logger logger= Logger.getInstance();
            logger.setUser(user);
            logger.setEstablecimiento(establecimiento);
            logger.setIdEstablecimiento(idEstablecimiento);
            
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
