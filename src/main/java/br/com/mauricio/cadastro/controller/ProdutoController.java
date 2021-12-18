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

import br.com.mauricio.cadastro.model.Produto;
import br.com.mauricio.cadastro.service.ProdutoService;

@RestController
@CrossOrigin
@RequestMapping("/api/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public List<Produto> listarTodos() {
		return produtoService.listarTodosProdutos();
	}

	@GetMapping("/{id}")
	public Produto buscarPorId(@PathVariable("id") Long id) {
		return produtoService.buscarProdutoPorId(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto adicionar(@RequestBody Produto produto) {
		return produtoService.adicionarProduto(produto);
	}

	@PutMapping
	public Produto atualizar(@RequestBody Produto produto) {
		return produtoService.atualizarProduto(produto);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable("id") Long id) {
		produtoService.deletarProdutoPorId(id);
	}
}
