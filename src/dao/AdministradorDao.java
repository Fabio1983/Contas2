/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import contas.Administrador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Fabio
 */
public class AdministradorDao extends GenericDao{
    
    public AdministradorDao(){
    super();
    }
    
    public Administrador getAdmin(String nome, String senha){
    Administrador ad = new Administrador();
    String sql = "SELECT * FROM administrador WHERE nome = ?, senha = ?";
    try{
    this.prepareStmte(sql);
    this.stmte.setString(1, nome);
    this.stmte.setString(2, senha);
    ResultSet rs = this.stmte.executeQuery();
    rs.first();
    ad.setNome(rs.getString("nome"));
    ad.setSenha(rs.getString("senha"));
    return ad;
    }catch(SQLException e){
    return null;
    }
   }
    
    public boolean consultar(String nome, String senha) {
        boolean autenticado = false;
        String sql;
        try {
            sql = "SELECT nome, senha FROM administrador WHERE nome = ? and senha = ?";
            PreparedStatement stme;
            stme = conn.prepareStatement(sql);
            stme.setString(1, nome);
            stme.setString(2, senha);
            ResultSet rs = stme.executeQuery();
            if (rs.next()) {
                String name = rs.getString("nome");
                String pass = rs.getString("senha");  
                autenticado = true;
            } else {
                //JOptionPane.showMessageDialog(this, "Acesso Negado \nInforme o setor de Inventário");
                stme.close();
                return autenticado;
            }
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog("Erro: "+ String.valueOf(ex.getMessage()));
            System.out.println("ERRO: " + ex.getMessage());
        }
        return autenticado;
    }
}
