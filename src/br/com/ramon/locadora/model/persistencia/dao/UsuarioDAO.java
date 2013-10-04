
package br.com.ramon.locadora.model.persistencia.dao;

import br.com.ramon.locadora.model.Usuario;
import java.util.List;


public interface UsuarioDAO {
    int salve(Usuario u);
    boolean revome(int codigo);
    List<Usuario> listAll();
    Usuario listById(int codigo);
    
}
