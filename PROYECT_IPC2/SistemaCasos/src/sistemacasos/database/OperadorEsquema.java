/*
 * Clase Operador Esquema, para realizar DDL y DML
 */
package sistemacasos.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import sistemacasos.backend.cases.Caso;
import sistemacasos.backend.cases.RegistroCaso;
import sistemacasos.backend.cases.RegistroEtapa;
import sistemacasos.backend.proyects.Proyecto;
import sistemacasos.backend.user.Empleado;
import static sistemacasos.backend.user.Empleado.ESTADO_ASIGNADO;
import sistemacasos.backend.user.Usuario;
import static sistemacasos.ui.FormNuevoEmpleado.REGISTRO;
import static sistemacasos.ui.FormNuevoEmpleado.REGISTRO_GUARDADO;
import sistemacasos.ui.JFramePrincipal;
/**
 *
 * @author bryan
 */
public class OperadorEsquema {
        private List listaRecuperacion = new ArrayList<>();
        //Connection a BD, prepared statement y resultset
        private Connection connection=new Conexion().establecerConexion(); //una unica conexion
        private PreparedStatement prepStatement;
        private ResultSet result;
        
        public static final int COLUMNA_1 = 1;
        public static final int COLUMNA_2 = 2;
        public static final int COLUMNA_3 = 3;
        public static final int COLUMNA_4 = 4;
        public static final int COLUMNA_5 = 5;
        public static final int COLUMNA_6 = 6;
        public static final int COLUMNA_7 = 7;
        public static final int COLUMNA_8 = 8;
        public static final int COLUMNA_9 = 9;
        public static final String ERR_CONSULTA="ERROR EN CONSULTA"; 
        public static final String ERR_INSERCION="ERROR EN INSERCION DE DATOS\n Es Posible que el registro ya exista"; 
        public static final String CONSULTA_USER_PASS="SELECT User,Pass,Tipo FROM USUARIO WHERE User=?"; 
        public static final String CONSULTAR_USER="SELECT*FROM USUARIO WHERE CUI_Empleado=?";
        public static final String INSERTAR_EMPLEADO="INSERT INTO EMPLEADO VALUES(?,?,?,?,?,?)";
        public static final String INSERTAR_REGISTRO_CASO="INSERT INTO REGISTRO_CASO VALUES(?,?,?,?,?,?,?)";
        public static final String INSERTAR_REGISTRO_ETAPA="INSERT INTO REGISTRO_ETAPA VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        public static final String ACTUALIZAR_ESTADO_EMPLEADO="UPDATE EMPLEADO SET Estado=? WHERE CUI=?";
        public static final String ACTUALIZAR_ESTADO_PROYECTO="UPDATE PROYECTO SET User_Admin_Proyecto=?,Estado=? WHERE ID=?";
        public static final String INSERTAR_USUARIO="INSERT INTO USUARIO VALUES(?,?,?,?)";
        public static final String INSERTAR_PROYECTO="INSERT INTO PROYECTO VALUES(null,?,?,?,?,?)";
        public static final String INSERTAR_CASO="INSERT INTO CASO VALUES(?,?,?)";
        public static final String CONSULTAR_EMPLEADOS="SELECT*FROM EMPLEADO WHERE Estado=?"; 
        public static final String CONSULTAR_CASOS="SELECT*FROM REGISTRO_CASO"; 
        public static final String CONSULTAR_TIPOS_CASO="SELECT*FROM CASO"; 
        public static final String CONSULTAR_EMPLEADOS_ADMIN_PROYECTO="SELECT*FROM EMPLEADO WHERE Estado=? AND Tipo=?"; 
        public static final String CONSULTAR_PROYECTOS="SELECT*FROM PROYECTO WHERE User_Admin_Proyecto=?"; 
        public static final String CONSULTAR_REGISTRO_CASOS_USER="SELECT R.Nombre,ID_Proyecto,Tipo_Caso,R.Estado,Porcentaje,Fecha_Registro,Fecha_Limite "
                                    + "FROM REGISTRO_CASO R JOIN PROYECTO P ON R.ID_Proyecto = P.ID WHERE P.User_Admin_Proyecto=?";
        
        public OperadorEsquema(){
 
        }
        //metodo boolean para la validacion de usuarios
        public String ValidarUsuario(String user, String pass){
                String tipoUser=null;
                try {   //se realiza la validacion de usuario
                        prepStatement = connection.prepareStatement(CONSULTA_USER_PASS);
                        prepStatement.setString(1, user);//parametro de entrada 1 user
                        result = prepStatement.executeQuery();
                        result.next();
                        if (result.getString(COLUMNA_2).equals(pass)) {
                                tipoUser= result.getString(COLUMNA_3);
                        }      
                        result.close(); // Cerrar ResultSet
                        prepStatement.close();  //Cerrar PreparedStatement
                } catch (SQLException ex) {
                        System.out.println(ERR_CONSULTA);
                        //JOptionPane.showMessageDialog(null, ERR_CONSULTA, "Error", JOptionPane.ERROR_MESSAGE);
                }
                //se retorna el Tipo de usuario para darle acceso al sistema
                return tipoUser;
        }
        //metodo para recibir un objeto empleado y ralizar la insercion de los campos
        public void insertarEmpleado(Empleado empleado){
                try {
                        prepStatement = connection.prepareStatement(INSERTAR_EMPLEADO);
                        prepStatement.setString(COLUMNA_1, empleado.getCUI());
                        prepStatement.setString(COLUMNA_2, empleado.getNombre());
                        prepStatement.setString(COLUMNA_3, empleado.getTipo());
                        prepStatement.setInt(COLUMNA_4, empleado.getEdad());
                        prepStatement.setString(COLUMNA_5, empleado.getEspecialidad());
                        prepStatement.setString(COLUMNA_6, empleado.getEstado());
                        prepStatement.executeUpdate();
                        prepStatement.close();  //Cerrar PreparedStatement
                        JOptionPane.showMessageDialog(null, REGISTRO_GUARDADO, REGISTRO, 1);
                
                } catch (SQLException ex) {
                        System.out.println(ERR_INSERCION);
                        JOptionPane.showMessageDialog(null, ERR_INSERCION, "Error", JOptionPane.ERROR_MESSAGE);
                        
                }
        }
        public void insertarProyecto(Proyecto proyecto){
                try {   
                        //conversion de fecha 
                        String fecha = proyecto.getFechaCreacion().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
                        prepStatement = connection.prepareStatement(INSERTAR_PROYECTO);
                        prepStatement.setString(COLUMNA_1, null);
                        prepStatement.setString(COLUMNA_2, proyecto.getNombre());
                        prepStatement.setString(COLUMNA_3, proyecto.getTipo());
                        prepStatement.setString(COLUMNA_4, fecha);
                        prepStatement.setString(COLUMNA_5, proyecto.getEstado());
                        prepStatement.executeUpdate();
                        prepStatement.close();  //Cerrar PreparedStatement
                        JOptionPane.showMessageDialog(null, REGISTRO_GUARDADO, REGISTRO, 1);
                
                } catch (SQLException ex) {
                        System.out.println(ERR_INSERCION);
                        JOptionPane.showMessageDialog(null, ERR_INSERCION, "Error", JOptionPane.ERROR_MESSAGE);
                        
                }
        }
        public void insertarRegistroCaso(RegistroCaso caso){
                try {   
                        //conversion de fecha 
                        String fechaRegistro = caso.getFechaCreacion().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
                        String fechaLimite = caso.getFechaLimite().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
                        prepStatement = connection.prepareStatement(INSERTAR_REGISTRO_CASO);
                        prepStatement.setString(COLUMNA_1, caso.getNombre());
                        prepStatement.setInt(COLUMNA_2, caso.getIdProyecto());
                        prepStatement.setString(COLUMNA_3, caso.getTipoCaso());
                        prepStatement.setString(COLUMNA_4, caso.getEstado());
                        prepStatement.setInt(COLUMNA_5, caso.getPorcentaje());
                        prepStatement.setString(COLUMNA_6, fechaRegistro);
                        prepStatement.setString(COLUMNA_7, fechaLimite);
                        
                        prepStatement.executeUpdate();
                        prepStatement.close();  //Cerrar PreparedStatement
                        JOptionPane.showMessageDialog(null, REGISTRO_GUARDADO, REGISTRO, 1);
                
                } catch (SQLException ex) {
                        System.out.println(ERR_INSERCION);
                        JOptionPane.showMessageDialog(null, ERR_INSERCION, "Error", JOptionPane.ERROR_MESSAGE);
                        
                }
        }
        public void insertarRegistroEtapa(RegistroEtapa etapa){
                try {   
                        //conversion de fecha 
                        String fechaRegistro = etapa.getFechaRegistro().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
                        prepStatement = connection.prepareStatement(INSERTAR_REGISTRO_ETAPA);
                        prepStatement.setInt(COLUMNA_1, etapa.getIdProyecto());
                        prepStatement.setString(COLUMNA_2, etapa.getTipoCaso());
                        prepStatement.setString(COLUMNA_3, etapa.getNombreCaso());
                        prepStatement.setString(COLUMNA_4, etapa.getUserDesarrollador());
                        prepStatement.setInt(COLUMNA_5, etapa.getNumeroEtapa());
                        prepStatement.setString(COLUMNA_6, etapa.getNombreEtapa());
                        prepStatement.setString(COLUMNA_7, fechaRegistro);
                        prepStatement.setInt(COLUMNA_8, etapa.getHorasInvertidas());
                        prepStatement.setInt(COLUMNA_9, etapa.getCostoHora());
                        prepStatement.setInt(10, etapa.getDineroInvertido());
                        prepStatement.setString(11, etapa.getEstado());
                        prepStatement.setString(12, etapa.getAprobacion());
                        prepStatement.setString(13, etapa.getComentario());
                        
                        prepStatement.executeUpdate();
                        prepStatement.close();  //Cerrar PreparedStatement
                        JOptionPane.showMessageDialog(null, REGISTRO_GUARDADO, REGISTRO, 1);
                
                } catch (SQLException ex) {
                        System.out.println(ERR_INSERCION);
                        JOptionPane.showMessageDialog(null, ERR_INSERCION, "Error", JOptionPane.ERROR_MESSAGE);
                        
                }
        }
        public void insertarCaso(Caso caso){
                try {   
                        //conversion de fecha 
                        String fecha = caso.getFechaCreacion().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
                        prepStatement = connection.prepareStatement(INSERTAR_CASO);
                        prepStatement.setString(COLUMNA_1, caso.getTipo());
                        prepStatement.setInt(COLUMNA_2, caso.getNumeroEtapas());
                        prepStatement.setString(COLUMNA_3, fecha);
                        prepStatement.executeUpdate();
                        prepStatement.close();  //Cerrar PreparedStatement
                        JOptionPane.showMessageDialog(null, REGISTRO_GUARDADO, REGISTRO, 1);
                
                } catch (SQLException ex) {
                        System.out.println(ERR_INSERCION);
                        JOptionPane.showMessageDialog(null, ERR_INSERCION, "Error", JOptionPane.ERROR_MESSAGE);
                        
                }
        }
        public void actualizarEstadoEmpleado(String cui,String estado){
                try {
                        prepStatement = connection.prepareStatement(ACTUALIZAR_ESTADO_EMPLEADO);
                        prepStatement.setString(1, estado);
                        prepStatement.setString(2, cui);
                        prepStatement.executeUpdate();
                        prepStatement.close();  //Cerrar PreparedStatement
                
                } catch (SQLException ex) {
                        System.out.println(ERR_INSERCION);
                        JOptionPane.showMessageDialog(null, ERR_INSERCION, "Error", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                }
        
        }
        public void actualizarEstadoProyecto(int id,String estado,String userAdmin){
                try {
                        prepStatement = connection.prepareStatement(ACTUALIZAR_ESTADO_PROYECTO);
                        prepStatement.setString(1, userAdmin);
                        prepStatement.setString(2, estado);
                        prepStatement.setInt(3, id);
                        prepStatement.executeUpdate();
                        prepStatement.close();  //Cerrar PreparedStatement
                        JOptionPane.showMessageDialog(null, REGISTRO_GUARDADO, REGISTRO, 1);
                
                } catch (SQLException ex) {
                        System.out.println(ERR_INSERCION);
                        JOptionPane.showMessageDialog(null, ERR_INSERCION, "Error", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                }
        
        }
         public void insertarUsuario(Usuario user){
                try {
                        prepStatement = connection.prepareStatement(INSERTAR_USUARIO);
                        prepStatement.setString(COLUMNA_1, user.getUser());
                        prepStatement.setString(COLUMNA_2, user.getPass());
                        prepStatement.setString(COLUMNA_3, user.getCui());
                        prepStatement.setString(COLUMNA_4, user.getTipo());
                        prepStatement.executeUpdate();
                        prepStatement.close();  //Cerrar PreparedStatement
                        actualizarEstadoEmpleado(user.getCui(), ESTADO_ASIGNADO);
                        JOptionPane.showMessageDialog(null, REGISTRO_GUARDADO, REGISTRO, 1);
                
                } catch (SQLException ex) {
                        System.out.println(ERR_INSERCION);
                        JOptionPane.showMessageDialog(null, ERR_INSERCION, "Error", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                }
        }
        //metodo para realizar consultas simples de una tabla completa
        public List<Empleado> recuperarEmpleados(String estado){
                try {   //se realiza la consulta
                        prepStatement = connection.prepareStatement(CONSULTAR_EMPLEADOS);
                        prepStatement.setString(1,estado);//parametro 1 estado
                        result = prepStatement.executeQuery();
                        //se extraen los resultados y se insertan en la lista
                        while (result.next()) {
                                listaRecuperacion.add(new Empleado(result.getString(COLUMNA_1),result.getString(COLUMNA_2),result.getString(COLUMNA_3),
                                        result.getInt(COLUMNA_4),result.getString(COLUMNA_5),result.getString(COLUMNA_6)));
                        
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
        //metodo para realizar consultas simples de una tabla completa
        public List<Empleado> recuperarEmpleadosAdminiProyectos(String estado,String tipo){
                try {   //se realiza la consulta
                        prepStatement = connection.prepareStatement(CONSULTAR_EMPLEADOS_ADMIN_PROYECTO);
                        prepStatement.setString(1,estado);//parametro 1 estado
                        prepStatement.setString(2,tipo);//parametro 1 estado
                        result = prepStatement.executeQuery();
                        //se extraen los resultados y se insertan en la lista
                        while (result.next()) {
                                listaRecuperacion.add(new Empleado(result.getString(COLUMNA_1),result.getString(COLUMNA_2),result.getString(COLUMNA_3),
                                        result.getInt(COLUMNA_4),result.getString(COLUMNA_5),result.getString(COLUMNA_6)));
                        
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
        public List<Proyecto> recuperarProyectos(String user){
                try {   //se realiza la consulta
                        prepStatement = connection.prepareStatement(CONSULTAR_PROYECTOS);
                        prepStatement.setString(1,user);//parametro 1 estado
                        result = prepStatement.executeQuery();
                        //se extraen los resultados y se insertan en la lista
                        while (result.next()) {
                                listaRecuperacion.add(new Proyecto(result.getInt(COLUMNA_1),result.getString(COLUMNA_2),result.getString(COLUMNA_3),
                                        result.getString(COLUMNA_4),result.getDate(COLUMNA_5).toLocalDate(),result.getString(COLUMNA_6)));
                        
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
        public List<RegistroCaso> recuperarCasos(String user){
                try {   //se realiza la consulta
                        prepStatement = connection.prepareStatement(CONSULTAR_REGISTRO_CASOS_USER);
                        prepStatement.setString(1,user);//parametro 1 estado
                        result = prepStatement.executeQuery();
                        //se extraen los resultados y se insertan en la lista
                        while (result.next()) {
                                listaRecuperacion.add(new RegistroCaso(result.getString(COLUMNA_1),result.getInt(COLUMNA_2),result.getString(COLUMNA_3),
                                        result.getString(COLUMNA_4),result.getInt(COLUMNA_5),result.getDate(COLUMNA_6).toLocalDate(),result.getDate(COLUMNA_7).toLocalDate()));
                        
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
        public List<Caso> recuperarTipoCasos(){
                try {   //se realiza la consulta
                        prepStatement = connection.prepareStatement(CONSULTAR_TIPOS_CASO);
                        result = prepStatement.executeQuery();
                        //se extraen los resultados y se insertan en la lista
                        while (result.next()) {
                                listaRecuperacion.add(new Caso(result.getString(COLUMNA_1),result.getInt(COLUMNA_2),
                                        result.getDate(COLUMNA_3).toLocalDate()));
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
        public String recuperarUsuario(String cuiEmpleado){
            String userDevol= null;
                try {   //se realiza la consulta
                        
                        prepStatement = connection.prepareStatement(CONSULTAR_USER);
                        prepStatement.setString(1,cuiEmpleado);//parametro 1 estado
                        result = prepStatement.executeQuery();
                        result.next();
                        userDevol= result.getString(COLUMNA_1);
                        result.close(); // Cerrar ResultSet
                        prepStatement.close();  //Cerrar PreparedStatement
                } catch (SQLException ex) {
                        System.out.println(ERR_CONSULTA);
                        JOptionPane.showMessageDialog(null, ERR_CONSULTA, "Error", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                }
                return userDevol;
        }
        
        
}
