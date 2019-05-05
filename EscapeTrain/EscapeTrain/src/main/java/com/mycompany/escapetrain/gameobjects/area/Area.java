/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.escapetrain.gameobjects.area;

import com.mycompany.escapetrain.gameobjects.GameObject;

/**
 * Represents the game area
 * @author Varjokorento
 */
public class Area implements GameObject {
    private String objectType;
    private String areaName;
    private String description;
    private String surroundingAreas;
    private String itemsInRoom;

    public Area(String areaName, String description, String surroundingAreas, String itemsInRoom) {
        this.areaName = areaName;
        this.description = description;
        this.surroundingAreas = surroundingAreas;
        this.itemsInRoom = itemsInRoom;
        this.objectType = "AREA";
    }
    /**
     * Returns the name of the area
     * @return areaName the name of the area
     */
    public String getAreaName() {
        return areaName;
    }
    
    /**
     * Returns the formatted area name for UI. AREA_NAME is formatted into area name.
     * @return formattedAreaname    area name
     */
    
    public String getAreaNameFormatted() {
        String formattedName = areaName.replaceAll("_", " ").toLowerCase();
        return formattedName;
    }
    
    
    /**
     * Sets the area name
     * @param areaName  areaName to be set
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
    /**
     * returns the description for the area
     * @return description  area description
     */
    public String getDescription() {
        return description;
    }
    /**
     * Sets the description for the area.
     * @param description   Description of the area
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Returns the surrounding areas of the area
     * @return  surroundingAreas    surrounding areas as a string area1,area2
     */
    public String getSurroundingAreas() {
        return surroundingAreas;
    }
    
    /**
     * Returns the formatted versions of the surrounding areas. | area1 | area2 |
     * @return formattedSurroundingAreas    formatted list of the surrounding areas
     */
    
    public String getSurroundingAreasFormatted() {
        String[] surrounding = this.surroundingAreas.split(",");
        String formatted = "";
        for (String area: surrounding) {
            area = area.replaceAll("_", " ").toLowerCase();
            formatted = formatted + " | " + area;
        }
        formatted = formatted + " |";
        return formatted;
    }
    
    /**
     * Sets the surrounding areas
     * @param surroundingAreas  The areas surrounding this area
     */

    public void setSurroundingAreas(String surroundingAreas) {
        this.surroundingAreas = surroundingAreas;
    }

    /**
     * Returns the items in the room as a single string
     * @return itemsInRoom  items in room as a string
     */
    public String getItemsInRoom() {
        return this.itemsInRoom;
    }
    
    /**
     * Sets the items in room
     * @param itemsInRoom   the desired items in room
     */
    
    public void setItemsInRoom(String itemsInRoom) {
        this.itemsInRoom = itemsInRoom;
    }
    /**
     * Sets the object type for the Area object
     * @param type  Type of the object
     */
    public void setObjectType(String type) {
        this.objectType = type;
    }
    /**
     * Implementation of the parent method
     * @return objectType   returns 'Area'
     */
    @Override
    public String getObjectType() {
        return this.objectType;
    }

   
    
    
    
}
