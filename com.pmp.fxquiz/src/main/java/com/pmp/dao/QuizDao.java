/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmp.dao;

import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
/**
 *
 * @author obetancourth
 */
public class QuizDao {
    public static void setup() {
        String sqlCrearTabla = "CREATE TABLE IF NOT EXISTS QUIZZES"
                + " (CODIGO INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " NOMBRE TEXT,"
                + " ESTADO TEXT);";
        try {
            Statement comando = Conexion.getConexion().createStatement();
            int resultado = comando.executeUpdate(sqlCrearTabla);
            comando.close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
        }
    }
    public static ArrayList<Quiz> obtenerTodos(){
        String sqlObtenerTodo = "SELECT * FROM QUIZZES;";
        ArrayList<Quiz> quizzes = new ArrayList<>();
        try{
            Statement comando = Conexion.getConexion().createStatement();
            ResultSet rows = comando.executeQuery(sqlObtenerTodo);
            while (rows.next()){
                Quiz categoria = new Quiz();
                categoria.setCodigo(rows.getInt("CODIGO"));
                categoria.setNombre(rows.getString("NOMBRE"));
                categoria.setEstado(rows.getString("ESTADO"));
                quizzes.add(categoria);
            }
            comando.close();
            return quizzes;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
            return null;
        }
    }
    public static Quiz agregar (Quiz newQuiz) {
        String sqlInsert = "INSERT INTO QUIZZES (NOMBRE, ESTADO) VALUES (?, ?); ";
        try {
            PreparedStatement comando = Conexion.getConexion().prepareStatement(sqlInsert);
            comando.setString(1, newQuiz.getNombre());
            comando.setString(2, newQuiz.getEstado());
            int registroAgregado = comando.executeUpdate();
            comando.close();
            return newQuiz;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
            return null;
        }
    }
    
    public static Quiz actualizar(Quiz updQuiz) {
        String sqlUpdate = "UPDATE QUIZZES set NOMBRE=? , ESTADO=? where CODIGO=?;";
        try {
            PreparedStatement comando = Conexion.getConexion().prepareStatement(sqlUpdate);
            comando.setString(1, updQuiz.getNombre());
            comando.setString(2, updQuiz.getEstado());
            comando.setInt(3, updQuiz.getCodigo());
            int registroActualizado = comando.executeUpdate();
            comando.close();
            return updQuiz;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
            return null;
        }
        
    }
    
    public static int eliminar (int codEliminar) {
        String sqlEliminarCategoria = "DELETE FROM CATEGORIAS WHERE CODIGO=?;";
        try {
            PreparedStatement comando = Conexion.getConexion().prepareStatement(sqlEliminarCategoria);
            comando.setInt(1, codEliminar);
            int registrosEliminados = comando.executeUpdate();
            comando.close();
            return registrosEliminados;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
            return 0;
        }
    
    }
    
}
