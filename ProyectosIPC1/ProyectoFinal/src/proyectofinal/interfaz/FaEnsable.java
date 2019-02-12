/*
 * 
 */
package proyectofinal.interfaz;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import proyectofinal.fabrica.archivo.Archivo;
import proyectofinal.fabrica.produccion.Ensamble;
import proyectofinal.fabrica.produccion.Mueble;
import proyectofinal.fabrica.usuarios.Usuario;
import proyectofinal.fabrica.ventas.AreaDeVenta;
import static proyectofinal.fabrica.ventas.AreaDeVenta.RUTA_MUEBLESVENTA;

/**
 *
 * @author bryan
 */
public class FaEnsable extends javax.swing.JInternalFrame {
    
    private LocalDate fecha;
    /**
     * Creates new form FaEnsable
     */
    public FaEnsable() {
        initComponents();
    }
    
     private List<Mueble> listaMuebles = Mueble.listaMuebles();

    
    public List<Mueble> getListaMuebles() {
        return listaMuebles;
    }

    public void setListaMuebles(List<Mueble> listaMuebles) {
        List<Mueble> anterior= this.listaMuebles;
        this.listaMuebles = listaMuebles;
        firePropertyChange("listaMuebles", anterior, listaMuebles);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUserEnsamble = new javax.swing.JTextField();
        txtFechaEnsamble = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtIdentMueble = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCostoFabrica = new javax.swing.JTextField();
        btnEnsamble = new javax.swing.JButton();
        txtCostoVenta = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnRegistroParaVenta = new javax.swing.JButton();
        txtNombreMuebleEnsamble = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListMuebles = new javax.swing.JList<>();
        jLabel8 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nuevo Ensamble");

        jLabel2.setText("Tipo de Mueble: ");

        jLabel3.setText("Usuario: ");

        jLabel5.setText("Fecha: ");

        txtUserEnsamble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserEnsambleActionPerformed(evt);
            }
        });

        jLabel4.setText("Identificador:");

        txtIdentMueble.setEditable(false);

        jLabel6.setText("Costo de Fab.");

        txtCostoFabrica.setEditable(false);

        btnEnsamble.setText("Ensamblar");
        btnEnsamble.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEnsamble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnsambleActionPerformed(evt);
            }
        });

        txtCostoVenta.setEditable(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jListMuebles, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.precioNuevoMueble}"), txtCostoVenta, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel7.setText("Costo de Venta:");

        btnRegistroParaVenta.setText("Registrar");
        btnRegistroParaVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistroParaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroParaVentaActionPerformed(evt);
            }
        });

        txtNombreMuebleEnsamble.setEditable(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jListMuebles, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.nombreNuevoMueble}"), txtNombreMuebleEnsamble, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jListMuebles.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listaMuebles}");
        org.jdesktop.swingbinding.JListBinding jListBinding = org.jdesktop.swingbinding.SwingBindings.createJListBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jListMuebles);
        jListBinding.setDetailBinding(org.jdesktop.beansbinding.ELProperty.create("${nombreNuevoMueble}"));
        bindingGroup.addBinding(jListBinding);

        jScrollPane1.setViewportView(jListMuebles);

        jLabel8.setText("Muebles");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEnsamble, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUserEnsamble, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                            .addComponent(txtFechaEnsamble)
                            .addComponent(txtIdentMueble)
                            .addComponent(txtCostoFabrica)
                            .addComponent(txtCostoVenta)
                            .addComponent(btnRegistroParaVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNombreMuebleEnsamble))))
                .addGap(122, 122, 122))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNombreMuebleEnsamble, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtUserEnsamble, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtFechaEnsamble, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtIdentMueble, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtCostoFabrica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnEnsamble))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCostoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistroParaVenta)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserEnsambleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserEnsambleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserEnsambleActionPerformed

    private void btnEnsambleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnsambleActionPerformed
        if(txtFechaEnsamble.getText().isEmpty()||txtUserEnsamble.getText().isEmpty()){
            
            JOptionPane.showMessageDialog(null, "Se requiere de todos los campos \n para realizar el ensamble");
        
        }
        else{
            Ensamble ensamble= new Ensamble(new Mueble(txtNombreMuebleEnsamble.getText()),
            new Usuario(txtUserEnsamble.getText()), txtFechaEnsamble.getText());
            
            String identificador=ensamble.revisarEnsamble();
            
            if(identificador!=null){
                txtIdentMueble.setText(identificador);
                String costo= String.valueOf(ensamble.eliminaPiezasGeneraCosto());
                txtCostoFabrica.setText(costo);
                JOptionPane.showMessageDialog(null, "Ensamble Completado!!");
            }
            
        }
        
    }//GEN-LAST:event_btnEnsambleActionPerformed

    private void btnRegistroParaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroParaVentaActionPerformed
        Archivo archivo= new Archivo();
        
        if(archivo.buscarExistente(RUTA_MUEBLESVENTA+txtIdentMueble.getText()+".VEN")){
            JOptionPane.showMessageDialog(null, "El Mueble con el identificador actual\n ya ha sido Registrado");
        }
        else{
            
            try{AreaDeVenta registrarMueble= new AreaDeVenta(new Mueble(txtNombreMuebleEnsamble.getText()),
                Double.parseDouble(txtCostoVenta.getText()),Double.parseDouble(txtCostoFabrica.getText()),txtIdentMueble.getText());
                registrarMueble.registrarMuebles();
                JOptionPane.showMessageDialog(null, "Registro en Sala de Ventas Completado");
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Todos los campos deben ser completados\n para realizar el registro");
        }
        
        }
        
    }//GEN-LAST:event_btnRegistroParaVentaActionPerformed

    public void user(String user){
        txtUserEnsamble.setText(user);
        
    }
    public void date(){
        this.fecha= LocalDate.now();
        
        //Convirtiendolo a String
        String date = fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        txtFechaEnsamble.setText(date);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnsamble;
    private javax.swing.JButton btnRegistroParaVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jListMuebles;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCostoFabrica;
    private javax.swing.JTextField txtCostoVenta;
    private javax.swing.JTextField txtFechaEnsamble;
    private javax.swing.JTextField txtIdentMueble;
    private javax.swing.JTextField txtNombreMuebleEnsamble;
    private javax.swing.JTextField txtUserEnsamble;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
