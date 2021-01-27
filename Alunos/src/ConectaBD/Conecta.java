package ConectaBD;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conecta {
    private String driver, url, user, senha;
    private Connection conexao;
    private Statement fluxoSQL;
    private ResultSet rs;
    
    public Conecta() {
        this.url = "jdbc:mysql://localhost:3306/prova-bd";
        this.user = "root";
        this.senha = "pedropedro1234";
    }
    
    public Connection abreConexao() {
        try{
            this.driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            this.conexao = DriverManager.getConnection(url, user, senha);
            //JOptionPane.showMessageDialog(null, "Conectado");
            return conexao;
        }
        catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Classe JDBC não encontrada.");
            return null;
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao se conectar com o banco."
                    + "\nVerifique URL, USER ou SENHA");
            return null;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            return null;
        }
    }
    
    public void fechaConexao() {
        try{
            conexao.close();
            //JOptionPane.showMessageDialog(null, "Encerrado");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Não foi possível encerrar a conexão."
                    + "\nErro: " + e.getMessage());
        }
    }
    
    public void executaUpdateSQL(String strSQL) {
        this.conexao = abreConexao();
        try{
            fluxoSQL = this.conexao.createStatement();
            fluxoSQL.executeUpdate(strSQL);
          
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na exclus�o da Query"
                    + "\nErro: " + e.getMessage());
        }
        fechaConexao();
    }
    
    public ResultSet executaQuerySQL(String strSQL) {
        this.conexao = abreConexao();
        try{
            fluxoSQL = this.conexao.createStatement();
            rs = fluxoSQL.executeQuery(strSQL);
            
           
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na exclus�o da Query"
                    + "\nErro: " + e.getMessage());
        }finally{
            return rs;
        }
    }
}
