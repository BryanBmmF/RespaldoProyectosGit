/*
 * Clase controladora del Servidor
 */
package proyecto1compi1.backend.app;

import java.util.List;
import proyecto1compi1.backend.acciones.Accion;
import proyecto1compi1.frontend.FrameServidor;
import proyecto1compi1.parserCreador;

/**
 *
 * @author bryan
 */
public class ControladorServidor {
        public static final int PUERTO=5000;
        private parserCreador parser;
        private FrameServidor frame;
        private Cliente cliente;
        private Thread hilo;

        public ControladorServidor(parserCreador parser, FrameServidor frame) {
            this.parser = parser;
            this.frame = frame;
        }
        
        public void implementarAcciones(){
            /*EVALUAR POSIBLES INCONCISTENCIAS ANTES DE REALIZAR LAS ACCIONES*/
            if (parser.devolverErrores().isEmpty()) {
                    //se devuelven las acciones creadas
                    List<Accion> lista = this.parser.devolverAcciones();
                    for(Accion ac: lista){
                            ac.ejecutarAciion();//ejecutando accion
                    }
                    notificarCliente("Mensaje del Servidor: Se procedera a ejecutar lo enviado.....");
            } else {//existen errores en los parametros etc
                    for(String er: parser.devolverErrores()){
                            frame.agregarAviso(er);
                            notificarCliente("Error desde del  Servidor:\n "+er);
                    }
                    
            }
        }
        public void notificarCliente(String mensaje){
                cliente= new Cliente(PUERTO, mensaje);
                hilo = new Thread(cliente);
                hilo.start();
        }
        
    
}
