/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2ipc2.backend.DAO.Interfaces;
import proyecto2ipc2.backend.Hotel.Cliente;

/**
 *
 * @author bryan
 */
public interface ClienteDAO extends CRUD<Cliente>{
        public Cliente recuperarCliente(String nit);
    
}
