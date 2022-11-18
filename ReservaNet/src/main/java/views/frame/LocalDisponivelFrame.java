package views.frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class LocalDisponivelFrame extends JFrame implements ActionListener {
    private int larguraFrame = 800;
    private int alturaFrame = 600;

    Object [][] dados = {
            {"Sala 45", "30", "Não"},
            {"Sala 46", "30", "Sim"},
            {"Sala 47", "30", "Sim"},
            {"Sala 48", "60", "Sim"},
            {"Sala 49", "30", "Sim"},
            {"Sala 50", "30", "Não"},
            {"Sala 51", "30", "Não"},
            {"Sala 52", "60", "Não"},
            {"Sala 53", "60", "Sim"},
            {"Sala 54", "30", "Sim"},
            {"Sala 46", "30", "Sim"},
            {"Sala 47", "30", "Sim"},
            {"Sala 48", "30", "Não"},
            {"Sala 49", "60", "Não"},
            {"Sala 50", "60", "Sim"},
            {"Sala 45", "30", "Sim"},
            {"Sala 46", "40", "Sim"},
            {"Sala 47", "40", "Sim"},
            {"Sala 45", "30", "Sim"},
            {"Sala 46", "30", "Não"},
            {"Sala 47", "60", "Não"}
    };

    String [] colunas = {"Local", "Capacidade", "Disponibilidade"};



    //Componentes de Layout ---------------
    private Container container = getContentPane();
    private BorderLayout layout = new BorderLayout(50,5);
    private JPanel painelTabela = new JPanel();
    private JPanel painelSuperior = new JPanel();
    private JPanel painelInferior = new JPanel();
    private JPanel PainelLateralDireita = new JPanel();
    private JPanel PainelLateralEsquerda = new JPanel();
    //Componentes Interativos -------------------------
    private JTable tabela = new JTable(dados, colunas);
    private JScrollPane barraRolagem = new JScrollPane(tabela);

    ImageIcon iconeSistema = new ImageIcon("src/assets/reservanet-banner.png");
    JLabel lblIconeSistema = new JLabel(iconeSistema);

    //Buttons----------------------------------------
    JButton btnConfirmar = new JButton("Confirmar");
    JButton btnCancelar = new JButton("Cancelar");

    //Menu -------------------------------------------

    JMenuBar bar = new JMenuBar();
    JMenu m1 = new JMenu("Retornar");
    JMenu m2 = new JMenu("Ajuda");
    JMenu m3 = new JMenu("Sair");

    JMenuItem a1 = new JMenuItem("Perguntas Frequentes");
    JMenuItem a2 = new JMenuItem("Ajuda");

    JMenuItem s1 = new JMenuItem("Sair do ReservaNet");

    public LocalDisponivelFrame() {
        super ("Salas Disponiveis");
        addActionEvent();
        definirLayout();
        definirLocalizacaoETamanho();
        addComponentes();
    }

    public void definirLayout()
    {
        container.setLayout(layout);
        painelTabela.setLayout(new GridLayout(1,1));
        painelSuperior.setLayout(new GridLayout(1,1));
        painelInferior.setLayout(new GridLayout(1,4, 30,30));
        PainelLateralDireita.setLayout(null);
        PainelLateralEsquerda.setLayout(null);
    }


    public int centralizarIcone(int larguraFrame, int larguraImagem){
        return (int)((larguraFrame - larguraImagem)/2);
    }
    public void definirLocalizacaoETamanho()
    {
        int larguraIcone = 800;
        int alturaIcone = 238;
        int xIcone = this.centralizarIcone(this.larguraFrame,larguraIcone);
        int yIcone = (int)(alturaFrame * 0.05);



        lblIconeSistema.setBounds(xIcone,yIcone,larguraIcone,alturaIcone);

    }


    public void addActionEvent()
    {
        btnCancelar.addActionListener(this);
        btnConfirmar.addActionListener(this);
    }

    public void addComponentes() {

        painelTabela.add(barraRolagem);
        painelSuperior.add(lblIconeSistema);
        painelInferior.add(new JLabel(""));
        painelInferior.add(btnConfirmar);
        painelInferior.add(btnCancelar);
        painelInferior.add(new JLabel(""));
        PainelLateralDireita.add(new JLabel(""));
        PainelLateralEsquerda.add(new JLabel(""));


        bar.add(m1);
        bar.add(m2);
        bar.add(m3);
        m2.add(a1);
        m2.add(a2);
        m3.add(s1);

        container.add("North",painelSuperior);
        container.add("South",painelInferior);
        container.add("West",PainelLateralEsquerda);
        container.add("East",PainelLateralDireita);
        container.add("Center",painelTabela);

    }
    public void GUI(){

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(larguraFrame, alturaFrame);
        setVisible(true);
        setResizable(false);
        setJMenuBar(bar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if( e.getSource() == btnConfirmar){
            int flag = JOptionPane.showConfirmDialog(this,
                                                    "Deseja Concluir a Locação ?",
                                                    "Locação",
                                                    JOptionPane.YES_NO_OPTION);

            if (flag == 0){
                JOptionPane.showMessageDialog(this,
                                                "Aguarde a Confirmação da Locação");
                this.hide();
                SelecaoLocalFrame slf = new SelecaoLocalFrame();
                slf.GUISelecaoLocal();
            }

        }

        if( e.getSource() == btnCancelar) {
            int flag = JOptionPane.showConfirmDialog(this,
                    "Deseja Cancelar a Locação ?",
                    "Locação",
                    JOptionPane.YES_NO_OPTION);

            if (flag == 0) {
                this.hide();
                SelecaoLocalFrame slf = new SelecaoLocalFrame();
                slf.GUISelecaoLocal();
            }
        }
    }
}
