package com.library;

import com.itextpdf.kernel.pdf.PdfDocument;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;


public class HelloController implements Initializable {
    @FXML
    private TextField studentID;


    @FXML
    private PasswordField password_s;

    @FXML
    private Button loginBtn_s;

    @FXML
    private Button minimize;
    @FXML
    private AnchorPane studentLogin;
    @FXML
    private AnchorPane studentPane;

    @FXML
    private AnchorPane registerPane;

    @FXML
    private AnchorPane adminPane;
    @FXML
    private TextField adminID;

    @FXML
    private TextField password_a;

    @FXML
    private Button loginBtn_a;
    @FXML
    private AnchorPane adminLogin;

    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    private Stage stage;
    private Scene scene;
    private Parent root;
    boolean check=false;



    @FXML
    void Adminlogin(ActionEvent event)throws IOException {
        String sql="SELECT * FROM admin WHERE adminID=? and password=?";
        connect=Database.connectDB();

        try{
            prepare=connect.prepareStatement(sql);
            prepare.setString(1,adminID.getText());
            prepare.setString(2,password_a.getText());
            result=prepare.executeQuery();

            Alert alert;

            if(adminID.getText().isEmpty()||password_a.getText().isEmpty()){
                alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            }else{
                if(result.next()){

                    getData.adminID=adminID.getText();
                    getData.path=result.getString("image");

                    alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Admin Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Login!");
                    alert.showAndWait();

                    Stage mainStage = (Stage) ((Node) (event.getTarget())).getScene().getWindow();
                    FXMLScene scene = FXMLScene.load("dashboard1.fxml");
                    Parent root = scene.root;
                    DashboardController1 us = (DashboardController1) scene.controller;
                    mainStage.setScene(new Scene(root));
                }else{
                    alert=new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Admin Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Wrong Username or Password");
                    alert.showAndWait();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void register(MouseEvent event)throws IOException{
        Stage mainStage = (Stage) ((Node) (event.getTarget())).getScene().getWindow();
        FXMLScene scene = FXMLScene.load("register.fxml");
        Parent root = scene.root;
        Register us = (Register) scene.controller;
        mainStage.setScene(new Scene(root));
    }

    @FXML
    void login(ActionEvent event)throws IOException {
        String sql="SELECT * FROM student WHERE studentID=? and password=?";
        connect=Database.connectDB();

        try{
            prepare=connect.prepareStatement(sql);
            prepare.setString(1,studentID.getText());
            prepare.setString(2,password_s.getText());
            result=prepare.executeQuery();

            Alert alert;

            if(studentID.getText().isEmpty()||password_s.getText().isEmpty()){
                alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            }else{
                if(result.next()){

                    getData.studentID=studentID.getText();
                    getData.path=result.getString("image");

                    alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Admin Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Login!");
                    alert.showAndWait();

                        Stage mainStage = (Stage) ((Node) (event.getTarget())).getScene().getWindow();
                        FXMLScene scene = FXMLScene.load("dashboard2.fxml");
                        Parent root = scene.root;
                        DashboardController us = (DashboardController) scene.controller;
                        mainStage.setScene(new Scene(root));
                }else{
                    alert=new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Admin Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Wrong Username or Password");
                    alert.showAndWait();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void numbersOnlyAdmin(KeyEvent event){
        if(event.getCharacter().matches("[^\\e\t\r\\d+$]")){
            event.consume();

            adminID.setStyle("-fx-border-color:#e04040");
        }else{
            adminID.setStyle("-fx-border-color:#fff");
        }
    }
    public void numbersOnly(KeyEvent event){
        if(event.getCharacter().matches("[^\\e\t\r\\d+$]")){
            event.consume();

            studentID.setStyle("-fx-border-color:#e04040");
        }else{
            studentID.setStyle("-fx-border-color:#fff");
        }
    }

    @FXML
    public void minimize(){
        Stage stage=(Stage) minimize.getScene().getWindow();
        stage.setIconified(true);
    }
    @FXML
    public void UpperButtonHover(MouseEvent event){
        if(event.getSource()==studentPane){
            studentLogin.setVisible(true);
            adminLogin.setVisible(false);
            studentPane.setStyle("-fx-background-color: #2a5172;");
            adminPane.setStyle("-fx-background-color:linear-gradient(to bottom right, #252d50, #324f5b)");

        }else if(event.getSource()==adminPane){
            studentLogin.setVisible(false);
            adminLogin.setVisible(true);
            studentPane.setStyle("-fx-background-color:linear-gradient(to bottom right, #252d50, #324f5b)");
            adminPane.setStyle("-fx-background-color: #2a5172;");
        }
    }

    @FXML
    public void exit(){
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}