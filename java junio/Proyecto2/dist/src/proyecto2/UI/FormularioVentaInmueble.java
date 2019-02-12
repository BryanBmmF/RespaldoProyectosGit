/*
 * Formulario para venta de Inmuebles
 */
package proyecto2.UI;

import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import proyecto2.Abogado;
import proyecto2.Cliente;
import proyecto2.ControladorArchivos;
import static proyecto2.ControladorArchivos.rutaRegistroAbogado;
import static proyecto2.ControladorArchivos.rutaRegistroCliente;
import proyecto2.Documento;
import proyecto2.Inmueble;
import proyecto2.Persona;
import proyecto2.Proyecto2;
import static proyecto2.UI.FormularioCliente.cache;
import static proyecto2.UI.FramePrincipal.fechaActualDelSistema;
import proyecto2.Vehiculo;
import proyecto2.Venta;

/**
 *
 * @author bryan
 */
public class FormularioVentaInmueble extends javax.swing.JDialog {

    /**
     * Creates new form FormularioVentaInmueble
     */
    private static int costo;
    private static int niveles;
    private static Double medidas;
    public FormularioVentaInmueble(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        this.cargarCombos();
        this.setLocationRelativeTo(null);
        this.txtFecha.setText(fechaActualDelSistema());
        this.lbAlerta.setVisible(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lbAlerta = new javax.swing.JLabel();
        comboCuiVendedor = new javax.swing.JComboBox<>();
        comboCuiComprador = new javax.swing.JComboBox<>();
        btnAgregarVendedor = new javax.swing.JButton();
        btnAgregarAbogado = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        comboColegiadoAbogados = new javax.swing.JComboBox<>();
        btnAgregarComprador = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtMedidas = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtNiveles = new javax.swing.JTextField();
        txtAbogado = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtComprador = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtVendedor = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Venta de Inmueble");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Cliente Vendedor: ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 16, -1, -1));

        jLabel2.setText("Cliente Comprador: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 90, -1, -1));

        jLabel4.setText("Fecha: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 438, -1, -1));

        txtFecha.setEditable(false);
        jPanel1.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 434, 143, -1));

        btnGuardar.setText("Generar Venta");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 502, -1, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 502, -1, -1));

        lbAlerta.setForeground(new java.awt.Color(255, 0, 0));
        lbAlerta.setText("*.Alerta");
        jPanel1.add(lbAlerta, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 475, 359, -1));

        comboCuiVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCuiVendedorActionPerformed(evt);
            }
        });
        jPanel1.add(comboCuiVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 50, 233, -1));

        comboCuiComprador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCuiCompradorActionPerformed(evt);
            }
        });
        jPanel1.add(comboCuiComprador, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 128, 232, -1));

        btnAgregarVendedor.setText("+.Agregar");
        btnAgregarVendedor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregarVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarVendedorActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 8, -1, 30));

        btnAgregarAbogado.setText("+.Agregar");
        btnAgregarAbogado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregarAbogado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAbogadoActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarAbogado, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 162, -1, 30));

        jLabel3.setText("Abogado: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 170, -1, -1));

        comboColegiadoAbogados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboColegiadoAbogadosActionPerformed(evt);
            }
        });
        jPanel1.add(comboColegiadoAbogados, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 208, 176, -1));

        btnAgregarComprador.setText("+.Agregar");
        btnAgregarComprador.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregarComprador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCompradorActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarComprador, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 82, -1, 30));

        jLabel5.setText("Datos del Inmueble: ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 243, -1, -1));

        jLabel6.setText("Direccion: ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 268, -1, -1));
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 264, 143, -1));

        jLabel7.setText("Costo: ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 313, -1, -1));

        txtCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoActionPerformed(evt);
            }
        });
        jPanel1.add(txtCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 309, 143, -1));

        jLabel8.setText("Medidas: ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, -1, -1));

        txtMedidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMedidasActionPerformed(evt);
            }
        });
        jPanel1.add(txtMedidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 348, 143, -1));

        jLabel9.setText("No.Niveles: ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 397, -1, -1));
        jPanel1.add(txtNiveles, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 393, 143, -1));

        txtAbogado.setEditable(false);
        jPanel1.add(txtAbogado, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 166, 294, -1));

        jLabel11.setText("No.Colegiado: ");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 213, -1, -1));

        txtComprador.setEditable(false);
        jPanel1.add(txtComprador, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 293, -1));

        jLabel12.setText("No.DPI: ");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 133, -1, -1));

        txtVendedor.setEditable(false);
        txtVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVendedorActionPerformed(evt);
            }
        });
        jPanel1.add(txtVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 12, 295, -1));

        jLabel13.setText("No.DPI: ");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 55, -1, -1));

        jLabel10.setText("En (mt cuadrados)");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVendedorActionPerformed

    private void txtMedidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMedidasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMedidasActionPerformed

    private void txtCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // accion de boton Cancelar Formulario de abogado
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //se verifica si ya estan seleccionados los campos estado y genero
        if (txtDireccion.getText().isEmpty() || txtMedidas.getText().isEmpty() || txtCosto.getText().isEmpty()
                || txtComprador.getText().isEmpty() || txtNiveles.getText().isEmpty()) {
            //datos incompletos
            this.lbAlerta.setText("*.Todos los campos son Obligatorios");
            this.lbAlerta.setForeground(Color.RED); this.lbAlerta.setVisible(true);
        }else{//se confirman los datos y se procede a guardarlos
            int confirmar = JOptionPane.showConfirmDialog(null, "Esta Seguro de Generar esta Venta?");
            if (confirmar==0) {
                try{//validacion de cui
                    costo= Integer.valueOf(txtCosto.getText());
                    niveles= Integer.valueOf(txtNiveles.getText());
                    medidas=Double.parseDouble(txtMedidas.getText());
                    if(costo<10) {
                        this.lbAlerta.setText("*. El Costo del Inmueble no es Valido");
                        this.lbAlerta.setForeground(Color.RED); this.lbAlerta.setVisible(true);
                    }
                    else{//sino se crea la venta del vehiculo
                        //conversion de fecha a Local Date
                        LocalDate localDate1 = LocalDate.parse(txtFecha.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        //creando instancia de ventaVehiculo
                            Venta ventaInmueble = new Venta((Cliente) ControladorArchivos.leerPersona(rutaRegistroCliente,
                                    String.valueOf(comboCuiComprador.getSelectedItem())+"cn"), 
                                    (Cliente) ControladorArchivos.leerPersona(rutaRegistroCliente,
                                    String.valueOf(comboCuiVendedor.getSelectedItem())+"cn"),
                                    (Abogado) ControladorArchivos.leerPersona(rutaRegistroAbogado,
                                    String.valueOf(comboColegiadoAbogados.getSelectedItem())+"Abog")
                                    , new Inmueble(txtDireccion.getText(), medidas,niveles
                                    ,"Inmueble", costo), localDate1);
                            
                            //generando archivo
                            //se llama al contador de ventas de Inmuebles
                            ControladorArchivos archivo= new ControladorArchivos();
                            String contVentas;
                            if(archivo.buscarExistente("src/proyecto2/ventas/"+"ventasInmuebles"+".cont")){
                                //si existe se llama a su contador y se sigue el conteo                     
                                contVentas=archivo.lecturaBasica("src/proyecto2/ventas/"+"ventasInmuebles"+".cont");             
                            }
                            else{
                                //sino se crea el contador con valor inicial para el archivo
                                archivo.escrituraBasica("src/proyecto2/ventas/"+"ventasInmuebles"+".cont", String.valueOf(0)); 
            
                                //se llama a su contador y se sigue el conteo                                       
                                contVentas=archivo.lecturaBasica("src/proyecto2/ventas/"+"ventasInmuebles"+".cont");
                            }
                            //se convierte el contador recuperado y se aumenta debido a la nueva venta
                            int contadorLeido= Integer.parseInt(contVentas);
                            contadorLeido++;
                            archivo.guardarVenta("src/proyecto2/ventas/", "venta", ".inmuebles", ventaInmueble, contadorLeido);
                            
                            //se guarda el contador
                            archivo.escrituraBasica("src/proyecto2/ventas/"+"ventasVehiculos"+".cont", String.valueOf(contadorLeido));
                            
                            resetearFormulario();
                            //se crea el documento
                            Documento documento= new Documento();
                            documento.crearDocumentoVenta2(ventaInmueble);
                            this.dispose();
                                                                        
                    }                    
                }
                catch(NumberFormatException e){
                    this.lbAlerta.setText("*. El Costo o modelo del Vehiculo no es un numero");
                    e.printStackTrace();
                    this.lbAlerta.setForeground(Color.RED); this.lbAlerta.setVisible(true);
                }

            }//En caso de no ser confirmados los datos
            if(confirmar==1) this.lbAlerta.setVisible(false);
            if(confirmar==2) resetearFormulario();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnAgregarVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarVendedorActionPerformed
        // Accion de boton Agregar Clientes
        formularioCliente= new FormularioCliente(Proyecto2.ventanaPrincipal);
        formularioCliente.setVisible(true);
        if (cache.equals("")){
            //no actualizar el combo
        }else{
            DefaultComboBoxModel model=(DefaultComboBoxModel)comboCuiVendedor.getModel();
            model.addElement(cache);//actualizarlo
            cache="";
        }     
    }//GEN-LAST:event_btnAgregarVendedorActionPerformed

    private void btnAgregarCompradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCompradorActionPerformed
        // Accion de boton Agregar Clientes
        formularioCliente= new FormularioCliente(Proyecto2.ventanaPrincipal);
        formularioCliente.setVisible(true);
        if (cache.equals("")){
            //no actualizar el combo
        }else{
            DefaultComboBoxModel model=(DefaultComboBoxModel)comboCuiComprador.getModel();
            model.addElement(cache);//actualizarlo
            cache="";
        }     
    }//GEN-LAST:event_btnAgregarCompradorActionPerformed

    private void btnAgregarAbogadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAbogadoActionPerformed
        // accion de boton agregar abogado
        formularioAbogado= new FormularioAbogado(Proyecto2.ventanaPrincipal);
        formularioAbogado.setVisible(true);
        if (cache.equals("")){
            //no actualizar el combo
        }else{
            DefaultComboBoxModel model=(DefaultComboBoxModel)comboColegiadoAbogados.getModel();
            model.addElement(cache);//actualizarlo
            cache="";
        }     
    }//GEN-LAST:event_btnAgregarAbogadoActionPerformed

    private void comboCuiVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCuiVendedorActionPerformed
        // accion de Combo Cui Vendedor
        persona=ControladorArchivos.leerPersona(rutaRegistroCliente,
                String.valueOf(comboCuiVendedor.getSelectedItem())+"cn");
        this.txtVendedor.setText(persona.getNombre()+" "+persona.getApellido());
    }//GEN-LAST:event_comboCuiVendedorActionPerformed

    private void comboCuiCompradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCuiCompradorActionPerformed
        // accion de Combo Cui Comprador
        persona=ControladorArchivos.leerPersona(rutaRegistroCliente,
                String.valueOf(comboCuiComprador.getSelectedItem())+"cn");
        this.txtComprador.setText(persona.getNombre()+" "+persona.getApellido());
    }//GEN-LAST:event_comboCuiCompradorActionPerformed

    private void comboColegiadoAbogadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboColegiadoAbogadosActionPerformed
        // accion de Combo Cui Colegiados
        persona=ControladorArchivos.leerPersona(rutaRegistroAbogado,
                String.valueOf(comboColegiadoAbogados.getSelectedItem())+"Abog");
        this.txtAbogado.setText(persona.getNombre()+" "+persona.getApellido());
    }//GEN-LAST:event_comboColegiadoAbogadosActionPerformed
    public void cargarCombos(){
        ControladorArchivos archivo= new ControladorArchivos();
        List<Persona> lista= new ArrayList<>();
        lista = archivo.leerPersonas(rutaRegistroCliente,"cn");
        
        DefaultComboBoxModel model4=(DefaultComboBoxModel)comboCuiVendedor.getModel();
        for(Persona prestador: lista){
            model4.addElement(((Cliente)prestador).getNumeroCui());
        }   AutoCompleteDecorator.decorate(comboCuiVendedor);
        DefaultComboBoxModel model5=(DefaultComboBoxModel)comboCuiComprador.getModel();
        for(Persona adquisisor: lista){
            model5.addElement(((Cliente)adquisisor).getNumeroCui());
        }   AutoCompleteDecorator.decorate(comboCuiComprador);
        
        List<Persona> lista2= new ArrayList<>();
        lista2 = archivo.leerPersonas(rutaRegistroAbogado,"Abog");
        
        DefaultComboBoxModel model6=(DefaultComboBoxModel)comboColegiadoAbogados.getModel();
        for(Persona abogado: lista2){
            model6.addElement(((Abogado)abogado).getNumeroColegiado());
        }   AutoCompleteDecorator.decorate(comboColegiadoAbogados);
    }
    // reseteo del Formulario
    protected void resetearFormulario(){
        txtCosto.setText(""); txtDireccion.setText("");  this.lbAlerta.setVisible(false);   
        txtMedidas.setText(""); txtNiveles.setText("");
    }
    private Persona persona;
    private FormularioCliente formularioCliente;
    private FormularioAbogado formularioAbogado;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarAbogado;
    private javax.swing.JButton btnAgregarComprador;
    private javax.swing.JButton btnAgregarVendedor;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> comboColegiadoAbogados;
    private javax.swing.JComboBox<String> comboCuiComprador;
    private javax.swing.JComboBox<String> comboCuiVendedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbAlerta;
    private javax.swing.JTextField txtAbogado;
    private javax.swing.JTextField txtComprador;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtMedidas;
    private javax.swing.JTextField txtNiveles;
    private javax.swing.JTextField txtVendedor;
    // End of variables declaration//GEN-END:variables
}
