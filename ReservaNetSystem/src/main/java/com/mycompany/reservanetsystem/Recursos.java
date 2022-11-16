package com.mycompany.reservanetsystem;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Recursos extends JFrame implements ActionListener {
    private int larguraFrame = 370;
    private int alturaFrame = 600;

    Container container = getContentPane();
    JLabel lblTexto = new JLabel("Escolha os recursos desejados:");
    JCheckBox ckopcao1 = new JCheckBox ("Datashow");
    JCheckBox ckopcao2 = new JCheckBox ("mesa de som");
    JCheckBox ckopcao3 = new JCheckBox ("caixa de som");
    JCheckBox ckopcao4 = new JCheckBox ("notebook");
    JCheckBox ckopcao5 = new JCheckBox ("microfone");
    JButton btnVoltar = new JButton("Voltar");    
    JButton btnEscolher = new JButton("Avançar");
    JButton btnResetar = new JButton("RESET");
    
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
    
    ImageIcon iconeSistema = new ImageIcon("src/main/java/images/reservanet-icon-horizontal-login.png");
    JLabel lblIconeSistema = new JLabel(iconeSistema);


    public Recursos()
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
        lblTexto.setBounds(50, 190, 250, 30);
        ckopcao1.setBounds(50, 230, 250, 15);
        ckopcao2.setBounds(50, 250, 250, 15);
        ckopcao3.setBounds(50, 270, 250, 15);
        ckopcao4.setBounds(50, 290, 250, 15);
        ckopcao5.setBounds(50, 310, 250, 15);
        
        btnVoltar.setBounds(50, 400, 100, 30);
        btnEscolher.setBounds(200, 400, 100, 30);
        btnResetar.setBounds(50, 330, 100, 20);
        
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
        container.add(lblIconeSistema);
        container.add(ckopcao1);
        container.add(ckopcao2);
        container.add(ckopcao3);
        container.add(ckopcao4);
        container.add(ckopcao5);
        container.add(lblTexto);
        container.add(btnVoltar);
        container.add(btnEscolher);
        container.add(btnResetar);
    }

    public void GUIRecursos(Recursos recursos)
    {
        recursos.setTitle("Selecionar Recursos Adicionais");
        recursos.setVisible(true);
        recursos.setBounds(10, 10, this.larguraFrame, this.alturaFrame);
        recursos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        recursos.setResizable(false);
        recursos.setJMenuBar(bar);
    }

    public int centralizarIcone(int larguraFrame, int larguraImagem){
        return (int)((larguraFrame - larguraImagem)/2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public static void main(String[] args) {
        Recursos recursos = new Recursos();

        recursos.GUIRecursos(recursos);
    }

}
