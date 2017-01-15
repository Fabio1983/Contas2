/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import contas.Contas;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;

/**
 *
 * @author Fabio
 */
public class ContaDao extends GenericDao{
    public ContaDao(){
    super();
    }
    
    public boolean Insert(Contas conta){
    //Calendar c = new Calendar();
    String sql;
    try{
    sql = "INSERT INTO contas(nome,valor,vencimento,estado) values(?,?,?,?)";
    this.prepareStmte(sql);
    this.stmte.setString(1, conta.getNome());
    this.stmte.setFloat(2, conta.getValor());
    //this.stmte.setDate(3, conta.getVencimento());
    this.stmte.setString(4, conta.getEstado());
    return true;
    }catch(SQLException e){
        return false;
    }
    
    }
}
