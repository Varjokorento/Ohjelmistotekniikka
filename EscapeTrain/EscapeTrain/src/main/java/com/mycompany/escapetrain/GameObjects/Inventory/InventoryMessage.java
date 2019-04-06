/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.escapetrain.GameObjects.Inventory;

import com.mycompany.escapetrain.Engine.GameObject;

/**
 *
 * @author Administrator
 */
public class InventoryMessage implements GameObject {
    private String objectType;
    private String message;

    public InventoryMessage() {
        this.objectType = "ITEM";
    }

    
    
    @Override
    public String getObjectType() {
        return this.objectType;
    }

    @Override
    public void setObjectType(String type) {
       this.objectType = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
    
    
    
}
