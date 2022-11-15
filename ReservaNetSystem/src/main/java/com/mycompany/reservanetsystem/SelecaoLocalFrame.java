package com.mycompany.reservanetsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelecaoLocalFrame extends JFrame implements ActionListener {
    private int larguraFrame = 370;
    private int alturaFrame = 600;

    Container container = getContentPane();
    JLabel lblUsuario = new JLabel("Usuário");
    JLabel lblSenha = new JLabel("Senha");
    ImageIcon iconeSistema = new ImageIcon("src/main/java/images/reservanet-icon-horizontal-login.png");
    JLabel lblIconeSistema = new JLabel(iconeSistema);
    JTextField txtUsuario = new JTextField();
    JPasswordField pwSenha = new JPasswordField();
    JButton btnAcessar = new JButton("LOGIN");
    JButton btnResetar = new JButton("RESET");
    JCheckBox ckExibirSenha = new JCheckBox("Exibir senha");

    public SelecaoLocalFrame()
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
        int yIcone = (int)(alturaFrame * 0.06);

        lblIconeSistema.setBounds(xIcone,yIcone,larguraIcone,alturaIcone);
        lblUsuario.setBounds(50, 190, 100, 30);
        lblSenha.setBounds(50, 260, 100, 30);
        txtUsuario.setBounds(150, 190, 150, 30);
        pwSenha.setBounds(150, 260, 150, 30);
        ckExibirSenha.setBounds(150, 290, 150, 30);
        btnAcessar.setBounds(50, 350, 100, 30);
        btnResetar.setBounds(200, 350, 100, 30);

    }

    public void addComponentesAoContainer()
    {
        container.add(lblUsuario);
        container.add(lblSenha);
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

    public void GUILogin(LoginFrame loginFrame)
    {
        loginFrame.setTitle("Acesso ao Sistema");
        loginFrame.setVisible(true);
        loginFrame.setBounds(10, 10, this.larguraFrame, this.alturaFrame);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setResizable(false);
    }

    public int centralizarIcone(int larguraFrame, int larguraImagem){
        return (int)((larguraFrame - larguraImagem)/2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource() == btnAcessar) {
            String usuario = txtUsuario.getText();
            String senha = pwSenha.getText();
            if (usuario.equalsIgnoreCase("lbarros") && senha.equalsIgnoreCase("adm111")) {
                JOptionPane.showMessageDialog(this, "Login Successful");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }

        }
        //Coding Part of RESET button
        if (e.getSource() == btnResetar) {
            txtUsuario.setText("");
            pwSenha.setText("");
        }
        //Coding Part of ckExibirSenha JCheckBox
        if (e.getSource() == ckExibirSenha) {
            if (ckExibirSenha.isSelected()) {
                pwSenha.setEchoChar((char) 0);
            } else {
                pwSenha.setEchoChar('*');
            }
        }
    }

}
