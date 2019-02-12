package tiposDeOrdenamiento;


public class porSeleccion {
    
     public void seleccion(int[] orden) {
          int i, j, menor, pos, tmp;
          for (i = 0; i < orden.length - 1; i++) { // tomamos como menor el primero
                menor = orden[i]; // de los elementos que quedan por ordenar
                pos = i; // y guardamos su posición
                for (j = i + 1; j < orden.length; j++){ // buscamos en el resto
                      if (orden[j] < menor) { // del array algún elemento
                          menor = orden[j]; // menor que el actual
                          pos = j;
                      }
                }
                if (pos != i){ // si hay alguno menor se intercambia
                    tmp = orden[i];
                    orden[i] = orden[pos];
                    orden[pos] = tmp;
                }
          }
}
    
}
