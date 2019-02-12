/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2ipc2.backend.DAO.Interfaces;
import java.util.List;

/**
 *
 * @author bryan
 */
public interface CRUD<T> {
        public boolean registrar(T t);
        public List<T> recuperarLista();
        public boolean actualizar(T t,String temp);
        public boolean eliminar(T t);
    
}
