/*
 * Frame de Asignacion de Proyectos
 */
package sistemacasos.ui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import sistemacasos.backend.proyects.ControladorProyectos;
import sistemacasos.backend.proyects.Proyecto;
import static sistemacasos.backend.proyects.Proyecto.ESTADO_ACTIVO;
import static sistemacasos.backend.proyects.Proyecto.ESTADO_NO_ACTIVO;
import sistemacasos.backend.user.ControladorEmpleados;
import sistemacasos.backend.user.Empleado;
import static sistemacasos.backend.user.Empleado.ESTADO_ASIGNADO;
import static sistemacasos.ui.FormNuevoEmpleado.CLEAR_CAMPO;
import static sistemacasos.ui.FormNuevoEmpleado.CONFIRM_DATOS;
import static sistemacasos.ui.FormNuevoEmpleado.CONF_CANCEL;
import static sistemacasos.ui.FormNuevoEmpleado.CONF_NO;
import static sistemacasos.ui.FormNuevoEmpleado.CONF_SI;
import static sistemacasos.ui.FormNuevoEmpleado.VAL_CAMPOS;
import static sistemacasos.ui.LoginUsuario.TIPO_2;

/**
 *
 * @author bryan
 */
public class JInFrameAsigancionProyectos extends javax.swing.JInternalFrame {

    /**
     * Creates new form JInFrameAsigancionProyectos
     */
        private List<Empleado> listadoAdministradores;
	private ObservableList<Empleado> listadoAdministradoresObservable;
        private List<Proyecto> listadoProyectos;
	private ObservableList<Proyecto> listadoProyectosObservable;
	private Empleado administradorSeleccionado;
        private Proyecto proyectoSeleccionado;
        
        public JInFrameAsigancionProyectos() {
                this.listadoAdministradores = new ArrayList<>();
                this.listadoProyectos = new ArrayList<>();
		this.listadoAdministradoresObservable = ObservableCollections.observableList(listadoAdministradores);
                this.listadoProyectosObservable = ObservableCollections.observableList(listadoProyectos);
		this.administradorSeleccionado = new Empleado();
                this.proyectoSeleccionado= new Proyecto();
                this.cargarTablas();
                initComponents();
        }
        //metodo para actualizar lista observable de empleados
        public void actualizarListadoObservable(List<Empleado> listadoAdministradores,List<Proyecto> listadoProyectos){
                this.listadoAdministradoresObservable.clear();//se limpia la lista
		this.listadoAdministradoresObservable.addAll(listadoAdministradores); //se agreaga a la lista observable
                this.listadoProyectosObservable.clear();//se limpia la lista2
		this.listadoProyectosObservable.addAll(listadoProyectos); //se agreaga a la lista observable2
        }
        //metodo para cargar la tbla de empleados
        public void cargarTablas(){
                ControladorEmpleados empleados= new ControladorEmpleados();
                ControladorProyectos proyectos= new ControladorProyectos();
                actualizarListadoObservable(empleados.consultarEmpleadosAdminProyectos(ESTADO_ASIGNADO, TIPO_2),proyectos.consultarProyectos(ESTADO_NO_ACTIVO));
        }
        private void resetCampos(){
                txtProyecto.setText(CLEAR_CAMPO);
                txtTipoProyecto.setText(CLEAR_CAMPO);
                txtAdminProyecto.setText(CLEAR_CAMPO);
                txtCuiAdmin.setText(CLEAR_CAMPO);
                
        }
        //Metodos accesores

        public List<Empleado> getListadoAdministradores() {
                return listadoAdministradores;
        }

        public void setListadoAdministradores(List<Empleado> listadoAdministradores) {
                this.listadoAdministradores = listadoAdministradores;
        }

        public ObservableList<Empleado> getListadoAdministradoresObservable() {
                return listadoAdministradoresObservable;
        }

        public void setListadoAdministradoresObservable(ObservableList<Empleado> listadoAdministradoresObservable) {
                this.listadoAdministradoresObservable = listadoAdministradoresObservable;
        }

        public List<Proyecto> getListadoProyectos() {
                return listadoProyectos;
        }

        public void setListadoProyectos(List<Proyecto> listadoProyectos) {
                this.listadoProyectos = listadoProyectos;
        }

        public ObservableList<Proyecto> getListadoProyectosObservable() {
                return listadoProyectosObservable;
        }

        public void setListadoProyectosObservable(ObservableList<Proyecto> listadoProyectosObservable) {
                this.listadoProyectosObservable = listadoProyectosObservable;
        }

        public Empleado getAdministradorSeleccionado() {
                return administradorSeleccionado;
        }

        public void setAdministradorSeleccionado(Empleado administradorSeleccionado) {
                Empleado anterior = this.administradorSeleccionado;
                if (administradorSeleccionado != null) {
                        this.administradorSeleccionado = administradorSeleccionado.clone();
                }
                firePropertyChange("administradorSeleccionado", anterior, this.administradorSeleccionado);
        }

        public Proyecto getProyectoSeleccionado() {
            return proyectoSeleccionado;
        }

        public void setProyectoSeleccionado(Proyecto proyectoSeleccionado) {
                Proyecto anterior = this.proyectoSeleccionado;
                if (proyectoSeleccionado != null) {
                        this.proyectoSeleccionado = proyectoSeleccionado.clone();
                }
                firePropertyChange("proyectoSeleccionado", anterior, this.proyectoSeleccionado);
        }
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtProyecto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtTipoProyecto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtAdminProyecto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCuiAdmin = new javax.swing.JTextField();
        btnGuardarAsignacion = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProyectos = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbAdministradores = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Asignacion de Proyectos");

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setText("Nombre de Proyecto:");

        txtProyecto.setEditable(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${proyectoSeleccionado.nombre}"), txtProyecto, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel1.setText("Tipo:");

        txtTipoProyecto.setEditable(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${proyectoSeleccionado.tipo}"), txtTipoProyecto, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel2.setText("Admin. de Proyecto:");

        txtAdminProyecto.setEditable(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${administradorSeleccionado.nombre}"), txtAdminProyecto, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel3.setText("CUI:");

        txtCuiAdmin.setEditable(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${administradorSeleccionado.CUI}"), txtCuiAdmin, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        btnGuardarAsignacion.setText("Guardar Asignacion");
        btnGuardarAsignacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarAsignacionActionPerformed(evt);
            }
        });

        jLabel7.setText("ID de Proyecto: ");

        txtID.setEditable(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${proyectoSeleccionado.id}"), txtID, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAdminProyecto)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCuiAdmin)
                            .addComponent(txtTipoProyecto)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardarAsignacion)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtTipoProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAdminProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtCuiAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarAsignacion)
                    .addComponent(jLabel7)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setText("Proyectos Disponibles (Seleccione uno)");

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listadoProyectosObservable}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, tbProyectos);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombre}"));
        columnBinding.setColumnName("Nombre");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tipo}"));
        columnBinding.setColumnName("Tipo");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fechaCreacion}"));
        columnBinding.setColumnName("Fecha Creacion");
        columnBinding.setColumnClass(java.time.LocalDate.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${estado}"));
        columnBinding.setColumnName("Estado");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${proyectoSeleccionado}"), tbProyectos, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        jScrollPane1.setViewportView(tbProyectos);

        jLabel6.setText("Administradores de Proyecto (Seleccione uno)");

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listadoAdministradoresObservable}");
        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, tbAdministradores);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${CUI}"));
        columnBinding.setColumnName("CUI");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombre}"));
        columnBinding.setColumnName("Nombre");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tipo}"));
        columnBinding.setColumnName("Tipo");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${edad}"));
        columnBinding.setColumnName("Edad");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${especialidad}"));
        columnBinding.setColumnName("Especialidad");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${administradorSeleccionado}"), tbAdministradores, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        jScrollPane2.setViewportView(tbAdministradores);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(0, 327, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarAsignacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarAsignacionActionPerformed
        // TODO add your handling code here:
            if (txtProyecto.getText().isEmpty()||txtAdminProyecto.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, VAL_CAMPOS,"Error",JOptionPane.ERROR_MESSAGE);
            }else{
                    //se confirman los datos y se procede a guardarlos
                    int confirmar = JOptionPane.showConfirmDialog(null, CONFIRM_DATOS);
                    if (confirmar==CONF_SI) {// si se confirman los datos
                            // se actualiza el proyecto con su administrador
                            ControladorProyectos controlador= new ControladorProyectos();
                            controlador.actualizarEstadoProyecto(txtCuiAdmin.getText(), ESTADO_ACTIVO,Integer.parseInt(txtID.getText()));
                            resetCampos();
                            this.cargarTablas();
                            
                    }
                    if (confirmar==CONF_NO) {
                        //los campos siguen igual
                    }
                    if (confirmar==CONF_CANCEL) {
                            resetCampos();// se restean los campos
                    }
            }
    }//GEN-LAST:event_btnGuardarAsignacionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarAsignacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbAdministradores;
    private javax.swing.JTable tbProyectos;
    private javax.swing.JTextField txtAdminProyecto;
    private javax.swing.JTextField txtCuiAdmin;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtProyecto;
    private javax.swing.JTextField txtTipoProyecto;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
