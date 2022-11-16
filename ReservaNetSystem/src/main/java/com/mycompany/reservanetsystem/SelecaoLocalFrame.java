package com.mycompany.reservanetsystem;

import javax.swing.*;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SelecaoLocalFrame extends JFrame implements ActionListener {
    private int larguraFrame = 500;
    private int alturaFrame = 400;

    Container container = getContentPane();
    JLabel lblBoasVindas = new JLabel("Seja bem-vindo(a)!");
    JLabel lblMensagemAcao = new JLabel("Que tipo de locação deseja fazer?");
    ImageIcon iconeSistema = new ImageIcon("src/main/java/images/reservanet-icon-horizontal-login.png");
    JLabel lblIconeSistema = new JLabel(iconeSistema);
    JTextField txtUsuario = new JTextField();
    JPasswordField pwSenha = new JPasswordField();
    JButton btnEscolherSala = new JButton("SALA");
    JButton btnEscolherAuditorio = new JButton("AUDITÓRIO");
    JButton btnVerHistorico = new JButton("HISTÓRICO DE LOCAÇÕES");

    JMenuBar menuBar = new JMenuBar();
    JMenu m1 = new JMenu("Arquivo");
    JMenu m2 = new JMenu("Editar");
    JMenuItem menuItem1 = new JMenuItem("Ver Histórico de Locações");
    JMenuItem menuItem2 = new JMenuItem("Sair");
    JMenuItem menuItem3 = new JMenuItem("Locação Anterior");

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
        int xIcone = this.alinharIcone(this.larguraFrame,larguraIcone);
        int yIcone = (int)(alturaFrame * 0.06);

        lblIconeSistema.setBounds(xIcone,yIcone,larguraIcone,alturaIcone);
        lblBoasVindas.setBounds(50, 190, 100, 30);
        lblMensagemAcao.setBounds(50, 210, 100, 30);
        btnEscolherSala.setBounds(50, 260, 100, 30);
        btnEscolherAuditorio.setBounds(200, 260, 100, 30);
        btnVerHistorico.setBounds(50, 290, 250, 30);

    }

    public void addComponentesAoContainer()
    {
        menuBar.add(m1);
        menuBar.add(m2);

        m1.add(menuItem1);
        m1.add(menuItem2);

        m2.add(menuItem3);

        container.add(menuBar);
        container.add(lblIconeSistema);
        container.add(lblBoasVindas);
        container.add(lblMensagemAcao);
        container.add(btnEscolherSala);
        container.add(btnEscolherAuditorio);
        container.add(btnVerHistorico);
    }

    public void addActionEvent()
    {
        btnEscolherSala.addActionListener(this);
        btnEscolherAuditorio.addActionListener(this);
    }

    public void GUISelecaoLocal()
    {
        this.setTitle("ReservaNet | Escolha Local");
        this.setVisible(true);
        this.setBounds(10, 10, this.larguraFrame, this.alturaFrame);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }

    public int alinharIcone(int larguraFrame, int larguraImagem){
        return (int)((larguraFrame - larguraImagem)/2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Para o botão SALA
        if (e.getSource() == btnEscolherSala) {
            String usuario = txtUsuario.getText();
            String senha = pwSenha.getText();
            if (usuario.equalsIgnoreCase("lbarros") && senha.equalsIgnoreCase("adm111")) {
                JOptionPane.showMessageDialog(this, "Login Successful");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }

        }
        //Para o botão AUDITÓRIO
        if (e.getSource() == btnEscolherAuditorio) {
            txtUsuario.setText("");
            pwSenha.setText("");
        }

    }

}

