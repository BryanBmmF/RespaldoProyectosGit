/*
 * Clase Conexion, para establecer una conexion con la BD 
 */
package sistemacasos.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bryan
 */
public class Conexion {
        private static final String URL_BASICA = "jdbc:mysql://localhost/CONTROL_CASOS2";
        private static final String CONEXION_ESTABLECIDA = "Conexion Establecida";
        private static final String CONEXION_FALLIDA = "Conexion Fallida";
        private static final String CONEXION_DRIVER = "com.mysql.jdbc.Driver";
        private Connection connection = null; //una unica conexion
        public Conexion(){
         
        }
        //metodo que devuelve una conexion establecida con la bd
        public Connection establecerConexion(){
                try {
                        //Indicamos cual driver usar
                        Class.forName(CONEXION_DRIVER).newInstance();

                        //USAMOS PROPERTIES PARA SER MAS CONFIGURABLE LA CONECCION Y MAS LEIBLE
                        String usuario = "root";
                        String password = "admin";
                        Properties propiedades = new Properties();
                        propiedades.setProperty("user", usuario);
                        propiedades.setProperty("password", password);
			
                        connection = DriverManager.getConnection(URL_BASICA, propiedades);     
                    
                } catch (Exception e) {
                        System.out.println(CONEXION_FALLIDA);
                        e.printStackTrace(System.out);
                } finally {
                        if (connection != null) {
                                try {
                                        System.out.println(CONEXION_ESTABLECIDA);
                                        connection.clearWarnings();
                                } catch (SQLException ex) {
                                        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                                }
                        }else{
                            System.out.println(CONEXION_FALLIDA);
                        }
                } 
                return connection;
        }
    
}
