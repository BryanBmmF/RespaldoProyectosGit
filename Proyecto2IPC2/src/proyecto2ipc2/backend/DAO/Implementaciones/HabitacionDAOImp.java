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
import proyecto2ipc2.backend.DAO.Interfaces.HabitacionDAO;
import proyecto2ipc2.backend.Hotel.Habitacion;
import proyecto2ipc2.backend.Hotel.ValoracionHabitacion;
import proyecto2ipc2.database.Conexion;
import static proyecto2ipc2.database.OperadorEsquema.ACTUALIZAR_ESTADO_HABITACION;
import static proyecto2ipc2.database.OperadorEsquema.ACTUALIZAR_HABITACION;
import static proyecto2ipc2.database.OperadorEsquema.CONSULTAR_HABITACION;
import static proyecto2ipc2.database.OperadorEsquema.CONSULTAR_HABITACIONES;
import static proyecto2ipc2.database.OperadorEsquema.CONSULTAR_HABITACIONES_ESTADO;
import static proyecto2ipc2.database.OperadorEsquema.CONSULTAR_HABITACIONES_HOTEL_ESPECIFICO;
import static proyecto2ipc2.database.OperadorEsquema.ELIMINAR_HABITACION;
import static proyecto2ipc2.database.OperadorEsquema.ERR_CONSULTA;
import static proyecto2ipc2.database.OperadorEsquema.ERR_INSERCION;
import static proyecto2ipc2.database.OperadorEsquema.INSERTAR_HABITACION;
import static proyecto2ipc2.database.OperadorEsquema.INSERTAR_VALORACION_HABITACION;

/**
 *
 * @author bryan
 */
public class HabitacionDAOImp implements HabitacionDAO{
        private Conexion conexion= new Conexion();
        private PreparedStatement prepStatement;
        private ResultSet result;
        private List listaRecuperacion = new ArrayList<>();
        @Override
        public boolean registrar(Habitacion habitacion) {
                try {
                        prepStatement = conexion.getConnection().prepareStatement(INSERTAR_HABITACION);
                        prepStatement.setInt(1, habitacion.getNumero());
                        prepStatement.setString(2, habitacion.getTipo());
                        prepStatement.setInt(3, habitacion.getNivel());
                        prepStatement.setDouble(4, habitacion.getPrecio());
                        prepStatement.setString(5, habitacion.getEstado());
                        prepStatement.setDouble(6, habitacion.getCostoMant());
                        prepStatement.setInt(7, habitacion.getIdHotel());
                        prepStatement.setInt(8, habitacion.getPromo());                        
                        prepStatement.executeUpdate();
                        prepStatement.close();  //Cerrar PreparedStatement
                        return true;
                } catch (SQLException ex) {           
                        System.out.println(ERR_INSERCION);
                        return false;
                }
        }

        @Override
        public List<Habitacion> recuperarLista() {
                try {   //se realiza la consulta
                        //Connection connection= establecerConexion();
                        prepStatement = conexion.getConnection().prepareStatement(CONSULTAR_HABITACIONES);
                        result = prepStatement.executeQuery();
                        //se extraen los resultados y se insertan en la lista
                        while (result.next()) {
                                listaRecuperacion.add(new Habitacion(result.getInt(1),result.getString(2),result.getInt(3),
                                        result.getDouble(4), result.getString(5),result.getDouble(6)));
                        
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
        public boolean actualizar(Habitacion habitacion, String idHabitacion) {
                try {
                        prepStatement = conexion.getConnection().prepareStatement(ACTUALIZAR_HABITACION);
                        prepStatement.setInt(1, habitacion.getNumero());
                        prepStatement.setString(2, habitacion.getTipo());
                        prepStatement.setInt(3, habitacion.getNivel());
                        prepStatement.setDouble(4, habitacion.getPrecio());
                        prepStatement.setString(5, habitacion.getEstado());
                        prepStatement.setDouble(6, habitacion.getCostoMant());
                        prepStatement.setInt(7, Integer.parseInt(idHabitacion));
                        prepStatement.setInt(8, habitacion.getIdHotel());

                        prepStatement.executeUpdate();
                        prepStatement.close();  //Cerrar PreparedStatement
                        return true;
                } catch (SQLException ex) {
                        System.out.println(ERR_INSERCION);
                        return false;
                }
        }

        @Override
        public boolean eliminar(Habitacion habitacion) {
                try {
                        prepStatement = conexion.getConnection().prepareStatement(ELIMINAR_HABITACION);
                        prepStatement.setInt(1, habitacion.getNumero());
                        prepStatement.setInt(2, habitacion.getIdHotel());
                        prepStatement.executeUpdate();
                        prepStatement.close();  //Cerrar PreparedStatement
                        return true;
                } catch (SQLException ex) {
                        System.out.println(ERR_INSERCION);
                        return false;
                }
        }

        @Override
        public boolean actualizarEstadoHabitacion(String estado, int numHabitacion, int idHotel) {
                try {
                        prepStatement = conexion.getConnection().prepareStatement(ACTUALIZAR_ESTADO_HABITACION);
                        prepStatement.setString(1, estado);
                        prepStatement.setInt(2, numHabitacion);
                        prepStatement.setInt(3, idHotel);

                        prepStatement.executeUpdate();
                        prepStatement.close();  //Cerrar PreparedStatement
                        return true;
                } catch (SQLException ex) {
                        System.out.println(ERR_INSERCION);
                        return false;
                }
        }

        @Override
        public Habitacion recuperarHabitacion(int numero,int idHotel) {
                Habitacion habitacionDevol= null;
                try {   //se realiza la consulta
                        //Connection connection= establecerConexion();
                        prepStatement = conexion.getConnection().prepareStatement(CONSULTAR_HABITACION);
                        prepStatement.setInt(1,numero);//parametro 1 estado
                        prepStatement.setInt(2,idHotel);//parametro 1 estado
                        result = prepStatement.executeQuery();
                        result.next();
                        habitacionDevol= new Habitacion(result.getInt(1),result.getString(2),result.getInt(3),
                                        result.getDouble(4), result.getString(5),result.getDouble(6));
                        result.close(); // Cerrar ResultSet
                        prepStatement.close();  //Cerrar PreparedStatement
                } catch (SQLException ex) {
                        System.out.println(ERR_CONSULTA);
                }
                return habitacionDevol;
        }

        @Override
        public List<Habitacion> recuperarHabitacionesEstado(int idHotel,String estado) {
                try {   //se realiza la consulta
                        prepStatement = conexion.getConnection().prepareStatement(CONSULTAR_HABITACIONES_ESTADO);
                        prepStatement.setInt(1, idHotel);
                        prepStatement.setString(2, estado);
                        result = prepStatement.executeQuery();
                        //se extraen los resultados y se insertan en la lista
                        while (result.next()) {
                                listaRecuperacion.add(new Habitacion(result.getInt(1),result.getString(2),result.getInt(3),
                                        result.getDouble(4), result.getString(5),result.getDouble(6)));
                        }
                        result.close(); // Cerrar ResultSet
                        prepStatement.close();  //Cerrar PreparedStatement
                } catch (SQLException ex) {
                        System.out.println(ERR_CONSULTA);

                }
                return listaRecuperacion;
        }

        @Override
        public List<Habitacion> recuperarHabitacionesHotelEspecificco(int idHotel) {
                try {   //se realiza la consulta
                        prepStatement = conexion.getConnection().prepareStatement(CONSULTAR_HABITACIONES_HOTEL_ESPECIFICO);
                        prepStatement.setInt(1, idHotel);
                        result = prepStatement.executeQuery();
                        //se extraen los resultados y se insertan en la lista
                        while (result.next()) {
                                listaRecuperacion.add(new Habitacion(result.getInt(1),result.getString(2),result.getInt(3),
                                        result.getDouble(4), result.getString(5),result.getDouble(6)));
                        
                        }
                        result.close(); // Cerrar ResultSet
                        prepStatement.close();  //Cerrar PreparedStatement
                } catch (SQLException ex) {
                        System.out.println(ERR_CONSULTA);
                }
                return listaRecuperacion;
        }

        @Override
        public boolean registrarPuntuacionHabitacionHotel(ValoracionHabitacion valoracion) {
                try {
                        prepStatement = conexion.getConnection().prepareStatement(INSERTAR_VALORACION_HABITACION);
                        prepStatement.setInt(1, valoracion.getPuntuacion());
                        prepStatement.setString(2, valoracion.getComentario());
                        prepStatement.setString(3, valoracion.getFecha().toString());
                        prepStatement.setString(4, valoracion.getCliente().getNit());
                        prepStatement.setInt(5, valoracion.getHabitacion().getNumero());
                        prepStatement.setInt(6,valoracion.getHotel().getId());
                        prepStatement.executeUpdate();
                        prepStatement.close();  //Cerrar PreparedStatement
                        return true;
                } catch (SQLException ex) {           
                        System.out.println(ERR_INSERCION);
                        return false;
                }
        }

    

}
