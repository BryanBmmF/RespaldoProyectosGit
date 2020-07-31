/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2ipc2.backend.DAO.Implementaciones;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import proyecto2ipc2.backend.DAO.Interfaces.ClienteDAO;
import proyecto2ipc2.backend.Hotel.Cliente;
import proyecto2ipc2.database.Conexion;
import static proyecto2ipc2.database.OperadorEsquema.ERR_CONSULTA;
import static proyecto2ipc2.database.OperadorEsquema.ERR_INSERCION;

/**
 *
 * @author bryan
 */
public class ClienteDAOImp implements ClienteDAO{
        private Conexion conexion= new Conexion();
        private PreparedStatement prepStatement;
        private ResultSet result;
        private List listaRecuperacion = new ArrayList<>();
        @Override
        public boolean registrar(Cliente cliente) {
                try {
                        prepStatement = conexion.getConnection().prepareStatement(INSERTAR_CLIENTE);
                        prepStatement.setString(1, cliente.getNit());
                        prepStatement.setString(2, cliente.getCui());
                        prepStatement.setString(3, cliente.getNombre());
                        prepStatement.setString(4, cliente.getTelefono());
                        prepStatement.setInt(5, cliente.getPromo());
                        prepStatement.executeUpdate();
                        prepStatement.close();  //Cerrar PreparedStatement
                        return true;
                } catch (SQLException ex) {           
                        System.out.println(ERR_INSERCION);
                        return false;
                }
        }

        @Override
        public List<Cliente> recuperarLista() {
                try {   //se realiza la consulta
                        //Connection connection= establecerConexion();
                        prepStatement = conexion.getConnection().prepareStatement(CONSULTAR_CLIENTES);
                        result = prepStatement.executeQuery();
                        //se extraen los resultados y se insertan en la lista
                        while (result.next()) {
                                listaRecuperacion.add(new Cliente(result.getString(1)));
                        
                        }
                        result.close(); // Cerrar ResultSet
                        prepStatement.close();  //Cerrar PreparedStatement
                } catch (SQLException ex) {
                        System.out.println(ERR_CONSULTA);
                        JOptionPane.showMessageDialog(null, ERR_CONSULTA, "Error", JOptionPane.ERROR_MESSAGE);
                        //ex.printStackTrace();
                }
                return listaRecuperacion;
        }
        @Override
        public boolean actualizar(Cliente t, String temp) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean eliminar(Cliente t) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Cliente recuperarCliente(String nit) {
                Cliente clienteDevol= null;
                try {   //se realiza la consulta
                        prepStatement = conexion.getConnection().prepareStatement(CONSULTAR_CLIENTE);
                        prepStatement.setString(1,nit);//parametro 1 estado
                        result = prepStatement.executeQuery();
                        result.next();
                        clienteDevol= new Cliente(result.getString(1), result.getString(2),
                                result.getString(3), result.getString(4),result.getInt(5));
                        result.close(); // Cerrar ResultSet
                        prepStatement.close();  //Cerrar PreparedStatement
                } catch (SQLException ex) {
                        System.out.println(ERR_CONSULTA);
                }
                return clienteDevol;
        }

}
