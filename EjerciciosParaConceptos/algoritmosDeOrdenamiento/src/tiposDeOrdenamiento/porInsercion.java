package tiposDeOrdenamiento;


public class porInsercion {
    
    public void insercion (int[] orden){
        double aux;
        int cont1;
        int cont2;
        
        for (cont1 = 1; cont1 < orden.length; cont1++){
            aux = orden[cont1];
            for (cont2 = cont1-1; cont2 >= 0 && orden[cont2] > aux; cont2--){
                orden[cont2+1] = orden[cont2];
                orden[cont2] = (int) aux;
            }
        }
        
    }
    
}
