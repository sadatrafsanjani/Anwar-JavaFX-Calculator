package com.rafsanjani.anwar.controller;

import com.rafsanjani.anwar.model.Model;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class FXMLController implements Initializable {

    @FXML
    private Label display;
    @FXML
    private Button ac;
    private final DecimalFormat decimalFormat = new DecimalFormat("###.#####");
    private final boolean[] operator = new boolean[4];
    private final double[] temporary = {0, 0};
    private Model model;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        model = new Model();
    }

    @FXML
    public void acPressed(ActionEvent event) {

        ac.setText("AC");
        display.setText("0");
        display.setStyle("-fx-font-size: 46;");

        for (int i = 0; i < 2; i++) {
            temporary[i] = 0;
        }

        for (int i = 0; i < 4; i++) {
            operator[i] = false;
        }
    }

    @FXML
    public void conversionPressed(ActionEvent event) {

        if (!display.getText().equals("0")) {
            Double value = Double.parseDouble(display.getText());
            value = model.processConversion(value);
            display.setText(decimalFormat.format(value));
        }
    }

    @FXML
    public void percentagePressed(ActionEvent event) {

        if (!display.getText().equals("0")) {
            Double value = Double.parseDouble(display.getText());
            value = model.processPercentage(value);
            display.setText(decimalFormat.format(value));
        }
    }

    @FXML
    public void operatorPressed(ActionEvent event) {

        String button = ((Button) event.getSource()).getId();
        temporary[0] = Double.parseDouble(display.getText());

        switch (button) {

            case "addition":
                operator[0] = true;
                break;

            case "subtraction":
                operator[1] = true;
                break;

            case "multiplication":
                operator[2] = true;
                break;

            case "division":
                operator[3] = true;
                break;
        }
        
        display.setText("");

    }

    @FXML
    public void buttonPressed(ActionEvent event) {

        String button = ((Button) event.getSource()).getId();

        changeFontSize();

        if (display.getText().equals("0")) {
            ac.setText("C");
            display.setText("");
        }

        switch (button) {

            case "one":
                display.setText(display.getText() + "1");
                break;

            case "two":
                display.setText(display.getText() + "2");
                break;

            case "three":
                display.setText(display.getText() + "3");
                break;

            case "four":
                display.setText(display.getText() + "4");
                break;

            case "five":
                display.setText(display.getText() + "5");
                break;

            case "six":
                display.setText(display.getText() + "6");
                break;

            case "seven":
                display.setText(display.getText() + "7");
                break;

            case "eight":
                display.setText(display.getText() + "8");
                break;

            case "nine":
                display.setText(display.getText() + "9");
                break;

            case "zero":
                display.setText(display.getText() + "0");
                break;

            case "point":
                if (!display.getText().contains(".")) {
                    display.setText(display.getText() + ".");
                }
                break;
        }
    }

    @FXML
    public void calculateResult(ActionEvent event) {

        changeFontSize();
        
        double result = 0;
        temporary[1] = Double.parseDouble(display.getText());

        if (operator[0]) {
            result = model.getAddition(temporary[0], temporary[1]);
        } else if (operator[1]) {
            result = model.getSubtraction(temporary[0], temporary[1]);
        } else if (operator[2]) {
            result = model.getMultiplication(temporary[0], temporary[1]);
        } else if (operator[3]) {
            result = model.getDivision(temporary[0], temporary[1]);
        }

        display.setText(decimalFormat.format(result));
    }
    
    private void changeFontSize(){
    
        int length = display.getText().length();

        if (length > 6 && length <= 11) {
            display.setStyle("-fx-font-size: 32;");
        } else if (length > 11 && length <= 18) {
            display.setStyle("-fx-font-size: 18;");
        }
    }

    @FXML
    public void closeAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    public void minusAction(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }
}
