/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text_editor;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;

/**
 *
 * @author Sathitha
 */
public class MainGUI extends javax.swing.JFrame implements API {

    /**
     * Creates new form MainGUI
     */
    int startOffset;
    int endOffset;
    ShortKeys skeys = null;
    String input;

    public MainGUI() throws IOException {
        initComponents();
        Search.setVisible(false);
        Date.setVisible(false);
        skeys = new ShortKeys();


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        Date = new javax.swing.JButton();
        Search = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jButton1.setText("Load");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextArea1MouseClicked(evt);
            }
        });
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        jButton3.setText("Plugins");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        Date.setText("Date");
        Date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DateActionPerformed(evt);
            }
        });

        Search.setText("Find");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addGap(40, 40, 40)
                        .addComponent(Date)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Search)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(Date)
                    .addComponent(Search))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        LoadAvailablePlugins lp = new LoadAvailablePlugins();
        lp.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String file_name = f.getAbsolutePath();

        try {
            FileReader fr = new FileReader(file_name);
            BufferedReader br = new BufferedReader(fr);
            jTextArea1.read(br, null);
            br.close();
            jTextArea1.requestFocus();
            EmojiLoader();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        FileSave fs = new FileSave();
        fs.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void DateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DateActionPerformed
        // TODO add your handling code here:
        DatePlugin n = new DatePlugin();
        n.proceed(this);
    }//GEN-LAST:event_DateActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        // TODO add your handling code here:
        FIND();
    }//GEN-LAST:event_SearchActionPerformed

    private void jTextArea1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyPressed
        EmojiLoader();
    }//GEN-LAST:event_jTextArea1KeyPressed

    private void jTextArea1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextArea1MouseClicked
        // TODO add your handling code here:
        int viewToModel = jTextArea1.viewToModel(evt.getPoint());
        if (viewToModel != -1) {
            try {

                int caretOffset = jTextArea1.getCaretPosition();
                int lineNumber;
                try {
                    lineNumber = jTextArea1.getLineOfOffset(caretOffset);
                    startOffset = jTextArea1.getLineStartOffset(lineNumber);
                    endOffset = jTextArea1.getLineEndOffset(lineNumber);

                    //jTextArea1.replaceRange("Replaced Text", startOffset, endOffset);
                } catch (BadLocationException ex) {
                    Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }

        Action actionAddDoubleSlash = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String str = jTextArea1.getText().substring(startOffset, endOffset);
                skeys.actionAddDoubleSlash(str, startOffset, endOffset);
            }
        };

        Action actionRemoveDoubleSlash = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = jTextArea1.getText().substring(startOffset, endOffset);
                skeys.actionRemoveDoubleSlash(str, startOffset, endOffset);

            }
        };

        Action actionAddWhiteSPace = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String str = jTextArea1.getText().substring(startOffset, endOffset);
                skeys.actionAddWhiteSPace(str, startOffset, endOffset);
            }
        };

        Action actionRemoveWhiteSPace = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = jTextArea1.getText().substring(startOffset, endOffset);
                skeys.actionRemoveWhiteSPace(str, startOffset, endOffset);

            }
        };

        Action actionAddTODO = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = jTextArea1.getText().substring(startOffset, endOffset);
                int currentCaretPosition = jTextArea1.getCaretPosition();
                skeys.actionAddTODO(str, currentCaretPosition, startOffset, endOffset);

            }
        };

        Action actionRemoveTODO = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = jTextArea1.getText().substring(startOffset, endOffset);
                int currentCaretPosition = jTextArea1.getCaretPosition();
                skeys.actionRemoveTODO(str, currentCaretPosition, startOffset, endOffset);

            }
        };

        Action actionAddFIXME = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = jTextArea1.getText().substring(startOffset, endOffset);
                int currentCaretPosition = jTextArea1.getCaretPosition();
                skeys.actionAddFIXME(str, currentCaretPosition, startOffset, endOffset);

            }
        };

        Action actionRemoveFIXME = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = jTextArea1.getText().substring(startOffset, endOffset);
                int currentCaretPosition = jTextArea1.getCaretPosition();
                skeys.actionRemoveFIXME(str, currentCaretPosition, startOffset, endOffset);

            }
        };

        String keyStrokeAndKey = "control D";
        KeyStroke keyStroke = KeyStroke.getKeyStroke(keyStrokeAndKey);
        jTextArea1.getInputMap().put(keyStroke, keyStrokeAndKey);
        jTextArea1.getActionMap().put(keyStrokeAndKey, actionAddDoubleSlash);

        String keyStrokeAndKey2 = "control shift D";
        KeyStroke keyStroke2 = KeyStroke.getKeyStroke(keyStrokeAndKey2);
        jTextArea1.getInputMap().put(keyStroke2, keyStrokeAndKey2);
        jTextArea1.getActionMap().put(keyStrokeAndKey2, actionRemoveDoubleSlash);

        String keyStrokeAndKey3 = "control I";
        KeyStroke keyStroke3 = KeyStroke.getKeyStroke(keyStrokeAndKey3);
        jTextArea1.getInputMap().put(keyStroke3, keyStrokeAndKey3);
        jTextArea1.getActionMap().put(keyStrokeAndKey3, actionAddWhiteSPace);

        String keyStrokeAndKey4 = "control shift I";
        KeyStroke keyStroke4 = KeyStroke.getKeyStroke(keyStrokeAndKey4);
        jTextArea1.getInputMap().put(keyStroke4, keyStrokeAndKey4);
        jTextArea1.getActionMap().put(keyStrokeAndKey4, actionRemoveWhiteSPace);

        String keyStrokeAndKey5 = "alt T";
        KeyStroke keyStroke5 = KeyStroke.getKeyStroke(keyStrokeAndKey5);
        jTextArea1.getInputMap().put(keyStroke5, keyStrokeAndKey5);
        jTextArea1.getActionMap().put(keyStrokeAndKey5, actionAddTODO);

        String keyStrokeAndKey6 = "alt S";
        KeyStroke keyStroke6 = KeyStroke.getKeyStroke(keyStrokeAndKey6);
        jTextArea1.getInputMap().put(keyStroke6, keyStrokeAndKey6);
        jTextArea1.getActionMap().put(keyStrokeAndKey6, actionRemoveTODO);

        String keyStrokeAndKey7 = "alt F";
        KeyStroke keyStroke7 = KeyStroke.getKeyStroke(keyStrokeAndKey7);
        jTextArea1.getInputMap().put(keyStroke7, keyStrokeAndKey7);
        jTextArea1.getActionMap().put(keyStrokeAndKey7, actionAddFIXME);

        String keyStrokeAndKey8 = "alt G";
        KeyStroke keyStroke8 = KeyStroke.getKeyStroke(keyStrokeAndKey8);
        jTextArea1.getInputMap().put(keyStroke8, keyStrokeAndKey8);
        jTextArea1.getActionMap().put(keyStrokeAndKey8, actionRemoveFIXME);

        //Function keys
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
        jTextArea1.getInputMap().put(keyStrokef2, f2);
        jTextArea1.getActionMap().put(f2, F2);

        Action F3 = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FIND();
            }
        };

        String f3 = "F3";
        KeyStroke keyStrokef3 = KeyStroke.getKeyStroke(f3);
        jTextArea1.getInputMap().put(keyStrokef3, f3);
        jTextArea1.getActionMap().put(f3, F3);

        Action F4 = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("F4 pressed");
                JOptionPane.showMessageDialog(jTextArea1, "F4 key pressed");
            }
        };

        String f4 = "F4";
        KeyStroke keyStrokef4 = KeyStroke.getKeyStroke(f4);
        jTextArea1.getInputMap().put(keyStrokef4, f4);
        jTextArea1.getActionMap().put(f4, F4);
    }//GEN-LAST:event_jTextArea1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainGUI().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton Date;
    public static javax.swing.JButton Search;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void registerDatePlugin(String value) {

        try {
            String str = jTextArea1.getText().substring(startOffset, endOffset);
            int currentCaretPosition = jTextArea1.getCaretPosition();
            str = str.substring(0, currentCaretPosition - startOffset) + value + str.substring(currentCaretPosition - startOffset);
            jTextArea1.replaceRange(str, startOffset, endOffset);
        } catch (Exception e) {
        }

    }

    @Override
    public void registerSearchPlugin() {

        try {

            Document doc = jTextArea1.getDocument();
            String pattern = input;
            String text_value = doc.getText(0, doc.getLength());
            int x = 0;

            jTextArea1.setText(jTextArea1.getText());

            while ((x = text_value.toUpperCase().indexOf(pattern.toUpperCase(), x)) >= 0) {
                try {
                    jTextArea1.getHighlighter().addHighlight(x, x + pattern.length(),
                            new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW));
                } catch (BadLocationException e) {
                    e.printStackTrace();
                }
                x += pattern.length();
            }
        } catch (Exception e) {
        }
    }

    private void EmojiLoader() {
        String filePath = "src\\main\\java\\text_editor\\script.py";

        try {

            Document doc = jTextArea1.getDocument();
            String patterns[] = {":-)", ":D", ":)", ":p"};
            String text_value = doc.getText(0, doc.getLength());
            int x = 0;

            for (String pattern : patterns) {
                while ((x = text_value.toUpperCase().indexOf(pattern.toUpperCase(), x)) >= 0) {
                    ProcessBuilder pb = new ProcessBuilder().command("python", "-u", filePath, "emoji", pattern);
                    Process p;
                    try {
                        p = pb.start();
                        BufferedReader in = new BufferedReader(
                                new InputStreamReader(p.getInputStream()));
                        StringBuilder buffer = new StringBuilder();
                        String line = null;
                        while ((line = in.readLine()) != null) {
                            buffer.append(line);
                        }
                        String emojistring = buffer.toString();
                        emojistring = "\\" + emojistring;
                        String str = emojistring.split(" ")[0];
                        str = str.replace("\\", "");
                        String[] arr = str.split("u");
                        String text = "";
                        for (int i = 1; i < arr.length; i++) {
                            int hexVal = Integer.parseInt(arr[i], 16);
                            text += (char) hexVal;
                        }
                        
                        jTextArea1.replaceRange(text, x, x + pattern.length());
                        in.close();
                    } catch (IOException ex) {
                        Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    x += pattern.length();
                }
            }

        } catch (Exception e) {
        }
    }
    
    public void FIND(){
        FindPluging sp = new FindPluging();
        try {
            input = JOptionPane.showInputDialog("Search Keyword");
            if (!input.isEmpty()) {
                sp.proceed(this);
            }
        } catch (Exception e) {
        }
    }

}
