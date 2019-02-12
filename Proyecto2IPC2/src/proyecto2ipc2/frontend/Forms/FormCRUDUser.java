/*
 * 
 */
package proyecto2ipc2.frontend.Forms;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyecto2ipc2.backend.User.ControladorUsuarios;
import proyecto2ipc2.backend.User.Usuario;
import static proyecto2ipc2.database.OperadorEsquema.CAMBIAR_DATOS;
import static proyecto2ipc2.database.OperadorEsquema.CAMPOS_OBLIGATORIOS;
import static proyecto2ipc2.database.OperadorEsquema.ERROR_ACTUALIZACION;
import static proyecto2ipc2.database.OperadorEsquema.ERROR_CREACION;
import static proyecto2ipc2.database.OperadorEsquema.ERROR_ELIMINACION;
import static proyecto2ipc2.database.OperadorEsquema.ERROR_RECUP;
import static proyecto2ipc2.database.OperadorEsquema.GUARDAR_DATOS;
import proyecto2ipc2.frontend.JFramePrincipal;
import static proyecto2ipc2.frontend.LoginUsuario.TIPO_2;
import static proyecto2ipc2.frontend.LoginUsuario.TIPO_3;
import static proyecto2ipc2.frontend.LoginUsuario.TIPO_4;
import static proyecto2ipc2.frontend.LoginUsuario.TIPO_5;

/**
 *
 * @author bryan
 */
public class FormCRUDUser extends javax.swing.JInternalFrame {

    /**
     * Creates new form FormCRUDUser
     */
    public static final String RECUPERAR_USUARIO ="Para recuperar los datos de un Usuario\n se debe especificar el mismo";
    public static final String ELIMINAR_USUARIO ="Para Eliminar los datos de un Usuario\n se debe especificar el mismo";
    public static final String ELIMINAR_DATOS_USUARIO ="Esta seguro de Eliminar al Usuario ";
    private ControladorUsuarios controladorUser;
    private Usuario user;
    private String userTemp;
    private JFramePrincipal ventanaprincipal;
    public FormCRUDUser(JFramePrincipal ventanaPrincipal) {
        this.userTemp=null;
        this.ventanaprincipal=ventanaPrincipal;
        initComponents();
        this.deshabilitarBotones();
        this.cargarTablaUsuarios();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPass = new javax.swing.JTextField();
        comboTipo = new javax.swing.JComboBox<>();
        btnCrear = new javax.swing.JButton();
        btnRecuperar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtCUI = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        comboEstado = new javax.swing.JComboBox<>();
        btnLimpiar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtSalario = new javax.swing.JFormattedTextField();
        btnAsignar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsuarios = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gestion de Usuarios");

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Nombre: *");

        jLabel2.setText("CUI:*");

        jLabel3.setText("Tipo:*");

        jLabel4.setText("Usuario:*");

        jLabel5.setText("Password:*");

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gerente_General", "Gerente_Hotel", "Gerente_Restaurante", "Recepcionista", "Mesero" }));

        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnRecuperar.setText("Recuperar");
        btnRecuperar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecuperarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        try {
            txtCUI.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#############")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel7.setText("Estado:*");

        comboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));

        btnLimpiar.setText("Limpiar Campos");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jLabel8.setText("Salario:*");

        txtSalario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        btnAsignar.setBackground(new java.awt.Color(51, 51, 255));
        btnAsignar.setForeground(new java.awt.Color(255, 255, 255));
        btnAsignar.setText("Asignar Establecimiento de Trabajo");
        btnAsignar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAsignar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRecuperar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombre)
                                    .addComponent(comboTipo, 0, 227, Short.MAX_VALUE)
                                    .addComponent(txtCUI))
                                .addGap(59, 59, 59)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7)))
                            .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAsignar)
                                .addGap(0, 24, Short.MAX_VALUE))
                            .addComponent(txtUser)
                            .addComponent(txtPass)
                            .addComponent(comboEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCUI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel5)
                        .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAsignar)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrear)
                    .addComponent(btnRecuperar)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tbUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "CUI", "Usuario", "Password", "Tipo", "Estado", "Salario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbUsuarios);

        jLabel6.setText("Listado de Usuarios (Seleccione uno)");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRecuperarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecuperarActionPerformed
        // TODO add your handling code here:
        if (txtUser.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,RECUPERAR_USUARIO, ERROR_RECUP, JOptionPane.ERROR_MESSAGE);
        } else {    
                    user= new Usuario(txtUser.getText());
                    controladorUser= new ControladorUsuarios(user, this);
                    controladorUser.consultarUsuario();
            
            }
    }//GEN-LAST:event_btnRecuperarActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        // TODO add your handling code here:
            if (txtCUI.getText().isEmpty()||txtNombre.getText().isEmpty()||
                    txtPass.getText().isEmpty()||txtUser.getText().isEmpty()||txtSalario.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, CAMPOS_OBLIGATORIOS,ERROR_CREACION, JOptionPane.ERROR_MESSAGE);
            } else {
                        int opcion= JOptionPane.showConfirmDialog(this, GUARDAR_DATOS);
                        if (opcion==0) {
                                user= new Usuario(txtUser.getText(), txtPass.getText(), txtNombre.getText(),txtCUI.getText()
                                        ,(String)comboTipo.getSelectedItem(), (String)comboEstado.getSelectedItem(),Double.parseDouble(txtSalario.getText()));
                                controladorUser= new ControladorUsuarios(user, this);
                                controladorUser.registrarUsuario();

                        }
                        if(opcion==1){
                                limpiarCampos();
                                deshabilitarBotones();
                        }
                }
    }//GEN-LAST:event_btnCrearActionPerformed

    private void tbUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUsuariosMouseClicked
        // TODO add your handling code here:
            habilitarBotones();
            DefaultTableModel model =(DefaultTableModel)tbUsuarios.getModel();
            
            if(tbUsuarios.getSelectedRow()!=-1){//si se ha seleccionado algo en la tabla se rellenan los campo
                    txtNombre.setText(model.getValueAt(tbUsuarios.getSelectedRow(), 0).toString());
                    txtCUI.setText(model.getValueAt(tbUsuarios.getSelectedRow(), 1).toString());
                    txtUser.setText(model.getValueAt(tbUsuarios.getSelectedRow(), 2).toString());
                    txtPass.setText(model.getValueAt(tbUsuarios.getSelectedRow(), 3).toString());
                    comboTipo.setSelectedItem(model.getValueAt(tbUsuarios.getSelectedRow(), 4));
                    comboEstado.setSelectedItem(model.getValueAt(tbUsuarios.getSelectedRow(), 5));
                    txtSalario.setText(model.getValueAt(tbUsuarios.getSelectedRow(), 6).toString());
                    
                    //almacenamos el usuario temporal seleccionado
                    userTemp=model.getValueAt(tbUsuarios.getSelectedRow(), 2).toString();
                    
            }
    }//GEN-LAST:event_tbUsuariosMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
            if (txtCUI.getText().isEmpty()||txtNombre.getText().isEmpty()||
                    txtPass.getText().isEmpty()||txtUser.getText().isEmpty()||txtSalario.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, CAMPOS_OBLIGATORIOS, ERROR_ACTUALIZACION, JOptionPane.ERROR_MESSAGE);
            } else {
                        int opcion= JOptionPane.showConfirmDialog(this, CAMBIAR_DATOS);
                        if (opcion==0) {
                                user= new Usuario(txtUser.getText(), txtPass.getText(), txtNombre.getText(),txtCUI.getText()
                                        ,(String)comboTipo.getSelectedItem(), (String)comboEstado.getSelectedItem(),Double.parseDouble(txtSalario.getText()));
                                controladorUser= new ControladorUsuarios(user, this);
                                controladorUser.actualizarUsuario();

                        }
                        if(opcion==1){
                                limpiarCampos();
                                deshabilitarBotones();
                        }
                }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
            if (txtUser.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, ELIMINAR_USUARIO, ERROR_ELIMINACION, JOptionPane.ERROR_MESSAGE);
            } else {    
                        int opcion= JOptionPane.showConfirmDialog(this, ELIMINAR_DATOS_USUARIO+userTemp+"?");
                        if (opcion==0) {
                                user= new Usuario(userTemp);
                                controladorUser= new ControladorUsuarios(user,this);
                                controladorUser.eliminarUsuario();
                        }
                        if(opcion==1){
                                limpiarCampos();
                                deshabilitarBotones();
                        }
                        

                }
            
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
            limpiarCampos();
            deshabilitarBotones();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarActionPerformed
        // TODO add your handling code here:
            if (txtUser.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Seleccione primero un Usuario\n en la tabla de abajo", ERROR_RECUP, JOptionPane.ERROR_MESSAGE);
            } else {
                    String cargo=(String)comboTipo.getSelectedItem();
                    if (cargo.equalsIgnoreCase(TIPO_2)||cargo.equalsIgnoreCase(TIPO_4)) {
                            asignacionHotel= new AsignacionHotel(ventanaprincipal,txtUser.getText(),cargo);
                            asignacionHotel.setVisible(true);
                    } else if (cargo.equalsIgnoreCase(TIPO_3) || cargo.equalsIgnoreCase(TIPO_5)) {
                                    asignacionRestaurante= new AsignacionRestaurante(ventanaprincipal,txtUser.getText(),cargo);
                                    asignacionRestaurante.setVisible(true);
                            } else {
                                        JOptionPane.showMessageDialog(null, "Un Gerente General no puede asignarse a un solo establecimiento", ERROR_RECUP, JOptionPane.ERROR_MESSAGE);
                                }
                }
            
            
    }//GEN-LAST:event_btnAsignarActionPerformed
    public void cargarTablaUsuarios(){
            controladorUser= new ControladorUsuarios();
            List<Usuario> lista= controladorUser.recuperarUsuarios();
            DefaultTableModel model= (DefaultTableModel)this.tbUsuarios.getModel();
            for(Usuario usuario: lista){
                    model.addRow(new Object[]{usuario.getNombre(),usuario.getCui(),
                    usuario.getUser(),usuario.getPass(),usuario.getTipo(),usuario.getEstado(),usuario.getSlario()});
            }                        
    }
    public void agregarUsuarioEnTabla(Usuario usuario){
            DefaultTableModel model= (DefaultTableModel)this.tbUsuarios.getModel();        
            model.addRow(new Object[]{usuario.getNombre(),usuario.getCui(),
                usuario.getUser(),usuario.getPass(),usuario.getTipo(),usuario.getEstado(),usuario.getSlario()});
                              
    }
    public void eliminarUsuarioEnTabla(){
            DefaultTableModel model=(DefaultTableModel)tbUsuarios.getModel();
            model.removeRow(tbUsuarios.getSelectedRow());
    }
    public void actualizarUsuarioEnTabla(){
            DefaultTableModel model=(DefaultTableModel)tbUsuarios.getModel();
            //Actualizando Tabla Clientes
            model.setValueAt(txtNombre.getText(), tbUsuarios.getSelectedRow(),0);
            model.setValueAt(txtCUI.getText(), tbUsuarios.getSelectedRow(),1);
            model.setValueAt(txtUser.getText(), tbUsuarios.getSelectedRow(),2);
            model.setValueAt(txtPass.getText(), tbUsuarios.getSelectedRow(),3);
            model.setValueAt(comboTipo.getSelectedItem(), tbUsuarios.getSelectedRow(), 4);
            model.setValueAt(comboEstado.getSelectedItem(), tbUsuarios.getSelectedRow(), 5);
            model.setValueAt(txtSalario.getText(), tbUsuarios.getSelectedRow(),6);
                              
    }
    public void limpiarCampos(){
            txtCUI.setText("");
            txtNombre.setText("");
            txtPass.setText("");
            txtUser.setText("");
            comboEstado.setSelectedIndex(0);
            comboTipo.setSelectedIndex(0);
    } 
    public void organizarFormulario(){
            limpiarCampos();
            deshabilitarBotones();
    }
    public void rellenarCampos(Usuario user){
            txtCUI.setText(user.getCui());
            txtNombre.setText(user.getNombre());
            txtPass.setText(user.getPass());
            txtUser.setText(user.getUser());
            comboEstado.setSelectedItem(user.getEstado());
            comboTipo.setSelectedItem(user.getTipo());
            txtSalario.setText(""+user.getSlario());
    }
    public void deshabilitarBotones(){
            btnActualizar.setEnabled(false);
            btnEliminar.setEnabled(false);
            
    } 
    public void habilitarBotones(){
            btnActualizar.setEnabled(true);
            btnEliminar.setEnabled(true);
    } 
    public String retornarUserTemporal(){
            return userTemp;
    }
    private AsignacionHotel asignacionHotel;
    private AsignacionRestaurante asignacionRestaurante;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAsignar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRecuperar;
    private javax.swing.JComboBox<String> comboEstado;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbUsuarios;
    private javax.swing.JFormattedTextField txtCUI;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPass;
    private javax.swing.JFormattedTextField txtSalario;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
