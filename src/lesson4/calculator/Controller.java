package lesson4.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
    @FXML
    private TextField textField;

    List<String> list = new ArrayList<>(Arrays.asList("+", "-", "*", "/", "%"));

    public void insertOperand(ActionEvent actionEvent) {
        Button btn = (Button) actionEvent.getSource();
        textField.appendText(btn.getText());
    }

    public void clearTextField() {
        textField.clear();
        textField.setStyle("-fx-font-size:30;");
    }

    public void insertOperator(ActionEvent actionEvent) {
        Button btn = (Button) actionEvent.getSource();
        String text = textField.getText();
        int length = text.length();
        for (int i = 0; i < list.size(); i++) {
            if (btn.getText().equals(list.get(i))) {
                for (int j = 0; j < list.size(); j++) {
                    if (text.charAt(length - 1) == list.get(j).charAt(0)) {
                        textField.deleteText(length - 1, length);
                    }
                }
                textField.appendText(btn.getText());
            }
        }
    }

    public void calculate() {
        try {
            textField.setText((calculateExpression(textField.getText()) + "").replace(".0", ""));
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            textField.setStyle("-fx-font-size:20;");
            textField.setText("Нельзя делить на ноль");
        }

    }

    public double calculateExpression(String input) throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        return new BigDecimal(engine.eval(input).toString()).doubleValue();
    }
}