/*
 * Clase Partido
 */
package practicaclases;

import java.util.List;

/**
 *
 * @author bryan
 */
public class Partido {
    //atributos
    private Campo campo;
    private List<Arbitro> arbitros;
    private List<Jugador> jugadoresEquipo1;
    private List<Jugador> jugadoresEquipo2;
    private List<Tecnico> tecnicos;
    //metodo Constructor
    public Partido(Campo campo, List<Arbitro> arbitros, List<Jugador> jugadoresEquipo1,List<Jugador> jugadoresEquipo2, List<Tecnico> tecnicos) {
        this.campo = campo;
        this.arbitros = arbitros;
        this.jugadoresEquipo1 = jugadoresEquipo1;
        this.jugadoresEquipo2= jugadoresEquipo2;
        this.tecnicos = tecnicos;
    }
    //metodos Accesores
    public Campo getCampo() {
        return campo;
    }

    public void setCampo(Campo campo) {
        this.campo = campo;
    }

    public List<Arbitro> getArbitros() {
        return arbitros;
    }

    public void setArbitros(List<Arbitro> arbitros) {
        this.arbitros = arbitros;
    }

    public List<Jugador> getJugadoresEquipo1() {
        return jugadoresEquipo1;
    }

    public void setJugadoresEquipo1(List<Jugador> jugadoresEquipo1) {
        this.jugadoresEquipo1 = jugadoresEquipo1;
    }

    public List<Jugador> getJugadoresEquipo2() {
        return jugadoresEquipo2;
    }

    public void setJugadoresEquipo2(List<Jugador> jugadoresEquipo2) {
        this.jugadoresEquipo2 = jugadoresEquipo2;
    }

    public List<Tecnico> getTecnicos() {
        return tecnicos;
    }

    public void setTecnicos(List<Tecnico> tecnicos) {
        this.tecnicos = tecnicos;
    }
    
    
}
