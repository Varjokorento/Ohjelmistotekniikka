/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import com.mycompany.escapetrain.engine.GameEngine;
import com.mycompany.escapetrain.engine.gamestateutils.GameState;
import com.mycompany.escapetrain.gameobjects.area.Area;
import com.mycompany.escapetrain.gameobjects.inventory.Inventory;
import com.mycompany.escapetrain.gameobjects.inventory.Item;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Administrator
 */
public class GameStateTest {
    private GameState state;
    
    @Before
    public void init() {
        this.state = new GameState();
    }
   
     
    @Test
    public void currentAreaIsNullInBeginning() {
        assertNull(state.getCurrentArea());
    }
    
    @Test
    public void settingCurrentAreaSetsCurrentArea() {
        Area test = new Area("new_area", null, null, null);
        state.setCurrentArea(test);
        assertEquals("new_area", state.getCurrentArea().getAreaName());
    }
    
    @Test
    public void incrementingTurnsIncrementTurns() {
        assertTrue(state.getTurns() == 0);
        state.incrementTurns();
        assertTrue(state.getTurns() == 1);
    }
    
    @Test
    public void setTurnsSetsTurns() {
       state.setTurns(10);
       assertTrue(state.getTurns() == 10);
    }
    
    @Test
    public void isInInventoryReturnsTrueIfItemInInventory() {
        Inventory inventory = new Inventory();
        inventory.addItem(new Item("Test"));
        state.setInventory(inventory);
        assertTrue(state.isInInventory("Test"));
    }
    
    
}
