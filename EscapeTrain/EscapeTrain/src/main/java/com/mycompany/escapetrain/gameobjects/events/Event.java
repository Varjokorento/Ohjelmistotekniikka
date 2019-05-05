/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.escapetrain.gameobjects.events;

import com.mycompany.escapetrain.gameobjects.GameObject;

/**
 * Represents certain events that occur in game
 * @author Varjokorento
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
    /**
     * Returns the event message
     * @return eventMessage unique message for the event
     */
    public String getEventMessage() {
        return eventMessage;
    }
    /**
     * Sets the event message
     * @param eventMessage  Message as a string
     */
    public void setEventMessage(String eventMessage) {
        this.eventMessage = eventMessage;
    }
    
    /**
     * Returns 'Event'
     * @return objectType   'Event'
     */
    @Override
    public String getObjectType() {
        return this.objectType;
    }

    /**
     * Sets the object type.
     * @param type  the desired type
     */
    @Override
    public void setObjectType(String type) {
        this.objectType = type;
    }
    
}
