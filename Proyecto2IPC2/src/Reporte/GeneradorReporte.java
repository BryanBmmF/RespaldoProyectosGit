/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reporte;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JDialog;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author bryan
 */
public class GeneradorReporte {
        private static JDialog dialogo;

        public GeneradorReporte(JDialog dialogo) {
            this.dialogo = dialogo;
        }
        
        public static void generarReporte(String nombreReporte,List<?> lista, Double total){
                String reporte= "src/Reporte/"+nombreReporte+".jasper";
                try {
                        JRPdfExporter exp = new JRPdfExporter();
                        SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
                        //se agrega un parametro
                        Map parametro = new HashMap();
                        parametro.put("Parameter1", total);
                        JasperPrint jasperPrint2 = JasperFillManager.fillReport(reporte, parametro,
                                       new JRBeanCollectionDataSource(lista));
			//se exporta el archivo
			exp.setExporterInput(new SimpleExporterInput(jasperPrint2));
			exp.setExporterOutput(new SimpleOutputStreamExporterOutput("/home/bryan/"+nombreReporte+".pdf"));
			exp.setConfiguration(conf);
			exp.exportReport();
                        
                        dialogo.dispose();
                        //se muestra en ventana aparte
			JasperViewer jasperViewer = new JasperViewer(jasperPrint2, false);
                        
			jasperViewer.setVisible(true);
                        jasperViewer.setTitle("Reporte Factura");
                        
                        
                } catch (Exception e) {
			System.out.println("error");
			e.printStackTrace(System.out);
		}
        }
        
        public static void generarReporteEmpleados(String nombreReporte,List<?> lista, String Estab){
                String reporte= "src/Reporte/"+nombreReporte+".jasper";
                try {
                        JRPdfExporter exp = new JRPdfExporter();
                        SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
                        //se agrega un parametro
                        Map parametro = new HashMap();
                        parametro.put("Parameter1", Estab);
                        JasperPrint jasperPrint2 = JasperFillManager.fillReport(reporte, parametro,
                                       new JRBeanCollectionDataSource(lista));
			//se exporta el archivo
			exp.setExporterInput(new SimpleExporterInput(jasperPrint2));
			exp.setExporterOutput(new SimpleOutputStreamExporterOutput("/home/bryan/"+nombreReporte+".pdf"));
			exp.setConfiguration(conf);
			exp.exportReport();
                        
                        dialogo.dispose();
                        //se muestra en ventana aparte
			JasperViewer jasperViewer = new JasperViewer(jasperPrint2, false);
                        
			jasperViewer.setVisible(true);
                        jasperViewer.setTitle("Reporte Empleados");
                        
                        
                } catch (Exception e) {
			System.out.println("error");
			e.printStackTrace(System.out);
		}
        }
    
}
