/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.escapetrain.datahandling;


/**
 * The service for calling DataClient. Is used to store information about
 * the amount of times the game has been won.
 * @author Administrator
 */
public class DataService {
    private DataClient dataClient;
    

    public DataService() {
        this.dataClient = new DataClient();
    }
    /**
     * 
     * @param dataClient    The Client that the service should use
     */
    public void setDataClient(DataClient dataClient) {
        this.dataClient = dataClient;
    }
    
    /**
     * Initialises the DataClient. 
     * 
     */
 
    public void init() {
        this.dataClient.init();
    }
    
    /**
     * Calls the dataClient addVictory method. Adds one victory.
     */
    
    public void addAVictory()  {
        this.dataClient.addVictory();
    }
    
    /**
     * Returns the total amount of victories for the player.
     * @return Integer  total amount of victories so far
     */
    
    public Integer getVictories() {
        return this.dataClient.getVictories();
    }
    
    
    
    
    
    
    
}
