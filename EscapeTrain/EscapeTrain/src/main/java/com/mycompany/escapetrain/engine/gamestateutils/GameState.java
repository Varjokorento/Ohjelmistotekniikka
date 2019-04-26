
package com.mycompany.escapetrain.engine.gamestateutils;

import com.mycompany.escapetrain.gameobjects.area.Area;
import com.mycompany.escapetrain.gameobjects.inventory.Inventory;

/**
 *
 * Class is the representation of the current game's states
 * Includes inventory, flagstates (i.e what has already occurred in the game and what is to occur)
 * 
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
    
    /**
    * Method returns true if the game is in an error state and false if not
    *
    * @return is the Game in Error state
    */

    public boolean isError() {
        return error;
    }
    /**
    * Method returns true if the game is in an error state and false if not
    * @param error the boolean value for error
    * @return is the Game in Error state
    */
    public void setError(boolean error) {
        this.error = error;
    }
    
    /**
    * Method returns the FlagStates of the game (i.e is a door open and so on)
    *
    * @return the flags of the game
    */
    
    public FlagStates getFlags() {
        return this.flagStates;
    }
    
    /**
    * Method returns the current area
    *
    * @return the current area
    */
    
    public Area getCurrentArea() {
        return currentArea;
    }
    
    /**
    * Method sets the current area
    * @param the Area
    * 
    */
    public void setCurrentArea(Area currentArea) {
        this.currentArea = currentArea;
    }
    
    /**
    * Method returns the turns in the game.
    *
    * @return the amount of turns that have passed
    */

    public int getTurns() {
        return turns;
    }
    
    /**
    * Method returns the boolean value of whether the game is in tutorial mode or not
    * @return the boolean is Tutorial
    */

    public boolean isIsTutorial() {
        return isTutorial;
    }

    /**
    * Method sets tutorial mode on/off
    * @param boolean isTutorial
    */
    public void setIsTutorial(boolean isTutorial) {
        this.isTutorial = isTutorial;
    }
    
        
    /**
    * Method returns the FlagStates of the game (i.e is a door open and so on)
    *
    * @return the flags of the game
    */
    

    public FlagStates getFlagStates() {
        return flagStates;
    }
    
        
    /**
    * Method sets the flagstates of the game
    *
    * @params the flagstates of the game
    */
    

    public void setFlagStates(FlagStates flagStates) {
        this.flagStates = flagStates;
    }
    
    /**
    * Method sets the turns for the game
    *
    * @params int value of the turns
    */
    public void setTurns(int turns) {
        this.turns = turns;
    }
    
    /**
     * Method increments the amount of turns by one
     */

    public void incrementTurns() {
        this.turns = turns + 1;
    }
    
    /**
     * Method returns the current inventory of the game
     * @return Inventory 
     */

    public Inventory getInventory() {
        return inventory;
    }
    /**
     * Method sets the current inventory of the game
     * @param inventory 
     */

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    
    /**
     * Method checks whether certain item is in inventory and returns a boolean
     * @param item
     * @return boolean
     */
   
    public boolean isInInventory(String item) {
        return this.inventory.isItemInInventory(item);
    }
    
    
    
    
}
