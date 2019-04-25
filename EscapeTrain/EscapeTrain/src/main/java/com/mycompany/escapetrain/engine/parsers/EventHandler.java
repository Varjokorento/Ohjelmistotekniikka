/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.escapetrain.engine.parsers;

import com.mycompany.escapetrain.engine.gamestateutils.GameState;
import com.mycompany.escapetrain.gameobjects.GameObject;

import com.mycompany.escapetrain.gameobjects.events.Event;
import java.util.HashSet;

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
        
        return handleItemEvent(target, gameState);
        
    }
    
    private GameObject handleItemEvent(String target, GameState gameState) {
        
        if (!gameState.isInInventory(target)) {          
            return new Event("You don't have that on you!");
        }
        
        if (target.equalsIgnoreCase("dynamite") && gameState.getCurrentArea().getAreaName().equals("STAFF_QUARTERS")) {
           return this.useDynamite(gameState);
        }       
        
        if(target.equals("matches")) {
            return this.useMatches(gameState);
        }
        if (target.equalsIgnoreCase("pillow")) {
            return this.usePillow(gameState);
        }
        return new Event("Nothing happens.");
    }
    
    private GameObject usePillow(GameState gameState) {
        gameState.getInventory().removeItem("pillow");
        gameState.getInventory().addItem("dynamite");
        return new Event("There was dynamite inside the pillow! What luck.");
    }
    
    private GameObject useMatches(GameState gameState) {
        if (gameState.getFlags().isDynamiteSet() == true && gameState.getCurrentArea().getAreaName().equals("STAFF_QUARTERS")) {
            gameState.getInventory().removeItem("matches");
            gameState.getFlagStates().setEngineDoorOpen(true);
            return new Event("You lit the dynamite. It blows up faster than you expect!");
        }
        return new Event("There's nothing to light");
    }
    
    private GameObject useDynamite(GameState gameState) {
        gameState.getInventory().removeItem("dynamite");
        gameState.getFlags().setDynamiteSet(true);
        return new Event("There is now dynamite on the door.");
    }
    
    private GameObject handleTutorialEvent(String target, GameState gameState) {
        if (target.equalsIgnoreCase("lever") && gameState.getCurrentArea().getAreaName().equals("NEXT_ROOM")) {
            return new Event("You have managed to finish the tutorial! Now press back button and start the game!");
        } else {
            return new Event("Absolutely nothing happens");
        }
    }
    
    public GameObject handleInvalidGoToCommand() {
        return new Event("Can't go there.");
    }
    
}
