package br.com.unip.aps.repository;

import br.com.unip.aps.domain.Empresa;
import br.com.unip.aps.domain.Ong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOngRepository extends JpaRepository<Ong, Long> {
}
