/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.escapetrain.datahandling;

import java.util.Properties;
import java.util.prefs.Preferences;

/**
 * This class handles reading and writing to file when game is won
 * @author Varjokorento
 */
public class DataClient {
    
    private Properties appProps;
    private Preferences prefs;

    public DataClient() {
        this.appProps = new Properties();
    }
    
    /**
     * This method initialises the class. It creates the file to users
     * preferences and sets the Victories column.
     */
    
    public void init() {
        this.prefs = Preferences.userNodeForPackage(DataClient.class);
        prefs.getInt("VICTORIES", 0); 
    }
    /**
     * Method adds one victory to the file. The getInt returns 0 if there
     * is no earlier value stored.
     */
    public void addVictory() {
        int victories = prefs.getInt("VICTORIES", 0);
        victories = victories + 1;
        prefs.put("VICTORIES", String.valueOf(victories));
    }
    
    /**
     * Method returns total amount of victories
     * @return int  total amount of victories for the player's user account
     */
    
    public int getVictories() {
        return (prefs.getInt("VICTORIES", 0));
    }
    
    /**
     * Method deletes one victory from file.
     * Used in testing.
     */
    
    public void deleteVictory() {
        int victories = prefs.getInt("VICTORIES", 0);
        victories = victories - 1;
        prefs.put("VICTORIES", String.valueOf(victories)); 
    }
    
}
