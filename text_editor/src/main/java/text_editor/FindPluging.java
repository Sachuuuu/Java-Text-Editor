/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text_editor;

/**
 *
 * @author Sathitha
 */
public class FindPluging implements Plugins{

    @Override
    public void proceed(API api) {
        api.registerSearchPlugin();
    }
    
}
