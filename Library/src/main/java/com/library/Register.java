package com.library;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Register implements Initializable {

    @FXML
    private AnchorPane regiPane;

    @FXML
    private TextField regiID;


    @FXML
    private Button regiAdminBtn;

    @FXML
    private PasswordField regiPass;

    @FXML
    private Button regiStudentBtn;

    @FXML
    private Button insertImage;

    @FXML
    private Button regiBack;
    @FXML
    private ImageView insertImageView;

    public Image image;

    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void insertImage(){
        FileChooser open =new FileChooser();
        open.setTitle("Image File");
        open.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image file","*jpg","*png"));
        Stage stage=(Stage) regiPane.getScene().getWindow();

        File file=open.showOpenDialog(stage);

        if(file!=null){
            image=new Image(file.toURI().toString(),112,84,false,true);
            insertImageView.setImage(image);

            getData.path=file.getAbsolutePath();
//            changeProfile();
            showProfile();
        }
    }
    public void  changeProfile(){
        String uri=getData.path;
        uri.replace("\\","\\\\");

        String sql="UPDATE student SET image'"+uri+"'WHERE studentID='"+getData.studentID+"'";
        connect=Database.connectDB();
        try{
            statement=connect.createStatement();
            statement.executeUpdate(uri);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void showProfile(){
        String uri="file:"+getData.path;
        image=new Image(uri,133,166,false,true);
        insertImageView.setImage(image);
    }

    public void studentBtn(){
        String sql="INSERT INTO student VALUES(?,?,?)";
        connect=Database.connectDB();
        try{if(regiID.getText().isEmpty()||regiPass.getText().isEmpty()||insertImageView.getImage().toString().isEmpty()){
            Alert alert;
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Admin Message");
            alert.setHeaderText(null);
            alert.setContentText("Please give all details");
            alert.showAndWait();
        }else {
            String uri=getData.path;
            uri.replace("\\","\\\\");

            prepare = connect.prepareStatement(sql);
            prepare.setString(1, regiID.getText());
            prepare.setString(2, regiPass.getText());
            prepare.setString(3, uri);
            prepare.executeUpdate();

            Alert alert;
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Admin Message");
            alert.setHeaderText(null);
            alert.setContentText("Successfully added student");
            alert.showAndWait();
        }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void back(ActionEvent event) throws IOException {
        Stage mainStage = (Stage) ((Node) (event.getTarget())).getScene().getWindow();
        FXMLScene scene = FXMLScene.load("hello-view.fxml");
        Parent root = scene.root;
        HelloController us = (HelloController) scene.controller;
        mainStage.setScene(new Scene(root));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
