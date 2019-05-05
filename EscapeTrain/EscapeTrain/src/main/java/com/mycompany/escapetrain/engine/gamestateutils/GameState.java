
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
    private boolean isTutorial;
    private FlagStates flagStates;
    
    public GameState() {
        this.currentArea = null;
        this.turns = 0;
        this.inventory = new Inventory();
        this.flagStates = new FlagStates();
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
     * @param currentArea   the current area that will be displayed to player
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
    * @param isTutorial whether the game is in tutorial mode or not
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
    * Method sets the FlagStates of the game
    *
     * @param flagStates    the FlagStates of the game
    */
    

    public void setFlagStates(FlagStates flagStates) {
        this.flagStates = flagStates;
    }
    
    /**
    * Method sets the turns for the game
    *
     * @param turns how many turns has occurred
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
     * @param inventory The inventory that is to be used
     */

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    
    /**
     * Method checks whether certain item is in inventory and returns a boolean
     * @param item  The item that is checked
     * @return boolean  Whether the item is in player's inventory or not
     */
   
    public boolean isInInventory(String item) {
        return this.inventory.isItemInInventory(item);
    }
    
    
    
    
}
