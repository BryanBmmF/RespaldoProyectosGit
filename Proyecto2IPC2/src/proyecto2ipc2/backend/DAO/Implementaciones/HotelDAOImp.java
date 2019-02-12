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
import proyecto2ipc2.backend.DAO.Interfaces.HotelDAO;
import proyecto2ipc2.backend.Hotel.Hotel;
import proyecto2ipc2.backend.Hotel.IngresosHotel;
import proyecto2ipc2.database.Conexion;
import static proyecto2ipc2.database.OperadorEsquema.ACTUALIZAR_HOTEL;
import static proyecto2ipc2.database.OperadorEsquema.CONSULTAR_DATOS_HOTEL;
import static proyecto2ipc2.database.OperadorEsquema.CONSULTAR_NOMBRES_HOTELES;
import static proyecto2ipc2.database.OperadorEsquema.CONSULTAR_NUMERO_HABITACIONES;
import static proyecto2ipc2.database.OperadorEsquema.ELIMINAR_HOTEL;
import static proyecto2ipc2.database.OperadorEsquema.ERR_CONSULTA;
import static proyecto2ipc2.database.OperadorEsquema.ERR_INSERCION;
import static proyecto2ipc2.database.OperadorEsquema.INSERTAR_HOTEL;
import static proyecto2ipc2.database.OperadorEsquema.INSERTAR_INGRESO_HOTEL;

/**
 *
 * @author bryan
 */
public class HotelDAOImp implements HotelDAO{
        private Conexion conexion= new Conexion();
        private PreparedStatement prepStatement;
        private ResultSet result;
        private List listaRecuperacion = new ArrayList<>();
        @Override
        public boolean registrar(Hotel hotel) {
                try {
                        prepStatement = conexion.getConnection().prepareStatement(INSERTAR_HOTEL);
                        prepStatement.setString(1, hotel.getNombre());
                        prepStatement.setString(2, hotel.getDireccion());
                        prepStatement.executeUpdate();
                        prepStatement.close();  //Cerrar PreparedStatement
                        return true;
                } catch (SQLException ex) {           
                        System.out.println(ERR_INSERCION);
                        return false;
                }
        }

        @Override
        public List<Hotel> recuperarLista() {
                try {   //se realiza la consulta
                        prepStatement = conexion.getConnection().prepareStatement(CONSULTAR_NOMBRES_HOTELES);
                        result = prepStatement.executeQuery();
                        //se extraen los resultados y se insertan en la lista
                        while (result.next()) {
                                listaRecuperacion.add(new Hotel(result.getInt(1),result.getString(2),result.getString(3)));
                        
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
        public boolean actualizar(Hotel hotel, String temp) {
                try {
                        prepStatement = conexion.getConnection().prepareStatement(ACTUALIZAR_HOTEL);
                        prepStatement.setString(1, hotel.getNombre());
                        prepStatement.setString(2, hotel.getDireccion());
                        
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
        public boolean eliminar(Hotel hotel) {
                try {
                        prepStatement = conexion.getConnection().prepareStatement(ELIMINAR_HOTEL);
                        prepStatement.setString(1, hotel.getNombre());
                        prepStatement.executeUpdate();
                        prepStatement.close();  //Cerrar PreparedStatement
                        return true;
                } catch (SQLException ex) {
                        System.out.println(ERR_INSERCION);
                        return false;
                }
        }

        @Override
        public Hotel recuperarHotel(String nombre) {
                Hotel hotelDevol= null;
                    try {   //se realiza la consulta
                            prepStatement = conexion.getConnection().prepareStatement(CONSULTAR_DATOS_HOTEL);
                            prepStatement.setString(1,nombre);//parametro 1 estado
                            result = prepStatement.executeQuery();
                            result.next();
                            hotelDevol= new Hotel(result.getInt(1),result.getString(2),result.getString(3));
                            result.close(); // Cerrar ResultSet
                            prepStatement.close();  //Cerrar PreparedStatement
                    } catch (SQLException ex) {
                            System.out.println(ERR_CONSULTA);
                    }
                    return hotelDevol;
        }

        @Override
        public int recuperarNumeroHabitaciones(int idHotel) {
                int numHabitaciones= 0;
                    try {   //se realiza la consulta
                            prepStatement = conexion.getConnection().prepareStatement(CONSULTAR_NUMERO_HABITACIONES);
                            prepStatement.setInt(1,idHotel);//parametro 1 estado
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
        public boolean registrarIngresoHotel(IngresosHotel ingresoHotel) {
                try {
                        prepStatement = conexion.getConnection().prepareStatement(INSERTAR_INGRESO_HOTEL);
                        prepStatement.setDouble(1, ingresoHotel.getIngreso());
                        prepStatement.setString(2, ingresoHotel.getFecha().toString());
                        prepStatement.setInt(3, ingresoHotel.getHabitacion().getNumero());
                        prepStatement.setInt(4, ingresoHotel.getHotel().getId());
                        prepStatement.setString(5, ingresoHotel.getCliente().getNit());
                        prepStatement.executeUpdate();
                        prepStatement.close();  //Cerrar PreparedStatement
                        return true;
                } catch (SQLException ex) {           
                        System.out.println(ERR_INSERCION);
                        return false;
                }
        }

        

        

        
}
