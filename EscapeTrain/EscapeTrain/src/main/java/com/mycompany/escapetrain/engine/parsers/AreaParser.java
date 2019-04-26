/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.escapetrain.engine.parsers;

import com.mycompany.escapetrain.gameobjects.area.Area;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * The parser for game areas
 * Uses area.properties
 */
public class AreaParser {
    
    private Properties appProps;

    public AreaParser() {
        this.appProps = new Properties();
    }
    
    public void init() throws FileNotFoundException, IOException {
        InputStream input = AreaParser.class.getClassLoader().getResourceAsStream("area.properties");
        appProps.load(input);
    }

    /**
     * Method returns the target area of a command or null if the parameter is not a valid area
     * @param possibleArea
     * @return Area 
     */
    public Area parseArea(String possibleArea) {
        if (possibleArea == null) {
            return null;
        }
        Area parsedArea = parsePossibleAreaToArea(possibleArea);
        if (parsedArea == null) {
            return null;
        } 
        return parsedArea;
        
    }
    
    private Area parsePossibleAreaToArea(String possibleArea) {
        
        if (!appProps.getProperty("GAME_ROOMS").contains(possibleArea)) {
            return null;
        }
        
        if (appProps.getProperty(possibleArea.concat("_AREANAME")) != null) {
            Area area = new Area(appProps.getProperty(possibleArea.concat("_AREANAME")), 
                    appProps.getProperty(possibleArea.concat("_DESCRIPTION")), 
                    appProps.getProperty(possibleArea.concat("_BORDER_AREAS")),
                    appProps.getProperty(possibleArea.concat("_ITEMS")));
            return area;
        }
        return null;
    }
    
    /**
     * Method checks whether the player can go from currentarea to targetarea. Returns false if cannot.
     * @param currentArea
     * @param targetArea
     * @return boolean
     */
    
    public Boolean canGoToArea(Area currentArea, String targetArea) {    
        if (currentArea == null || targetArea == null || currentArea.getAreaName() == null) {
            return false;
        }
        String borderingAreas = appProps.getProperty(currentArea.getAreaName().concat("_BORDER_AREAS"));
        return borderingAreas.contains(targetArea);
    }
    
    /**
     * The method returns the first room of the game (LUGGAGE_ROOM)
     * @return Area
     */

    public Area getFirstRoom() { 
        Area firstArea = new Area(appProps.getProperty("LUGGAGE_ROOM_AREANAME"), 
                appProps.getProperty("LUGGAGE_ROOM_DESCRIPTION"), 
                appProps.getProperty("LUGGAGE_ROOM_BORDER_AREAS"),
                appProps.getProperty("LUGGAGE_ROOM_ITEMS"));
        return firstArea;
    }

     /**
     * The method returns the Error room of the game (Error_ROOM)
     * @return Area
     */

    public Area getErrorRoom() {
        Area errorArea = new Area(appProps.getProperty("ERROR_ROOM_AREANAME"), 
            appProps.getProperty("ERROR_ROOM_DESCRIPTION"), 
            appProps.getProperty("ERROR_ROOM_BORDER_AREAS"),
            appProps.getProperty("ERROR_ROOM_ITEMS"));
        return errorArea;
    }
     /**
     * The method returns the tutorial room of the game (tutorial_ROOM)
     * @return Area
     */
    
    public Area getTutorialRoom() {
        Area tutorialArea = new Area(appProps.getProperty("TUTORIAL_ROOM_AREANAME"), 
            appProps.getProperty("TUTORIAL_ROOM_DESCRIPTION"), 
            appProps.getProperty("TUTORIAL_ROOM_BORDER_AREAS"),
            appProps.getProperty("TUTORIAL_ROOM_ITEMS"));
        return tutorialArea;
    }
    
    /**
     * The method returns whether a certain item is in room or not. Returns false if not.
     * @param currentArea 
     * @param target (the name of the item)
     * @return boolean
     */

    public boolean hasItem(Area currentArea, String target) {
        String itemsInRoom = appProps.getProperty(currentArea.getAreaName().concat("_ITEMS"));
        return checkItemsInRoom(itemsInRoom, target);
       
    }
    
    private boolean checkItemsInRoom(String itemsInRoom, String target) {
        String[] itemList = itemsInRoom.split(",");
        for (String item : itemList) {
            item = item.replaceAll("\\s", "");
            if (item.equalsIgnoreCase(target.trim())) {
                return true;
            } 
        }
        return false;
    }
    
    
}
