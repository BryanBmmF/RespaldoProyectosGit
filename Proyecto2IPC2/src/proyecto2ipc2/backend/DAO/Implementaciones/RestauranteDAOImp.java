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
import proyecto2ipc2.backend.DAO.Interfaces.RestauranteDAO;
import proyecto2ipc2.backend.Restaurante.IngresosRestaurante;
import proyecto2ipc2.backend.Restaurante.Restaurante;
import proyecto2ipc2.database.Conexion;
import static proyecto2ipc2.database.OperadorEsquema.ACTUALIZAR_RESTAURANTE;
import static proyecto2ipc2.database.OperadorEsquema.CONSULTAR_DATOS_RESTAURANTE;
import static proyecto2ipc2.database.OperadorEsquema.CONSULTAR_NOMBRES_RESTAURANTES;
import static proyecto2ipc2.database.OperadorEsquema.CONSULTAR_NUMERO_MENUS;
import static proyecto2ipc2.database.OperadorEsquema.CONSULTAR_RESTAURANTE_UNICO;
import static proyecto2ipc2.database.OperadorEsquema.ELIMINAR_RESTAURANTE;
import static proyecto2ipc2.database.OperadorEsquema.ERR_CONSULTA;
import static proyecto2ipc2.database.OperadorEsquema.ERR_INSERCION;
import static proyecto2ipc2.database.OperadorEsquema.INSERTAR_INGRESO_RESTAURANTE;
import static proyecto2ipc2.database.OperadorEsquema.INSERTAR_RESTAURANTE;

/**
 *
 * @author bryan
 */
public class RestauranteDAOImp implements RestauranteDAO{
        private Conexion conexion= new Conexion();
        private PreparedStatement prepStatement;
        private ResultSet result;
        private List listaRecuperacion = new ArrayList<>();
        @Override
        public boolean registrar(Restaurante restaurante) {
                try {
                        prepStatement = conexion.getConnection().prepareStatement(INSERTAR_RESTAURANTE);
                        prepStatement.setString(1, restaurante.getNombre());
                        prepStatement.setString(2, restaurante.getDireccion());
                        prepStatement.executeUpdate();
                        prepStatement.close();  //Cerrar PreparedStatement
                        return true;
                } catch (SQLException ex) {           
                        System.out.println(ERR_INSERCION);
                        return false;
                }
        }

        @Override
        public List<Restaurante> recuperarLista() {
                try {   //se realiza la consulta
                        prepStatement = conexion.getConnection().prepareStatement(CONSULTAR_NOMBRES_RESTAURANTES);
                        result = prepStatement.executeQuery();
                        //se extraen los resultados y se insertan en la lista
                        while (result.next()) {
                                listaRecuperacion.add(new Restaurante(result.getInt(1),result.getString(2),result.getString(3)));
                        
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
        public boolean actualizar(Restaurante restaurante, String temp) {
                try {
                        prepStatement = conexion.getConnection().prepareStatement(ACTUALIZAR_RESTAURANTE);
                        prepStatement.setString(1, restaurante.getNombre());
                        prepStatement.setString(2, restaurante.getDireccion());
                        
                        prepStatement.setString(3, temp);
                        prepStatement.executeUpdate();
                        prepStatement.close();  //Cerrar PreparedStatement
                        return true;
                } catch (SQLException ex) {
                        System.out.println(ERR_INSERCION);
                        return false;
                }
        }

        @Override
        public boolean eliminar(Restaurante restaurante) {
                try {
                        prepStatement = conexion.getConnection().prepareStatement(ELIMINAR_RESTAURANTE);
                        prepStatement.setString(1, restaurante.getNombre());
                        prepStatement.executeUpdate();
                        prepStatement.close();  //Cerrar PreparedStatement
                        return true;
                } catch (SQLException ex) {
                        System.out.println(ERR_INSERCION);
                        return false;
                }
        }

        @Override
        public Restaurante recuperarRestaurante(int id) {
                Restaurante restDevol= null;
                try {   //se realiza la consulta
                        //Connection connection= establecerConexion();
                        prepStatement = conexion.getConnection().prepareStatement(CONSULTAR_RESTAURANTE_UNICO);
                        prepStatement.setInt(1,id);//parametro 1 estado
                        result = prepStatement.executeQuery();
                        result.next();
                        restDevol= new Restaurante(result.getInt(1), result.getString(2), result.getString(3));
                        
                        result.close(); // Cerrar ResultSet
                        prepStatement.close();  //Cerrar PreparedStatement
                } catch (SQLException ex) {
                        System.out.println(ERR_CONSULTA);
                }
                return restDevol;
        }

        @Override
        public Restaurante recuperarIdRestaurante(String nombre) {
                Restaurante restDevol= null;
                try {   //se realiza la consulta
                        //Connection connection= establecerConexion();
                        prepStatement = conexion.getConnection().prepareStatement(CONSULTAR_DATOS_RESTAURANTE);
                        prepStatement.setString(1,nombre);//parametro 1 estado
                        result = prepStatement.executeQuery();
                        result.next();
                        restDevol= new Restaurante(result.getInt(1), result.getString(2), result.getString(3));
                        
                        result.close(); // Cerrar ResultSet
                        prepStatement.close();  //Cerrar PreparedStatement
                } catch (SQLException ex) {
                        System.out.println(ERR_CONSULTA);
                }
                return restDevol;

        }

        @Override
        public int recuperarNumeroMenus(int idRestaurante) {
                int numHabitaciones= 0;
                    try {   //se realiza la consulta
                            prepStatement = conexion.getConnection().prepareStatement(CONSULTAR_NUMERO_MENUS);
                            prepStatement.setInt(1,idRestaurante);//parametro 1 estado
                            result = prepStatement.executeQuery();
                            result.next();
                            numHabitaciones= result.getInt(1);
                            result.close(); // Cerrar ResultSet
                            prepStatement.close();  //Cerrar PreparedStatement
                    } catch (SQLException ex) {
                            System.out.println(ERR_CONSULTA);
                    }
                    return numHabitaciones;
        }

        @Override
        public boolean registrarIngresoRestaurante(IngresosRestaurante ingresoRestaurante) {
                try {
                        prepStatement = conexion.getConnection().prepareStatement(INSERTAR_INGRESO_RESTAURANTE);
                        prepStatement.setDouble(1, ingresoRestaurante.getIngreso());
                        prepStatement.setString(2, ingresoRestaurante.getFecha().toString());
                        prepStatement.setInt(3, ingresoRestaurante.getRestaurante().getId());
                        prepStatement.executeUpdate();
                        prepStatement.close();  //Cerrar PreparedStatement
                        return true;
                } catch (SQLException ex) {           
                        System.out.println(ERR_INSERCION);
                        return false;
                }
        }

    
}
