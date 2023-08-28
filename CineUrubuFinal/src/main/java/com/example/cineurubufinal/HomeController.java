package com.example.cineurubufinal;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    private ImageView Barbie;

    @FXML
    private ImageView BesouroAzul;

    @FXML
    private ImageView Elementos;

    @FXML
    private ImageView OpenHeimer;

    @FXML
    private ImageView Perfil;


    @FXML
    private Label login;


    public void initialize(URL location, ResourceBundle resources) {
    }
    @FXML
    public void trocaLogin(MouseEvent event) throws IOException {
        SceneCreator.launchScene("Login.fxml");
    }

    @FXML
    public void trocaBarbie(MouseEvent event) throws IOException {
        SceneCreator.launchScene("Barbie.fxml");
    }

    @FXML
    public  void trocaBesouro (MouseEvent event) throws IOException{
        SceneCreator.launchScene("Besouro.fxml");
    }
    @FXML
    public  void trocaOppehiemer (MouseEvent event) throws IOException{
        SceneCreator.launchScene("Oppenheimer.fxml");
    }
    @FXML
    public  void trocaElementos (MouseEvent event) throws IOException{
        SceneCreator.launchScene("Elementos.fxml");
    }
    public void hover(MouseEvent event) throws  IOException{
        login.getStylesheets().add(Objects.requireNonNull(getClass().getResource("Hover.css")).toExternalForm());
    }


    public void ahover(MouseEvent event) throws  IOException{
        login.getStylesheets().remove(Objects.requireNonNull(getClass().getResource("Hover.css")).toExternalForm());
    }

    @FXML
    public void trocaDadosPessoais(MouseEvent event) throws IOException {
        SceneCreator.launchScene("DadosPessoais.fxml");
    }
}
