package com.example.cineurubufinal;

import com.example.cineurubufinal.dados.RepositorioIngresso;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.lang.reflect.AccessFlag;
import java.net.URL;
import java.util.ResourceBundle;

public class CompraTelaController implements Initializable {

    @FXML
    public void trocaHome (ActionEvent event) throws IOException{
        SceneCreator.launchScene("Home.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
