/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.escapetrain.Engine;

import com.mycompany.escapetrain.GameObjects.Area.Area;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Administrator
 */
public class AreaParser {
    
    private Properties appProps;

    public AreaParser() {
        this.appProps = new Properties();
    }
    
    public void init() throws FileNotFoundException, IOException {
        String appConfigPath = "./src/main/resources/area.properties";
        appProps.load(new FileInputStream(appConfigPath));
    }

    
    public Area parseArea(String possibleArea) {
        if(possibleArea == null) {
            return null;
        }
        Area parsedArea = parsePossibleAreaToArea(possibleArea);
        if(parsedArea == null) {
            return null;
        } 
        return parsedArea;
        
    }
    
    private Area parsePossibleAreaToArea(String possibleArea) {
        
        if(!appProps.getProperty("GAME_ROOMS").contains(possibleArea)) {
            return null;
        }
        
        if(appProps.getProperty(possibleArea.concat("_AREANAME")) != null) {
            Area area = new Area(appProps.getProperty(possibleArea.concat("_AREANAME")), 
                    appProps.getProperty(possibleArea.concat("_DESCRIPTION")), 
                    appProps.getProperty(possibleArea.concat("_BORDER_AREAS")),
            appProps.getProperty(possibleArea.concat("_ITEMS")));
            return area;
        }
        return null;
    }
    
    public Boolean canGoToArea(Area currentArea, String targetArea) {     
        String borderingAreas = appProps.getProperty(currentArea.getAreaName().concat("_BORDER_AREAS"));
        return borderingAreas.contains(targetArea);
    }

    public Area getFirstRoom() { 
      Area firstArea = new Area(appProps.getProperty("FIRST_ROOM_AREANAME"), 
              appProps.getProperty("FIRST_ROOM_DESCRIPTION"), 
              appProps.getProperty("FIRST_ROOM_BORDER_AREAS"),
              appProps.getProperty("FIRST_ROOM_ITEMS"));
      return firstArea;
    }

    public Area getLastRoom() {
      Area lastArea = new Area(appProps.getProperty("LAST_ROOM_AREANAME"), 
              appProps.getProperty("LAST_ROOM_DESCRIPTION"), 
              appProps.getProperty("LAST_ROOM_BORDER_AREAS"),
              appProps.getProperty("LAST_ROOM_ITEMS"));
      return lastArea;
    }
    
    public Area getErrorRoom() {
      Area errorArea = new Area(appProps.getProperty("ERROR_ROOM_AREANAME"), 
              appProps.getProperty("ERROR_ROOM_DESCRIPTION"), 
              appProps.getProperty("ERROR_ROOM_BORDER_AREAS"),
              appProps.getProperty("ERROR_ROOM_ITEMS"));
      return errorArea;
    }

    boolean hasItem(Area currentArea, String target) {
       String itemsInRoom = appProps.getProperty(currentArea.getAreaName().concat("_ITEMS"));
       return checkItemsInRoom(itemsInRoom, target);
       
    }
    
    private boolean checkItemsInRoom(String itemsInRoom, String target) {
        String[] itemList = itemsInRoom.split(",");
        for(String item : itemList) {
            if(item.equals(target)) {
                return true;
            } 
        }
        return false;
    }
    
}
