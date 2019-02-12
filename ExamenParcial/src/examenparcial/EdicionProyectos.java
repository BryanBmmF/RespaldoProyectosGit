/*
 * Frame para edicion de proyectos
 */
package examenparcial;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bryan
 */
public class EdicionProyectos extends javax.swing.JInternalFrame {

    /**
     * Creates new form EdicionProyectos
     */
    private int numeroPersonas;
    private int costo;
    
    public static  List<Proyectos> listaProyectos= new ArrayList<>();
    public EdicionProyectos() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNumeroPersonas = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        lbAlerta = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        comboMedios = new javax.swing.JComboBox<>();
        txtEdades = new javax.swing.JTextField();
        comboProyectos = new javax.swing.JComboBox<>();
        comboEdades = new javax.swing.JComboBox<>();
        txtCosto = new javax.swing.JTextField();
        txtProyecto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProyectos = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("No.Personas: ");

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

        jLabel7.setText("Proyecto: ");

        jLabel8.setText("Edades: ");

        jLabel9.setText("Costo por Persona: ");

        jLabel10.setText("Medios Usados: ");

        comboMedios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Radio Y Tv", "Volantes", "Radio, TV y Redes Sociales", "TV, Volantes y Redes Sociales", "Redes Sociales y Volantes", "Radio", "Tv", "Redes Sociales" }));

        comboProyectos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Revista", "Campaña", "Convencion", "Presentacion", "Fiesta", "Promocion" }));
        comboProyectos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProyectosActionPerformed(evt);
            }
        });

        comboEdades.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "9 a 18 años", "15 a 25 años", "21 a 33 años", "25 a 65 años", "35 a 60 años" }));
        comboEdades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEdadesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtCosto)
                                        .addComponent(comboMedios, 0, 228, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(118, 118, 118)
                                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNumeroPersonas, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtEdades)
                                    .addComponent(txtProyecto, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboProyectos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboEdades, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lbAlerta, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(comboProyectos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNumeroPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtEdades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboEdades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(comboMedios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lbAlerta)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        tablaProyectos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Proyecto", "Personas Alcanzadas", "Edades Objetivos", "Costo por Persona", "Medios Usados"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProyectos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProyectosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProyectos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaProyectosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProyectosMouseClicked
        // Evento al hacer click sobre una fila de la tabla Clientes
        DefaultTableModel model =(DefaultTableModel)tablaProyectos.getModel();
        //metodo getValueAt devuelve el parametro de una fila y una columna en una tabla
        //reestableciendo en los campos del formulario la fila selecionada en la tabla
        if(tablaProyectos.getSelectedRow()!=-1){

            txtProyecto.setText(model.getValueAt(tablaProyectos.getSelectedRow(), 0).toString());
            txtNumeroPersonas.setText(String.valueOf(model.getValueAt(tablaProyectos.getSelectedRow(), 1)));
            txtEdades.setText(String.valueOf(model.getValueAt(tablaProyectos.getSelectedRow(), 2)));
            txtCosto.setText(String.valueOf(model.getValueAt(tablaProyectos.getSelectedRow(), 3)));
            comboMedios.setSelectedItem(model.getValueAt(tablaProyectos.getSelectedRow(), 4).toString());
        }
    }//GEN-LAST:event_tablaProyectosMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        //Actualizacion de una fila
        if (tablaProyectos.getSelectedRow()==-1) {
            if (tablaProyectos.getRowCount()<=0) {
                this.lbAlerta.setText("*. No hay informacion en la tabla");
                this.lbAlerta.setForeground(Color.MAGENTA); this.lbAlerta.setVisible(true);
            }else{
                this.lbAlerta.setText("*. Seleccione primero una fila");
                this.lbAlerta.setForeground(Color.MAGENTA); this.lbAlerta.setVisible(true);
            }

        }else{// se revisa la existencia de un campo vacio y Se procede a la actualizacion
             if (txtCosto.getText().isEmpty() || txtEdades.getText().isEmpty() || txtNumeroPersonas.getText().isEmpty()) {
            //datos incompletos
            this.lbAlerta.setText("*.Todos los campos son Obligatorios");
            this.lbAlerta.setForeground(Color.RED); this.lbAlerta.setVisible(true);
        }else{//se confirman los datos y se procede a guardarlos
            int confirmar = JOptionPane.showConfirmDialog(null, "Esta Seguro de Guardar estos Datos?");
            if (confirmar==0) {
                try{//validacion de cui
                    numeroPersonas= Integer.valueOf(txtNumeroPersonas.getText());
                    costo=Integer.valueOf(txtCosto.getText());
                    if(numeroPersonas<0 || costo<0) {
                        this.lbAlerta.setText("*.El No.Personas o el costo son Invalidos");
                        this.lbAlerta.setForeground(Color.RED); this.lbAlerta.setVisible(true);
                    }
                    else{
                            //Agregando a la tabla
   
                            DefaultTableModel model=(DefaultTableModel)tablaProyectos.getModel();
                            //Actualizando Tabla Proyectos
                            model.setValueAt(txtProyecto.getText(), tablaProyectos.getSelectedRow(),0);
                            model.setValueAt(String.valueOf(txtNumeroPersonas.getText()), tablaProyectos.getSelectedRow(),1);
                            model.setValueAt(txtEdades.getText(), tablaProyectos.getSelectedRow(), 2);
                            model.setValueAt(String.valueOf(txtCosto.getText()), tablaProyectos.getSelectedRow(),3);
                            model.setValueAt(comboMedios.getSelectedItem(), tablaProyectos.getSelectedRow(),0);
     
                            //creando instancia de nuevo Proyecto                                     
                            listaProyectos.add(new Proyectos(txtProyecto.getText()
                                , numeroPersonas, txtEdades.getText(), costo,String.valueOf(comboMedios.getSelectedItem())));
                            resetearFormulario();
                            this.lbAlerta.setText("*. Registro actualizado");
                            this.lbAlerta.setForeground(Color.BLUE); this.lbAlerta.setVisible(true);    
                }
            }
            catch(NumberFormatException e){
                this.lbAlerta.setText("*. Numero de Personas o Costo no son numeros");
                this.lbAlerta.setForeground(Color.RED); this.lbAlerta.setVisible(true);
            }

        }
           
        }
    }//GEN-LAST:event_btnEditarActionPerformed
    }
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        //identifica si hay seleccionado algo y si la tabla contiene algo
        if (tablaProyectos.getSelectedRow()==-1) {
            if (tablaProyectos.getRowCount()<=0) {
                this.lbAlerta.setText("*. No hay informacion en la tabla");
                this.lbAlerta.setForeground(Color.GRAY); this.lbAlerta.setVisible(true);
            }else{
                this.lbAlerta.setText("*. Seleccione primero una fila");
                this.lbAlerta.setForeground(Color.GRAY); this.lbAlerta.setVisible(true);
            }

        }else{//Se verifica si el registro existe y se  procede a eliminar la fila seleccionada
            //se confirman los datos y se procede a eliminar
            int confirmar = JOptionPane.showConfirmDialog(null, "Esta Seguro de Eliminar este Proyecto?");
            if (confirmar==0) {
                DefaultTableModel model=(DefaultTableModel)tablaProyectos.getModel();
                model.removeRow(tablaProyectos.getSelectedRow());
                //se elimina el registro del archivo
                resetearFormulario();
                this.lbAlerta.setText("*. Registro Borrado");
                this.lbAlerta.setForeground(Color.BLUE); this.lbAlerta.setVisible(true);
            }//En caso de no ser confirmados los datos
            if(confirmar==1) this.lbAlerta.setVisible(false);
            if(confirmar==2) resetearFormulario();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        if (txtCosto.getText().isEmpty() || txtEdades.getText().isEmpty() || txtNumeroPersonas.getText().isEmpty()) {
            //datos incompletos
            this.lbAlerta.setText("*.Todos los campos son Obligatorios");
            this.lbAlerta.setForeground(Color.RED); this.lbAlerta.setVisible(true);
        }else{//se confirman los datos y se procede a guardarlos
            int confirmar = JOptionPane.showConfirmDialog(null, "Esta Seguro de Guardar estos Datos?");
            if (confirmar==0) {
                try{//validacion de cui
                    numeroPersonas= Integer.valueOf(txtNumeroPersonas.getText());
                    costo=Integer.valueOf(txtCosto.getText());
                    if(numeroPersonas<0 || costo<0) {
                        this.lbAlerta.setText("*.El No.Personas o el costo son Invalidos");
                        this.lbAlerta.setForeground(Color.RED); this.lbAlerta.setVisible(true);
                    }
                    else{//creando instancia de nuevo Proyecto
                        
                        Proyectos nuevoProyecto= new Proyectos(String.valueOf(comboProyectos.getSelectedItem())
                                , numeroPersonas, txtEdades.getText(), costo,String.valueOf(comboMedios.getSelectedItem()) );

                            //Agregando a la tabla
   
                            DefaultTableModel model=(DefaultTableModel)tablaProyectos.getModel();
                            model.addRow(new Object[]{txtProyecto.getText(),String.valueOf(numeroPersonas),
                            txtEdades.getText(),String.valueOf(costo),comboMedios.getSelectedItem()});
                        resetearFormulario();
                        this.lbAlerta.setText("*.Registro Ingresado Correctamente");
                        this.lbAlerta.setForeground(Color.BLUE); this.lbAlerta.setVisible(true);
                }
            }
            catch(NumberFormatException e){
                this.lbAlerta.setText("*. Numero de Personas o Costo no son numeros");
                this.lbAlerta.setForeground(Color.RED); this.lbAlerta.setVisible(true);
            }

        }//En caso de no ser confirmados los datos
        if(confirmar==1) this.lbAlerta.setVisible(false);
        if(confirmar==2) resetearFormulario();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed
    
    private void comboEdadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEdadesActionPerformed
        txtEdades.setText(String.valueOf(comboEdades.getSelectedItem()));
    }//GEN-LAST:event_comboEdadesActionPerformed

    private void comboProyectosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProyectosActionPerformed
        //
        txtProyecto.setText(String.valueOf(comboProyectos.getSelectedItem()));
    }//GEN-LAST:event_comboProyectosActionPerformed
    // reseteo del Formulario
    protected void resetearFormulario(){
        txtProyecto.setText("");
        txtNumeroPersonas.setText(""); txtCosto.setText(""); txtEdades.setText("");
        comboEdades.setSelectedIndex(0); comboMedios.setSelectedIndex(0);
        comboProyectos.setSelectedIndex(0);
        this.lbAlerta.setVisible(false);   
    }
    //seleccion de estado y genero
    protected void seleccionEstadoGenero(){
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<String> comboEdades;
    private javax.swing.JComboBox<String> comboMedios;
    private javax.swing.JComboBox<String> comboProyectos;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbAlerta;
    private javax.swing.JTable tablaProyectos;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtEdades;
    private javax.swing.JTextField txtNumeroPersonas;
    private javax.swing.JTextField txtProyecto;
    // End of variables declaration//GEN-END:variables
}
