package br.ufrpe.bcc;

import br.ufrpe.bcc.controller.Fachada;
import br.ufrpe.bcc.files.Salvar;
import br.ufrpe.bcc.gui.SalasController;
import br.ufrpe.bcc.model.negocios.AlocacaoSala;
import br.ufrpe.bcc.model.negocios.beans.Aluno;
import br.ufrpe.bcc.model.negocios.beans.Predio;
import br.ufrpe.bcc.model.negocios.beans.Professor;
import br.ufrpe.bcc.model.negocios.beans.Sala;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    private static BorderPane root = new BorderPane();


    public void start(Stage primaryStage) throws IOException{
        try{
            this.root = FXMLLoader.load(getClass().getResource("/br/ufrpe/bcc/gui/Login.fxml"));
            Scene scene = new Scene(root, 640, 400);
            primaryStage.setTitle("Gestão de Salas - UFRPE");
            primaryStage.getIcons().add(new Image("/br/ufrpe/bcc/imagens/Logo-UFRPE.png"));
            primaryStage.setResizable(false);
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Fachada fachada;

        Salvar in = new Salvar();
        fachada = in.carregar();

        Professor professor1 = new Professor("ProfessorGAME", 33, "Ceagri e e nois", "profelele@gmail.com", "819123123123","123123123212", "profelele","laemksa","DEINFO");
        Fachada.getInstance().cadastrarProfessor(professor1);
        Professor professor2 = new Professor("ProfessorGAME", 33, "Ceagri e e nois", "profelele@gmail.com", "819123123123","12312312322", "profelele","laemksa","DEINFO");
        Fachada.getInstance().cadastrarProfessor(professor2);

        System.out.println(Fachada.getInstance().getListProfessor());


        /*
        Predio ceagri = new Predio("Ceagri-2", "12322123", 199.22,112.3);
        fachada.cadastrarPredio(ceagri);
        fachada.cadastrarProfessor(professor1);
        Sala sala1 = new Sala("Sala 1", "Sala de estudos", 40,01,40);
        Sala sala2 = new Sala("Sala 2", "Sala de estudos", 40,02,40);
        fachada.novaSala(ceagri,sala1);
        fachada.novaSala(ceagri,sala2);
        AlocacaoSala alocar = new AlocacaoSala(ceagri,sala1,professor1,10,12);
        alocar.setPredio(ceagri);
        alocar.setProfessor(professor1);
        alocar.setSala(sala1);


        Aluno a1 = new Aluno();
        a1.setLogin("a1login");
        a1.setSenha("a1senha");
        a1.setCpf("123");


        Aluno a2 = new Aluno();
        a2.setLogin("a2login");
        a2.setSenha("a2senha");
        a2.setCpf("234");
        SalasController a = new SalasController();

        /*
        Predio p1= new Predio("Ceagri","fodda-se",314,251.15);

        Sala s1 = new Sala("Sala 1","Sala de aula", 3.15 , 1, 30);
        Sala s2 = new Sala("Sala 2","Auditorio", 6,2,60);

        Professor pf1 = new Professor("Gru",42,"Algum Lugar","gru@ufrpe.br","3212-3456","123.456.789.0","gru","minions","DC");

        AlocacaoSala as1 = new AlocacaoSala(p1,s1,pf1,14,16);
        AlocacaoSala as2 = new AlocacaoSala(p1,s2,pf1,16,18);

        AlocacaoSalaGeneric ag1= new AlocacaoSalaGeneric(as1);
        AlocacaoSalaGeneric ag2= new AlocacaoSalaGeneric(as2);
        */



        launch(Main.class);
    }

    public static BorderPane getRoot(){
        return root;
    }
}
