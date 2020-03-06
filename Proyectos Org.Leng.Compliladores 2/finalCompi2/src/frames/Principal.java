package frames;

import Objetos.ManejoDatos;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import Objetos.LineNumber;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal extends javax.swing.JFrame {

    public ManejoDatos manejoDatos;
    LineNumber numeroLinea;

    public Principal() {
        manejoDatos = new ManejoDatos();
        initComponents();
        numeroLinea = new LineNumber(textArea);
        jScrollPane1.setRowHeaderView(numeroLinea);
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        abrirMenu = new javax.swing.JMenuItem();
        guardarMenu = new javax.swing.JMenuItem();
        nuevoMenu = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        AnalizarButton = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(7, 86, 100));

        jPanel1.setBackground(new java.awt.Color(7, 86, 100));

        textArea.setColumns(20);
        textArea.setFont(new java.awt.Font("Ubuntu Light", 3, 18)); // NOI18N
        textArea.setRows(5);
        textArea.setBorder(null);
        jScrollPane1.setViewportView(textArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 936, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenuBar1.setBackground(new java.awt.Color(54, 54, 54));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jMenuBar1.setForeground(new java.awt.Color(7, 86, 100));

        jMenu1.setBackground(new java.awt.Color(22, 19, 7));
        jMenu1.setForeground(new java.awt.Color(254, 254, 254));
        jMenu1.setText("Archivos");

        abrirMenu.setBackground(new java.awt.Color(54, 54, 54));
        abrirMenu.setForeground(new java.awt.Color(254, 254, 254));
        abrirMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/abrir.png"))); // NOI18N
        abrirMenu.setText("Abrir");
        abrirMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirMenuActionPerformed(evt);
            }
        });
        jMenu1.add(abrirMenu);

        guardarMenu.setBackground(new java.awt.Color(54, 54, 54));
        guardarMenu.setForeground(new java.awt.Color(254, 254, 254));
        guardarMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/guardar.png"))); // NOI18N
        guardarMenu.setText("Guardar");
        guardarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarMenuActionPerformed(evt);
            }
        });
        jMenu1.add(guardarMenu);

        nuevoMenu.setBackground(new java.awt.Color(54, 54, 54));
        nuevoMenu.setForeground(new java.awt.Color(254, 254, 254));
        nuevoMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/nuevo2.png"))); // NOI18N
        nuevoMenu.setText("Nuevo");
        nuevoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoMenuActionPerformed(evt);
            }
        });
        jMenu1.add(nuevoMenu);

        jMenuBar1.add(jMenu1);

        jMenu3.setForeground(new java.awt.Color(254, 254, 254));
        jMenu3.setText("Edicion");

        jMenuItem3.setBackground(new java.awt.Color(54, 54, 54));
        jMenuItem3.setForeground(new java.awt.Color(254, 254, 254));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/copiar.png"))); // NOI18N
        jMenuItem3.setText("Copiar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem4.setBackground(new java.awt.Color(54, 54, 54));
        jMenuItem4.setForeground(new java.awt.Color(254, 254, 254));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/pegar.png"))); // NOI18N
        jMenuItem4.setText("Pegar");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem5.setBackground(new java.awt.Color(54, 54, 54));
        jMenuItem5.setForeground(new java.awt.Color(254, 254, 254));
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cortar.png"))); // NOI18N
        jMenuItem5.setText("Cortar");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuBar1.add(jMenu3);

        jMenu2.setForeground(new java.awt.Color(254, 254, 254));
        jMenu2.setText("analizar");

        AnalizarButton.setBackground(new java.awt.Color(54, 54, 54));
        AnalizarButton.setForeground(new java.awt.Color(254, 254, 254));
        AnalizarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/analizar.png"))); // NOI18N
        AnalizarButton.setText("Analizar y Generar");
        AnalizarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnalizarButtonActionPerformed(evt);
            }
        });
        jMenu2.add(AnalizarButton);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/analizar.png"))); // NOI18N
        jMenuItem1.setText("Ejecutar codigo C");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AnalizarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnalizarButtonActionPerformed
       // if (manejoDatos.getArchivo() == null) {
            manejoDatos.setContenido(textArea.getText());
            manejoDatos.analizarCodigo(this.textArea.getText());
        //} else {
            crearArchivo(manejoDatos.getArchivo().getPath(), this.textArea.getText());
        //}
    }//GEN-LAST:event_AnalizarButtonActionPerformed

    private void abrirMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirMenuActionPerformed
        new ImportarFrame(this).setVisible(true);
    }//GEN-LAST:event_abrirMenuActionPerformed

    private void nuevoMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoMenuActionPerformed
        this.textArea.setText("");
        this.manejoDatos.quitarArchivo();
    }//GEN-LAST:event_nuevoMenuActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        this.textArea.copy();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        this.textArea.paste();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        this.textArea.cut();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void guardarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarMenuActionPerformed
        this.manejoDatos.contenido=textArea.getText();
        if (manejoDatos.getArchivo() != null) {
            try {
                guardar(manejoDatos.getArchivo(), this.textArea.getText());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "No se puedo Guardar");
            }
        } else {
            new saveChooser(manejoDatos, 0).setVisible(true);
        }
    }//GEN-LAST:event_guardarMenuActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        File archivo = manejoDatos.getFileC();
        if (archivo != null) {
            Runtime terminal = Runtime.getRuntime();
            try {
                terminal.exec("gcc " + archivo.getAbsolutePath() + " -o " + archivo.getParent() + "/salida");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "error de compilacion");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Primero analize el codigo y genere el archivo .c");
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    public boolean guardar(File fichero, String text) throws IOException {
        crearArchivo(fichero.getAbsolutePath(), text);
        JOptionPane.showMessageDialog(this, "Se ha guardado el archivo");
        return true;
    }

    public void crearArchivo(String path, String texto){
        try {
            File archivo = new File(path);
            FileWriter escribir = new FileWriter(archivo);
            escribir.write(texto);
            escribir.close();
            archivo.createNewFile();
           // JOptionPane.showMessageDialog(this,"Se han guardado los cambios");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al realizar cambios");
        }
    }

    public String agregarNumero(int inicio, int fin) {
        String valor = "";
        for (int i = inicio; i < fin + 1; i++) {
            valor += i + "\n";
        }
        return valor;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AnalizarButton;
    private javax.swing.JMenuItem abrirMenu;
    private javax.swing.JMenuItem guardarMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem nuevoMenu;
    public javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
