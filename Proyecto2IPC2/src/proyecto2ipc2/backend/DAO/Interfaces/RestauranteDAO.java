/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2ipc2.backend.DAO.Interfaces;

import proyecto2ipc2.backend.Restaurante.IngresosRestaurante;
import proyecto2ipc2.backend.Restaurante.Restaurante;

/**
 *
 * @author bryan
 */
public interface RestauranteDAO extends CRUD<Restaurante> {
        public Restaurante recuperarRestaurante(int id);
        public Restaurante recuperarIdRestaurante(String nombre);
        public int recuperarNumeroMenus(int idRestaurante);
        public boolean registrarIngresoRestaurante(IngresosRestaurante ingresoRestaurante);
    
}
