/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.escapetrain.gameobjects.inventory;

import com.mycompany.escapetrain.gameobjects.GameObject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class Inventory implements GameObject {
    private List<Item> items;
    private HashSet<String> itemNames;
    private String objectType;

    public Inventory() {
        this.items = new ArrayList<>();
        this.itemNames = new HashSet<>();
        this.objectType = "INVENTORY";
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        for (Item item: items) {
            itemNames.add(item.getName());
        }
        this.items = items;
    }
    
    public void addItem(Item item) {
        this.items.add(item);
        this.itemNames.add(item.getName());
    }
    
    public void addItem(String item) {
        this.items.add(new Item(item));
        this.itemNames.add(item);
    }
    
    public void removeItem(String itemName) {
        Item item = new Item(itemName);
        if (this.items.contains(item)) {
            this.items.remove(item);
        }
    }
    
    public boolean isItemInInventory(String itemName) {
        return items.contains(new Item(itemName));
    }
    
    public boolean hasBeenPicked(String name) {
        return itemNames.contains(name);
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
