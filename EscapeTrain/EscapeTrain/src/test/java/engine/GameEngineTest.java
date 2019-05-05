/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 */

package engine;

import com.mycompany.escapetrain.engine.parsers.AreaParser;
import com.mycompany.escapetrain.engine.parsers.CommandParser;
import com.mycompany.escapetrain.engine.GameEngine;
import com.mycompany.escapetrain.engine.gamestateutils.FlagStates;
import com.mycompany.escapetrain.engine.gamestateutils.GameState;
import com.mycompany.escapetrain.engine.parsers.EventHandler;
import com.mycompany.escapetrain.engine.parsers.ItemInfoParser;
import com.mycompany.escapetrain.gameobjects.area.Area;
import com.mycompany.escapetrain.gameobjects.events.Event;
import com.mycompany.escapetrain.gameobjects.inventory.Inventory;
import com.mycompany.escapetrain.gameobjects.inventory.InventoryMessage;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import org.mockito.Mock;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author Administrator
 */

@RunWith(MockitoJUnitRunner.class)
public class GameEngineTest {
    private GameEngine engine;
    @Mock
    private AreaParser areaParser;
    @Mock
    private CommandParser commandParser;
    @Mock
    private GameState gameState;
    @Mock
    private ItemInfoParser itemInfoParser;
    @Mock 
    private EventHandler eventHandler; 
    
    @Mock
    private FlagStates flagStates;
    
    
    @Before
    public void init() {
        initMocks(this);
        this.engine = new GameEngine();
        engine.setAreaParser(areaParser);
        gameState.setFlagStates(flagStates);
        engine.setEventHandler(eventHandler); 
        engine.setGameState(gameState);
        engine.setCommandParser(commandParser);
        engine.setItemInfoParser(itemInfoParser);
 
    }
    
    @Test
    public void gotoCommandCallsAreaParser() {
        FlagStates flagStates = new FlagStates();
        when(gameState.getFlags()).thenReturn(flagStates);
        when(commandParser.parseCommand(anyString())).thenReturn("GOTO");
        when(commandParser.parseTarget(anyString())).thenReturn("TARGET");
        engine.parseCommand("GOTO AREA");
        verify(areaParser).parseArea(anyString());
    }
    
    @Test
    public void gotoCommandCallsAreaParserCallsGameStateIfCanGoToArea() {
        Area testArea = new Area("TEST", null, null,null);
        FlagStates flagStates = new FlagStates();
        when(gameState.getFlags()).thenReturn(flagStates);
        when(commandParser.parseCommand(anyString())).thenReturn("GOTO");
        when(commandParser.parseTarget(anyString())).thenReturn("TARGET");
        when(areaParser.canGoToArea(any(Area.class), anyString())).thenReturn(true);
        when(areaParser.parseArea("TARGET")).thenReturn(testArea);
        engine.parseCommand("GOTO AREA");
        verify(areaParser).parseArea(anyString());
        verify(gameState, atLeastOnce()).setCurrentArea(testArea);
        verify(gameState, atLeastOnce()).incrementTurns();
        verify(gameState,  atLeastOnce()).getCurrentArea();
    }
    
    @Test
    public void initInitalizesDependencies() throws IOException {
        engine.init();
        verify(itemInfoParser).init();
        verify(areaParser).init();
        verify(eventHandler).init();
    }
    
    @Test
    public void useCommandCallsEventHandler() {
        FlagStates flagStates = new FlagStates();
        when(gameState.getFlags()).thenReturn(flagStates);
        when(commandParser.parseCommand("USE TARGET")).thenReturn("USE");
        when(commandParser.parseTarget("USE TARGET")).thenReturn("TARGET");
        engine.parseCommand("USE TARGET");
        verify(eventHandler).handleUsageEvent(anyString(), any(GameState.class));
    }
    
    @Test
    public void takeCommandCallsEventHandler() {
        FlagStates flagStates = new FlagStates();
        when(gameState.getFlags()).thenReturn(flagStates);
        when(commandParser.parseCommand("TAKE TARGET")).thenReturn("TAKE");
        when(commandParser.parseTarget("TAKE TARGET")).thenReturn("TARGET");
        Inventory inventory = new Inventory();
        when(gameState.getInventory()).thenReturn(inventory);
        when(areaParser.hasItem(any(Area.class), anyString())).thenReturn(true);
        InventoryMessage message = (InventoryMessage) engine.parseCommand("TAKE TARGET");
        assertEquals("You picked up TARGET", message.getMessage());

    }
    
    @Test
    public void inspectCommandCallsItemInfoParser() {
       FlagStates flagStates = new FlagStates();
        when(gameState.getFlags()).thenReturn(flagStates);
        when(commandParser.parseCommand("INSPECT TARGET")).thenReturn("INSPECT");
        when(commandParser.parseTarget("INSPECT TARGET")).thenReturn("TARGET");
        engine.parseCommand("INSPECT TARGET");
        verify(itemInfoParser).parseItemInfo(anyString(), any(GameState.class));
    }
       
    @Test
    public void setTutorialModeSetsTutorial() {
        engine.setTutorialMode();
        verify(gameState).setIsTutorial(true);
    }
    
    @Test
    public void getCurrentAreaGetCurrentArea() {
        engine.getCurrentRoom();
        verify(gameState).getCurrentArea();
    }
 
    // special cases and error tests
    
    @Test
    public void over50TurnsReturnsGameOver() {
        when(gameState.getTurns()).thenReturn(26);
        Event mockEvent = new Event("GAME OVER");
        when(eventHandler.gameOverEvent()).thenReturn(mockEvent);
        Event event = (Event) engine.parseCommand("GOTO TARGET");
        verify(eventHandler).gameOverEvent();
    }
    
    @Test
    public void engineReturnsCorrectEventWhenGameHasEnded() {
        FlagStates flagStates = new FlagStates();
        flagStates.setGameOver(true);
        when(gameState.getFlags()).thenReturn(flagStates);
        when(gameState.getTurns()).thenReturn(1);
        Event mockEvent = new Event("GAME OVER");
        when(eventHandler.gamehasEndedEvent()).thenReturn(mockEvent);
        Event event = (Event) engine.parseCommand("GOTO TARGET");
        verify(eventHandler).gamehasEndedEvent();
    }
    
}
