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
import com.mycompany.escapetrain.gameobjects.inventory.Inventory;
import com.mycompany.escapetrain.gameobjects.inventory.Item;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import org.mockito.Mock;
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
    public void useCommandCallsEventHandler() {
        FlagStates flagStates = new FlagStates();
        when(gameState.getFlags()).thenReturn(flagStates);
        when(commandParser.parseCommand("USE TARGET")).thenReturn("USE");
        when(commandParser.parseTarget("USE TARGET")).thenReturn("TARGET");
        engine.parseCommand("USE TARGET");
        verify(eventHandler).handleUsageEvent(anyString(), any(GameState.class));
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
 
    
    
}
