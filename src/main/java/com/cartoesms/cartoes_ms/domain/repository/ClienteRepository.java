package com.cartoesms.cartoes_ms.domain.repository;

import com.cartoesms.cartoes_ms.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
