package views.frame;

import org.jdatepicker.DateModel;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import src.utils.DateLabelFormatter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Properties;

public class RecursosFrame extends JFrame implements  ActionListener{

    private int larguraFrame = 800;
    private int alturaFrame = 600;


    private Container container = getContentPane();
    private BorderLayout layout = new BorderLayout(100,100);
    private JPanel painelEscolherRecursos = new JPanel();
    private JPanel painelBotoes = new JPanel();
    private JPanel painelCentral = new JPanel();
    private JPanel painelDataCapaxcidade = new JPanel();
    private JPanel painelBanner = new JPanel();

    UtilDateModel model = new UtilDateModel();
    Properties p = new Properties();

    JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
    JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
    JLabel lblTexto = new JLabel("Recursos desejados:");
    JCheckBox ckopcao1 = new JCheckBox ("Datashow");
    JCheckBox ckopcao2 = new JCheckBox ("mesa de som");
    JCheckBox ckopcao3 = new JCheckBox ("caixa de som");
    JCheckBox ckopcao4 = new JCheckBox ("notebook");
    JCheckBox ckopcao5 = new JCheckBox ("microfone");
    JButton btnVoltar = new JButton("Voltar");
    JButton btnAvançar = new JButton("Avançar");

    JMenuBar bar = new JMenuBar();
    JMenu m1 = new JMenu("Reservas");
    JMenu m2 = new JMenu("Ajuda");
    JMenu m3 = new JMenu("Sair");

    JMenuItem r1 = new JMenuItem("Visualizar");
    JMenuItem r2 = new JMenuItem("Imprimir");
    JMenuItem r3 = new JMenuItem("Alterar");
    JMenuItem r4 = new JMenuItem("Cancelar");
    JMenuItem r5 = new JMenuItem("Histórico");

    JMenuItem a1 = new JMenuItem("Perguntas Frequentes");
    JMenuItem a2 = new JMenuItem("Ajuda");

    JMenuItem s1 = new JMenuItem("Sair do ReservaNet");

    ImageIcon iconeSistema = new ImageIcon("src/assets/reservanet-banner.png");
    JLabel lblIconeSistema = new JLabel(iconeSistema);


    public RecursosFrame()
    {
        addActionEvent();
        definirLayout();
        definirLocalizacaoETamanho();
        addComponentes();
    }

    public void definirLayout()
    {
        container.setLayout(layout);
        painelCentral.setLayout(new GridLayout(1,2));
        painelBotoes.setLayout(new GridLayout(2,4,20,0));
        painelEscolherRecursos.setLayout(new GridLayout(4,2));
        painelDataCapaxcidade.setLayout(new GridLayout(4,1));
        painelBanner.setLayout(new GridLayout(1,1));
        //painelLateralEsquerda.setLayout(new GridLayout(1,1));
    }

    public void definirLocalizacaoETamanho()
    {
        //Dimensoes do Icone
        int larguraIcone = 250;
        int alturaIcone = 110;
        int xIcone = this.centralizarIcone(this.larguraFrame,larguraIcone);
        int yIcone = (int)(alturaFrame * 0.06);
        lblIconeSistema.setBounds(xIcone,yIcone,larguraIcone,alturaIcone);

        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");




    }

    public void addComponentes()
    {

        bar.add(m1);
        bar.add(m2);
        bar.add(m3);
        m1.add(r1);
        m1.add(r2);
        m1.add(r3);
        m1.add(r4);
        m1.add(r5);
        m2.add(a1);
        m2.add(a2);
        m3.add(s1);

        painelBanner.add(lblIconeSistema);

        painelEscolherRecursos.add(lblTexto);
        painelEscolherRecursos.add(new JLabel(""));

        painelEscolherRecursos.add(ckopcao1);
        painelEscolherRecursos.add(ckopcao2);
        painelEscolherRecursos.add(ckopcao3);
        painelEscolherRecursos.add(ckopcao4);
        painelEscolherRecursos.add(ckopcao5);

        painelDataCapaxcidade.add(new JLabel("Data Reserva"));
        painelDataCapaxcidade.add(datePicker);
        painelDataCapaxcidade.add(new JLabel("capacidade"));
        painelDataCapaxcidade.add(new JTextField());

        painelCentral.add(painelEscolherRecursos);
        painelCentral.add(painelDataCapaxcidade);

        painelBotoes.add(new JLabel(""));
        painelBotoes.add(btnVoltar);
        painelBotoes.add(btnAvançar);
        painelBotoes.add(new JLabel(""));
        painelBotoes.add(new JLabel(""));
        painelBotoes.add(new JLabel(""));
        painelBotoes.add(new JLabel(""));
        painelBotoes.add(new JLabel(""));


        container.add("North",painelBanner);
        container.add("South",painelBotoes);
        container.add("West",new JLabel(""));
        container.add("East",new JLabel(""));
        container.add("Center",painelCentral);

    }

    public void GUI()
    {
        setTitle("Selecionar Recursos Adicionais");
        setVisible(true);
        setSize(larguraFrame, alturaFrame);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setJMenuBar(bar);
    }

    public int centralizarIcone(int larguraFrame, int larguraImagem){
        return (int)((larguraFrame - larguraImagem)/2);
    }

    public void addActionEvent()
    {
        btnAvançar.addActionListener(this);
        btnVoltar.addActionListener(this);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnAvançar){
            this.hide();
            LocalDisponivelFrame localdisponivelframe = new LocalDisponivelFrame();
            localdisponivelframe.GUI();
        }

        if(e.getSource() == btnVoltar){
            this.hide();
            SelecaoLocalFrame selecaolocal = new SelecaoLocalFrame();
            selecaolocal.GUISelecaoLocal();
        }
    }
}
