package views.frame;



import ext.Listas;
import src.models.Usuario;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginFrame extends JFrame implements ActionListener {
    private int larguraFrame = 500;
    private int alturaFrame = 400;

    //Componentes Layout------------------------
    private Container container = getContentPane();
    private BorderLayout layout = new BorderLayout(50,50);
    private JPanel painelCentral = new JPanel();
    private JPanel painelSuperior = new JPanel();
    private JPanel painelInferior = new JPanel();
    private JPanel PainelLateralDireita = new JPanel();
    private JPanel PainelLateralEsquerda = new JPanel();
    //Componentes Interativos---------------------------
    ImageIcon iconeSistema = new ImageIcon("src/assets/reservanet-icon-horizontal-login.png");
    JLabel lblNome = new JLabel("Nome: ");
    JLabel lblIdentificacao = new JLabel("Identificacao");
    JLabel lblIconeSistema = new JLabel(iconeSistema);
    JTextField txtUsuario = new JTextField();
    JPasswordField pwSenha = new JPasswordField();
    JButton btnAcessar = new JButton("LOGIN");
    JButton btnResetar = new JButton("RESET");
    JCheckBox ckExibirSenha = new JCheckBox("Exibir senha");

    public LoginFrame()
    {
        definirLayout();
        definirLocalizacaoETamanho();
        addComponentesAoContainer();
        addActionEvent();
    }

    public void definirLayout()
    {

        container.setLayout(layout);
        painelSuperior.setLayout(new GridLayout(1,1));
        painelCentral.setLayout(new GridLayout(3,2,0,5));
        painelInferior.setLayout(new GridLayout(2,4, 15,10));
    }

    public void definirLocalizacaoETamanho()
    {
        //Dimensoes do Icone
        int larguraIcone = 250;
        int alturaIcone = 110;
        int xIcone = this.centralizarIcone(this.larguraFrame,larguraIcone);
        int yIcone = (int)(alturaFrame * 0.05);



    }

    public void addComponentesAoContainer()
    {
        painelSuperior.add(lblIconeSistema);

        painelCentral.add(lblNome);
        painelCentral.add(txtUsuario);
        painelCentral.add(lblIdentificacao);
        painelCentral.add(pwSenha);
        painelCentral.add(new JLabel(""));
        painelCentral.add(ckExibirSenha);

        painelInferior.add(new JLabel(""));
        painelInferior.add(btnAcessar);
        painelInferior.add(btnResetar);
        painelInferior.add(new JLabel(""));
        painelInferior.add(new JLabel(""));
        painelInferior.add(new JLabel(""));
        painelInferior.add(new JLabel(""));
        painelInferior.add(new JLabel(""));


        container.add("North",painelSuperior);
        container.add("South",painelInferior);
        container.add("West",PainelLateralEsquerda);
        container.add("East",PainelLateralDireita);
        container.add("Center",painelCentral);
    }

    public void addActionEvent()
    {
        btnAcessar.addActionListener(this);
        btnResetar.addActionListener(this);
        ckExibirSenha.addActionListener(this);
    }


    public int centralizarIcone(int larguraFrame, int larguraImagem){
        return (int)((larguraFrame - larguraImagem)/2);
    }

    private boolean autenticarUsuario(String _usuario, String _senha){
        for(Usuario objUsuario : Listas.listaUsuarios){
            if(objUsuario.getLogin().equals(_usuario) && objUsuario.getSenha().equals(_senha)){
                this.hide();
                SelecaoLocalFrame formSelecaoLocal = new SelecaoLocalFrame();
                formSelecaoLocal.GUISelecaoLocal();
                return true;
            }
        }
        return false;
    }

    public void GUILogin(LoginFrame loginFrame)
    {
        loginFrame.setTitle("ReservaNet | Acesso ao Sistema");
        loginFrame.setVisible(true);
        loginFrame.setBounds(10, 10, this.larguraFrame, this.alturaFrame);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Para o botão LOGIN
        if (e.getSource() == btnAcessar) {
            if(!this.autenticarUsuario(txtUsuario.getText(), pwSenha.getText())){
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }
        }

        //Para o botão RESET
        if (e.getSource() == btnResetar) {
            txtUsuario.setText("");
            pwSenha.setText("");
        }
        //Para o ckExibirSenha
        if (e.getSource() == ckExibirSenha) {
            if (ckExibirSenha.isSelected()) {
                pwSenha.setEchoChar((char) 0);
            } else {
                pwSenha.setEchoChar('*');
            }
        }
    }

}

