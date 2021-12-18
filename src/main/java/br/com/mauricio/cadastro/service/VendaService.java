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
		return vendaRepository.findById(id).orElse(null);
	}

	public Venda adicionarVendas(Venda venda) {
		return vendaRepository.save(venda);
	}

}
