package com.example.cineurubufinal;

import com.example.cineurubufinal.negocio.ControladorIngresso;
import com.example.cineurubufinal.negocio.ControladorUsuario;
import com.example.cineurubufinal.negocio.beans.Ingresso;
import com.example.cineurubufinal.dados.RepositorioIngresso;
import com.example.cineurubufinal.dados.RepositorioUsuario;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DadosPessoaisController implements Initializable {


    @FXML
    TextField data;

    @FXML
    TextField email;

    @FXML
    TextField nome;
    @FXML
    TextField cpf;
    @FXML
    ComboBox Ingressos;

    @FXML
    Label PrecoIngresso;

    @FXML
    Label FilmeIngresso;

    @FXML
    Label TipoIngresso;



    @FXML
    public void trocaHome(MouseEvent event) throws IOException {
        SceneCreator.launchScene("Home.fxml");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String str =Long.toString(ControladorUsuario.getInstance().getUsuarios().get(0).getCpf());
        email.setText(ControladorUsuario.getInstance().getUsuarios().get(0).getEmail());
        nome.setText(ControladorUsuario.getInstance().getUsuarios().get(0).getNome());
        cpf.setText(str);
        for (int i =0; i < ControladorIngresso.getInstance().listarIngressos().size(); i++){
            Ingressos.getItems().add(ControladorIngresso.getInstance().listarIngressos().get(i));
        }
        Ingressos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener <Ingresso>() {
            @Override
            public void changed(ObservableValue<? extends Ingresso> observableValue, Ingresso ingresso, Ingresso t1) {
                FilmeIngresso.setText(t1.getFilme());
                PrecoIngresso.setText(String.valueOf(t1.getPreco()));
                TipoIngresso.setText(t1.getTipo());
            }

        });

    }
    //Colocar um alert no Home controler para dizer que n da pra entrar nessa aba sem um usuario
}
