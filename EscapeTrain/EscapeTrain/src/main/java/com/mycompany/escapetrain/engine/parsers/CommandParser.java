/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.escapetrain.engine.parsers;

/**
 *
 * @author Administrator
 */
public class CommandParser {

    public CommandParser() {
    }
    
    public String parseCommand(String commandToBeParsed) {
        String[] parts = commandToBeParsed.split(" ");
        return parts[0];
    }
            
    public String parseTarget(String commandToBeParsed) {
        String[] parts = commandToBeParsed.split(" ");
        if (parts.length < 2) {
            return null;
        }
        String item = "";
        for (int i = 1; i < parts.length; i++) {
            item = item.concat(parts[i]);
        }
        return item;
    }
    
}
