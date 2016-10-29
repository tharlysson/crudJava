/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;



/**
 *
 * @author tharlysson breno
 */
public class Conexao {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
         
        FuncionarioDAO f = new FuncionarioDAO();
        Funcionario x = new Funcionario();
        x = f.getFuncionario("05795337510");
        
        System.out.println(x.getNome());

 
    }
}
