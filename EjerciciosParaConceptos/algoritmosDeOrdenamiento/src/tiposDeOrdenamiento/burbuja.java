package tiposDeOrdenamiento;


public class burbuja {
    public void burbuja(int[] orden){
        int aux;
        boolean cambios = false;
        
        while(true){
            cambios = false;
            for(int i = 1; i < orden.length; i++){
                if (orden[i] < orden[i-1]){
                    aux = orden[i];
                    orden[i] = orden[i-1];
                    orden[i-1] = aux;
                    cambios = true;
                }
            }
            if (cambios == false)
                break;
        }
    }
}
