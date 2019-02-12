/*
 * Ventana principal del programa
 */
package proyecto2.UI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author bryan
 */
public class FramePrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FramePrincipal
     */
    //fecha del sistema
    public static LocalDate fechaActual;
    //constructor de ventana principal
    public FramePrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorioTrabajo = new javax.swing.JDesktopPane();
        menuPrincipal = new javax.swing.JMenuBar();
        menuClientes = new javax.swing.JMenu();
        btnCrearCliente = new javax.swing.JMenuItem();
        menuAgregarCliente = new javax.swing.JMenuItem();
        menuEditarCliente = new javax.swing.JMenuItem();
        menuElimarCliente = new javax.swing.JMenuItem();
        menuListadoClientes = new javax.swing.JMenuItem();
        menuAbogados = new javax.swing.JMenu();
        btnCrearNuevoAbogado = new javax.swing.JMenuItem();
        menuAgregarAbogado = new javax.swing.JMenuItem();
        menuEditarAbogado = new javax.swing.JMenuItem();
        menuEliminarAbogado = new javax.swing.JMenuItem();
        menuListadoAbogados = new javax.swing.JMenuItem();
        menuDocumentos = new javax.swing.JMenu();
        menuAutenticas = new javax.swing.JMenu();
        menuItemNuevaAut = new javax.swing.JMenuItem();
        menuItemAutCread = new javax.swing.JMenuItem();
        menuAlquileres = new javax.swing.JMenu();
        menuItemNuevaAut1 = new javax.swing.JMenuItem();
        menuItemAutCread1 = new javax.swing.JMenuItem();
        menuVehiculos = new javax.swing.JMenu();
        menuItemNuevaAut2 = new javax.swing.JMenuItem();
        menuItemAutCread2 = new javax.swing.JMenuItem();
        menuInmuebles = new javax.swing.JMenu();
        menuItemNuevaAut3 = new javax.swing.JMenuItem();
        menuItemAutCread3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorioTrabajo.setBackground(new java.awt.Color(204, 204, 204));
        escritorioTrabajo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout escritorioTrabajoLayout = new javax.swing.GroupLayout(escritorioTrabajo);
        escritorioTrabajo.setLayout(escritorioTrabajoLayout);
        escritorioTrabajoLayout.setHorizontalGroup(
            escritorioTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 672, Short.MAX_VALUE)
        );
        escritorioTrabajoLayout.setVerticalGroup(
            escritorioTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );

        menuPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        menuClientes.setText("Clientes");

        btnCrearCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        btnCrearCliente.setText("Crear Nuevo Cliente");
        btnCrearCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearClienteActionPerformed(evt);
            }
        });
        menuClientes.add(btnCrearCliente);

        menuAgregarCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        menuAgregarCliente.setText("Agregar Clientes y Visualizar Existentes");
        menuAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAgregarClienteActionPerformed(evt);
            }
        });
        menuClientes.add(menuAgregarCliente);

        menuEditarCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        menuEditarCliente.setText("Editar Clientes");
        menuEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditarClienteActionPerformed(evt);
            }
        });
        menuClientes.add(menuEditarCliente);

        menuElimarCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        menuElimarCliente.setText("Eliminar Clientes");
        menuElimarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuElimarClienteActionPerformed(evt);
            }
        });
        menuClientes.add(menuElimarCliente);

        menuListadoClientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        menuListadoClientes.setText("Listado de Clientes");
        menuListadoClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListadoClientesActionPerformed(evt);
            }
        });
        menuClientes.add(menuListadoClientes);

        menuPrincipal.add(menuClientes);

        menuAbogados.setText("Abogados");

        btnCrearNuevoAbogado.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        btnCrearNuevoAbogado.setText("Crear Nuevo Abogado");
        btnCrearNuevoAbogado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearNuevoAbogadoActionPerformed(evt);
            }
        });
        menuAbogados.add(btnCrearNuevoAbogado);

        menuAgregarAbogado.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuAgregarAbogado.setText("Agregar Abogados");
        menuAgregarAbogado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAgregarAbogadoActionPerformed(evt);
            }
        });
        menuAbogados.add(menuAgregarAbogado);

        menuEditarAbogado.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuEditarAbogado.setText("Editar Abogados");
        menuEditarAbogado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditarAbogadoActionPerformed(evt);
            }
        });
        menuAbogados.add(menuEditarAbogado);

        menuEliminarAbogado.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuEliminarAbogado.setText("Eliminar Abogados");
        menuEliminarAbogado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEliminarAbogadoActionPerformed(evt);
            }
        });
        menuAbogados.add(menuEliminarAbogado);

        menuListadoAbogados.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuListadoAbogados.setText("Listado de Abogados");
        menuListadoAbogados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListadoAbogadosActionPerformed(evt);
            }
        });
        menuAbogados.add(menuListadoAbogados);

        menuPrincipal.add(menuAbogados);

        menuDocumentos.setText("Documentos");

        menuAutenticas.setText("Autenticas");

        menuItemNuevaAut.setText("Crear Nueva Autentica");
        menuItemNuevaAut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemNuevaAutActionPerformed(evt);
            }
        });
        menuAutenticas.add(menuItemNuevaAut);

        menuItemAutCread.setText("Ver Autenticas Creadas");
        menuItemAutCread.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAutCreadActionPerformed(evt);
            }
        });
        menuAutenticas.add(menuItemAutCread);

        menuDocumentos.add(menuAutenticas);

        menuAlquileres.setText("Alquileres");

        menuItemNuevaAut1.setText("Crear Nuevo Alquiler");
        menuItemNuevaAut1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemNuevaAut1ActionPerformed(evt);
            }
        });
        menuAlquileres.add(menuItemNuevaAut1);

        menuItemAutCread1.setText("Ver Alquileres Creados");
        menuItemAutCread1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAutCread1ActionPerformed(evt);
            }
        });
        menuAlquileres.add(menuItemAutCread1);

        menuDocumentos.add(menuAlquileres);

        menuVehiculos.setText("Venta de Vehiculos");

        menuItemNuevaAut2.setText("Crear Nueva Venta de Vehiculo");
        menuItemNuevaAut2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemNuevaAut2ActionPerformed(evt);
            }
        });
        menuVehiculos.add(menuItemNuevaAut2);

        menuItemAutCread2.setText("Ver Ventas Creadas");
        menuVehiculos.add(menuItemAutCread2);

        menuDocumentos.add(menuVehiculos);

        menuInmuebles.setText("Venta de Inmuebles");

        menuItemNuevaAut3.setText("Crear Nueva Venta de Inmueble");
        menuItemNuevaAut3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemNuevaAut3ActionPerformed(evt);
            }
        });
        menuInmuebles.add(menuItemNuevaAut3);

        menuItemAutCread3.setText("Ver Ventas Creadas");
        menuInmuebles.add(menuItemAutCread3);

        menuDocumentos.add(menuInmuebles);

        menuPrincipal.add(menuDocumentos);

        setJMenuBar(menuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(escritorioTrabajo)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(escritorioTrabajo)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAgregarClienteActionPerformed
        // Accion de Menu Agregar Clientes
        EdicionClientes frameClientes= new EdicionClientes();
        this.escritorioTrabajo.add(frameClientes);
        frameClientes.bloquearBoton("editar"); frameClientes.bloquearBoton("eliminar"); frameClientes.setVisible(true);
    }//GEN-LAST:event_menuAgregarClienteActionPerformed

    private void menuListadoClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListadoClientesActionPerformed
        listadoClientes= new ListadoClientes(this); listadoClientes.setVisible(true);
    }//GEN-LAST:event_menuListadoClientesActionPerformed

    private void menuAgregarAbogadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAgregarAbogadoActionPerformed
        // Accion de menu Agregar Abogados
        EdicionAbogados frameAbogados= new EdicionAbogados();
        this.escritorioTrabajo.add(frameAbogados); 
        frameAbogados.bloquearBoton("editar"); frameAbogados.bloquearBoton("eliminar"); frameAbogados.setVisible(true);
    }//GEN-LAST:event_menuAgregarAbogadoActionPerformed

    private void menuEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditarClienteActionPerformed
        // Accion de Menu Editar Clientes
        EdicionClientes frameClientes= new EdicionClientes();
        this.escritorioTrabajo.add(frameClientes);
        frameClientes.bloquearBoton("agregar"); frameClientes.bloquearBoton("eliminar"); frameClientes.setVisible(true);
    }//GEN-LAST:event_menuEditarClienteActionPerformed

    private void menuEditarAbogadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditarAbogadoActionPerformed
        // Accion de menu Editar Abogados
        EdicionAbogados frameAbogados= new EdicionAbogados();
        this.escritorioTrabajo.add(frameAbogados);
        frameAbogados.bloquearBoton("agregar");frameAbogados.bloquearBoton("eliminar"); frameAbogados.setVisible(true);
    }//GEN-LAST:event_menuEditarAbogadoActionPerformed

    private void btnCrearClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearClienteActionPerformed
        // Accion de Menu Agregar Clientes
        formularioCliente= new FormularioCliente(this); formularioCliente.setVisible(true);    
    }//GEN-LAST:event_btnCrearClienteActionPerformed

    private void btnCrearNuevoAbogadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearNuevoAbogadoActionPerformed
        // Accion de boton agregar abogado
        formularioAbogado= new FormularioAbogado(this); formularioAbogado.setVisible(true);
    }//GEN-LAST:event_btnCrearNuevoAbogadoActionPerformed

    private void menuEliminarAbogadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEliminarAbogadoActionPerformed
        // Accion de menu Eliminar Abogados
        EdicionAbogados frameAbogados= new EdicionAbogados();
        this.escritorioTrabajo.add(frameAbogados);
        frameAbogados.bloquearBoton("agregar"); frameAbogados.bloquearBoton("editar"); frameAbogados.setVisible(true);
    }//GEN-LAST:event_menuEliminarAbogadoActionPerformed

    private void menuElimarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuElimarClienteActionPerformed
        // Accion de Menu Eliminar Clientes
        EdicionClientes frameClientes= new EdicionClientes();
        this.escritorioTrabajo.add(frameClientes);
        frameClientes.bloquearBoton("agregar"); frameClientes.bloquearBoton("editar"); frameClientes.setVisible(true); 
    }//GEN-LAST:event_menuElimarClienteActionPerformed

    private void menuItemNuevaAutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemNuevaAutActionPerformed
        formularioAutenticas= new FormularioAutenticas(this); formularioAutenticas.setVisible(true);       
    }//GEN-LAST:event_menuItemNuevaAutActionPerformed

    private void menuItemNuevaAut1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemNuevaAut1ActionPerformed
        // Accion de Menu Nuevo Alquiler
        formularioAlquiler= new FormularioAlquiler(this);formularioAlquiler.setVisible(true);        
    }//GEN-LAST:event_menuItemNuevaAut1ActionPerformed

    private void menuItemNuevaAut2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemNuevaAut2ActionPerformed
        // Accion de menu Nueva Venta vehiculo
        formularioVentaVehiculos= new FormularioVentaVehiculo(this); formularioVentaVehiculos.setVisible(true); 
    }//GEN-LAST:event_menuItemNuevaAut2ActionPerformed

    private void menuItemNuevaAut3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemNuevaAut3ActionPerformed
        // Accion de Menu Nueva Venta Inmueble
        formularioVentaInmueble= new FormularioVentaInmueble(this); formularioVentaInmueble.setVisible(true);        
    }//GEN-LAST:event_menuItemNuevaAut3ActionPerformed

    private void menuListadoAbogadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListadoAbogadosActionPerformed
        // TODO add your handling code here:
        abogados= new ListadoAbogados(this);abogados.setVisible(true);
    }//GEN-LAST:event_menuListadoAbogadosActionPerformed

    private void menuItemAutCreadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAutCreadActionPerformed
       
    }//GEN-LAST:event_menuItemAutCreadActionPerformed

    private void menuItemAutCread1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAutCread1ActionPerformed
        
    }//GEN-LAST:event_menuItemAutCread1ActionPerformed
    public static  String fechaActualDelSistema(){//metodo que devuelve fecha actual en el sistema
        fechaActual= LocalDate.now();
        //Convirtiendolo a String
        String date = fechaActual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));  
        return date;
    }
    private ListadoAbogados abogados;
    private ListadoClientes listadoClientes;
    private FormularioCliente formularioCliente;
    private FormularioAbogado formularioAbogado;
    private FormularioVentaVehiculo formularioVentaVehiculos;
    private FormularioVentaInmueble formularioVentaInmueble;
    private FormularioAlquiler formularioAlquiler;
    private FormularioAutenticas formularioAutenticas;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnCrearCliente;
    private javax.swing.JMenuItem btnCrearNuevoAbogado;
    private javax.swing.JDesktopPane escritorioTrabajo;
    private javax.swing.JMenu menuAbogados;
    private javax.swing.JMenuItem menuAgregarAbogado;
    private javax.swing.JMenuItem menuAgregarCliente;
    private javax.swing.JMenu menuAlquileres;
    private javax.swing.JMenu menuAutenticas;
    private javax.swing.JMenu menuClientes;
    private javax.swing.JMenu menuDocumentos;
    private javax.swing.JMenuItem menuEditarAbogado;
    private javax.swing.JMenuItem menuEditarCliente;
    private javax.swing.JMenuItem menuElimarCliente;
    private javax.swing.JMenuItem menuEliminarAbogado;
    private javax.swing.JMenu menuInmuebles;
    private javax.swing.JMenuItem menuItemAutCread;
    private javax.swing.JMenuItem menuItemAutCread1;
    private javax.swing.JMenuItem menuItemAutCread2;
    private javax.swing.JMenuItem menuItemAutCread3;
    private javax.swing.JMenuItem menuItemNuevaAut;
    private javax.swing.JMenuItem menuItemNuevaAut1;
    private javax.swing.JMenuItem menuItemNuevaAut2;
    private javax.swing.JMenuItem menuItemNuevaAut3;
    private javax.swing.JMenuItem menuListadoAbogados;
    private javax.swing.JMenuItem menuListadoClientes;
    private javax.swing.JMenuBar menuPrincipal;
    private javax.swing.JMenu menuVehiculos;
    // End of variables declaration//GEN-END:variables
}
