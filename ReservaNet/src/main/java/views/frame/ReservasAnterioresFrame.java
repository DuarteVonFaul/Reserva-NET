package views.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ReservasAnterioresFrame extends JFrame implements ActionListener {
    private int larguraFrame = 800;
    private int alturaFrame = 600;
    //Componentes de Layout ---------------
    private Container container = getContentPane();
    private BorderLayout layout = new BorderLayout(10,30);
    private JPanel painelCentral = new JPanel();
    private JPanel painelUser = new JPanel();
    private JPanel painelInfoUser = new JPanel();
    private JPanel painelTabela = new JPanel();
    private JPanel painelBotoes = new JPanel();

    //Menu bar ----------------------------------------
    JMenuBar menuBar = new JMenuBar();
    JMenu m1 = new JMenu("Arquivo");
    JMenu m2 = new JMenu("Editar");
    JMenuItem menuItem1 = new JMenuItem("Ver Histórico de Locações");
    JMenuItem menuItem2 = new JMenuItem("Sair");
    JMenuItem menuItem3 = new JMenuItem("Locação Anterior");
    //Componetes Interativos ---------------------------------------
    ImageIcon iconeSistema = new ImageIcon("src/assets/reservanet-icon-fundo-colorido-2.png");
    JLabel lblIconeSistema = new JLabel(iconeSistema);

    JLabel lblNome = new JLabel("Nome: Pedro Rodriguês da Silva");
    JLabel lblCodigo = new JLabel("Código: RD037865-SSP");
    JLabel lblProximaReserva = new JLabel("Próxima Reserva: <data_prox_reserva>");
    JLabel lblListaReservas = new JLabel("Lista de Reservas ");

    //MENU

    String[] colunas = { "ID", "Locação", "Data da Locação", "Duração", "Status", "Recursos"};
    String[][] dados = {
            { "21d5f", "Sala", "2022-11-13", "1 dia", "Aprovada", "Sim" },
            { "48gg69", "Auditório", "2022-10-10", "1 dia", "Aprovada", "Não" },
            { "68d2sa", "Sala", "2022-09-14", "1 dia", "Cancelada", "Não" },
            { "23b10d", "Auditório", "2022-05-22", "1 dia", "Aprovada", "Sim" },
            { "81t0we", "Sala", "2022-05-09", "1 dia", "pendente", "Sim" }
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
        addComponentes();
        addActionEvent();
    }

    public void definirLayout()
    {


        container.setLayout(layout);
        painelUser.setLayout(new GridLayout(1,2,0,0));
        painelInfoUser.setLayout(new GridLayout(6,1,0,10));
        painelBotoes.setLayout(new GridBagLayout());
        painelTabela.setLayout(new GridBagLayout());



    }

    public void definirLocalizacaoETamanho()
    {
        //Dimensoes do Icone
        int larguraIcone = 110;
        int alturaIcone = 90;
//        int xIcone = (int)(larguraFrame * 0.06);
//        int yIcone = (int)(alturaFrame * 0.06);



    }

    public void addComponentes()
    {


        //Menu
        setJMenuBar(menuBar);
        menuBar.add(m1);
        menuBar.add(m2);
        m1.add(menuItem1);
        m1.add(menuItem2);
        m2.add(menuItem3);
        //Painel

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.gridx = 0;
        gbc4.gridy = 1;
        gbc4.weightx = 6.0;
        gbc4.weighty = 6.0;
        gbc4.fill = GridBagConstraints.BOTH;

        painelTabela.add(lblListaReservas, gbc);
        painelTabela.add(scrollPane, gbc4);


        painelInfoUser.add(new JLabel(""));
        painelInfoUser.add(new JLabel(""));
        painelInfoUser.add(lblNome);
        painelInfoUser.add(lblCodigo);
        painelInfoUser.add(new JLabel(""));
        painelInfoUser.add(new JLabel(""));


        painelUser.add(lblIconeSistema);
        painelUser.add(painelInfoUser);
        painelUser.add(new JLabel(""));
        painelUser.add(new JLabel(""));

        gbc.fill = GridBagConstraints.VERTICAL;
        painelBotoes.add(lblCopyright, gbc);



        //Demais componentes
       container.add("North",painelUser);
       container.add("South",painelBotoes);
        container.add("West", new JPanel());
        container.add("East", new JPanel());
        container.add("Center",painelTabela);

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

