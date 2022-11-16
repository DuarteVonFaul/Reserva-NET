package com.mycompany.reservanetsystem;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class SelecaoLocalFrame extends JFrame{
    private int larguraFrame = 370;
    private int alturaFrame = 600;

    Container container = getContentPane();
    JLabel lblSelecionaLocal = new JLabel("Selecione o local a ser reservado");
    ImageIcon iconeSistema = new ImageIcon("src/main/java/images/reservanet-icon-horizontal-login.png");
    JLabel lblIconeSistema = new JLabel(iconeSistema);
    JButton btnSala = new JButton("SALA");
    JButton btnAuditorio = new JButton("AUDITÓRIO");

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
            
    public SelecaoLocalFrame()
    {
        definirLayout();
        definirLocalizacaoETamanho();
        addComponentesAoContainer();
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
        lblSelecionaLocal.setBounds(50, 190, 200, 30);
        btnSala.setBounds(50, 260, 100, 30);
        btnAuditorio.setBounds(200, 260, 100, 30);

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
        
    }

    public void addComponentesAoContainer()
    {
        container.add(lblSelecionaLocal);
        container.add(lblIconeSistema);
        container.add(btnSala);
        container.add(btnAuditorio);
    }

    public void GUISelecaoLocal(SelecaoLocalFrame selecaoLocalFrame)
    {
        selecaoLocalFrame.setTitle("Selecionar Local");
        selecaoLocalFrame.setVisible(true);
        selecaoLocalFrame.setBounds(10, 10, this.larguraFrame, this.alturaFrame);
        selecaoLocalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        selecaoLocalFrame.setResizable(false);
        selecaoLocalFrame.setJMenuBar(bar);
            
    }

    public int centralizarIcone(int larguraFrame, int larguraImagem){
        return (int)((larguraFrame - larguraImagem)/2);
    }
   
    public static void main(String[] args) {
        SelecaoLocalFrame selecaoLocalFrame = new SelecaoLocalFrame();

        selecaoLocalFrame.GUISelecaoLocal(selecaoLocalFrame);
   
    }
}

