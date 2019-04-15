/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.escapetrain.engine.parsers;

import com.mycompany.escapetrain.engine.gamestateutils.GameState;
import com.mycompany.escapetrain.gameobjects.GameObject;

import com.mycompany.escapetrain.gameobjects.events.Event;

/**
 *
 * @author Administrator
 */
public class EventHandler {

    public GameObject handleUsageEvent(String target, GameState gameState) {
        if (gameState.isIsTutorial()) {
            return handleTutorialEvent(target, gameState);
        }
        
        if (target.equalsIgnoreCase("lever") 
                && gameState.getCurrentArea().getAreaName().equals("ENGINE_ROOM")) {
            gameState.getFlags().setGameWon(true);
            return  new Event("You managed to stop the train! You have survived!");
        }    
        if (!gameState.isInInventory(target)) {          
            return new Event("You don't have that on you!");
        }
        if (target.equalsIgnoreCase("pillow")) {
            gameState.getFlags().setEngineDoorOpen(true);
            return new Event("Something opened somewhere.");
        }
        return new Event("Nothing happens.");
    }
    
    private GameObject handleTutorialEvent(String target, GameState gameState) {
        if (target.equalsIgnoreCase("lever") && gameState.getCurrentArea().getAreaName().equals("NEXT_ROOM")) {
            return new Event("You have managed to finish the tutorial! Now press back button and start the game!");
        } else {
            return new Event("Absolutely nothing happens");
        }
    }
    
}
