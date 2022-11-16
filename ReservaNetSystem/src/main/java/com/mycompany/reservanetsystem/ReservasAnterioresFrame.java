package com.mycompany.reservanetsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ReservasAnterioresFrame extends JFrame implements ActionListener {
    private int larguraFrame = 600;
    private int alturaFrame = 500;

    Container container = getContentPane();
    JFrame frame = new JFrame();

    JMenuBar menuBar = new JMenuBar();
    JMenu m1 = new JMenu("Arquivo");
    JMenu m2 = new JMenu("Editar");
    JMenuItem menuItem1 = new JMenuItem("Ver Histórico de Locações");
    JMenuItem menuItem2 = new JMenuItem("Sair");
    JMenuItem menuItem3 = new JMenuItem("Locação Anterior");

    ImageIcon iconeSistema = new ImageIcon("src/main/java/images/reservanet-icon-fundo-colorido-2.png");
    JLabel lblIconeSistema = new JLabel(iconeSistema);

    JLabel lblNome = new JLabel("Nome: <nome_pessoa>");
    JLabel lblCodigo = new JLabel("Código: <codigo_identificacao>");
    JLabel lblProximaReserva = new JLabel("Próxima Reserva: <data_prox_reserva>");
    JLabel lblListaReservas = new JLabel("Lista de Reservas ");

    //MENU
    String[] colunas = { "ID", "Locação", "Data da Locação", "Duração", "Status", "Recursos"};
    String[][] dados = {
            { "21d5f", "Sala", "2022-11-13", "1 dia", "Aprovada", "Sim" },
            { "48gg69", "Auditório", "2022-10-10", "1 dia", "Aprovada", "Não" },
            { "68d2sa", "Sala", "2022-09-14", "1 dia", "Cancelada", "Não" },
            { "23b10d", "Auditório", "2022-05-22", "1 dia", "Aprovada", "Sim" },
            { "81t0we", "Sala", "2022-05-09", "1 dia", "Cancelada", "Sim" }
    };
    JTable tabelaReservas = new JTable(dados, colunas);
    JScrollPane scrollPane = new JScrollPane(tabelaReservas);


    JButton btnEscolherSala = new JButton("SALA");
    JButton btnEscolherAuditorio = new JButton("AUDITÓRIO");
    JButton btnVerHistorico = new JButton("HISTÓRICO DE LOCAÇÕES");

    //FOOTER
    JPanel painelRodape = new JPanel();
    JLabel lblCopyright = new JLabel("© 2022 ReservaNet - LAGR");


    public ReservasAnterioresFrame()
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
        int larguraIcone = 110;
        int alturaIcone = 90;
//        int xIcone = (int)(larguraFrame * 0.06);
//        int yIcone = (int)(alturaFrame * 0.06);

        lblIconeSistema.setBounds(20,20,larguraIcone,alturaIcone);
        lblNome.setBounds(150, 30, 200, 30);
        lblCodigo.setBounds(150, 60, 200, 30);
        lblListaReservas.setBounds(20, 140, 200, 30);
        lblCopyright.setBounds(20, (alturaFrame - 35), 150, 25);
        tabelaReservas.setBounds(20,190, (int)(larguraFrame * 0.90), 150);
        painelRodape.setBounds(0, (alturaFrame - 40), larguraFrame, 40);

    }

    public void addComponentesAoContainer()
    {
        //Menu
        setJMenuBar(menuBar);
        menuBar.add(m1);
        menuBar.add(m2);
        m1.add(menuItem1);
        m1.add(menuItem2);
        m2.add(menuItem3);

        //Demais componentes
        container.add(lblIconeSistema);
        container.add(lblNome);
        container.add(lblCodigo);
        container.add(lblListaReservas);
        container.add(lblCopyright);
        container.add(tabelaReservas);
        container.add(scrollPane);
        container.add(painelRodape);
        container.add(btnEscolherAuditorio);
        container.add(btnVerHistorico);
    }

    public void addActionEvent()
    {
        btnEscolherSala.addActionListener(this);
        btnEscolherAuditorio.addActionListener(this);
    }

    public void GUIReservasAnteriores()
    {
        //Menu
        menuBar.setSize (300, 150);
        menuBar.setVisible (true);

        //Table
        tabelaReservas.setVisible(true);

        //Frame
        this.setTitle("ReservaNet | Reservas Anteriores");
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
//            String usuario = txtUsuario.getText();
//            String senha = pwSenha.getText();
//            if (usuario.equalsIgnoreCase("lbarros") && senha.equalsIgnoreCase("adm111")) {
//                JOptionPane.showMessageDialog(this, "Login Successful");
//            } else {
//                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
//            }

        }
        //Para o botão AUDITÓRIO
        if (e.getSource() == btnEscolherAuditorio) {
//            txtUsuario.setText("");
//            pwSenha.setText("");
        }

    }

}

