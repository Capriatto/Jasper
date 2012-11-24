/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gid_reporte;
import com.jtattoo.plaf.graphite.GraphiteLookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.apache.log4j.BasicConfigurator;
/**
 *
 * @author Administrador
 */
public class Play {
    public static void main(String[] args) {
        BasicConfigurator.configure();
        try {
            UIManager.setLookAndFeel(new GraphiteLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
        }
               MainFrame frame= new MainFrame();
        frame.setVisible(true);
    }
}
