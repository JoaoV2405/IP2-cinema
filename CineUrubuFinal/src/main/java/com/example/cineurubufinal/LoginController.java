package com.example.cineurubufinal;

import com.example.cineurubufinal.dados.RepositorioUsuario;
import com.example.cineurubufinal.exception.UsuarioExisteException;
import com.example.cineurubufinal.negocio.ControladorUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.Objects;

public class LoginController {
    @FXML
    private PasswordField PasswordTXT;

    @FXML
    private TextField UsarnameTXT;

    @FXML
    private Button cancel;

    @FXML
    private Button login;

    @FXML
    private Label cadastrese;
    String Senha;
    String email;

    public void hover(MouseEvent event) throws  IOException{
        cadastrese.getStylesheets().add(Objects.requireNonNull(getClass().getResource("Hover.css")).toExternalForm());
    }

    public void ahover(MouseEvent event) throws  IOException{
        cadastrese.getStylesheets().remove(Objects.requireNonNull(getClass().getResource("Hover.css")).toExternalForm());
    }


    @FXML
    public void trocaCadastro(MouseEvent event) throws IOException {
       SceneCreator.launchScene("Cadastro.fxml");
    }

    public void trocaCenaHome(ActionEvent event) throws IOException {
        SceneCreator.launchScene("Home.fxml");
    }
    public void login(ActionEvent event) throws UsuarioExisteException, IOException {
        if (event.getSource() == login) {

            Senha = PasswordTXT.getText();
            email = UsarnameTXT.getText();
            Alert erro = new Alert(Alert.AlertType.ERROR);
            erro.setHeaderText("");
            erro.setTitle("Erro");
            if(ControladorUsuario.getInstance().getUsuarios().isEmpty()){
                erro.setContentText("É preciso cadastrar um usuário antes de fazer login");
                erro.show();
                return;
            }
            if (ControladorUsuario.getInstance().getUsuarios().get(0).getEmail().equals(email)) {
                if (ControladorUsuario.getInstance().getUsuarios().get(0).getSenha().equals(Senha)) {
                    SceneCreator.launchScene("Home.fxml");
                } else {
                    erro.setContentText("Senha Incorreta");
                    erro.show();
                    return;
                }

            } else {
                erro.setContentText("Usuario Incorreto");
                erro.show();
                return;
            }
        }
    }

}
