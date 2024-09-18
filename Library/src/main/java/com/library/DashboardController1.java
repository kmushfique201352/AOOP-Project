package com.library;

import javafx.animation.TranslateTransition;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;


public class DashboardController1 implements Initializable {

    @FXML
    private Button bars_btn;
    @FXML
    private Button arrow_btn;

    @FXML
    private ImageView insertImageView;
    @FXML
    private Button minimize;
    @FXML
    private Circle circle_image;
    @FXML
    private AnchorPane nav_form;
    @FXML
    private TableView<AvailableAdmin> save_tableView;

    @FXML
    private TableColumn<AvailableAdmin, String> adminName;
    @FXML
    private TableColumn<saveBook, String> col_saveTitle;
    @FXML
    private TableColumn<saveBook, String> col_saveAuthor;
    @FXML
    private TableColumn<saveBook, String> col_saveGenre;
    @FXML
    private TableColumn<saveBook, String> col_saveShelf;
    @FXML
    private ImageView save_imageView;
    @FXML
    private Button unsaveBtn;
    @FXML
    private Label take_studentID;
    @FXML
    private TextField take_firstName;
    @FXML
    private TextField take_lastName;
    @FXML
    private ComboBox<String> take_gender;
    @FXML
    private TextField take_bookTitle;
    @FXML
    private Label take_issueDate;
    @FXML
    private ImageView take_imageView;
    @FXML
    private Label take_titleLabel;
    @FXML
    private AnchorPane student_form;

    @FXML
    private Button studentBtn;
    @FXML
    private Label take_authorLabel;
    @FXML
    private Label take_genreLabel;
    @FXML
    private Label take_shelfNoLabel;
    @FXML
    private Button take_clearBtn;
    @FXML
    private Button take_takeBtn;
    @FXML
    private Label studentID_nav;
    @FXML
    private Button availableBooks_btn;
    @FXML
    private AnchorPane returnBooks_form;
    @FXML
    private TableView<studentIssueData> return_tableView;
    @FXML
    private TableColumn<studentIssueData, String> return_studentID;

    @FXML
    private TableColumn<studentIssueData, String> return_studentName;

    @FXML
    private TableColumn<studentIssueData, String> return_bookName;
    @FXML
    private TableColumn<studentIssueData, String> return_dateIssued;
    @FXML
    private TableColumn<studentIssueData, String> return_status;
    @FXML
    private ImageView return_imageView;
    @FXML
    private Button return_Btn;

    @FXML
    private Button returnBooks_btn;
    @FXML
    private Button saveBooks_btn;
    @FXML
    private Button edit_btn;
    @FXML
    private Button logout_btn;
    @FXML
    private AnchorPane availableBooks_form;
    @FXML
    private AnchorPane mainCenter_form;
    @FXML
    private TableView<availableBooks> availableBooks_table;
    @FXML
    private TableColumn<availableBooks, String> col_availableBooks_table_bookTitle;
    @FXML
    private TableColumn<availableBooks, String> col_availableBooks_table_author;
    @FXML
    private TableColumn<availableBooks, String> col_availableBooks_table_bookType;
    @FXML
    private TableColumn<availableBooks, String> col_availableBooks_table_shelf;
    @FXML
    private TableColumn<availableBooks, String> col_availableBooks_table_quantity;
    @FXML
    private ImageView availableBooks_image;
    @FXML
    private Button save_btn;
    @FXML
    private ImageView edit_icon;
    @FXML
    private AnchorPane halfNav_form;
    @FXML
    private Circle smallCircle_image;
    @FXML
    private AnchorPane savedBooks_form;
    @FXML
    private Button halfNav_availableBooks_btn;
    @FXML
    private Button halfNav_returnBooks_btn;
    @FXML
    private Button halfNav_saveBooks_btn;
    @FXML
    private Button take_btn;
    @FXML
    private Label availableBooks_title;
    @FXML
    private Label currentForm_label;
    @FXML
    private TextField ab_bookTitle;

    @FXML
    private TextField ID;
    @FXML
    private TableView<AllIssued> taken_tableView;

    @FXML
    private TableColumn<AllIssued,String> taken_studentID;

    @FXML
    private TableColumn<AllIssued,String> taken_bookName;

    @FXML
    private TextField ab_author;

    @FXML
    private TextField ab_bookType;

    @FXML
    private TextField ab_shelf;

    @FXML
    private TextField ab_quantity;
    @FXML
    private Label file_path;

    @FXML
    private Button insert_btn;

    @FXML
    private AnchorPane regiPane;

    @FXML
    private TextField regiID;

    @FXML
    private TextField regiPass;

    @FXML
    private Button RegisterBtn;

    @FXML
    private Button add_cover;
    @FXML
    private AnchorPane detailsPane;
    @FXML
    private TableView<AvailableStudents> student_tableView;

    @FXML
    private TableColumn<AvailableStudents, String> studentName;

    @FXML
    private ImageView student_ImageView_admin;

    @FXML
    private TextField ID2;











    @FXML
    public void minimize(){
        Stage stage=(Stage) minimize.getScene().getWindow();
        stage.setIconified(true);
    }
    @FXML
    public void exit(){
        System.exit(0);
    }



    private Image image;
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    private String comboBox[]={"Male","Female","Others"};





    public void sideNavButtonDesign(ActionEvent event){
        if(event.getSource()==halfNav_availableBooks_btn){
            availableBooks_form.setVisible(true);
            savedBooks_form.setVisible(false);
            returnBooks_form.setVisible(false);
            student_form.setVisible(false);

            availableBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #46589a, #4278a7);");
            returnBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            saveBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");

            halfNav_availableBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #46589a, #4278a7);");
            halfNav_returnBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            halfNav_saveBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");

            currentForm_label.setText("Available Books");
        }else if(event.getSource()==halfNav_returnBooks_btn){
            availableBooks_form.setVisible(false);
            savedBooks_form.setVisible(false);
            returnBooks_form.setVisible(true);
            student_form.setVisible(false);

            availableBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            returnBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #46589a, #4278a7);");
            saveBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");

            halfNav_availableBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            halfNav_returnBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #46589a, #4278a7);");
            halfNav_saveBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");

            currentForm_label.setText("Return Books");

//            showReturnBooks();
        }else if(event.getSource()==halfNav_saveBooks_btn){
            availableBooks_form.setVisible(false);
            savedBooks_form.setVisible(true);
            returnBooks_form.setVisible(false);
            student_form.setVisible(false);

            availableBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            returnBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            saveBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #46589a, #4278a7);");

            halfNav_availableBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            halfNav_returnBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            halfNav_saveBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #46589a, #4278a7);");

            currentForm_label.setText("Saved Books");
        }else if(event.getSource()== studentBtn){

            availableBooks_form.setVisible(false);
            savedBooks_form.setVisible(false);
            returnBooks_form.setVisible(false);
            student_form.setVisible(true);

            availableBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            returnBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            saveBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            student_form.setStyle("-fx-background-color:linear-gradient(to bottom right, #46589a, #4278a7);");

            halfNav_availableBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            halfNav_returnBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            halfNav_saveBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #46589a, #4278a7);");

            currentForm_label.setText("Saved Books");

        }
    }
    public void navButtonDesign(ActionEvent event){
        if(event.getSource()== availableBooks_btn){

            availableBooks_form.setVisible(true);
            savedBooks_form.setVisible(false);
            returnBooks_form.setVisible(false);
            student_form.setVisible(false);

            availableBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #46589a, #4278a7);");
            returnBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            saveBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");

            halfNav_availableBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #46589a, #4278a7);");
            halfNav_returnBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            halfNav_saveBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");

            currentForm_label.setText("Available Books");

        }else if(event.getSource()== returnBooks_btn){

            availableBooks_form.setVisible(false);
            savedBooks_form.setVisible(false);
            returnBooks_form.setVisible(true);
            student_form.setVisible(false);

            availableBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            returnBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #46589a, #4278a7);");
            saveBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");

            halfNav_availableBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            halfNav_returnBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #46589a, #4278a7);");
            halfNav_saveBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");

            currentForm_label.setText("Return Books");
//            showReturnBooks();

        }else if(event.getSource()== saveBooks_btn){

            availableBooks_form.setVisible(false);
            savedBooks_form.setVisible(true);
            returnBooks_form.setVisible(false);
            student_form.setVisible(false);

            availableBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            returnBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            saveBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #46589a, #4278a7);");

            halfNav_availableBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            halfNav_returnBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            halfNav_saveBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #46589a, #4278a7);");

            currentForm_label.setText("Saved Books");

        }else if(event.getSource()== studentBtn){

            availableBooks_form.setVisible(false);
            savedBooks_form.setVisible(false);
            returnBooks_form.setVisible(false);
            student_form.setVisible(true);

            availableBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            returnBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            saveBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            student_form.setStyle("-fx-background-color:linear-gradient(to bottom right, #46589a, #4278a7);");

            halfNav_availableBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            halfNav_returnBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            halfNav_saveBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #46589a, #4278a7);");

            currentForm_label.setText("Saved Books");

        }
    }
    public void sliderArrow(){
        TranslateTransition slide=new TranslateTransition();

        slide.setDuration(Duration.seconds(.5));
        slide.setNode(nav_form);
        slide.setToX(-224);

        TranslateTransition slide1=new TranslateTransition();

        slide1.setDuration(Duration.seconds(.5));
        slide1.setNode(mainCenter_form);
        slide1.setToX(-224+90);

        TranslateTransition slide2=new TranslateTransition();
        slide2.setDuration(Duration.seconds(.5));
        slide2.setNode(halfNav_form);
        slide2.setToX(0);

        slide.setOnFinished((ActionEvent event)->{
            arrow_btn.setVisible(false);
            bars_btn.setVisible(true);
        });
        slide2.play();
        slide1.play();
        slide.play();
    }
    public void sliderBar(){
        TranslateTransition slide=new TranslateTransition();
        slide.setDuration(Duration.seconds(.5));
        slide.setNode(nav_form);
        slide.setToX(0);

        TranslateTransition slide1=new TranslateTransition();

        slide1.setDuration(Duration.seconds(.5));
        slide1.setNode(mainCenter_form);
        slide1.setToX(0);

        TranslateTransition slide2=new TranslateTransition();
        slide2.setDuration(Duration.seconds(.5));
        slide2.setNode(halfNav_form);
        slide2.setToX(-77);

        slide.setOnFinished((ActionEvent event)->{
            arrow_btn.setVisible(true);
            bars_btn.setVisible(false);
        });
        slide2.play();
        slide1.play();
        slide.play();
    }
    @FXML
    public void Logout(ActionEvent event){
        try{
            if(event.getSource()==logout_btn){
                Stage mainStage = (Stage) ((Node) (event.getTarget())).getScene().getWindow();
                FXMLScene scene = FXMLScene.load("hello-view.fxml");
                Parent root = scene.root;
                //1:49:41----
                HelloController us = (HelloController) scene.controller;
                mainStage.setScene(new Scene(root));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    public void insertImage(){
        FileChooser open =new FileChooser();
        open.setTitle("Image File");
        open.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image file","*jpg","*png"));
        Stage stage=(Stage) nav_form.getScene().getWindow();

        File file=open.showOpenDialog(stage);

        if(file!=null){
            image=new Image(file.toURI().toString(),112,84,false,true);
            circle_image.setFill(new ImagePattern(image));
            smallCircle_image.setFill(new ImagePattern(image));

            getData.path=file.getAbsolutePath();
            changeProfile();
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
        image=new Image(uri,112,84,false,true);
        circle_image.setFill(new ImagePattern(image));
        smallCircle_image.setFill(new ImagePattern(image));

    }



    public void studentID(){
        studentID_nav.setText(getData.adminID);
    }
    public void clearTakeData(){
        take_bookTitle.setText("");
        take_titleLabel.setText("");
        take_authorLabel.setText("");
        take_genreLabel.setText("");
        take_shelfNoLabel.setText("");
        take_imageView.setImage(null);
    }
    public void clearFindData(){
        take_titleLabel.setText("");
        take_authorLabel.setText("");
        take_genreLabel.setText("");
        take_shelfNoLabel.setText("");
        take_imageView.setImage(null);
    }




    public void showAvailableBooks(){
        listBook=dataList();

        col_availableBooks_table_bookTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        col_availableBooks_table_author.setCellValueFactory(new PropertyValueFactory<>("author"));
        col_availableBooks_table_bookType.setCellValueFactory(new PropertyValueFactory<>("genre"));
        col_availableBooks_table_shelf.setCellValueFactory(new PropertyValueFactory<>("shelf"));
        col_availableBooks_table_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        availableBooks_table.setItems(listBook);
    }

    public void selectAvailableBooks(){
        availableBooks bookData=availableBooks_table.getSelectionModel().getSelectedItem();
        int num=availableBooks_table.getSelectionModel().getFocusedIndex();

        if((num-1)<-1){
            return;
        }

        availableBooks_title.setText(bookData.getTitle());

        String uri="file:"+bookData.getImage();
        image=new Image(uri,133,166,false,true);
        availableBooks_image.setImage(image);

        getData.takeBookTitle=bookData.getTitle();

        getData.savedTitle=bookData.getTitle();
        getData.savedAuthor=bookData.getAuthor();
        getData.savedGenre=bookData.getGenre();
        getData.savedImage=bookData.getImage();
        getData.savedShelf=bookData.getShelf();
    }


//    public void displayDate(){
//        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
//        String date=format.format(new Date());
//
//        take_issueDate.setText(date);
//    }


    private ObservableList<availableBooks> listBook;
    public ObservableList<availableBooks> dataList(){

        ObservableList<availableBooks> listBooks= FXCollections.observableArrayList();

        String sql="SELECT * FROM book";

        connect =Database.connectDB();

        try{
            availableBooks aBooks;

            prepare=connect.prepareStatement(sql);
            result=prepare.executeQuery();

            while (result.next()){
                aBooks=new availableBooks(result.getString("bookTitle"),result.getString("author"),result.getString("bookType"),result.getString("image"),result.getString("shelf"),Integer.parseInt(result.getString("quantity")));
                listBooks.add(aBooks);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listBooks;
    }

//    public void gender(){
//
//        List<String> combo=new ArrayList<>();
//
//        for(String data:comboBox){
//            combo.add(data);
//        }
//        ObservableList list=FXCollections.observableList(combo);
//
//        take_gender.setItems(list);
//    }
    public void findBook(KeyEvent event){
//            clearFindData();
        if(event.getCode().equals((KeyCode.ENTER))) {
            String sql = "SELECT * FROM book WHERE bookTitle = '" + take_bookTitle.getText() + "'";
            connect = Database.connectDB();
            try {
                prepare = connect.prepareStatement(sql);
                result = prepare.executeQuery();
                boolean check = false;
                Alert alert;

                if (take_bookTitle.getText().isEmpty()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Admin Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Please select the book");
                    alert.showAndWait();
                } else {
                    while (result.next()) {
                        take_titleLabel.setText(result.getString("bookTitle"));
                        take_authorLabel.setText(result.getString("author"));
                        take_genreLabel.setText(result.getString("bookType"));
                        take_shelfNoLabel.setText(result.getString("shelf"));

                        getData.path = result.getString("image");
                        String uri = "file:" + getData.path;
                        image = new Image(uri, 133, 166, false, true);
                        take_imageView.setImage(image);

                        check = true;
                    }
                    if (!check) {
                        take_titleLabel.setText("The book is not available");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void takeBook(){

        Date date=new Date();
        java.sql.Date sqlDate=new java.sql.Date(date.getTime());

        String sql="INSERT INTO take VALUES(?,?,?,?,?,?,?,?,?,?)";
        connect=Database.connectDB();
        try{
            Alert alert;
            if (take_firstName.getText().isEmpty()||take_lastName.getText().isEmpty()||take_gender.getSelectionModel().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Please type complete student details");
                alert.showAndWait();
            } else if (take_titleLabel.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Please indicate the book you want to take");
                alert.showAndWait();
            }else{
                prepare=connect.prepareStatement(sql);
                prepare.setString(1,take_studentID.getText());
                prepare.setString(2,take_firstName.getText());
                prepare.setString(3,take_lastName.getText());
                prepare.setString(4,(String) take_gender.getSelectionModel().getSelectedItem());
                prepare.setString(5,take_titleLabel.getText());
                prepare.setString(6,take_authorLabel.getText());
                prepare.setString(7,take_genreLabel.getText());
                prepare.setString(8,getData.path);
                prepare.setDate(9,sqlDate);

                String check="Not Return";

                prepare.setString(10,check);
                prepare.executeUpdate();

                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully taken the book");
                alert.showAndWait();

                clearTakeData();
                clearFindData();
                take_firstName.setText(null);
                take_lastName.setText(null);
                take_gender.getSelectionModel().clearSelection();

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private ObservableList<ReturnBook> returnData;
//    public void showReturnBooks(){
//        returnData=returnBookData();
//
////        return_bookTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
////        return_author.setCellValueFactory(new PropertyValueFactory<>("author"));
////        return_bookType.setCellValueFactory(new PropertyValueFactory<>("genre"));
//        return_dateIssued.setCellValueFactory(new PropertyValueFactory<>("date"));
//
//        return_tableView.setItems(returnData);
//    }
    public void returnBooks(){
        String sql="UPDATE take SET checkReturn='Returned' WHERE bookTitle='" + getData.takeBookTitle + "'";

        connect=Database.connectDB();

        Alert alert;

        try{
            if(return_imageView.getImage()==null){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Please select the book you want to return");
                alert.showAndWait();
            }else {
                statement = connect.createStatement();
                statement.executeUpdate(sql);

                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully returned");
                alert.showAndWait();

//                showReturnBooks();
                return_imageView.setImage(null);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }







    public void adminAb_clear(){
        ab_bookTitle.setText("");
        ab_author.setText("");
        ab_bookType.setText("");
        ab_shelf.setText("");
        ab_quantity.setText("");
        availableBooks_image.setImage(null);
        file_path.setText("");
    }
    String cover;
    public void insertCover(){
        FileChooser open =new FileChooser();
        open.setTitle("Image File");
        open.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image file","*jpg","*png"));
        Stage stage=(Stage) detailsPane.getScene().getWindow();

        File file=open.showOpenDialog(stage);

        if(file!=null){
            System.out.println("IMAGE PATH: "+ file.getAbsolutePath());

            cover=getData.path=file.getAbsolutePath();
            image=new Image(file.toURI().toString(),100,120,false,true);

            availableBooks_image.setImage(image);
            file_path.setText(cover);
        }else{
            System.out.println("NO DATA EXIST");
        }
    }
    public void insert(){
        connect=Database.connectDB();
        String sql="INSERT INTO book VALUES(?,?,?,?,?,?)";
        Alert alert;
        try{
            if(ab_bookTitle.getText().isEmpty()){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Please select the book");
                alert.showAndWait();
            }else {
                String file=file_path.getText().replace("\\","\\\\");
                prepare = connect.prepareStatement(sql);
                prepare.setString(1, ab_bookTitle.getText());
                prepare.setString(2, ab_author.getText());
                prepare.setString(3, ab_bookType.getText());
                prepare.setString(4, file);
                prepare.setString(5, ab_shelf.getText());
                prepare.setString(6, ab_quantity.getText());

                prepare.executeUpdate();

                showAvailableBooks();
                adminAb_clear();

                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Added");
                alert.showAndWait();

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void update(){
        connect=Database.connectDB();

        String sql="UPDATE book SET `author`='"+ab_author.getText()
                +"',`bookType`='"+ab_bookType.getText()
                +"',`image`='"+file_path.getText()
                +"',`shelf`='"+ab_shelf.getText()
                +"',`quantity`='"+ab_quantity.getText()
                +"' WHERE `bookTitle`='"+availableBooks_title.getText()+"'";

        Alert alert;

        try{
            statement = connect.createStatement();
            statement.executeUpdate(sql);

            showAvailableBooks();
            adminAb_clear();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void delete(){
        connect=Database.connectDB();
        String sql="DELETE FROM book WHERE `bookTitle`='"+availableBooks_title.getText()+"'";
        Alert alert;
        try{
            if(availableBooks_title.getText().isEmpty()){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Please select the book");
                alert.showAndWait();
            }
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Admin Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you Sure?");
            Optional<ButtonType> option=alert.showAndWait();
            if(option.get()!=ButtonType.OK){
                return;
            }else{
                statement=connect.createStatement();
                statement.executeUpdate(sql);

                showAvailableBooks();
                adminAb_clear();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void selectAvailableBooks_admin(){
        availableBooks bookData=availableBooks_table.getSelectionModel().getSelectedItem();
        int num=availableBooks_table.getSelectionModel().getFocusedIndex();

        if((num-1)<-1){
            return;
        }

        availableBooks_title.setText(bookData.getTitle());

        getData.path=bookData.getImage();
        String uri="file:"+bookData.getImage();
        image=new Image(uri,133,166,false,true);
        availableBooks_image.setImage(image);
        file_path.setText(bookData.getImage());
        ab_bookTitle.setText(bookData.getTitle());
        ab_author.setText(bookData.getAuthor());
        ab_bookType.setText(bookData.getGenre());
        ab_shelf.setText(bookData.getShelf());
        ab_quantity.setText(String.valueOf(bookData.getQuantity()));

        getData.takeBookTitle=bookData.getTitle();

        getData.savedTitle=bookData.getTitle();
        getData.savedAuthor=bookData.getAuthor();
        getData.savedGenre=bookData.getGenre();
        getData.savedImage=bookData.getImage();
        getData.savedShelf=bookData.getShelf();


    }

    private ObservableList<studentIssueData> adminStudentList;
    public ObservableList<studentIssueData> adminStudentData(){
        ObservableList<studentIssueData> sIList=FXCollections.observableArrayList();

        String checkReturn="Not Return";

        String sql="SELECT * FROM take WHERE checkReturn='"+checkReturn+"'";

        connect=Database.connectDB();
        try{
            studentIssueData sIssue;

            statement=connect.createStatement();
            result=prepare.executeQuery(sql);

            while(result.next()){
                sIssue=new studentIssueData(result.getString("studentID"),result.getString("firstName"),result.getString("bookTitle"),result.getDate("date"),result.getString("checkReturn"));
                sIList.add(sIssue);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return sIList;
    }

    public void showNotReturnStudents(){
        adminStudentList=adminStudentData();

        return_studentID.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        return_studentName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        return_bookName.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        return_dateIssued.setCellValueFactory(new PropertyValueFactory<>("date"));
        return_status.setCellValueFactory(new PropertyValueFactory<>("checkReturn"));


        return_tableView.setItems(adminStudentList);
    }

    private ObservableList<AllIssued> adminAllstudentList;
    public ObservableList<AllIssued> adminAllstudentData(){
        ObservableList<AllIssued> sIList=FXCollections.observableArrayList();

        String sql="SELECT * FROM take";

        connect=Database.connectDB();
        try{
            AllIssued sIssue;

            statement=connect.createStatement();
            result=prepare.executeQuery(sql);

            while(result.next()){
                sIssue=new AllIssued(result.getString("studentID"),result.getString("bookTitle"));
                sIList.add(sIssue);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return sIList;
    }
    public void showAllIssuedStudents(){
        adminAllstudentList=adminAllstudentData();

        taken_studentID.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        taken_bookName.setCellValueFactory(new PropertyValueFactory<>("bookName"));

        taken_tableView.setItems(adminAllstudentList);

    }


    public void insertImageReg(){
        FileChooser open =new FileChooser();
        open.setTitle("Image File");
        open.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image file","*jpg","*png"));
        Stage stage=(Stage) regiPane.getScene().getWindow();

        File file=open.showOpenDialog(stage);

        if(file!=null){
            image=new Image(file.toURI().toString(),112,84,false,true);
            insertImageView.setImage(image);

            getData.path=file.getAbsolutePath();
//            changeProfileReg();
            showProfileReg();

        }
    }

    public void showProfileReg(){
        String uri="file:"+getData.path;
        image=new Image(uri,133,166,false,true);
        insertImageView.setImage(image);
    }
    public void adminBtn(){
        String sql="INSERT INTO admin VALUES(?,?,?)";
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

            Alert alert;

            prepare = connect.prepareStatement(sql);
            prepare.setString(1, regiID.getText());
            prepare.setString(2, regiPass.getText());
            prepare.setString(3, uri);
            prepare.executeUpdate();

            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Admin Message");
            alert.setHeaderText(null);
            alert.setContentText("Successfully added admin");
            alert.showAndWait();

            showAllAdmin();
        }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    private ObservableList<AvailableAdmin> allAdminList;
    public ObservableList<AvailableAdmin> allAdminData(){
        ObservableList<AvailableAdmin> sIList=FXCollections.observableArrayList();

        String sql="SELECT * FROM admin";

        connect=Database.connectDB();
        try{
            AvailableAdmin sIssue;

            statement=connect.createStatement();
            result=prepare.executeQuery(sql);

            while(result.next()){
                sIssue=new AvailableAdmin(result.getString("adminID"),result.getString("password"),result.getString("image"));
                sIList.add(sIssue);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return sIList;
    }
    public void showAllAdmin(){
        allAdminList=allAdminData();

        adminName.setCellValueFactory(new PropertyValueFactory<>("adminID"));

        save_tableView.setItems(allAdminList);

    }
    public void selectSaveBooks(){
        AvailableAdmin adminShow=save_tableView.getSelectionModel().getSelectedItem();
        int num=save_tableView.getSelectionModel().getFocusedIndex();

        if((num-1)<-1){
            return;
        }
        getData.adminID=adminShow.getAdminID();
        String uri="file:"+adminShow.getAdminImage();
        image=new Image(uri,133,166,false,true);
        save_imageView.setImage(image);
        ID.setText(getData.adminID);

        getData.savedImage=adminShow.getAdminImage();
    }
    public void deleteadmin(){
        connect=Database.connectDB();
        String sql="DELETE FROM admin WHERE `adminID`='"+ID.getText()+"'";
        Alert alert;
        try{
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Admin Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you Sure?");
            Optional<ButtonType> option=alert.showAndWait();
            if(option.get()!=ButtonType.OK){
                return;
            }else{
                statement=connect.createStatement();
                statement.executeUpdate(sql);

                showAllAdmin();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }





    private ObservableList<AvailableStudents> allStudentList;
    public ObservableList<AvailableStudents> allStudentData(){
        ObservableList<AvailableStudents> sIList=FXCollections.observableArrayList();

        String sql="SELECT * FROM student";

        connect=Database.connectDB();
        try{
            AvailableStudents sIssue;

            statement=connect.createStatement();
            result=prepare.executeQuery(sql);

            while(result.next()){
                sIssue=new AvailableStudents(result.getString("studentID"),result.getString("password"),result.getString("image"));
                sIList.add(sIssue);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return sIList;
    }
    public void showAllStudents(){
        allStudentList=allStudentData();

        studentName.setCellValueFactory(new PropertyValueFactory<>("studentID"));

        student_tableView.setItems(allStudentList);

    }
    public void selectStudents(){
        AvailableStudents studentShow=student_tableView.getSelectionModel().getSelectedItem();
        int num=student_tableView.getSelectionModel().getFocusedIndex();

        if((num-1)<-1){
            return;
        }
        getData.studentID=studentShow.getStudentID();
        String uri="file:"+studentShow.getImage();
        image=new Image(uri,133,166,false,true);
        student_ImageView_admin.setImage(image);
        ID2.setText(getData.studentID);

        getData.savedImage=studentShow.getImage();
    }
    public void deletestudent(){
        connect=Database.connectDB();
        String sql="DELETE FROM student WHERE `studentID`='"+ID2.getText()+"'";
        Alert alert;
        try{
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Admin Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you Sure?");
            Optional<ButtonType> option=alert.showAndWait();
            if(option.get()!=ButtonType.OK){
                return;
            }else{
                statement=connect.createStatement();
                statement.executeUpdate(sql);

                showAllStudents();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showAvailableBooks();
        showProfile();
//        studentIDLabel();
        studentID();
        showAllAdmin();
        showAllStudents();
//        displayDate();
//        gender();
        showNotReturnStudents();
        showAllIssuedStudents();

//        showSavedBooks();
    }
}
