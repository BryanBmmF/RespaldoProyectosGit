package frames;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Color;

/**
 *
 * @author teodoro
 */
public class ImportarFrame extends javax.swing.JDialog {
    Principal manejoDatos;
    int tipo;
    String texto = "";
    String titulo = "";
    private FileNameExtensionFilter extension;

    public ImportarFrame(Principal manejoDatos) {
        initComponents();
        this.fileChooser.setBackground(new Color(7, 86, 100));
        this.manejoDatos=manejoDatos;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();

        setBackground(new java.awt.Color(7, 86, 100));

        fileChooser.setBackground(new java.awt.Color(7, 86, 100));
        fileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileChooserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileChooserActionPerformed
        try {
            String comando = evt.getActionCommand();
            if (comando.equals(JFileChooser.APPROVE_SELECTION)) {
                File fichero = fileChooser.getSelectedFile();
                this.manejoDatos.textArea.setText(leerTexto(fichero)); 
                manejoDatos.manejoDatos.agregarFile(fichero); 
            }
            this.setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"No se pudo importar el archivo");
        }
    }//GEN-LAST:event_fileChooserActionPerformed
    
    public String leerTexto(File archivo) {
        String textos = "";
        try {
            String cadena;
            FileReader fileReader = new FileReader(archivo);
            BufferedReader bufRead = new BufferedReader(fileReader);
            while ((cadena = bufRead.readLine()) != null) {
                textos = textos + cadena + "\n";
            }
            bufRead.close();
            fileReader.close();
            JOptionPane.showMessageDialog(null, "Se ha abierto el archivo");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se pudo abrir el archivo");
        }
        return textos;
    }
    public String getText() {
        return texto;
    }

    public String getName() {
        return titulo;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser fileChooser;
    // End of variables declaration//GEN-END:variables
}
