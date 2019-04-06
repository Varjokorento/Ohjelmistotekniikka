/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.escapetrain.GameObjects.Area;

import com.mycompany.escapetrain.Engine.GameObject;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class Area implements GameObject {
    private String objectType;
    private String areaName;
    private String description;
    private String surroundingAreas;

    public Area(String areaName, String description, String surroundingAreas) {
        this.areaName = areaName;
        this.description = description;
        this.surroundingAreas = surroundingAreas;
        this.objectType= "AREA";
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
    
    public void setObjectType(String type) {
        this.objectType = type;
    }
    @Override
    public String getObjectType() {
        return this.objectType;
    }

   
    
    
    
}
