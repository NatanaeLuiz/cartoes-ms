package com.cartoesms.cartoes_ms.domain.repository;

import com.cartoesms.cartoes_ms.domain.model.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Long> {
}
