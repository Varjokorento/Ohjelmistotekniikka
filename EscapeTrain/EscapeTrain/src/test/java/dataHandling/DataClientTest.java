/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataHandling;

import com.mycompany.escapetrain.datahandling.DataClient;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Administrator
 */
public class DataClientTest {
    
    private DataClient dataClient;
    
    @Before
    public void init() throws IOException {
        this.dataClient = new DataClient(); 
        dataClient.init();
    }
    
    
    @Test
    public void getVictoriesGetsVictories() {
        int number = dataClient.getVictories();
        assertNotNull(number);
    }
    
    @Test
    public void addVictoriesAddsVictories() throws IOException {
        int number = dataClient.getVictories();
        dataClient.addVictory();
        int numberAfterAdd = dataClient.getVictories();
        int difference = numberAfterAdd - number;
        assertEquals(1, difference);
        
        // this next part is just so that the test update won't be stored permanently
       dataClient.deleteVictory();
       numberAfterAdd = dataClient.getVictories();
       difference = numberAfterAdd - number;
       assertEquals(0, difference);
    }
}
