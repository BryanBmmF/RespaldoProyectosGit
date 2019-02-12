/*
 * Listado de Clientes
 */
package proyecto2.UI;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import proyecto2.Cliente;
import proyecto2.ControladorArchivos;
import static proyecto2.ControladorArchivos.rutaRegistroCliente;
import proyecto2.Persona;

/**
 *
 * @author bryan
 */
public class ListadoClientes extends javax.swing.JDialog {

    /**
     * Creates new form ListadoClientes
     */
    public ListadoClientes(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        this.cargarTablaClientes();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Listado de Clientes");

        jButton1.setText("Imprimir Listado");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombres", "Apellidos", "No.DPI(CUI)", "Estado Civil", "Genero", "Residencia", "Municipio", "Departamento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaClientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addContainerGap(629, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 304, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(32, 32, 32))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(101, 101, 101)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(75, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseClicked

    }//GEN-LAST:event_tablaClientesMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //:
        try{
          MessageFormat header = new MessageFormat("Listado Abogados");
          MessageFormat fotter= new MessageFormat("Page(1,number,integer");
          
          tablaClientes.print(JTable.PrintMode.FIT_WIDTH,header,fotter);
      }catch(Exception e){
      
      }
    }//GEN-LAST:event_jButton1ActionPerformed
     //metodo para llenar tabla Clientes
    protected void cargarTablaClientes(){
        ControladorArchivos archivo= new ControladorArchivos();
        DefaultTableModel model= (DefaultTableModel)tablaClientes.getModel();
        List<Persona> lista= new ArrayList<>();
        lista = archivo.leerPersonas(rutaRegistroCliente,"cn");
        
        for(Persona cliente: lista){
            model.addRow(new Object[]{cliente.getNombre(),cliente.getApellido(),((Cliente)cliente).getNumeroCui()
            ,((Cliente)cliente).getEstadoCivil(),((Cliente)cliente).getGenero(),((Cliente)cliente).getResidencia()
            ,((Cliente)cliente).getMunicipio(),((Cliente)cliente).getDepartamento()});
        }                        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaClientes;
    // End of variables declaration//GEN-END:variables
}
