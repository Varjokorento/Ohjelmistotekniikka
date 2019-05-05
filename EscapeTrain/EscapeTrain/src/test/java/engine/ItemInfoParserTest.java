/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import com.mycompany.escapetrain.engine.gamestateutils.GameState;
import com.mycompany.escapetrain.engine.parsers.ItemInfoParser;
import com.mycompany.escapetrain.gameobjects.events.Event;
import com.mycompany.escapetrain.gameobjects.inventory.Item;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Administrator
 */
public class ItemInfoParserTest {
    private ItemInfoParser parser;
    
    @Before
    public void init() throws IOException {
        this.parser = new ItemInfoParser();
        parser.init();
    }
    
    @Test
    public void itemInfoParserParsesCorrectValueIfItemNotInInventory() {
        GameState gameState = new GameState();
        Event event = (Event) parser.parseItemInfo("vodka", gameState);
        String expectedMessage = "What are you looking at? You don't have a vodka";
        assertEquals(expectedMessage, event.getEventMessage());
    }
    
    @Test
    public void itemInfoParserReturnsCorrectMessageForItem() {
        GameState gameState = new GameState();
        gameState.getInventory().addItem(new Item("vodka"));
        Event event = (Event) parser.parseItemInfo("vodka", gameState);
        String expectedMessage = "Looks pretty strong.";
        assertEquals(expectedMessage, event.getEventMessage());
    }
    
}
