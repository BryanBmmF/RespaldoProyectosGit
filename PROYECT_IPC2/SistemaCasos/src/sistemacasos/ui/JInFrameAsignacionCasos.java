/*
 * Frame para Asignacion de Casos
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
import sistemacasos.backend.proyects.ControladorProyectos;
import sistemacasos.backend.proyects.Proyecto;
import static sistemacasos.ui.FormNuevoEmpleado.CLEAR_CAMPO;
import static sistemacasos.ui.FormNuevoEmpleado.CONFIRM_DATOS;
import static sistemacasos.ui.FormNuevoEmpleado.CONF_CANCEL;
import static sistemacasos.ui.FormNuevoEmpleado.CONF_NO;
import static sistemacasos.ui.FormNuevoEmpleado.CONF_SI;
import static sistemacasos.ui.FormNuevoEmpleado.INDEX_INICIAL;
import static sistemacasos.ui.FormNuevoEmpleado.VAL_CAMPOS;
import static sistemacasos.ui.JFramePrincipal.devolverUser;
import static sistemacasos.ui.JFramePrincipal.fechaActualDelSistema;

/**
 *
 * @author bryan
 */
public class JInFrameAsignacionCasos extends javax.swing.JInternalFrame {

        /**
         * Creates new form JInFrameAsignacionCasos
         */
        private List<Proyecto> listadoProyectos;
	private ObservableList<Proyecto> listadoProyectosObservable;
        private Proyecto proyectoSeleccionado;
        private List<RegistroCaso> listadoCasos;
	private ObservableList<RegistroCaso> listadoCasosObservable;
        private List<Caso> listadoTiposCasos;
	private ObservableList<Caso> listadoTiposCasosObservable;
        public JInFrameAsignacionCasos() {
                this.listadoProyectos = new ArrayList<>();
                this.listadoProyectosObservable = ObservableCollections.observableList(listadoProyectos);
                this.listadoTiposCasos = new ArrayList<>();
                this.listadoTiposCasosObservable = ObservableCollections.observableList(listadoTiposCasos);
                this.listadoCasos = new ArrayList<>();
                this.listadoCasosObservable = ObservableCollections.observableList(listadoCasos);
                this.proyectoSeleccionado= new Proyecto();
                this.cargarTablas();
                initComponents();
                this.txtFecha.setText(fechaActualDelSistema());
        }
        //metodo para actualizar lista observable de empleados
        public void actualizarListadoObservable(List<RegistroCaso> listadoCasos,List<Proyecto> listadoProyectos,List<Caso> listadoTipoCasos){
                this.listadoCasosObservable.clear();//se limpia la lista
		this.listadoCasosObservable.addAll(listadoCasos); //se agreaga a la lista observable
                this.listadoTiposCasosObservable.clear();//se limpia la lista
		this.listadoTiposCasosObservable.addAll(listadoTipoCasos); //se agreaga a la lista observable
                this.listadoProyectosObservable.clear();//se limpia la lista2
		this.listadoProyectosObservable.addAll(listadoProyectos); //se agrega a la lista observable2
        }
        //metodo para cargar las tabla de proyectos y casos
        public void cargarTablas(){
                ControladorCasos casos= new ControladorCasos();
                ControladorProyectos proyectos= new ControladorProyectos();
                actualizarListadoObservable(casos.consultarCasos(devolverUser()),proyectos.consultarProyectos(devolverUser()),casos.consultarTiposCaso());
        }
        private void resetCampos(){
                txtProyecto.setText(CLEAR_CAMPO);
                txtNombre.setText(CLEAR_CAMPO);
                txtIdProyecto.setText(CLEAR_CAMPO);
                comboDia.setSelectedIndex(INDEX_INICIAL);
                comboMes.setSelectedIndex(INDEX_INICIAL);
                comboYear.setSelectedIndex(INDEX_INICIAL);
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

        public ObservableList<Caso> getListadoTiposCasosObservable() {
                return listadoTiposCasosObservable;
        }

        public void setListadoTiposCasosObservable(ObservableList<Caso> listadoTiposCasosObservable) {
               this.listadoTiposCasosObservable = listadoTiposCasosObservable;
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

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaTiposCasos = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        txtProyecto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtIdProyecto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        comboDia = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        comboMes = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        comboYear = new javax.swing.JComboBox<>();
        btnAsignarCaso = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbProyectos = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

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
        jScrollPane3.setViewportView(jTable1);

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Asignacion de Casos");

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Nombre de Caso:");

        jLabel2.setText("Tipo:");

        listaTiposCasos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listadoTiposCasosObservable}");
        org.jdesktop.swingbinding.JListBinding jListBinding = org.jdesktop.swingbinding.SwingBindings.createJListBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, listaTiposCasos);
        jListBinding.setDetailBinding(org.jdesktop.beansbinding.ELProperty.create("${tipo}"));
        bindingGroup.addBinding(jListBinding);

        jScrollPane1.setViewportView(listaTiposCasos);

        jLabel3.setText(" Proyecto: ");

        txtProyecto.setEditable(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${proyectoSeleccionado.nombre}"), txtProyecto, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel4.setText("ID Proyecto:");

        txtIdProyecto.setEditable(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${proyectoSeleccionado.id}"), txtIdProyecto, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel5.setText("Fecha Registro: ");

        txtFecha.setEditable(false);

        jLabel6.setText("Fecha Limite:");

        jLabel7.setText("Dia");

        comboDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        jLabel8.setText("Mes:");

        comboMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        jLabel9.setText("Año:");

        comboYear.setEditable(true);
        comboYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030" }));

        btnAsignarCaso.setText("Asignar Caso");
        btnAsignarCaso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarCasoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAsignarCaso))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombre)
                            .addComponent(txtProyecto, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtIdProyecto))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboYear, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtIdProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(comboDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(comboMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(comboYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAsignarCaso)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel10.setText("Proyectos Disponibles: (seleccione uno)");

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listadoProyectosObservable}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, tbProyectos);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("ID");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombre}"));
        columnBinding.setColumnName("Nombre");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${userAdminProyecto}"));
        columnBinding.setColumnName("Admin Proyecto");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tipo}"));
        columnBinding.setColumnName("Tipo");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fechaCreacion}"));
        columnBinding.setColumnName("Fecha Creacion");
        columnBinding.setColumnClass(java.time.LocalDate.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${estado}"));
        columnBinding.setColumnName("Estado");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${proyectoSeleccionado}"), tbProyectos, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        jScrollPane2.setViewportView(tbProyectos);

        jLabel11.setText("Casos Asignados:");

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listadoCasosObservable}");
        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jTable2);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombre}"));
        columnBinding.setColumnName("Nombre");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tipoCaso}"));
        columnBinding.setColumnName("Tipo de Caso");
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
        columnBinding.setColumnName("Fecha Registro");
        columnBinding.setColumnClass(java.time.LocalDate.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fechaLimite}"));
        columnBinding.setColumnName("Fecha Limite");
        columnBinding.setColumnClass(java.time.LocalDate.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane4.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAsignarCasoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarCasoActionPerformed
        // TODO add your handling code here:
            if (txtNombre.getText().isEmpty()||txtProyecto.getText().isEmpty()||txtIdProyecto.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, VAL_CAMPOS,"Error",JOptionPane.ERROR_MESSAGE);
            }else{
                    //se confirman los datos y se procede a guardarlos
                    int confirmar = JOptionPane.showConfirmDialog(null, CONFIRM_DATOS);
                    if (confirmar==CONF_SI) {// si se confirman los datos
                            //se crea el usuario, se registra y se actualiza el empleado
                            //conversion de fecha a Local Date Inicio
                            String localDateLimite = String.valueOf(comboDia.getSelectedItem()+"/"+
                                comboMes.getSelectedItem()+"/"+comboYear.getSelectedItem());
                            
                            //conversion de fecha registro a Local Date 
                            LocalDate localDate1 = LocalDate.parse(txtFecha.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                            //conversion de fecha limite a Local Date 
                            LocalDate localDate2 = LocalDate.parse(localDateLimite, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                            
                            RegistroCaso caso= new RegistroCaso(txtNombre.getText(), Integer.parseInt(txtIdProyecto.getText()), (String)listaTiposCasos.getSelectedValue(), "Asignado", 0, localDate1, localDate2);
                            ControladorCasos controlador = new ControladorCasos();
                            controlador.registrarAsignacionCaso(caso);
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
        
            
    }//GEN-LAST:event_btnAsignarCasoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsignarCaso;
    private javax.swing.JComboBox<String> comboDia;
    private javax.swing.JComboBox<String> comboMes;
    private javax.swing.JComboBox<String> comboYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JTable jTable2;
    private javax.swing.JList<String> listaTiposCasos;
    private javax.swing.JTable tbProyectos;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtIdProyecto;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtProyecto;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
