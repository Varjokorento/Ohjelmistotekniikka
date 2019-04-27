/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.escapetrain.dataHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.prefs.Preferences;

/**
 *
 * @author Administrator
 */
public class DataClient {
    
    private Properties appProps;
    private Preferences prefs;

    public DataClient() {
       this.appProps = new Properties();
    }
    
    public void init() {
        this.prefs = Preferences.userNodeForPackage(DataClient.class);
        prefs.getInt("VICTORIES", 0);
        
    }
    public void addVictory() {
        int victories = prefs.getInt("VICTORIES", 0);
        victories = victories +1;
        prefs.put("VICTORIES", String.valueOf(victories));
    }
    
    public int getVictories() {
        return (prefs.getInt("VICTORIES", 0));
    }
    
    public void deleteVictory() {
        int victories = prefs.getInt("VICTORIES", 0);
        victories = victories +-1;
        prefs.put("VICTORIES", String.valueOf(victories)); 
    }
    
}
