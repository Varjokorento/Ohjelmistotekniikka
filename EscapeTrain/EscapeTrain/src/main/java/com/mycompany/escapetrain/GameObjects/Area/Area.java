/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.escapetrain.GameObjects.Area;

import java.util.List;

/**
 *
 * @author Administrator
 */
public class Area {
    private String areaName;
    private String description;
    private List<Integer> surroundingAreas;

    public Area(String areaName, String description, List<Integer> surroundingAreas) {
        this.areaName = areaName;
        this.description = description;
        this.surroundingAreas = surroundingAreas;
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

    public List<Integer> getSurroundingAreas() {
        return surroundingAreas;
    }

    public void setSurroundingAreas(List<Integer> surroundingAreas) {
        this.surroundingAreas = surroundingAreas;
    }
    
    
    
    
}