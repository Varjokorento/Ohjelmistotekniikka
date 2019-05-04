/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.escapetrain.engine.gamestateutils;

/**
 *
 * Class is the representation of what has occurred in the game and what will occur. It also sets the flags when
 * events occurr
 */
public class FlagStates {
    private boolean engineDoorOpen;
    private boolean gameOver;
    private boolean gameWon;
    private boolean dynamiteSet;

    public FlagStates() {
        this.engineDoorOpen = false;
        this.gameOver = false;
        this.dynamiteSet = false;
        this.gameWon = false;
    }
    
    /**
     * Method checks whether the engine door is open
     * 
     * @return boolean
     */

    public boolean isEngineDoorOpen() {
        return engineDoorOpen;
    }
    
     /**
     * Method checks whether the dynamite has been set
     * 
     * @return boolean
     */

    public boolean isDynamiteSet() {
        return dynamiteSet;
    }
    /**
     * sets whether dynamite is set or not
     * @param dynamiteSet 
     */
    
    public void setDynamiteSet(boolean dynamiteSet) {
        this.dynamiteSet = dynamiteSet;
    }
    /**
     * sets whether engine door is open or not
     * @param engineDoorOpen 
     */

    public void setEngineDoorOpen(boolean engineDoorOpen) {
        this.engineDoorOpen = engineDoorOpen;
    }
    
    /**
     * checks whether game is over or not
     * @return boolean
     */

    public boolean isGameOver() {
        return gameOver;
    }
    
    /**
     * sets whether game is over nor not
     * @param boolean gameOver 
     */

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    /**
     * checks whether game is won or not
     * @return boolean
     */
    public boolean isGameWon() {
        return gameWon;
    }
    /**
     * sets whether game is won nor not
     * @param boolean gameWon
     */
    
    public void setGameWon(boolean gameWon) {
        this.gameWon = gameWon;
    }
    
    
    
    
    
    
    
    
    
}
