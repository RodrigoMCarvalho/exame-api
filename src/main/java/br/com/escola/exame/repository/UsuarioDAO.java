package br.com.escola.exame.repository;

import br.com.escola.exame.model.Usuario;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsuarioDAO extends PagingAndSortingRepository<Usuario, Long> {

    Usuario findByLogin(String login);
}
