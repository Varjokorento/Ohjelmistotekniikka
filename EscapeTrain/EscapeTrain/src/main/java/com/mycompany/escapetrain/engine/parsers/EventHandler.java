/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.escapetrain.engine.parsers;

import com.mycompany.escapetrain.datahandling.DataService;
import com.mycompany.escapetrain.engine.gamestateutils.GameState;
import com.mycompany.escapetrain.gameobjects.GameObject;

import com.mycompany.escapetrain.gameobjects.events.Event;
import java.io.IOException;


/**
 * This handler returns event for USE ITEM events and other game events such as game over. 
 * @author Varjokorento
 */
public class EventHandler {
    private DataService dataService;

    public EventHandler() {
        this.dataService = new DataService();
    }
    
    public void init() throws IOException {
        this.dataService.init();
    }

    public void setDataService(DataService dataService) {
        this.dataService = dataService;
    }
    
    
    /**
     * This method returns event based on the current GameState and the target.
     * @param target    The item that is being used
     * @param gameState The current game state
     * @return GameObject   The outcome of the item usage that is displayed
     */

    public GameObject handleUsageEvent(String target, GameState gameState) {
        if (gameState.isIsTutorial()) {
            return handleTutorialEvent(target, gameState);
        }
        if (target.equalsIgnoreCase("lever") 
                && gameState.getCurrentArea().getAreaName().equals("ENGINE_ROOM")) {
            return gameWonEvent(gameState); 
        }    
        
        return handleItemEvent(target, gameState);
        
    }
    
    private GameObject gameWonEvent(GameState gameState) {
        gameState.getFlags().setGameWon(true);
        Integer totalVictories = 1;
        dataService.addAVictory();
        totalVictories = dataService.getVictories();
        String victoryMessage = "You managed to stop the train! You have survived! You have won the game " + totalVictories + " times!";
        return  new Event(victoryMessage);
    }
    
    /**
     * This returns gameHasEndedEvent and is called when game has either been won or lost
     * @return GameObject   The event that is displayed to the player
     */
    
    public GameObject gamehasEndedEvent() {
        return new Event("The game is now over. Please quit by clicking X.");
    }
    
    /**
     * This method returns event when the game has been lost
     * @return GameObject   The event that is displayed to the user
     */
    
    public GameObject gameOverEvent() {
        return new Event("The train drives down a broken bridge. You crash down with it and die. Game over. You lost. Press X to quit. Thank you for playing!");
    }
    
    private GameObject handleItemEvent(String target, GameState gameState) { 
        if (!gameState.isInInventory(target)) {          
            return new Event("You don't have that on you!");
        }       
        if (target.equalsIgnoreCase("dynamite") && gameState.getCurrentArea().getAreaName().equals("STAFF_QUARTERS")) {
            return this.useDynamite(gameState);
        }       
        if (target.equals("matches")) {
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
    
    /**
     * This returns invalid command event
     * @return Event    Returns the event that is displayed in the case of invalid command
     */
    
    public GameObject handleInvalidGoToCommand() {
        return new Event("Can't go there.");
    }
    
}
