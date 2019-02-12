/*
 * Formulario de Clientes
 */
package proyecto2.UI;

import java.awt.Color;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import proyecto2.Cliente;
import proyecto2.ControladorArchivos;
import static proyecto2.ControladorArchivos.rutaRegistroCliente;
import proyecto2.Persona;

/**
 *
 * @author bryan
 */
public class FormularioCliente extends javax.swing.JDialog {

    /**
     * Creates new form FormularioCliente
     */
    
     //variables a utilizar
    private static String generoElegido="";
    private static String estadoElegido="";
    private static Long numeroCui;
    
    //cargando listas
    public static List<String> listaMunicipios= ControladorArchivos.leerArchivo("src/proyecto2/archivos/municipios.txt");
    public static List<String> listaDepartamentos= ControladorArchivos.leerArchivo("src/proyecto2/archivos/departamentos.txt");
    public FormularioCliente(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        this.cargarCombos();
        this.setLocationRelativeTo(null);
        this.lbAlerta.setVisible(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        estado = new javax.swing.ButtonGroup();
        genero = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        comboDepartamentos = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        comboMunicipios = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtResidencia = new javax.swing.JTextField();
        txtCui = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rbtnFemenino = new javax.swing.JRadioButton();
        rbtnMasculino = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        rbtnCasado = new javax.swing.JRadioButton();
        rbtnSoltero = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbAlerta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(415, 485));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, -1, -1));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, -1, -1));

        jPanel1.add(comboDepartamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 343, 238, -1));

        jLabel9.setText("Departamento: ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 353, -1, -1));

        jPanel1.add(comboMunicipios, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 310, 238, -1));

        jLabel8.setText("Municipio: ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 315, 112, -1));
        jPanel1.add(txtResidencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 230, 270, -1));
        jPanel1.add(txtCui, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 93, 270, -1));
        jPanel1.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 49, 270, -1));
        jPanel1.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 8, 270, -1));

        jLabel7.setText("Lugar de Origen: ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 277, -1, -1));

        jLabel6.setText("Residencia: ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 232, 90, -1));

        genero.add(rbtnFemenino);
        rbtnFemenino.setText("Femenino");
        jPanel1.add(rbtnFemenino, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, -1, -1));

        genero.add(rbtnMasculino);
        rbtnMasculino.setText("Masculino");
        jPanel1.add(rbtnMasculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));

        jLabel5.setText("Genero: ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 185, 90, -1));

        estado.add(rbtnCasado);
        rbtnCasado.setText("Casado");
        jPanel1.add(rbtnCasado, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 101, -1));

        estado.add(rbtnSoltero);
        rbtnSoltero.setText("Soltero");
        jPanel1.add(rbtnSoltero, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 103, -1));

        jLabel4.setText("Estado Civil: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 139, -1, -1));

        jLabel3.setText("No. DPI (CUI): ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 95, -1, -1));

        jLabel2.setText("Apellidos: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 50, 97, -1));

        jLabel1.setText("Nombres: ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 8, 97, -1));

        lbAlerta.setForeground(new java.awt.Color(255, 0, 0));
        lbAlerta.setText("*.Alerta");
        jPanel1.add(lbAlerta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // Accion de boton cerrar
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
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
                        this.lbAlerta.setText("*. El CUI Ingresado no es valido, debe contener 12 digitos");
                        this.lbAlerta.setForeground(Color.RED); this.lbAlerta.setVisible(true);
                    }
                    else{//creando instancia de archivo, verificando si ya existe el Cui del cliente, generando nuevo cliente
                        ControladorArchivos archivo= new ControladorArchivos();
                        if (archivo.validarRegistro(rutaRegistroCliente,"."+String.valueOf(numeroCui)+"cn")==false) {
                            JOptionPane.showMessageDialog(null, "El Cliente que desea Agregar ya Existe!!");
                        }else{//sino se crea
                            Persona cliente= new Cliente(numeroCui, estadoElegido, generoElegido, txtResidencia.getText(),
                            String.valueOf(comboMunicipios.getSelectedItem()),String.valueOf(comboDepartamentos.getSelectedItem()),
                            txtNombres.getText(), txtApellidos.getText());
                            //almacenando cui en cache para posterior uso
                            cache=String.valueOf(numeroCui);
                            //generando archivo
                            archivo.guardarPersona(rutaRegistroCliente,cliente.getNombre()+
                                cliente.getApellido(), "."+((Cliente)cliente).getNumeroCui()+"cn",cliente);
                            resetearFormulario();
                            JOptionPane.showMessageDialog(null, "Registro Guardado Correctamente!!");
                            this.dispose();
                        }                                                
                    }                    
                }
                catch(NumberFormatException e){
                    this.lbAlerta.setText("*. El No.DPI(CUI) Ingresado no es un numero");
                    this.lbAlerta.setForeground(Color.RED); this.lbAlerta.setVisible(true);
                }

            }//En caso de no ser confirmados los datos
            if(confirmar==1) this.lbAlerta.setVisible(false);
            if(confirmar==2) resetearFormulario();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed
    //seleccion de estado y genero
    protected void seleccionEstadoGenero(){
        if(rbtnCasado.isSelected()) estadoElegido=rbtnCasado.getText();
        if(rbtnSoltero.isSelected()) estadoElegido=rbtnSoltero.getText();
        if(rbtnFemenino.isSelected()) generoElegido=rbtnFemenino.getText();
        if(rbtnMasculino.isSelected()) generoElegido=rbtnMasculino.getText();
    }
    // reseteo del Formulario
    protected void resetearFormulario(){
        txtCui.setText(""); txtNombres.setText(""); txtApellidos.setText("");
        estadoElegido="";   generoElegido=("");  txtResidencia.setText("");
        comboMunicipios.setSelectedIndex(0); comboDepartamentos.setSelectedIndex(0);
        this.lbAlerta.setVisible(false);   
    }
    //cargando combos
    public void cargarCombos(){
        DefaultComboBoxModel model=(DefaultComboBoxModel)comboMunicipios.getModel();
        for(String muni: listaMunicipios){
            model.addElement(muni);
        }   AutoCompleteDecorator.decorate(comboMunicipios);
        DefaultComboBoxModel model2=(DefaultComboBoxModel)comboDepartamentos.getModel();
        for(String dep: listaDepartamentos){
            model2.addElement(dep);
        }   AutoCompleteDecorator.decorate(comboDepartamentos);
    }
    public static String cache="";
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> comboDepartamentos;
    private javax.swing.JComboBox<String> comboMunicipios;
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
    private javax.swing.JLabel lbAlerta;
    private javax.swing.JRadioButton rbtnCasado;
    private javax.swing.JRadioButton rbtnFemenino;
    private javax.swing.JRadioButton rbtnMasculino;
    private javax.swing.JRadioButton rbtnSoltero;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCui;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtResidencia;
    // End of variables declaration//GEN-END:variables
}
