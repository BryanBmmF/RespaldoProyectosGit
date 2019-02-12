/*
 * Interfaz del Escritorio de trabajo
 */
package proyectofinal.interfaz;

import javax.swing.JOptionPane;


/**
 *
 * @author bryan
 */
public class Escritorio extends javax.swing.JFrame {
    /**
     * Creates new form escritorio
     */
    public Escritorio() {
        initComponents();
        setLocationRelativeTo(null);
  
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorioDeTrabajo = new javax.swing.JDesktopPane();
        titulo = new javax.swing.JLabel();
        ventas = new javax.swing.JLabel();
        fabrica = new javax.swing.JLabel();
        finanzas = new javax.swing.JLabel();
        admon1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbUser = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        cargarArchivo = new javax.swing.JMenuItem();
        menuFabrica = new javax.swing.JMenu();
        menuMateriaprima = new javax.swing.JMenuItem();
        menuEnsamble = new javax.swing.JMenuItem();
        menuVentas = new javax.swing.JMenu();
        menuAdmon = new javax.swing.JMenu();
        menuFinanzas = new javax.swing.JMenu();
        opcionAcercaDe = new javax.swing.JMenu();
        infoDes = new javax.swing.JMenuItem();
        opcionSalir = new javax.swing.JMenu();
        exitAp = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorioDeTrabajo.setBackground(new java.awt.Color(204, 204, 204));
        escritorioDeTrabajo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        escritorioDeTrabajo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        titulo.setFont(new java.awt.Font("Abyssinica SIL", 1, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(0, 0, 0));
        titulo.setText(" \"Mi Muebleria\"");

        ventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinal/fabrica/imagenes/vendedor.png"))); // NOI18N
        ventas.setText("Ventas");
        ventas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ventas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ventasMouseClicked(evt);
            }
        });

        fabrica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinal/fabrica/imagenes/fabrica.png"))); // NOI18N
        fabrica.setText("Fabrica");
        fabrica.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fabrica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fabricaMouseClicked(evt);
            }
        });
        fabrica.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                fabricaInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });

        finanzas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinal/fabrica/imagenes/finanzas.png"))); // NOI18N
        finanzas.setText("Finanzas");
        finanzas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        finanzas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                finanzasMouseClicked(evt);
            }
        });

        admon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinal/fabrica/imagenes/admon.png"))); // NOI18N
        admon1.setText("Administracion");
        admon1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        admon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admon1MouseClicked(evt);
            }
        });

        escritorioDeTrabajo.setLayer(titulo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorioDeTrabajo.setLayer(ventas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorioDeTrabajo.setLayer(fabrica, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorioDeTrabajo.setLayer(finanzas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorioDeTrabajo.setLayer(admon1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioDeTrabajoLayout = new javax.swing.GroupLayout(escritorioDeTrabajo);
        escritorioDeTrabajo.setLayout(escritorioDeTrabajoLayout);
        escritorioDeTrabajoLayout.setHorizontalGroup(
            escritorioDeTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioDeTrabajoLayout.createSequentialGroup()
                .addGroup(escritorioDeTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(escritorioDeTrabajoLayout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(titulo))
                    .addGroup(escritorioDeTrabajoLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(fabrica, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(admon1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(escritorioDeTrabajoLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(ventas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(finanzas, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        escritorioDeTrabajoLayout.setVerticalGroup(
            escritorioDeTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioDeTrabajoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(escritorioDeTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fabrica, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(escritorioDeTrabajoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(admon1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(escritorioDeTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ventas, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(finanzas, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbUser.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Usuario:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbUser, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lbUser)
                .addComponent(jLabel1))
        );

        menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        menuArchivo.setText("Archivo");
        menuArchivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        cargarArchivo.setText("Cargar Archivo");
        cargarArchivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cargarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarArchivoActionPerformed(evt);
            }
        });
        menuArchivo.add(cargarArchivo);

        menu.add(menuArchivo);

        menuFabrica.setText("Fabrica");

        menuMateriaprima.setText("Materia Prima");
        menuMateriaprima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMateriaprimaActionPerformed(evt);
            }
        });
        menuFabrica.add(menuMateriaprima);

        menuEnsamble.setText("Ensamble");
        menuEnsamble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEnsambleActionPerformed(evt);
            }
        });
        menuFabrica.add(menuEnsamble);

        menu.add(menuFabrica);

        menuVentas.setText("Ventas");
        menu.add(menuVentas);

        menuAdmon.setText("Administracion");
        menu.add(menuAdmon);

        menuFinanzas.setText("Finanzas");
        menu.add(menuFinanzas);

        opcionAcercaDe.setText("Acerca De");
        opcionAcercaDe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opcionAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionAcercaDeActionPerformed(evt);
            }
        });

        infoDes.setText("Info.Desarrollador");
        infoDes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        infoDes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoDesActionPerformed(evt);
            }
        });
        opcionAcercaDe.add(infoDes);

        menu.add(opcionAcercaDe);

        opcionSalir.setText("Salir");
        opcionSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionSalirActionPerformed(evt);
            }
        });

        exitAp.setText("Cerrar Aolicacion");
        exitAp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitAp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitApActionPerformed(evt);
            }
        });
        opcionSalir.add(exitAp);

        menu.add(opcionSalir);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(escritorioDeTrabajo)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(escritorioDeTrabajo)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fabricaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fabricaMouseClicked
        //accion de etiqueta fabrica
        limpiaEs();
        //instanciando nuevo internal Frame CargaArchivos
        FMateriaPrima materiaPrim= new FMateriaPrima();      
         //agregando al panel de escritorio
        this.escritorioDeTrabajo.add(materiaPrim);
        materiaPrim.show();//visualizando
    }//GEN-LAST:event_fabricaMouseClicked

    private void fabricaInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_fabricaInputMethodTextChanged

    }//GEN-LAST:event_fabricaInputMethodTextChanged

    private void opcionSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionSalirActionPerformed
        
    }//GEN-LAST:event_opcionSalirActionPerformed

    private void opcionAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionAcercaDeActionPerformed
       
    }//GEN-LAST:event_opcionAcercaDeActionPerformed

    private void exitApActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitApActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitApActionPerformed

    private void infoDesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoDesActionPerformed
         //informacion del desarrollador
        JOptionPane.showMessageDialog(null, "Bryan Misael Monzon Fuentes\n"
                + "Experiencia: 6 meses\n"
                + "USAC-CUNOC 2018");
    }//GEN-LAST:event_infoDesActionPerformed

    private void finanzasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finanzasMouseClicked
        //accion de etiqueta finanzas
       limpiaEs();
    }//GEN-LAST:event_finanzasMouseClicked

    private void ventasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ventasMouseClicked
        //accion de etiqueta ventas
       limpiaEs();

    }//GEN-LAST:event_ventasMouseClicked

    private void admon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admon1MouseClicked
        // TODO add your handling code here:
        limpiaEs();
    }//GEN-LAST:event_admon1MouseClicked

    private void cargarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarArchivoActionPerformed
         //accion de menu Archivo
        limpiaEs();
        //instanciando nuevo internal Frame CargaArchivos
        CargaArchivos carga= new CargaArchivos();      
         //agregando al panel de escritorio
        this.escritorioDeTrabajo.add(carga);
        carga.show();//visualizando
    }//GEN-LAST:event_cargarArchivoActionPerformed
    
    private void menuEnsambleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEnsambleActionPerformed
        limpiaEs();    
        FaEnsable ensamble= new FaEnsable();
        //agregando al panel de escritorio
        this.escritorioDeTrabajo.add(ensamble);
        //estableciendo fecha y usuario activo
        ensamble.date();
        ensamble.user(lbUser.getText());
        ensamble.show();//visualizando
    }//GEN-LAST:event_menuEnsambleActionPerformed

    private void menuMateriaprimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMateriaprimaActionPerformed
        //accion de menuItem fabrica
        limpiaEs();
        //instanciando nuevo internal Frame Fabrica
        FMateriaPrima materiaPrim= new FMateriaPrima();      
         //agregando al panel de escritorio
        this.escritorioDeTrabajo.add(materiaPrim);
        materiaPrim.show();//visualizando
    }//GEN-LAST:event_menuMateriaprimaActionPerformed
    //metodo encargado de limpiar Panel de escritorio
    public void limpiaEs(){
        this.escritorioDeTrabajo.removeAll();
        this.escritorioDeTrabajo.repaint();
    }
    //metodo de habilitacion de escritorio
    public void paraFabrica(String user){     
        ventas.setEnabled(false);
        admon1.setEnabled(false);
        finanzas.setEnabled(false);
        menuVentas.setEnabled(false);
        menuAdmon.setEnabled(false);
        menuFinanzas.setEnabled(false);
        menuArchivo.setEnabled(false);
        lbUser.setToolTipText(user);
        lbUser.setText(user);
    
    }
    public void paraVentas(String user){
        fabrica.setEnabled(false);
        admon1.setEnabled(false);
        finanzas.setEnabled(false);
        menuFabrica.setEnabled(false);
        menuAdmon.setEnabled(false);
        menuFinanzas.setEnabled(false);
        menuArchivo.setEnabled(false);
        lbUser.setToolTipText(user);
        lbUser.setText(user);
    }
    public void paraAdmon(String user){
        fabrica.setEnabled(false);
        ventas.setEnabled(false);
        menuFabrica.setEnabled(false);
        menuVentas.setEnabled(false);
        lbUser.setToolTipText(user);
        lbUser.setText(user);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel admon1;
    private javax.swing.JMenuItem cargarArchivo;
    private javax.swing.JDesktopPane escritorioDeTrabajo;
    private javax.swing.JMenuItem exitAp;
    private javax.swing.JLabel fabrica;
    private javax.swing.JLabel finanzas;
    private javax.swing.JMenuItem infoDes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbUser;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu menuAdmon;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenuItem menuEnsamble;
    private javax.swing.JMenu menuFabrica;
    private javax.swing.JMenu menuFinanzas;
    private javax.swing.JMenuItem menuMateriaprima;
    private javax.swing.JMenu menuVentas;
    private javax.swing.JMenu opcionAcercaDe;
    private javax.swing.JMenu opcionSalir;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel ventas;
    // End of variables declaration//GEN-END:variables
}

