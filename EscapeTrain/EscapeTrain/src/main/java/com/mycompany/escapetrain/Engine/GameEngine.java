/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.escapetrain.Engine;

import com.mycompany.escapetrain.GameObjects.Area.Area;
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
    //TODO 
    //Return gameState which controller uses to update view.
    public Area parseGoToCommand(String input) {
  
        if(gameState.getTurns() == 0) {
            gameState.incrementTurns();
            gameState.setCurrentArea(areaParser.getFirstRoom());
            return areaParser.getFirstRoom();
        } 
        if(input.trim().length() == 0) {
             return null;
        }
        if(gameState.getTurns() == 2) {
            return areaParser.getLastRoom();
        }
        if(gameState.isError()) {
            gameState.setError(false);
            return gameState.getCurrentArea();
        }
        String command = commandParser.parseCommand(input);
        String target = commandParser.parseTarget(input);
        Area area = areaParser.parseArea(target);   
        if(area == null) {
           gameState.setError(true); 
           return areaParser.getErrorRoom(); 
        }
        if(areaParser.canGoToArea(gameState.getCurrentArea(), area.getAreaName())) {
           gameState.setCurrentArea(area);
           gameState.incrementTurns();
           return gameState.getCurrentArea(); 
        }
        return areaParser.getErrorRoom();
    }
}
