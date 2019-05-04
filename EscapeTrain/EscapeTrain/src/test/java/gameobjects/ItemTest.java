/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobjects;

import com.mycompany.escapetrain.gameobjects.inventory.Inventory;
import com.mycompany.escapetrain.gameobjects.inventory.Item;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Administrator
 */
public class ItemTest {
    private Item item;
    
    @Before
    public void init() {
        this.item = new Item("Test");
    }
    
    @Test
    public void equalsTestTrueWithSameObject() {
        assertTrue(item.equals(item));
    }
    
    @Test
    public void equalTestTrueWithObjectWithSameName() {
         assertTrue(item.equals(new Item("Test")));
    }
    
    @Test
    public void equalTestFalseWithNullObject() {
        assertFalse(item.equals(null));
    }
}
