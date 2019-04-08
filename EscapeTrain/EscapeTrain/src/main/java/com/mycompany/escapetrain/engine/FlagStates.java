/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.escapetrain.engine;

/**
 *
 * @author Administrator
 */
public class FlagStates {
    private boolean engineDoorOpen;
    private boolean windowOpen;
    private boolean gameOver;
    private boolean gameWon;

    public FlagStates() {
        this.engineDoorOpen = false;
        this.windowOpen = false;
    }

    public boolean isEngineDoorOpen() {
        return engineDoorOpen;
    }

    public void setEngineDoorOpen(boolean engineDoorOpen) {
        this.engineDoorOpen = engineDoorOpen;
    }

    public boolean isWindowOpen() {
        return windowOpen;
    }

    public void setWindowOpen(boolean windowOpen) {
        this.windowOpen = windowOpen;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public boolean isGameWon() {
        return gameWon;
    }

    public void setGameWon(boolean gameWon) {
        this.gameWon = gameWon;
    }
    
    
    
    
    
    
    
}
