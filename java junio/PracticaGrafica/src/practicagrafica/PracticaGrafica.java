/*
 */
package practicagrafica;

/**
 *
 * @author bryan
 */
public class PracticaGrafica {
    private static Formulario datosFormulario = new Formulario();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        datosFormulario.setVisible(true);
    }

    public static Formulario getDatosFormulario() {
        return datosFormulario;
    }

    public static void setDatosFormulario(Formulario datosFormulario) {
        PracticaGrafica.datosFormulario = datosFormulario;
    }
    
}
