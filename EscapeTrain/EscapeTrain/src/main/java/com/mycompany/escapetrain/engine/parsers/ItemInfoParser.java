/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.escapetrain.engine.parsers;

import com.mycompany.escapetrain.engine.gamestateutils.GameState;
import com.mycompany.escapetrain.gameobjects.GameObject;
import com.mycompany.escapetrain.gameobjects.events.Event;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Administrator
 */
public class ItemInfoParser {
    
    private Properties appProps;

    public ItemInfoParser() {
        this.appProps = new Properties();
    }
    
    public void init() throws FileNotFoundException, IOException {
        InputStream input = ItemInfoParser.class.getClassLoader().getResourceAsStream("item.properties");
        appProps.load(input);
    }
    
    public GameObject parseItemInfo(String target, GameState gameState) {
        if (gameState.isInInventory(target)) {
            String message = appProps.getProperty(target);
            return new Event(message);
        }
        return new Event("What are you looking at? There's no " + target + " here");
        
    }
    
    
}
