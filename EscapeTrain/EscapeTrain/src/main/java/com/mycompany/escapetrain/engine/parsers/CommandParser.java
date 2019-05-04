/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.escapetrain.engine.parsers;

/**
 * Command parser that parses user inputs
 * @author Administrator
 */
public class CommandParser {

    public CommandParser() {
    }
    
    /**
     * Parses the command part of the command. For example GOTO AREA -> return "GOTO" command
     * @param commandToBeParsed
     * @return command
     */
    
    public String parseCommand(String commandToBeParsed) {
        String[] parts = commandToBeParsed.split(" ");
        return parts[0];
    }
    
    /**
     * Parses the target part of the command. For example GOTO AREA -> return AREA target. 
     * @param commandToBeParsed
     * @return target
     */
            
    public String parseTarget(String commandToBeParsed) {
        String[] parts = commandToBeParsed.split(" ");
        if (parts.length < 2) {
            return null;
        }
        String item = "";
        for (int i = 1; i < parts.length; i++) {
            item = item + " " + (parts[i]);
        }
        item = item.trim();
        return item;
    }
    
}
