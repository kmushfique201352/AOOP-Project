package com.library;

import com.itextpdf.kernel.colors.Color;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.security.cert.Extension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    @FXML
    private Button bars_btn;
    @FXML
    private Button arrow_btn;
    @FXML
    private Button minimize;
    @FXML
    private Circle circle_image;
    @FXML
    private AnchorPane nav_form;
    @FXML
    private TableView<saveBook> save_tableView;
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
    private TableView<ReturnBook> return_tableView;
    @FXML
    private TableColumn<ReturnBook, String> return_bookTitle;
    @FXML
    private TableColumn<ReturnBook, String> return_author;
    @FXML
    private TableColumn<ReturnBook, String> return_bookType;
    @FXML
    private TableColumn<ReturnBook, String> return_dateIssued;
    @FXML
    private ImageView return_imageView;
    @FXML
    private Button return_Btn;
    @FXML
    private Button issueBooks_btn;
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
    private AnchorPane issue_form;
    @FXML
    private AnchorPane savedBooks_form;
    @FXML
    private Button halfNav_availableBooks_btn;
    @FXML
    private Button halfNav_takenBooks_btn;
    @FXML
    private Button halfNav_returnBooks_btn;
    @FXML
    private Button halfNav_saveBooks_btn;
    @FXML
    private Button take_btn;
    @FXML
    private Label availableBooks_title;
    @FXML
    private Label take_quantity;
    @FXML
    private Label currentForm_label;










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
            issue_form.setVisible(false);
            availableBooks_form.setVisible(true);
            savedBooks_form.setVisible(false);
            returnBooks_form.setVisible(false);

            availableBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #46589a, #4278a7);");
            issueBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            returnBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            saveBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");

            halfNav_availableBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #46589a, #4278a7);");
            halfNav_takenBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            halfNav_returnBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            halfNav_saveBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");

            currentForm_label.setText("Available Books");
        }else if(event.getSource()==halfNav_takenBooks_btn){
            issue_form.setVisible(true);
            availableBooks_form.setVisible(false);
            savedBooks_form.setVisible(false);
            returnBooks_form.setVisible(false);

            availableBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            issueBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #46589a, #4278a7);");
            returnBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            saveBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");

            halfNav_availableBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            halfNav_takenBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #46589a, #4278a7);");
            halfNav_returnBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            halfNav_saveBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");

            currentForm_label.setText("Issue Books");
        }else if(event.getSource()==halfNav_returnBooks_btn){
            issue_form.setVisible(false);
            availableBooks_form.setVisible(false);
            savedBooks_form.setVisible(false);
            returnBooks_form.setVisible(true);

            availableBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            issueBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            returnBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #46589a, #4278a7);");
            saveBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");

            halfNav_availableBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            halfNav_takenBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            halfNav_returnBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #46589a, #4278a7);");
            halfNav_saveBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");

            currentForm_label.setText("Return Books");

            showReturnBooks();
        }else if(event.getSource()==halfNav_saveBooks_btn){
            issue_form.setVisible(false);
            availableBooks_form.setVisible(false);
            savedBooks_form.setVisible(true);
            returnBooks_form.setVisible(false);

            availableBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            issueBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            returnBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            saveBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #46589a, #4278a7);");

            halfNav_availableBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            halfNav_takenBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            halfNav_returnBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            halfNav_saveBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #46589a, #4278a7);");

            currentForm_label.setText("Saved Books");
        }
    }
    public void navButtonDesign(ActionEvent event){
        if(event.getSource()== availableBooks_btn){

            issue_form.setVisible(false);
            availableBooks_form.setVisible(true);
            savedBooks_form.setVisible(false);
            returnBooks_form.setVisible(false);

            availableBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #46589a, #4278a7);");
            issueBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            returnBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            saveBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");

            halfNav_availableBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #46589a, #4278a7);");
            halfNav_takenBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            halfNav_returnBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            halfNav_saveBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");

            currentForm_label.setText("Available Books");

        }else if(event.getSource()== issueBooks_btn){

            issue_form.setVisible(true);
            availableBooks_form.setVisible(false);
            savedBooks_form.setVisible(false);
            returnBooks_form.setVisible(false);

            availableBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            issueBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #46589a, #4278a7);");
            returnBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            saveBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");

            halfNav_availableBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            halfNav_takenBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #46589a, #4278a7);");
            halfNav_returnBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            halfNav_saveBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");

            currentForm_label.setText("Issue Books");

        }else if(event.getSource()== returnBooks_btn){

            issue_form.setVisible(false);
            availableBooks_form.setVisible(false);
            savedBooks_form.setVisible(false);
            returnBooks_form.setVisible(true);

            availableBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            issueBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            returnBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #46589a, #4278a7);");
            saveBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");

            halfNav_availableBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            halfNav_takenBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            halfNav_returnBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #46589a, #4278a7);");
            halfNav_saveBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");

            currentForm_label.setText("Return Books");
            showReturnBooks();

        }else if(event.getSource()== saveBooks_btn){

            issue_form.setVisible(false);
            availableBooks_form.setVisible(false);
            savedBooks_form.setVisible(true);
            returnBooks_form.setVisible(false);

            availableBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            issueBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            returnBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            saveBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #46589a, #4278a7);");

            halfNav_availableBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            halfNav_takenBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
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
        studentID_nav.setText(getData.studentID);
    }
    public void studentIDLabel(){
        take_studentID.setText(getData.studentID);
    }
    public void clearTakeData(){
//        take_bookTitle.setText("");
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
    public void availableBooks_TakeButton(ActionEvent event){
        if(event.getSource()==take_btn){
            issue_form.setVisible(true);
            availableBooks_form.setVisible(false);
            savedBooks_form.setVisible(false);
            returnBooks_form.setVisible(false);

            availableBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            issueBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #46589a, #4278a7);");
            returnBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            saveBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");

            halfNav_availableBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            halfNav_takenBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #46589a, #4278a7);");
            halfNav_returnBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");
            halfNav_saveBooks_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #344275, #3a6389);");

            currentForm_label.setText("Issue Books");
        }
    }

    public void displayDate(){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String date=format.format(new Date());

        take_issueDate.setText(date);
    }


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

    public void gender(){

        List<String> combo=new ArrayList<>();

        for(String data:comboBox){
            combo.add(data);
        }
        ObservableList list=FXCollections.observableList(combo);

        take_gender.setItems(list);
    }
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
                        take_quantity.setText(result.getString("quantity"));

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

        String sql="INSERT INTO take VALUES(?,?,?,?,?,?,?,?,?)";
        connect=Database.connectDB();
        try{
            Alert alert;
            if (take_firstName.getText().isEmpty()||take_gender.getSelectionModel().isEmpty()) {
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
            }else if(Integer.valueOf(take_quantity.getText())==0){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Book out of stock");
                alert.showAndWait();
            } else{
                decreaseQuantity();
                prepare=connect.prepareStatement(sql);
                prepare.setString(1,take_studentID.getText());
                prepare.setString(2,take_firstName.getText());
//                prepare.setString(3,take_lastName.getText());
                prepare.setString(3,(String) take_gender.getSelectionModel().getSelectedItem());
                prepare.setString(4,take_titleLabel.getText());
                prepare.setString(5,take_authorLabel.getText());
                prepare.setString(6,take_genreLabel.getText());
                prepare.setString(7,getData.path);
                prepare.setDate(8,sqlDate);

                String check="Not Return";

                prepare.setString(9,check);
                prepare.executeUpdate();
                showAvailableBooks();

                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully taken the book");
                alert.showAndWait();


                print(take_studentID.getText(),take_firstName.getText(),take_bookTitle.getText(),sqlDate);



                clearTakeData();
                clearFindData();
                take_firstName.setText(null);
//                take_lastName.setText(null);
                take_gender.getSelectionModel().clearSelection();

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void decreaseQuantity(){
        String sql="UPDATE book SET quantity=quantity-1 WHERE bookTitle='"+take_bookTitle.getText()+"'";
        connect=Database.connectDB();
        try{
            statement = connect.createStatement();
            statement.executeUpdate(sql);
        }catch (Exception e){

        }
    }
    public void increaseQuantity(){
        String sql="UPDATE book SET quantity=quantity+1 WHERE bookTitle='"+getData.takeBookTitle+"'";
        connect=Database.connectDB();
        try{
            statement=connect.createStatement();
            statement.executeUpdate(sql);
        }catch (Exception e){

        }
    }



    public void selectReturnBook(){
        ReturnBook rBook=return_tableView.getSelectionModel().getSelectedItem();
        int num=return_tableView.getSelectionModel().getFocusedIndex();

        if((num-1)<-1){
            return;
        }
        String uri="file:"+rBook.getImage();
        image=new Image(uri,133,166,false,true);
        return_imageView.setImage(image);

        getData.takeBookTitle=rBook.getTitle();
    }
    public ObservableList<ReturnBook> returnBookData(){
        ObservableList<ReturnBook> listReturnBook=FXCollections.observableArrayList();

        String checkReturn="Not Return";

        String sql="SELECT * FROM take WHERE checkReturn='"+checkReturn+"' and studentID='"+getData.studentID+"'";

        Alert alert;

        connect=Database.connectDB();
        try{
            ReturnBook rBooks;
            prepare=connect.prepareStatement(sql);
            result=prepare.executeQuery();

            while(result.next()){
                rBooks=new ReturnBook(result.getString("bookTitle"),result.getString("author"),result.getString("bookType"),result.getString("image"),result.getDate("date"));
                listReturnBook.add(rBooks);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listReturnBook;
    }
    private ObservableList<ReturnBook> returnData;
    public void showReturnBooks(){
        returnData=returnBookData();

        return_bookTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        return_author.setCellValueFactory(new PropertyValueFactory<>("author"));
        return_bookType.setCellValueFactory(new PropertyValueFactory<>("genre"));
        return_dateIssued.setCellValueFactory(new PropertyValueFactory<>("date"));

        return_tableView.setItems(returnData);
    }

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

                increaseQuantity();
                showAvailableBooks();

                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully returned");
                alert.showAndWait();

                showReturnBooks();
                return_imageView.setImage(null);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public ObservableList<saveBook> saveBooksData(){
        ObservableList<saveBook> listSaveData=FXCollections.observableArrayList();

        String sql="SELECT * FROM save WHERE studentID='"+getData.studentID+"'";

        connect=Database.connectDB();
        try{
            saveBook sBook;

            prepare=connect.prepareStatement(sql);
            result=prepare.executeQuery();

            while(result.next()){
                sBook=new saveBook(result.getString("bookTitle"),result.getString("author"),result.getString("bookType"),result.getString("image"),result.getString("shelf"));

                listSaveData.add(sBook);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listSaveData;
    }
    public void saveBooks(){
        String sql="INSERT INTO save Values(?,?,?,?,?,?)";
        connect=Database.connectDB();
        Alert alert;
        try{
            if(availableBooks_title.getText().isEmpty()){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Please select the book");
                alert.showAndWait();
            }else{
                prepare=connect.prepareStatement(sql);
                prepare.setString(1,getData.studentID);
                prepare.setString(2,getData.savedTitle);
                prepare.setString(3,getData.savedAuthor);
                prepare.setString(4,getData.savedGenre);
                prepare.setString(5,getData.savedImage);
                prepare.setString(6,getData.savedShelf);

                prepare.executeUpdate();

                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Saved");
                alert.showAndWait();

                showSavedBooks();

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private ObservableList<saveBook> sBookList;
    public void showSavedBooks(){
        sBookList=saveBooksData();

        col_saveTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        col_saveAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        col_saveGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        col_saveShelf.setCellValueFactory(new PropertyValueFactory<>("shelf"));

        save_tableView.setItems(sBookList);
    }
    public void selectSaveBooks(){
        saveBook sBook=save_tableView.getSelectionModel().getSelectedItem();
        int num=save_tableView.getSelectionModel().getFocusedIndex();

        if((num-1)<-1){
            return;
        }
        String uri="file:"+sBook.getImage();
        image=new Image(uri,133,166,false,true);
        save_imageView.setImage(image);

        getData.savedImage=sBook.getImage();
        getData.savedTitle=sBook.getTitle();
    }
    public void unSaveBooks(){
        String sql="DELETE FROM save WHERE bookTitle='"+getData.savedTitle+"'"+"and studentID='"+getData.studentID+"'";

        connect=Database.connectDB();
        Alert alert;
        try{
            if(save_imageView.getImage()==null){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Please select the book you want to unsave");
                alert.showAndWait();
            }else {
                statement=connect.createStatement();
                statement.executeUpdate(sql);

                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Unsaved");
                alert.showAndWait();

                showSavedBooks();
                save_imageView.setImage(null);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


//    public void designInsertImage(){
//        edit_btn.setVisible(false);
//
//        circle_image.setOnMouseEntered((MouseEvent event)->{
//            edit_btn.setVisible(true);
//        });
//        circle_image.setOnMouseExited((MouseEvent event)->{
//            edit_btn.setVisible(false);
//        });
//        edit_btn.setOnMouseEntered((MouseEvent event)->{
//            edit_btn.setVisible(true);
//        });
//        edit_btn.setOnMousePressed((MouseEvent event)->{
//            edit_btn.setVisible(true);
//        });
//        edit_btn.setOnMouseExited((MouseEvent event)->{
//            edit_btn.setVisible(false);
//        });
//    }

    public void print(String ID, String name, String bookName, Date date){
        Document document = new Document();
        try
        {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("ShowFileToLibrarian.pdf"));
            document.open();
            document.add(new Paragraph("Library Management System"));

            document.addAuthor("Khaled Md. Mushfique");
            document.addCreationDate();
            document.addCreator("HowToDoInJava.com");
            document.addTitle("Set Attribute Example");
            document.addSubject("An example to show how attributes can be added to pdf files.");

            PdfPTable table = new PdfPTable(2); // 3 columns.
            table.setWidthPercentage(100); //Width 100%
            table.setSpacingBefore(10f); //Space before table
            table.setSpacingAfter(10f); //Space after table

            //Set Column widths
            float[] columnWidths = {2f, 1f};
            table.setWidths(columnWidths);
            PdfPCell cell1 = new PdfPCell(new Paragraph("Book Name:    "+bookName));
//            cell1.setBorder(100);
            PdfPCell cell2 = new PdfPCell(new Paragraph("Date:    "+date));//
//            cell2.setBorder(100);


            table.addCell(cell1);
            table.addCell(cell2);
            document.add(new Paragraph("\n\n\n\n"));

            document.add(table);

            ZapfDingbatsList zapfDingbatsList = new ZapfDingbatsList(43, 30);
            document.add(new Paragraph("Taken By"));
            zapfDingbatsList.add(new ListItem("Name:    "+name));
            zapfDingbatsList.add(new ListItem("ID:     "+ID));
            document.add(zapfDingbatsList);

            document.close();
            writer.close();
        } catch (DocumentException e)
        {
            e.printStackTrace();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }







    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showAvailableBooks();
        showProfile();
        studentIDLabel();
        studentID();
        displayDate();
        gender();
        showReturnBooks();
        showSavedBooks();
    }
}
