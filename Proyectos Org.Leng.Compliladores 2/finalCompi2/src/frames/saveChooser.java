package frames;

import Objetos.ManejoDatos;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;



public class saveChooser extends javax.swing.JDialog {

    ManejoDatos manejoDatos;
    int tipo;
    
    public saveChooser(ManejoDatos manejoDatos,int tipo) {
        initComponents();
        this.manejoDatos = manejoDatos;
        this.tipo=tipo;
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        guardarChooser = new javax.swing.JFileChooser();

        setTitle("Guardar");

        guardarChooser.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        guardarChooser.setBackground(new java.awt.Color(7, 86, 100));
        guardarChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        guardarChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarChooserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(guardarChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(guardarChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarChooserActionPerformed
        try {
            String comando = evt.getActionCommand();
            if (comando.equals(JFileChooser.APPROVE_SELECTION)) {
                File fichero = guardarChooser.getSelectedFile();
                guardar(fichero);
            } else if (comando.equals(JFileChooser.CANCEL_SELECTION)) {
                this.setVisible(false);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se pudo guardar el codigo");
        }
    }//GEN-LAST:event_guardarChooserActionPerformed
    public boolean guardar(File fichero) throws IOException {
            if(tipo==1){
                crearArchivo(fichero.getAbsolutePath(), manejoDatos.getCodigo3d());
            }else if(tipo==2){
                crearArchivo(fichero.getAbsolutePath(), manejoDatos.getCodigoC());
                manejoDatos.addFileC(fichero);
            }else{
                crearArchivo(fichero.getAbsolutePath(), manejoDatos.contenido);
                manejoDatos.agregarFile(fichero);
            }
            
            JOptionPane.showMessageDialog(null, "Se ha guardado el archivo");
            this.setVisible(false);
            return true;
    }

    public void crearArchivo(String path, String texto) throws IOException {
        File archivo = new File(path);
        FileWriter escribir = new FileWriter(archivo);
        escribir.write(texto);
        escribir.close();
        archivo.createNewFile();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser guardarChooser;
    // End of variables declaration//GEN-END:variables
}
