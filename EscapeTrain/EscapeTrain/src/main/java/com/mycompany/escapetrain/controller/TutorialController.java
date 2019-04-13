/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.escapetrain.controller;

import com.mycompany.escapetrain.engine.GameEngine;
import com.mycompany.escapetrain.gameobjects.GameObject;
import com.mycompany.escapetrain.gameobjects.inventory.Item;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import com.mycompany.escapetrain.gameobjects.area.Area;
import com.mycompany.escapetrain.gameobjects.events.Event;
import com.mycompany.escapetrain.gameobjects.inventory.Inventory;
import com.mycompany.escapetrain.gameobjects.inventory.InventoryMessage;

/**
 *
 * @author Administrator
 */
public class TutorialController implements Initializable{

    private GameEngine engine;
    
    Color locationColor = Color.web("#E3AB59");
 
    
    @FXML
    private TextFlow output;
    
    @FXML
    private TextFlow inventory;
    
    @FXML
    private TextField commandInput;
    
    @FXML
    private ImageView imageResolve;
    
   @FXML
    private void handleBackButtonAction(ActionEvent event) throws IOException {
        Button button = (Button) event.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        stage.setTitle("Escape train"); 
        Pane myPane = null;
        myPane = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        Scene scene = new Scene(myPane);
        stage.setScene(scene);
        stage.show();
    }
    
     
    @FXML
    private void parseCommand(ActionEvent event)  {
         output.getChildren().clear();
         String input = commandInput.getText();
         commandInput.setText("");
         GameObject gameObject = engine.parseCommand(input);  
         updateInventoryView();
         updateDisplay(gameObject);
    }
    
    private void updateDisplay(GameObject gameObject) {
       
    }
    
     private void displayArea(Area displayedArea) {
        Text text1 = new Text("\nYou are in: ");
        Text text3 = new Text("Adjacent areas: ");
        Text text4 = new Text("Items in room: ");
        Text areaStyling = new Text(displayedArea.getSurroundingAreas() + "\n\n");
        Text text5 = new Text(displayedArea.getAreaName() + "\n\n");
        Text text2 = new Text(displayedArea.getDescription() + "\n\n");
        text1.setFill(Color.BLACK);
        text1.setStyle("-fx-font-weight: bold;");
        text5.setStyle("-fx-font-weight: bold;");
        text2.setFill(Color.BLACK);
        //imageResolve.setImage(new Image("main/resources/assets/pictures/train.jpg"));
        areaStyling.setFill(locationColor);
        output.getChildren().addAll(text1, text5, text3, areaStyling, text4, text2, new Text("\n\n"));
    }
    
    private void displayCurrentRoom() {
        displayArea(engine.getCurrentRoom());
    }
    
    private void displayNotAValidCommand() {
        Text text1 = new Text("\nNot a valid command");
        text1.setFill(Color.BLACK);
        text1.setStyle("-fx-font-weight: bold;");
        output.getChildren().addAll(text1, new Text("\n\n"));
    }
     
    private void updateInventoryView() {
        Inventory gameInventory = engine.getInventoryState();
        inventory.getChildren().clear();
        for (Item item : gameInventory.getItems()) {
            inventory.getChildren().addAll(new Text(item.getName()+"\n"));
        }
    }
    
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.engine = new GameEngine(); 
        try {
            engine.init();
        } catch (IOException ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
