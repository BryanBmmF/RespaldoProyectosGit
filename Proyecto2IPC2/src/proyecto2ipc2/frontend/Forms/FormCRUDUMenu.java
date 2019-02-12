/*
 * 
 */
package proyecto2ipc2.frontend.Forms;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import proyecto2ipc2.backend.Restaurante.ControladorMenus;
import proyecto2ipc2.backend.Restaurante.Menu;
import proyecto2ipc2.backend.Restaurante.Restaurante;
import proyecto2ipc2.backend.User.Logger;
import static proyecto2ipc2.database.OperadorEsquema.CAMBIAR_DATOS;
import static proyecto2ipc2.database.OperadorEsquema.CAMPOS_OBLIGATORIOS;
import static proyecto2ipc2.database.OperadorEsquema.ELIMINACION;
import static proyecto2ipc2.database.OperadorEsquema.ERROR_ACTUALIZACION;
import static proyecto2ipc2.database.OperadorEsquema.ERROR_CREACION;
import static proyecto2ipc2.database.OperadorEsquema.ERROR_RECUP;
import static proyecto2ipc2.database.OperadorEsquema.GUARDAR_DATOS;
import proyecto2ipc2.frontend.JFramePrincipal;

/**
 *
 * @author bryan
 */
public class FormCRUDUMenu extends javax.swing.JInternalFrame {

    /**
     * Creates new form FormCRUDUser
     */
    private ControladorMenus controladorMenus;
    public static final String RECUPERAR_MENU="Para recuperar los datos de un Menu\n se debe especificar el Numero";
    public static final String ELIMINAR_MENU="Para recuperar los datos de un Menu\n se debe especificar el Numero";
    public static final String ELIMINAR_DATOS_MENU="Esta seguro de Eliminar al Menu ";
    
    private Menu menu;
    private int idMenu;
    private int idRestaurante;
    private JFramePrincipal frame;
    public FormCRUDUMenu(JFramePrincipal frame) {
            this.frame=frame;
            this.idMenu=0;
            this.idRestaurante=0;
            initComponents();
            this.deshabilitarBotones();
            this.cargarComboRestaurantes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        comboTipo = new javax.swing.JComboBox<>();
        btnCrear = new javax.swing.JButton();
        btnRecuperar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        txtCosto = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        txtPrecio = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        comboRestaurantes = new javax.swing.JComboBox<>();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel9 = new javax.swing.JLabel();
        txtIdRestaurante = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMenus = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gestion de Menus");

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Nombre:*");

        jLabel2.setText("Descripcion:*");

        jLabel3.setText("Tipo:*");

        jLabel4.setText("Precio de Venta:* Q.");

        jLabel5.setText("Numero:");

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bebida", "Comida " }));

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

        btnLimpiar.setText("Limpiar Campos");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        txtCosto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        txtPrecio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        jLabel7.setText("Costo de Fab:     * Q.");

        jLabel8.setText("Restaurante:");

        comboRestaurantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboRestaurantesActionPerformed(evt);
            }
        });

        jToggleButton1.setText("Todos los Restaurantes");

        jLabel9.setText("ID:");

        txtIdRestaurante.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5))
                                .addGap(33, 33, 33))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                                        .addComponent(jScrollPane2))
                                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jToggleButton1))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(66, 66, 66)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel7)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCosto)
                                            .addComponent(txtPrecio)
                                            .addComponent(comboTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
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
                                .addGap(0, 87, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtIdRestaurante, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(comboRestaurantes, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(comboRestaurantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtIdRestaurante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrear)
                    .addComponent(btnRecuperar)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar))
                .addGap(11, 11, 11))
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tbMenus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero", "Tipo", "Nombre", "Descripcion", "Precio", "Costo de Fab"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbMenus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMenusMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbMenus);

        jLabel6.setText("Listado de Menus (Seleccione uno)");

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRecuperarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecuperarActionPerformed
        // TODO add your handling code here:
        if (txtNumero.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, RECUPERAR_MENU, ERROR_RECUP, JOptionPane.ERROR_MESSAGE);
        } else {    
                    menu= new Menu(Integer.parseInt(txtNumero.getText()),Integer.parseInt(txtIdRestaurante.getText()));
                    
                    controladorMenus= new ControladorMenus(menu, this);
                    controladorMenus.consultarMenu();
            
            }
    }//GEN-LAST:event_btnRecuperarActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        // TODO add your handling code here:
            if (txtCosto.getText().isEmpty()||txtNombre.getText().isEmpty()||txtDescripcion.getText().isEmpty()
                    ||txtNumero.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, CAMPOS_OBLIGATORIOS, ERROR_CREACION, JOptionPane.ERROR_MESSAGE);
            } else {    
                        int opcion= JOptionPane.showConfirmDialog(this, GUARDAR_DATOS);
                        if (opcion==0) {
                                menu= new Menu(Integer.parseInt(txtNumero.getText()),(String)comboTipo.getSelectedItem(), txtNombre.getText(),txtDescripcion.getText()
                                        ,Double.parseDouble(txtPrecio.getText()),Double.parseDouble(txtCosto.getText()),Integer.parseInt(txtIdRestaurante.getText()),0);
                                controladorMenus= new ControladorMenus(menu, this);
                                controladorMenus.registrarMenu();

                        }
                        if(opcion==1){
                                limpiarCampos();
                                deshabilitarBotones();
                        }
                        
                }
    }//GEN-LAST:event_btnCrearActionPerformed

    private void tbMenusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMenusMouseClicked
        // TODO add your handling code here:
            habilitarBotones();
            DefaultTableModel model =(DefaultTableModel)tbMenus.getModel();
            
            if(tbMenus.getSelectedRow()!=-1){//si se ha seleccionado algo en la tabla se rellenan los campo
                    txtNumero.setText(model.getValueAt(tbMenus.getSelectedRow(), 0).toString());
                    comboTipo.setSelectedItem(model.getValueAt(tbMenus.getSelectedRow(), 1));
                    txtNombre.setText(model.getValueAt(tbMenus.getSelectedRow(), 2).toString());
                    txtDescripcion.setText(model.getValueAt(tbMenus.getSelectedRow(), 3).toString());
                    txtPrecio.setText(model.getValueAt(tbMenus.getSelectedRow(), 4).toString());
                    txtCosto.setText(model.getValueAt(tbMenus.getSelectedRow(), 5).toString());
                                       
                    //almacenamos el idMenu temporal seleccionado y el Id
                    idMenu= Integer.parseInt(model.getValueAt(tbMenus.getSelectedRow(), 0).toString());
                    
            }
    }//GEN-LAST:event_tbMenusMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
            if (txtCosto.getText().isEmpty()||txtNombre.getText().isEmpty()||
                    txtNumero.getText().isEmpty()||txtDescripcion.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,CAMPOS_OBLIGATORIOS, ERROR_ACTUALIZACION, JOptionPane.ERROR_MESSAGE);
            } else {
                        int opcion= JOptionPane.showConfirmDialog(this, CAMBIAR_DATOS);
                        if (opcion==0) {
                               menu= new Menu(Integer.parseInt(txtNumero.getText()),(String)comboTipo.getSelectedItem(), txtNombre.getText(),txtDescripcion.getText()
                                                ,Double.parseDouble(txtPrecio.getText()),Double.parseDouble(txtCosto.getText()),Integer.parseInt(txtIdRestaurante.getText()),0);
                                controladorMenus= new ControladorMenus(menu, this);
                                controladorMenus.actualizarMenu();

                        }
                        if(opcion==1){
                                limpiarCampos();
                                deshabilitarBotones();
                        }
                }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
            if (txtNumero.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, ELIMINAR_MENU, ELIMINACION, JOptionPane.ERROR_MESSAGE);
            } else {    
                        int opcion= JOptionPane.showConfirmDialog(this, ELIMINAR_DATOS_MENU+idMenu+"?");
                        if (opcion==0) {
                                menu= new Menu(idMenu,Integer.parseInt(txtIdRestaurante.getText()));
                                controladorMenus= new ControladorMenus(menu, this);
                                controladorMenus.eliminarMenu();
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

    private void comboRestaurantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboRestaurantesActionPerformed
        // TODO add your handling code here:
            controladorMenus= new ControladorMenus();
            
            Logger logger = Logger.getInstance();
            if (logger.getEstablecimiento()!=null) {
                    txtIdRestaurante.setText(""+logger.getIdEstablecimiento());
                    cargarTablaMenus();
                    deshabilitarComboRestaurantes();              
            } else {
                        txtIdRestaurante.setText(""+controladorMenus.recuperarRestaurante((String)comboRestaurantes.getSelectedItem()));
                        cargarTablaMenus();
            }
    }//GEN-LAST:event_comboRestaurantesActionPerformed
    public void cargarTablaMenus(){
            limpiarTabla();
            controladorMenus= new ControladorMenus();
            List<Menu> lista= controladorMenus.recuperarMenus(Integer.parseInt(txtIdRestaurante.getText()));
            DefaultTableModel model= (DefaultTableModel)this.tbMenus.getModel();
            for(Menu menu: lista){
                    model.addRow(new Object[]{menu.getNumero(),menu.getTipo(),
                    menu.getNombre(),menu.getDescripcion(),menu.getPrecio(),menu.getCostoFabricacion()});
            }                        
    }
    public void limpiarTabla(){
            DefaultTableModel tb = (DefaultTableModel)tbMenus.getModel();
            int a = tbMenus.getRowCount()-1;
            for (int i = a; i >= 0; i--) {          
                    tb.removeRow(tb.getRowCount()-1);
            }
    }
    public void cargarComboRestaurantes(){
            controladorMenus= new ControladorMenus();
            List<Restaurante> lista= controladorMenus.recuperarRestaurantes();
            DefaultComboBoxModel modelComboRestaurantes=(DefaultComboBoxModel)comboRestaurantes.getModel();
            for(Restaurante restaurante: lista){
                modelComboRestaurantes.addElement(restaurante.getNombre());
            }   AutoCompleteDecorator.decorate(comboRestaurantes);
    }
    public void agregarMenuEnTabla(Menu menu){
            DefaultTableModel model= (DefaultTableModel)this.tbMenus.getModel();        
            model.addRow(new Object[]{menu.getNumero(),menu.getTipo(),
                    menu.getNombre(),menu.getDescripcion(),menu.getPrecio(),menu.getCostoFabricacion()});
                              
    }
    public void eliminarMenuEnTabla(){
            DefaultTableModel model=(DefaultTableModel)tbMenus.getModel();
            model.removeRow(tbMenus.getSelectedRow());
    }
    public void actualizarMenuEnTabla(){
            DefaultTableModel model=(DefaultTableModel)tbMenus.getModel();
            //Actualizando Tabla Clientes
            model.setValueAt(txtNumero.getText(), tbMenus.getSelectedRow(),0);
            model.setValueAt(comboTipo.getSelectedItem(), tbMenus.getSelectedRow(), 1);
            model.setValueAt(txtNombre.getText(), tbMenus.getSelectedRow(),2);
            model.setValueAt(txtDescripcion.getText(), tbMenus.getSelectedRow(),3);
            model.setValueAt(txtPrecio.getText(), tbMenus.getSelectedRow(),4);
            model.setValueAt(txtCosto.getText(), tbMenus.getSelectedRow(),5);
           
            
    }
    public void limpiarCampos(){
            txtPrecio.setText("");
            txtCosto.setText("");
            txtNombre.setText("");
            txtNumero.setText("");
            txtDescripcion.setText("");
            comboTipo.setSelectedIndex(0);
            comboRestaurantes.setSelectedIndex(0);
    } 
    public void organizarFormulario(){
            limpiarCampos();
            deshabilitarBotones();
    }
    public void rellenarCampos(Menu menu){
            txtPrecio.setText(String.valueOf(menu.getPrecio()));
            txtCosto.setText(String.valueOf(menu.getCostoFabricacion()));
            txtNombre.setText(menu.getNombre());
            txtNumero.setText(String.valueOf(menu.getNumero()));
            txtDescripcion.setText(menu.getDescripcion());
            comboTipo.setSelectedItem(menu.getTipo());
    }
    public void seleccionarRestaurante(String restaurante){
            comboRestaurantes.setSelectedItem(restaurante);
    }
    public void deshabilitarBotones(){
            btnActualizar.setEnabled(false);
            btnEliminar.setEnabled(false);
            
    } 
     public void deshabilitarComboRestaurantes(){
            comboRestaurantes.setEnabled(false);
    }
    public void habilitarBotones(){
            btnActualizar.setEnabled(true);
            btnEliminar.setEnabled(true);
    } 
    public int retornarIdMenuTemporal(){
            return idMenu;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRecuperar;
    private javax.swing.JComboBox<String> comboRestaurantes;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTable tbMenus;
    private javax.swing.JFormattedTextField txtCosto;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtIdRestaurante;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JFormattedTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
