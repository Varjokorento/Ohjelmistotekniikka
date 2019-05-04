/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import com.mycompany.escapetrain.datahandling.DataService;
import com.mycompany.escapetrain.engine.gamestateutils.GameState;
import com.mycompany.escapetrain.engine.parsers.EventHandler;
import com.mycompany.escapetrain.gameobjects.area.Area;
import com.mycompany.escapetrain.gameobjects.events.Event;
import com.mycompany.escapetrain.gameobjects.inventory.Inventory;
import com.mycompany.escapetrain.gameobjects.inventory.Item;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author Administrator
 */
@RunWith(MockitoJUnitRunner.class)
public class EventHandlerTest {
    private EventHandler eventHandler;
    private GameState gameState;
    
    @Mock 
    private DataService dataService;

    
    @Before
    public void init() {
        initMocks(this);
        this.eventHandler = new EventHandler();
        eventHandler.setDataService(dataService);
        this.gameState = new GameState();
    }
    
    @Test
    public void tutorialReturnsTutorialEvent() {
        this.gameState.setIsTutorial(true);
        Event event = (Event) eventHandler.handleUsageEvent("test", gameState);
        String expectedEventMessage = "Absolutely nothing happens";
        assertEquals(expectedEventMessage, event.getEventMessage());
    }
    
    @Test
    public void winTutorialReturnsWinTutorialEvent() {
        this.gameState.setIsTutorial(true);
        this.gameState.setCurrentArea(new Area("NEXT_ROOM", null,null,null));
        Event event = (Event) eventHandler.handleUsageEvent("lever", gameState);
        String expectedEventMessage = "You have managed to finish the tutorial! Now press back button and start the game!";
        assertEquals(expectedEventMessage, event.getEventMessage());
    }
    
    @Test
    public void usingLeverInCorrectPlaceReturnsVictoryEvent() {
        when(dataService.getVictories()).thenReturn(0);
        gameState.setCurrentArea(new Area("ENGINE_ROOM", "null","null","null"));
        gameState.setIsTutorial(false);
        Event event = (Event) eventHandler.handleUsageEvent("lever", gameState);
        assertTrue(gameState.getFlagStates().isGameWon());
    }
    
    @Test
    public void nonExistentItemReturnsItemNotFoundMessage() {
        Event event = (Event) eventHandler.handleUsageEvent("notexist", gameState);
        String expectedEventMessage = "You don't have that on you!";
        assertEquals(expectedEventMessage, event.getEventMessage());
    }
    
    @Test
    public void usingDynamiteWorksInStaffQuarters() {
        Inventory inventory = new Inventory();
        inventory.addItem(new Item("dynamite"));
        gameState.setInventory(inventory);
        gameState.setCurrentArea(new Area("STAFF_QUARTERS", null,null,null));
        Event event = (Event) eventHandler.handleUsageEvent("dynamite", gameState);
        assertTrue(gameState.getFlagStates().isDynamiteSet());
    }
    
    @Test
    public void lightingDynamiteInCorrectPlaceOpensUpTheDoor() {
        Inventory inventory = new Inventory();
        inventory.addItem(new Item("dynamite"));
        inventory.addItem(new Item("matches"));
        gameState.setInventory(inventory);
        gameState.setCurrentArea(new Area("STAFF_QUARTERS", null,null,null));
        Event event = (Event) eventHandler.handleUsageEvent("dynamite", gameState);
        eventHandler.handleUsageEvent("matches", gameState);
        assertTrue(gameState.getFlagStates().isEngineDoorOpen());
    }
    
    @Test
    public void usingPillowGivesYouDynamite() {
        Inventory inventory = new Inventory();
        inventory.addItem(new Item("pillow"));
        gameState.setInventory(inventory);
        gameState.setCurrentArea(new Area("STAFF_QUARTERS", null,null,null));
        Event event = (Event) eventHandler.handleUsageEvent("pillow", gameState);
        assertTrue(gameState.getInventory().isItemInInventory("dynamite"));
    }
    
    @Test
    public void nothingHappensIfItemShouldnCauseEvent() {
        Inventory inventory = new Inventory();
        inventory.addItem(new Item("vodka"));
        gameState.setInventory(inventory);
        Event event = (Event) eventHandler.handleUsageEvent("vodka", gameState);
        String expectedEventMessage = "Nothing happens.";
        assertEquals(expectedEventMessage, event.getEventMessage());
    }
    
    @Test
    public void gameHasEndedEventReturnsCorrectEvent() {
        Event event = (Event) eventHandler.gamehasEndedEvent();
        String expectedEventMessage = "The game is now over. Please quit by clicking X.";
        assertEquals(expectedEventMessage, event.getEventMessage());   
    }
}
