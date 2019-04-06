/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.escapetrain.engine;

import com.mycompany.escapetrain.gameobjects.area.Area;
import com.mycompany.escapetrain.gameobjects.events.Event;
import com.mycompany.escapetrain.gameobjects.events.GameOver;
import com.mycompany.escapetrain.gameobjects.inventory.Inventory;
import com.mycompany.escapetrain.gameobjects.inventory.InventoryMessage;
import com.mycompany.escapetrain.gameobjects.inventory.Item;
import java.io.IOException;

/**
 *
 * @author Administrator
 */
public class GameEngine {
    
    private CommandParser commandParser;
    private AreaParser areaParser;
    private GameState gameState;
    
    public GameEngine() {
        this.commandParser = new CommandParser();
        this.areaParser = new AreaParser();
        this.gameState = new GameState();
    }
    
    public void init() throws IOException {
        areaParser.init();
    }
    
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
        } /*else if (command.equalsIgnoreCase("USE")) {
            
        } else {
            
        }*/
        return null;
    }
    
    public GameObject checkSpecialCasesAndErrors(String input) {
        if (gameState.getTurns() == 0) {
            gameState.incrementTurns();
            gameState.setCurrentArea(areaParser.getFirstRoom());
            return areaParser.getFirstRoom();
        }
        if (gameState.getTurns() == 3) {
            return gameOver();
        }
        if (input == null || input.trim().length() == 0) {
            return gameState.getCurrentArea();
        }
        return null;
    }
    
    private GameObject gameOver() {
        Event event = new GameOver();
        event.setEventMessage("Game over. You lost. Press X to quit. Thank you for playing!");
        return event;
    }
    
    public InventoryMessage parseTakeCommand(String target) {
        InventoryMessage invmessage = new InventoryMessage();
        String message = "Error has occurred";
        if (areaParser.hasItem(gameState.getCurrentArea(), target)) {
            message = "You picked up " + target;
            gameState.getInventory().addItem(new Item(target));
        } else {
            message = "There is no such item in room.";
        }
        invmessage.setMessage(message);
        return invmessage;
    }
    
    public Inventory getInventoryState() {
        return gameState.getInventory();
    }
    
    public Area parseGoToCommand(String target) {
        if (target.trim().length() == 0) {
            return null;
        }
        if (gameState.isError()) {
            gameState.setError(false);
            return gameState.getCurrentArea();
        }
        Area area = areaParser.parseArea(target);   
        if (area == null) {
            gameState.setError(true); 
            return areaParser.getErrorRoom(); 
        }
        if (areaParser.canGoToArea(gameState.getCurrentArea(), area.getAreaName())) {
            gameState.setCurrentArea(area);
            gameState.incrementTurns();
            return gameState.getCurrentArea(); 
        }
        return areaParser.getErrorRoom();
    }
    
    public Area getCurrentRoom() {
        return gameState.getCurrentArea();
    }
}
