/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week3.section111;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Controller {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML Label report;

    @FXML private void login() {
        if(!usernameField.getText().isBlank() && !passwordField.getText().isBlank()) {
            report.setText("logged in");
        } else {
//            report.setText("Need username and password");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR!");
            alert.setHeaderText("Missing information!");
            alert.setContentText("Need both username and password");
            alert.show();
        }
    }

    @FXML private void cancel() {
        usernameField.setText("");
        passwordField.setText("");
        report.setText("");
    }
}
