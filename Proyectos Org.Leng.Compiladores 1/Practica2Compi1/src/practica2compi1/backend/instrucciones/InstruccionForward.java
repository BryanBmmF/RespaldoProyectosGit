/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2compi1.backend.instrucciones;

import practica2compi1.frontend.PanelGrafico;

/**
 *
 * @author bryan
 */
public class InstruccionForward extends Instruccion{
    
    private Integer n;

    public InstruccionForward(Integer n, String token) {
        super(token);
        this.n = n;
    }

    @Override
    public void ejecutar(PanelGrafico panel) {
            //panel.agregarLinea(panel.getCentroX(), panel.getCentroY(), panel.getCentroX(), n);
        if (panel.isPluma()) {
            if (panel.isSobreY() && panel.getmActual()==0) {
                  panel.agregarLinea(panel.getActualX(), panel.getActualY(), panel.getActualX(), panel.getActualY()-n); 
                  //System.out.println("se hizo 0 la m");
                  panel.setActualX(panel.getActualX());
                  panel.setActualY(panel.getActualY()-n);
            } else if(panel.isSobreY() && panel.getmActual()!=0){
                        int nuevoX = panel.getActualX()+panel.obtenerX(n, Math.toRadians(panel.getmActual()));
                        int nuevoY = panel.getActualY()-panel.obtenerY(n, Math.toRadians(panel.getmActual()));
                        panel.agregarLinea(panel.getActualX(), panel.getActualY(), nuevoX, nuevoY);
                        
                        panel.setActualX(nuevoX);
                        panel.setActualY(nuevoY);
                    } else if((!panel.isSobreY() && panel.getmActual()==0)){
                                panel.agregarLinea(panel.getActualX(), panel.getActualY(), panel.getActualX(), panel.getActualY()-n); 
                               
                                //panel.setActualX(panel.getActualX());
                                //panel.setActualY(panel.getActualY()-n);
                            } else if ((!panel.isSobreY() && panel.getmActual()!=0)){
                                                    int nuevoX = panel.getActualX()-panel.obtenerX(n, Math.toRadians(panel.getmActual()));
                                                    int nuevoY = panel.getActualY()-panel.obtenerY(n, Math.toRadians(panel.getmActual()));
                                                    panel.agregarLinea(panel.getActualX(), panel.getActualY(), nuevoX, nuevoY);

                                                    panel.setActualX(nuevoX);
                                                    panel.setActualY(nuevoY);
                                    }
            
            
            panel.repaint();

        } else {//colocar solo puntos finales para que no genere trazos la tortuga culera..
                if (panel.isSobreY() && panel.getmActual()==0) {
                        panel.agregarLinea(panel.getActualX(), panel.getActualY()-n, panel.getActualX(), panel.getActualY()-n); 
                        //System.out.println("se hizo 0 la m");
                        panel.setActualX(panel.getActualX());
                        panel.setActualY(panel.getActualY()-n);
                } else if(panel.isSobreY() && panel.getmActual()!=0){
                            int nuevoX = panel.getActualX()+panel.obtenerX(n, Math.toRadians(panel.getmActual()));
                            int nuevoY = panel.getActualY()-panel.obtenerY(n, Math.toRadians(panel.getmActual()));
                            panel.agregarLinea(nuevoX, nuevoY, nuevoX, nuevoY);

                            panel.setActualX(nuevoX);
                            panel.setActualY(nuevoY);
                        } else if((!panel.isSobreY() && panel.getmActual()==0)){
                                    panel.agregarLinea(panel.getActualX(), panel.getActualY()-n, panel.getActualX(), panel.getActualY()-n); 

                                    //panel.setActualX(panel.getActualX());
                                    //panel.setActualY(panel.getActualY()-n);
                                } else if ((!panel.isSobreY() && panel.getmActual()!=0)){
                                                        int nuevoX = panel.getActualX()-panel.obtenerX(n, Math.toRadians(panel.getmActual()));
                                                        int nuevoY = panel.getActualY()-panel.obtenerY(n, Math.toRadians(panel.getmActual()));
                                                        panel.agregarLinea(nuevoX, nuevoY, nuevoX, nuevoY);

                                                        panel.setActualX(nuevoX);
                                                        panel.setActualY(nuevoY);
                                        }


                panel.repaint();
        
        }
            
    }
    
}
