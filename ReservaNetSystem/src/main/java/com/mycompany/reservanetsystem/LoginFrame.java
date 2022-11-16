package com.mycompany.reservanetsystem;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame implements ActionListener {
    private int larguraFrame = 370;
    private int alturaFrame = 600;

    Container container = getContentPane();
    ImageIcon iconeSistema = new ImageIcon("src/main/java/images/reservanet-icon-horizontal-login.png");
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
        container.setLayout(null);
    }

    public void definirLocalizacaoETamanho()
    {
        //Dimensoes do Icone
        int larguraIcone = 250;
        int alturaIcone = 110;
        int xIcone = this.centralizarIcone(this.larguraFrame,larguraIcone);
        int yIcone = (int)(alturaFrame * 0.05);

        lblIconeSistema.setBounds(xIcone,yIcone,larguraIcone,alturaIcone);
        lblNome.setBounds(50, 190, 100, 30);
        lblIdentificacao.setBounds(50, 260, 100, 30);
        txtUsuario.setBounds(150, 190, 150, 30);
        pwSenha.setBounds(150, 260, 150, 30);
        ckExibirSenha.setBounds(150, 290, 150, 30);
        btnAcessar.setBounds(50, 350, 100, 30);
        btnResetar.setBounds(200, 350, 100, 30);

    }

    public void addComponentesAoContainer()
    {
        container.add(lblNome);
        container.add(lblIdentificacao);
        container.add(lblIconeSistema);
        container.add(txtUsuario);
        container.add(pwSenha);
        container.add(ckExibirSenha);
        container.add(btnAcessar);
        container.add(btnResetar);
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
                JOptionPane.showMessageDialog(this, "Login Successful");
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

                //Remove it later
                this.hide();
                ReservasAnterioresFrame formReservasAnteriores = new ReservasAnterioresFrame();
                formReservasAnteriores.GUIReservasAnteriores();
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

