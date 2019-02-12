/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2ipc2.backend.Restaurante;

import java.util.List;
import javax.swing.JOptionPane;
import proyecto2ipc2.backend.DAO.Implementaciones.ConsumoDAOImp;
import proyecto2ipc2.backend.DAO.Implementaciones.MenuDAOImp;
import proyecto2ipc2.backend.DAO.Interfaces.ConsumoDAO;
import proyecto2ipc2.backend.DAO.Interfaces.MenuDAO;
import static proyecto2ipc2.database.OperadorEsquema.ERROR_CREACION;
import proyecto2ipc2.frontend.Forms.FormCRUDPedidos;

/**
 *
 * @author bryan
 */
public class ControladorConsumos {
        public static final String REGISTRAR_PEDIDO ="No se pudo registrar el pedido";
        private Consumo consumo;
        private FormCRUDPedidos formPedidos;
        
        private ConsumoDAO consumoDao;
        private MenuDAO menuDao;

        public ControladorConsumos(Consumo consumo, FormCRUDPedidos formPedidos) {
                this.consumo = consumo;
                this.formPedidos = formPedidos;
                this.consumoDao= new ConsumoDAOImp();
                this.menuDao= new MenuDAOImp();
        }

        public ControladorConsumos() {
                this.consumoDao= new ConsumoDAOImp();
                this.menuDao= new MenuDAOImp(); 
        }
        
        
        public Double calcularTotalConsumos(List<Consumo> lista){
                double total = 0;
                
                for(Consumo cons: lista){
                        total+= cons.getNumeroPorciones()*cons.getMenu().getPrecio();
                }
                return total;
        }
        
        public void registrarPedidos(List<Consumo> lista){
                for(Consumo cons: lista){
                        if (!consumoDao.registrar(cons)) {
                            JOptionPane.showMessageDialog(null, REGISTRAR_PEDIDO, ERROR_CREACION, JOptionPane.ERROR_MESSAGE);
                        }
                }
        }
        
    
}
