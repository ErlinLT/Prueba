/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pmp.fxquiz;

import java.net.URL;
import java.util.ResourceBundle;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import com.pmp.dao.Quiz;
import com.pmp.dao.QuizDao;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author obetancourth
 */
public class QuizzesController implements Initializable {


    @FXML
    private TableView<Quiz> tblQuizzes;
    @FXML
    private Button btnVisualizar;
    @FXML
    private Button btnNuevo;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnEliminar;
    
    private Quiz selectedQuiz;
    private ArrayList<Quiz> quizzes;
    
    @FXML
    private TableColumn<Quiz, Integer> tdCodigo;
    @FXML
    private TableColumn<Quiz, String> tdNombre;
    @FXML
    private TableColumn<Quiz, String> tdEstado;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        QuizDao.setup();
        tdCodigo.setCellValueFactory(new PropertyValueFactory("codigo")); //getCodigo 
        tdNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        tdEstado.setCellValueFactory(new PropertyValueFactory("estado"));
        //TODO: Asociar las demas columnas de Quiz 
        
        this.loadQuiz();

    }
    
    private void loadQuiz() {
        quizzes = QuizDao.obtenerTodos();
        tblQuizzes.setItems(FXCollections.observableArrayList(quizzes));
    }
    
    private Quiz loadQuizForm(Quiz quiz, String mode) throws IOException {
        try {
            FXMLLoader modal = App.getFXMLLoader("quiz");
            Parent modalObject = modal.load();
            QuizController modalForm = (QuizController) modal.getController();
            modalForm.setQuiz(quiz);
            modalForm.setMode(mode);
            App.loadFXMLModal(modalObject);
            // Post Cierre
            if (modalForm.getIsConfirmed()) {
               
                //Dependiendo de la accion a realizar se debe sincronizar con la db
                
                switch (mode){
                    
                   //TODO: Actualizar segun el modo en la base de datos
                }
                this.loadQuiz();
            }
            return null;
        } catch (IOException ex) {
            System.err.println(ex);
            return null;
        }
    }
    
    private Quiz getSelectedQuiz(){
        //TODO:  obtener de la grilla el Quiz seleccionado y devolverlo
        return null;
    }
    
    @FXML
    private void btnVisualizar_onclick(ActionEvent event) {
        try {
            Quiz selectedCategoria = getSelectedQuiz();
            //TODO: Llamar formulario modal y su implementación
        } catch (IOException ex){
            System.err.println(ex);
        }
    }

    @FXML
    private void btnNuevo_onclick(ActionEvent event) {
        try {
         
           //TODO: llamar formulario modal y su implementación
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    @FXML
    private void btnEditar_onclick(ActionEvent event) {
        try {
            //TODO: llamar formulario modal y su implementación
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    @FXML
    private void btnEliminar_onclick(ActionEvent event) {
        try {
             //TODO: llamar formulario modal y su implementación
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
 