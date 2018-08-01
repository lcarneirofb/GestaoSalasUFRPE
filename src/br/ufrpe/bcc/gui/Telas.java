package br.ufrpe.bcc.gui;

import br.ufrpe.bcc.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class Telas {
    FXMLLoader login, cadastroAluno, menuADM, alocarSala, cadastroProfessor, cadastroPredio;
    BorderPane paneLogin;
    BorderPane border;
    BorderPane paneCadastroAluno;
    BorderPane paneMenuADM;
    BorderPane paneAlocacaoSalas;
    BorderPane paneCadastroProfessor;
    BorderPane paneCadastroPredio;

    public static Telas instancia;

    public static synchronized Telas getInstance(){
        if(instancia == null){
            instancia = new Telas();
        }
        return instancia;
    }

    private Telas(){
        try{
            login = new FXMLLoader(this.getClass().getResource("/br/ufrpe/bcc/gui/Login.fxml"));
            this.paneLogin = login.load();
            cadastroAluno = new FXMLLoader(this.getClass().getResource("/br/ufrpe/bcc/gui/CadastroAluno.fxml"));
            this.paneCadastroAluno = cadastroAluno.load();
            menuADM = new FXMLLoader(this.getClass().getResource("/br/ufrpe/bcc/gui/Menu.fxml"));
            this.paneMenuADM = menuADM.load();
            alocarSala = new FXMLLoader(this.getClass().getResource("/br/ufrpe/bcc/gui/Salas.fxml"));
            this.paneAlocacaoSalas = alocarSala.load();
            cadastroProfessor = new FXMLLoader(this.getClass().getResource("/br/ufrpe/bcc/gui/CadastroProfessor.fxml"));
            this.paneCadastroProfessor = cadastroProfessor.load();
            cadastroPredio = new FXMLLoader(this.getClass().getResource("/br/ufrpe/bcc/gui/CadastroPredio.fxml"));
            this.paneCadastroPredio = cadastroPredio.load();
            this.border = Main.getRoot();

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void getLogin(){
        border.setCenter(this.paneLogin);
    }

    public void getCadastroAluno(){
        border.setCenter(this.paneCadastroAluno);
    }

    public void getMenuADM(){ border.setCenter(this.paneMenuADM);}

    public void getAlocarSala(){
        border.setCenter(this.paneAlocacaoSalas);
        SalasController salasController = new SalasController();
        salasController.showInfo();
    }

    public void getCadastroProfessor(){
        border.setCenter(this.paneCadastroProfessor);
    }

    public void getCadastroPredio(){
        border.setCenter(this.paneCadastroPredio);
    }

}
