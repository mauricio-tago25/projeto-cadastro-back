package br.com.mauricio.cadastro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mauricio.cadastro.model.Produto;
import br.com.mauricio.cadastro.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<Produto> listarTodosProdutos() {
		return produtoRepository.findAll();
	}

	public Produto buscarProdutoPorId(Long id) {
		return produtoRepository.findById(id).orElse(null);
	}

	public Produto adicionarProduto(Produto produto) {
		return produtoRepository.save(produto);
	}

	public Produto atualizarProduto(Produto produto) {
		Produto produtoExistente = produtoRepository.findById(produto.getId()).orElse(null);
		produtoExistente.setNome(produto.getNome());
		produtoExistente.setPrecoVenda(produto.getPrecoVenda());
		produtoExistente.setEstoque(produto.getEstoque());
		return produtoRepository.save(produtoExistente);
	}

	public void deletarProdutoPorId(Long id) {
		produtoRepository.deleteById(id);
	}

}
