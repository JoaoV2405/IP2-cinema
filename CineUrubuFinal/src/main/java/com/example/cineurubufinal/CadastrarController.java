package com.example.cineurubufinal;

import com.example.cineurubufinal.negocio.ControladorUsuario;
import com.example.cineurubufinal.negocio.beans.Usuario;
import com.example.cineurubufinal.exception.UsuarioExisteException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.Objects;

public class CadastrarController {


    @FXML
    private TextField CPFField;

    @FXML
    private Button Cadastrar;

    @FXML
    private Label CadastroCaracters;

    @FXML
    private TextField DTField;

    @FXML
    private TextField EmailField;

    @FXML
    private TextField NomeField;

    @FXML
    private PasswordField SenhaField;

    @FXML
    private Label cadastroNumero;

    @FXML
    private Label cadastroLow;

    @FXML
    private Label cadastroUp;

    String cssG = Objects.requireNonNull(this.getClass().getResource("cssG.css")).toExternalForm();
    String cssR = Objects.requireNonNull(this.getClass().getResource("cssR.css")).toExternalForm();





    String Senha;
    String nome;
    String email;
    String cpf;
    int contadordigito;
    int contadorUp;
    int contadorlow;
    public void cadastrar(ActionEvent event) throws UsuarioExisteException, IOException {
        Alert erro = new Alert(Alert.AlertType.ERROR);
        erro.setHeaderText("");
        erro.setTitle("Erro");
        long ncpf;
        try {
            Senha = SenhaField.getText();
            cpf = CPFField.getText();
            email = EmailField.getText();
            ncpf = Long.parseLong(cpf);
            nome = NomeField.getText();
            if(cpf.length()!=11){
                erro.setContentText("Formato inválido de CPF");
                erro.show();
                return;
            }

            for (int i = 0; i < Senha.length(); i++) {
                if (Character.isDigit(Senha.charAt(i))) {
                    contadordigito++;
                }
            }
            for (int o = 0; o < Senha.length(); o++) {
                if (Character.isUpperCase(Senha.charAt(o))) {
                    contadorUp++;
                }
            }
            for (int p = 0; p < Senha.length(); p++) {
                if (Character.isLowerCase(Senha.charAt(p))) {
                    contadorlow++;
                }
            }

            if (Senha.length() >= 8 && contadordigito != 0 && contadorlow != 0 && contadorUp != 0) {
                contadordigito = 0;
                contadorUp = 0;
                contadorlow = 0;
                SceneCreator.launchScene("Login.fxml");
            } else {
                if (contadorlow != 0) {
                    cadastroLow.getStylesheets().add(cssG);
                }
                if (contadorUp != 0) {
                    cadastroUp.getStylesheets().add(cssG);
                }
                if (contadordigito != 0) {
                    cadastroNumero.getStylesheets().add(cssG);
                }
                if (Senha.length() >= 8) {
                    CadastroCaracters.getStylesheets().add(cssG);
                }
                if (contadordigito == 0) {
                    cadastroNumero.getStylesheets().add(cssR);
                    cadastroNumero.getStylesheets().remove(cssG);
                }
                if (Senha.length() < 8) {
                    CadastroCaracters.getStylesheets().add(cssR);
                    CadastroCaracters.getStylesheets().remove(cssG);
                }
                if (contadorlow == 0) {
                    cadastroLow.getStylesheets().add(cssR);
                    cadastroLow.getStylesheets().remove(cssG);
                }
                if (contadorUp == 0) {
                    cadastroUp.getStylesheets().add(cssR);
                    cadastroUp.getStylesheets().remove(cssG);
                }
                System.out.println(contadordigito);

            }
        }
        catch(NumberFormatException n){
            erro.setContentText("Formato Inválido");
            erro.show();
            return;
        }
        contadordigito = 0;
        contadorUp = 0;
        contadorlow = 0;
        if(nome!=null && cpf!=null && email!=null){
            Usuario u = new Usuario(nome, ncpf, email);
            u.setSenha(Senha);
            ControladorUsuario.getInstance().cadastrarUsuario(u);
        }
        else{
            erro.setContentText("Campo de texto nulo!");
            erro.show();
            return;
        }

    }

}