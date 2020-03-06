/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Instructions;

import Objetos.Cuarteto;
import java.util.List;

/**
 *
 * @author jpmazate
 */
public interface Instruction {

    public void setAmbit(int ambito);

    public boolean validate();

    public abstract List<Cuarteto> execute();

    public void asignarValorFuncion(String idFuncion);
    
    public boolean asignarReturn(String tipo,String tSalida);
}
