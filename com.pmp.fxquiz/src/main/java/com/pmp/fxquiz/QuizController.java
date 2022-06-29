/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pmp.fxquiz;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Button;
import com.pmp.dao.Quiz;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author obetancourth
 */
public class QuizController implements Initializable {


    @FXML
    private Button btnConfirmar;
    @FXML
    private Button btnCancelar;
    @FXML
    private TextField txtCodigo;
    @FXML
    private RadioButton rdbActivo;
    @FXML
    private RadioButton rdbInactivo;
    @FXML
    private Label lblTitulo;

    private Quiz selectedQuiz;
    private boolean isConfirmed = false;
    
    private String mode;
    @FXML
    private TextField txtNombre;
    @FXML
    private ToggleGroup grpEstado;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void setQuiz( Quiz quiz){
      this.selectedQuiz = quiz;
      //TODO: Actualizar los controles segun los datos del objeto quiz
      
    }
    public void setMode(String mode) {
      this.mode = mode;
      //TODO: Segun el modo del formulario adecuar el acceso y visibilidad de los controles
    }

    @FXML
    private void btnConfirmar_onclicked(ActionEvent event) {
        //TODO: llenar el objeto de selectedQuiz con los datos de los controles
        this.isConfirmed = true;
        App.closeModal(event);
    }

    @FXML
    private void btnCancelar_onclicked(ActionEvent event) {
        App.closeModal(event);
    }

    public boolean getIsConfirmed(){
        return this.isConfirmed;
    }
    
   
}
        
    