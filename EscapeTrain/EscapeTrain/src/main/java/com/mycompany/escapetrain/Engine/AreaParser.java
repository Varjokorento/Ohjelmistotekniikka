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
public class AreaParser {
    
    public String areaParser(String possibleArea) {
        String parsedArea = parsePossibleAreaToArea(possibleArea);
        if(parsedArea == null) {
            return null;
        } 
        return parsedArea;
        
    }
    
    private String parsePossibleAreaToArea(String possibleArea) {
        if(possibleArea.equals("NEXT_ROOM")) {
            return "NEXT_ROOM";
        } else {
            return null;
        }
    }
    
}
