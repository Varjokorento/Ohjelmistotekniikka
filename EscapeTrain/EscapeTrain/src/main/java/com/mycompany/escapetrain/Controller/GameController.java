/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.escapetrain.Controller;

import com.mycompany.escapetrain.Engine.AreaParser;
import com.mycompany.escapetrain.Engine.CommandParser;
import com.mycompany.escapetrain.Engine.GameDataProcessor;
import com.mycompany.escapetrain.GameObjects.Area.Area;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

/**
 *
 * @author Administrator
 */
public class GameController implements Initializable{
    
    Color locationColor = Color.web("#E3AB59");
    
    private CommandParser commandParser;
    private AreaParser areaParser;
    private Map<Integer, Area> areas;
 
    
    @FXML
    private TextFlow output;
    
    @FXML
    private TextField commandInput;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.commandParser = new CommandParser();
        this.areaParser = new AreaParser();
        this.areas = GameDataProcessor.initializeAreas();
    }
    
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
         String input = commandInput.getText();
         String command = commandParser.parseCommand(input);
         String target = commandParser.parseTarget(input);
         String area = areaParser.parseArea(target);   
         displayArea(area);
    }
    
    private void displayArea(String area) {
        Area displayedArea = new Area(area, "scary place", null);
        Text text1 = new Text("\nYou are in: ");
        String borderAreas = areas.get(displayedArea.getSurroundingAreas().get(0)).getAreaName();
        Text text3 = new Text("Adjacent areas: ");
        Text areaStyling = new Text(borderAreas + "\n\n");
        Text text5 = new Text(displayedArea.getAreaName() + "\n\n");
        Text text2 = new Text(displayedArea.getDescription() + "\n\n");
        // Updating the location on map
        text1.setFill(Color.BLACK);
        text1.setStyle("-fx-font-weight: bold;");
        text5.setStyle("-fx-font-weight: bold;");
        text2.setFill(Color.BLACK);
        areaStyling.setFill(locationColor);
        output.getChildren().addAll(text1, text5, text3, areaStyling, text2, new Text("\n\n"));
    }
    
}
