package br.com.mauricio.cadastro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mauricio.cadastro.model.Venda;
import br.com.mauricio.cadastro.repository.VendaRepository;

@Service
public class VendaService {

	@Autowired
	private VendaRepository vendaRepository;

	public List<Venda> listarTodasVendas() {
		return vendaRepository.findAll();
	}

	public Venda buscarVendaPorId(Long id) {
		return vendaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Não foi possível encontrar venda com o ID " + id));
	}

	public Venda adicionarVendas(Venda venda) {
		return vendaRepository.save(venda);
	}

}
