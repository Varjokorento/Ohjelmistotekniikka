/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.escapetrain.gameobjects.area;

import com.mycompany.escapetrain.gameobjects.GameObject;

/**
 *
 * @author Administrator
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

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSurroundingAreas() {
        return surroundingAreas;
    }

    public void setSurroundingAreas(String surroundingAreas) {
        this.surroundingAreas = surroundingAreas;
    }

    public Boolean doesBorder(String targetArea) {
        return true;
    }
    
    public String getItemsInRoom() {
        return this.itemsInRoom;
    }
    
    public void setItemsInRoom(String itemsInRoom) {
        this.itemsInRoom = itemsInRoom;
    }
    
    public void setObjectType(String type) {
        this.objectType = type;
    }
    @Override
    public String getObjectType() {
        return this.objectType;
    }

   
    
    
    
}
