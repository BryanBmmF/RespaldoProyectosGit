/*
 * Clase Documento
 */
package proyecto2;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import proyecto2.UI.ExportadorPDF;

/**
 *
 * @author bryan
 */
public class Documento {
    
    //atributos de un Documento
    private static ExportadorPDF exportador ;
    private static ControladorArchivos archivo;
    private static Conversor conversor;
    public static String rutaArchVentas ="src/proyecto2/archivos/venta/";
    public static String rutaArchAlquiler ="src/proyecto2/archivos/alquiler/";
    public static String rutaArchAuten ="src/proyecto2/archivos/autentica/";
    public Documento(){
        this.exportador= new ExportadorPDF(Proyecto2.ventanaPrincipal);
        this.archivo= new ControladorArchivos();
        this.conversor= new Conversor();
    }
    public static void crearDocumentoVenta(Venta venta){
        //conversion de fecha de venta
        String fecha = venta.getFechaDeVenta().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String dia= fecha.substring(0, 2);
        String mes=fecha.substring(3, 5);
        String an= fecha.substring(6,10);
        //convirtiendo CuiVendedor
        String cuiVendedor= String.valueOf(venta.getClienteVendedor().getNumeroCui());
        String cuiVend1=conversor.convertidorNumeros(Integer.parseInt(cuiVendedor.substring(0, 4)));
        String cuiVend2=conversor.convertidorNumeros(Integer.parseInt(cuiVendedor.substring(4, 9)));
        String cuiVend3=conversor.convertidorNumeros(Integer.parseInt(cuiVendedor.substring(9, 13)));
        //convirtiendo CuiComprador
        String cuiComprador= String.valueOf(venta.getClienteVendedor().getNumeroCui());
        String cuiComp1=conversor.convertidorNumeros(Integer.parseInt(cuiComprador.substring(0, 4)));
        String cuiComp2=conversor.convertidorNumeros(Integer.parseInt(cuiComprador.substring(4, 9)));
        String cuiComp3=conversor.convertidorNumeros(Integer.parseInt(cuiComprador.substring(9, 13)));
        
        List<String> parte2Venta=new ArrayList<>();
        parte2Venta=archivo.leerArchivo(rutaArchVentas+"parte2.txt");
        String parte2=" ";
        for(String linea: parte2Venta){
            parte2+=linea+" "+"\n";
        }
        parte2= parte2+" "+String.valueOf(venta.getPropiedadEnVenta().getCosto())+" ";
        
        List<String> parte3Venta=new ArrayList<>();
        String parte3=" ";
        parte3Venta=archivo.leerArchivo(rutaArchVentas+"parte3.txt");
        for(String linea: parte3Venta){
            parte3+=linea+" "+"\n";
        }
        
        String contenido=archivo.lecturaBasica(rutaArchVentas+"parte1.txt")+" "+conversor.convertidorNumeros(
        Integer.parseInt(dia))+" de"+conversor.convertirMeses(Integer.parseInt(mes))+"del "+conversor.convertidorNumeros(
        Integer.parseInt(an))+".\n\n"+"El Vendedor: \nDon(ña)."+((Persona)venta.getClienteVendedor()).getNombre()
        +" "+((Persona)venta.getClienteVendedor()).getApellido()+" con DOCUMENTO PERSONAL DE IDENTIFICACIÓN \n-DPI- con CÓDIGO"
                + " ÚNICO DE IDENTIFICACIÓN -CUI- numero "+cuiVend1+",\n "+cuiVend2+", "+cuiVend3+", ("+cuiVendedor+"), y domicilio"
                + " en \n"+venta.getClienteVendedor().getResidencia()+" del municipio de "+venta.getClienteVendedor().getMunicipio()
                +", Departamento de "+venta.getClienteVendedor().getDepartamento()+".\n"
                
                +"\n"+"El Comprador: \nDon(ña)."+((Persona)venta.getClienteComprador()).getNombre()
                +" "+((Persona)venta.getClienteComprador()).getApellido()+" con DOCUMENTO PERSONAL DE IDENTIFICACIÓN\n -DPI- con CÓDIGO"
                + " ÚNICO DE IDENTIFICACIÓN -CUI- numero "+cuiComp1+",\n "+cuiComp2+", "+cuiComp3+", ("+cuiComprador+"), y domicilio"
                + " en \n"+venta.getClienteComprador().getResidencia()+" del municipio de "+venta.getClienteComprador().getMunicipio()
                +", Departamento de "+venta.getClienteComprador().getDepartamento()+".\n"
                +"Reunidos vendedor y comprador en la fecha del encabezamiento, manifiestan haber "
                + "\nacordado formalizar en este documento CONTRATO DE COMPRAVENTA del vehículo "
                + "\nautomóvil que se especifica, en las siguientes."
                +"\n\n"+"Vehiculo: \n"
                +"Marca: "+((Vehiculo) venta.getPropiedadEnVenta()).getMarca()+"\n"
                +"Modelo: "+((Vehiculo) venta.getPropiedadEnVenta()).getModelo()+"\n"
                +"Placa: "+((Vehiculo) venta.getPropiedadEnVenta()).getPlaca()+"\n"
                +"Tipo: "+((Vehiculo) venta.getPropiedadEnVenta()).getTipo()+"\n"
                +parte2+"\n"+parte3
                +"\n\n\n\n\n\n"
                + ((Abogado) venta.getAbogadoIntermediario()).getTitulo()
                +((Persona) venta.getAbogadoIntermediario()).getNombre()+" "+((Persona) venta.getAbogadoIntermediario()).getApellido()
                +"\nNo.Colegiado: "+((Abogado) venta.getAbogadoIntermediario()).getNumeroColegiado()+". ";
        
        exportador.cargarAreaTexto(contenido);
        exportador.setVisible(true);
    }
    public static void crearDocumentoVenta2(Venta venta){
        //conversion de fecha de venta
        String fecha = venta.getFechaDeVenta().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String dia= fecha.substring(0, 2);
        String mes=fecha.substring(3, 5);
        String an= fecha.substring(6,10);
        //convirtiendo CuiVendedor
        String cuiVendedor= String.valueOf(venta.getClienteVendedor().getNumeroCui());
        String cuiVend1=conversor.convertidorNumeros(Integer.parseInt(cuiVendedor.substring(0, 4)));
        String cuiVend2=conversor.convertidorNumeros(Integer.parseInt(cuiVendedor.substring(4, 9)));
        String cuiVend3=conversor.convertidorNumeros(Integer.parseInt(cuiVendedor.substring(9, 13)));
        //convirtiendo CuiComprador
        String cuiComprador= String.valueOf(venta.getClienteVendedor().getNumeroCui());
        String cuiComp1=conversor.convertidorNumeros(Integer.parseInt(cuiComprador.substring(0, 4)));
        String cuiComp2=conversor.convertidorNumeros(Integer.parseInt(cuiComprador.substring(4, 9)));
        String cuiComp3=conversor.convertidorNumeros(Integer.parseInt(cuiComprador.substring(9, 13)));
        
        List<String> parte2Venta=new ArrayList<>();
        parte2Venta=archivo.leerArchivo(rutaArchVentas+"parte4.txt");
        String parte2=" ";
        for(String linea: parte2Venta){
            parte2+=linea+" "+"\n";
        }
        parte2= parte2+" "+String.valueOf(venta.getPropiedadEnVenta().getCosto())+" ";
        
        List<String> parte3Venta=new ArrayList<>();
        String parte3=" ";
        parte3Venta=archivo.leerArchivo(rutaArchVentas+"parte5.txt");
        for(String linea: parte3Venta){
            parte3+=linea+" "+"\n";
        }
        
        String contenido=archivo.lecturaBasica(rutaArchVentas+"parte1.txt")+" "+conversor.convertidorNumeros(
        Integer.parseInt(dia))+" de"+conversor.convertirMeses(Integer.parseInt(mes))+"del "+conversor.convertidorNumeros(
        Integer.parseInt(an))+".\n\n"+"El Vendedor: \nDon(ña)."+((Persona)venta.getClienteVendedor()).getNombre()
        +" "+((Persona)venta.getClienteVendedor()).getApellido()+" con DOCUMENTO PERSONAL DE IDENTIFICACIÓN \n-DPI- con CÓDIGO"
                + " ÚNICO DE IDENTIFICACIÓN -CUI- numero "+cuiVend1+",\n "+cuiVend2+", "+cuiVend3+", ("+cuiVendedor+"), y domicilio"
                + " en \n"+venta.getClienteVendedor().getResidencia()+" del municipio de "+venta.getClienteVendedor().getMunicipio()
                +", Departamento de "+venta.getClienteVendedor().getDepartamento()+".\n"
                
                +"\n"+"El Comprador: \nDon(ña)."+((Persona)venta.getClienteComprador()).getNombre()
                +" "+((Persona)venta.getClienteComprador()).getApellido()+" con DOCUMENTO PERSONAL DE IDENTIFICACIÓN\n -DPI- con CÓDIGO"
                + " ÚNICO DE IDENTIFICACIÓN -CUI- numero "+cuiComp1+",\n "+cuiComp2+", "+cuiComp3+", ("+cuiComprador+"), y domicilio"
                + " en \n"+venta.getClienteComprador().getResidencia()+" del municipio de "+venta.getClienteComprador().getMunicipio()
                +", Departamento de "+venta.getClienteComprador().getDepartamento()+".\n"
                +"Reunidos vendedor y comprador en la fecha del encabezamiento, manifiestan haber "
                + "\nacordado formalizar en este documento CONTRATO DE COMPRAVENTA DEL INMUEBLE "
                + "\nque se especifica, en las siguientes."
                +"\n\n"+((Propiedad) venta.getPropiedadEnVenta()).getNombrePropiedad()+"\n"
                +"Direccion: "+((Inmueble) venta.getPropiedadEnVenta()).getDireccion()+"\n"
                +"Medidas : "+((Inmueble) venta.getPropiedadEnVenta()).getMedidas()+" metros Cuadrados\n"
                +"Numero de Niveles : "+((Inmueble) venta.getPropiedadEnVenta()).getNumeroDeNiveles()+"\n"
                +"Costo: "+((Propiedad) venta.getPropiedadEnVenta()).getCosto()+"\n"
                +parte2+"\n"+parte3
                +"\n\n\n\n\n\n"
                + ((Abogado) venta.getAbogadoIntermediario()).getTitulo()
                +((Persona) venta.getAbogadoIntermediario()).getNombre()+" "+((Persona) venta.getAbogadoIntermediario()).getApellido()
                +"\nNo.Colegiado: "+((Abogado) venta.getAbogadoIntermediario()).getNumeroColegiado()+". ";
        
        exportador.cargarAreaTexto(contenido);
        exportador.setVisible(true);
    }
    public static void crearDocumentoAutentica(Autentica autentica){
        //conversion de fecha de venta
        String fecha = autentica.getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String dia= fecha.substring(0, 2);
        String mes=fecha.substring(3, 5);
        String an= fecha.substring(6,10);
        //convirtiendo CuiCliente
        String cuiCliente= String.valueOf(autentica.getCliente().getNumeroCui());
        String cuiC1=conversor.convertidorNumeros(Integer.parseInt(cuiCliente.substring(0, 4)));
        String cuiC2=conversor.convertidorNumeros(Integer.parseInt(cuiCliente.substring(4, 9)));
        String cuiC3=conversor.convertidorNumeros(Integer.parseInt(cuiCliente.substring(9, 13)));
        //convirtiendo Colegiado
        String colegiado= String.valueOf(autentica.getAbogado().getNumeroColegiado());
        String coleg=conversor.convertidorNumeros(Integer.parseInt(colegiado.substring(0, 5)));
        
        List<String> parte2Venta=new ArrayList<>();
        parte2Venta=archivo.leerArchivo(rutaArchAuten+"parte2.txt");
        String parte2=" ";
        for(String linea: parte2Venta){
            parte2+=linea+" "+"\n";
        }
        parte2Venta=archivo.leerArchivo(rutaArchAuten+"parte3.txt");
        String parte3=" ";
        for(String linea: parte2Venta){
            parte3+=linea+" "+"\n";
        }
        
        String contenido=archivo.lecturaBasica(rutaArchAuten+"parte1.txt")+" "+conversor.convertidorNumeros(
        Integer.parseInt(dia))+" de "+conversor.convertirMeses(Integer.parseInt(mes))+" del "+conversor.convertidorNumeros(
        Integer.parseInt(an))+parte2+" "+cuiC1+", "+cuiC2+", "+cuiC3+",\n ("+cuiCliente+"), perteneciente a "
                +((Persona)autentica.getCliente()).getNombre()+" "+((Persona)autentica.getCliente()).getApellido()
                +"\n"+parte3+"\n\n\n\n\n\n"
                + ((Abogado) autentica.getAbogado()).getTitulo()
                +((Persona) autentica.getAbogado()).getNombre()+" "+((Persona) autentica.getAbogado()).getApellido()
                +"\nNo.Colegiado: "+((Abogado) autentica.getAbogado()).getNumeroColegiado()+". ";
        
        exportador.cargarAreaTexto(contenido);
        exportador.setVisible(true);
        
    }
    public static void crearDocumentoAlquiler(Alquiler alquiler){
        //conversion de fecha de venta
        String fecha = alquiler.getFechaDeAlquiler().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String dia= fecha.substring(0, 2);
        String mes=fecha.substring(3, 5);
        String an= fecha.substring(6,10);
        //convirtiendo CuiVendedor
        String cuiVendedor= String.valueOf(alquiler.getClientePrestador().getNumeroCui());
        String cuiVend1=conversor.convertidorNumeros(Integer.parseInt(cuiVendedor.substring(0, 4)));
        String cuiVend2=conversor.convertidorNumeros(Integer.parseInt(cuiVendedor.substring(4, 9)));
        String cuiVend3=conversor.convertidorNumeros(Integer.parseInt(cuiVendedor.substring(9, 13)));
        //convirtiendo CuiComprador
        String cuiComprador= String.valueOf(alquiler.getClienteAdquisisor().getNumeroCui());
        String cuiComp1=conversor.convertidorNumeros(Integer.parseInt(cuiComprador.substring(0, 4)));
        String cuiComp2=conversor.convertidorNumeros(Integer.parseInt(cuiComprador.substring(4, 9)));
        String cuiComp3=conversor.convertidorNumeros(Integer.parseInt(cuiComprador.substring(9, 13)));
        
        List<String> parte2Venta=new ArrayList<>();
        parte2Venta=archivo.leerArchivo(rutaArchAlquiler+"parte2.txt");
        String parte2=" ";
        for(String linea: parte2Venta){
            parte2+=linea+" "+"\n";
        }
        parte2= parte2+alquiler.getDiaDePago()+".\n";
        
        List<String> parte3Venta=new ArrayList<>();
        String parte3=" "+alquiler.getDiaDePago()+" ";
        parte3Venta=archivo.leerArchivo(rutaArchAlquiler+"parte3.txt");
        for(String linea: parte3Venta){
            parte3+=linea+" "+"\n";
        }
        
        String contenido=archivo.lecturaBasica(rutaArchVentas+"parte1.txt")+" "+conversor.convertidorNumeros(
        Integer.parseInt(dia))+" de"+conversor.convertirMeses(Integer.parseInt(mes))+"del "+conversor.convertidorNumeros(
        Integer.parseInt(an))+".\n\n"+"El Arrendador: \nDon(ña)."+((Persona)alquiler.getClientePrestador()).getNombre()
        +" "+((Persona)alquiler.getClientePrestador()).getApellido()+" con DOCUMENTO PERSONAL DE IDENTIFICACIÓN\n-DPI- con CÓDIGO"
                + " ÚNICO DE IDENTIFICACIÓN -CUI- numero "+cuiVend1+", "+cuiVend2+", "+cuiVend3+",\n ("+cuiVendedor+"), y domicilio"
                + " en "+alquiler.getClientePrestador().getResidencia()+"\n del municipio de "+alquiler.getClientePrestador().getMunicipio()
                +", Departamento de "+alquiler.getClientePrestador().getDepartamento()+".\n\n"
                
                +".\n\n"+"El Arrendatario: \n\nDon(ña)."+((Persona)alquiler.getClienteAdquisisor()).getNombre()
                +" "+((Persona)alquiler.getClienteAdquisisor()).getApellido()+" con DOCUMENTO PERSONAL DE IDENTIFICACIÓN -DPI- con CÓDIGO"
                + " \nÚNICO DE IDENTIFICACIÓN -CUI- numero "+cuiComp1+",\n "+cuiComp2+", "+cuiComp3+", ("+cuiComprador+"), y domicilio"
                + " en \n"+alquiler.getClienteAdquisisor().getResidencia()+" del municipio de "+alquiler.getClienteAdquisisor().getMunicipio()
                +", Departamento de "+alquiler.getClienteAdquisisor().getDepartamento()+".\n"
                
                +"I.Reunidos Arrendador y Arrendatario en la fecha del encabezamiento, manifiestan haber"
                + "\nacordado formalizar en este documento CONTRATO DE ARRENDAMIENTO DE INMUEBLE  que se "
                + "\nespecifica, en las siguientes."
                +"\n\n"+"Alquiler de Inmueble: \n"
                
                +"Nombre de Inmueble: "+alquiler.getPropiedadEnAlquiler().getNombrePropiedad()
                +"Direccion: "+((Inmueble) alquiler.getPropiedadEnAlquiler()).getDireccion()+"\n"
                +"Fecha de Inicio: "+alquiler.getFechaInicialDeAlquiler()+"\n"
                +"Fecha de Finalizacion: "+alquiler.getFechaFinalDeAlquiler()+"\n"
                +"Costo Mensual: "+String.valueOf(alquiler.getPropiedadEnAlquiler().getCosto())+"\n\n"
                +parte2+"\n"+parte3
                +"\n\n\n\n\n\n"
                + ((Abogado) alquiler.getAbogadoIntermediario()).getTitulo()
                +((Persona) alquiler.getAbogadoIntermediario()).getNombre()+" "+((Persona) alquiler.getAbogadoIntermediario()).getApellido()
                +"\nNo.Colegiado: "+((Abogado) alquiler.getAbogadoIntermediario()).getNumeroColegiado()+". ";
                
        exportador.cargarAreaTexto(contenido);
        exportador.setVisible(true);
    }
}
