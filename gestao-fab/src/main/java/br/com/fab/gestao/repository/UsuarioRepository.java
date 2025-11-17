package br.com.fab.gestao.repository; // 1. Mude o pacote do repositório

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fab.model.Usuario; // 2. Mude o import do modelo
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByLogin(String login);

    boolean existsByLogin(String login);
}