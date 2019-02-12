/*
 * Formulario de Autenticas
 */
package proyecto2.UI;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import proyecto2.Abogado;
import proyecto2.Autentica;
import proyecto2.Cliente;
import proyecto2.ControladorArchivos;
import static proyecto2.ControladorArchivos.rutaRegistroAbogado;
import static proyecto2.ControladorArchivos.rutaRegistroCliente;
import proyecto2.Documento;
import proyecto2.Persona;
import proyecto2.Proyecto2;
import static proyecto2.UI.FormularioCliente.cache;
import static proyecto2.UI.FramePrincipal.fechaActualDelSistema;

/**
 *
 * @author bryan
 */
public class FormularioAutenticas extends javax.swing.JDialog {

    /**
     * Creates new form FormularioAutenticas
     */
    public FormularioAutenticas(java.awt.Frame parent) {
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
        comboCuiClientes = new javax.swing.JComboBox<>();
        comboColegiadoAbogados = new javax.swing.JComboBox<>();
        btnAgregarCliente = new javax.swing.JButton();
        btnAgregarAbogado = new javax.swing.JButton();
        txtCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAbogado = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Autentica de DPI");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Cliente: ");

        jLabel2.setText("Abogado: ");

        jLabel4.setText("Fecha: ");

        txtFecha.setEditable(false);

        btnGuardar.setText("Crear Autentica");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lbAlerta.setForeground(new java.awt.Color(255, 0, 0));
        lbAlerta.setText("*.Alerta");

        comboCuiClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCuiClientesActionPerformed(evt);
            }
        });

        comboColegiadoAbogados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboColegiadoAbogadosActionPerformed(evt);
            }
        });

        btnAgregarCliente.setText("+.Agregar");
        btnAgregarCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarClienteActionPerformed(evt);
            }
        });

        btnAgregarAbogado.setText("+.Agregar");
        btnAgregarAbogado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregarAbogado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAbogadoActionPerformed(evt);
            }
        });

        txtCliente.setEditable(false);

        jLabel3.setText("No.DPI: ");

        txtAbogado.setEditable(false);

        jLabel5.setText("No.Colegiado: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboCuiClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregarCliente)
                .addGap(12, 33, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbAlerta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(122, 122, 122))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtAbogado, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAgregarAbogado))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comboColegiadoAbogados, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnGuardar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnCancelar)
                                        .addGap(96, 96, 96))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(90, 90, 90))))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboCuiClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAbogado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarAbogado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboColegiadoAbogados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lbAlerta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap(17, Short.MAX_VALUE))
        );

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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //se verifica si ya estan seleccionados los campos estado y genero
        //se confirman los datos y se procede a guardarlos
            int confirmar = JOptionPane.showConfirmDialog(null, "Esta Seguro de Generar esta Autentica de DPI?");
            if (confirmar==0) {
                //conversion de fecha a Local Date
                LocalDate localDate1 = LocalDate.parse(txtFecha.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                //creando instancia de ventaVehiculo
                Autentica aut = new Autentica((Cliente) ControladorArchivos.leerPersona(rutaRegistroCliente,
                String.valueOf(comboCuiClientes.getSelectedItem())+"cn"),
                    (Abogado) ControladorArchivos.leerPersona(rutaRegistroAbogado,
                        String.valueOf(comboColegiadoAbogados.getSelectedItem())+"Abog"),localDate1);
                            
               //generando archivo
                //se llama al contador de Autenticas
                ControladorArchivos archivo= new ControladorArchivos();
                String contVentas;
                if(archivo.buscarExistente("src/proyecto2/autenticas/"+"autentica"+".cont")){
                    //si existe se llama a su contador y se sigue el conteo                     
                    contVentas=archivo.lecturaBasica("src/proyecto2/autenticas/"+"autentica"+".cont");             
                }
                else{
                    //sino se crea el contador con valor inicial para el archivo
                    archivo.escrituraBasica("src/proyecto2/autenticas/"+"autentica"+".cont", String.valueOf(0)); 
            
                    //se llama a su contador y se sigue el conteo                                       
                    contVentas=archivo.lecturaBasica("src/proyecto2/autenticas/"+"autentica"+".cont");
                }
                //se convierte el contador recuperado y se aumenta debido a la nueva venta
                int contadorLeido= Integer.parseInt(contVentas);
                contadorLeido++;
                archivo.guardarAutentica("src/proyecto2/autenticas/", "autenticaDPI", ".auten", aut, contadorLeido);
                            
                 //se guarda el contador
                archivo.escrituraBasica("src/proyecto2/ventas/"+"ventasVehiculos"+".cont", String.valueOf(contadorLeido));
                            
                Documento documento= new Documento();
                documento.crearDocumentoAutentica(aut);
                //exportadorPDF.setVisible(true);
                this.dispose();

            }//En caso de no ser confirmados los datos
            if(confirmar==1) this.lbAlerta.setVisible(false);
            if(confirmar==2)this.lbAlerta.setVisible(false);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // accion de boton Cancelar Formulario de abogado
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarClienteActionPerformed
        // Accion de Menu Agregar Clientes
        formularioCliente= new FormularioCliente(Proyecto2.ventanaPrincipal);
        formularioCliente.setVisible(true);
        if (cache.equals("")){
            //no actualizar el combo
        }else{
            DefaultComboBoxModel model=(DefaultComboBoxModel)comboCuiClientes.getModel();
            model.addElement(cache);//actualizarlo
            cache="";
        }     
    }//GEN-LAST:event_btnAgregarClienteActionPerformed

    private void btnAgregarAbogadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAbogadoActionPerformed
        //accion de boton agragar abogado
        formularioAbogado= new FormularioAbogado(Proyecto2.ventanaPrincipal);
        formularioAbogado.setVisible(true);
        if (cache.equals("")){
            //no actualizar el combo
        }else{
            DefaultComboBoxModel model=(DefaultComboBoxModel)comboColegiadoAbogados.getModel();
            model.addElement(cache);
            cache="";
        }        
    }//GEN-LAST:event_btnAgregarAbogadoActionPerformed

    private void comboCuiClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCuiClientesActionPerformed
        // accion de Combo Clientes
        persona=ControladorArchivos.leerPersona(rutaRegistroCliente,
                String.valueOf(comboCuiClientes.getSelectedItem())+"cn");
        this.txtCliente.setText(persona.getNombre()+" "+persona.getApellido());
    }//GEN-LAST:event_comboCuiClientesActionPerformed

    private void comboColegiadoAbogadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboColegiadoAbogadosActionPerformed
        // accion de Combo Colegiados
        persona=ControladorArchivos.leerPersona(rutaRegistroAbogado,
                String.valueOf(comboColegiadoAbogados.getSelectedItem())+"Abog");
        this.txtAbogado.setText(persona.getNombre()+" "+persona.getApellido());
    }//GEN-LAST:event_comboColegiadoAbogadosActionPerformed
    public void cargarCombos(){
        ControladorArchivos archivo= new ControladorArchivos();
        List<Persona> lista= new ArrayList<>();
        lista = archivo.leerPersonas(rutaRegistroCliente,"cn");
        
        DefaultComboBoxModel model5=(DefaultComboBoxModel)comboCuiClientes.getModel();
        for(Persona adquisisor: lista){
            model5.addElement(((Cliente)adquisisor).getNumeroCui());
        }   AutoCompleteDecorator.decorate(comboCuiClientes);
        
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
    private javax.swing.JButton btnAgregarCliente;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> comboColegiadoAbogados;
    private javax.swing.JComboBox<String> comboCuiClientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbAlerta;
    private javax.swing.JTextField txtAbogado;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtFecha;
    // End of variables declaration//GEN-END:variables
}
