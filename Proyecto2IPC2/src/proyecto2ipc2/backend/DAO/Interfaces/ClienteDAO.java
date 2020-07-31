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
        // Operaciones
        public Cliente recuperarCliente(String nit);
        
        //Querys DAO: en todas las interfaces DAO se devben colocar sus querys relacionadas para no sobrecargar el OperadorEsquema con muchas querys sino solo las de error
        public static final String CONSULTAR_CLIENTES="SELECT Nit FROM CLIENTE";
        public static final String CONSULTAR_CLIENTE="SELECT*FROM CLIENTE WHERE NIT=?";
        public static final String INSERTAR_CLIENTE="INSERT INTO CLIENTE VALUES(?,?,?,?,?)";
    
}
