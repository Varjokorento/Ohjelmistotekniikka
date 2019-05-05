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
 * @author Varjokorento
 */
public class ItemInfoParser {
    
    private Properties appProps;

    public ItemInfoParser() {
        this.appProps = new Properties();
    }
    
    /**
     * Initialises the item.properties files
     * @throws FileNotFoundException    If file is not found this is thrown
     * @throws IOException  general exception for failed or interrupted I/O operation
     */
    
    public void init() throws FileNotFoundException, IOException {
        InputStream input = ItemInfoParser.class.getClassLoader().getResourceAsStream("item.properties");
        appProps.load(input);
    }
    /**
     * Parse the item info event
     * @param target    Item that is being used
     * @param gameState The current game state
     * @return GameObject   The item information or an default message if no such item in inventory
     */
    public GameObject parseItemInfo(String target, GameState gameState) {
        if (gameState.isInInventory(target)) {
            String message = appProps.getProperty(target);
            return new Event(message);
        }
        return new Event("What are you looking at? You don't have a " + target);
        
    }
    
    
}
