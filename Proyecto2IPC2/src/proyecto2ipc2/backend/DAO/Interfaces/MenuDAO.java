/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2ipc2.backend.DAO.Interfaces;
import java.util.List;
import proyecto2ipc2.backend.Restaurante.Menu;

/**
 *
 * @author bryan
 */
public interface MenuDAO extends CRUD<Menu>{
        public Menu recuperarMenu(int numero, int restaurante);
        public List<Menu> recuperarMenusRestauranteEspecificco(int idRestaurante);
}
