package views.frame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SelecaoLocalFrame extends JFrame implements ActionListener {
    private int larguraFrame = 800;
    private int alturaFrame = 600;

    //Componentes de Layout ---------------
    private Container container = getContentPane();

    //Componentes Interativos--------------------------------------------
    JLabel lblBoasVindas = new JLabel("Seja bem-vindo(a)!");
    JLabel lblMensagemAcao = new JLabel("Que tipo de locação deseja fazer?");
    ImageIcon iconeSistema = new ImageIcon("src/assets/reservanet-banner-login.png");
    ImageIcon Separador = new ImageIcon("src/assets/separar.png");

    JLabel lblIconeSistema = new JLabel(iconeSistema);

    private Font fonte = new Font("SansSerif", Font.BOLD, 25);
    JLabel lblSeparador = new JLabel(Separador);

    JLabel lblAuditorio = new JLabel("Auditório");
    JLabel lblSala = new JLabel("Sala");
    JButton btnEscolherSala = new JButton(new ImageIcon("src/assets/Sala.png"));
    JButton btnEscolherAuditorio = new JButton(new ImageIcon("src/assets/Auditorio.png"));
    JButton btnVerHistorico = new JButton("HISTÓRICO DE LOCAÇÕES");
    JButton btnSair = new JButton("SAIR");

    //Menu Bar ----------------------------------------
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

        btnEscolherSala.setBorder(BorderFactory.createEmptyBorder()) ;
        btnEscolherSala.setContentAreaFilled(false);
        btnEscolherSala.setBounds(365, 200, 160, 160);

        lblSala.setBounds(420, 360, 160, 30);
        lblSala.setFont(fonte);

        btnEscolherAuditorio.setBorder(BorderFactory.createEmptyBorder()) ;
        btnEscolherAuditorio.setContentAreaFilled(false);
        btnEscolherAuditorio.setBounds(565, 200, 160, 160);

        lblAuditorio.setBounds(590, 360, 160, 30);
        lblAuditorio.setFont(fonte);

        lblSeparador.setBounds(300,0,10,600);

        lblIconeSistema.setBounds(xIcone,yIcone,larguraIcone,alturaIcone);
        lblBoasVindas.setBounds(20, 70, 200, 30);
        lblMensagemAcao.setBounds(20, 100, 200, 30);


        btnVerHistorico.setBounds(25, 240, 250, 30);
        btnSair.setBounds(95, 300, 100, 30);

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
        container.add(lblSeparador);
        container.add(lblAuditorio);
        container.add(lblSala);
        container.add(btnSair);
        container.add(btnEscolherSala);
        container.add(btnEscolherAuditorio);
        container.add(btnVerHistorico);
    }

    public void addActionEvent()
    {
        btnEscolherSala.addActionListener(this);
        btnEscolherAuditorio.addActionListener(this);
        btnVerHistorico.addActionListener(this);
    }

    public void GUISelecaoLocal()
    {
        this.setTitle("Acesso ao Sistema");
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
            this.hide();
            RecursosFrame recursosFrame = new RecursosFrame();
            recursosFrame.GUI();

        }
        //Para o botão AUDITÓRIO
        if (e.getSource() == btnEscolherAuditorio) {

        }

        if (e.getSource() == btnVerHistorico){
            this.hide();

            ReservasAnterioresFrame reservasAnterioresFrame = new ReservasAnterioresFrame();
            reservasAnterioresFrame.GUIReservasAnteriores();
        }

    }

}