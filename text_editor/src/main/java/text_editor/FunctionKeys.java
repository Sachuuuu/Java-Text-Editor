/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text_editor;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import static text_editor.MainGUI.jTextArea1;

/**
 *
 * @author Sathitha
 */
public class FunctionKeys {

    public FunctionKeys() {
    }
    
    public void functionKeyHandler(){
    
        Action F1 = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("F1 pressed");
                JOptionPane.showMessageDialog(jTextArea1, "F1 key pressed");
            }
        };
        
        String f1 = "F1";
        KeyStroke keyStrokef = KeyStroke.getKeyStroke(f1);
        jTextArea1.getInputMap().put(keyStrokef, f1);
        jTextArea1.getActionMap().put(f1, F1);
        
        Action F2 = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("F2 pressed");
                JOptionPane.showMessageDialog(jTextArea1, "F2 key pressed");
            }
        };
        
        String f2 = "F2";
        KeyStroke keyStrokef2 = KeyStroke.getKeyStroke(f2);
        jTextArea1.getInputMap().put(keyStrokef, f2);
        jTextArea1.getActionMap().put(f1, F2);
    }
}
