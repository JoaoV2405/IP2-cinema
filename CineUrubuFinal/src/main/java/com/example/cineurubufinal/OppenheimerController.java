package com.example.cineurubufinal;

import com.example.cineurubufinal.negocio.ControladorIngresso;
import com.example.cineurubufinal.negocio.beans.Assento;
import com.example.cineurubufinal.negocio.beans.Ingresso;
import com.example.cineurubufinal.exception.AssentoOcupadoException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


import static com.example.cineurubufinal.Main.listaAssentosOppenheimer;


public class OppenheimerController implements Initializable {

    @FXML
    GridPane gridseats;

    @FXML
    ComboBox tipoIngresso;

    @FXML
    Button A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, C1, C2, C3, C4, C5, C6, C7, C8, C9, C10, D1, D2, D3, D4, D5, D6, D7, D8, D9, D10, E1, E2, E3, E4, E5, E6, E7, E8, E9, E10, F1, F2, F3, F4, F5, F6, F7, F8, F9, F10, G1, G2, G3, G4, G5, G6, G7, G8, G9, G10, H1, H2, H3, H4, H5, H6, H7, H8, H9, H10, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, J1, J2, J3, J4, J5, J6, J7, J8, J9, J10;


    String meia = "Meia";
    String inteira = "Inteira";

    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 0; i < 100; i++) {
            if (listaAssentosOppenheimer.get(i).getOcupado() == Boolean.TRUE){
                gridseats.getChildren().get(i).setStyle("-fx-background-color: #ff1100 ");
            }
            else {
                gridseats.getChildren().get(i).setStyle("-fx-background-color:#1e90ff");
            }
        }
        tipoIngresso.getItems().add(meia);
        tipoIngresso.getItems().add(inteira);
    }

    @FXML
    public void trocaHome(ActionEvent event) throws IOException {
        SceneCreator.launchScene("Home.fxml");
    }

    ArrayList<Assento> carrinho = new ArrayList<>();
    public void selecionar(ActionEvent event) throws IOException {

        Button bnt = (Button) event.getSource();
        if (bnt.getStyle().equals("-fx-background-color: FF1100FF")) {
            if (listaAssentosOppenheimer.get((GridPane.getRowIndex(bnt) * 10) + GridPane.getColumnIndex(bnt)).getOcupado()){
                System.out.println("Esse assento já está Ocupado, escolha outro!");
            }
            else {
                carrinho.remove(listaAssentosOppenheimer.get((GridPane.getRowIndex(bnt) * 10) + GridPane.getColumnIndex(bnt)));
                bnt.setStyle("-fx-background-color: #1e90ff");
            }
        }

        else {
            if (carrinho.isEmpty() && !listaAssentosOppenheimer.get((GridPane.getRowIndex(bnt) * 10) + GridPane.getColumnIndex(bnt)).getOcupado()) {
                bnt.setStyle("-fx-background-color: #ff1100");
                carrinho.add(listaAssentosOppenheimer.get((GridPane.getRowIndex(bnt) * 10) + GridPane.getColumnIndex(bnt)));
            }
            else {
                Alert erro = new Alert(Alert.AlertType.ERROR);
                erro.setHeaderText("");
                erro.setTitle("Erro");
                erro.setContentText("Só se pode escolher 1 ingresso por vez!");
                erro.show();
            }
        }
    }

    public void comprar(ActionEvent event) throws IOException, AssentoOcupadoException {
        Alert erro = new Alert(Alert.AlertType.ERROR);
        erro.setHeaderText("");
        erro.setTitle("Erro");
        if(tipoIngresso.getValue() != null) {
            for (Assento assento : carrinho) {
                assento.setOcupado(true);
                Ingresso ingresso = new Ingresso(assento);
                ingresso.setFilme("Oppenheimer");
                ingresso.setTipo(String.valueOf(tipoIngresso.getValue()));
                ingresso.setPreco();
                ControladorIngresso.getInstance().adicionarIngresso(ingresso);
            }
        }
        else {
                erro.setContentText("Você não selecionou o tipo do ingresso!!");
                erro.show();
                return;
            }
        carrinho.clear();
        SceneCreator.launchScene("CompraTela.fxml");
    }
}