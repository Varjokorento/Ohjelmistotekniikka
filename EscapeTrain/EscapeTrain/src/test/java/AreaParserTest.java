
import com.mycompany.escapetrain.engine.AreaParser;
import com.mycompany.escapetrain.gameobjects.area.Area;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class AreaParserTest {
    
    private AreaParser parser;
    
    
    @Before
    public void init() throws IOException {
        this.parser = new AreaParser();
        parser.init();
    }
    
    @Test
    public void areaParserReturnAnAreaForAValidString() {
        String parsedString ="LUGGAGE_ROOM";
        String returnedArea = parser.parseArea(parsedString).getAreaName();
        String expectedString ="LUGGAGE_ROOM";
        assertEquals(expectedString, returnedArea);
    }
    
    @Test
    public void areParserReturnsNullIfTheStringCannotBeParsedIntoAnAre() {
        String parsedString ="NOT_A_ROOM";
        Area returnedArea = parser.parseArea(parsedString);
        assertNull(returnedArea);
    }
    
    @Test
    public void areaGetFirstRoomReturnsFirstRoom() {
        Area expectedArea = parser.getFirstRoom();
        assertEquals("LUGGAGE_ROOM", expectedArea.getAreaName());
    }
    
  
}
