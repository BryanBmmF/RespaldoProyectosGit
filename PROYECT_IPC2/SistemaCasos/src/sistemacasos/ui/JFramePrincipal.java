/*
 * Frame principal
 */
package sistemacasos.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author bryan
 */
public class JFramePrincipal extends javax.swing.JFrame {

    /**
     * Creates new form JFramePrincipal
     */
    //fecha del sistema
    public static LocalDate fechaActual;
    public static String userSistema;
    public JFramePrincipal() {
            initComponents();
            setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorioTrabajo = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbUser = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuAdminSistem = new javax.swing.JMenu();
        itemRegistrarUsers = new javax.swing.JMenuItem();
        itemNuevoEmpleado = new javax.swing.JMenuItem();
        itemAdminProyecto = new javax.swing.JMenuItem();
        itemNuevoCaso = new javax.swing.JMenuItem();
        itemAsignacionAdminProyecto = new javax.swing.JMenuItem();
        menuAdminProyect = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        itemAsignarCasos = new javax.swing.JMenuItem();
        itemAsignacionEtapas = new javax.swing.JMenuItem();
        menuDesarrollador = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuAcercaDe = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuSalir = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorioTrabajo.setBackground(new java.awt.Color(153, 153, 255));
        escritorioTrabajo.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 255, 204), new java.awt.Color(153, 255, 204)));
        escritorioTrabajo.setForeground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout escritorioTrabajoLayout = new javax.swing.GroupLayout(escritorioTrabajo);
        escritorioTrabajo.setLayout(escritorioTrabajoLayout);
        escritorioTrabajoLayout.setHorizontalGroup(
            escritorioTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        escritorioTrabajoLayout.setVerticalGroup(
            escritorioTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 623, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("User: ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(483, 2, -1, -1));

        lbUser.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 173, 20));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Sistema de Proyectos \"Code 'n Bugs\".");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 2, 367, -1));

        menuAdminSistem.setText("Administrador Sistema");

        itemRegistrarUsers.setText("Registrar Usuarios");
        itemRegistrarUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRegistrarUsersActionPerformed(evt);
            }
        });
        menuAdminSistem.add(itemRegistrarUsers);

        itemNuevoEmpleado.setText("Registrar Nuevo Empleado");
        itemNuevoEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevoEmpleadoActionPerformed(evt);
            }
        });
        menuAdminSistem.add(itemNuevoEmpleado);

        itemAdminProyecto.setText("Registrar Nuevo Proyecto");
        itemAdminProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAdminProyectoActionPerformed(evt);
            }
        });
        menuAdminSistem.add(itemAdminProyecto);

        itemNuevoCaso.setText("Registrar Nuevo Caso");
        itemNuevoCaso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevoCasoActionPerformed(evt);
            }
        });
        menuAdminSistem.add(itemNuevoCaso);

        itemAsignacionAdminProyecto.setText("Asignar Administrador Proyecto");
        itemAsignacionAdminProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAsignacionAdminProyectoActionPerformed(evt);
            }
        });
        menuAdminSistem.add(itemAsignacionAdminProyecto);

        jMenuBar1.add(menuAdminSistem);

        menuAdminProyect.setText("Administrador Proyecto");

        jMenuItem4.setText("Proyectos Asignados");
        menuAdminProyect.add(jMenuItem4);

        itemAsignarCasos.setText("Asignar Casos a Proyectos");
        itemAsignarCasos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAsignarCasosActionPerformed(evt);
            }
        });
        menuAdminProyect.add(itemAsignarCasos);

        itemAsignacionEtapas.setText("Asignacion de Etapas");
        itemAsignacionEtapas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAsignacionEtapasActionPerformed(evt);
            }
        });
        menuAdminProyect.add(itemAsignacionEtapas);

        jMenuBar1.add(menuAdminProyect);

        menuDesarrollador.setText("Desarrollador");
        menuDesarrollador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDesarrolladorActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Desarrollador del Sistema");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuDesarrollador.add(jMenuItem1);

        jMenuBar1.add(menuDesarrollador);

        menuAcercaDe.setText("Acerca De");
        menuAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAcercaDeActionPerformed(evt);
            }
        });

        jMenuItem2.setText("Info programa");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuAcercaDe.add(jMenuItem2);

        jMenuBar1.add(menuAcercaDe);

        menuSalir.setText("Salir");

        jMenuItem3.setText("cerrar sesion");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menuSalir.add(jMenuItem3);

        jMenuBar1.add(menuSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 899, Short.MAX_VALUE)
                    .addComponent(escritorioTrabajo))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(escritorioTrabajo)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAcercaDeActionPerformed
        // TODO add your handling code here:
         
    }//GEN-LAST:event_menuAcercaDeActionPerformed

    private void menuDesarrolladorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDesarrolladorActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_menuDesarrolladorActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
            // TODO add your handling code here:
            
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
            // TODO add your handling code here:
            JOptionPane.showMessageDialog(this, "Version del sistema: 1.0 \n Desarrollador: BMonzon@97", "Informacion", 1);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void itemNuevoEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevoEmpleadoActionPerformed
            // TODO add your handling code here:
            empleado = new FormNuevoEmpleado(this);
            empleado.setVisible(true);
    }//GEN-LAST:event_itemNuevoEmpleadoActionPerformed

    private void itemRegistrarUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRegistrarUsersActionPerformed
            //accion de menu Registrar Usuarios
            limpiaEs();
            //instanciando nuevo internal Frame
            JInFrameAsignacionUsuarios asignacion= new JInFrameAsignacionUsuarios();
            //agregando al panel de escritorio
            this.escritorioTrabajo.add(asignacion);
            asignacion.show();//visualizando
    }//GEN-LAST:event_itemRegistrarUsersActionPerformed

    private void itemAdminProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAdminProyectoActionPerformed
        // TODO add your handling code here:
            proyecto = new FormNuevoProyecto(this);
            proyecto.setVisible(true);
    }//GEN-LAST:event_itemAdminProyectoActionPerformed

    private void itemNuevoCasoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevoCasoActionPerformed
        // TODO add your handling code here:
            caso= new FormNuevoCaso(this);
            caso.setVisible(true);
    }//GEN-LAST:event_itemNuevoCasoActionPerformed

    private void itemAsignacionAdminProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAsignacionAdminProyectoActionPerformed
        // TODO add your handling code here:
            //accion de menu Registrar Usuarios
            limpiaEs();
            //instanciando nuevo internal Frame
            JInFrameAsigancionProyectos asignacion= new JInFrameAsigancionProyectos();
            //agregando al panel de escritorio
            this.escritorioTrabajo.add(asignacion);
            asignacion.show();//visualizando
    }//GEN-LAST:event_itemAsignacionAdminProyectoActionPerformed

    private void itemAsignarCasosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAsignarCasosActionPerformed
        // TODO add your handling code here:
             //accion de menu Registrar Usuarios
            limpiaEs();
            //instanciando nuevo internal Frame
            JInFrameAsignacionCasos asignacion= new JInFrameAsignacionCasos();
            //agregando al panel de escritorio
            this.escritorioTrabajo.add(asignacion);
            asignacion.show();//visualizando
    }//GEN-LAST:event_itemAsignarCasosActionPerformed

    private void itemAsignacionEtapasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAsignacionEtapasActionPerformed
        // TODO add your handling code here:
             //accion de menu Registrar Usuarios
            limpiaEs();
            //instanciando nuevo internal Frame
            JInFrameAsignacionEtapa asignacion= new JInFrameAsignacionEtapa();
            //agregando al panel de escritorio
            this.escritorioTrabajo.add(asignacion);
            asignacion.show();//visualizando
    }//GEN-LAST:event_itemAsignacionEtapasActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
            
            System.exit(0);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

        //metodo encargado de limpiar Panel de escritorio
        public void limpiaEs(){
                this.escritorioTrabajo.removeAll();
                this.escritorioTrabajo.repaint();
        }
        //habilitacion de Opciones
        public void paraAdminSistema(String user){
                menuAdminProyect.setEnabled(false);
                menuDesarrollador.setEnabled(false);
                userSistema=user;
                lbUser.setText(user);
        }
        public void paraAdminProyecto(String user){
                menuAdminSistem.setEnabled(false);
                menuDesarrollador.setEnabled(false);
                userSistema=user;
                lbUser.setText(user);
        }
        public void paraDesarrollador(String user){
                menuAdminProyect.setEnabled(false);
                menuAdminSistem.setEnabled(false);
                userSistema=user;
                lbUser.setText(user);
        }
        public static  String fechaActualDelSistema(){//metodo que devuelve fecha actual en el sistema
                fechaActual= LocalDate.now();
                //Convirtiendolo a String
                String date = fechaActual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));  
                return date;
        }
        public static String devolverUser(){
            return userSistema;
        }
    private FormAsignacionCaso asignacionCaso;
    private FormNuevoProyecto proyecto;
    private FormNuevoEmpleado empleado;
    private FormNuevoCaso caso;
    private LoginUsuario login;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorioTrabajo;
    private javax.swing.JMenuItem itemAdminProyecto;
    private javax.swing.JMenuItem itemAsignacionAdminProyecto;
    private javax.swing.JMenuItem itemAsignacionEtapas;
    private javax.swing.JMenuItem itemAsignarCasos;
    private javax.swing.JMenuItem itemNuevoCaso;
    private javax.swing.JMenuItem itemNuevoEmpleado;
    private javax.swing.JMenuItem itemRegistrarUsers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbUser;
    private javax.swing.JMenu menuAcercaDe;
    private javax.swing.JMenu menuAdminProyect;
    private javax.swing.JMenu menuAdminSistem;
    private javax.swing.JMenu menuDesarrollador;
    private javax.swing.JMenu menuSalir;
    // End of variables declaration//GEN-END:variables
}
