package com.example.cineurubufinal;

import com.example.cineurubufinal.negocio.beans.Assento;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;
import java.util.Objects;

public class Main extends Application {

    static Parent root;
    static Stage primaryStage;
    static ArrayList<Assento> listaAssentosBarbie;
    static ArrayList<Assento> listaAssentosOppenheimer;
    static ArrayList<Assento> listaAssentosElementos;
    static ArrayList<Assento> listaAssentosBesouro;





    @Override
    public void start(Stage primaryStage) {

        try {
            // setting up the login scene
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
            Main.primaryStage = primaryStage;
            primaryStage.setTitle("CineUrubu");
            primaryStage.initStyle(StageStyle.UNDECORATED);
            Scene scene = new Scene(root, 600, 450);
            //scene.getStylesheets().add(getClass().getResource("/scenes/application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        listaAssentosBesouro = new ArrayList<>();
        listaAssentosElementos= new ArrayList<>();
        listaAssentosOppenheimer = new ArrayList<>();
        listaAssentosBarbie = new ArrayList<>();
        Assentos assentos = new Assentos();
        assentos.criarAssentos(listaAssentosBarbie);
        assentos.criarAssentos(listaAssentosBesouro);
        assentos.criarAssentos(listaAssentosElementos);
        assentos.criarAssentos(listaAssentosOppenheimer);
        launch();
    }

    static Parent getRoot() {

        return root;
    }

    static void setRoot(Parent root) {

        Main.root = root;
    }

    static Stage getStage() {

        return primaryStage;
    }

    static void setStage(Stage stage) {

        Main.primaryStage = stage;
    }

}