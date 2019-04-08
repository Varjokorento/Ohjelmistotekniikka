/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import com.mycompany.escapetrain.engine.GameEngine;
import com.mycompany.escapetrain.engine.GameState;
import com.mycompany.escapetrain.gameobjects.area.Area;
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
    public void isErrorIsFalseInBeginning() {
        assertFalse(state.isError());
    }
    
    @Test
    public void settingErrorSetsError() {
        state.setError(true);
        assertTrue(state.isError());
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
    
    
    
    
}
