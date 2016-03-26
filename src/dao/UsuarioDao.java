/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;



import contas.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Fabio
 */
public class UsuarioDao extends GenericDao{
    public UsuarioDao(){
    super();
    }
    
    public boolean Insert(Usuario usuario){
    String sql;
    try{
        sql = "INSERT INTO usuarios(nome,senha) VALUES (?,?)";
        this.prepareStmte(sql);
        this.stmte.setString(1, usuario.getNome());
        this.stmte.setString(2, usuario.getSenha());
        this.stmte.execute();
        return true;
    }catch(SQLException e){
        return false;
    }
  }
    
    public ArrayList<Usuario> getUsuario(){ //L I S T A
        
        ArrayList<Usuario> uList = new ArrayList<>();

        String sql = "SELECT * FROM usuarios order by nome";
               
        try {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(sql); //sempre usar quando fazer uma consulta(SELECT)
            rs.beforeFirst();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setNome(rs.getString("nome"));
                u.setSenha(rs.getString("senha"));
                uList.add(u);
            }
            return uList;
        } catch (Exception e) {
            return null;
        } 
    }
    
    public Usuario FindUserByName(String nome){
        Usuario u = new Usuario();
        String sql = "SELECT * FROM usuarios WHERE nome = ?";
        try{
            this.prepareStmte(sql);
            this.stmte.setString(1, nome);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
           
            while(rs.next())
            {
                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setNome(rs.getString("nome"));
                u.setSenha(rs.getString("senha"));
                return u;
            }
        }
        catch(Exception e)
        {
            return null;
        }
        return u;
    }
    
    public boolean Update(Usuario usuario){
        String sql = "UPDATE usuarios SET nome = ?, senha = ? WHERE idUsuario = ?";
        try{
            this.prepareStmte(sql);
            this.stmte.setString(1, usuario.getNome());
            this.stmte.setString(2,usuario.getSenha());
            this.stmte.setInt(3, usuario.getIdUsuario());
            this.stmte.executeUpdate();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    
}
