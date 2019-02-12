/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2ipc2.backend.DAO.Implementaciones;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import proyecto2ipc2.backend.DAO.Interfaces.ReservacionDAO;
import proyecto2ipc2.backend.Hotel.Cliente;
import proyecto2ipc2.backend.Hotel.Habitacion;
import proyecto2ipc2.backend.Hotel.Hotel;
import proyecto2ipc2.backend.Hotel.Reservacion;
import proyecto2ipc2.database.Conexion;
import static proyecto2ipc2.database.OperadorEsquema.ACTUALIZAR_DIAS_RESERVACION;
import static proyecto2ipc2.database.OperadorEsquema.ACTUALIZAR_ESTADO_RESERVACION;
import static proyecto2ipc2.database.OperadorEsquema.ACTUALIZAR_FECHAS_RESERVACION;
import static proyecto2ipc2.database.OperadorEsquema.ACTUALIZAR_RESERVACION;
import static proyecto2ipc2.database.OperadorEsquema.CONSULTAR_FECHA_RESERVACION;
import static proyecto2ipc2.database.OperadorEsquema.CONSULTAR_NUMERO_RESERVACION;
import static proyecto2ipc2.database.OperadorEsquema.CONSULTAR_RESERVACION;
import static proyecto2ipc2.database.OperadorEsquema.CONSULTAR_RESERVACIONES;
import static proyecto2ipc2.database.OperadorEsquema.CONSULTAR_RESERVACIONES_CLIENTE;
import static proyecto2ipc2.database.OperadorEsquema.CONSULTAR_RESERVACIONES_CLIENTE_PARA_EXTENSION;
import static proyecto2ipc2.database.OperadorEsquema.CONSULTAR_RESERVACIONES_CLIENTE_RETIRO;
import static proyecto2ipc2.database.OperadorEsquema.CONSULTAR_RESERVACIONES_ENTRE_FECHAS;
import static proyecto2ipc2.database.OperadorEsquema.CONSULTAR_RESERVACIONES_ENTRE_FECHAS_EXCLUYENDO;
import static proyecto2ipc2.database.OperadorEsquema.CONSULTAR_RESERVACIONES_HABITACIONES_HOTEL;
import static proyecto2ipc2.database.OperadorEsquema.CONSULTAR_RESERVACIONES_HOTEL;
import static proyecto2ipc2.database.OperadorEsquema.ELIMINAR_RESERVACION;
import static proyecto2ipc2.database.OperadorEsquema.ERR_CONSULTA;
import static proyecto2ipc2.database.OperadorEsquema.ERR_INSERCION;
import static proyecto2ipc2.database.OperadorEsquema.INSERTAR_RESERVACION;

/**
 *
 * @author bryan
 */
public class ReservacionDAOImp implements ReservacionDAO{
        private Conexion conexion= new Conexion();
        private PreparedStatement prepStatement;
        private ResultSet result;
        private Cliente cliente;
        private Habitacion habitacion;
        private Hotel hotel;
        
        private List listaRecuperacion = new ArrayList<>();
        @Override
        public boolean registrar(Reservacion reservacion) {
                try {   
                        String fechaIngreso = reservacion.getFechaIngreso().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
                        String fechaRetiro = reservacion.getFechaRetiro().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
                        
                        prepStatement = conexion.getConnection().prepareStatement(INSERTAR_RESERVACION);
                        prepStatement.setString(1, reservacion.getCliente().getNombre());
                        prepStatement.setDouble(2, reservacion.getHabitacion().getPrecio());
                        prepStatement.setString(3, fechaIngreso);
                        prepStatement.setString(4, fechaRetiro);
                        prepStatement.setString(5, reservacion.getEstado());
                        prepStatement.setString(6, reservacion.getCliente().getNit());
                        prepStatement.setInt(7, reservacion.getHabitacion().getNumero());
                        prepStatement.setInt(8, reservacion.getHotel().getId());
                        
                        prepStatement.executeUpdate();
                        prepStatement.close();  //Cerrar PreparedStatement
                        return true;
                } catch (SQLException ex) {           
                        System.out.println(ERR_INSERCION);
                        return false;
                }
        }


        @Override
        public boolean actualizar(Reservacion reservacion, String idTemp) {
                try {   
                        String fechaIngreso = reservacion.getFechaIngreso().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
                        String fechaRetiro = reservacion.getFechaRetiro().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
                        
                        prepStatement = conexion.getConnection().prepareStatement(ACTUALIZAR_RESERVACION);
                        prepStatement.setString(1, reservacion.getCliente().getNombre());
                        prepStatement.setDouble(2, reservacion.getHabitacion().getPrecio());
                        prepStatement.setString(3, fechaIngreso);
                        prepStatement.setString(4, fechaRetiro);
                        prepStatement.setString(5, reservacion.getEstado());
                        prepStatement.setString(6, reservacion.getCliente().getNit());
                        prepStatement.setInt(7, reservacion.getHabitacion().getNumero());
                        prepStatement.setInt(8, reservacion.getHotel().getId());
                        
                        prepStatement.setInt(9, Integer.parseInt(idTemp));
                        
                        prepStatement.executeUpdate();
                        prepStatement.close();  //Cerrar PreparedStatement
                        return true;
                } catch (SQLException ex) {           
                        System.out.println(ERR_INSERCION);
                        return false;
                }
        }

        @Override
        public boolean eliminar(Reservacion reservacion) {
                try {
                        prepStatement = conexion.getConnection().prepareStatement(ELIMINAR_RESERVACION);
                        prepStatement.setInt(1, reservacion.getNumero());
                        prepStatement.executeUpdate();
                        prepStatement.close();  //Cerrar PreparedStatement
                        return true;
                } catch (SQLException ex) {
                        System.out.println(ERR_INSERCION);
                        return false;
                }
        }

        @Override
        public List<Reservacion> recuperarLista() {
                try {   //se realiza la consulta
                        //Connection connection= establecerConexion();
                        prepStatement = conexion.getConnection().prepareStatement(CONSULTAR_RESERVACIONES);
                        result = prepStatement.executeQuery();
                        //se extraen los resultados y se insertan en la lista
                        while (result.next()) {
                                cliente= new Cliente(result.getString(7), result.getString(2));
                                habitacion = new Habitacion(result.getInt(8), result.getDouble(3));
                                hotel = new Hotel(result.getInt(9));
                                listaRecuperacion.add(new Reservacion(result.getInt(1),cliente,habitacion,
                                result.getDate(4).toLocalDate(),result.getDate(5).toLocalDate(),result.getString(6),hotel));
                        
                        }
                        result.close(); // Cerrar ResultSet
                        prepStatement.close();  //Cerrar PreparedStatement
                } catch (SQLException ex) {
                        System.out.println(ERR_CONSULTA);
                        
                }
                return listaRecuperacion;
        }

        @Override
        public boolean actualizarDiasReservacion(int dias, int id) {
                try {
                        //Connection connection= establecerConexion();
                        prepStatement = conexion.getConnection().prepareStatement(ACTUALIZAR_DIAS_RESERVACION);
                        prepStatement.setInt(1, dias);
                        prepStatement.setInt(2, id);

                        prepStatement.executeUpdate();
                        prepStatement.close();  //Cerrar PreparedStatement
                        return true;
                } catch (SQLException ex) {
                        System.out.println(ERR_INSERCION+" Insercion de Dias");
                        return false;
                }
        }

        @Override
        public Reservacion recuperarReservacion(String nombreCliente) {
                Reservacion reservacionDevol= null;
                try {   //se realiza la consulta
                        //Connection connection= establecerConexion();
                        prepStatement = conexion.getConnection().prepareStatement(CONSULTAR_RESERVACION);
                        prepStatement.setString(1,nombreCliente);//parametro 1 estado
                        result = prepStatement.executeQuery();
                        result.next();
                        cliente= new Cliente(result.getString(7), result.getString(2));
                        habitacion = new Habitacion(result.getInt(8), result.getDouble(3));
                        hotel = new Hotel(result.getInt(9));
                        reservacionDevol = new Reservacion(result.getInt(1),cliente,habitacion,
                        result.getDate(4).toLocalDate(),result.getDate(5).toLocalDate(),result.getString(6),hotel);
                        result.close(); // Cerrar ResultSet
                        prepStatement.close();  //Cerrar PreparedStatement
                } catch (SQLException ex) {
                        System.out.println(ERR_CONSULTA);
                }
                return reservacionDevol;

        }

        @Override
        public Reservacion recuperarReservacionConFecha(String fechaIn, String fechaRet,int numeHabitacion,int idHotel) {
                Reservacion reservacionDevol= null;
                try {   //se realiza la consulta
                        //Connection connection= establecerConexion();
                        prepStatement = conexion.getConnection().prepareStatement(CONSULTAR_FECHA_RESERVACION);
                        prepStatement.setString(1,fechaIn);//parametro 1 estado
                        prepStatement.setString(2,fechaRet);//parametro 1 estado
                        prepStatement.setInt(3,numeHabitacion);//parametro 5 estado
                        prepStatement.setInt(4,idHotel);//parametro 6 estado
                        result = prepStatement.executeQuery();
                        result.next();
                        cliente= new Cliente(result.getString(7), result.getString(2));
                        habitacion = new Habitacion(result.getInt(8), result.getDouble(3));
                        hotel = new Hotel(result.getInt(9));
                        reservacionDevol = new Reservacion(result.getInt(1),cliente,habitacion,
                        result.getDate(4).toLocalDate(),result.getDate(5).toLocalDate(),result.getString(6),hotel);
                        result.close(); // Cerrar ResultSet
                        prepStatement.close();  //Cerrar PreparedStatement
                } catch (SQLException ex) {
                        System.out.println(ERR_CONSULTA);
                }
                return reservacionDevol;
        }

        @Override
        public Reservacion recuperarNumeroReservacion(int numero) {
                Reservacion reservacionDevol= null;
                try {   //se realiza la consulta
                        //Connection connection= establecerConexion();
                        prepStatement = conexion.getConnection().prepareStatement(CONSULTAR_NUMERO_RESERVACION);
                        prepStatement.setInt(1,numero);//parametro 1 estado
                        result = prepStatement.executeQuery();
                        result.next();
                        cliente= new Cliente(result.getString(7), result.getString(2));
                        habitacion = new Habitacion(result.getInt(8), result.getDouble(3));
                        hotel = new Hotel(result.getInt(9));
                        reservacionDevol = new Reservacion(result.getInt(1),cliente,habitacion,
                        result.getDate(4).toLocalDate(),result.getDate(5).toLocalDate(),result.getString(6),hotel);
                        result.close(); // Cerrar ResultSet
                        prepStatement.close();  //Cerrar PreparedStatement
                } catch (SQLException ex) {
                        System.out.println(ERR_CONSULTA);
                }
                return reservacionDevol;
        }

        @Override
        public List<Reservacion> resuperarReservacionesHotel(int idHotel) {
                try {   //se realiza la consulta
                        prepStatement = conexion.getConnection().prepareStatement(CONSULTAR_RESERVACIONES_HOTEL);
                        prepStatement.setInt(1,idHotel);//parametro 1 estado
                        result = prepStatement.executeQuery();
                        //se extraen los resultados y se insertan en la lista
                        while (result.next()) {               
                                cliente= new Cliente(result.getString(7), result.getString(2));
                                habitacion = new Habitacion(result.getInt(8), result.getDouble(3));
                                hotel = new Hotel(result.getInt(9));
                                listaRecuperacion.add(new Reservacion(result.getInt(1),cliente,habitacion,
                                result.getDate(4).toLocalDate(),result.getDate(5).toLocalDate(),result.getString(6),hotel));
                        
                        }
                        result.close(); // Cerrar ResultSet
                        prepStatement.close();  //Cerrar PreparedStatement
                } catch (SQLException ex) {
                        System.out.println(ERR_CONSULTA);
                        
                }
                return listaRecuperacion;
        }

        @Override
        public List<Reservacion> resuperarReservacionesHabitacionesHotel(int idHotel, String fecha) {
                try {   //se realiza la consulta
                        prepStatement = conexion.getConnection().prepareStatement(CONSULTAR_RESERVACIONES_HABITACIONES_HOTEL);
                        prepStatement.setInt(1,idHotel);//parametro 1 estado
                        prepStatement.setString(2,fecha);//parametro 1 estado
                        result = prepStatement.executeQuery();
                        //se extraen los resultados y se insertan en la lista
                        while (result.next()) {
                                habitacion = new Habitacion(result.getInt(1), result.getString(2));
                                listaRecuperacion.add(new Reservacion(habitacion,result.getDate(3).toLocalDate(),result.getDate(4).toLocalDate()));
                        }
                        result.close(); // Cerrar ResultSet
                        prepStatement.close();  //Cerrar PreparedStatement
                } catch (SQLException ex) {
                        System.out.println(ERR_CONSULTA);
                        
                }
                return listaRecuperacion;
        }

        @Override
        public List<Reservacion> verificarDisponibilidadHabitacion(String fIngreso, String fRetiro, int numHabitacion, int idHotel) {
                
                //java.sql.Date dateingreso = java.sql.Date.valueOf(LocalDate.parse(fIngreso)); //LO CORRECTO setDate 
                //java.sql.Date dateRetiro = java.sql.Date.valueOf(LocalDate.parse(fRetiro));
                
                try {   //se realiza la consulta
                        prepStatement = conexion.getConnection().prepareStatement(CONSULTAR_RESERVACIONES_ENTRE_FECHAS);
                        prepStatement.setString(1,fIngreso);//parametro 1 estado
                        prepStatement.setString(2,fRetiro);//parametro 2 estado
                        prepStatement.setString(3,fIngreso);//parametro 3 estado
                        prepStatement.setString(4,fRetiro);//parametro 4 estado
                        prepStatement.setInt(5,numHabitacion);//parametro 5 estado
                        prepStatement.setInt(6,idHotel);//parametro 6 estado
                        
                        result = prepStatement.executeQuery();
                        //se extraen los resultados y se insertan en la lista
                        while (result.next()) {               
                                cliente= new Cliente(result.getString(7), result.getString(2));
                                habitacion = new Habitacion(result.getInt(8), result.getDouble(3));
                                hotel = new Hotel(result.getInt(9));
                                listaRecuperacion.add(new Reservacion(result.getInt(1),cliente,habitacion,
                                result.getDate(4).toLocalDate(),result.getDate(5).toLocalDate(),result.getString(6),hotel));
                        }
                        result.close(); // Cerrar ResultSet
                        prepStatement.close();  //Cerrar PreparedStatement
                } catch (SQLException ex) {
                        System.out.println(ERR_CONSULTA);
                }
                return listaRecuperacion;
        }

        @Override
        public List<Reservacion> verificarDisponibilidadHabitacionExcluyendo(String fIngreso, String fRetiro, int numHabitacion, int idHotel, int idReserv) {
                
                try {   //se realiza la consulta
                        prepStatement = conexion.getConnection().prepareStatement(CONSULTAR_RESERVACIONES_ENTRE_FECHAS_EXCLUYENDO);
                        prepStatement.setString(1,fIngreso);//parametro 1 estado
                        prepStatement.setString(2,fRetiro);//parametro 2 estado
                        prepStatement.setString(3,fIngreso);//parametro 3 estado
                        prepStatement.setString(4,fRetiro);//parametro 4 estado
                        prepStatement.setInt(5,numHabitacion);//parametro 5 estado
                        prepStatement.setInt(6,idHotel);//parametro 6 estado
                        prepStatement.setInt(7,idReserv);//parametro 6 estado
                        
                        result = prepStatement.executeQuery();
                        //se extraen los resultados y se insertan en la lista
                        while (result.next()) {               
                                cliente= new Cliente(result.getString(7), result.getString(2));
                                habitacion = new Habitacion(result.getInt(8), result.getDouble(3));
                                hotel = new Hotel(result.getInt(9));
                                listaRecuperacion.add(new Reservacion(result.getInt(1),cliente,habitacion,
                                result.getDate(4).toLocalDate(),result.getDate(5).toLocalDate(),result.getString(6),hotel));
                        }
                        result.close(); // Cerrar ResultSet
                        prepStatement.close();  //Cerrar PreparedStatement
                } catch (SQLException ex) {
                        System.out.println(ERR_CONSULTA);
                }
                return listaRecuperacion;
        }

        @Override
        public List<Reservacion> recuperarReservacionesCliente(int idHotel, String fechaActual, String nitCliente, String estado) {
                try {   //se realiza la consulta
                            prepStatement = conexion.getConnection().prepareStatement(CONSULTAR_RESERVACIONES_CLIENTE);
                            prepStatement.setInt(1,idHotel);//parametro 1 estado
                            prepStatement.setString(2,nitCliente);//parametro 2 estado
                            prepStatement.setString(3,fechaActual);//parametro 3 estado
                            prepStatement.setString(4,estado);//parametro 4 estado
                            result = prepStatement.executeQuery();
                            //se extraen los resultados y se insertan en la lista
                            while (result.next()) {               
                                    cliente= new Cliente(result.getString(7), result.getString(2));
                                    habitacion = new Habitacion(result.getInt(8), result.getDouble(3));
                                    hotel = new Hotel(result.getInt(9));
                                    listaRecuperacion.add(new Reservacion(result.getInt(1),cliente,habitacion,
                                    result.getDate(4).toLocalDate(),result.getDate(5).toLocalDate(),result.getString(6),hotel));
                            }
                            result.close(); // Cerrar ResultSet
                            prepStatement.close();  //Cerrar PreparedStatement
                    } catch (SQLException ex) {
                            System.out.println(ERR_CONSULTA);

                    }
                    return listaRecuperacion;
        }

        @Override
        public List<Reservacion> recuperarReservacionesClienteRetiro(int idHotel, String fechaActual, String nitCliente, String estado) {
                try {   //se realiza la consulta
                            prepStatement = conexion.getConnection().prepareStatement(CONSULTAR_RESERVACIONES_CLIENTE_RETIRO);
                            prepStatement.setInt(1,idHotel);//parametro 1 estado
                            prepStatement.setString(2,nitCliente);//parametro 2 estado
                            prepStatement.setString(3,fechaActual);//parametro 3 estado
                            prepStatement.setString(4,estado);//parametro 4 estado
                            result = prepStatement.executeQuery();
                            //se extraen los resultados y se insertan en la lista
                            while (result.next()) {               
                                    cliente= new Cliente(result.getString(7), result.getString(2));
                                    habitacion = new Habitacion(result.getInt(8), result.getDouble(3));
                                    hotel = new Hotel(result.getInt(9));
                                    listaRecuperacion.add(new Reservacion(result.getInt(1),cliente,habitacion,
                                    result.getDate(4).toLocalDate(),result.getDate(5).toLocalDate(),result.getString(6),hotel));
                            }
                            result.close(); // Cerrar ResultSet
                            prepStatement.close();  //Cerrar PreparedStatement
                    } catch (SQLException ex) {
                            System.out.println(ERR_CONSULTA);

                    }
                    return listaRecuperacion;
        }

        @Override
        public boolean actualizarEstadoReservacion(int idReservacion, String estado) {
                try {   
                        prepStatement = conexion.getConnection().prepareStatement(ACTUALIZAR_ESTADO_RESERVACION); 
                        prepStatement.setString(1, estado);
                        prepStatement.setInt(2,idReservacion);
                        prepStatement.executeUpdate();
                        prepStatement.close();  //Cerrar PreparedStatement
                        return true;
                } catch (SQLException ex) {           
                        System.out.println(ERR_INSERCION);
                        return false;
                }
        }

        @Override
        public boolean actualizarFechasReservacion(Reservacion reservacion) {
                try {   
                        prepStatement = conexion.getConnection().prepareStatement(ACTUALIZAR_FECHAS_RESERVACION);
                        prepStatement.setString(1, reservacion.getFechaIngreso().toString());
                        prepStatement.setString(2, reservacion.getFechaRetiro().toString());
                        prepStatement.setInt(3, reservacion.getNumero());
                        
                        prepStatement.executeUpdate();
                        prepStatement.close();  //Cerrar PreparedStatement
                        return true;
                } catch (SQLException ex) {           
                        System.out.println(ERR_INSERCION);
                        return false;
                }
        }

        @Override
        public List<Reservacion> recuperarReservacionesClienteActivasParaExtension(int idHotel, String nitCliente, String estado) {
                try {   //se realiza la consulta
                            prepStatement = conexion.getConnection().prepareStatement(CONSULTAR_RESERVACIONES_CLIENTE_PARA_EXTENSION);
                            prepStatement.setInt(1,idHotel);//parametro 1 estado
                            prepStatement.setString(2,nitCliente);//parametro 2 estado
                            prepStatement.setString(3,estado);//parametro 4 estado
                            result = prepStatement.executeQuery();
                            //se extraen los resultados y se insertan en la lista
                            while (result.next()) {               
                                    cliente= new Cliente(result.getString(7), result.getString(2));
                                    habitacion = new Habitacion(result.getInt(8), result.getDouble(3));
                                    hotel = new Hotel(result.getInt(9));
                                    listaRecuperacion.add(new Reservacion(result.getInt(1),cliente,habitacion,
                                    result.getDate(4).toLocalDate(),result.getDate(5).toLocalDate(),result.getString(6),hotel));
                            }
                            result.close(); // Cerrar ResultSet
                            prepStatement.close();  //Cerrar PreparedStatement
                    } catch (SQLException ex) {
                            System.out.println(ERR_CONSULTA);

                    }
                    return listaRecuperacion;
        }

}
