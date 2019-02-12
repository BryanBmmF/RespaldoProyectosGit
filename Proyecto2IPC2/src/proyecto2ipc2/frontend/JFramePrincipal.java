/*
 * Frame principal
 */
package proyecto2ipc2.frontend;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import proyecto2ipc2.frontend.Forms.FormCRUDHotel;
import proyecto2ipc2.frontend.Forms.FormCRUDReservacion;
import proyecto2ipc2.frontend.Forms.FormCRUDRestaurante;
import proyecto2ipc2.frontend.Forms.FormCRUDUMenu;
import proyecto2ipc2.frontend.Forms.FormCRUDUser;
import proyecto2ipc2.frontend.Forms.FormCRUDHabitacion;
import proyecto2ipc2.frontend.Forms.FormCRUDPedidos;
import proyecto2ipc2.frontend.Forms.FormCheckIn;
import proyecto2ipc2.frontend.Forms.FormCheckOut;
import proyecto2ipc2.frontend.Forms.FormEmpleadosRestaurante;
import proyecto2ipc2.frontend.Forms.FormExtenderReservacion;

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
    public static String nombreEstablecimiento;
    public static int idEstablecimiento;
    public JFramePrincipal() {
            initComponents();
            setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        escritorioTrabajo = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbUser = new javax.swing.JLabel();
        lbIdEstablecim = new javax.swing.JLabel();
        lbNombreEstablecim = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuGerentes = new javax.swing.JMenu();
        itemGestionarUsers = new javax.swing.JMenuItem();
        ItemMenus = new javax.swing.JMenuItem();
        itemHabitaciones = new javax.swing.JMenuItem();
        itemGestionarHoteles = new javax.swing.JMenuItem();
        itemGestionarRestaurantes = new javax.swing.JMenuItem();
        menuGerenteHotel = new javax.swing.JMenu();
        itemGestionHabitaciones = new javax.swing.JMenuItem();
        itemPromosHotel = new javax.swing.JMenuItem();
        itemPromosClientesHotel = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        menuGerenteRestaurante = new javax.swing.JMenu();
        itemGestionMenus = new javax.swing.JMenuItem();
        itemPromosRestaurante = new javax.swing.JMenuItem();
        itemPromosClientesRestaurante = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        itemLiberarReservacion = new javax.swing.JMenu();
        itemReservaciones = new javax.swing.JMenuItem();
        itemCheckIn = new javax.swing.JMenuItem();
        itemCheckOut = new javax.swing.JMenuItem();
        itemExtenderFechaReservacion = new javax.swing.JMenuItem();
        menuMesero = new javax.swing.JMenu();
        itemPedidos = new javax.swing.JMenuItem();
        menuAcercaDe = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuSalir = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Empresa Comer y Dormir");

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

        lbIdEstablecim.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbIdEstablecim, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 2, 20, 20));

        lbNombreEstablecim.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbNombreEstablecim, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 260, 20));

        menuGerentes.setText("Gerente");

        itemGestionarUsers.setText("Gestionar Usuarios");
        itemGestionarUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGestionarUsersActionPerformed(evt);
            }
        });
        menuGerentes.add(itemGestionarUsers);

        ItemMenus.setText("Gestionar Menus de Restaurantes");
        ItemMenus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemMenusActionPerformed(evt);
            }
        });
        menuGerentes.add(ItemMenus);

        itemHabitaciones.setText("Gestionar Habitaciones de Hoteles");
        itemHabitaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemHabitacionesActionPerformed(evt);
            }
        });
        menuGerentes.add(itemHabitaciones);

        itemGestionarHoteles.setText("Gestionar Hoteles");
        itemGestionarHoteles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGestionarHotelesActionPerformed(evt);
            }
        });
        menuGerentes.add(itemGestionarHoteles);

        itemGestionarRestaurantes.setText("Gestionar Restaurantes");
        itemGestionarRestaurantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGestionarRestaurantesActionPerformed(evt);
            }
        });
        menuGerentes.add(itemGestionarRestaurantes);

        menuGerenteHotel.setText("Gerente de Hotel");

        itemGestionHabitaciones.setText("Gestionar Habitaciones");
        itemGestionHabitaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGestionHabitacionesActionPerformed(evt);
            }
        });
        menuGerenteHotel.add(itemGestionHabitaciones);

        itemPromosHotel.setText("Gestionar Promociones delHotel");
        menuGerenteHotel.add(itemPromosHotel);

        itemPromosClientesHotel.setText("Gestionar Promociones de Clientes frecuentes ");
        menuGerenteHotel.add(itemPromosClientesHotel);

        jMenuItem4.setText("Gestionar Reservaciones");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menuGerenteHotel.add(jMenuItem4);

        menuGerentes.add(menuGerenteHotel);

        menuGerenteRestaurante.setText("Gerente de Restaurante");

        itemGestionMenus.setText("Gestionar Menus");
        itemGestionMenus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGestionMenusActionPerformed(evt);
            }
        });
        menuGerenteRestaurante.add(itemGestionMenus);

        itemPromosRestaurante.setText("Gestionar Promociones delRestaurante");
        menuGerenteRestaurante.add(itemPromosRestaurante);

        itemPromosClientesRestaurante.setText("Gestionar Promociones de Clientes Frecuentes");
        menuGerenteRestaurante.add(itemPromosClientesRestaurante);

        jMenuItem5.setText("Gestionar Pedidos");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        menuGerenteRestaurante.add(jMenuItem5);

        menuGerentes.add(menuGerenteRestaurante);

        jMenu1.setText("Reportes");

        jMenuItem6.setText("Empleados");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        menuGerentes.add(jMenu1);

        jMenuBar1.add(menuGerentes);

        itemLiberarReservacion.setText("Recepcionista");

        itemReservaciones.setText("Gestionar Reservaciones");
        itemReservaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemReservacionesActionPerformed(evt);
            }
        });
        itemLiberarReservacion.add(itemReservaciones);

        itemCheckIn.setText("Realizar CheckIn");
        itemCheckIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCheckInActionPerformed(evt);
            }
        });
        itemLiberarReservacion.add(itemCheckIn);

        itemCheckOut.setText("Realizar CheckOut");
        itemCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCheckOutActionPerformed(evt);
            }
        });
        itemLiberarReservacion.add(itemCheckOut);

        itemExtenderFechaReservacion.setText("Extender Fecha de Reservacion");
        itemExtenderFechaReservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemExtenderFechaReservacionActionPerformed(evt);
            }
        });
        itemLiberarReservacion.add(itemExtenderFechaReservacion);

        jMenuBar1.add(itemLiberarReservacion);

        menuMesero.setText("Encargado Restaurante");
        menuMesero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMeseroActionPerformed(evt);
            }
        });

        itemPedidos.setText("Gestionar Pedidos");
        itemPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPedidosActionPerformed(evt);
            }
        });
        menuMesero.add(itemPedidos);

        jMenuBar1.add(menuMesero);

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

    private void menuMeseroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMeseroActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_menuMeseroActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
            // TODO add your handling code here:
            JOptionPane.showMessageDialog(this, "Version del sistema: 1.0 \n Desarrollador: BMonzon@97", "Informacion", 1);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void ItemMenusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemMenusActionPerformed
            // TODO add your handling code here:
            //limpiaEs();
            //instanciando nuevo internal Frame
            this.formMenus= new FormCRUDUMenu(this);
            //agregando al panel de escritorio
            this.escritorioTrabajo.add(this.formMenus);
            this.formMenus.show();//visualizando
    }//GEN-LAST:event_ItemMenusActionPerformed
    public void gestionarMenus(String restaurante){
            this.formMenus= new FormCRUDUMenu(this);
            this.formMenus.seleccionarRestaurante(restaurante);
            //agregando al panel de escritorio
            this.escritorioTrabajo.add(this.formMenus);
            this.formMenus.show();//visualizando
    }
    private void itemGestionarUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemGestionarUsersActionPerformed
            //accion de menu Gestionar Usuarios
            //limpiaEs();
            //instanciando nuevo internal Frame
            this.formUsers= new FormCRUDUser(this);
            //agregando al panel de escritorio
            this.escritorioTrabajo.add(this.formUsers);
            this.formUsers.show();//visualizando
    }//GEN-LAST:event_itemGestionarUsersActionPerformed

    private void itemHabitacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemHabitacionesActionPerformed
        // TODO add your handling code here:
            //limpiaEs();
            //instanciando nuevo internal Frame
            this.formHabitacion= new FormCRUDHabitacion();
            //agregando al panel de escritorio
            this.escritorioTrabajo.add(this.formHabitacion);
            this.formHabitacion.show();//visualizando
    }//GEN-LAST:event_itemHabitacionesActionPerformed
    public void gestionarHabitaciones(String hotel){
            this.formHabitacion= new FormCRUDHabitacion();
            this.formHabitacion.seleccionarHotel(hotel);
            //agregando al panel de escritorio
            this.escritorioTrabajo.add(this.formHabitacion);
            this.formHabitacion.show();//visualizando
    }
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
            
            System.exit(0);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void itemReservacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemReservacionesActionPerformed
        // TODO add your handling code here:
            //limpiaEs();
            //instanciando nuevo internal Frame
            this.formReservacion= new FormCRUDReservacion(this);
            //agregando al panel de escritorio
            this.escritorioTrabajo.add(this.formReservacion);
            this.formReservacion.show();//visualizando
    }//GEN-LAST:event_itemReservacionesActionPerformed

    private void itemGestionarHotelesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemGestionarHotelesActionPerformed
        // TODO add your handling code here:
        //instanciando nuevo internal Frame
            this.formHotel= new FormCRUDHotel(this);
            //agregando al panel de escritorio
            this.escritorioTrabajo.add(this.formHotel);
            this.formHotel.show();//visualizando
    }//GEN-LAST:event_itemGestionarHotelesActionPerformed

    private void itemGestionarRestaurantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemGestionarRestaurantesActionPerformed
        // TODO add your handling code here:
            //instanciando nuevo internal Frame
            this.formRestaurante= new FormCRUDRestaurante(this);
            //agregando al panel de escritorio
            this.escritorioTrabajo.add(this.formRestaurante);
            this.formRestaurante.show();//visualizando
    }//GEN-LAST:event_itemGestionarRestaurantesActionPerformed

    private void itemGestionHabitacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemGestionHabitacionesActionPerformed
        // TODO add your handling code here:
            this.formHabitacion= new FormCRUDHabitacion();
            //agregando al panel de escritorio
            this.escritorioTrabajo.add(this.formHabitacion);
            this.formHabitacion.show();//visualizando
    }//GEN-LAST:event_itemGestionHabitacionesActionPerformed

    private void itemGestionMenusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemGestionMenusActionPerformed
        // TODO add your handling code here:
            this.formMenus= new FormCRUDUMenu(this);
            //agregando al panel de escritorio
            this.escritorioTrabajo.add(this.formMenus);
            this.formMenus.show();//visualizando
    }//GEN-LAST:event_itemGestionMenusActionPerformed

    private void itemPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPedidosActionPerformed
        // TODO add your handling code here:
            this.formPedidos= new FormCRUDPedidos(this);
            //agregando al panel de escritorio
            this.escritorioTrabajo.add(this.formPedidos);
            this.formPedidos.show();//visualizando
    }//GEN-LAST:event_itemPedidosActionPerformed

    private void itemCheckInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCheckInActionPerformed
        // TODO add your handling code here:
            this.formCheckIn= new FormCheckIn(this);
            //agregando al panel de escritorio
            this.escritorioTrabajo.add(this.formCheckIn);
            this.formCheckIn.show();//visualizando
    }//GEN-LAST:event_itemCheckInActionPerformed

    private void itemCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCheckOutActionPerformed
        // TODO add your handling code here:
            this.formCheckOut= new FormCheckOut(this);
            //agregando al panel de escritorio
            this.escritorioTrabajo.add(this.formCheckOut);
            this.formCheckOut.show();//visualizando
    }//GEN-LAST:event_itemCheckOutActionPerformed

    private void itemExtenderFechaReservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemExtenderFechaReservacionActionPerformed
        // TODO add your handling code here:
            this.formExtenderReserv= new FormExtenderReservacion(this);
            //agregando al panel de escritorio
            this.escritorioTrabajo.add(this.formExtenderReserv);
            this.formExtenderReserv.show();//visualizando
    }//GEN-LAST:event_itemExtenderFechaReservacionActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
            this.formReservacion= new FormCRUDReservacion(this);
            //agregando al panel de escritorio
            this.escritorioTrabajo.add(this.formReservacion);
            this.formReservacion.show();//visualizando
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
            this.formPedidos= new FormCRUDPedidos(this);
            //agregando al panel de escritorio
            this.escritorioTrabajo.add(this.formPedidos);
            this.formPedidos.show();//visualizando
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
            this.empRestaurante= new FormEmpleadosRestaurante(this);
            this.empRestaurante.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

        //metodo encargado de limpiar Panel de escritorio
        public void limpiaEs(){
                this.escritorioTrabajo.removeAll();
                this.escritorioTrabajo.repaint();
        }
        //habilitacion de Opciones
        public void habilitarOpsGerente(String user){
                itemLiberarReservacion.setEnabled(false);
                menuMesero.setEnabled(false);
                menuGerenteHotel.setEnabled(false);
                menuGerenteRestaurante.setEnabled(false);
           
                lbUser.setText(user);
                lbNombreEstablecim.setText("Empresa \"Comer y Dormir\"");
                
        }
        public void habilitarOpsRecepcionista(String user,String hotel, int idHotel){
                menuGerentes.setEnabled(false);
                menuMesero.setEnabled(false);

                lbUser.setText(user);
                lbNombreEstablecim.setText(hotel);
                lbIdEstablecim.setText(""+idHotel);
        }
        public void habilitarOpsGerenteHotel(String user,String hotel, int idHotel){
                menuMesero.setEnabled(false);
                itemLiberarReservacion.setEnabled(false);
                menuGerenteRestaurante.setEnabled(false);
                itemGestionarHoteles.setEnabled(false);
                itemGestionarRestaurantes.setEnabled(false);
                itemGestionarUsers.setEnabled(false);
                itemHabitaciones.setEnabled(false);
                ItemMenus.setEnabled(false);
                
                lbUser.setText(user);
                lbNombreEstablecim.setText(hotel);
                lbIdEstablecim.setText(""+idHotel);
                
        }
        public void habilitarOpsEncargadoRestaurante(String user,String rest, int idRest){
                itemLiberarReservacion.setEnabled(false);
                menuGerentes.setEnabled(false);
                
                lbUser.setText(user);
                lbNombreEstablecim.setText(rest);
                lbIdEstablecim.setText(""+idRest);
        }
        public void habilitarOpsGerenteRestaurante(String user,String rest, int idRest){
                menuMesero.setEnabled(false);
                itemLiberarReservacion.setEnabled(false);
                menuGerenteHotel.setEnabled(false);
                itemGestionarHoteles.setEnabled(false);
                itemGestionarRestaurantes.setEnabled(false);
                itemGestionarUsers.setEnabled(false);
                itemHabitaciones.setEnabled(false);
                ItemMenus.setEnabled(false);
            
                lbUser.setText(user);
                lbNombreEstablecim.setText(rest);
                lbIdEstablecim.setText(""+idRest);
        }
        public static  String fechaActualDelSistema(){//metodo que devuelve fecha actual en el sistema
                fechaActual= LocalDate.now();
                //Convirtiendolo a String
                String date = fechaActual.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));  
                return date;
        }
        public static  String fechaActualDelSistema2(){//metodo que devuelve fecha actual en el sistema
                fechaActual= LocalDate.now();
                //Convirtiendolo a String
                String date = fechaActual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));  
                return date;
        }
    private FormEmpleadosRestaurante empRestaurante;
    private FormCheckIn formCheckIn;
    private FormCheckOut formCheckOut;
    private FormCRUDUser formUsers;
    private FormCRUDUMenu formMenus;
    private FormCRUDHabitacion formHabitacion;
    private FormCRUDReservacion formReservacion;
    private FormExtenderReservacion formExtenderReserv;
    private FormCRUDPedidos formPedidos;
    private FormCRUDHotel formHotel;
    private FormCRUDRestaurante formRestaurante;
    private LoginUsuario login;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ItemMenus;
    private javax.swing.JDesktopPane escritorioTrabajo;
    private javax.swing.JMenuItem itemCheckIn;
    private javax.swing.JMenuItem itemCheckOut;
    private javax.swing.JMenuItem itemExtenderFechaReservacion;
    private javax.swing.JMenuItem itemGestionHabitaciones;
    private javax.swing.JMenuItem itemGestionMenus;
    private javax.swing.JMenuItem itemGestionarHoteles;
    private javax.swing.JMenuItem itemGestionarRestaurantes;
    private javax.swing.JMenuItem itemGestionarUsers;
    private javax.swing.JMenuItem itemHabitaciones;
    private javax.swing.JMenu itemLiberarReservacion;
    private javax.swing.JMenuItem itemPedidos;
    private javax.swing.JMenuItem itemPromosClientesHotel;
    private javax.swing.JMenuItem itemPromosClientesRestaurante;
    private javax.swing.JMenuItem itemPromosHotel;
    private javax.swing.JMenuItem itemPromosRestaurante;
    private javax.swing.JMenuItem itemReservaciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JLabel lbIdEstablecim;
    private javax.swing.JLabel lbNombreEstablecim;
    private javax.swing.JLabel lbUser;
    private javax.swing.JMenu menuAcercaDe;
    private javax.swing.JMenu menuGerenteHotel;
    private javax.swing.JMenu menuGerenteRestaurante;
    private javax.swing.JMenu menuGerentes;
    private javax.swing.JMenu menuMesero;
    private javax.swing.JMenu menuSalir;
    // End of variables declaration//GEN-END:variables
}
