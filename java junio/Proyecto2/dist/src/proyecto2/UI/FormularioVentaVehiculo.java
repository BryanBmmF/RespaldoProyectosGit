/*
 * Formulario para ventas de propiedad
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
public class FormularioVentaVehiculo extends javax.swing.JDialog {

    /**
     * Creates new form FormularioVenta
     */
    //cargando listas
    public static List<String> listaModelos= ControladorArchivos.leerArchivo("src/proyecto2/archivos/modelos.txt");
    public static List<String> listaMarcas= ControladorArchivos.leerArchivo("src/proyecto2/archivos/marcas.txt");
    public static List<String> listaTipos= ControladorArchivos.leerArchivo("src/proyecto2/archivos/tipos.txt");
    private static int costo;
    public FormularioVentaVehiculo(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        this.cargarCombos();
        this.setLocationRelativeTo(null);
        this.lbAlerta.setVisible(false);
        this.txtFecha.setText(fechaActualDelSistema());
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
        txtModel = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        comboMarcas = new javax.swing.JComboBox<>();
        comboModelos = new javax.swing.JComboBox<>();
        comboTipos = new javax.swing.JComboBox<>();
        txtAbogado = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtComprador = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtVendedor = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        lbModelo = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Venta de Vehiculo");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Cliente Vendedor: ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 33, -1, -1));

        jLabel2.setText("Cliente Comprador: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 107, -1, -1));

        jLabel4.setText("Fecha: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 526, -1, -1));

        txtFecha.setEditable(false);
        jPanel1.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 522, 143, -1));

        btnGuardar.setText("Generar Venta");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 590, -1, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 590, -1, -1));

        lbAlerta.setForeground(new java.awt.Color(255, 0, 0));
        lbAlerta.setText("*.Alerta");
        jPanel1.add(lbAlerta, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 563, 359, -1));

        comboCuiVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCuiVendedorActionPerformed(evt);
            }
        });
        jPanel1.add(comboCuiVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 67, 233, -1));

        comboCuiComprador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCuiCompradorActionPerformed(evt);
            }
        });
        jPanel1.add(comboCuiComprador, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 145, 232, -1));

        btnAgregarVendedor.setText("+.Agregar");
        btnAgregarVendedor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregarVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarVendedorActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(462, 25, -1, 30));

        btnAgregarAbogado.setText("+.Agregar");
        btnAgregarAbogado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregarAbogado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAbogadoActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarAbogado, new org.netbeans.lib.awtextra.AbsoluteConstraints(462, 179, -1, 30));

        jLabel3.setText("Abogado: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 187, -1, -1));

        comboColegiadoAbogados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboColegiadoAbogadosActionPerformed(evt);
            }
        });
        jPanel1.add(comboColegiadoAbogados, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 225, 176, -1));

        btnAgregarComprador.setText("+.Agregar");
        btnAgregarComprador.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregarComprador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCompradorActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarComprador, new org.netbeans.lib.awtextra.AbsoluteConstraints(462, 99, -1, 30));

        jLabel5.setText("Datos del Vehiculo: ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 260, -1, -1));

        jLabel6.setText("Marca: ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 298, -1, -1));
        jPanel1.add(txtModel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 143, -1));

        jLabel8.setText("Placa: ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 384, -1, -1));

        txtPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlacaActionPerformed(evt);
            }
        });
        jPanel1.add(txtPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 143, -1));

        jLabel9.setText("Tipo: ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 432, -1, -1));
        jPanel1.add(txtTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 430, 143, -1));

        jLabel10.setText("Costo:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 477, -1, -1));
        jPanel1.add(txtCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 470, 143, -1));

        comboMarcas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMarcasActionPerformed(evt);
            }
        });
        jPanel1.add(comboMarcas, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, 134, -1));

        comboModelos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboModelosActionPerformed(evt);
            }
        });
        jPanel1.add(comboModelos, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, 134, -1));

        comboTipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTiposActionPerformed(evt);
            }
        });
        jPanel1.add(comboTipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 430, 134, -1));

        txtAbogado.setEditable(false);
        jPanel1.add(txtAbogado, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 183, 294, -1));

        jLabel11.setText("No.Colegiado: ");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 230, -1, -1));

        txtComprador.setEditable(false);
        jPanel1.add(txtComprador, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 103, 293, -1));

        jLabel12.setText("No.DPI: ");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 150, -1, -1));

        txtVendedor.setEditable(false);
        txtVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVendedorActionPerformed(evt);
            }
        });
        jPanel1.add(txtVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 29, 295, -1));

        jLabel13.setText("No.DPI: ");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 72, -1, -1));

        lbModelo.setText("Modelo: ");
        jPanel1.add(lbModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, -1, -1));
        jPanel1.add(txtMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 143, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //se verifica si ya estan seleccionados los campos estado y genero
        if (txtCosto.getText().isEmpty() || txtPlaca.getText().isEmpty() || txtModel.getText().isEmpty()
                || txtModel.getText().isEmpty() || txtTipo.getText().isEmpty()) {
            //datos incompletos
            this.lbAlerta.setText("*.Todos los campos son Obligatorios");
            this.lbAlerta.setForeground(Color.RED); this.lbAlerta.setVisible(true);
        }else{//se confirman los datos y se procede a guardarlos
            int confirmar = JOptionPane.showConfirmDialog(null, "Esta Seguro de Generar esta Venta?");
            if (confirmar==0) {
                try{//validacion de cui
                    costo= Integer.valueOf(txtCosto.getText());
                    if(costo<1000) {
                        this.lbAlerta.setText("*. El Costo del Vehiculo no es Valido");
                        this.lbAlerta.setForeground(Color.RED); this.lbAlerta.setVisible(true);
                    }
                    else{//sino se crea la venta del vehiculo
                        //conversion de fecha a Local Date
                        LocalDate localDate1 = LocalDate.parse(txtFecha.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        //creando instancia de ventaVehiculo
                            Venta ventaVehiculo = new Venta((Cliente) ControladorArchivos.leerPersona(rutaRegistroCliente,
                                    String.valueOf(comboCuiComprador.getSelectedItem())+"cn"), 
                                    (Cliente) ControladorArchivos.leerPersona(rutaRegistroCliente,
                                    String.valueOf(comboCuiVendedor.getSelectedItem())+"cn"),
                                    (Abogado) ControladorArchivos.leerPersona(rutaRegistroAbogado,
                                    String.valueOf(comboColegiadoAbogados.getSelectedItem())+"Abog")
                                    , new Vehiculo(txtModel.getText(), txtModel.getText(),txtPlaca.getText()
                                    , txtTipo.getText(),"Vehiculo", costo), localDate1);
                            
                            //generando archivo
                            //se llama al contador de ventas de vehiculos
                            ControladorArchivos archivo= new ControladorArchivos();
                            String contVentas;
                            if(archivo.buscarExistente("src/proyecto2/ventas/"+"ventasVehiculos"+".cont")){
                                //si existe se llama a su contador y se sigue el conteo                     
                                contVentas=archivo.lecturaBasica("src/proyecto2/ventas/"+"ventasVehiculos"+".cont");             
                            }
                            else{
                                //sino se crea el contador con valor inicial para el archivo
                                archivo.escrituraBasica("src/proyecto2/ventas/"+"ventasVehiculos"+".cont", String.valueOf(0)); 
            
                                //se llama a su contador y se sigue el conteo                                       
                                contVentas=archivo.lecturaBasica("src/proyecto2/ventas/"+"ventasVehiculos"+".cont");
                            }
                            //se convierte el contador recuperado y se aumenta debido a la nueva venta
                            int contadorLeido= Integer.parseInt(contVentas);
                            contadorLeido++;
                            archivo.guardarVenta("src/proyecto2/ventas/", "venta", ".vehiculos", ventaVehiculo, contadorLeido);
                            
                            //se guarda el contador
                            archivo.escrituraBasica("src/proyecto2/ventas/"+"ventasVehiculos"+".cont", String.valueOf(contadorLeido));
                            
                            resetearFormulario();
                            //se crea el documento
                            Documento documento= new Documento();
                            documento.crearDocumentoVenta(ventaVehiculo);
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
    // reseteo del Formulario
    protected void resetearFormulario(){
        txtCosto.setText(""); txtPlaca.setText("");  this.lbAlerta.setVisible(false);   
        comboMarcas.setSelectedIndex(0); comboModelos.setSelectedIndex(0); comboTipos.setSelectedIndex(0);
    }
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // accion de boton Cancelar Formulario de abogado
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlacaActionPerformed

    private void txtVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVendedorActionPerformed

    private void comboMarcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMarcasActionPerformed
        // accion de combo marcas
        this.txtMarca.setText(String.valueOf(comboMarcas.getSelectedItem()));
    }//GEN-LAST:event_comboMarcasActionPerformed

    private void comboModelosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboModelosActionPerformed
      //aacion de combo modelos
      this.txtModel.setText(String.valueOf(comboModelos.getSelectedItem()));
    }//GEN-LAST:event_comboModelosActionPerformed

    private void comboTiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTiposActionPerformed
        // aacion de combo tipos
        this.txtTipo.setText(String.valueOf(comboTipos.getSelectedItem()));
    }//GEN-LAST:event_comboTiposActionPerformed

    private void btnAgregarVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarVendedorActionPerformed
        // Accion de botonAgregar Clientes
        formularioCliente= new FormularioCliente(Proyecto2.ventanaPrincipal);
        formularioCliente.setVisible(true);
        //actualizar combo
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
        //actualizar combo
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
        // accion de Combo Colegiados
        persona=ControladorArchivos.leerPersona(rutaRegistroAbogado,
                String.valueOf(comboColegiadoAbogados.getSelectedItem())+"Abog");
        this.txtAbogado.setText(persona.getNombre()+" "+persona.getApellido());
    }//GEN-LAST:event_comboColegiadoAbogadosActionPerformed
    //cargando combos
    public void cargarCombos(){
        DefaultComboBoxModel model=(DefaultComboBoxModel)comboMarcas.getModel();
        for(String marcas: listaMarcas){
            model.addElement(marcas);
        }   AutoCompleteDecorator.decorate(comboMarcas);
        DefaultComboBoxModel model2=(DefaultComboBoxModel)comboModelos.getModel();
        for(String modelos: listaModelos){
            model2.addElement(modelos);
        }   AutoCompleteDecorator.decorate(comboModelos);
        DefaultComboBoxModel model3=(DefaultComboBoxModel)comboTipos.getModel();
        for(String tipos: listaTipos){
            model3.addElement(tipos);
        }   AutoCompleteDecorator.decorate(comboTipos);
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
    private javax.swing.JComboBox<String> comboMarcas;
    private javax.swing.JComboBox<String> comboModelos;
    private javax.swing.JComboBox<String> comboTipos;
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbAlerta;
    private javax.swing.JLabel lbModelo;
    private javax.swing.JTextField txtAbogado;
    private javax.swing.JTextField txtComprador;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModel;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtTipo;
    private javax.swing.JTextField txtVendedor;
    // End of variables declaration//GEN-END:variables
}
