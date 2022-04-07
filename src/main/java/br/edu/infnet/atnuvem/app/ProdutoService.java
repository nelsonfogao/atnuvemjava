package br.edu.infnet.atnuvem.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.atnuvem.domain.Produto;
import br.edu.infnet.atnuvem.infra.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	public Produto publicarProduto(Produto produto) {
		return produtoRepository.save(produto);
	}

	public List<Produto> obterLista() {
		return (List<Produto>) produtoRepository.findAll(); 
	}
	public Produto findById(Integer id) {
		return produtoRepository.findById(id).orElse(null);
	}
	
	public void excluir(Integer id) {
		produtoRepository.deleteById(id);
	}
}