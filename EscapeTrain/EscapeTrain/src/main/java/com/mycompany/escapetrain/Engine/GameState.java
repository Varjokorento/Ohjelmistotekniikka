/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.escapetrain.Engine;

import com.mycompany.escapetrain.GameObjects.Area.Area;

/**
 *
 * @author Administrator
 */
public class GameState {
    private Area currentArea;
    private int turns;
    private boolean error;
    public GameState() {
        this.currentArea = null;
        this.turns = 0;
        this.error = false;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
    

    public Area getCurrentArea() {
        return currentArea;
    }

    public void setCurrentArea(Area currentArea) {
        this.currentArea = currentArea;
    }

    public int getTurns() {
        return turns;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }

    public void incrementTurns() {
        this.turns = turns +1;
    }
   
    
    
    
}
