package br.com.mauricio.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mauricio.cadastro.model.VendaDet;

@Repository
public interface VendaDetRepository extends JpaRepository<VendaDet, Long> {
}
