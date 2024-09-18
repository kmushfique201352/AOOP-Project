module com.library {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires commons;
    requires font.asian;
    requires forms;
    requires hyph;
    requires io;
    requires kernel;
    requires layout;
    requires pdfa;
    requires sign;
    requires styled.xml.parser;
    requires svg;
    requires barcodes;
    requires org.slf4j;
    requires itextpdf;


    opens com.library to javafx.fxml;
    exports com.library;
//    exports Scenes;
//    opens Scenes to javafx.fxml;
}