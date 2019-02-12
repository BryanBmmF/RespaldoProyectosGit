/*
 * Formulario para Alquileres
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
import proyecto2.Alquiler;
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
/**
 *
 * @author bryan
 */
public class FormularioAlquiler extends javax.swing.JDialog {

    /**
     * Creates new form FormularioAlquiler
     * 
     */
    //cargando listas
    public static List<String> listaYears= ControladorArchivos.leerArchivo("src/proyecto2/archivos/years.txt");
    public static List<String> listaDiasDePago= ControladorArchivos.leerArchivo("src/proyecto2/archivos/pagos.txt");
    
    private static int costoMensual;
    public FormularioAlquiler(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        this.cargarCombos();
        this.persona= new Persona();
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
        txtDiaPago = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lbAlerta = new javax.swing.JLabel();
        comboCuiPrestador = new javax.swing.JComboBox<>();
        comboCuiAdquisisor = new javax.swing.JComboBox<>();
        btnAgregarClienteP = new javax.swing.JButton();
        btnAgregarAbogado = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        comboColegiadoAbogados = new javax.swing.JComboBox<>();
        btnAgregarClienteA = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCostoMensual = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtAbogado = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtAdquisisor = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtPrestador = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        comboDiaInicio = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        comboMesInicio = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        comboAnIncio = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        comboDiaFinal = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        comboMesFinal = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        comboAnFinal = new javax.swing.JComboBox<>();
        comboDiaPago = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alquiler de Inmueble");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Cliente Prestador: ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 16, -1, -1));

        jLabel2.setText("Cliente Adquisisor: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 90, -1, -1));

        jLabel4.setText("Dia de Pago:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 438, -1, -1));

        txtDiaPago.setEditable(false);
        jPanel1.add(txtDiaPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 434, 143, -1));

        btnGuardar.setText("Generar Venta");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 544, -1, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 544, -1, -1));

        lbAlerta.setForeground(new java.awt.Color(255, 0, 0));
        lbAlerta.setText("*.Alerta");
        jPanel1.add(lbAlerta, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 517, 359, -1));

        comboCuiPrestador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCuiPrestadorActionPerformed(evt);
            }
        });
        jPanel1.add(comboCuiPrestador, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 50, 233, -1));

        comboCuiAdquisisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCuiAdquisisorActionPerformed(evt);
            }
        });
        jPanel1.add(comboCuiAdquisisor, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 128, 232, -1));

        btnAgregarClienteP.setText("+.Agregar");
        btnAgregarClienteP.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregarClienteP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarClientePActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarClienteP, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 8, -1, 30));

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
        jPanel1.add(comboColegiadoAbogados, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 208, 176, -1));

        btnAgregarClienteA.setText("+.Agregar");
        btnAgregarClienteA.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregarClienteA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarClienteAActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarClienteA, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 82, -1, 30));

        jLabel5.setText("Datos del Inmueble: ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 243, -1, -1));

        jLabel6.setText("Direccion: ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 268, -1, -1));
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 264, 281, -1));

        jLabel7.setText("Costo Mensual: ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 313, -1, -1));

        txtCostoMensual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoMensualActionPerformed(evt);
            }
        });
        jPanel1.add(txtCostoMensual, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 309, 143, -1));

        jLabel8.setText("Fecha de Inicio:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 352, -1, -1));

        jLabel9.setText("Fecha de Finalizacion:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 397, -1, -1));

        txtAbogado.setEditable(false);
        jPanel1.add(txtAbogado, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 166, 294, -1));

        jLabel11.setText("No.Colegiado: ");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 213, -1, -1));

        txtAdquisisor.setEditable(false);
        jPanel1.add(txtAdquisisor, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 86, 293, -1));

        jLabel12.setText("No.DPI: ");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 133, -1, -1));

        txtPrestador.setEditable(false);
        txtPrestador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrestadorActionPerformed(evt);
            }
        });
        jPanel1.add(txtPrestador, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 12, 295, -1));

        jLabel13.setText("No.DPI: ");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 55, -1, -1));

        jLabel10.setText("Fecha Actual:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 480, -1, -1));

        txtFecha.setEditable(false);
        jPanel1.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 476, 143, -1));

        jLabel14.setText("Dia");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 352, -1, -1));

        comboDiaInicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03 ", "04 ", "05 ", "06 ", "07 ", "08 ", "09 ", "10 ", "11 ", "12 ", "13 ", "14 ", "15 ", "16 ", "17 ", "18 ", "19 ", "20 ", "21 ", "22 ", "23 ", "24 ", "25 ", "26 ", "27 ", "28 ", "29 ", "30 ", "31" }));
        jPanel1.add(comboDiaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 347, 50, -1));

        jLabel15.setText("Mes");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 352, -1, -1));

        comboMesInicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01 ", "02 ", "03 ", "04 ", "05 ", "06 ", "07 ", "08 ", "09 ", "10 ", "11 ", "12" }));
        jPanel1.add(comboMesInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 347, 50, -1));

        jLabel16.setText("Año");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 352, -1, -1));

        jPanel1.add(comboAnIncio, new org.netbeans.lib.awtextra.AbsoluteConstraints(386, 347, 72, -1));

        jLabel17.setText("Dia");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 397, -1, -1));

        comboDiaFinal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01 ", "02 ", "03 ", "04 ", "05 ", "06 ", "07 ", "08 ", "09 ", "10 ", "11 ", "12 ", "13 ", "14 ", "15 ", "16", "17 ", "18 ", "19 ", "20 ", "21 ", "22 ", "23 ", "24 ", "25 ", "26 ", "27 ", "28 ", "29 ", "30 ", "31" }));
        jPanel1.add(comboDiaFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 392, 51, -1));

        jLabel18.setText("Mes");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 397, -1, -1));

        comboMesFinal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01 ", "02 ", "03 ", "04 ", "05 ", "06 ", "07 ", "08 ", "09 ", "10 ", "11 ", "12" }));
        jPanel1.add(comboMesFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 392, 50, -1));

        jLabel19.setText("Año");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 397, -1, -1));

        jPanel1.add(comboAnFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(386, 392, 72, -1));

        comboDiaPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDiaPagoActionPerformed(evt);
            }
        });
        jPanel1.add(comboDiaPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 433, 129, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //se verifica si ya estan seleccionados los campos estado y genero
        if (txtCostoMensual.getText().isEmpty() || txtDireccion.getText().isEmpty()) {
            //datos incompletos
            this.lbAlerta.setText("*.Todos los campos son Obligatorios");
            this.lbAlerta.setForeground(Color.RED); this.lbAlerta.setVisible(true);
        }else{//se confirman los datos y se procede a guardarlos
            int confirmar = JOptionPane.showConfirmDialog(null, "Esta Seguro de Generar esta Venta?");
            if (confirmar==0) {
                try{//validacion de cui
                    costoMensual= Integer.valueOf(txtCostoMensual.getText());
                    if(costoMensual<1) {
                        this.lbAlerta.setText("*. El Costo de Alquiler Mensual no es Valido");
                        this.lbAlerta.setForeground(Color.RED); this.lbAlerta.setVisible(true);
                    }
                    else{//sino se crea la venta del Inmueble
                        //conversion de fecha a Local Date Inicio
                        String localDateInicio = String.valueOf(comboDiaInicio.getSelectedItem()+"/"+
                                comboMesInicio.getSelectedItem()+"/"+comboAnIncio.getSelectedItem());
                        //conversion de fecha a Local Date Inicio
                        String localDateFinal = String.valueOf(comboDiaFinal.getSelectedItem()+"/"+
                                comboMesFinal.getSelectedItem()+"/"+comboAnFinal.getSelectedItem());
                        //conversion de fecha a Local Date Inicio
                        LocalDate localDate1 = LocalDate.parse(txtFecha.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        //creando instancia de Alquiler
                        Alquiler alquilerInmueble = new Alquiler((Cliente) ControladorArchivos.leerPersona(rutaRegistroCliente,
                                    String.valueOf(comboCuiAdquisisor.getSelectedItem())+"cn"), 
                                    (Cliente) ControladorArchivos.leerPersona(rutaRegistroCliente,
                                    String.valueOf(comboCuiPrestador.getSelectedItem())+"cn"),
                                    (Abogado) ControladorArchivos.leerPersona(rutaRegistroAbogado,
                                    String.valueOf(comboColegiadoAbogados.getSelectedItem())+"Abog")
                                    ,new Inmueble(txtDireccion.getText(),"Inmueble",Integer.valueOf(txtCostoMensual.getText())
                                    ),localDateInicio,localDateFinal,txtDiaPago.getText(),localDate1);
                              
                            //generando archivo
                            //se llama al contador de alquileres
                            ControladorArchivos archivo= new ControladorArchivos();
                            String contAlquileres;
                            if(archivo.buscarExistente("src/proyecto2/alquileres/"+"alquilerInmuebles"+".cont")){
                                //si existe se llama a su contador y se sigue el conteo                     
                                contAlquileres=archivo.lecturaBasica("src/proyecto2/alquileres/"+"alquilerInmuebles"+".cont");             
                            }
                            else{
                                //sino se crea el contador con valor inicial para el archivo
                                archivo.escrituraBasica("src/proyecto2/alquileres/"+"alquilerInmuebles"+".cont", String.valueOf(0)); 
            
                                //se llama a su contador y se sigue el conteo                                       
                                contAlquileres=archivo.lecturaBasica("src/proyecto2/alquileres/"+"alquilerInmuebles"+".cont");
                            }
                            //se convierte el contador recuperado y se aumenta debido a la nueva venta
                            int contadorLeido= Integer.parseInt(contAlquileres);
                            contadorLeido++;
                            archivo.guardarAlquiler("src/proyecto2/alquileres/", "alquiler", ".alquileres", alquilerInmueble, contadorLeido);
                            
                            //se guarda el contador
                            archivo.escrituraBasica("src/proyecto2/alquileres/"+"alquilerInmuebles"+".cont", String.valueOf(contadorLeido));
                            
                            resetearFormulario();
                            Documento documento= new Documento();
                            documento.crearDocumentoAlquiler(alquilerInmueble);
                            
                            //exportadorPDF.setVisible(true);
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

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // accion de boton Cancelar Formulario de abogado
        this.dispose();;
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtCostoMensualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoMensualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostoMensualActionPerformed

    private void txtPrestadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrestadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrestadorActionPerformed

    private void comboDiaPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDiaPagoActionPerformed
        // accion de combo dias de pago
        this.txtDiaPago.setText(String.valueOf(comboDiaPago.getSelectedItem()));
    }//GEN-LAST:event_comboDiaPagoActionPerformed

    private void btnAgregarClientePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarClientePActionPerformed
        // Accion de boton Agregar Clientes
        formularioCliente= new FormularioCliente(Proyecto2.ventanaPrincipal);
        formularioCliente.setVisible(true);
        if (cache.equals("")){
            //no actualizar el combo
        }else{
            DefaultComboBoxModel model=(DefaultComboBoxModel)comboCuiPrestador.getModel();
            model.addElement(cache);//actualizarlo
            cache="";
        }     
    }//GEN-LAST:event_btnAgregarClientePActionPerformed

    private void btnAgregarClienteAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarClienteAActionPerformed
        // Accion de boton Agregar Clientes
        formularioCliente= new FormularioCliente(Proyecto2.ventanaPrincipal);
        formularioCliente.setVisible(true);
        if (cache.equals("")){
            //no actualizar el combo
        }else{
            DefaultComboBoxModel model=(DefaultComboBoxModel)comboCuiAdquisisor.getModel();
            model.addElement(cache);//actualizarlo
            cache="";
        }     
    }//GEN-LAST:event_btnAgregarClienteAActionPerformed

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

    private void comboCuiPrestadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCuiPrestadorActionPerformed
        // accion de Combo Cui prestador
        persona=ControladorArchivos.leerPersona(rutaRegistroCliente,
                String.valueOf(comboCuiPrestador.getSelectedItem())+"cn");
        this.txtPrestador.setText(persona.getNombre()+" "+persona.getApellido());
    }//GEN-LAST:event_comboCuiPrestadorActionPerformed

    private void comboCuiAdquisisorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCuiAdquisisorActionPerformed
        // accion de Combo Cui Adquisisor
        persona=ControladorArchivos.leerPersona(rutaRegistroCliente,
                String.valueOf(comboCuiAdquisisor.getSelectedItem())+"cn");
        this.txtAdquisisor.setText(persona.getNombre()+" "+persona.getApellido());
    }//GEN-LAST:event_comboCuiAdquisisorActionPerformed

    private void comboColegiadoAbogadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboColegiadoAbogadosActionPerformed
        // accion de Combo Colegiados
        persona=ControladorArchivos.leerPersona(rutaRegistroAbogado,
                String.valueOf(comboColegiadoAbogados.getSelectedItem())+"Abog");
        this.txtAbogado.setText(persona.getNombre()+" "+persona.getApellido());
    }//GEN-LAST:event_comboColegiadoAbogadosActionPerformed
    // reseteo del Formulario
    protected void resetearFormulario(){
        txtCostoMensual.setText(""); txtDireccion.setText("");
        this.lbAlerta.setVisible(false);   
    }
    //cargando combos
    public void cargarCombos(){
        DefaultComboBoxModel model=(DefaultComboBoxModel)comboAnFinal.getModel();
        for(String An: listaYears){
            model.addElement(An);
        }   AutoCompleteDecorator.decorate(comboAnFinal);
        DefaultComboBoxModel model2=(DefaultComboBoxModel)comboAnIncio.getModel();
        for(String An: listaYears){
            model2.addElement(An);
        }   AutoCompleteDecorator.decorate(comboAnIncio);
        DefaultComboBoxModel model3=(DefaultComboBoxModel)comboDiaPago.getModel();
        for(String dias: listaDiasDePago){
            model3.addElement(dias);
        }   AutoCompleteDecorator.decorate(comboDiaPago);
        ControladorArchivos archivo= new ControladorArchivos();
        List<Persona> lista= new ArrayList<>();
        lista = archivo.leerPersonas(rutaRegistroCliente,"cn");
        
        DefaultComboBoxModel model4=(DefaultComboBoxModel)comboCuiPrestador.getModel();
        for(Persona prestador: lista){
            model4.addElement(((Cliente)prestador).getNumeroCui());
        }   AutoCompleteDecorator.decorate(comboCuiPrestador);
        DefaultComboBoxModel model5=(DefaultComboBoxModel)comboCuiAdquisisor.getModel();
        for(Persona adquisisor: lista){
            model5.addElement(((Cliente)adquisisor).getNumeroCui());
        }   AutoCompleteDecorator.decorate(comboCuiAdquisisor);
        
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
    private javax.swing.JButton btnAgregarClienteA;
    private javax.swing.JButton btnAgregarClienteP;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> comboAnFinal;
    private javax.swing.JComboBox<String> comboAnIncio;
    private javax.swing.JComboBox<String> comboColegiadoAbogados;
    private javax.swing.JComboBox<String> comboCuiAdquisisor;
    private javax.swing.JComboBox<String> comboCuiPrestador;
    private javax.swing.JComboBox<String> comboDiaFinal;
    private javax.swing.JComboBox<String> comboDiaInicio;
    private javax.swing.JComboBox<String> comboDiaPago;
    private javax.swing.JComboBox<String> comboMesFinal;
    private javax.swing.JComboBox<String> comboMesInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
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
    private javax.swing.JLabel lbAlerta;
    private javax.swing.JTextField txtAbogado;
    private javax.swing.JTextField txtAdquisisor;
    private javax.swing.JTextField txtCostoMensual;
    private javax.swing.JTextField txtDiaPago;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtPrestador;
    // End of variables declaration//GEN-END:variables
}
