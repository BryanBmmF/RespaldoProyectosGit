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
import proyecto2ipc2.backend.DAO.Interfaces.ConsumoDAO;
import proyecto2ipc2.backend.Restaurante.Consumo;
import proyecto2ipc2.database.Conexion;
import static proyecto2ipc2.database.OperadorEsquema.ERR_INSERCION;
import static proyecto2ipc2.database.OperadorEsquema.INSERTAR_CONSUMO;

/**
 *
 * @author bryan
 */
public class ConsumoDAOImp implements ConsumoDAO{
        private Conexion conexion= new Conexion();
        private PreparedStatement prepStatement;
        private ResultSet result;
        private List listaRecuperacion = new ArrayList<>();
        @Override
        public boolean registrar(Consumo consum) {
                try {   
                        prepStatement = conexion.getConnection().prepareStatement(INSERTAR_CONSUMO);
                        prepStatement.setInt(1, consum.getNumeroPorciones());
                        prepStatement.setInt(2, consum.getMenu().getNumero());
                        prepStatement.setString(3, consum.getMenu().getNombre());
                        prepStatement.setDouble(4, consum.getMenu().getPrecio());
                        prepStatement.setString(5, consum.getCliente().getNombre());
                        prepStatement.setString(6, consum.getCliente().getNit());
                        prepStatement.setString(7, consum.getFecha().toString());
                        prepStatement.setInt(8, consum.getRestaurante().getId());
                        
                        prepStatement.executeUpdate();
                        prepStatement.close();  //Cerrar PreparedStatement
                        return true;
                } catch (SQLException ex) {           
                        System.out.println(ERR_INSERCION);
                        return false;
                }
        }

        @Override
        public List<Consumo> recuperarLista() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean actualizar(Consumo t, String temp) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean eliminar(Consumo t) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    
}
