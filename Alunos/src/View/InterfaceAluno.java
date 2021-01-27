package View;

import Controller.Aluno;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class InterfaceAluno extends JFrame implements ActionListener {
    private JButton jBCadastrar, jBPesquisar, jBExcluir, jBAlterar;
    private JLabel jLNumAluno, jLNome, jLEndereco, jLCidade, jLTelefone, jLNumCurso;
    private JTextField  jNumAluno, jNome, jEndereco, jCidade, jTelefone, jNumCurso;
    private JPanel jPBotoes, jPTitulos, jPCampos;
    private int NumCurso, NumAluno;
    private String Nome, Endereco, Cidade,  Telefone;
    Aluno aluno = new Aluno();
    
    public InterfaceAluno() {
        init();
    }
    
    public void init() {
        setTitle("Cadastro de Aluno");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(700, 200);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.GRAY);
        
        jPBotoes = new JPanel(new GridLayout(2,2,5,5));
        jPTitulos = new JPanel(new GridLayout(4,1,5,5));
        jPCampos = new JPanel(new GridLayout(4,1,5,5));
        
        jBCadastrar = new JButton("Cadastrar");
        jBCadastrar.setBackground(Color.ORANGE);
        jBPesquisar = new JButton("Pesquisar");
        jBPesquisar.setBackground(Color.ORANGE);
        jBExcluir = new JButton("Excluir");
        jBExcluir.setBackground(Color.ORANGE);
        jBAlterar = new JButton("Alterar");
        jBAlterar.setBackground(Color.ORANGE);
        
        jBCadastrar.addActionListener(this);
        jBPesquisar.addActionListener(this);
        jBExcluir.addActionListener(this);
        jBAlterar.addActionListener(this);
        
        jLNumAluno = new JLabel("Numero Aluno:"); 
        jNumAluno = new JTextField("" + this.NumAluno,20);
        jLNome = new JLabel("Nome:"); 
        jNome = new JTextField(""+this.Nome,20);
        jLEndereco = new JLabel("Endereço:"); 
        jEndereco = new JTextField("" + this.Endereco,40);
        jLCidade= new JLabel("Cidade:");  
        jCidade = new JTextField("" + this.Cidade,20);
        jLTelefone = new JLabel("Telefone:");
        jTelefone = new JTextField(" "+this.Telefone,20);
        jLNumCurso = new JLabel("Curso:"); 
        jNumCurso = new JTextField("" + this.NumCurso,20);
      
        jPBotoes.add(jBCadastrar);
        jPBotoes.add(jBPesquisar);
        jPBotoes.add(jBExcluir);
        jPBotoes.add(jBAlterar);
        jPBotoes.setBackground(Color.GRAY);
        
        jPTitulos.add(jLNome);
        jPTitulos.add(jLEndereco);
        jPTitulos.add(jLCidade);
        jPTitulos.add(jLTelefone);
        jPTitulos.add(jLNumCurso);
        jPTitulos.add(jLNumAluno);
        jPTitulos.setBackground(Color.GRAY);
        
        jPCampos.add(jNome);
        jPCampos.add(jEndereco);
        jPCampos.add(jCidade);
        jPCampos.add(jTelefone);
        jPCampos.add(jNumCurso);
        jPCampos.add(jNumAluno);
        jPCampos.setBackground(Color.GRAY);
        
        JPanel principal = new JPanel(new GridLayout(1, 3));
        principal.add(jPBotoes, BorderLayout.WEST);
        principal.add(jPTitulos, BorderLayout.CENTER);
        principal.add(jPCampos, BorderLayout.EAST);
        principal.setOpaque(false);
        principal.setSize(this.getSize());
        this.add(principal);
        
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
        this.NumAluno = Integer.parseInt(jNumAluno.getText());
        this.Nome = jNome.getText();
        this.Endereco = jEndereco.getText();
        this.Cidade = jCidade.getText();
        this.Telefone = jTelefone.getText();
        this.NumCurso = Integer.parseInt(jLNumCurso.getText());
        
        
        if(e.getSource() == jBCadastrar) {
            aluno.cadastrar( this.NumAluno,this.Nome,this.Endereco,this.Cidade,this.Telefone,this.NumCurso);
        }
        else if(e.getSource() == jBPesquisar) {
            aluno.pesquisar();
        }
        else if(e.getSource() == jBExcluir) {
            aluno.excluir();
        }
        else if(e.getSource() == jBAlterar) {
            aluno.alterar(this.NumAluno,this.Nome,this.Endereco,this.Cidade,this.Telefone,this.NumCurso);
        }
    }
}
