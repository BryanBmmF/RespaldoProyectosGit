/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplotablas1;

import java.awt.Color;
import javax.swing.DefaultButtonModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bryan
 */
public class Tabla extends javax.swing.JFrame {

    /**
     * Creates new form Tabla
     */
    //variables a utilizar
    private static String generoElegido="";
    private static String estadoElegido="";
    private static int numeroCarne;
    
    public Tabla() {
        initComponents();
        this.lbError.setVisible(false);
        this.setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        estado = new javax.swing.ButtonGroup();
        genero = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtCarne = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comboCarrera = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        rbtnSoltero = new javax.swing.JRadioButton();
        rbtnCasado = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        rbtnMasculino = new javax.swing.JRadioButton();
        rbtnFemenino = new javax.swing.JRadioButton();
        btnGuardar = new javax.swing.JButton();
        lbError = new javax.swing.JLabel();
        btnBorrar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnMover = new javax.swing.JButton();
        btnMoverTodo = new javax.swing.JButton();
        btnBorrarTodo = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla2 = new javax.swing.JTable();
        lbAlerta2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombre ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 12, -1, -1));

        jLabel2.setText("Carne");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 47, -1, -1));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 8, 285, -1));
        jPanel1.add(txtCarne, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 43, 285, -1));

        jLabel3.setText("Carrera");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 83, -1, -1));

        comboCarrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ingenieria en Ciencias y Sistemas", "Ingenieria Civil", "Ingenieria Industrial", "Ingenieria Mecanica", "Ingenieria Mecanica Industrial" }));
        jPanel1.add(comboCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 78, 285, -1));

        jLabel4.setText("Estado Civil");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 128, -1, -1));

        estado.add(rbtnSoltero);
        rbtnSoltero.setText("Soltero");
        rbtnSoltero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnSolteroActionPerformed(evt);
            }
        });
        jPanel1.add(rbtnSoltero, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 121, 103, -1));

        estado.add(rbtnCasado);
        rbtnCasado.setText("Casado");
        rbtnCasado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnCasadoActionPerformed(evt);
            }
        });
        jPanel1.add(rbtnCasado, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 110, -1));

        jLabel5.setText("Genero");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 168, -1, -1));

        genero.add(rbtnMasculino);
        rbtnMasculino.setText("Masculino");
        rbtnMasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnMasculinoActionPerformed(evt);
            }
        });
        jPanel1.add(rbtnMasculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 161, -1, -1));

        genero.add(rbtnFemenino);
        rbtnFemenino.setText("Femenino");
        rbtnFemenino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnFemeninoActionPerformed(evt);
            }
        });
        jPanel1.add(rbtnFemenino, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 110, -1));

        btnGuardar.setText("Guardar");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 100, 40));

        lbError.setForeground(new java.awt.Color(204, 0, 0));
        lbError.setText("*. El Nombre y Carne son Obligatorios");
        jPanel1.add(lbError, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 204, 319, -1));

        btnBorrar.setText("Borrar");
        btnBorrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, -1, 40));

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, -1, 40));

        jLabel6.setText("Opciones");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, -1, -1));

        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Carne", "Nombre", "Carrera", "Estado Civil", "Genero"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla1);

        jLabel7.setText("Tabla Principal");

        jLabel8.setText("Opciones de Tabla");

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnMover.setText("Mover Registro");
        btnMover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoverActionPerformed(evt);
            }
        });

        btnMoverTodo.setText("Mover Todos los Registros");
        btnMoverTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoverTodoActionPerformed(evt);
            }
        });

        btnBorrarTodo.setText("Borrar Todos los Registros");
        btnBorrarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarTodoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMover)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMoverTodo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBorrarTodo)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMover, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(btnMoverTodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBorrarTodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel9.setText("Tabla 2");

        tabla2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Carne", "Nombre", "Carrera", "Estado Civil", "Genero"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabla2);

        lbAlerta2.setText("*.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(lbAlerta2))
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lbAlerta2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbtnSolteroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnSolteroActionPerformed
    }//GEN-LAST:event_rbtnSolteroActionPerformed

    private void rbtnCasadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnCasadoActionPerformed
  
    }//GEN-LAST:event_rbtnCasadoActionPerformed

    private void rbtnMasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnMasculinoActionPerformed
    }//GEN-LAST:event_rbtnMasculinoActionPerformed

    private void rbtnFemeninoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnFemeninoActionPerformed
       
    }//GEN-LAST:event_rbtnFemeninoActionPerformed
    //Acciones del boton Guardar
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        seleccionEstadoGenero();//se verifica si ya estan seleccionados los campos estado y genero
        if (txtNombre.getText().isEmpty() || txtCarne.getText().isEmpty() || estadoElegido.equals("") || generoElegido.equals("")) {
            //datos incompletos
            this.lbError.setText("*.Todos los campos son Obligatorios");
            this.lbError.setForeground(Color.RED);
            this.lbError.setVisible(true);
        }else{//se confirman los datos y se procede a guardarlos
            int confirmar = JOptionPane.showConfirmDialog(null, "Esta Seguro de Guardar estos Datos?");
            if (confirmar==0) {
                try{//validacion de carne
                    numeroCarne= Integer.valueOf(txtCarne.getText());
                    if(numeroCarne<8700000 || numeroCarne>201900000) {
                        this.lbError.setText("*. El carne Ingresado no es valido");
                        this.lbError.setForeground(Color.RED);
                        this.lbError.setVisible(true);
                    }
                    else{//agregando nueva fila a la tabla
                        DefaultTableModel model=(DefaultTableModel)tabla1.getModel();
                        model.addRow(new Object[]{numeroCarne,txtNombre.getText(),comboCarrera.getSelectedItem(),estadoElegido,generoElegido});
                        resetearFormulario();
                        this.lbError.setText("*.Registro Ingresado Correctamente");
                        this.lbError.setForeground(Color.BLUE);
                        this.lbError.setVisible(true);
                    }
                
                }
                catch(NumberFormatException e){
                    this.lbError.setText("*. El carne Ingresado no es un numero");
                    this.lbError.setForeground(Color.RED);
                    this.lbError.setVisible(true);
                }
                
                
            }//En caso de no ser confirmados los datos
            if(confirmar==1) this.lbError.setVisible(false);
            if(confirmar==2) resetearFormulario();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed
    //accion de boton borrar registro de la tabla
    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        //identifica si hay seleccionado algo y si la tabla contiene algo
        if (tabla1.getSelectedRow()==-1) {
            if (tabla1.getRowCount()<=0) {
                this.lbError.setText("*. No hay informacion en la tabla");
                    this.lbError.setForeground(Color.GRAY);
                    this.lbError.setVisible(true);
            }else{
                this.lbError.setText("*. Seleccione primero una fila");
                    this.lbError.setForeground(Color.GRAY);
                    this.lbError.setVisible(true);
            }
            
        }else{//Se procede a eliminar la fila seleccionada
            DefaultTableModel model=(DefaultTableModel)tabla1.getModel();
            model.removeRow(tabla1.getSelectedRow());
            this.lbError.setText("*. Registro Borrado");
                    this.lbError.setForeground(Color.BLUE);
                    this.lbError.setVisible(true);
        }
    }//GEN-LAST:event_btnBorrarActionPerformed
    //Seleccion de una fila en la tabla 
    private void tabla1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla1MouseClicked
        DefaultTableModel model =(DefaultTableModel)tabla1.getModel();
        //metodo getValueAt devuelve el parametro de una fila y una columna en una tabla
        //reestableciendo en los campos del formulario la fila selecionada en la tabla
        if(tabla1.getSelectedRow()!=-1){
            txtCarne.setText(String.valueOf(model.getValueAt(tabla1.getSelectedRow(), 0)));
            txtNombre.setText(model.getValueAt(tabla1.getSelectedRow(), 1).toString());
            comboCarrera.setSelectedItem(model.getValueAt(tabla1.getSelectedRow(), 2));
            String estado=model.getValueAt(tabla1.getSelectedRow(), 3).toString();
            String genero= model.getValueAt(tabla1.getSelectedRow(), 4).toString();
            if (estado.equals("Soltero")) rbtnSoltero.setSelected(true);
            if (estado.equals("Casado")) rbtnCasado.setSelected(true);
            if (genero.equals("Masculino")) rbtnMasculino.setSelected(true);
            if (genero.equals("Femenino")) rbtnFemenino.setSelected(true);
        }
    }//GEN-LAST:event_tabla1MouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        //Actualizacion de una fila
        if (tabla1.getSelectedRow()==-1) {
            if (tabla1.getRowCount()<=0) {
                this.lbError.setText("*. No hay informacion en la tabla");
                    this.lbError.setForeground(Color.MAGENTA);
                    this.lbError.setVisible(true);
            }else{
                this.lbError.setText("*. Seleccione primero una fila");
                    this.lbError.setForeground(Color.MAGENTA);
                    this.lbError.setVisible(true);
            }
            
        }else{//Se procede a la actualizacion
            seleccionEstadoGenero();// se comprueba la seleccion de estado y genero
            DefaultTableModel model=(DefaultTableModel)tabla1.getModel();
            model.setValueAt(String.valueOf(txtCarne.getText()), tabla1.getSelectedRow(), 0);
            model.setValueAt(txtNombre.getText(), tabla1.getSelectedRow(),1);
            
            model.setValueAt(comboCarrera.getSelectedItem(), tabla1.getSelectedRow(), 2);
            model.setValueAt(estadoElegido, tabla1.getSelectedRow(),3);
            model.setValueAt(generoElegido, tabla1.getSelectedRow(), 4);
            
            this.lbError.setText("*. Registro actualizado");
            this.lbError.setForeground(Color.BLUE);
            this.lbError.setVisible(true);
            //resetearFormulario();
        }
       
        
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnMoverTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoverTodoActionPerformed
        // Accion de boton Mover Todo de tabla principal a tabla 2
         if (tabla1.getRowCount()<=0) {
            this.lbAlerta2.setText("*. No hay informacion en la tabla Principal Para ser Trasladada");
                this.lbAlerta2.setForeground(Color.RED);
                this.lbAlerta2.setVisible(true);
        }else{//Se procede a mover todos los registros de Tabla Principal
             DefaultTableModel model1=(DefaultTableModel)tabla1.getModel();
             DefaultTableModel model2=(DefaultTableModel)tabla2.getModel();
             for (int i = 0; i <tabla1.getRowCount(); i++) {
                 //se agrega cada fila 
                 model2.addRow(new Object[]{model1.getValueAt(i, 0).toString(),model1.getValueAt(i, 1).toString()
                 ,model1.getValueAt(i, 2).toString(),model1.getValueAt(i, 3).toString(),model1.getValueAt(i, 4).toString()});
             }
             this.lbAlerta2.setText("*. Transferencia Completada");
                this.lbAlerta2.setForeground(Color.BLUE);
                this.lbAlerta2.setVisible(true);
         }
    }//GEN-LAST:event_btnMoverTodoActionPerformed

    private void btnBorrarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarTodoActionPerformed
        // Accion de boton Borrar Todo de tabla 2
         if (tabla2.getRowCount()<=0) {
            this.lbAlerta2.setText("*. No hay informacion en la tabla 2 Para ser Borrada");
                this.lbAlerta2.setForeground(Color.RED);
                this.lbAlerta2.setVisible(true);
        }else{//Se procede a eliminar cada registro
             DefaultTableModel model2=(DefaultTableModel)tabla2.getModel();
             int contador= tabla2.getRowCount();
             for (int i = 0; contador>i; i++) {
                 //se Elimina cada fila 
                 model2.removeRow(0);
             }
             this.lbAlerta2.setText("*. Eliminacion Completada");
                this.lbAlerta2.setForeground(Color.BLUE);
                this.lbAlerta2.setVisible(true);
         }
    }//GEN-LAST:event_btnBorrarTodoActionPerformed

    private void btnMoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoverActionPerformed
        //Accion de boton Mover Registto de Tabla principal a tabla 2
        if (tabla1.getSelectedRow()==-1) {
            if (tabla1.getRowCount()<=0) {
                this.lbAlerta2.setText("*. No hay informacion en la tabla Principal");
                    this.lbAlerta2.setForeground(Color.RED);
                    this.lbAlerta2.setVisible(true);
            }else{
                this.lbAlerta2.setText("*. Seleccione Primero una Fila de la Tabla Principal");
                    this.lbAlerta2.setForeground(Color.RED);
                    this.lbAlerta2.setVisible(true);
            }
            
        }else{
            seleccionEstadoGenero();// se comprueba la seleccion de estado y genero
            DefaultTableModel model=(DefaultTableModel)tabla2.getModel();
            model.addRow(new Object[]{String.valueOf(txtCarne.getText()),
                txtNombre.getText(),comboCarrera.getSelectedItem(),
                estadoElegido,generoElegido});
            //resetearFormulario();
            this.lbAlerta2.setText("*. Registro Transferido");
            this.lbAlerta2.setForeground(Color.BLUE);
            this.lbAlerta2.setVisible(true);
            
        }
    }//GEN-LAST:event_btnMoverActionPerformed
    // reseteo del Formulario
    protected void resetearFormulario(){
        txtCarne.setText(""); txtNombre.setText("");
        estadoElegido=""; generoElegido=("");
        comboCarrera.setSelectedIndex(0); this.lbError.setVisible(false);     
    }
    //seleccion de estado y genero
    protected void seleccionEstadoGenero(){
        if(rbtnCasado.isSelected()) estadoElegido=rbtnCasado.getText();
        if(rbtnSoltero.isSelected()) estadoElegido=rbtnSoltero.getText();
        if(rbtnFemenino.isSelected()) generoElegido=rbtnFemenino.getText();
        if(rbtnMasculino.isSelected()) generoElegido=rbtnMasculino.getText();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBorrarTodo;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnMover;
    private javax.swing.JButton btnMoverTodo;
    private javax.swing.JComboBox<String> comboCarrera;
    private javax.swing.ButtonGroup estado;
    private javax.swing.ButtonGroup genero;
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
    private javax.swing.JLabel lbAlerta2;
    private javax.swing.JLabel lbError;
    private javax.swing.JRadioButton rbtnCasado;
    private javax.swing.JRadioButton rbtnFemenino;
    private javax.swing.JRadioButton rbtnMasculino;
    private javax.swing.JRadioButton rbtnSoltero;
    private javax.swing.JTable tabla1;
    private javax.swing.JTable tabla2;
    private javax.swing.JTextField txtCarne;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
