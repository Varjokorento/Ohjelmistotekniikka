/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.escapetrain.GameObjects.Inventory;

/**
 *
 * @author Administrator
 */
public class Item {
    private String name; 

    public Item(String name) {
        this.name = name;
    }
    
   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
