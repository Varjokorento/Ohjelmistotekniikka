
package com.mycompany.escapetrain.gameobjects.inventory;

import com.mycompany.escapetrain.gameobjects.GameObject;

/**
 *
 * @author Administrator
 */
public class InventoryMessage implements GameObject {
    private String objectType;
    private String message;

    public InventoryMessage() {
        this.objectType = "ITEM";
    }

    
    
    @Override
    public String getObjectType() {
        return this.objectType;
    }

    @Override
    public void setObjectType(String type) {
        this.objectType = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
    
    
    
}
