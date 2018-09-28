/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author pedro
 */
public class FomularioCalculadoraController implements Initializable {
    
    String op;
    float valor1;
    
    @FXML
    private Label visor;
    
    @FXML
    private void B0(ActionEvent event) {
        this.visor.setText(String.valueOf(this.visor.getText() + "0"));
    }
    @FXML
    private void B1(ActionEvent event) {
        this.visor.setText(String.valueOf(this.visor.getText() + "1"));
    }
    @FXML
    private void B2(ActionEvent event) {
        this.visor.setText(String.valueOf(this.visor.getText() + "2"));
    }
    @FXML
    private void B3(ActionEvent event) {
        this.visor.setText(String.valueOf(this.visor.getText() + "3"));
    }
    @FXML
    private void B4(ActionEvent event) {
        this.visor.setText(String.valueOf(this.visor.getText() + "4"));
    }
    @FXML
    private void B5(ActionEvent event) {
        this.visor.setText(String.valueOf(this.visor.getText() + "5"));
    }
    @FXML
    private void B6(ActionEvent event) {
        this.visor.setText(String.valueOf(this.visor.getText() + "6"));
    }
    @FXML
    private void B7(ActionEvent event) {
        this.visor.setText(String.valueOf(this.visor.getText() + "7"));
    }
    @FXML
    private void B8(ActionEvent event) {
        this.visor.setText(String.valueOf(this.visor.getText() + "8"));
    }
    @FXML
    private void B9(ActionEvent event) {
        this.visor.setText(String.valueOf(this.visor.getText() + "9"));
    }
    @FXML
    private void BSoma(ActionEvent event) {
        op = "+";
        valor1 = Float.parseFloat(this.visor.getText());
        this.visor.setText(String.valueOf(""));
    }
    @FXML
    private void BSubtracao(ActionEvent event) {
        op = "-";
        valor1 = Float.parseFloat(this.visor.getText());
        this.visor.setText(String.valueOf(""));
    }
    @FXML
    private void BMultiplicacao(ActionEvent event) {
        op = "*";
        valor1 = Float.parseFloat(this.visor.getText());
        this.visor.setText(String.valueOf(""));
    }
    @FXML
    private void BDivisao(ActionEvent event) {
        op = "/";
        valor1 = Float.parseFloat(this.visor.getText());
        this.visor.setText(String.valueOf(""));
    }
    @FXML
    private void BResultado(ActionEvent event) {
        float valor2, resultado = 0;
        valor2 = Float.parseFloat(this.visor.getText());
        
        if ("+".equals(op)){
            resultado = valor1 + valor2;
        }
        if ("-".equals(op)){
            resultado = valor1 - valor2;
        }
        if ("*".equals(op)){
            resultado = valor1 * valor2;
        }
        if ("/".equals(op)){
            resultado = valor1 / valor2;
        }
        this.visor.setText(String.valueOf(resultado));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
