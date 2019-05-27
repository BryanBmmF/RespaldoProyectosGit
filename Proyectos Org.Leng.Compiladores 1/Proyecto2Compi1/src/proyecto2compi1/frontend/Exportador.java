/*
 * 
 */
package proyecto2compi1.frontend;

import proyecto2compi1.backend.archivos.ControladorDeArchivos;
import javax.swing.JFileChooser;

/**
 *
 * @author bryan
 */
public class Exportador extends javax.swing.JDialog {

    /**
     * Creates new form Exportador
     */
    public static final String TXT=".txt"; 
    public static final String DOCX=".docx";
    public static final String ODT=".odt";
    private String archivoTexto;
    public Exportador(java.awt.Frame parent,String archivoTexto) {
        super(parent, true);
        this.archivoTexto=archivoTexto;
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbExportTXT = new javax.swing.JLabel();
        lbExportWord = new javax.swing.JLabel();
        lbExportODT = new javax.swing.JLabel();
        lbEXportPDF = new javax.swing.JLabel();
        btnCanelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Guardar Como");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Documento texto plano TXT:");

        jLabel2.setText("Documento Word:");

        jLabel3.setText("Documento ODT  Libre Office:");

        jLabel4.setText("Documento PDF:");

        lbExportTXT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2compi1/frontend/img/export/copiar.png"))); // NOI18N
        lbExportTXT.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbExportTXT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbExportTXT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbExportTXTMouseClicked(evt);
            }
        });

        lbExportWord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2compi1/frontend/img/export/word.png"))); // NOI18N
        lbExportWord.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbExportWord.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbExportWord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbExportWordMouseClicked(evt);
            }
        });

        lbExportODT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2compi1/frontend/img/export/libre.png"))); // NOI18N
        lbExportODT.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbExportODT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbExportODT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbExportODTMouseClicked(evt);
            }
        });

        lbEXportPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto2compi1/frontend/img/export/pdf2.png"))); // NOI18N
        lbEXportPDF.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbEXportPDF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbEXportPDF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbEXportPDFMouseClicked(evt);
            }
        });

        btnCanelar.setText("Cancelar");
        btnCanelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCanelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(lbExportODT))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbEXportPDF)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbExportTXT)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(lbExportWord))
                        .addGap(41, 41, 41))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(btnCanelar)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbExportWord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbExportTXT, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbEXportPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbExportODT, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCanelar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbExportTXTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbExportTXTMouseClicked
        // TODO add your handling code here:
            guardarArchivoTipo(TXT);
            this.dispose();
    }//GEN-LAST:event_lbExportTXTMouseClicked

    private void lbExportWordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbExportWordMouseClicked
        // TODO add your handling code here:
            guardarArchivoTipo(DOCX);
            this.dispose();
    }//GEN-LAST:event_lbExportWordMouseClicked

    private void lbExportODTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbExportODTMouseClicked
        // TODO add your handling code here:
            guardarArchivoTipo(ODT);
            this.dispose();
    }//GEN-LAST:event_lbExportODTMouseClicked

    private void lbEXportPDFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEXportPDFMouseClicked
        // TODO add your handling code here:
            guardarArchivoPDF();
            this.dispose();
    }//GEN-LAST:event_lbEXportPDFMouseClicked

    private void btnCanelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanelarActionPerformed
        // TODO add your handling code here:
            this.dispose();
    }//GEN-LAST:event_btnCanelarActionPerformed
     //metodo para guardar un archivo txt docx odt
    private void guardarArchivoTipo(String exten) {
            ControladorDeArchivos controlador= new ControladorDeArchivos();
             /**llamamos el metodo que permite cargar la ventana*/
            JFileChooser file=new JFileChooser();
            file.showSaveDialog(this);
            controlador.exportarAarchivo(file.getSelectedFile(), archivoTexto,exten);
            controlador.setArch(null);
    }
    //export pdf
     private void guardarArchivoPDF() {
            ControladorDeArchivos controlador= new ControladorDeArchivos();
             /**llamamos el metodo que permite cargar la ventana*/
            JFileChooser file=new JFileChooser();
            file.showSaveDialog(this);
            controlador.exportarPDF(file.getSelectedFile(), archivoTexto);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCanelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbEXportPDF;
    private javax.swing.JLabel lbExportODT;
    private javax.swing.JLabel lbExportTXT;
    private javax.swing.JLabel lbExportWord;
    // End of variables declaration//GEN-END:variables
}
