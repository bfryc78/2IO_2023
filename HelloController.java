package com.example.kalkulator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloController {


    @FXML
    private Button buttonMinus;

    @FXML
    private Button buttonPlus;

    @FXML
    private Label labelNumber1;

    @FXML
    private Label labelNumber2;

    @FXML
    private Label labelResult;

    @FXML
    private Label labelTitle;

    @FXML
    private AnchorPane mainPanel;

    @FXML
    private TextField textNumber1;

    @FXML
    private TextField textNumber2;

    @FXML
    public ListView <String> listOfOperations;
    @FXML
    void onMinus(ActionEvent event) {
        try {
            double liczba1 = Double.parseDouble(textNumber1.getText());  //zamiana string ana liczbę typu double
            double liczba2 = Double.parseDouble(textNumber2.getText());
            double wynik = liczba1 - liczba2;
            labelResult.setText("Wynik :" + Double.toString(wynik));
            listOfOperations.getItems().add(textNumber1.getText()+"-"+textNumber2.getText()+"="+wynik);
        }catch(NumberFormatException e)
        {
            labelResult.setText("Błąd konwersji!!!");
        }
    }

    @FXML
    void onPlus(ActionEvent event) {
        try{
            double liczba1 = Double.parseDouble(textNumber1.getText());  //zamiana stringa na liczbę typu double
            double liczba2 = Double.parseDouble(textNumber2.getText());
            double wynik = liczba1 + liczba2;

            labelResult.setText("Wynik :"+Double.toString(wynik));
            listOfOperations.getItems().add(textNumber1.getText()+"+"+textNumber2.getText()+"="+wynik);
        }catch(NumberFormatException e)
        {
            labelResult.setText("Błąd konwersji!!!");
        }

    }

    @FXML
    private Button buttonSave;
    @FXML
    private Button buttonClear;

    @FXML
    void onClear(ActionEvent event) {

    }
    @FXML
    void onSave(ActionEvent event) {
    try {
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt")
              //  new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
              //  new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
              //  new FileChooser.ExtensionFilter("All Files", "*.*"));
        );
       // chooser.selectedExtensionFilterProperty();
        File file = chooser.showSaveDialog(new Stage());
        if (file != null) {
            PrintWriter out = new PrintWriter(file.getAbsolutePath());
            out.println("Zapisane opercje");

            for(String dane:listOfOperations.getItems())
            {
                out.println(dane);
            }
            out.close();
        }

    }
        catch(IOException e)
        {
            System.out.println("Błąd zapisu pliku");
        }

    }

}
