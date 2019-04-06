/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

import com.mycompany.escapetrain.gameobjects.events.Event;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Administrator
 */
public class eventTest {
    
    private Event event;
    
    @Before
    public void init() {
        this.event = new Event();
    }
    
    @Test
    public void setEventMessageSetsEventMessage() {
        String message = "message";
        event.setEventMessage(message);
        assertEquals(message, event.getEventMessage());
    }
    
    @Test
    public void setObjectTypeSetsObjectType() {
        String type = "type";
        event.setObjectType(type);
        assertEquals(type, event.getObjectType());
    }
}
