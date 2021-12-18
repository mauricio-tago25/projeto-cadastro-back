package br.com.mauricio.cadastro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.mauricio.cadastro.model.VendaDet;
import br.com.mauricio.cadastro.service.VendaDetService;

@RestController
@CrossOrigin
@RequestMapping("/api/vendaDet")
public class VendaDetController {

	@Autowired
	private VendaDetService vendaDetService;

	@GetMapping
	public List<VendaDet> listarTodos() {
		return vendaDetService.listarTodasVendasDet();
	}

	@GetMapping("/{id}")
	public VendaDet buscarPorId(@PathVariable("id") Long id) {
		return vendaDetService.buscarVendaDetPorId(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public VendaDet adicionar(@RequestBody VendaDet vendaDet) {
		return vendaDetService.adicionarVendaDet(vendaDet);
	}

	@PutMapping
	public VendaDet atualizar(@RequestBody VendaDet vendaDet) {
		return vendaDetService.atualizarVendaDet(vendaDet);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable("id") Long id) {
		vendaDetService.deletarVendaDetPorId(id);
	}
}
