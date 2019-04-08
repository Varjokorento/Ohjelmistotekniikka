/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.escapetrain.gameobjects.message;

import com.mycompany.escapetrain.engine.GameObject;

/**
 *
 * @author Administrator
 */
public class Message implements GameObject {
    private boolean isOK;
    private String objectType;

    public Message(boolean isOK) {
        this.isOK = isOK;
    }

    public boolean isOK() {
        return isOK;
    }

    public void setIsOK(boolean isOK) {
        this.isOK = isOK;
    }
    
    @Override
    public String getObjectType() {
        return "OK";
    }

    @Override
    public void setObjectType(String type) {
        this.objectType = type;
    }
    
    
    
    
}
