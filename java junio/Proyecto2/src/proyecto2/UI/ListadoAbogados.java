/*
 * listado de abogados
 */
package proyecto2.UI;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import proyecto2.Abogado;
import proyecto2.ControladorArchivos;
import static proyecto2.ControladorArchivos.rutaRegistroAbogado;
import proyecto2.Persona;

/**
 *
 * @author bryan
 */
public class ListadoAbogados extends javax.swing.JDialog {

    /**
     * Creates new form ListadoAbogados
     */
    public ListadoAbogados(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        this.cargarTablaAbogados();
        this.setLocationRelativeTo(null);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tablaAbogados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tablaAbogados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombres", "Apellidos", "TItulo Univ.", "No.Colegiado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaAbogados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaAbogadosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaAbogados);

        jLabel1.setText("Listado de Abogados");

        jButton1.setText("Imprimir Listado");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                        .addGap(14, 14, 14))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton1)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tablaAbogadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAbogadosMouseClicked
    
    }//GEN-LAST:event_tablaAbogadosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      try{
          MessageFormat header = new MessageFormat("Listado Abogados");
          MessageFormat fotter= new MessageFormat("Page(1,number,integer");
          
          tablaAbogados.print(JTable.PrintMode.FIT_WIDTH,header,fotter);
      }catch(Exception e){
      
      }
    }//GEN-LAST:event_jButton1ActionPerformed
    //metodo para llenar tabla Abogados
    protected void cargarTablaAbogados(){
        ControladorArchivos archivo= new ControladorArchivos();
        DefaultTableModel model= (DefaultTableModel)tablaAbogados.getModel();
        List<Persona> lista= new ArrayList<>();
        lista = archivo.leerPersonas(rutaRegistroAbogado,"Abog");
        
        for(Persona abogado: lista){
            model.addRow(new Object[]{abogado.getNombre(),abogado.getApellido(),
                ((Abogado)abogado).getTitulo(),((Abogado)abogado).getNumeroColegiado()});
        }                        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaAbogados;
    // End of variables declaration//GEN-END:variables
}
