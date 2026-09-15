/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week3.section121;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXControls extends Application {
    private Label report;
    private TextField usernameField;
    private PasswordField passwordField;

    static void main() {
        launch();
    }

    @Override
    public void start(Stage stage) {
        HBox top = new HBox();
        HBox middle = new HBox();
        HBox bottom = new HBox();
        Button okButton = new Button("OK");
        Button cancelButton = new Button("Cancel");
        Label usernameLabel = new Label("Username:");
        Label passwordLabel = new Label("Password:");
        this.usernameField = new TextField();
        this.passwordField = new PasswordField();
        this.report = new Label();
        bottom.setAlignment(Pos.CENTER_RIGHT);
        top.setSpacing(10);
        bottom.setSpacing(10);
        middle.setSpacing(10);
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        okButton.setOnAction(_ -> login());
        usernameField.setOnAction(_ -> login());
        passwordField.setOnAction(_ -> login());
        cancelButton.setOnAction(e -> cancel());

        top.getChildren().addAll(usernameLabel, usernameField);
        middle.getChildren().addAll(passwordLabel, passwordField);
        bottom.getChildren().addAll(cancelButton, okButton);
        root.getChildren().addAll(top, middle, bottom, report);

        Scene scene = new Scene(root);
        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, this::clicked);
        stage.setScene(scene);
        stage.show();
    }

    private void login() {
        if(!usernameField.getText().isBlank() && !passwordField.getText().isBlank()) {
            report.setText("Logged in!");
        } else {
            report.setText("");
        }
    }

    private void cancel() {
        usernameField.setText("");
        passwordField.setText("");
        report.setText("");
    }

    private void clicked(MouseEvent e) {
        report.setText(e.getSceneX() + " " + e.getSceneY());
    }
}
