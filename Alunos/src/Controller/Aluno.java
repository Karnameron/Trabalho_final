package Controller;

import javax.swing.JOptionPane;

import ConectaBD.Conecta;

import java.sql.*;

public class Aluno {
    private int NumAluno;
    private String Nome;
    private String Endereco;
    private String Cidade; 
    private String Telefone;
    private int NumCurso;
    Conecta conexao = new Conecta();
     
    public Aluno() {
        this.NumAluno = 0;
        this.Nome = "";
        this.Endereco = "";
        this.Cidade = "";
        this.Telefone = "";
        this.NumCurso = 0;
    }
    
  
    public int getNumAluno() {
		return NumAluno;
	}

	public void setNumAluno(int numAluno) {
		NumAluno = numAluno;
	}


	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getEndereco() {
		return Endereco;
	}

	public void setEndereco(String endereco) {
		Endereco = endereco;
	}

	public String getCidade() {
		return Cidade;
	}
	public void setCidade(String cidade) {
		Cidade = cidade;
	}

	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String telefone) {
		Telefone = telefone;
	}

	public int getNumCurso() {
		return NumCurso;
	}

	public void setNumCurso(int numCurso) {
		NumCurso = numCurso;
	}


	public void cadastrar(int a, String b, String c, String d, String e, int f) {
     
        setNumAluno(a);
        setNome(b);
        setEndereco(c);
        setCidade(d);
        setTelefone(e);
        setNumCurso(f);
        
        int tem = verificaHaDados(getNumAluno());
        
        if(tem > 0){
            JOptionPane.showMessageDialog(null, "Impossivel cadastrar!"
                    + "\não, existem dados cadastrados neste Numero.","Erro",JOptionPane.INFORMATION_MESSAGE);
        }else if(getNumAluno() == 0){
            JOptionPane.showMessageDialog(null, "Impossivel cadastrar!"
                    + "\n Numero 0 não e valido.","Erro",JOptionPane.INFORMATION_MESSAGE);
        }else{
            String comando = "INSERT INTO aluno(NumAluno,Nome,Endereco,Cidade,Telefone,NumCurso) VALUES ("
                    + getNumAluno()+ ",'" + getNome() + "'," + getEndereco() + ",'" + getCidade()+ "'," + getTelefone() +"',"+getNumCurso()+")";
       
 
            conexao.executaUpdateSQL(comando);

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!","Sucesso",JOptionPane.INFORMATION_MESSAGE);
        }
    }
   
    public void pesquisar() {
        Object[] opcoes = {"Mostrar Todos","Apenas Um"};
        String opcao = "" + JOptionPane.showInputDialog(null,"Qual o tipo de Pesquisa?","Pesquisa",
                JOptionPane.INFORMATION_MESSAGE,null,opcoes,opcoes[0]);
                
        if(opcao.equals("Mostrar Todos")){
            String comando = "SELECT * FROM aluno;";

            try{
            ResultSet rs = conexao.executaQuerySQL(comando);

            String texto = "##### DADOS DOS ALUNOS #####\n";

            while(rs.next()){
                texto += "Numero aluno: " + rs.getString("numero aluno");
                texto += " | Nome: " + rs.getString("nome");
                texto += " | Idade: " + rs.getString("idade");
                texto += " | Cidade: " + rs.getString("cidade"); 
                texto += " | Telefone: " + rs.getString("telefone"); 
                texto += " | Numero Curso: " + rs.getString("numero curso")
                + "\n";
            }
            rs.close();

            JOptionPane.showMessageDialog(null, texto,"Resultado",JOptionPane.INFORMATION_MESSAGE);
            }catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Erro na execusão da Query"
                        + "\nErro: " + e.getMessage());
            }
        }
        else if(opcao.equals("Apenas Um")){
            setNumAluno(Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o numero do aluno a ser pesquisado?", "Numero Aluno", JOptionPane.QUESTION_MESSAGE)));
            
            int tem = verificaHaDados(getNumAluno());
        
            if(tem == 0){
                JOptionPane.showMessageDialog(null, "Impossivel pesquisar!"
                        + "\n não existem dados cadastrados neste numero","Erro",JOptionPane.INFORMATION_MESSAGE);
            }else{
                String comando = "SELECT * FROM aluno WHERE aluno.NumAluno = " + getNumAluno() + ";";

                try{
                ResultSet rs = conexao.executaQuerySQL(comando);

                String texto = "##### DADOS DO ALUNO #####\n";

                if(rs.next()){
                    texto += "RGM: " + rs.getString("rgm");
                    texto += "\nNome: " + rs.getString("nome");
                    texto += "\nEndereço: " + rs.getString("Endereço");
                    texto += "\nCidade: " + rs.getString("turma");
                }
                rs.close();

                JOptionPane.showMessageDialog(null, texto,"Resultado",JOptionPane.INFORMATION_MESSAGE);
                }catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro na execuÃ§Ã£o da Query"
                            + "\nErro: " + e.getMessage());
                }
            }
        }
        conexao.fechaConexao();
    }
    
    public void excluir() {
        setNumAluno(Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o Numero do aluno a ser excluido?", "Numero Aluno", JOptionPane.QUESTION_MESSAGE)));
        
        int tem = verificaHaDados(getNumAluno());
        
        if(tem == 0){
            JOptionPane.showMessageDialog(null, "Impossivel excluir!"
                    + "\nNão existem dados cadastrados neste numero","Erro",JOptionPane.INFORMATION_MESSAGE);
        }else{
            String comando = "DELETE FROM aluno WHERE aluno.NumAluno = "
                    + getNumAluno() + ";";
            conexao.executaUpdateSQL(comando);

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!","Sucesso",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void alterar(int a, String b, String c, String d, String e, int f) {
        setNumAluno(Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o Numero do aluno a ser alterado?", "Numero Aluno", JOptionPane.QUESTION_MESSAGE)));
        
        setNumAluno(a);
        setNome(b);
        setEndereco(c);
        setCidade(d);
        setTelefone(e);
        setNumCurso(f);
        int tem = verificaHaDados(getNumAluno());
        
        if(tem == 0){
            JOptionPane.showMessageDialog(null, "Impossivel alterar!"
                    + "\nNão existem dados cadastrados neste numero","Erro",JOptionPane.INFORMATION_MESSAGE);
        }else{
            tem = verificaHaDados(a);
            
            if(tem == 0){
                String comando = "UPDATE aluno SET nome = '" + getNome() + "',"
                        + " endereço = " + getEndereco() + ", cidade = '" + getCidade()+ "',"
                        + " telefone = " + getTelefone() + ", numero curso ='" + getNumCurso() +"';"
                        + " numero aluno = " + a + " WHERE numero aluno = " + getNumAluno() + ";";
                
            
                conexao.executaUpdateSQL(comando);

                JOptionPane.showMessageDialog(null, "Alterado com sucesso!","Sucesso",JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Impossivel alterar!"
                    + "\nO Numero Aluno " + a + " ja esta em uso.","Erro",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    public int verificaHaDados(int a) {
        String comando = "SELECT COUNT(*) FROM aluno WHERE aluno.NumAluno = "
                + a + ";";
        ResultSet rs = conexao.executaQuerySQL(comando);
        
        int tem = 0;
        
        try{
            if(rs.next()){
                    tem = Integer.parseInt(rs.getString("COUNT(*)"));
                }
            rs.close();

            return tem;
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na execusão da Query"
                    + "\nErro: " + e.getMessage());
            return tem; 
        }
    }
    
}
