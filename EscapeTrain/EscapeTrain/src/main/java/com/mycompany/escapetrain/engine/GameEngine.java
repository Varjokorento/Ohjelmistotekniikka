/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.escapetrain.engine;

import com.mycompany.escapetrain.dataHandling.DataService;
import com.mycompany.escapetrain.gameobjects.GameObject;
import com.mycompany.escapetrain.engine.gamestateutils.GameState;
import com.mycompany.escapetrain.engine.parsers.CommandParser;
import com.mycompany.escapetrain.engine.parsers.AreaParser;
import com.mycompany.escapetrain.engine.parsers.EventHandler;
import com.mycompany.escapetrain.gameobjects.area.Area;
import com.mycompany.escapetrain.gameobjects.events.Event;
import com.mycompany.escapetrain.gameobjects.inventory.Inventory;
import com.mycompany.escapetrain.gameobjects.inventory.InventoryMessage;
import com.mycompany.escapetrain.gameobjects.inventory.Item;
import com.mycompany.escapetrain.gameobjects.message.Message;
import java.io.IOException;

/**
 * The engine of the game. 
 * All commands and events go from here 
 * and all events and object to the controller come from here.
 * @author Administrator
 */
public class GameEngine {
    
    private CommandParser commandParser;
    private AreaParser areaParser;
    private GameState gameState;
    private EventHandler eventHandler;
    
    public GameEngine() {
        this.commandParser = new CommandParser();
        this.areaParser = new AreaParser();
        this.gameState = new GameState();
        this.eventHandler = new EventHandler();
    }
    /**
     * Initializes areaparser and dataService that uses properties files
     * @throws IOException 
     */
    public void init() throws IOException {
        areaParser.init();
        eventHandler.init();
    }
    
    /**
     * Parses user commands and returns either events or areas based on the commands
     * @param input
     * @return GameObject
     */
    
    public GameObject parseCommand(String input) {
        GameObject gameObject = this.checkSpecialCasesAndErrors(input);
        if (gameObject != null) {
            return gameObject;
        }
        String command = commandParser.parseCommand(input);
        String target = commandParser.parseTarget(input);
        if (command.equalsIgnoreCase("GOTO")) {
            return parseGoToCommand(target);
        } else if (command.equalsIgnoreCase("TAKE")) {
            return parseTakeCommand(target);
        } else if (command.equalsIgnoreCase("USE")) {
            return parseUseCommand(target);
        } else {
            return null;
        }
      
    }
    
    private GameObject parseUseCommand(String target) {
        return eventHandler.handleUsageEvent(target, gameState);
    }
    
    
    private GameObject checkSpecialCasesAndErrors(String input) {
        GameObject flagOutcomes = checkFlags();
        if (flagOutcomes != null) {
            return flagOutcomes;
        }
        if (gameState.isIsTutorial() && gameState.getTurns() == 0) {
            return getStartTutorial();
        }
        if (gameState.getTurns() == 0) {
            return getFirstArea();
        }
        if (gameState.getTurns() == 50) {
            return gameOver();
        }
        if (input == null || input.trim().length() == 0) {
            return gameState.getCurrentArea();
        }
        return null;
    }
    
    private GameObject getFirstArea() {
        gameState.incrementTurns();
        gameState.setCurrentArea(areaParser.getFirstRoom());
        return areaParser.getFirstRoom();
    }
    
    private GameObject getStartTutorial() {
        gameState.incrementTurns();
        gameState.setCurrentArea(areaParser.getTutorialRoom());
        return areaParser.getTutorialRoom();
    }
    
    
    
    private GameObject checkFlags() {
        if (gameState.getFlags().isGameOver() || gameState.getFlags().isGameWon()) {
            return new Event("The game is now over. Please quit by clicking X.");
        }
        return null;
    }
    
    
    private GameObject gameOver() {
        Event event = new Event();
        event.setEventMessage("Game over. You lost. Press X to quit. Thank you for playing!");
        return event;
    }
     
    private InventoryMessage parseTakeCommand(String target) {
        InventoryMessage invmessage = new InventoryMessage();
        String message = "Error has occurred";
        if (areaParser.hasItem(gameState.getCurrentArea(), target) && gameState.getInventory().isItemInInventory(target) == false) {
            message = "You picked up " + target;
            gameState.getInventory().addItem(new Item(target));
        } else {
            message = "There is no such item in room.";
        }
        invmessage.setMessage(message);
        return invmessage;
    }
    
    /**
     * Returns the current inventory state
     * @return Inventory
     */
    public Inventory getInventoryState() {
        return gameState.getInventory();
    }
    
    /**
     * Returns boolean on whether an item has been picked in the game already. True if has.
     * @param name
     * @return boolean
     */
    
    public boolean hasBeenPicked(String name) {
        return gameState.getInventory().hasBeenPicked(name);
    }
    
    private GameObject parseGoToCommand(String target) {   
        GameObject specialEvent = checkForSpecialAreaCases(target);
        if  (specialEvent != null) {
            return specialEvent;
        }
        Area area = areaParser.parseArea(target);   
        if (area == null) {
            return eventHandler.handleInvalidGoToCommand();
        }
        if (areaParser.canGoToArea(gameState.getCurrentArea(), area.getAreaName())) {
            gameState.setCurrentArea(area);
            gameState.incrementTurns();
            return gameState.getCurrentArea(); 
        }
        return eventHandler.handleInvalidGoToCommand();
    }
    /**
     * Returns current room
     * @return current room
     */
    
    public Area getCurrentRoom() {
        return gameState.getCurrentArea();
    }
    
    private GameObject checkForSpecialAreaCases(String target) {
        if (target.equals("ENGINE_ROOM") && !gameState.getFlags().isEngineDoorOpen()) {
            return new Event("The door is locked and looks very sturdy.");
        } 
        Message message = (Message) checkErrors(target);
        if (!message.isOK()) {
            return new Event("You can't go there");
        } 
        return null;
    }
    
    private GameObject checkErrors(String target) {
        if (target.trim().length() == 0) {
            return null;
        }
        if (gameState.isError()) {
            gameState.setError(false);
            return gameState.getCurrentArea();
        }
        return new Message(true);
    }

    /**
     * Sets tutorial mode
     */
    public void setTutorialMode() {
        gameState.setIsTutorial(true);
    }
    
    /**
     * returns current game state
     * @return GameState
     */

    public GameState getGameState() {
        return gameState;
    }

    /**
     * sets current gamestate
     * @param gameState 
     */
    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
    
    
}
