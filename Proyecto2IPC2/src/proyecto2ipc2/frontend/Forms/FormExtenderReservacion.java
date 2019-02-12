/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2ipc2.frontend.Forms;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import proyecto2ipc2.backend.Hotel.Cliente;
import proyecto2ipc2.backend.Hotel.ControladorClientes;
import proyecto2ipc2.backend.Hotel.ControladorHabitaciones;
import proyecto2ipc2.backend.Hotel.ControladorReservacion;
import proyecto2ipc2.backend.Hotel.Habitacion;
import proyecto2ipc2.backend.Hotel.Hotel;
import proyecto2ipc2.backend.Hotel.Reservacion;
import proyecto2ipc2.backend.User.Logger;
import static proyecto2ipc2.database.OperadorEsquema.CAMPOS_OBLIGATORIOS;
import static proyecto2ipc2.database.OperadorEsquema.GUARDAR_DATOS;
import static proyecto2ipc2.database.OperadorEsquema.MODIFICACION;
import proyecto2ipc2.frontend.JFramePrincipal;

/**
 *
 * @author bryan
 */
public class FormExtenderReservacion extends javax.swing.JInternalFrame {
    public static final String RESERVACION_SELECCIONADA="La Reservacion seleccionada\n no se puede volver a crear";
    public static final String ELIMINAR_RESERVACION_SELECCIONADA="Para Eliminar los datos de una Reservacion\n se debe especificar su numero";
    public static final String ELIMINAR_DATOS_RESERVACION="Esta seguro la Reservacion No. ";
    
    private ControladorReservacion controladorReserv;
    private ControladorHabitaciones controladorHabitaciones;
    private ControladorClientes controladorClientes;
    private Reservacion reservacion;
    private Habitacion habitacion;
    private Hotel hotel;
    private int idReservacion;
    private JFramePrincipal ventana;
    /**
     * Creates new form FormExtenderReservacion
     */
    public FormExtenderReservacion(JFramePrincipal ventana) {
         this.ventana= ventana;
        initComponents();
        this.deshabilitarBotones();
        this.cargarComboHoteles();
        this.cargarComboClientes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreHuesped = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNumeroHabitacion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        txtNoReservacion = new javax.swing.JTextField();
        txtFechaIngreso = new javax.swing.JFormattedTextField();
        txtFechaSalida = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        comboNits = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        comboHoteles = new javax.swing.JComboBox<>();
        txtIdHotel = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHabitaciones = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbReservaciones = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbHabitacionesDisponibles = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Extension de Reservaciones");

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Nombre: * ");

        txtNombreHuesped.setEditable(false);

        jLabel3.setText("Datos del Huesped:");

        jLabel4.setText("Datos de la Habitacion:");

        jLabel5.setText("Numero: *");

        txtNumeroHabitacion.setEditable(false);

        jLabel6.setText("Precio: * Q.");

        txtPrecio.setEditable(false);

        jLabel7.setText("Fecha de Ingreso:");

        jLabel11.setText("Fecha de Retiro:");

        btnActualizar.setText("Actualizar Fecha de Reservacion");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        jLabel19.setText("No.Reservacion:");

        txtNoReservacion.setEditable(false);

        try {
            txtFechaIngreso.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtFechaSalida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel8.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel8.setText("ejemplo: 02/06/2018");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel9.setText("ejemplo: 02/06/2018");

        jLabel10.setText("NIT: *");

        comboNits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboNitsActionPerformed(evt);
            }
        });

        jButton1.setText("Limpiar Campos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Hotel / ID:");

        comboHoteles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboHotelesActionPerformed(evt);
            }
        });

        txtIdHotel.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboNits, javax.swing.GroupLayout.Alignment.TRAILING, 0, 221, Short.MAX_VALUE)
                                    .addComponent(txtNombreHuesped, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)))
                    .addComponent(jLabel3))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(26, 26, 26)
                                        .addComponent(txtNumeroHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(39, 39, 39))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(118, 118, 118)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboHoteles, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtIdHotel))
                                        .addComponent(txtNoReservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 66, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombreHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtNumeroHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNoReservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(comboNits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdHotel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                    .addComponent(comboHoteles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnActualizar)
                            .addComponent(jButton1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel15.setText("Habitaciones Disponibles del Hotel (Seleccione una)");

        tbHabitaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero", "Tipo", "Nivel", "Precio", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbHabitaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHabitacionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbHabitaciones);

        jLabel16.setText("Reservaciones Realizadas ( Seleccione una)");

        tbReservaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero", "Nombre Huesped", "NIT Huesped", "ID_Habitacion", "Precio Habitacion", "Fecha Ingreso", "Fecha Retiro"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbReservaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbReservacionesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbReservaciones);

        tbHabitacionesDisponibles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero", "Tipo", "Inicia", "Termina"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbHabitacionesDisponibles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHabitacionesDisponiblesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbHabitacionesDisponibles);

        jLabel12.setText("Fechas Ocupadas para cada Habitacion");

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
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
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
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
            if (txtNombreHuesped.getText().isEmpty()||txtFechaIngreso.getText().isEmpty()||txtFechaSalida.getText().isEmpty()
                    ||txtNumeroHabitacion.getText().isEmpty()||txtPrecio.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,CAMPOS_OBLIGATORIOS, MODIFICACION, JOptionPane.ERROR_MESSAGE);
            } else {    
                        
                        int opcion= JOptionPane.showConfirmDialog(this, GUARDAR_DATOS);
                        if (opcion==0) {
                                LocalDate fechaIngreso = LocalDate.parse(txtFechaIngreso.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                                LocalDate fechaRetiro = LocalDate.parse(txtFechaSalida.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                                habitacion = new Habitacion(Integer.parseInt(txtNumeroHabitacion.getText()), Double.parseDouble(txtPrecio.getText()));
                                hotel= new Hotel(Integer.parseInt(txtIdHotel.getText()));
                                reservacion= new Reservacion(Integer.parseInt(txtNoReservacion.getText()),habitacion, fechaIngreso, fechaRetiro,hotel);
                                controladorReserv= new ControladorReservacion(reservacion, this);
                                controladorReserv.verificarActualizacionFechasReservacion();

                        }
                        if(opcion==1){
                                limpiarCampos();
                                deshabilitarBotones();
                        }
                       
                        
                }

        
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void comboNitsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboNitsActionPerformed
        // TODO add your handling code here:
            controladorClientes = new ControladorClientes();
            Cliente cliente=controladorClientes.recuperarClienteNit((String)comboNits.getSelectedItem());
            if (cliente!=null) {
                    txtNombreHuesped.setText(cliente.getNombre());
                    cargarTablaReservaciones();
                    limpiarCampos();
                    deshabilitarBotones();
            }

    }//GEN-LAST:event_comboNitsActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
            limpiarCampos();
            deshabilitarBotones();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void comboHotelesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboHotelesActionPerformed
        // TODO add your handling code here:
            controladorHabitaciones= new ControladorHabitaciones();           
            Logger logger = Logger.getInstance();
            if (logger.getEstablecimiento()!=null) {
                    txtIdHotel.setText(""+logger.getIdEstablecimiento());
                    cargarTablasHabitacion();
                    cargarTablaReservaciones();
                    deshabilitarComboHoteles();
            } else {
                        txtIdHotel.setText(""+controladorHabitaciones.recuperarHotel((String)comboHoteles.getSelectedItem()));
                        cargarTablasHabitacion();
                        cargarTablaReservaciones();
            }
    }//GEN-LAST:event_comboHotelesActionPerformed

    private void tbHabitacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHabitacionesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbHabitacionesMouseClicked

    private void tbReservacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbReservacionesMouseClicked
        // TODO add your handling code here:
            habilitarBotones();
            DefaultTableModel model =(DefaultTableModel)tbReservaciones.getModel();
            
            if(tbReservaciones.getSelectedRow()!=-1){//si se ha seleccionado algo en la tabla se rellenan los campo
                    
                    txtNoReservacion.setText(model.getValueAt(tbReservaciones.getSelectedRow(), 0).toString());
                    txtNombreHuesped.setText(model.getValueAt(tbReservaciones.getSelectedRow(), 1).toString());
                    comboNits.setSelectedItem(model.getValueAt(tbReservaciones.getSelectedRow(), 2).toString());
                    txtNumeroHabitacion.setText(model.getValueAt(tbReservaciones.getSelectedRow(), 3).toString());
                    txtPrecio.setText(model.getValueAt(tbReservaciones.getSelectedRow(), 4).toString());
                    txtFechaIngreso.setText(model.getValueAt(tbReservaciones.getSelectedRow(), 5).toString());
                    txtFechaSalida.setText(model.getValueAt(tbReservaciones.getSelectedRow(), 6).toString());
                                       
                    //almacenamos la reservacion temporal seleccionada
                    idReservacion= Integer.parseInt(model.getValueAt(tbReservaciones.getSelectedRow(), 0).toString());
                    
            }
    }//GEN-LAST:event_tbReservacionesMouseClicked

    private void tbHabitacionesDisponiblesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHabitacionesDisponiblesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbHabitacionesDisponiblesMouseClicked
    public void cargarTablaHabitaciones(){
            limpiarTabla();
            controladorHabitaciones= new ControladorHabitaciones();
            List<Habitacion> lista= controladorHabitaciones.recuperarHabitaciones(Integer.parseInt(txtIdHotel.getText()));
            DefaultTableModel model= (DefaultTableModel)this.tbHabitaciones.getModel();
            for(Habitacion habitacion: lista){
                    model.addRow(new Object[]{habitacion.getNumero(),habitacion.getTipo(),
                    habitacion.getNivel(),habitacion.getPrecio(),habitacion.getEstado()});
            }                        
    }
    public void cargarTablaHabitacionesDisponibles(){
            limpiarTabla2();
            controladorReserv= new ControladorReservacion();
            List<Reservacion> lista= controladorReserv.recuperarReservacionesHabitaciones(Integer.parseInt(txtIdHotel.getText()),ventana.fechaActualDelSistema());
            DefaultTableModel model= (DefaultTableModel)this.tbHabitacionesDisponibles.getModel();
            String fechaIngreso;
            String fechaRetiro;
            for(Reservacion reserv: lista){
                    fechaIngreso= reserv.getFechaIngreso().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    fechaRetiro= reserv.getFechaRetiro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    model.addRow(new Object[]{reserv.getHabitacion().getNumero(),reserv.getHabitacion().getTipo(),
                    fechaIngreso,fechaRetiro});
            }                         
    }
    //metodo para limpiar tablas
    public void limpiarTabla(){
            DefaultTableModel tb = (DefaultTableModel)tbHabitaciones.getModel();
            int a = tbHabitaciones.getRowCount()-1;
            for (int i = a; i >= 0; i--) {          
                    tb.removeRow(tb.getRowCount()-1);
            }
    }
     //metodo para limpiar tablas
    public void limpiarTabla2(){
            DefaultTableModel tb = (DefaultTableModel)tbHabitacionesDisponibles.getModel();
            int a = tbHabitacionesDisponibles.getRowCount()-1;
            for (int i = a; i >= 0; i--) {          
                    tb.removeRow(tb.getRowCount()-1);
            }
    }
    public void cargarComboHoteles(){
            controladorHabitaciones= new ControladorHabitaciones();
            List<Hotel> lista= controladorHabitaciones.recuperarHoteles();
            DefaultComboBoxModel modelComboRestaurantes=(DefaultComboBoxModel)comboHoteles.getModel();
            for(Hotel hotel: lista){
                modelComboRestaurantes.addElement(hotel.getNombre());
            }   AutoCompleteDecorator.decorate(comboHoteles);
    }
    //metodo para limpiar tablas
    public void limpiarTabla3(){
            DefaultTableModel tb = (DefaultTableModel)tbReservaciones.getModel();
            int a = tbReservaciones.getRowCount()-1;
            for (int i = a; i >= 0; i--) {          
                    tb.removeRow(tb.getRowCount()-1);
            }
    }
    public void cargarTablaReservaciones(){
            limpiarTabla3();
            controladorReserv= new ControladorReservacion();
            List<Reservacion> lista= controladorReserv.recuperarReservacionesClienteParaExtension(Integer.parseInt(txtIdHotel.getText()),
                    (String)comboNits.getSelectedItem(),"ACTIVA");
            DefaultTableModel model= (DefaultTableModel)this.tbReservaciones.getModel();
            String fechaIngreso;
            String fechaRetiro;
            for(Reservacion reserv: lista){
                    fechaIngreso= reserv.getFechaIngreso().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    fechaRetiro= reserv.getFechaRetiro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    model.addRow(new Object[]{reserv.getNumero(),reserv.getCliente().getNombre(),
                    reserv.getCliente().getNit(),reserv.getHabitacion().getNumero(),reserv.getHabitacion().getPrecio(),
                    fechaIngreso,fechaRetiro});
            }                        
    }
    public void cargarComboClientes(){
            controladorClientes= new ControladorClientes();
            List<Cliente> lista= controladorClientes.recuperarClientes();
            DefaultComboBoxModel model4=(DefaultComboBoxModel)comboNits.getModel();
            for(Cliente huesped: lista){
                model4.addElement(huesped.getNit());
            }   AutoCompleteDecorator.decorate(comboNits);
    }
    public void actualizarReservacionEnTabla(){
            DefaultTableModel model=(DefaultTableModel)tbReservaciones.getModel();
            //Actualizando Tabla Reservaciones
            
            model.setValueAt(txtNoReservacion.getText(), tbReservaciones.getSelectedRow(),0);
            model.setValueAt(txtNombreHuesped.getText(), tbReservaciones.getSelectedRow(),1);
            model.setValueAt((String)comboNits.getSelectedItem(), tbReservaciones.getSelectedRow(),2);
            model.setValueAt(txtNumeroHabitacion.getText(), tbReservaciones.getSelectedRow(),3);
            model.setValueAt(txtPrecio.getText(), tbReservaciones.getSelectedRow(),4);
            model.setValueAt(txtFechaIngreso.getText(), tbReservaciones.getSelectedRow(),5);
            model.setValueAt(txtFechaSalida.getText(), tbReservaciones.getSelectedRow(),6);
            
    }
    public void limpiarCampos(){
            txtPrecio.setText("");
            comboNits.setSelectedIndex(0);
            txtNoReservacion.setText("");
            txtNumeroHabitacion.setText("");
            txtFechaIngreso.setText("");
            txtFechaSalida.setText("");
    } 
   
    public void deshabilitarBotones(){
            btnActualizar.setEnabled(false);
    } 
    public void deshabilitarComboHoteles(){
            comboHoteles.setEnabled(false);
    }
    public void habilitarBotones(){
            btnActualizar.setEnabled(true);
    } 
    public void organizarFormulario(){
            limpiarCampos();
            deshabilitarBotones();
    }
    public void cargarTablasHabitacion(){
            cargarTablaHabitaciones();
            cargarTablaHabitacionesDisponibles();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JComboBox<String> comboHoteles;
    private javax.swing.JComboBox<String> comboNits;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JTable tbHabitaciones;
    private javax.swing.JTable tbHabitacionesDisponibles;
    private javax.swing.JTable tbReservaciones;
    private javax.swing.JFormattedTextField txtFechaIngreso;
    private javax.swing.JFormattedTextField txtFechaSalida;
    private javax.swing.JTextField txtIdHotel;
    private javax.swing.JTextField txtNoReservacion;
    private javax.swing.JTextField txtNombreHuesped;
    private javax.swing.JTextField txtNumeroHabitacion;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
