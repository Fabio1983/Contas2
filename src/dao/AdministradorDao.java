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
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
/**
 *
 * @author Fabio
 */
public class AdministradorDao extends GenericDao{
    
    
    public AdministradorDao(){
    super();
    }
    
    public ArrayList<Administrador> getAdmin(){ //L I S T A
        
        ArrayList<Administrador> adList = new ArrayList<>();

        String sql = "SELECT * FROM administrador order by nome";
               
        try {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(sql); //sempre usar quando fazer uma consulta(SELECT)
            rs.beforeFirst();
            while (rs.next()) {
                Administrador ad = new Administrador();
                ad.setNome(rs.getString("nome"));
                ad.setSenha(rs.getString("senha"));
                adList.add(ad);
            }
            return adList;
        } catch (Exception e) {
            return null;
        } 
    }
    
   public ArrayList<Administrador> getAdminByName(String nome){
       
        ArrayList<Administrador> adl = new ArrayList<Administrador>();
        String sql = "SELECT * FROM administrador WHERE nome LIKE ?";
        
        try
        {
            this.prepareStmte(sql);
            this.stmte.setString(1, "%"+nome+"%");
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
           
            while(rs.next())
            {
                Administrador ad = new Administrador();
                ad.setNome(rs.getString("nome"));
                ad.setSenha(rs.getString("senha"));
                adl.add(ad);
            }
            return adl;
            
        }
        catch(Exception e)
        {
            return null;
        }  
    }
    
    public boolean verify(String nome, String senha) {
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
                
                stme.close();
                return autenticado;
            }
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog("Erro: "+ String.valueOf(ex.getMessage()));
            System.out.println("ERRO: " + ex.getMessage());
        }
        return autenticado;
    }
    
    public boolean Insert(Administrador administrador){
    String sql;
    try{
        sql = "INSERT INTO administrador(nome,senha) VALUES (?,?)";
        this.prepareStmte(sql);
        this.stmte.setString(1, administrador.getNome());
        this.stmte.setString(2, administrador.getSenha());
        this.stmte.execute();
        return true;
    }catch(SQLException e){
        return false;
    }
  }
    
    
}
