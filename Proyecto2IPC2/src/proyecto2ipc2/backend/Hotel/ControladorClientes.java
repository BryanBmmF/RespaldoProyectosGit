/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2ipc2.backend.Hotel;

import java.util.List;
import javax.swing.JOptionPane;
import proyecto2ipc2.backend.DAO.Implementaciones.ClienteDAOImp;
import proyecto2ipc2.backend.DAO.Interfaces.ClienteDAO;
import static proyecto2ipc2.database.OperadorEsquema.ERROR_CREACION;
import static proyecto2ipc2.database.OperadorEsquema.ERR_INSERCION;
import static proyecto2ipc2.database.OperadorEsquema.REGISTRO;
import static proyecto2ipc2.database.OperadorEsquema.REGISTRO_GUARDADO;
import proyecto2ipc2.frontend.Forms.FormCRUDPedidos;
import proyecto2ipc2.frontend.Forms.FormCRUDReservacion;

/**
 *
 * @author bryan
 */
public class ControladorClientes {
        private Cliente cliente;
        private FormCRUDReservacion formReservacion;
        private FormCRUDPedidos formPedidos;
        private ClienteDAO clienteDao;

        public ControladorClientes(Cliente cliente, FormCRUDReservacion formReservacion) {
                this.cliente = cliente;
                this.formReservacion = formReservacion;
                this.clienteDao= new ClienteDAOImp();
        }

        public ControladorClientes(Cliente cliente) {
                this.cliente = cliente;
                this.clienteDao= new ClienteDAOImp();
        }

        public ControladorClientes() {
                this.clienteDao= new ClienteDAOImp();
        }
        
         //metodo para registrar usuarios nuevos del sistema
        public void registrarCliente(){
                //se envia a la bd
                if (clienteDao.registrar(cliente)) {
                        JOptionPane.showMessageDialog(null, REGISTRO_GUARDADO, REGISTRO, 1);
                        
                } else{
                        JOptionPane.showMessageDialog(null, ERR_INSERCION, ERROR_CREACION, JOptionPane.ERROR_MESSAGE);
                }   
                
        }
        public List<Cliente> recuperarClientes(){
                return clienteDao.recuperarLista();
        }
        
        public Cliente recuperarClienteNit(String nit){
                return clienteDao.recuperarCliente(nit);
        }
    
}
