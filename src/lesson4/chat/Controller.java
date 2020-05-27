package lesson4.chat;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Controller {
    @FXML
    private TextArea textArea;
    @FXML
    private TextField textField;
    @FXML
    private Button sendText;

    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");


    public void sendMessage() {
        sendText.setOnMouseReleased(event -> {
            textArea.appendText(dateFormat.format(new Date()) + "  " + textField.getText() + "\n");
            textField.clear();
        });
        textField.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                textArea.appendText(dateFormat.format(new Date()) + "  " + textField.getText() + "\n");
                textField.clear();
            }
        });
    }



}
