package br.com.mauricio.cadastro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.mauricio.cadastro.model.Venda;
import br.com.mauricio.cadastro.service.VendaService;

@RestController
@CrossOrigin
@RequestMapping("/api/vendas")
public class VendaController {

	@Autowired
	private VendaService vendaService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Venda> listarTodos() {
		return vendaService.listarTodasVendas();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Venda buscarPorId(@PathVariable("id") Long id) {
		return vendaService.buscarVendaPorId(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Venda adicionar(@RequestBody Venda venda) {
		return vendaService.adicionarVendas(venda);
	}

}
