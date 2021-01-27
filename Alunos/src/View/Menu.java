package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Menu  extends JFrame implements ActionListener {
    private JButton jBCadastrar, jBEncerrar;
    private JPanel jPBotoes;
    
    public Menu() {
        init();
    }
    
    public void init() {
        setTitle("Menu");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(200, 200);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.GRAY);
        
        jPBotoes = new JPanel(new GridLayout(3,1,5,5));
        
        jBCadastrar = new JButton("Cadastrar Aluno");
        jBCadastrar.setBackground(Color.BLUE);
        jBEncerrar = new JButton("Encerrar");
        jBEncerrar.setBackground(Color.red);
        jBCadastrar.addActionListener(this);
        jBEncerrar.addActionListener(this);
        
        jPBotoes.add(jBCadastrar);
        jPBotoes.add(jBEncerrar);
        jPBotoes.setBackground(Color.GRAY);
        
        this.add(jPBotoes, BorderLayout.CENTER);
        
        JPanel p1 = new JPanel();
        p1.setOpaque(false);
        p1.setPreferredSize(new Dimension(10,10));
        JPanel p2 = new JPanel();
        p2.setOpaque(false);
        p2.setPreferredSize(new Dimension(10,10));
        JPanel p3 = new JPanel();
        p3.setOpaque(false);
        p3.setPreferredSize(new Dimension(10,10));
        JPanel p4 = new JPanel();
        p4.setOpaque(false);
        p4.setPreferredSize(new Dimension(10,10));
        this.add(p1, BorderLayout.NORTH);
        this.add(p2, BorderLayout.SOUTH);
        this.add(p3, BorderLayout.EAST);
        this.add(p4, BorderLayout.WEST);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jBCadastrar) {
            InterfaceAluno intAL = new InterfaceAluno();
            intAL.setVisible(true);
        }
       
        else if(e.getSource() == jBEncerrar) {
            JOptionPane.showMessageDialog(null, "Ate Logo!", "Por hoje e só", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
    
}
