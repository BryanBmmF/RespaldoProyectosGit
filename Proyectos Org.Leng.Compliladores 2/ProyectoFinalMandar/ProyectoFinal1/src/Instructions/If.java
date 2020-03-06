/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Instructions;

import Objetos.Cuarteto;
import Objetos.Logica;
import Tablas.TablaSimbolos.TablaSimbolos;
import Tablas.TablaTipos.TablaTipos;
import Valores.Etiquetas;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpmazate
 */
public class If implements Instruction{
    
    private BaseIf baseIf;
    private List<Elsif> elsif;
    private Else sino;
    private Logica logica = new Logica();
    private TablaTipos tablaTipos;
    private TablaSimbolos tablaSimbolos;

    public If(BaseIf baseIf, List<Elsif> elsif, Else sino,  TablaSimbolos tablaSimbolos,TablaTipos tablaTipos) {
        this.baseIf = baseIf;
        this.elsif = elsif;
        this.sino = sino;
        this.tablaTipos = tablaTipos;
        this.tablaSimbolos = tablaSimbolos;
    }

    @Override
    public void setAmbit(int ambito) {
        baseIf.setAmbit(ambito);
        if(this.elsif!=null){
            for (int i = 0; i < elsif.size(); i++) {
                elsif.get(i).setAmbit(ambito);
            }
        }
        if(sino!=null){
            sino.setAmbit(ambito);
        }
    }
    
    
    @Override
    public void asignarValorFuncion(String idFuncion) {
        baseIf.asignarValorFuncion(idFuncion);
        if(this.elsif!=null){
            for (int i = 0; i < elsif.size(); i++) {
                elsif.get(i).asignarValorFuncion(idFuncion);
            }
        }
        if(sino!=null){
            sino.asignarValorFuncion(idFuncion);
        }
    }

    
    
    

    @Override
    public boolean validate() {
        boolean banderaIf = baseIf.validate();
        boolean banderaelsif=true;
        boolean banderasino=true;
        if(elsif!=null){
            for (int i = 0; i < elsif.size(); i++) {
                boolean bandera = elsif.get(i).validate();
                if(!bandera){
                    banderaelsif = false;
                }
            }
        }
        
        if(sino!=null){
            banderasino = sino.validate();
        }
        
        if(banderasino && banderaIf && banderaelsif){
            return true;
        }
        
        
        return false;
        
        
    }

    @Override
    public List<Cuarteto> execute() {
        
        if (elsif == null && sino == null) {

            List<Cuarteto> lista = new ArrayList<>(), listaCondicion = new ArrayList<>(), aux = new ArrayList<>();
            listaCondicion = baseIf.getCondicion().execute();
            Cuarteto.unirCuartetos(lista, listaCondicion);
            String etiquetaInstrucciones = Etiquetas.siguienteEtiqueta();
            String etiquetaSalida = Etiquetas.siguienteEtiqueta();
            String temporalCondicion = logica.returnUltimoTemporalCondicion(listaCondicion);
            Cuarteto cuartetoEtiqueta, cuartetoIf, cuartetoGoto;

            cuartetoIf = new Cuarteto();
            cuartetoIf.setOperador("IF");
            cuartetoIf.setResultado(temporalCondicion);
            lista.add(cuartetoIf);

            cuartetoGoto = new Cuarteto();
            cuartetoGoto.setOperador("GOTO");
            cuartetoGoto.setResultado(etiquetaInstrucciones);
            lista.add(cuartetoGoto);

            cuartetoGoto = new Cuarteto();
            cuartetoGoto.setOperador("GOTO");
            cuartetoGoto.setResultado(etiquetaSalida);
            lista.add(cuartetoGoto);

            cuartetoEtiqueta = new Cuarteto();
            cuartetoEtiqueta.setOperador("ET");
            cuartetoEtiqueta.setResultado(etiquetaInstrucciones);
            lista.add(cuartetoEtiqueta);
            aux = new ArrayList<>();
            for (int i = 0; i < this.baseIf.getInstructions().size(); i++) {
                Cuarteto.unirCuartetos(aux, this.baseIf.getInstructions().get(i).execute());
            }
            Cuarteto.unirCuartetos(lista, aux);
            cuartetoGoto = new Cuarteto();
            cuartetoGoto.setOperador("GOTO");
            cuartetoGoto.setResultado(etiquetaSalida);
            lista.add(cuartetoGoto);

            cuartetoEtiqueta = new Cuarteto();
            cuartetoEtiqueta.setOperador("ET");
            cuartetoEtiqueta.setResultado(etiquetaSalida);
            lista.add(cuartetoEtiqueta);

            return lista;

        } else if (elsif != null && sino == null) {
            List<Cuarteto> lista = new ArrayList<>(), listaCondicion = new ArrayList<>(), aux = new ArrayList<>();
            listaCondicion = baseIf.getCondicion().execute();
            Cuarteto.unirCuartetos(lista, listaCondicion);

            List<String> etiquetaInicio = new ArrayList<>();
            List<String> etiquetaInstruccion = new ArrayList<>();

            String etiquetaIf = Etiquetas.siguienteEtiqueta();
            String etiquetaSalida = Etiquetas.siguienteEtiqueta();

            for (int i = 0; i < this.elsif.size(); i++) {
                etiquetaInicio.add(Etiquetas.siguienteEtiqueta());
                etiquetaInstruccion.add(Etiquetas.siguienteEtiqueta());
            }

            String temporalCondicion = logica.returnUltimoTemporalCondicion(listaCondicion);
            Cuarteto cuartetoEtiqueta, cuartetoIf, cuartetoGoto;

            cuartetoIf = new Cuarteto();
            cuartetoIf.setOperador("IF");
            cuartetoIf.setResultado(temporalCondicion);
            lista.add(cuartetoIf);

            cuartetoGoto = new Cuarteto();
            cuartetoGoto.setOperador("GOTO");
            cuartetoGoto.setResultado(etiquetaIf);
            lista.add(cuartetoGoto);

            cuartetoGoto = new Cuarteto();
            cuartetoGoto.setOperador("GOTO");
            cuartetoGoto.setResultado(etiquetaInicio.get(0));
            lista.add(cuartetoGoto);

            cuartetoEtiqueta = new Cuarteto();
            cuartetoEtiqueta.setOperador("ET");
            cuartetoEtiqueta.setResultado(etiquetaIf);
            lista.add(cuartetoEtiqueta);
            aux = new ArrayList<>();
            for (int i = 0; i < this.baseIf.getInstructions().size(); i++) {
                Cuarteto.unirCuartetos(aux, this.baseIf.getInstructions().get(i).execute());
            }
            Cuarteto.unirCuartetos(lista, aux);

            cuartetoGoto = new Cuarteto();
            cuartetoGoto.setOperador("GOTO");
            cuartetoGoto.setResultado(etiquetaSalida);
            lista.add(cuartetoGoto);

            for (int i = 0; i < etiquetaInicio.size(); i++) {
                cuartetoEtiqueta = new Cuarteto();
                cuartetoEtiqueta.setOperador("ET");
                cuartetoEtiqueta.setResultado(etiquetaInicio.get(i));
                lista.add(cuartetoEtiqueta);

                listaCondicion = this.elsif.get(i).getCondicion().execute();
                Cuarteto.unirCuartetos(lista, listaCondicion);
                temporalCondicion = logica.returnUltimoTemporalCondicion(listaCondicion);

                cuartetoIf = new Cuarteto();
                cuartetoIf.setOperador("IF");
                cuartetoIf.setResultado(temporalCondicion);
                lista.add(cuartetoIf);

                cuartetoGoto = new Cuarteto();
                cuartetoGoto.setOperador("GOTO");
                cuartetoGoto.setResultado(etiquetaInstruccion.get(i));
                lista.add(cuartetoGoto);

                boolean bandera;
                try {
                    etiquetaInicio.get(i + 1);
                    bandera = true;
                } catch (Exception e) {
                    bandera = false;
                }

                if (bandera) {
                    cuartetoGoto = new Cuarteto();
                    cuartetoGoto.setOperador("GOTO");
                    cuartetoGoto.setResultado(etiquetaInicio.get(i + 1));
                    lista.add(cuartetoGoto);
                } else {
                    cuartetoGoto = new Cuarteto();
                    cuartetoGoto.setOperador("GOTO");
                    cuartetoGoto.setResultado(etiquetaSalida);
                    lista.add(cuartetoGoto);
                }

                cuartetoEtiqueta = new Cuarteto();
                cuartetoEtiqueta.setOperador("ET");
                cuartetoEtiqueta.setResultado(etiquetaInstruccion.get(i));
                lista.add(cuartetoEtiqueta);
                aux = new ArrayList<>();
                for (int j = 0; j < this.elsif.get(i).getInstructions().size(); j++) {
                    Cuarteto.unirCuartetos(aux, this.elsif.get(i).getInstructions().get(j).execute());
                }
                Cuarteto.unirCuartetos(lista, aux);

                cuartetoGoto = new Cuarteto();
                cuartetoGoto.setOperador("GOTO");
                cuartetoGoto.setResultado(etiquetaSalida);
                lista.add(cuartetoGoto);

            }

            cuartetoEtiqueta = new Cuarteto();
            cuartetoEtiqueta.setOperador("ET");
            cuartetoEtiqueta.setResultado(etiquetaSalida);
            lista.add(cuartetoEtiqueta);

            return lista;

        } else if (elsif == null && sino != null) {

            List<Cuarteto> lista = new ArrayList<>(), listaCondicion = new ArrayList<>(), aux = new ArrayList<>();
            listaCondicion = baseIf.getCondicion().execute();
            Cuarteto.unirCuartetos(lista, listaCondicion);
            String etiquetaInstrucciones = Etiquetas.siguienteEtiqueta();
            String etiquetaElse = Etiquetas.siguienteEtiqueta();
            String etiquetaSalida = Etiquetas.siguienteEtiqueta();
            String temporalCondicion = logica.returnUltimoTemporalCondicion(listaCondicion);
            Cuarteto cuartetoEtiqueta, cuartetoIf, cuartetoGoto;

            cuartetoIf = new Cuarteto();
            cuartetoIf.setOperador("IF");
            cuartetoIf.setResultado(temporalCondicion);
            lista.add(cuartetoIf);

            cuartetoGoto = new Cuarteto();
            cuartetoGoto.setOperador("GOTO");
            cuartetoGoto.setResultado(etiquetaInstrucciones);
            lista.add(cuartetoGoto);

            cuartetoGoto = new Cuarteto();
            cuartetoGoto.setOperador("GOTO");
            cuartetoGoto.setResultado(etiquetaElse);
            lista.add(cuartetoGoto);

            cuartetoEtiqueta = new Cuarteto();
            cuartetoEtiqueta.setOperador("ET");
            cuartetoEtiqueta.setResultado(etiquetaInstrucciones);
            lista.add(cuartetoEtiqueta);
            aux = new ArrayList<>();
            for (int i = 0; i < this.baseIf.getInstructions().size(); i++) {
                Cuarteto.unirCuartetos(aux, this.baseIf.getInstructions().get(i).execute());
            }
            Cuarteto.unirCuartetos(lista, aux);
            cuartetoGoto = new Cuarteto();
            cuartetoGoto.setOperador("GOTO");
            cuartetoGoto.setResultado(etiquetaSalida);
            lista.add(cuartetoGoto);

            cuartetoEtiqueta = new Cuarteto();
            cuartetoEtiqueta.setOperador("ET");
            cuartetoEtiqueta.setResultado(etiquetaElse);
            lista.add(cuartetoEtiqueta);
            aux = new ArrayList<>();
            for (int i = 0; i < this.sino.getInstructions().size(); i++) {
                Cuarteto.unirCuartetos(aux, this.sino.getInstructions().get(i).execute());
            }
            Cuarteto.unirCuartetos(lista, aux);
            cuartetoGoto = new Cuarteto();
            cuartetoGoto.setOperador("GOTO");
            cuartetoGoto.setResultado(etiquetaSalida);
            lista.add(cuartetoGoto);

            cuartetoEtiqueta = new Cuarteto();
            cuartetoEtiqueta.setOperador("ET");
            cuartetoEtiqueta.setResultado(etiquetaSalida);
            lista.add(cuartetoEtiqueta);

            return lista;

        } else {

            List<Cuarteto> lista = new ArrayList<>(), listaCondicion = new ArrayList<>(), aux = new ArrayList<>();
            listaCondicion = baseIf.getCondicion().execute();
            Cuarteto.unirCuartetos(lista, listaCondicion);

            List<String> etiquetaInicio = new ArrayList<>();
            List<String> etiquetaInstruccion = new ArrayList<>();

            String etiquetaIf = Etiquetas.siguienteEtiqueta();
            String etiquetaSalida = Etiquetas.siguienteEtiqueta();

            for (int i = 0; i < this.elsif.size(); i++) {
                etiquetaInicio.add(Etiquetas.siguienteEtiqueta());
                etiquetaInstruccion.add(Etiquetas.siguienteEtiqueta());
            }

            String etiquetaElse = Etiquetas.siguienteEtiqueta();

            String temporalCondicion = logica.returnUltimoTemporalCondicion(listaCondicion);
            Cuarteto cuartetoEtiqueta, cuartetoIf, cuartetoGoto;

            cuartetoIf = new Cuarteto();
            cuartetoIf.setOperador("IF");
            cuartetoIf.setResultado(temporalCondicion);
            lista.add(cuartetoIf);

            cuartetoGoto = new Cuarteto();
            cuartetoGoto.setOperador("GOTO");
            cuartetoGoto.setResultado(etiquetaIf);
            lista.add(cuartetoGoto);

            cuartetoGoto = new Cuarteto();
            cuartetoGoto.setOperador("GOTO");
            cuartetoGoto.setResultado(etiquetaInicio.get(0));
            lista.add(cuartetoGoto);

            cuartetoEtiqueta = new Cuarteto();
            cuartetoEtiqueta.setOperador("ET");
            cuartetoEtiqueta.setResultado(etiquetaIf);
            lista.add(cuartetoEtiqueta);
            aux = new ArrayList<>();
            for (int i = 0; i < this.baseIf.getInstructions().size(); i++) {
                Cuarteto.unirCuartetos(aux, this.baseIf.getInstructions().get(i).execute());
            }
            Cuarteto.unirCuartetos(lista, aux);

            cuartetoGoto = new Cuarteto();
            cuartetoGoto.setOperador("GOTO");
            cuartetoGoto.setResultado(etiquetaSalida);
            lista.add(cuartetoGoto);

            for (int i = 0; i < etiquetaInicio.size(); i++) {
                cuartetoEtiqueta = new Cuarteto();
                cuartetoEtiqueta.setOperador("ET");
                cuartetoEtiqueta.setResultado(etiquetaInicio.get(i));
                lista.add(cuartetoEtiqueta);

                listaCondicion = this.elsif.get(i).getCondicion().execute();
                Cuarteto.unirCuartetos(lista, listaCondicion);
                temporalCondicion = logica.returnUltimoTemporalCondicion(listaCondicion);

                cuartetoIf = new Cuarteto();
                cuartetoIf.setOperador("IF");
                cuartetoIf.setResultado(temporalCondicion);
                lista.add(cuartetoIf);

                cuartetoGoto = new Cuarteto();
                cuartetoGoto.setOperador("GOTO");
                cuartetoGoto.setResultado(etiquetaInstruccion.get(i));
                lista.add(cuartetoGoto);

                boolean bandera;
                try {
                    etiquetaInicio.get(i + 1);
                    bandera = true;
                } catch (Exception e) {
                    bandera = false;
                }

                if (bandera) {
                    cuartetoGoto = new Cuarteto();
                    cuartetoGoto.setOperador("GOTO");
                    cuartetoGoto.setResultado(etiquetaInicio.get(i + 1));
                    lista.add(cuartetoGoto);
                } else {
                    cuartetoGoto = new Cuarteto();
                    cuartetoGoto.setOperador("GOTO");
                    cuartetoGoto.setResultado(etiquetaElse);
                    lista.add(cuartetoGoto);
                }

                cuartetoEtiqueta = new Cuarteto();
                cuartetoEtiqueta.setOperador("ET");
                cuartetoEtiqueta.setResultado(etiquetaInstruccion.get(i));
                lista.add(cuartetoEtiqueta);
                aux = new ArrayList<>();
                for (int j = 0; j < this.elsif.get(i).getInstructions().size(); j++) {
                    Cuarteto.unirCuartetos(aux, this.elsif.get(i).getInstructions().get(j).execute());
                }
                Cuarteto.unirCuartetos(lista, aux);

                cuartetoGoto = new Cuarteto();
                cuartetoGoto.setOperador("GOTO");
                cuartetoGoto.setResultado(etiquetaSalida);
                lista.add(cuartetoGoto);

            }

            cuartetoEtiqueta = new Cuarteto();
            cuartetoEtiqueta.setOperador("ET");
            cuartetoEtiqueta.setResultado(etiquetaElse);
            lista.add(cuartetoEtiqueta);
            aux = new ArrayList<>();
            for (int j = 0; j < this.sino.getInstructions().size(); j++) {
                Cuarteto.unirCuartetos(aux, this.sino.getInstructions().get(j).execute());
            }
            Cuarteto.unirCuartetos(lista, aux);

            cuartetoGoto = new Cuarteto();
            cuartetoGoto.setOperador("GOTO");
            cuartetoGoto.setResultado(etiquetaSalida);
            lista.add(cuartetoGoto);

            cuartetoEtiqueta = new Cuarteto();
            cuartetoEtiqueta.setOperador("ET");
            cuartetoEtiqueta.setResultado(etiquetaSalida);
            lista.add(cuartetoEtiqueta);

            return lista;

        }
    }

    @Override
    public boolean asignarReturn(String tipo,String tSalida) {
        boolean banderaif=false,banderaelsif=false,banderaelse=false,banderaAux;
        banderaif = baseIf.asignarReturn(tipo,tSalida);
        if(elsif!=null){
            for (int i = 0; i < elsif.size(); i++) {
                banderaAux = elsif.get(i).asignarReturn(tipo,tSalida);
                if(!banderaelsif && banderaAux){
                    banderaelsif = true;
                }
            }
        }
        
        if(sino!=null){
            banderaelse = sino.asignarReturn(tipo,tSalida);
        }
        
        if(banderaif || banderaelse || banderaelsif){
            return true;
        }else{
            return false;
        }
        
    }

    
    
    
}
