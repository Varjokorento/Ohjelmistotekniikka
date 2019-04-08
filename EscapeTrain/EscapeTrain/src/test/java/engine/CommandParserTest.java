/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import com.mycompany.escapetrain.engine.CommandParser;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Administrator
 */
public class CommandParserTest {
    private CommandParser parser;
    String command = "GOTO CABIN";
    
    @Before
    public void init() {
        this.parser = new CommandParser();
    }
    
    
    @Test
    public void parseCommandReturnsCommand() {
        String output = parser.parseCommand(command);
        assertEquals("GOTO", output);
    }
    
    @Test
    public void parseCommandReturnsCorrectTarget() {
        String output = parser.parseTarget(command);
        assertEquals("CABIN", output);
    }
    
}
