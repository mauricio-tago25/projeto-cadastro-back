package br.com.mauricio.cadastro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mauricio.cadastro.model.VendaDet;
import br.com.mauricio.cadastro.repository.VendaDetRepository;

@Service
public class VendaDetService {

	@Autowired
	private VendaDetRepository vendaDetRepository;

	public List<VendaDet> listarTodasVendasDet() {
		return vendaDetRepository.findAll();
	}

	public VendaDet buscarVendaDetPorId(Long id) {
		return vendaDetRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Não foi possível encontrar venda det com o ID " + id));
	}

	public VendaDet adicionarVendaDet(VendaDet vendaDet) {
		return vendaDetRepository.save(vendaDet);
	}

	public void deletarVendaDetPorId(Long id) {
		vendaDetRepository.deleteById(id);
	}

}
