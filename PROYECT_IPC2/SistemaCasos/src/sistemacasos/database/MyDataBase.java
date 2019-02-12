/*
 * Clase Data Base para manejar procedimientos realizados a la bd
 */
package sistemacasos.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bryan
 */
public class MyDataBase {
    private static final String urlBasica = "jdbc:mysql://localhost/CONTROL_CASOS2";
    //miembro conexion
    private Connection conexion;
    
    //metodos accesores de conexion
    public Connection getConexion() {
            return conexion;
    }

    public void setConexion(Connection conexion) {
            this.conexion = conexion;
    }
    //Este método devuelve una instancia de la clase MyDataBase (es decir, la misma que lo contiene)
    public MyDataBase conectar() {
            try {
                    //Indicamos cual driver usar
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    //USAMOS PROPERTIES PARA SER MAS CONFIGURABLE LA CONECCION Y MAS LEIBLE
                    String usuario = "root";
                    String password = "admin";
                    Properties propiedades = new Properties();
                    propiedades.setProperty("user", usuario);
                    propiedades.setProperty("password", password);
                    //estableciendo conexion
                    setConexion(DriverManager.getConnection(urlBasica, propiedades));
                    
            //validar si la conexión se realizó correctamente verificando si la variable es nula:
            } catch (Exception e) {
                    System.out.println("error");
                    e.printStackTrace(System.out);
            } finally {
                    if (getConexion() != null) {
                            try {
                                    System.out.println("Conexion Exitosa!");
                                    getConexion().clearWarnings();
                            } catch (SQLException ex) {
                                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                            }
                    } else{
                            System.out.println("Conexion Fallida!");      
                    }
            } 
            return this; //retornando instancia de bd
    }
    //método a partir del cual ejecutaremos las sentencias más comunes que no nos devuelven resultados como INSERT, UPDATE, DELETE, etc.
    public boolean ejecutar(String sql) {
            try {
                    Statement sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
                    sentencia.executeUpdate(sql);
                    sentencia.close();

            } catch (SQLException e) {
                    e.printStackTrace();
                    return false;
            }
            return true;
    }
    //metodo para realizar consultas a la bd
    public ResultSet consultar(String sql) {
            ResultSet resultado;
            try {
                    Statement sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
                    resultado = sentencia.executeQuery(sql);

            } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
            }
            return resultado;
    }
}
