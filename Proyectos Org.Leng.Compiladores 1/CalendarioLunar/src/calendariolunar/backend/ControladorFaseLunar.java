package calendariolunar.backend;

import calendariolunar.frontend.InfoFaseLunar;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author bryan
 */
public class ControladorFaseLunar {
    private InfoFaseLunar info;
    private int fase;
    private CalculadorFaseLunar calc;
    private LocalDate fechaPivote;
    private ConstanteFaseLunar constFase;

    public ControladorFaseLunar(InfoFaseLunar info, int fase, LocalDate fechaPivote) {
        this.info = info;
        this.fase = fase;
        this.fechaPivote = fechaPivote;
        this.constFase = new ConstanteFaseLunar(fase);
        // Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
        this.calc = new CalculadorFaseLunar(Date.from(fechaPivote.atStartOfDay(ZoneId.systemDefault()).toInstant()));
    }
    
    public void mostrarInformacion(){
        int faseActual = calc.calcularFaseLunar();
        
        //fecha proxima de la fase seleccionada
        System.out.println("** La fecha sera: "+devolverFechaProxima(faseActual,fase, fechaPivote).toString());
        LocalDate fechaProximaFase = devolverFechaProxima(faseActual,fase, fechaPivote);
        info.establecerInfo(constFase.obtenerRutaImagen(), constFase.obtenerConstante());
        info.establecerFechaProximaFase(fechaProximaFase);
        info.establecerNuevaFechaFase(fechaProximaFase);
    }
    
    
    
    public LocalDate devolverFechaProxima(int faseActual,int fase, LocalDate fechaPivote){
        LocalDate fechaProximaFase = fechaPivote;
        long nDias = 0;
        if (fase>=faseActual) {
            nDias= fase-faseActual;
            fechaProximaFase = fechaProximaFase.plusDays(nDias);
            
        } else {
            nDias = (30-faseActual)+fase;
            fechaProximaFase = fechaProximaFase.plusDays(nDias);
        }
        return fechaProximaFase;
    
    }
    
    
    public void establecerFechaAnterior(LocalDate nuevaFecha){
        LocalDate fechaAnterior = nuevaFecha;
        fechaAnterior = fechaAnterior.minusDays(30);
        info.establecerNuevaFechaFase(fechaAnterior);
        //return fechaAnterior;
        
    }
    
    public void establecerFechaSiguiente(LocalDate nuevaFecha){
        LocalDate fechaSiguiente = nuevaFecha;
        fechaSiguiente = fechaSiguiente.plusDays(30);
        //return fechaSiguiente;
        info.establecerNuevaFechaFase(fechaSiguiente);
        
    }
    
    
}
