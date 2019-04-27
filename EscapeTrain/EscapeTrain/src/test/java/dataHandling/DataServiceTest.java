/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataHandling;

import com.mycompany.escapetrain.dataHandling.DataClient;
import com.mycompany.escapetrain.dataHandling.DataService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author Administrator
 */
@RunWith(MockitoJUnitRunner.class)
public class DataServiceTest {
    @Mock
    private DataClient dataClient;
    
    private DataService dataService;
    
    @Before
    public void init() throws Exception {
        this.dataService = new DataService();
        dataService.init();
        dataService.setDataClient(dataClient);
    }
    
    @Test
    public void addVictoryCallsClientAddVictory() {
        this.dataService.addAVictory();
        verify(dataClient).addVictory();
    }
    
    @Test
    public void getVictoryCallsClientGetVictory() {
        this.dataService.getVictories();
        verify(dataClient).getVictories();
    }
}
