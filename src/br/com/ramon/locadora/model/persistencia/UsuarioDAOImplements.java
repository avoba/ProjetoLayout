package br.com.ramon.locadora.model.persistencia;

import br.com.ramon.locadora.model.Usuario;
import br.com.ramon.locadora.model.persistencia.dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;

public class UsuarioDAOImplements implements UsuarioDAO {

    private static final String INSERT = "insert into usuario (nome,login, senha, cpf, telefone, data_nascimento ,sexo) "
            + "values (?,?,?,?,?,?,?)";

    @Override
    public int salve(Usuario u) {
        if (u.getCodigo() == 0) {
            return insert(u);
        }
        return -1;
    }

    private int insert(Usuario u) {
        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, u.getNome());
            pstm.setString(2, u.getLogin());
            pstm.setString(3, u.getSenha());
            pstm.setString(4, u.getCpf());
            pstm.setString(5, u.getTelefone());
            pstm.setDate(6, new java.sql.Date(u.getDataNascimento().getTime()));
            pstm.setString(7, u.getSexo());
            pstm.execute();
            
            try(ResultSet rs = pstm.getGeneratedKeys()){ // traz codigo do banco (Id)
                if(rs.next()){
                    retorno = rs.getInt(1);
                }
            }
                
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro" + ex);
            }
            return retorno;
        }
    }

    @Override
    public boolean revome(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> listAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario listById(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
