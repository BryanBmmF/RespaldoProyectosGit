/*
 * Internal Frame para edicion de Clientes
 */
package proyecto2.UI;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import proyecto2.Cliente;
import proyecto2.ControladorArchivos;
import static proyecto2.ControladorArchivos.rutaRegistroCliente;
import proyecto2.Persona;
import static proyecto2.UI.FormularioCliente.listaDepartamentos;
import static proyecto2.UI.FormularioCliente.listaMunicipios;

/**
 *
 * @author bryan
 */
public class EdicionClientes extends javax.swing.JInternalFrame {

    /**
     * Creates new form EdicionClientes
     */
    //variables a utilizar
    private static String generoElegido="";
    private static String estadoElegido="";
    private static Long numeroCui;
    
    public EdicionClientes() {
        initComponents();
        this.lbAlerta.setVisible(false);
        this.cargarCombos();
        this.cargarTablaClientes();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        estado = new javax.swing.ButtonGroup();
        genero = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCui = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        lbAlerta = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        rbtnSoltero = new javax.swing.JRadioButton();
        rbtnCasado = new javax.swing.JRadioButton();
        rbtnMasculino = new javax.swing.JRadioButton();
        rbtnFemenino = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        comboMunicipios = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        comboDepartamentos = new javax.swing.JComboBox<>();
        txtResidencia = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Clientes");

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Apellidos: ");

        jLabel2.setText("No.DPI(CUI):");

        btnAgregar.setText("Agregar");
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        lbAlerta.setForeground(new java.awt.Color(204, 0, 0));
        lbAlerta.setText("*. Alerta");

        btnEliminar.setText("Eliminar");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jLabel6.setText("Opciones:");

        jLabel7.setText("Nombres: ");

        estado.add(rbtnSoltero);
        rbtnSoltero.setText("Soltero");

        estado.add(rbtnCasado);
        rbtnCasado.setText("Casado");

        genero.add(rbtnMasculino);
        rbtnMasculino.setText("Masculino");

        genero.add(rbtnFemenino);
        rbtnFemenino.setText("Femenino");

        jLabel4.setText("Estado Civil: ");

        jLabel5.setText("Genero: ");

        jLabel8.setText("Residencia: ");

        jLabel9.setText("Lugar de Origen: ");

        jLabel10.setText("Municipio: ");

        jLabel11.setText("Departamento: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboMunicipios, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtCui, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtResidencia, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGap(43, 43, 43)
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lbAlerta, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rbtnSoltero, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rbtnCasado, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(rbtnMasculino)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(31, 31, 31)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(rbtnFemenino))))
                            .addComponent(jLabel6)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(123, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(15, 15, 15))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtCui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(rbtnSoltero)
                            .addComponent(rbtnCasado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(rbtnMasculino)
                            .addComponent(rbtnFemenino))
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtResidencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(comboMunicipios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(comboDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lbAlerta))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombres", "Apellidos", "No.DPI(CUI)", "Estado Civil", "Genero", "Residencia", "Municipio", "Departamento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaClientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        seleccionEstadoGenero();//se verifica si ya estan seleccionados los campos estado y genero
        if (txtNombres.getText().isEmpty() || txtApellidos.getText().isEmpty() || txtCui.getText().isEmpty()
                || estadoElegido.equals("") || generoElegido.equals("")|| txtResidencia.getText().isEmpty()) {
            //datos incompletos
            this.lbAlerta.setText("*.Todos los campos son Obligatorios");
            this.lbAlerta.setForeground(Color.RED); this.lbAlerta.setVisible(true);
        }else{//se confirman los datos y se procede a guardarlos
            int confirmar = JOptionPane.showConfirmDialog(null, "Esta Seguro de Guardar estos Datos?");
            if (confirmar==0) {
                try{//validacion de cui
                    numeroCui= Long.valueOf(txtCui.getText());
                    if(txtCui.getText().length()<12) {
                        this.lbAlerta.setText("*. El cui Ingresado no es valido, debe contener 12 digitos");
                        this.lbAlerta.setForeground(Color.RED); this.lbAlerta.setVisible(true);
                    }
                    else{//creando instancia de archivo, verificando si ya existe el Cui del cliente, generando nuevo cliente
                        ControladorArchivos archivo= new ControladorArchivos();
                        if (archivo.validarRegistro(rutaRegistroCliente,"."+String.valueOf(numeroCui)+"cn")==false) {
                            JOptionPane.showMessageDialog(null, "El Cliente que desea Agregar ya Existe!!");
                        }else{
                            Persona cliente= new Cliente(numeroCui, estadoElegido, generoElegido, txtResidencia.getText(),
                            String.valueOf(comboMunicipios.getSelectedItem()),String.valueOf(comboDepartamentos.getSelectedItem()),
                            txtNombres.getText(), txtApellidos.getText());
                        
                            //generando archivo
                            archivo.guardarPersona(rutaRegistroCliente,cliente.getNombre()+
                                cliente.getApellido(), "."+((Cliente)cliente).getNumeroCui()+"cn",cliente);
                            //agregando nueva fila a la tabla
                            DefaultTableModel model=(DefaultTableModel)tablaClientes.getModel();
                            model.addRow(new Object[]{txtNombres.getText(),txtApellidos.getText(),numeroCui,estadoElegido,
                            generoElegido,txtResidencia.getText(),comboMunicipios.getSelectedItem(),comboDepartamentos.getSelectedItem()});
                            resetearFormulario();
                            this.lbAlerta.setText("*.Registro Ingresado Correctamente");
                            this.lbAlerta.setForeground(Color.BLUE); this.lbAlerta.setVisible(true); 
                        }                                                
                    }                    
                }
                catch(NumberFormatException e){
                    this.lbAlerta.setText("*. El carne Ingresado no es un numero");
                    this.lbAlerta.setForeground(Color.RED); this.lbAlerta.setVisible(true);
                }

            }//En caso de no ser confirmados los datos
            if(confirmar==1) this.lbAlerta.setVisible(false);
            if(confirmar==2) resetearFormulario();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        //identifica si hay seleccionado algo y si la tabla contiene algo
        if (tablaClientes.getSelectedRow()==-1) {
            if (tablaClientes.getRowCount()<=0) {
                this.lbAlerta.setText("*. No hay informacion en la tabla");
                this.lbAlerta.setForeground(Color.GRAY); this.lbAlerta.setVisible(true);
            }else{
                this.lbAlerta.setText("*. Seleccione primero una fila");
                this.lbAlerta.setForeground(Color.GRAY); this.lbAlerta.setVisible(true);
            }

        }else{//Se verifica si el registro existe y se  procede a eliminar la fila seleccionada
            ControladorArchivos archivo= new ControladorArchivos();
            if (archivo.buscarExistente(rutaRegistroCliente+txtNombres.getText()+txtApellidos.getText()+"."
                +String.valueOf(txtCui.getText())+"cn")) {
                //se confirman los datos y se procede a eliminar
                int confirmar = JOptionPane.showConfirmDialog(null, "Esta Seguro de Eliminar a este Cliente?");
                if (confirmar==0) {
                    DefaultTableModel model=(DefaultTableModel)tablaClientes.getModel();
                    model.removeRow(tablaClientes.getSelectedRow());
                    //se elimina el registro del archivo
                    archivo.eliminarArchivo(rutaRegistroCliente, txtNombres.getText()+txtApellidos.getText(), "."
                    +String.valueOf(txtCui.getText())+"cn");
                    resetearFormulario(); 
                    this.lbAlerta.setText("*. Registro Borrado");
                    this.lbAlerta.setForeground(Color.BLUE); this.lbAlerta.setVisible(true);
                }//En caso de no ser confirmados los datos
                if(confirmar==1) this.lbAlerta.setVisible(false);
                if(confirmar==2) resetearFormulario();
                
            }else{
                this.lbAlerta.setText("*.El Cliente que desea Eliminar No Existe");
                this.lbAlerta.setForeground(Color.RED); this.lbAlerta.setVisible(true);
            }       
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        //Actualizacion de una fila
        if (tablaClientes.getSelectedRow()==-1) {
            if (tablaClientes.getRowCount()<=0) {
                this.lbAlerta.setText("*. No hay informacion en la tabla");
                this.lbAlerta.setForeground(Color.MAGENTA); this.lbAlerta.setVisible(true);
            }else{
                this.lbAlerta.setText("*. Seleccione primero una fila");
                this.lbAlerta.setForeground(Color.MAGENTA); this.lbAlerta.setVisible(true);
            }

        }else{// se revisa la existencia de un campo vacio y Se procede a la actualizacion
            seleccionEstadoGenero();// se comprueba la seleccion de estado y genero
            if (txtNombres.getText().isEmpty() || txtApellidos.getText().isEmpty() || txtCui.getText().isEmpty()
                || estadoElegido.equals("") || generoElegido.equals("")|| txtResidencia.getText().isEmpty()) {
                //datos incompletos
                this.lbAlerta.setText("*.Todos los campos son Obligatorios para la Actualizacion");
                this.lbAlerta.setForeground(Color.RED); this.lbAlerta.setVisible(true);
            }else{//se confirman los datos y se procede a Cambiarlos
                int confirmar = JOptionPane.showConfirmDialog(null, "Esta Seguro de Cambiar estos Datos?");
                if (confirmar==0) {
                    try{//validacion de cui a cambiar
                        numeroCui= Long.valueOf(txtCui.getText());
                        if(txtCui.getText().length()<12) {
                            this.lbAlerta.setText("*. El nuevo CUI no es valido, debe contener 12 digitos");
                            this.lbAlerta.setForeground(Color.RED); this.lbAlerta.setVisible(true);
                        }
                        else{   
                            DefaultTableModel model=(DefaultTableModel)tablaClientes.getModel();
                            //Actualizando Tabla Clientes
                            model.setValueAt(txtNombres.getText(), tablaClientes.getSelectedRow(),0);
                            model.setValueAt(txtApellidos.getText(), tablaClientes.getSelectedRow(),1);
                            model.setValueAt(String.valueOf(txtCui.getText()), tablaClientes.getSelectedRow(), 2);
                            model.setValueAt(estadoElegido, tablaClientes.getSelectedRow(),3);
                            model.setValueAt(generoElegido, tablaClientes.getSelectedRow(), 4);
                            model.setValueAt(txtResidencia.getText(), tablaClientes.getSelectedRow(),5);
                            model.setValueAt(comboMunicipios.getSelectedItem(), tablaClientes.getSelectedRow(), 6);
                            model.setValueAt(comboDepartamentos.getSelectedItem(), tablaClientes.getSelectedRow(), 7);
            
                            //Reescribiendo archivo Cliente y borrando registroAntiguo
                            ControladorArchivos archivo= new ControladorArchivos();
                            archivo.eliminarArchivo(rutaRegistroCliente, archivoAntiguo,"cn");
                            Persona cliente= new Cliente(numeroCui, estadoElegido, generoElegido, txtResidencia.getText(),
                                String.valueOf(comboMunicipios.getSelectedItem()),String.valueOf(comboDepartamentos.getSelectedItem()),
                                txtNombres.getText(), txtApellidos.getText());
                        
                            //guardando archivo
                            archivo.guardarPersona(rutaRegistroCliente,cliente.getNombre()+
                            cliente.getApellido(), "."+((Cliente)cliente).getNumeroCui()+"cn",cliente);
                            resetearFormulario();
                            this.lbAlerta.setText("*. Registro actualizado");
                            this.lbAlerta.setForeground(Color.BLUE); this.lbAlerta.setVisible(true);      
                        }                       
                    }catch(NumberFormatException e){
                        this.lbAlerta.setText("*. El nuevo CUI no es un numero");
                        this.lbAlerta.setForeground(Color.RED); this.lbAlerta.setVisible(true);
                    }
                }//En caso de no ser confirmados los datos
                if(confirmar==1) this.lbAlerta.setVisible(false);
                if(confirmar==2) resetearFormulario();                
            }            
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void tablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseClicked
        // Evento al hacer click sobre una fila de la tabla Clientes
         DefaultTableModel model =(DefaultTableModel)tablaClientes.getModel();
        //metodo getValueAt devuelve el parametro de una fila y una columna en una tabla
        //reestableciendo en los campos del formulario la fila selecionada en la tabla
        if(tablaClientes.getSelectedRow()!=-1){
       
            txtNombres.setText(model.getValueAt(tablaClientes.getSelectedRow(), 0).toString());
            txtApellidos.setText(model.getValueAt(tablaClientes.getSelectedRow(), 1).toString());
            txtCui.setText(String.valueOf(model.getValueAt(tablaClientes.getSelectedRow(), 2)));
            String estado=model.getValueAt(tablaClientes.getSelectedRow(), 3).toString();
            String genero= model.getValueAt(tablaClientes.getSelectedRow(), 4).toString();
            txtResidencia.setText(model.getValueAt(tablaClientes.getSelectedRow(), 5).toString());
            comboMunicipios.setSelectedItem(model.getValueAt(tablaClientes.getSelectedRow(), 6));
            comboDepartamentos.setSelectedItem(model.getValueAt(tablaClientes.getSelectedRow(), 7));
            //marcando radio button de acuerdo a la comparacion de estado y genero
            if (estado.equals("Soltero")) rbtnSoltero.setSelected(true);
            if (estado.equals("Casado")) rbtnCasado.setSelected(true);
            if (genero.equals("Masculino")) rbtnMasculino.setSelected(true);
            if (genero.equals("Femenino")) rbtnFemenino.setSelected(true);
            
            //variables temporales del registro que se desea borrar en algun momento ya que se selecciono
             archivoAntiguo=txtNombres.getText()+txtApellidos.getText()+"."
                    +String.valueOf(txtCui.getText());
        }
    }//GEN-LAST:event_tablaClientesMouseClicked
    // reseteo del Formulario
    protected void resetearFormulario(){
        txtCui.setText(""); txtNombres.setText(""); txtApellidos.setText("");
        estadoElegido="";   generoElegido=("");  txtResidencia.setText("");
        comboMunicipios.setSelectedIndex(0); comboDepartamentos.setSelectedIndex(0);
        this.lbAlerta.setVisible(false); archivoAntiguo="";    
    }
    //seleccion de estado y genero
    protected void seleccionEstadoGenero(){
        if(rbtnCasado.isSelected()) estadoElegido=rbtnCasado.getText();
        if(rbtnSoltero.isSelected()) estadoElegido=rbtnSoltero.getText();
        if(rbtnFemenino.isSelected()) generoElegido=rbtnFemenino.getText();
        if(rbtnMasculino.isSelected()) generoElegido=rbtnMasculino.getText();
    }
    //metodo para inhabilitar botones
    protected void bloquearBoton(String boton){
        if(boton.equals("agregar")) this.btnAgregar.setEnabled(false);
        if(boton.equals("editar")) this.btnEditar.setEnabled(false);
        if(boton.equals("eliminar")) this.btnEliminar.setEnabled(false);   
    }
    //metodo para llenar tabla Clientes
    protected void cargarTablaClientes(){
        ControladorArchivos archivo= new ControladorArchivos();
        DefaultTableModel model= (DefaultTableModel)tablaClientes.getModel();
        List<Persona> lista= new ArrayList<>();
        lista = archivo.leerPersonas(rutaRegistroCliente,"cn");
        
        for(Persona cliente: lista){
            model.addRow(new Object[]{cliente.getNombre(),cliente.getApellido(),((Cliente)cliente).getNumeroCui()
            ,((Cliente)cliente).getEstadoCivil(),((Cliente)cliente).getGenero(),((Cliente)cliente).getResidencia()
            ,((Cliente)cliente).getMunicipio(),((Cliente)cliente).getDepartamento()});
        }                        
    }
    //cargando combos
    protected void cargarCombos(){
        DefaultComboBoxModel model=(DefaultComboBoxModel)comboMunicipios.getModel();
        for(String muni: listaMunicipios){
            model.addElement(muni);
        }   AutoCompleteDecorator.decorate(comboMunicipios);
        DefaultComboBoxModel model2=(DefaultComboBoxModel)comboDepartamentos.getModel();
        for(String dep: listaDepartamentos){
            model2.addElement(dep);
        }   AutoCompleteDecorator.decorate(comboDepartamentos);
    }
    private static String archivoAntiguo="";
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<String> comboDepartamentos;
    private javax.swing.JComboBox<String> comboMunicipios;
    private javax.swing.ButtonGroup estado;
    private javax.swing.ButtonGroup genero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbAlerta;
    private javax.swing.JRadioButton rbtnCasado;
    private javax.swing.JRadioButton rbtnFemenino;
    private javax.swing.JRadioButton rbtnMasculino;
    private javax.swing.JRadioButton rbtnSoltero;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCui;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtResidencia;
    // End of variables declaration//GEN-END:variables
}
