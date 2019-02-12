/*
 * Clase para llevar el control de los Proyectos
 */
package sistemacasos.backend.proyects;

import java.util.List;
import sistemacasos.backend.user.ControladorUsuarios;
import sistemacasos.database.OperadorEsquema;

/**
 *
 * @author bryan
 */
public class ControladorProyectos {
    
        public ControladorProyectos(){
        
        }
        public void registrarProyecto(Proyecto proyecto){
                OperadorEsquema operador = new OperadorEsquema();
                operador.insertarProyecto(proyecto);
        }
        public List<Proyecto> consultarProyectos(String user){
                OperadorEsquema operador= new OperadorEsquema();
                return operador.recuperarProyectos(user);
        }
        public void actualizarEstadoProyecto(String cuiAdmin,String estado,int id){
                String userAdmin;
                ControladorUsuarios usuarios= new ControladorUsuarios();
                //se consulta el usuario con cui de administrador
                userAdmin= usuarios.consultarUsuario(cuiAdmin);
                OperadorEsquema operador = new OperadorEsquema();
                //se actualiza el proyecto
                operador.actualizarEstadoProyecto(id, estado,userAdmin);
                
        }
    
}
