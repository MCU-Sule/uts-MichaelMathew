package com.example.uts_2072007.Controller;

import com.example.uts_2072007.dao.UserDao;
import com.example.uts_2072007.model.user;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class UTSController2 {
    public TextField txtUserName;
    public PasswordField txtPassword;

    public void submit(ActionEvent actionEvent) {
        UserDao dao = new UserDao();
        if (txtUserName.getText().isEmpty() || txtPassword.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Please Fill all the field", ButtonType.OK);
            alert.show();
        } else {
            dao.addData(new user(0,txtUserName.getText(), txtPassword.getText()));
            txtUserName.getScene().getWindow().hide();
        }
    }
}
