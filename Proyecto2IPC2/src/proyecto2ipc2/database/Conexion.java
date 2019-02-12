/*
 * Clase Conexion, para establecer una conexion con la BD 
 */
package proyecto2ipc2.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author bryan
 */
public class Conexion {
        private static final String URL_BASICA = "jdbc:mysql://localhost:3306/EMPRESA_CD";
        private static final String CONEXION_ESTABLECIDA = "Conexion Establecida";
        private static final String CONEXION_FALLIDA = "Conexion Fallida";
        private static final String CONEXION_DRIVER = "com.mysql.jdbc.Driver";
        private static final String USER = "root";
        private static final String PASS = "admin";
        //variable Connection tipo Estatica
        public static Connection conection;
        //metodo para obtencion de conexionn a la BD utilizando patron Singleton
        public static Connection getConnection(){
                try{
                        //se verifica si la conexion no se realizado con anterioridad
                        if (conection == null) {
                                //por cierre de programa
                                Runtime.getRuntime().addShutdownHook(new getClose());
                                
                                Class.forName(CONEXION_DRIVER);
                                //obtenemos la conexion una sola vez
                                conection = DriverManager.getConnection(URL_BASICA, USER,PASS); 
                        }
                        return conection;
                }catch(ClassNotFoundException | SQLException e){
                        throw new RuntimeException(CONEXION_FALLIDA,e);// se lanza la posible ecepcion
                
                }
        
        }
        // clase estatica para cerrar conexion por cierre de programa ya sea forzado o no
        static class getClose extends Thread{
                @Override
                public void run(){
                    try {
                            Connection con= Conexion.getConnection();
                            con.close();
                    } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                    }
                
                }
        }
            
        
    
}
