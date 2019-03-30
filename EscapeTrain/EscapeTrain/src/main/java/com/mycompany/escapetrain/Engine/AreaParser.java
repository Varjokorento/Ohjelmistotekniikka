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
        String appConfigPath = "C:/Users/Administrator/ohte/EscapeTrain/EscapeTrain/src/main/resources/app.properties";
        appProps.load(new FileInputStream(appConfigPath));
    }
    

    
    public String parseArea(String possibleArea) {
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
    
    public Boolean canGoToArea(Area currentArea, String targetArea) {
     
        return currentArea.doesBorder(targetArea);
    }
    
}
