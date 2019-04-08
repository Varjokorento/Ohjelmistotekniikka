/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.escapetrain.gameobjects.events;

import com.mycompany.escapetrain.engine.GameObject;

/**
 *
 * @author Administrator
 */
public class Event implements GameObject {
    private  String objectType;
    private String eventMessage;
    
    public Event() {
        this.objectType = "EVENT";
    }
    
    public Event(String message) {
        this.eventMessage = message;
        this.objectType = "EVENT";
    }

    public String getEventMessage() {
        return eventMessage;
    }

    public void setEventMessage(String eventMessage) {
        this.eventMessage = eventMessage;
    }
    

    @Override
    public String getObjectType() {
        return this.objectType;
    }

    @Override
    public void setObjectType(String type) {
        this.objectType = type;
    }
    
}
