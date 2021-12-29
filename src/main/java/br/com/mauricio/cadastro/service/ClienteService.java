package br.com.mauricio.cadastro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mauricio.cadastro.model.Cliente;
import br.com.mauricio.cadastro.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> listarTodosClientes() {
		return clienteRepository.findAll();
	}

	public Cliente buscarClientePorId(Long id) {
		return clienteRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Não foi possível encontrar cliente com o ID " + id));
	}

	public Cliente adicionarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public Cliente atualizarCliente(Cliente cliente) {
		Cliente clienteExistente = clienteRepository.findById(cliente.getId()).orElse(null);
		clienteExistente.setNome(cliente.getNome());
		clienteExistente.setCpf(cliente.getCpf());
		clienteExistente.setDataNascimento(cliente.getDataNascimento());
		return clienteRepository.save(clienteExistente);
	}

	public void deletarClientePorId(Long id) {
		clienteRepository.deleteById(id);
	}
}
