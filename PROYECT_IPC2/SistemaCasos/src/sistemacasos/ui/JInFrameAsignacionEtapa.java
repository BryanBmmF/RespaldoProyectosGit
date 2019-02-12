/*
 * 
 */
package sistemacasos.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import sistemacasos.backend.cases.Caso;
import sistemacasos.backend.cases.ControladorCasos;
import sistemacasos.backend.cases.RegistroCaso;
import sistemacasos.backend.cases.RegistroEtapa;
import sistemacasos.backend.proyects.ControladorProyectos;
import sistemacasos.backend.user.ControladorEmpleados;
import sistemacasos.backend.user.Empleado;
import static sistemacasos.backend.user.Empleado.ESTADO_ASIGNADO;
import static sistemacasos.ui.FormNuevoEmpleado.CLEAR_CAMPO;
import static sistemacasos.ui.FormNuevoEmpleado.CONFIRM_DATOS;
import static sistemacasos.ui.FormNuevoEmpleado.CONF_CANCEL;
import static sistemacasos.ui.FormNuevoEmpleado.CONF_NO;
import static sistemacasos.ui.FormNuevoEmpleado.CONF_SI;
import static sistemacasos.ui.FormNuevoEmpleado.VAL_CAMPOS;
import static sistemacasos.ui.JFramePrincipal.devolverUser;
import static sistemacasos.ui.LoginUsuario.TIPO_3;

/**
 *
 * @author bryan
 */
public class JInFrameAsignacionEtapa extends javax.swing.JInternalFrame {
        
        private List<Empleado> listadoDesarrolladores;
	private ObservableList<Empleado> listadoDesarrolladoresObservable;
        private List<RegistroCaso> listadoCasos;
	private ObservableList<RegistroCaso> listadoCasosObservable;
        private List<Caso> listadoTiposCasos;
	private ObservableList<Caso> listadoTiposCasosObservable;
	private Empleado desarrolladorSeleccionado;
        private RegistroCaso casoSeleccionado;
        private Caso tipoCasoSeleccionado;
        /**
         * Creates new form JInFrameAsignacionEtapa
         */
        public JInFrameAsignacionEtapa() {
                this.listadoDesarrolladores = new ArrayList<>();
                this.listadoCasos = new ArrayList<>();
                this.listadoTiposCasos = new ArrayList<>();
		this.listadoDesarrolladoresObservable = ObservableCollections.observableList(listadoDesarrolladores);
                this.listadoCasosObservable = ObservableCollections.observableList(listadoCasos);
                this.listadoTiposCasosObservable = ObservableCollections.observableList(listadoTiposCasos);
		this.desarrolladorSeleccionado = new Empleado();
                this.casoSeleccionado= new RegistroCaso();
                this.tipoCasoSeleccionado= new Caso();
                this.cargarTablas();
                initComponents();
                this.txtFecha.setText(JFramePrincipal.fechaActualDelSistema());
        }
        //metodo para actualizar lista observable de empleados
        public void actualizarListadoObservable(List<Empleado> listadoDesarrolladores,List<RegistroCaso> listadoCasos,List<Caso> listadoTipoCasos){
                this.listadoDesarrolladoresObservable.clear();//se limpia la lista
		this.listadoDesarrolladoresObservable.addAll(listadoDesarrolladores); //se agreaga a la lista observable
                this.listadoCasosObservable.clear();//se limpia la lista2
		this.listadoCasosObservable.addAll(listadoCasos); //se agreaga a la lista observable2
                this.listadoTiposCasosObservable.clear();//se limpia la lista
		this.listadoTiposCasosObservable.addAll(listadoTipoCasos); //se agreaga a la lista observable
        }
        //metodo para cargar la tbla de empleados
        public void cargarTablas(){
                ControladorEmpleados empleados= new ControladorEmpleados();
                ControladorProyectos proyectos= new ControladorProyectos();
                ControladorCasos casos= new ControladorCasos();
                actualizarListadoObservable(empleados.consultarEmpleadosAdminProyectos(ESTADO_ASIGNADO, TIPO_3),casos.consultarCasos(devolverUser()),casos.consultarTiposCaso());
        }
        private void resetCampos(){
                txtCui.setText(CLEAR_CAMPO);
                txtDesarrollador.setText(CLEAR_CAMPO);
                txtNombreCaso.setText(CLEAR_CAMPO);
                txtNombreEtapa.setText(CLEAR_CAMPO);
                txtNumeroEtapa.setText(CLEAR_CAMPO);
                txtPago.setText(CLEAR_CAMPO);
                txtTipoCaso.setText(CLEAR_CAMPO);
                
        }

        public List<Empleado> getListadoDesarrolladores() {
            return listadoDesarrolladores;
        }

        public void setListadoDesarrolladores(List<Empleado> listadoDesarrolladores) {
            this.listadoDesarrolladores = listadoDesarrolladores;
        }

        public ObservableList<Empleado> getListadoDesarrolladoresObservable() {
            return listadoDesarrolladoresObservable;
        }

        public void setListadoDesarrolladoresObservable(ObservableList<Empleado> listadoDesarrolladoresObservable) {
            this.listadoDesarrolladoresObservable = listadoDesarrolladoresObservable;
        }

        public List<RegistroCaso> getListadoCasos() {
            return listadoCasos;
        }

        public void setListadoCasos(List<RegistroCaso> listadoCasos) {
            this.listadoCasos = listadoCasos;
        }

        public ObservableList<RegistroCaso> getListadoCasosObservable() {
            return listadoCasosObservable;
        }

        public void setListadoCasosObservable(ObservableList<RegistroCaso> listadoCasosObservable) {
            this.listadoCasosObservable = listadoCasosObservable;
        }

        public List<Caso> getListadoTiposCasos() {
            return listadoTiposCasos;
        }

        public void setListadoTiposCasos(List<Caso> listadoTiposCasos) {
            this.listadoTiposCasos = listadoTiposCasos;
        }

        public ObservableList<Caso> getListadoTiposCasosObservable() {
            return listadoTiposCasosObservable;
        }

        public void setListadoTiposCasosObservable(ObservableList<Caso> listadoTiposCasosObservable) {
            this.listadoTiposCasosObservable = listadoTiposCasosObservable;
        }


        public Empleado getDesarrolladorSeleccionado() {
            return desarrolladorSeleccionado;
        }

        public void setDesarrolladorSeleccionado(Empleado desarrolladorSeleccionado) {
                Empleado anterior = this.desarrolladorSeleccionado;
                if (desarrolladorSeleccionado != null) {
                        this.desarrolladorSeleccionado = desarrolladorSeleccionado.clone();
                }
                firePropertyChange("desarrolladorSeleccionado", anterior, this.desarrolladorSeleccionado);
        }

        public RegistroCaso getCasoSeleccionado() {
            return casoSeleccionado;
        }

        public void setCasoSeleccionado(RegistroCaso casoSeleccionado) {
                RegistroCaso anterior = this.casoSeleccionado;
                if (casoSeleccionado != null) {
                        this.casoSeleccionado = casoSeleccionado.clone();
                }
                firePropertyChange("casoSeleccionado", anterior, this.casoSeleccionado);
        }

        public Caso getTipoCasoSeleccionado() {
            return tipoCasoSeleccionado;
        }

        public void setTipoCasoSeleccionado(Caso tipoCasoSeleccionado) {
                Caso anterior = this.tipoCasoSeleccionado;
                if (tipoCasoSeleccionado != null) {
                        this.tipoCasoSeleccionado = tipoCasoSeleccionado.clone();
                }
                firePropertyChange("tipoCasoSeleccionado", anterior, this.tipoCasoSeleccionado);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreEtapa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtIdProyecto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNombreCaso = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTipoCaso = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDesarrollador = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCui = new javax.swing.JTextField();
        txtPago = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNumeroEtapa = new javax.swing.JTextField();
        btnAsignarEtapa = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbTipoEtapa = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbCasos = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbDesarrolladores = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Asignacion de Etapas");

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Nombre Etapa:");

        txtNombreEtapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreEtapaActionPerformed(evt);
            }
        });

        jLabel2.setText("ID Proyecto:");

        txtIdProyecto.setEditable(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${casoSeleccionado.idProyecto}"), txtIdProyecto, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel3.setText("Nombre Caso:");

        txtNombreCaso.setEditable(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${casoSeleccionado.nombre}"), txtNombreCaso, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel4.setText("Tipo Caso:");

        txtTipoCaso.setEditable(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${casoSeleccionado.tipoCaso}"), txtTipoCaso, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel5.setText("Pago/Hora:     Q.");

        jLabel6.setText("Desarrollador:");

        txtDesarrollador.setEditable(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${desarrolladorSeleccionado.nombre}"), txtDesarrollador, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel7.setText("CUI :");

        txtCui.setEditable(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${desarrolladorSeleccionado.CUI}"), txtCui, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel8.setText("No. Etapa:");

        btnAsignarEtapa.setText("Asignar Etapa");
        btnAsignarEtapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarEtapaActionPerformed(evt);
            }
        });

        jLabel11.setText("Fecha Registro:");

        txtFecha.setEditable(false);

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listadoTiposCasos}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, tbTipoEtapa);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tipo}"));
        columnBinding.setColumnName("Tipo de Caso");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${numeroEtapas}"));
        columnBinding.setColumnName("Numero de Pasos");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${tipoCasoSeleccionado}"), tbTipoEtapa, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        jScrollPane4.setViewportView(tbTipoEtapa);

        jLabel12.setText("(Numero de Etapas Correspondientes de cada Caso)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDesarrollador, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                            .addComponent(txtNombreEtapa)
                            .addComponent(txtNombreCaso)
                            .addComponent(txtPago))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCui)
                                    .addComponent(txtTipoCaso)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIdProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(txtNumeroEtapa))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(64, 64, 64)
                        .addComponent(btnAsignarEtapa, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombreEtapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtNumeroEtapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombreCaso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtTipoCaso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDesarrollador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtCui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAsignarEtapa)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel9.setText("Casos Registrados: (Seleccione Uno)");

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listadoCasosObservable}");
        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, tbCasos);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombre}"));
        columnBinding.setColumnName("Nombre");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tipoCaso}"));
        columnBinding.setColumnName("Tipo Caso");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idProyecto}"));
        columnBinding.setColumnName("ID Proyecto");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${estado}"));
        columnBinding.setColumnName("Estado");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${porcentaje}"));
        columnBinding.setColumnName("Porcentaje");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fechaCreacion}"));
        columnBinding.setColumnName("Fecha Regisrto");
        columnBinding.setColumnClass(java.time.LocalDate.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fechaLimite}"));
        columnBinding.setColumnName("Fecha Limite");
        columnBinding.setColumnClass(java.time.LocalDate.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${casoSeleccionado}"), tbCasos, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        jScrollPane2.setViewportView(tbCasos);

        jLabel10.setText("Desarrolladores: (Seleccione uno)");

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listadoDesarrolladoresObservable}");
        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, tbDesarrolladores);
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
        jTableBinding.bind();binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${desarrolladorSeleccionado}"), tbDesarrolladores, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        jScrollPane3.setViewportView(tbDesarrolladores);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreEtapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreEtapaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreEtapaActionPerformed

    private void btnAsignarEtapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarEtapaActionPerformed
        // TODO add your handling code here:
            if (txtNombreEtapa.getText().isEmpty()||txtNumeroEtapa.getText().isEmpty()|| txtNombreCaso.getText().isEmpty()
                    ||txtDesarrollador.getText().isEmpty()||txtPago.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, VAL_CAMPOS,"Error",JOptionPane.ERROR_MESSAGE);
            }else{
                    //se confirman los datos y se procede a guardarlos
                    int confirmar = JOptionPane.showConfirmDialog(null, CONFIRM_DATOS);
                    if (confirmar==CONF_SI) {// si se confirman los datos
                            // se actualiza el proyecto con su administrador
                             //conversion de fecha registro a Local Date 
                            LocalDate localDate1 = LocalDate.parse(txtFecha.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                            ControladorCasos controlador = new ControladorCasos();
                            RegistroEtapa etapa= new RegistroEtapa(Integer.parseInt(txtIdProyecto.getText()), txtTipoCaso.getText(), txtNombreCaso.getText(), txtDesarrollador.getText(),
                                        Integer.parseInt(txtNumeroEtapa.getText()), txtNombreEtapa.getText(), localDate1,0,
                                        Integer.parseInt(txtPago.getText()),0, "Etapa_Inicial", null,null);
                            controlador.registrarAsignacionEtapa(etapa);
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
    }//GEN-LAST:event_btnAsignarEtapaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsignarEtapa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tbCasos;
    private javax.swing.JTable tbDesarrolladores;
    private javax.swing.JTable tbTipoEtapa;
    private javax.swing.JTextField txtCui;
    private javax.swing.JTextField txtDesarrollador;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtIdProyecto;
    private javax.swing.JTextField txtNombreCaso;
    private javax.swing.JTextField txtNombreEtapa;
    private javax.swing.JTextField txtNumeroEtapa;
    private javax.swing.JTextField txtPago;
    private javax.swing.JTextField txtTipoCaso;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
