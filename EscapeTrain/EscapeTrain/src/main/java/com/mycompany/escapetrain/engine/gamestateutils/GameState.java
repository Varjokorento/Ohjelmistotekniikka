/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.escapetrain.engine.gamestateutils;

import com.mycompany.escapetrain.gameobjects.area.Area;
import com.mycompany.escapetrain.gameobjects.inventory.Inventory;

/**
 *
 * @author Administrator
 */
public class GameState {
    private Area currentArea;
    private Inventory inventory;
    private int turns;
    private boolean error;
    private boolean isTutorial;
    private FlagStates flagStates;
    
    public GameState() {
        this.currentArea = null;
        this.turns = 0;
        this.error = false;
        this.inventory = new Inventory();
        this.flagStates = new FlagStates();
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
    
    public FlagStates getFlags() {
        return this.flagStates;
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

    public boolean isIsTutorial() {
        return isTutorial;
    }

    public void setIsTutorial(boolean isTutorial) {
        this.isTutorial = isTutorial;
    }

    public FlagStates getFlagStates() {
        return flagStates;
    }

    public void setFlagStates(FlagStates flagStates) {
        this.flagStates = flagStates;
    }
    
    

    public void setTurns(int turns) {
        this.turns = turns;
    }

    public void incrementTurns() {
        this.turns = turns + 1;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
   
    public boolean isInInventory(String item) {
        return this.inventory.isItemInInventory(item);
    }
    
    
    
    
}
