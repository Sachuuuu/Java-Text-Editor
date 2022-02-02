/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text_editor;

import static text_editor.MainGUI.jTextArea1;

/**
 *
 * @author Sathitha
 */
public class ShortKeys {

    public ShortKeys() {
    }

    public void actionAddDoubleSlash(String str, int start, int end) {
        System.out.println("Double slash key invoked");
        str = "//" + str;
        jTextArea1.replaceRange(str, start, end);
    }

    public void actionRemoveDoubleSlash(String str, int start, int end) {
        System.out.println("Double slash remove key invoked");
        if (str.indexOf("//") == 0) {
            jTextArea1.replaceRange(str.replace("//", ""), start, end);
        }
    }

    public void actionAddWhiteSPace(String str, int start, int end) {
        System.out.println("White space key invoked");
        str = "\t" + str;
        jTextArea1.replaceRange(str, start, end);
    }

    public void actionRemoveWhiteSPace(String str, int start, int end) {
        System.out.println("White space remove key invoked");
        if (str.indexOf("\t") == 0) {
            jTextArea1.replaceRange(str.replace("\t", ""), start, end);
        }
    }

    public void actionAddTODO(String str, int position, int start, int end) {
         System.out.println("TODO key invoked");
        try {
            str = str.substring(0, position - start) + "/*TODO*/" + str.substring(position - start);
            jTextArea1.replaceRange(str, start, end);
        } catch (Exception e) {
        }

    }

    public void actionRemoveTODO(String str, int position, int start, int end) {
        System.out.println("TODO remove key invoked");
        int leng = "/*TODO*/".length();
        if (str.substring(position - start, position - start + leng).equals("/*TODO*/")) {
            try {
                str = str.substring(0, position - start) + str.substring(position - start + leng);
                jTextArea1.replaceRange(str, start, end);
            } catch (Exception e) {
            }

        }
    }

    public void actionAddFIXME(String str, int position, int start, int end) {
        System.out.println("FIXME key invoked");
        try {
            str = str.substring(0, position - start) + "/*FIXME*/" + str.substring(position - start);
            jTextArea1.replaceRange(str, start, end);
        } catch (Exception e) {
        }

    }

    public void actionRemoveFIXME(String str, int position, int start, int end) {
        System.out.println("FIXME remove key invoked");
        int leng = "/*FIXME*/".length();

        if (str.substring(position - start, position - start + leng).equals("/*FIXME*/")) {

            try {
                str = str.substring(0, position - start) + str.substring(position - start + leng);
                jTextArea1.replaceRange(str, start, end);
            } catch (Exception e) {
            }

        }
    }

}
