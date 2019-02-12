/*
 * Frame Interno de Abogados
 */
package proyecto2.UI;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyecto2.Abogado;
import proyecto2.ControladorArchivos;
import static proyecto2.ControladorArchivos.rutaRegistroAbogado;
import proyecto2.Persona;

/**
 *
 * @author bryan
 */
public class EdicionAbogados extends javax.swing.JInternalFrame {

    /**
     * Creates new form EdicionAbogados
     */
    private int numeroColegiado;
    public EdicionAbogados() {
        initComponents();
        this.lbAlerta.setVisible(false);
        this.cargarTablaAbogados();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        comboTitulo = new javax.swing.JComboBox<>();
        txtNoColegiado = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        lbAlerta = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaAbogados = new javax.swing.JTable();

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
        setTitle("Abogados");

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombres: ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 21, -1, -1));

        jLabel2.setText("Apellidos: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 62, -1, -1));

        jLabel3.setText("Titulo Universitario: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel4.setText("Numero de Colegiado: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 157, -1, -1));
        jPanel1.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 285, -1));
        jPanel1.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 58, 285, -1));

        comboTitulo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lic.", "MSc.", "Dr." }));
        jPanel1.add(comboTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 105, 210, -1));
        jPanel1.add(txtNoColegiado, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 153, 208, -1));

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 100, -1));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, 100, -1));

        lbAlerta.setForeground(new java.awt.Color(255, 0, 0));
        lbAlerta.setText("*.Alerta");
        jPanel1.add(lbAlerta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jLabel6.setText("Opciones: ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, -1, -1));

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, 100, -1));

        tablaAbogados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombres", "Apellidos", "TItulo Univ.", "No.Colegiado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaAbogados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaAbogadosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaAbogados);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
         //identifica si hay seleccionado algo y si la tabla contiene algo
        if (tablaAbogados.getSelectedRow()==-1) {
            if (tablaAbogados.getRowCount()<=0) {
                this.lbAlerta.setText("*. No hay informacion en la tabla");
                this.lbAlerta.setForeground(Color.GRAY); this.lbAlerta.setVisible(true);
            }else{
                this.lbAlerta.setText("*. Seleccione primero una fila");
                this.lbAlerta.setForeground(Color.GRAY); this.lbAlerta.setVisible(true);
            }

        }else{//Se verifica si el registro existe y se  procede a eliminar la fila seleccionada
            ControladorArchivos archivo= new ControladorArchivos();
            if (archivo.buscarExistente(rutaRegistroAbogado+txtNombres.getText()+txtApellidos.getText()+"."
                +String.valueOf(txtNoColegiado.getText())+"Abog")) {
                //se confirman los datos y se procede a eliminar
                int confirmar = JOptionPane.showConfirmDialog(null, "Esta Seguro de Eliminar a este Abogado?");
                if (confirmar==0) {
                    //Se procede a eliminar la fila seleccionada
                    DefaultTableModel model=(DefaultTableModel)tablaAbogados.getModel();
                    model.removeRow(tablaAbogados.getSelectedRow());
                    //se elimina el registro del archivo
                    archivo.eliminarArchivo(rutaRegistroAbogado, txtNombres.getText()+txtApellidos.getText(), "."
                    +String.valueOf(txtNoColegiado.getText())+"Abog");
      
                    resetearFormulario(); 
                    this.lbAlerta.setText("*. Registro Borrado");
                    this.lbAlerta.setForeground(Color.BLUE); this.lbAlerta.setVisible(true);
                }//En caso de no ser confirmados los datos
                if(confirmar==1) this.lbAlerta.setVisible(false);
                if(confirmar==2) resetearFormulario();
                
            }else{
                this.lbAlerta.setText("*.El Abogado que desea Eliminar No Existe");
                this.lbAlerta.setForeground(Color.RED); this.lbAlerta.setVisible(true);
            }       
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // Accion de boton Editar Abogados
        //Actualizacion de una fila
        if (tablaAbogados.getSelectedRow()==-1) {
            if (tablaAbogados.getRowCount()<=0) {
                this.lbAlerta.setText("*. No hay informacion en la tabla");
                this.lbAlerta.setForeground(Color.MAGENTA); this.lbAlerta.setVisible(true);
            }else{
                this.lbAlerta.setText("*. Seleccione primero una fila");
                this.lbAlerta.setForeground(Color.MAGENTA); this.lbAlerta.setVisible(true);
            }

        }else{// se revisa la existencia de un campo vacio y Se procede a la actualizacion
            if (txtNombres.getText().isEmpty() || txtApellidos.getText().isEmpty() 
                    || txtNoColegiado.getText().isEmpty()) {
                //datos incompletos
                this.lbAlerta.setText("*.Todos los campos son Obligatorios para la Actualizacion");
                this.lbAlerta.setForeground(Color.RED); this.lbAlerta.setVisible(true);
            }else{//se confirman los datos y se procede a Cambiarlos
                int confirmar = JOptionPane.showConfirmDialog(null, "Esta Seguro de Cambiar estos Datos?");
                if (confirmar==0) {
                    try{//validacion de No.Colegiado a cambiar
                        numeroColegiado= Integer.valueOf(txtNoColegiado.getText());
                        if(numeroColegiado<200) {
                            this.lbAlerta.setText("*. El nuevo No.Colegiado no es valido ");
                            this.lbAlerta.setForeground(Color.RED); this.lbAlerta.setVisible(true);
                        }
                        else{//Se procede a la actualizacion
                            DefaultTableModel model=(DefaultTableModel)tablaAbogados.getModel();
            
                            model.setValueAt(txtNombres.getText(), tablaAbogados.getSelectedRow(),0);
                            model.setValueAt(txtApellidos.getText(), tablaAbogados.getSelectedRow(),1);
                            model.setValueAt(comboTitulo.getSelectedItem(), tablaAbogados.getSelectedRow(), 2);
                            model.setValueAt(String.valueOf(txtNoColegiado.getText()), tablaAbogados.getSelectedRow(), 3);
                            this.lbAlerta.setText("*. Registro actualizado");
                            this.lbAlerta.setForeground(Color.BLUE); this.lbAlerta.setVisible(true);
                            
                            //Reescribiendo archivo Abogado y borrando registroAntiguo
                            ControladorArchivos archivo= new ControladorArchivos();
                            archivo.eliminarArchivo(rutaRegistroAbogado, archivoAntiguo,"Abog");
                            Persona abogado= new Abogado(String.valueOf(comboTitulo.getSelectedItem()),numeroColegiado,
                                    txtNombres.getText(),txtApellidos.getText());
                        
                            //guardando archivo
                            archivo.guardarPersona(rutaRegistroAbogado,abogado.getNombre()+
                            abogado.getApellido(), "."+((Abogado)abogado).getNumeroColegiado()+"Abog",abogado);
                            resetearFormulario();
                            this.lbAlerta.setText("*. Registro actualizado");
                            this.lbAlerta.setForeground(Color.BLUE); this.lbAlerta.setVisible(true);      
                        }                       
                    }catch(NumberFormatException e){
                        this.lbAlerta.setText("*. El nuevo No.Colegiado no es un numero");
                        this.lbAlerta.setForeground(Color.RED); this.lbAlerta.setVisible(true);
                    }
                }//En caso de no ser confirmados los datos
                if(confirmar==1) this.lbAlerta.setVisible(false);
                if(confirmar==2) resetearFormulario();
            
            }
            
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // Accion de Boton agregar Abogado
        if (txtNombres.getText().isEmpty() || txtApellidos.getText().isEmpty()
                || txtNoColegiado.getText().isEmpty()) {
            //datos incompletos
            this.lbAlerta.setText("*.Todos los campos son Obligatorios");
            this.lbAlerta.setForeground(Color.RED); this.lbAlerta.setVisible(true);
        }else{//se confirman los datos y se procede a guardarlos
            int confirmar = JOptionPane.showConfirmDialog(null, "Esta Seguro de Guardar estos Datos?");
            if (confirmar==0) {
                try{//validacion de numero de Colegiado
                    numeroColegiado= Integer.valueOf(txtNoColegiado.getText());
                    if(numeroColegiado<0) {
                        this.lbAlerta.setText("*. El Numero de Colegiado Ingresado no es valido");
                        this.lbAlerta.setForeground(Color.RED); this.lbAlerta.setVisible(true);
                    }
                    else{//creando instancia de archivo, verificando si ya existe el No.Colegiado, generando nuevo Abogado
                        ControladorArchivos archivo= new ControladorArchivos();
                        if (archivo.validarRegistro(rutaRegistroAbogado,"."+String.valueOf(numeroColegiado)+"Abog")==false) {
                            JOptionPane.showMessageDialog(null, "El Abogado que desea Agregar ya Existe!!");
                        }else{//instanciando nuevo abogado
                            Persona abogado= new Abogado(String.valueOf(comboTitulo.getSelectedItem()),numeroColegiado,
                                    txtNombres.getText(),txtApellidos.getText());

                            //generando archivo
                            archivo.guardarPersona(rutaRegistroAbogado,abogado.getNombre()+
                                abogado.getApellido(), "."+((Abogado)abogado).getNumeroColegiado()+"Abog",abogado);
                            //agregando nueva fila a la tabla
                            DefaultTableModel model=(DefaultTableModel)tablaAbogados.getModel();
                                model.addRow(new Object[]{txtNombres.getText(),txtApellidos.getText(),
                                comboTitulo.getSelectedItem(),numeroColegiado});
                            resetearFormulario();
                            this.lbAlerta.setText("*.Registro Ingresado Correctamente");
                            this.lbAlerta.setForeground(Color.BLUE); this.lbAlerta.setVisible(true);
                        
                        }
                        
                    }
                    
                }
                catch(NumberFormatException e){
                    this.lbAlerta.setText("*. El No.Colegiado Ingresado no es un numero");
                    this.lbAlerta.setForeground(Color.RED); this.lbAlerta.setVisible(true);
                }

            }//En caso de no ser confirmados los datos
            if(confirmar==1) this.lbAlerta.setVisible(false);
            if(confirmar==2) resetearFormulario();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tablaAbogadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAbogadosMouseClicked
        // Evento al hacer click sobre una fila de la tabla Abogados
         DefaultTableModel model =(DefaultTableModel)tablaAbogados.getModel();
        //metodo getValueAt devuelve el parametro de una fila y una columna en una tabla
        //reestableciendo en los campos del formulario la fila selecionada en la tabla
        if(tablaAbogados.getSelectedRow()!=-1){
            
            txtNombres.setText(model.getValueAt(tablaAbogados.getSelectedRow(), 0).toString());
            txtApellidos.setText(model.getValueAt(tablaAbogados.getSelectedRow(), 1).toString());
            comboTitulo.setSelectedItem(model.getValueAt(tablaAbogados.getSelectedRow(), 2));
            txtNoColegiado.setText(String.valueOf(model.getValueAt(tablaAbogados.getSelectedRow(), 3)));
            
            //variables temporales del registro que se desea borrar en algun momento ya que se selecciono
             archivoAntiguo=txtNombres.getText()+txtApellidos.getText()+"."
                    +String.valueOf(txtNoColegiado.getText());
        }
    }//GEN-LAST:event_tablaAbogadosMouseClicked
    // reseteo del Formulario
    protected void resetearFormulario(){
        txtNoColegiado.setText(""); txtNombres.setText(""); txtApellidos.setText("");
        comboTitulo.setSelectedIndex(0);
        this.lbAlerta.setVisible(false); archivoAntiguo="";    
    }
     //metodo para inhabilitar botones
    protected void bloquearBoton(String boton){
        if(boton.equals("agregar")) this.btnAgregar.setEnabled(false);
        if(boton.equals("editar")) this.btnEditar.setEnabled(false);
        if(boton.equals("eliminar")) this.btnEliminar.setEnabled(false);   
    }
    //metodo para llenar tabla Abogados
    protected void cargarTablaAbogados(){
        ControladorArchivos archivo= new ControladorArchivos();
        DefaultTableModel model= (DefaultTableModel)tablaAbogados.getModel();
        List<Persona> lista= new ArrayList<>();
        lista = archivo.leerPersonas(rutaRegistroAbogado,"Abog");
        
        for(Persona abogado: lista){
            model.addRow(new Object[]{abogado.getNombre(),abogado.getApellido(),
                ((Abogado)abogado).getTitulo(),((Abogado)abogado).getNumeroColegiado()});
        }                        
    }
    private static String archivoAntiguo="";
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<String> comboTitulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbAlerta;
    private javax.swing.JTable tablaAbogados;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtNoColegiado;
    private javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables
}
