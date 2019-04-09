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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Matchers.anyString;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
    
  /*  @Test
    public void parseGotoCommandReturnsARoomForValidCommand() {
        String command = "GOTO CABIN";
        engine.parseCommand(command);
        when(commandParser.parseCommand(command)).thenReturn("GOTO");   
        when(commandParser.parseTarget(command)).thenReturn("CABIN");
        when(gameState.isError()).thenReturn(false);
        verify(areaParser).parseArea(anyString());
    }*/
    
}
