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
		return vendaDetRepository.findById(id).orElse(null);
	}

	public VendaDet adicionarVendaDet(VendaDet vendaDet) {
		return vendaDetRepository.save(vendaDet);
	}

	public VendaDet atualizarVendaDet(VendaDet vendaDet) {
		VendaDet vendaDetExistente = vendaDetRepository.findById(vendaDet.getId()).orElse(null);
		vendaDetExistente.setIdVenda(vendaDet.getIdVenda());
		vendaDetExistente.setIdProduto(vendaDet.getIdProduto());
		vendaDetExistente.setQuantidade(vendaDet.getQuantidade());
		vendaDetExistente.setPrecoTotal(vendaDet.getPrecoTotal());
		return vendaDetRepository.save(vendaDetExistente);
	}

	public void deletarVendaDetPorId(Long id) {
		vendaDetRepository.deleteById(id);
	}

}
