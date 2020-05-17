package br.com.unip.aps.repository;

import br.com.unip.aps.domain.Endereco;
import br.com.unip.aps.domain.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITelefoneRepository extends JpaRepository<Telefone, Long> {
}
