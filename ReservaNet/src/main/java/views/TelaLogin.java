package views;

import ext.Listas;
import src.models.Usuario;
import views.frame.*;


public class TelaLogin {

    public static void main(String[] args) {
        Listas listas = new Listas();
        LoginFrame loginFrame = new LoginFrame();
        /* Gerando listas para coleta de dados predefinidos */
        gerarListaUsuarios();
        loginFrame.GUILogin(loginFrame);
    }

    public static void gerarListaUsuarios(){
        Listas.listaUsuarios.add(new Usuario("1a2b", "Lucas Barros", "lbarros", "prof111"));
        Listas.listaUsuarios.add(new Usuario("1b2c", "Anisia Maria", "amaria", "prof222"));
        Listas.listaUsuarios.add(new Usuario("1c2d", "Guilherme Sousa", "gsousa", "prof333"));
        Listas.listaUsuarios.add(new Usuario("1d2e", "Roberto Massaki", "rmassaki", "prof444"));
        Listas.listaUsuarios.add(new Usuario("1e2f", "Antonio Filho", "01aluno", "01aluno"));
    }


}