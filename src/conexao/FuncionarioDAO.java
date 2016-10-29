/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author tharlysson breno
 */
public class FuncionarioDAO {
    public Funcionario getFuncionario(String cpf)
    {
        ConexaoMySQL c = new ConexaoMySQL();
        Connection conn = null;
        PreparedStatement stmt = null;
        
        String query = "SELECT * FROM Funcionario WHERE cpf=?";
        
        Funcionario funcionario = new Funcionario();
        try
        {
            conn = c.conectar();
            stmt = conn.prepareStatement(query);
            stmt.setString(1,cpf);
            
            ResultSet resultado = stmt.executeQuery();
            
            if(resultado.next())
            {
                funcionario.setCpf(resultado.getString("cpf"));
                funcionario.setNome(resultado.getString("nome"));
                funcionario.setDataNascimento(resultado.getDate("dataNascimento"));
                funcionario.setEmail(resultado.getString("email"));
                funcionario.setTelefone1(resultado.getString("telefone1"));
                funcionario.setTelefone2(resultado.getString("telefone2"));
            }
            conn.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return funcionario;
    }
    
}
