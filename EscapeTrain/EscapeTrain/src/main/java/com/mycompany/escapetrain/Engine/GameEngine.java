/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.escapetrain.Engine;

/**
 *
 * @author Administrator
 */
public class GameEngine {
    
    private CommandParser commandParser;
    private AreaParser areaParser;
    
    public GameEngine() {
        this.commandParser = new CommandParser();
        this.areaParser = new AreaParser();
    }
    
    public String parseGoToCommand(String input) {
        if(input.length() == 0) {
             return null;
        }
        String command = commandParser.parseCommand(input);
        String target = commandParser.parseTarget(input);
        String area = areaParser.parseArea(target);   
        return area;
    }
}
