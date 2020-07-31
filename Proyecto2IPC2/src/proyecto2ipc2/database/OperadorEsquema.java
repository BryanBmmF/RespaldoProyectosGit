/*
 * Clase Operador Esquema, para realizar DDL y DML
 */
package proyecto2ipc2.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import proyecto2ipc2.backend.User.Usuario;

/**
 *
 * @author bryan
 */
public class OperadorEsquema {
        
        //QUERYS PARA ELIMINACION Y DESASIGNACION DE DATOS
        public static final String ELIMINAR_USUARIO="DELETE FROM USUARIO WHERE User=?"; 
        public static final String ELIMINAR_HOTEL="DELETE FROM HOTEL WHERE Nombre=?";
        public static final String ELIMINAR_HABITACION="DELETE FROM HABITACION WHERE Numero=? AND ID_Hotel=?";
        public static final String ELIMINAR_RESTAURANTE="DELETE FROM RESTAURANTE WHERE Nombre=?"; 
        public static final String ELIMINAR_MENU="DELETE FROM MENU WHERE ID=? AND ID_Restaurante=?"; 
        public static final String ELIMINAR_RESERVACION="DELETE FROM RESERVACION WHERE ID=?";
        public static final String DESASIGNAR_USUARIO_HOTEL="DELETE FROM REG_EMPLEADO_HOTEL WHERE User_Empleado_Hotel=?";
        public static final String DESASIGNAR_USUARIO_RESTAURANTE="DELETE FROM REG_EMPLEADO_REST WHERE User_Empleado_Rest=?"; 
        
        //QUERYS PARA CONSULTA Y RECUPERACION DE DATOS
        public static final String CONSULTA_USER_PASS="SELECT User,Pass,Tipo FROM USUARIO WHERE User=?"; 
        public static final String CONSULTAR_HOTEL="SELECT HOTEL.ID,HOTEL.Nombre,HOTEL.Direccion FROM HOTEL INNER JOIN REG_EMPLEADO_HOTEL ON "
                + "                                 REG_EMPLEADO_HOTEL.ID_Hotel=HOTEL.ID WHERE User_Empleado_Hotel=?";
        public static final String CONSULTAR_DATOS_HOTEL="SELECT*FROM HOTEL WHERE Nombre=?";
        public static final String CONSULTAR_DATOS_RESTAURANTE="SELECT*FROM RESTAURANTE WHERE Nombre=?";
        public static final String CONSULTAR_RESTAURANTE="SELECT RESTAURANTE.ID,RESTAURANTE.Nombre,RESTAURANTE.Direccion FROM RESTAURANTE INNER JOIN "
                + "                                 REG_EMPLEADO_REST ON REG_EMPLEADO_REST.Id_Restaurante=RESTAURANTE.ID WHERE User_Empleado_Rest=?";        
        public static final String CONSULTAR_USER="SELECT*FROM USUARIO WHERE User=?";
        
        public static final String CONSULTAR_MENU="SELECT*FROM MENU WHERE ID=? AND ID_Restaurante=?";
        public static final String CONSULTAR_RESTAURANTE_UNICO="SELECT*FROM RESTAURANTE WHERE ID=?";
        public static final String CONSULTAR_RESTAURANTE_UNICO2="SELECT*FROM RESTAURANTE WHERE Nombre=?";
        public static final String CONSULTAR_RESERVACION="SELECT*FROM RESERVACION WHERE Nombre_Huesped=?";
        public static final String CONSULTAR_FECHA_RESERVACION="SELECT*FROM RESERVACION WHERE Fecha_Ingreso=? AND Fecha_Retiro=? AND Numero_Habitacion=? AND ID_Hotel_Habitacion=?";
        public static final String CONSULTAR_NUMERO_RESERVACION="SELECT*FROM RESERVACION WHERE ID=?";
        public static final String CONSULTAR_HABITACION="SELECT*FROM HABITACION WHERE Numero=? AND ID_Hotel=?";
        
        //QUERYS PARA INSERCION Y ASIGNACION  DE DATOS
        public static final String INSERTAR_USUARIO="INSERT INTO USUARIO VALUES(?,?,?,?,?,?,?)";
        public static final String INSERTAR_HOTEL="INSERT INTO HOTEL(Nombre,Direccion) VALUES(?,?)";
        public static final String INSERTAR_INGRESO_HOTEL="INSERT INTO REG_INGRESOS_ALOJAMIENTO(Ingreso,Fecha_Ingreso,Numero_Habitacion,ID_Hotel_Habitacion,NIT_Cliente) VALUES (?,?,?,?,?)";
        public static final String INSERTAR_HABITACION="INSERT INTO HABITACION VALUES (?,?,?,?,?,?,?,?)";
        public static final String INSERTAR_VALORACION_HABITACION="INSERT INTO VALORACION_HABITACION (Puntuacion,Comentario,Fecha_Valoracion,NIT_Cliente,Numero_Habitacion,ID_Hotel_Habitacion)VALUES (?,?,?,?,?,?)";
        public static final String INSERTAR_RESTAURANTE="INSERT INTO RESTAURANTE(Nombre,Direccion)VALUES(?,?)";
        public static final String INSERTAR_INGRESO_RESTAURANTE="INSERT INTO REG_INGRESOS_RESTAURANTE(Ingreso,Fecha_Ingreso,ID_Restaurante) VALUES (?,?,?)";
        public static final String INSERTAR_VALORACION_RESTAURANTE="INSERT INTO VALORACION_REST (Puntuacion,Comentario,Fecha_Valoracion,ID_Restaurante,NIT_Cliente) VALUES(?,?,?,?,?)";
        //public static final String INSERTAR_CLIENTE="INSERT INTO CLIENTE VALUES(?,?,?,?,?)";
        public static final String INSERTAR_MENU="INSERT INTO MENU(ID,Tipo,Nombre,Descripcion,Precio,Costo_Fabricacion,ID_Restaurante,Promo) VALUES(?,?,?,?,?,?,?,?)";
        public static final String INSERTAR_RESERVACION="INSERT INTO RESERVACION(Nombre_Huesped,Precio_Habitacion,"
                + "                                         Fecha_Ingreso,Fecha_Retiro,Estado,NIT_Cliente,Numero_Habitacion,ID_Hotel_Habitacion) VALUES(?,?,?,?,?,?,?,?)";
        public static final String INSERTAR_CONSUMO="INSERT INTO CONSUMO(No_Porciones,ID_Menu,Nombre_Menu,Precio_Menu,Nombre_Cliente,NIT_Cliente,Fecha_Consumo,ID_Restaurante) VALUES(?,?,?,?,?,?,?,?)";
        public static final String ASIGNAR_USUARIO_HOTEL="INSERT INTO REG_EMPLEADO_HOTEL(User_Empleado_Hotel,ID_Hotel) VALUES (?,?)";
        public static final String ASIGNAR_USUARIO_RESTAURANTE="INSERT INTO REG_EMPLEADO_REST(User_Empleado_Rest,ID_Restaurante) VALUES (?,?)";
        
        //QUERYS PARA ACTUALIZACION DE DATOS
        public static final String ACTUALIZAR_USUARIO="UPDATE USUARIO SET User=?,Pass=?,Nombre=?,CUI=?,Tipo=?,Estado=?,Salario=? WHERE User=?";
        public static final String ACTUALIZAR_HOTEL="UPDATE HOTEL SET Nombre=?,Direccion=? WHERE Nombre=?";
        public static final String ACTUALIZAR_RESTAURANTE="UPDATE RESTAURANTE SET Nombre=?,Direccion=? WHERE Nombre=?";
        public static final String ACTUALIZAR_MENU="UPDATE MENU SET ID=?,Tipo=?,Nombre=?,Descripcion=?,Precio=?,Costo_Fabricacion=? WHERE ID=? AND ID_Restaurante=?";
        public static final String ACTUALIZAR_RESERVACION="UPDATE RESERVACION SET Nombre_Huesped=?,Precio_Habitacion=?,"
                + "                                         Fecha_Ingreso=?,Fecha_Retiro=?,Estado=?,NIT_Cliente=?,Numero_Habitacion=?, ID_Hotel_Habitacion=? WHERE ID=?"; 
        public static final String ACTUALIZAR_FECHAS_RESERVACION="UPDATE RESERVACION SET Fecha_Ingreso=?,Fecha_Retiro=? WHERE ID=?";
        public static final String ACTUALIZAR_ESTADO_RESERVACION="UPDATE RESERVACION SET Estado=? WHERE ID=?";
        public static final String ACTUALIZAR_DIAS_RESERVACION="UPDATE RESERVACION SET Cantidad_Dias=? WHERE ID=?"; 
        public static final String ACTUALIZAR_ESTADO_HABITACION="UPDATE HABITACION SET Estado=? WHERE Numero=? AND ID_Hotel=?"; 
        public static final String ACTUALIZAR_HABITACION="UPDATE HABITACION SET Numero=?,Tipo=?,Nivel=?,Precio=?, Estado=?,Costo_Mantenimiento=? WHERE Numero=? AND ID_Hotel=?";
        
        //QUERYS PARA OTRAS CONSULTAS Y RECUPERACION DE DATOS
        public static final String CONSULTAR_EMPLEADOS_ADMIN_PROYECTO="SELECT*FROM EMPLEADO WHERE Estado=? AND Tipo=?"; 
        public static final String CONSULTAR_USUARIOS="SELECT*FROM USUARIO"; 
        public static final String CONSULTAR_MENUS="SELECT*FROM MENU";
        //public static final String CONSULTAR_CLIENTES="SELECT Nit FROM CLIENTE";
        public static final String CONSULTAR_NOMBRES_RESTAURANTES="SELECT*FROM RESTAURANTE";
        public static final String CONSULTAR_NUMERO_HABITACIONES="SELECT COUNT(*)FROM HABITACION WHERE ID_Hotel=?";
        public static final String CONSULTAR_NUMERO_MENUS="SELECT COUNT(*)FROM MENU WHERE ID_Restaurante=?";
        public static final String CONSULTAR_NOMBRES_HOTELES="SELECT*FROM HOTEL";
        public static final String CONSULTAR_RESERVACIONES="SELECT*FROM RESERVACION"; 
        public static final String CONSULTAR_RESERVACIONES_HOTEL="SELECT*FROM RESERVACION WHERE ID_Hotel_Habitacion=?"; 
        public static final String CONSULTAR_RESERVACIONES_HABITACIONES_HOTEL="SELECT HABITACION.Numero,HABITACION.Tipo,RESERVACION.Fecha_Ingreso,RESERVACION.Fecha_Retiro FROM HABITACION INNER JOIN RESERVACION "
                + "                                                         ON HABITACION.Numero=RESERVACION.Numero_Habitacion AND HABITACION.ID_Hotel=RESERVACION.ID_Hotel_Habitacion WHERE RESERVACION.ID_Hotel_Habitacion=? AND RESERVACION.Fecha_Retiro>?";
        public static final String CONSULTAR_RESERVACIONES_CLIENTE="SELECT*FROM RESERVACION WHERE ID_Hotel_Habitacion=? AND NIT_Cliente=? AND Fecha_Ingreso=? AND Estado=?";
        public static final String CONSULTAR_RESERVACIONES_CLIENTE_PARA_EXTENSION="SELECT*FROM RESERVACION WHERE ID_Hotel_Habitacion=? AND NIT_Cliente=? AND Estado=?";
        public static final String CONSULTAR_RESERVACIONES_CLIENTE_RETIRO="SELECT*FROM RESERVACION WHERE ID_Hotel_Habitacion=? AND NIT_Cliente=? AND Fecha_Retiro=? AND Estado=?";
        public static final String CONSULTAR_RESERVACIONES_ENTRE_FECHAS="SELECT *FROM RESERVACION WHERE (Fecha_Ingreso BETWEEN ? AND ? OR Fecha_Retiro BETWEEN ? AND ?) AND Numero_Habitacion=? AND ID_Hotel_Habitacion=?";
        public static final String CONSULTAR_RESERVACIONES_ENTRE_FECHAS_EXCLUYENDO="SELECT *FROM RESERVACION WHERE (Fecha_Ingreso BETWEEN ? AND ? OR Fecha_Retiro BETWEEN ? AND ?) AND Numero_Habitacion=? AND ID_Hotel_Habitacion=? AND ID NOT IN (?)"; 
        public static final String CONSULTAR_HABITACIONES="SELECT*FROM HABITACION"; 
        public static final String CONSULTAR_HABITACIONES_HOTEL_ESPECIFICO="SELECT HABITACION.Numero,HABITACION.Tipo,HABITACION.Nivel,HABITACION.Precio,HABITACION.Estado,HABITACION.Costo_Mantenimiento,HOTEL.Nombre "
                + "                                                         FROM HOTEL INNER JOIN HABITACION ON HABITACION.ID_Hotel=HOTEL.ID WHERE HOTEL.ID=?"; 
        public static final String CONSULTAR_MENUS_RESTAURANTE_ESPECIFICO="SELECT MENU.ID,MENU.Tipo,MENU.Nombre,MENU.Descripcion,MENU.Precio,MENU.Costo_Fabricacion,MENU.ID_Restaurante,MENU.Promo,RESTAURANTE.Nombre "
                + "                                                         FROM RESTAURANTE INNER JOIN MENU ON MENU.ID_Restaurante=RESTAURANTE.ID WHERE RESTAURANTE.ID=?"; 
        public static final String CONSULTAR_HABITACIONES_ESTADO="SELECT*FROM HABITACION WHERE ID_Hotel=? AND Estado=?";
        public static final String CONSULTAR_DATEDIFF="SELECT DATEDIFF(?,?)";
        
        public static final String CONSULTAR_REGISTRO_CASOS_USER="SELECT R.Nombre,ID_Proyecto,Tipo_Caso,R.Estado,Porcentaje,Fecha_Registro,Fecha_Limite "
                                    + "FROM REGISTRO_CASO R JOIN PROYECTO P ON R.ID_Proyecto = P.ID WHERE P.User_Admin_Proyecto=?";
        
        public static final String CONSULTAR_EMPLEADOS_RESTAURANTE="SELECT USUARIO.Nombre,USUARIO.CUI,USUARIO.User,USUARIO.Tipo,USUARIO.Salario FROM USUARIO INNER JOIN REG_EMPLEADO_REST ON USUARIO.User=REG_EMPLEADO_REST.User_Empleado_Rest WHERE REG_EMPLEADO_REST.Id_Restaurante=?";
        public static final String CONSULTAR_EMPLEADOS_HOTEL="SELECT USUARIO.Nombre,USUARIO.CUI,USUARIO.User,USUARIO.Tipo,USUARIO.Salario FROM USUARIO INNER JOIN REG_EMPLEADO_HOTEL ON USUARIO.User=REG_EMPLEADO_HOTEL.User_Empleado_Hotel WHERE REG_EMPLEADO_HOTEL.ID_Hotel=?";
        //Constantes de mensajes de Error y Modificacion 
        public static final String ERROR_RECUP ="Error de Recuperacion";
        public static final String ERROR_CREACION ="Error de Creacion";
        public static final String ERROR_ACTUALIZACION ="Error de Actualizacion";
        public static final String ERROR_ELIMINACION ="Error de Eliminacion";
        public static final String CAMBIAR_DATOS ="Esta seguro de Modificar estos datos?";
        public static final String GUARDAR_DATOS ="Esta seguro de guardar estos datos?";
        public static final String CAMPOS_OBLIGATORIOS ="Todos los campos Marcados con '*'\n son Obligatorios";
        public static final String ERR_CONSULTA="ERROR EN CONSULTA"; 
        public static final String ERR_INSERCION="ERROR EN INSERCION DE DATOS\n Es Posible que el registro ya exista";
        
        //Constantes de Operaciones en ejecucion
        public static final String REGISTRO_GUARDADO ="Registro Guardado con Exito";
        public static final String REGISTRO ="Registro";
        public static final String REGISTRO_MODIFICADO ="Registro Modificado con Exito";
        public static final String MODIFICACION ="Modificacion";
        public static final String REGISTRO_ELIMINADO ="Registro Eliminado con Exito";
        public static final String ELIMINACION ="Eliminacion";
        public static final String REGISTRO_RECUPERADO ="Registro Recuperado con Exito";
        public static final String RECUPERACION ="Recuperacion";
        
        private Conexion conexion= new Conexion();
        private PreparedStatement prepStatement;
        private ResultSet result;
        private List listaRecuperacion = new ArrayList<>();
        
        public OperadorEsquema(){
            
        }   
        
        public List<Usuario> recuperarListaEmpleadosRestaurante(int idRest) {
                try {   //se realiza la consulta
                        prepStatement = conexion.getConnection().prepareStatement(CONSULTAR_EMPLEADOS_RESTAURANTE);
                        prepStatement.setInt(1, idRest);
                        result = prepStatement.executeQuery();
                        //se extraen los resultados y se insertan en la lista
                        while (result.next()) {
                                listaRecuperacion.add(new Usuario(result.getString(3),result.getString(1),result.getString(2),
                                        result.getString(4), result.getDouble(5)));
                        
                        }
                        result.close(); // Cerrar ResultSet
                        prepStatement.close();  //Cerrar PreparedStatement
                } catch (SQLException ex) {
                        System.out.println(ERR_CONSULTA);
                        
                }
                return listaRecuperacion;
        }
        
        public List<Usuario> recuperarListaEmpleadosHotel(int idHotel) {
                try {   //se realiza la consulta
                        prepStatement = conexion.getConnection().prepareStatement(CONSULTAR_EMPLEADOS_HOTEL);
                        prepStatement.setInt(1, idHotel);
                        result = prepStatement.executeQuery();
                        //se extraen los resultados y se insertan en la lista
                        while (result.next()) {
                                listaRecuperacion.add(new Usuario(result.getString(3),result.getString(1),result.getString(2),
                                        result.getString(4), result.getDouble(5)));
                        
                        }
                        result.close(); // Cerrar ResultSet
                        prepStatement.close();  //Cerrar PreparedStatement
                } catch (SQLException ex) {
                        System.out.println(ERR_CONSULTA);
                        
                }
                return listaRecuperacion;
        }
        
}
