/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.escapetrain.Engine;

import com.mycompany.escapetrain.GameObjects.Area.Area;

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
    //TODO 
    //Return gameState which controller uses to update view.
    public String parseGoToCommand(String input) {
        if(input.length() == 0) {
             return null;
        }
        String command = commandParser.parseCommand(input);
        String target = commandParser.parseTarget(input);
        String area = areaParser.parseArea(target);   
        if(areaParser.canGoToArea(gameState.getCurrentArea(), area)) {
           gameState.setCurrentArea(new Area(area, "scary place", null));
           return gameState.getCurrentArea().getAreaName(); 
        }
        return "CANT GO";
    }
}
