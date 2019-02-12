/*
 * Formulario de nuevo Abogado
 */
package proyecto2.UI;

import java.awt.Color;
import javax.swing.JOptionPane;
import proyecto2.Abogado;
import proyecto2.ControladorArchivos;
import static proyecto2.ControladorArchivos.rutaRegistroAbogado;
import proyecto2.Persona;
import static proyecto2.UI.FormularioCliente.cache;

/**
 *
 * @author bryan
 */
public class FormularioAbogado extends javax.swing.JDialog {

    /**
     * Creates new form FormularioAbogado
     */
    private int numeroColegiado;
    public FormularioAbogado(java.awt.Frame parent) {
        super(parent,true);
        initComponents();
        this.lbAlerta.setVisible(false);
        this.setLocationRelativeTo(null);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        comboTitulo = new javax.swing.JComboBox<>();
        txtNoColegiado = new javax.swing.JTextField();
        btnGuardarAbogado = new javax.swing.JButton();
        btnCancelarFormAbog = new javax.swing.JButton();
        lbAlerta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Abogado");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
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
        jPanel1.add(comboTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 105, 119, -1));
        jPanel1.add(txtNoColegiado, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 153, 208, -1));

        btnGuardarAbogado.setText("Guardar");
        btnGuardarAbogado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarAbogadoActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardarAbogado, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 206, -1, -1));

        btnCancelarFormAbog.setText("Cancelar");
        btnCancelarFormAbog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarFormAbogActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelarFormAbog, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 206, -1, -1));

        lbAlerta.setForeground(new java.awt.Color(255, 0, 0));
        lbAlerta.setText("*.Alerta");
        jPanel1.add(lbAlerta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 240, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarFormAbogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarFormAbogActionPerformed
        // accion de boton Cancelar Formulario de abogado
        this.dispose();
    }//GEN-LAST:event_btnCancelarFormAbogActionPerformed

    private void btnGuardarAbogadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarAbogadoActionPerformed
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
                            //almacenando colegiado en cache para posterior uso
                            cache=String.valueOf(numeroColegiado);
                            //generando archivo
                            archivo.guardarPersona(rutaRegistroAbogado,abogado.getNombre()+
                                abogado.getApellido(), "."+((Abogado)abogado).getNumeroColegiado()+"Abog",abogado);
                            resetearFormulario();
                            JOptionPane.showMessageDialog(null, "Registro Guardado Correctamente!!");
                            this.dispose();                       
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
    }//GEN-LAST:event_btnGuardarAbogadoActionPerformed
    // reseteo del Formulario
    protected void resetearFormulario(){
        txtNoColegiado.setText(""); txtNombres.setText(""); txtApellidos.setText("");
        comboTitulo.setSelectedIndex(0);
        this.lbAlerta.setVisible(false);   
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarFormAbog;
    private javax.swing.JButton btnGuardarAbogado;
    private javax.swing.JComboBox<String> comboTitulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbAlerta;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtNoColegiado;
    private javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables
}
