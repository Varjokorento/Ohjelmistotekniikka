/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

import com.mycompany.escapetrain.gameobjects.events.GameOver;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Administrator
 */
public class GameOverTest {
    private GameOver over;
    
    @Before
    public void init() {
        this.over = new GameOver();
    }
    
    @Test
    public void constructingGameOverSetsObjecTypeAsEvent() {
        String event = "EVENT";
        assertEquals(event, over.getObjectType());
    }
    
    
}
