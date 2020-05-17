package br.com.unip.aps.repository;

import br.com.unip.aps.domain.Cliente;
import br.com.unip.aps.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEnderecoRepository extends JpaRepository<Endereco, Long> {
}
