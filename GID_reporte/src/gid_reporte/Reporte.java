package gid_reporte;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Reporte {

    public Reporte() {

        try {
//          JasperReport  reporte =  (JasperReport) getClass().getClassLoader().getResources("/gid_reporte/ReporteOky.jasper");
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile ( "C:/Documents and Settings/Administrador/Mis documentos/NetBeansProjects/GID_reporte/src/gid_reporte/ReporteOky.jasper");
            Map parametros = new HashMap();
            GID_reporte clase = new GID_reporte();
            InetAddress direccion = InetAddress.getLocalHost();
            
            clase.setNombreOS(System.getProperty("os.name"));
            clase.setNombrePC(System.getenv("COMPUTERNAME"));
            clase.setNombreUser(System.getProperty("user.name"));
            clase.setArchPc(System.getProperty("os.arch"));
            clase.setIp(direccion.getHostAddress());
            clase.setJavaVersion(System.getProperty("java.version"));
            clase.setSeparadorFicheros(System.getProperty("file.separator"));
            clase.setProcesador(System.getenv("PROCESSOR_IDENTIFIER"));

            parametros.put("nombreOS", clase.getNombreOS());
            parametros.put("nombrePC", clase.getNombrePC());
            parametros.put("nombreUser", clase.getNombreUser());
            parametros.put("archPc", clase.getArchPc());
            parametros.put("procesador", clase.getProcesador());
            parametros.put("separadorFicheros", clase.getSeparadorFicheros());
            parametros.put("javaVersion", clase.getJavaVersion());
            parametros.put("ip", clase.getIp());


            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros, new JREmptyDataSource());

            JasperViewer view = new JasperViewer(jasperPrint);
            view.setTitle("Reporte Informativo");
            view.setVisible(true);



        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo crear el reporte!!" + "\n" + e);
            System.out.println("Error referencia no:"+e);
        }
    }
}
