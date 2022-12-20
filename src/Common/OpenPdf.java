/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common;

import javax.swing.JOptionPane;
import java.io.File;

/**
 *
 * @author kshit
 */
public class OpenPdf {

    public static void openById(String id) {
        try {
            if ((new File("E:\\Cafe" + id + ".pdf")).exists()) {
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler E:\\Cafe" + id + ".pdf");
            }
            else{
                JOptionPane.showMessageDialog(null, "File is not Exits!!");
            }
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
