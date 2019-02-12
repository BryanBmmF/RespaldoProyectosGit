/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2ipc2.backend.DAO.Interfaces;
import proyecto2ipc2.backend.Hotel.Hotel;
import proyecto2ipc2.backend.Restaurante.Restaurante;
import proyecto2ipc2.backend.User.Usuario;

/**
 *
 * @author bryan
 */
public interface UsuarioDAO extends CRUD<Usuario>{
        public Usuario recuperarUsuario(String user);
        public String validarUsuario(String user, String pass);
        public Hotel recuperarHotel(String user);
        public Restaurante recuperarUsuarioRestaurante(String user);
        public boolean asignarHotel(String user,int idHotel);
        public boolean asignarRestaurante(String user,int idRestaurante);
        public boolean desasignarHotel(String user);
        public boolean desasignarRestaurante(String user);
        
}
