package com.library;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FXMLScene {
    Parent root = null;
    Object controller = null;
    public static FXMLScene load(String fxml) throws IOException {
        FXMLScene fxmlScene = new FXMLScene();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(fxmlScene.getClass().getResource(fxml));

        fxmlScene.root =  fxmlLoader.load();
        fxmlScene.controller = fxmlLoader.getController();

        return fxmlScene;
    }
}


