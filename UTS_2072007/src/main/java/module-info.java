module com.example.uts_2072007 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jasperreports;

    opens com.example.uts_2072007 to javafx.fxml;
    exports com.example.uts_2072007;
    exports com.example.uts_2072007.model;
    exports com.example.uts_2072007.util;
    exports com.example.uts_2072007.dao;
    exports com.example.uts_2072007.Controller;
}