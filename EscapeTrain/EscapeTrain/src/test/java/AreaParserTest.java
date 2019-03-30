
import com.mycompany.escapetrain.Engine.AreaParser;
import static org.junit.Assert.assertEquals;
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
    public void init() {
        this.parser = new AreaParser();
    }
    
    @Test
    public void areaParserReturnAnAreaForAValidString() {
        String parsedString ="NEXT_ROOM";
        String returnedArea = parser.parseArea(parsedString);
        String expectedString ="NEXT_ROOM";
        assertEquals(expectedString, returnedArea);
    }
    
}
