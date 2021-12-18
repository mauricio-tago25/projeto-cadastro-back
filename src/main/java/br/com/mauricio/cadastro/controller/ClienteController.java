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

import br.com.mauricio.cadastro.model.Cliente;
import br.com.mauricio.cadastro.service.ClienteService;

@RestController
@CrossOrigin
@RequestMapping("/api/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public List<Cliente> listarTodos() {
		return clienteService.listarTodosClientes();
	}

	@GetMapping("/{id}")
	public Cliente buscarPorId(@PathVariable("id") Long id) {
		return clienteService.buscarClientePorId(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@RequestBody Cliente cliente) {
		return clienteService.adicionarCliente(cliente);
	}

	@PutMapping
	public Cliente atualizar(@RequestBody Cliente cliente) {
		return clienteService.atualizarCliente(cliente);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable("id") Long id) {
		clienteService.deletarClientePorId(id);
	}
}
