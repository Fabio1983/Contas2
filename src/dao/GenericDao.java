/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jdbc.ConnectionFactory;

/**
 *
 * @author Fabio
 */
public class GenericDao {
    protected Connection conn;
    protected PreparedStatement stmte;
    
    public GenericDao(){
    this.conn = new ConnectionFactory().getConnection();
    }
    
    protected void prepareStmte(String sql){
    try{
        this.stmte = this.conn.prepareStatement(sql);
    }
    catch(SQLException e){
        System.out.println("Erro ao preparar o estado");
    }
   }
    
    protected void closeAll(){
    try{
        this.stmte.close();
        this.conn.close();
    }
    catch(SQLException e){
        System.out.println("Erro ao fechar conexao");
    }
   }
}
