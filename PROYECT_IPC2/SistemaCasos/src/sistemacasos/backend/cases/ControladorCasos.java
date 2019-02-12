/*
 * Maneja Operaciones con casos
 */
package sistemacasos.backend.cases;

import java.util.List;
import sistemacasos.database.OperadorEsquema;

/**
 *
 * @author bryan
 */
public class ControladorCasos {
        public ControladorCasos(){
        
        }
        
        public void registrarCaso(Caso caso){
                //se envia a la bd
                OperadorEsquema operador= new OperadorEsquema();
                operador.insertarCaso(caso);
        }
        public void registrarAsignacionCaso(RegistroCaso caso){
                //se envia a la bd
                OperadorEsquema operador= new OperadorEsquema();
                operador.insertarRegistroCaso(caso);
        }
        public List<RegistroCaso> consultarCasos(String user){
                OperadorEsquema operador= new OperadorEsquema();
                return operador.recuperarCasos(user);
        }
        public List<Caso> consultarTiposCaso(){
                OperadorEsquema operador= new OperadorEsquema();
                return operador.recuperarTipoCasos();
        }
        public void registrarAsignacionEtapa(RegistroEtapa etapa){
                //se envia a la bd
                OperadorEsquema operador= new OperadorEsquema();
                operador.insertarRegistroEtapa(etapa);
        }
        
        
        
}
