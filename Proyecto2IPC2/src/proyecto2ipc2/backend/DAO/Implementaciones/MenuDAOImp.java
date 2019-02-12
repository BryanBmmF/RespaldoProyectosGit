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
import proyecto2ipc2.backend.DAO.Interfaces.MenuDAO;
import proyecto2ipc2.backend.Restaurante.Menu;
import proyecto2ipc2.database.Conexion;
import static proyecto2ipc2.database.OperadorEsquema.ACTUALIZAR_MENU;
import static proyecto2ipc2.database.OperadorEsquema.CONSULTAR_MENU;
import static proyecto2ipc2.database.OperadorEsquema.CONSULTAR_MENUS;
import static proyecto2ipc2.database.OperadorEsquema.CONSULTAR_MENUS_RESTAURANTE_ESPECIFICO;
import static proyecto2ipc2.database.OperadorEsquema.ELIMINAR_MENU;
import static proyecto2ipc2.database.OperadorEsquema.ERR_CONSULTA;
import static proyecto2ipc2.database.OperadorEsquema.ERR_INSERCION;
import static proyecto2ipc2.database.OperadorEsquema.INSERTAR_MENU;

/**
 *
 * @author bryan
 */
public class MenuDAOImp implements MenuDAO{
        private Conexion conexion= new Conexion();
        private PreparedStatement prepStatement;
        private ResultSet result;
        private List listaRecuperacion = new ArrayList<>();
        @Override
        public boolean registrar(Menu menu) {
                try {
                        prepStatement = conexion.getConnection().prepareStatement(INSERTAR_MENU);
                        prepStatement.setInt(1, menu.getNumero());
                        prepStatement.setString(2, menu.getTipo());
                        prepStatement.setString(3, menu.getNombre());
                        prepStatement.setString(4, menu.getDescripcion());
                        prepStatement.setDouble(5, menu.getPrecio());
                        prepStatement.setDouble(6, menu.getCostoFabricacion());
                        prepStatement.setInt(7, menu.getIdRestaurante());
                        prepStatement.setInt(8, menu.getPromo());
                        prepStatement.executeUpdate();
                        prepStatement.close();  //Cerrar PreparedStatement
                        return true;
                } catch (SQLException ex) {           
                        System.out.println(ERR_INSERCION);
                        return false;
                }
        }

        @Override
        public List<Menu> recuperarLista() {
                try {   //se realiza la consulta
                        //Connection connection= establecerConexion();
                        prepStatement = conexion.getConnection().prepareStatement(CONSULTAR_MENUS);
                        result = prepStatement.executeQuery();
                        //se extraen los resultados y se insertan en la lista
                        while (result.next()) {
                                listaRecuperacion.add(new Menu(result.getInt(1),result.getString(2),result.getString(3),
                                result.getString(4), result.getDouble(5),result.getDouble(6),result.getInt(7),result.getInt(8)));
                        
                        }
                        result.close(); // Cerrar ResultSet
                        prepStatement.close();  //Cerrar PreparedStatement
                } catch (SQLException ex) {
                        System.out.println(ERR_CONSULTA);
                        JOptionPane.showMessageDialog(null, ERR_CONSULTA, "Error", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                }
                return listaRecuperacion;
        }

        @Override
        public boolean actualizar(Menu menu, String temp) {
                try {
                        //Connection connection= establecerConexion();
                        prepStatement = conexion.getConnection().prepareStatement(ACTUALIZAR_MENU);
                        prepStatement.setInt(1, menu.getNumero());
                        prepStatement.setString(2, menu.getTipo());
                        prepStatement.setString(3, menu.getNombre());
                        prepStatement.setString(4, menu.getDescripcion());
                        prepStatement.setDouble(5, menu.getPrecio());
                        prepStatement.setDouble(6, menu.getCostoFabricacion());
                        
                        prepStatement.setInt(7, Integer.parseInt(temp));
                        prepStatement.setInt(8, menu.getIdRestaurante());
                        
                        prepStatement.executeUpdate();
                        prepStatement.close();  //Cerrar PreparedStatement
                        return true;
                } catch (SQLException ex) {
                        System.out.println(ERR_INSERCION);
                        return false;
                }
        }

        @Override
        public boolean eliminar(Menu menu) {
                try {
                        //Connection connection= establecerConexion();
                        prepStatement = conexion.getConnection().prepareStatement(ELIMINAR_MENU);
                        prepStatement.setInt(1, menu.getNumero());
                        prepStatement.setInt(2, menu.getIdRestaurante());
                        prepStatement.executeUpdate();
                        prepStatement.close();  //Cerrar PreparedStatement
                        return true;
                } catch (SQLException ex) {
                        System.out.println(ERR_INSERCION);
                        return false;
                }
        }

        @Override
        public Menu recuperarMenu(int numero, int restaurante) {
                Menu menuDevol= null;
                try {   //se realiza la consulta
                        //Connection connection= establecerConexion();
                        prepStatement = conexion.getConnection().prepareStatement(CONSULTAR_MENU);
                        prepStatement.setInt(1,numero);//parametro 1 estado
                        prepStatement.setInt(2,restaurante);//parametro 1 estado
                        result = prepStatement.executeQuery();
                        result.next();
                        menuDevol= new Menu(result.getInt(1),result.getString(2),result.getString(3),
                            result.getString(4), result.getDouble(5),result.getDouble(6),result.getInt(7),result.getInt(8));
                        result.close(); // Cerrar ResultSet
                        prepStatement.close();  //Cerrar PreparedStatement
                } catch (SQLException ex) {
                        System.out.println(ERR_CONSULTA);
                }
                return menuDevol;
        }

        @Override
        public List<Menu> recuperarMenusRestauranteEspecificco(int idRestaurante) {
                try {   //se realiza la consulta
                        //Connection connection= establecerConexion();
                        prepStatement = conexion.getConnection().prepareStatement(CONSULTAR_MENUS_RESTAURANTE_ESPECIFICO);
                        prepStatement.setInt(1,idRestaurante);//parametro 1 estado
                        result = prepStatement.executeQuery();
                        //se extraen los resultados y se insertan en la lista
                        while (result.next()) {
                                listaRecuperacion.add(new Menu(result.getInt(1),result.getString(2),result.getString(3),
                                result.getString(4), result.getDouble(5),result.getDouble(6),result.getInt(7),result.getInt(8)));
                        
                        }
                        result.close(); // Cerrar ResultSet
                        prepStatement.close();  //Cerrar PreparedStatement
                } catch (SQLException ex) {
                        System.out.println(ERR_CONSULTA);
                        JOptionPane.showMessageDialog(null, ERR_CONSULTA, "Error", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                }
                return listaRecuperacion;
        }
    
}
