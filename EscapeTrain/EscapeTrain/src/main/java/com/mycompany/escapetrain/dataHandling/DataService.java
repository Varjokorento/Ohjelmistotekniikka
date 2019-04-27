/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.escapetrain.dataHandling;

import java.io.IOException;

/**
 *
 * @author Administrator
 */
public class DataService {
    private DataClient dataClient;

    public DataService() {
        this.dataClient = new DataClient();
    }

    public void setDataClient(DataClient dataClient) {
        this.dataClient = dataClient;
    }
    
 
    public void init(){
        this.dataClient.init();
    }
    
    public void addAVictory()  {
        this.dataClient.addVictory();
    }
    
    public Integer getVictories() {
        return this.dataClient.getVictories();
    }
    
    
    
    
    
    
    
}
