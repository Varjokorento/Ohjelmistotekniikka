/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 */

package engine;

import com.mycompany.escapetrain.engine.parsers.AreaParser;
import com.mycompany.escapetrain.engine.parsers.CommandParser;
import com.mycompany.escapetrain.engine.GameEngine;
import com.mycompany.escapetrain.engine.gamestateutils.GameState;
import com.mycompany.escapetrain.gameobjects.GameObject;
import com.mycompany.escapetrain.gameobjects.area.Area;
import com.mycompany.escapetrain.gameobjects.inventory.Inventory;
import com.mycompany.escapetrain.gameobjects.inventory.Item;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 *
 * @author Administrator
 */
public class GameEngineTest {
    private GameEngine engine;
    @Mock
    private AreaParser areaParser;
    @Mock
    private CommandParser commandParser;
    @Mock
    private GameState gameState;
    
    
    @Before
    public void init() {
        initMocks(this);
        this.engine = new GameEngine();
    }
    
    @Test
    public void parseCommandReturnsAreaWithNullFieldsForInvalidCOmmand() {
        Area returnedObject = (Area) engine.parseCommand("INVALID COMMAND INVALID");
        assertEquals(null, returnedObject.getAreaName());
    }
       
    @Test
    public void setTutorialModeSetsTutorial() {
        engine.setTutorialMode();
        assertTrue(engine.getGameState().isIsTutorial());
    }
    
    @Test
    public void getCurrentAreaGetCurrentArea() {
        Area area = new Area("Test", null,null,null);
        engine.getGameState().setCurrentArea(area);
        assertEquals(area.getAreaName(), engine.getCurrentRoom().getAreaName());
    }
    
    @Test
    public void hasBeenPickedReturnsCorrectValue() {
        GameState gameState = new GameState();
        Inventory inventory = new Inventory();
        inventory.addItem(new Item("item"));
        gameState.setInventory(inventory);
        engine.setGameState(gameState);
        assertTrue(engine.hasBeenPicked("item"));
    }
    
    
}
