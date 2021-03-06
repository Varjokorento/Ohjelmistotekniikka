
package com.mycompany.escapetrain.engine.gamestateutils;

/**
 *
 * Class is the representation of what has occurred in the game and what will occur. It also sets the flags when
 * events occur
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
     * @return boolean  whether door is open or not
     */

    public boolean isEngineDoorOpen() {
        return engineDoorOpen;
    }
    
     /**
     * Method checks whether the dynamite has been set
     * 
     * @return boolean  whether dynamite has been set or not
     */

    public boolean isDynamiteSet() {
        return dynamiteSet;
    }
    /**
     * sets whether dynamite is set or not
     * @param dynamiteSet   value for whether dynamite is set
     */
    
    public void setDynamiteSet(boolean dynamiteSet) {
        this.dynamiteSet = dynamiteSet;
    }
    /**
     * sets whether engine door is open or not
     * @param engineDoorOpen    value for whether engine door is open or not
     */

    public void setEngineDoorOpen(boolean engineDoorOpen) {
        this.engineDoorOpen = engineDoorOpen;
    }
    
    /**
     * checks whether game is over or not
     * @return boolean value for whether game is over or not
     */

    public boolean isGameOver() {
        return gameOver;
    }
    
    /**
     * sets whether game is over nor not
     * @param gameOver   is game Over 
     */

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    /**
     * checks whether game is won or not
     * @return boolean  is game won or not
     */
    public boolean isGameWon() {
        return gameWon;
    }
    /**
     * sets whether game is won nor not
     * @param gameWon    Is game won
     */
    
    public void setGameWon(boolean gameWon) {
        this.gameWon = gameWon;
    }
    
    
    
    
    
    
    
    
    
}
