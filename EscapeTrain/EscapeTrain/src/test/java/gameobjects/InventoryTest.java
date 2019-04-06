/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobjects;

import com.mycompany.escapetrain.gameobjects.inventory.Inventory;
import com.mycompany.escapetrain.gameobjects.inventory.Item;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Administrator
 */
public class InventoryTest {
    private Inventory inventory;
    private Item item;
    
    @Before
    public void init() {
        this.inventory = new Inventory();
        this.item = new Item("Test");
    }
    
    @Test
    public void addItemAddsItem() {
        inventory.addItem(item);
        assertTrue(inventory.isItemInInventory("Test"));
    }
    
    @Test
    public void removingItemRemovesItem() {
        inventory.addItem(item);
        inventory.removeItem(item);
        assertFalse(inventory.isItemInInventory("Test"));
    }
    
    @Test
    public void removingNonExistingItemDoesNothing() {
        inventory.addItem(item);
        inventory.removeItem(new Item("New"));
        assertTrue(inventory.isItemInInventory("Test"));
    }
    
    @Test
    public void setItemsSetsItems() {
        List<Item> newItems = new ArrayList<>();
        Item newItem = new Item("newItem");
        newItems.add(newItem);
        inventory.setItems(newItems);
        assertTrue(inventory.isItemInInventory(newItem.getName()));
    }
    
    @Test
    public void getObjectTypeReturnsCorrectObjectType() {
        String expectedType = "INVENTORY";
        assertEquals(expectedType, inventory.getObjectType());
    }
    
    @Test
    public void settingObjectTypeChangesType() {
        Inventory newInventory = new Inventory();
        String newType = "NEW_TYPE";
        newInventory.setObjectType(newType);
        assertEquals(newType, newInventory.getObjectType());
    }
    
    @Test
    public void getItemsReturnsSomething() {
        inventory.addItem(item);
        Item returnedItem = inventory.getItems().get(0);
        assertEquals("Test", returnedItem.getName());
    }
}
