/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;

/**
 *
 * @author Adrián
 */
public class ControlVentanas {
    
    public void enableButton(JButton boton) {
        boton.setEnabled(true);
        //boton.setBackground(new Color(255, 204, 51));
    }
    
        public void disableButton(JButton boton) {
        boton.setEnabled(false);
        //boton.setBackground(new Color(204, 204, 204));
    }
        
    public void disableConnectionPanel(JButton boton, JComboBox combo,JComboBox combo1) {
        combo.setEnabled(false);
        combo1.setEnabled(false);
        boton.setEnabled(false);
    }
    
    public void enableConnectionPanel(JButton boton, JComboBox combo, JComboBox combo1) {
        combo.setEnabled(true);
        combo1.setEnabled(true);
        boton.setEnabled(true);
    }   
    
}
