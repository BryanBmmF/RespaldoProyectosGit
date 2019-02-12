/*
 * 
 */
package proyecto2ipc2.backend.Hotel;
import java.util.List;
import javax.swing.JOptionPane;
import proyecto2ipc2.backend.DAO.Implementaciones.HotelDAOImp;
import proyecto2ipc2.backend.DAO.Interfaces.HotelDAO;
import static proyecto2ipc2.database.OperadorEsquema.ELIMINACION;
import static proyecto2ipc2.database.OperadorEsquema.ERROR_ACTUALIZACION;
import static proyecto2ipc2.database.OperadorEsquema.ERROR_CREACION;
import static proyecto2ipc2.database.OperadorEsquema.ERROR_ELIMINACION;
import static proyecto2ipc2.database.OperadorEsquema.ERROR_RECUP;
import static proyecto2ipc2.database.OperadorEsquema.ERR_INSERCION;
import static proyecto2ipc2.database.OperadorEsquema.MODIFICACION;
import static proyecto2ipc2.database.OperadorEsquema.RECUPERACION;
import static proyecto2ipc2.database.OperadorEsquema.REGISTRO;
import static proyecto2ipc2.database.OperadorEsquema.REGISTRO_ELIMINADO;
import static proyecto2ipc2.database.OperadorEsquema.REGISTRO_GUARDADO;
import static proyecto2ipc2.database.OperadorEsquema.REGISTRO_MODIFICADO;
import static proyecto2ipc2.database.OperadorEsquema.REGISTRO_RECUPERADO;
import proyecto2ipc2.frontend.Forms.FormCRUDHotel;
import proyecto2ipc2.frontend.Forms.FormCRUDReservacion;
import proyecto2ipc2.frontend.Forms.FormCheckOut;

/**
 *
 * @author bryan
 */
public class ControladorHoteles {
        public static final String HOTEL_NO_EXISTENETE="Este Hotel no existe";
        private Hotel hotel;
        private HotelDAO hotelDao;
        private FormCRUDHotel formHotel;
        
        private IngresosHotel ingresoHotel;
        private FormCheckOut formCheckOut;

        public ControladorHoteles(Hotel hotel, FormCRUDHotel formHotel) {
                this.hotel = hotel;
                this.formHotel = formHotel;
                this.hotelDao= new HotelDAOImp();
        }

        public ControladorHoteles() {
                this.hotelDao= new HotelDAOImp();
                
        }

        public ControladorHoteles(IngresosHotel ingresoHotel, FormCheckOut formCheckOut) {
            this.ingresoHotel = ingresoHotel;
            this.formCheckOut = formCheckOut;
            this.hotelDao= new HotelDAOImp();
        }    
        
        public void registrarHotel(){
                if (hotelDao.registrar(hotel)) {
                        JOptionPane.showMessageDialog(formHotel, REGISTRO_GUARDADO, REGISTRO, 1);  
                        formHotel.agregarHotelEnTabla(hotelDao.recuperarHotel(hotel.getNombre()));
                        formHotel.organizarFormulario();
                } else{
                        JOptionPane.showMessageDialog(formHotel, ERR_INSERCION, ERROR_CREACION, JOptionPane.ERROR_MESSAGE);
                }   
        }
        public void actualizarHotel(){
                if (hotelDao.actualizar(hotel,formHotel.retornarHotelTemporal())) {
                        JOptionPane.showMessageDialog(formHotel, REGISTRO_MODIFICADO, MODIFICACION, 1);
                        formHotel.actualizarHotelEnTabla();
                        formHotel.organizarFormulario();
                } else{
                        JOptionPane.showMessageDialog(formHotel, ERR_INSERCION, ERROR_ACTUALIZACION, JOptionPane.ERROR_MESSAGE);
                }   
        }
        public void eliminarHotel(){
                 //se envia a la bd
                if (hotelDao.eliminar(hotel)) {
                        JOptionPane.showMessageDialog(formHotel, REGISTRO_ELIMINADO, ELIMINACION, 1);
                        formHotel.eliminarHotelEnTabla();
                        formHotel.organizarFormulario();
                } else{
                        JOptionPane.showMessageDialog(formHotel, HOTEL_NO_EXISTENETE, ERROR_ELIMINACION, JOptionPane.ERROR_MESSAGE);
                }   
        }
        public void recuperarHotel(){
                Hotel hot=hotelDao.recuperarHotel(hotel.getNombre());
                if (hot!=null) {
                        JOptionPane.showMessageDialog(formHotel, REGISTRO_RECUPERADO, RECUPERACION, 1);
                        formHotel.rellenarCampos(hot);
                } else{
                        JOptionPane.showMessageDialog(formHotel, HOTEL_NO_EXISTENETE, ERROR_RECUP, JOptionPane.ERROR_MESSAGE);
                }   
        }
        
        public List<Hotel> recuperarHoteles(){
                return hotelDao.recuperarLista();
        }
        public int recuperarNumeroHabitaciones(int idHotel){
                return hotelDao.recuperarNumeroHabitaciones(idHotel);
        }
        public void registrarIngresosHotel(){
                if (hotelDao.registrarIngresoHotel(ingresoHotel)) {
                        System.out.println("Ingreso Hotel Registrado");
                } else{
                        JOptionPane.showMessageDialog(formHotel, ERR_INSERCION, ERROR_CREACION, JOptionPane.ERROR_MESSAGE);
                }   
        }
        
}
