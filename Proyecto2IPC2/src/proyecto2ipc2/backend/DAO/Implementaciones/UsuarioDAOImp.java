/*
 * Clase de Implementacion para un Usuario DAO
 */
package proyecto2ipc2.backend.DAO.Implementaciones;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import proyecto2ipc2.backend.DAO.Interfaces.UsuarioDAO;
import proyecto2ipc2.backend.Hotel.Hotel;
import proyecto2ipc2.backend.Restaurante.Restaurante;
import proyecto2ipc2.backend.User.Usuario;
import proyecto2ipc2.database.Conexion;
import static proyecto2ipc2.database.OperadorEsquema.ACTUALIZAR_USUARIO;
import static proyecto2ipc2.database.OperadorEsquema.ASIGNAR_USUARIO_HOTEL;
import static proyecto2ipc2.database.OperadorEsquema.ASIGNAR_USUARIO_RESTAURANTE;
import static proyecto2ipc2.database.OperadorEsquema.CONSULTAR_HOTEL;
import static proyecto2ipc2.database.OperadorEsquema.CONSULTAR_RESTAURANTE;
import static proyecto2ipc2.database.OperadorEsquema.CONSULTAR_USER;
import static proyecto2ipc2.database.OperadorEsquema.CONSULTAR_USUARIOS;
import static proyecto2ipc2.database.OperadorEsquema.CONSULTA_USER_PASS;
import static proyecto2ipc2.database.OperadorEsquema.DESASIGNAR_USUARIO_HOTEL;
import static proyecto2ipc2.database.OperadorEsquema.DESASIGNAR_USUARIO_RESTAURANTE;
import static proyecto2ipc2.database.OperadorEsquema.ELIMINAR_USUARIO;
import static proyecto2ipc2.database.OperadorEsquema.ERR_CONSULTA;
import static proyecto2ipc2.database.OperadorEsquema.ERR_INSERCION;
import static proyecto2ipc2.database.OperadorEsquema.INSERTAR_USUARIO;

/**
 *
 * @author bryan
 */
public class UsuarioDAOImp implements UsuarioDAO {
        //objeto conexion //prepared statement y resultset
        private Conexion conexion= new Conexion();
        private PreparedStatement prepStatement;
        private ResultSet result;
        private List listaRecuperacion = new ArrayList<>();
        @Override
        public boolean registrar(Usuario user) {
                try {
                        prepStatement = conexion.getConnection().prepareStatement(INSERTAR_USUARIO);
                        prepStatement.setString(1, user.getUser());
                        prepStatement.setString(2, user.getPass());
                        prepStatement.setString(3, user.getNombre());
                        prepStatement.setString(4, user.getCui());
                        prepStatement.setString(5, user.getTipo());
                        prepStatement.setString(6, user.getEstado());
                        prepStatement.setDouble(7, user.getSlario());
                        prepStatement.executeUpdate();
                        prepStatement.close();  //Cerrar PreparedStatement
                        return true;
                } catch (SQLException ex) {           
                        System.out.println(ERR_INSERCION);
                        return false;
                }
        }
        @Override
        public boolean actualizar(Usuario user,String userTemp) {
                try {
                        prepStatement = conexion.getConnection().prepareStatement(ACTUALIZAR_USUARIO);
                        prepStatement.setString(1, user.getUser());
                        prepStatement.setString(2, user.getPass());
                        prepStatement.setString(3, user.getNombre());
                        prepStatement.setString(4, user.getCui());
                        prepStatement.setString(5, user.getTipo());
                        prepStatement.setString(6, user.getEstado());
                        prepStatement.setDouble(7, user.getSlario());
                        prepStatement.setString(8, userTemp);
                        prepStatement.executeUpdate();
                        prepStatement.close();  //Cerrar PreparedStatement
                        return true;
                } catch (SQLException ex) {
                        System.out.println(ERR_INSERCION);
                        return false;
                }

        }

        @Override
        public boolean eliminar(Usuario user) {
                try {
                        prepStatement = conexion.getConnection().prepareStatement(ELIMINAR_USUARIO);
                        prepStatement.setString(1, user.getUser());
                        prepStatement.executeUpdate();
                        prepStatement.close();  //Cerrar PreparedStatement
                        return true;
                } catch (SQLException ex) {
                        System.out.println(ERR_INSERCION);
                        return false;
                }

        }

        @Override
        public Usuario recuperarUsuario(String user) {
                Usuario userDevol= null;
                    try {   //se realiza la consulta
                            prepStatement = conexion.getConnection().prepareStatement(CONSULTAR_USER);
                            prepStatement.setString(1,user);//parametro 1 estado
                            result = prepStatement.executeQuery();
                            result.next();
                            userDevol= new Usuario(result.getString(1),result.getString(2),result.getString(3),
                                            result.getString(4), result.getString(5), result.getString(6), result.getDouble(7));
                            result.close(); // Cerrar ResultSet
                            prepStatement.close();  //Cerrar PreparedStatement
                    } catch (SQLException ex) {
                            System.out.println(ERR_CONSULTA);
                    }
                    return userDevol;
        }

        @Override
        public List<Usuario> recuperarLista() {
                try {   //se realiza la consulta
                        prepStatement = conexion.getConnection().prepareStatement(CONSULTAR_USUARIOS);
                        result = prepStatement.executeQuery();
                        //se extraen los resultados y se insertan en la lista
                        while (result.next()) {
                                listaRecuperacion.add(new Usuario(result.getString(1),result.getString(2),result.getString(3),
                                        result.getString(4), result.getString(5), result.getString(6),result.getDouble(7)));
                        
                        }
                        result.close(); // Cerrar ResultSet
                        prepStatement.close();  //Cerrar PreparedStatement
                } catch (SQLException ex) {
                        System.out.println(ERR_CONSULTA);
                        
                }
                return listaRecuperacion;
        }

        @Override
        public String validarUsuario(String user, String pass) {
                String tipoUser=null;
                try {   //se realiza la validacion de usuario
                        //Connection connection= establecerConexion();
                        prepStatement = conexion.getConnection().prepareStatement(CONSULTA_USER_PASS);
                        prepStatement.setString(1, user);//parametro de entrada 1 user
                        result = prepStatement.executeQuery();
                        result.next();
                        if (result.getString(2).equals(pass)) {
                                tipoUser= result.getString(3);
                        }      
                        result.close(); // Cerrar ResultSet
                        prepStatement.close();  //Cerrar PreparedStatement
                } catch (SQLException ex) {
                        System.out.println(ERR_CONSULTA);
                }
                //se retorna el Tipo de usuario para darle acceso al sistema
                return tipoUser;
        }
        @Override
        public Hotel recuperarHotel(String user) {
                Hotel hotelDevol= null;
                try {   //se realiza la consulta
                        //Connection connection= establecerConexion();
                        prepStatement = conexion.getConnection().prepareStatement(CONSULTAR_HOTEL);
                        prepStatement.setString(1,user);//parametro 1 estado
                        result = prepStatement.executeQuery();
                        result.next();
                        hotelDevol= new Hotel(result.getInt(1), result.getString(2),
                                result.getString(3));
                        result.close(); // Cerrar ResultSet
                        prepStatement.close();  //Cerrar PreparedStatement
                } catch (SQLException ex) {
                        System.out.println(ERR_CONSULTA);
                }
                return hotelDevol;
        }

        @Override
        public Restaurante recuperarUsuarioRestaurante(String user) {
                Restaurante restDevol= null;
                try {   //se realiza la consulta
                        prepStatement = conexion.getConnection().prepareStatement(CONSULTAR_RESTAURANTE);
                        prepStatement.setString(1,user);//parametro 1 estado
                        result = prepStatement.executeQuery();
                        result.next();
                        restDevol= new Restaurante(result.getInt(1), result.getString(2),
                                result.getString(3));
                        result.close(); // Cerrar ResultSet
                        prepStatement.close();  //Cerrar PreparedStatement
                } catch (SQLException ex) {
                        System.out.println(ERR_CONSULTA);
                }
                return restDevol;
        }

        @Override
        public boolean asignarHotel(String user, int idHotel) {
                try {
                        prepStatement = conexion.getConnection().prepareStatement(ASIGNAR_USUARIO_HOTEL);
                        prepStatement.setString(1, user);
                        prepStatement.setInt(2, idHotel);
                        prepStatement.executeUpdate();
                        prepStatement.close();  //Cerrar PreparedStatement
                        return true;
                } catch (SQLException ex) {           
                        System.out.println(ERR_INSERCION);
                        return false;
                }
        }

        @Override
        public boolean asignarRestaurante(String user, int idRestaurante) {
                try {
                        prepStatement = conexion.getConnection().prepareStatement(ASIGNAR_USUARIO_RESTAURANTE);
                        prepStatement.setString(1, user);
                        prepStatement.setInt(2, idRestaurante);
                        prepStatement.executeUpdate();
                        prepStatement.close();  //Cerrar PreparedStatement
                        return true;
                } catch (SQLException ex) {           
                        System.out.println(ERR_INSERCION);
                        return false;
                }
        }

        @Override
        public boolean desasignarHotel(String user) {
                try {
                        prepStatement = conexion.getConnection().prepareStatement(DESASIGNAR_USUARIO_HOTEL);
                        prepStatement.setString(1, user);
                        prepStatement.executeUpdate();
                        prepStatement.close();  //Cerrar PreparedStatement
                        return true;
                } catch (SQLException ex) {
                        System.out.println(ERR_INSERCION);
                        return false;
                }
        }

        @Override
        public boolean desasignarRestaurante(String user) {
                try {
                        prepStatement = conexion.getConnection().prepareStatement(DESASIGNAR_USUARIO_RESTAURANTE);
                        prepStatement.setString(1, user);
                        prepStatement.executeUpdate();
                        prepStatement.close();  //Cerrar PreparedStatement
                        return true;
                } catch (SQLException ex) {
                        System.out.println(ERR_INSERCION);
                        return false;
                }
        }

   

}
