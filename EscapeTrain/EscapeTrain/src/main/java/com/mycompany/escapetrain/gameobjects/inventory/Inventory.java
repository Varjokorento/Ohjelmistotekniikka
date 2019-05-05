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
 * The game inventory
 * @author Varjokorento
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
    
    /**
     * Returns the items in an inventory as a list
     * @return items     items in the inventory
     */

    public List<Item> getItems() {
        return items;
    }
    
    /**
     * Sets the items in the inventory
     * @param items desired items
     */

    public void setItems(List<Item> items) {
        for (Item item: items) {
            itemNames.add(item.getName());
        }
        this.items = items;
    }
    
    /**
     * Adds an item to the inventory
     * @param item  Item to be added
     */
    
    public void addItem(Item item) {
        this.items.add(item);
        this.itemNames.add(item.getName());
    }
    
    /**
     * Adds an item to the inventory by its names
     * @param item  name of the item
     */
    
    public void addItem(String item) {
        this.items.add(new Item(item));
        this.itemNames.add(item);
    }
    
    /**
     * Removes the item from the inventory by its name
     * @param itemName   String name of the item
     */
    
    public void removeItem(String itemName) {
        Item item = new Item(itemName);
        if (this.items.contains(item)) {
            this.items.remove(item);
        }
    }
    
    /**
     * Checks whether item is in inventory
     * @param itemName  the item to be checked
     * @return  boolean whether item is in inventory
     */
    
    public boolean isItemInInventory(String itemName) {
        return items.contains(new Item(itemName));
    }
    
    /**
     * Checks whether an item has already been picked in the room
     * @param name  The item that the player is trying to take
     * @return boolean  whether it has already been picked or not
     */
    
    public boolean hasBeenPicked(String name) {
        return itemNames.contains(name);
    }
    
    /**
     * Returns 'Inventory'
     * @return  String  'Inventory'
     */

    @Override
    public String getObjectType() {
        return this.objectType;
    }
    /**
     * Sets the object type of the inventory
     * @param type   the desired type
     */
    @Override
    public void setObjectType(String type) {
        this.objectType = type;
    }
    
    
}
