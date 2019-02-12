/*
 *Controlador de empleados
 */
package sistemacasos.backend.user;

import java.util.ArrayList;
import java.util.List;
import sistemacasos.database.OperadorEsquema;

/**
 *
 * @author bryan
 */
public class ControladorEmpleados {
        List<Empleado> empleados = new ArrayList<>();
        public ControladorEmpleados(){
                
        }
        public List<Empleado> consultarEmpleados(String estado){
                OperadorEsquema operador= new OperadorEsquema();
                return operador.recuperarEmpleados(estado);
        }
        public List<Empleado> consultarEmpleadosAdminProyectos(String estado,String tipo){
                OperadorEsquema operador= new OperadorEsquema();
                return operador.recuperarEmpleadosAdminiProyectos(estado, tipo);
        }
        public void registrarEmpleado(Empleado empleado){
                //se envia a la bd
                OperadorEsquema operador= new OperadorEsquema();
                operador.insertarEmpleado(empleado);
        }
        public void actualizarEstadoEmpleado(String cui,String estado){
                 //se envia a la bd
                OperadorEsquema operador= new OperadorEsquema();
                operador.actualizarEstadoEmpleado(cui, estado);
        }
    
}
