package com.mycompany.escapetrain.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FXMLController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Label credits;
    @FXML
    private Label game;
    
    
    @FXML
    private TextArea textArea;
    
    @FXML
    private Label title;
    @FXML
    private Scene nextScreen;
    
    @FXML
    private Stage prevStage;
    
    public void setPrevStage(Stage stage) {
        this.prevStage = stage;
    }
    
   
    @FXML
    private void handleCreditsButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) label.getScene().getWindow();
        stage.setTitle("Credits"); 
        Pane myPane = null;
        myPane = FXMLLoader.load(getClass().getResource("/fxml/credits.fxml"));
        ObservableList<Node> nodes = myPane.getChildren();
        AnchorPane anchorPane = (AnchorPane) nodes.get(0);
        ObservableList<Node> anchorPaneNodes = anchorPane.getChildren();
        Label creditsText = (Label) anchorPaneNodes.get(1);
        creditsText.setWrapText(true);
        creditsText.setText("test test test test test testtest test  test test testtest test ");
        Scene scene = new Scene(myPane);
        stage.setScene(scene);
        stage.show();
    }
    
     @FXML
    private void handleTutorialButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) label.getScene().getWindow();
        stage.setTitle("Tutorial"); 
        Pane myPane = null;
        myPane = FXMLLoader.load(getClass().getResource("/fxml/credits.fxml"));
        Scene scene = new Scene(myPane);
        stage.setScene(scene);
        stage.show();
    }
    
  
    @FXML
    private void handleStartButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) label.getScene().getWindow();
        stage.setTitle("Game"); 
        Pane myPane = null;
        myPane = FXMLLoader.load(getClass().getResource("/fxml/game.fxml"));
        Scene scene = new Scene(myPane);
        stage.setScene(scene);
        stage.show();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
}
