/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.escapetrain.gameobjects.inventory;

import java.util.Objects;

/**
 *
 * @author Administrator
 */
public class Item {
    private String name; 
    private Boolean hasBeenUsed;

    public Item(String name) {
        this.name = name;
    }
   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Boolean getHasBeenUsed() {
        return hasBeenUsed;
    }

    public void setHasBeenUsed(Boolean hasBeenUsed) {
        this.hasBeenUsed = hasBeenUsed;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
    
}
