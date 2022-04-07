package br.edu.infnet.atnuvem.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.edu.infnet.atnuvem.domain.Produto;


@RestController
@RequestMapping(path = {"/produtos"})
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
    
	
	@PostMapping
	public ResponseEntity<Object> publicarProduto(@RequestBody Produto produto) {
		ResponseEntity<Object> retorno = ResponseEntity.badRequest().build();
		Produto gravado = produtoService.publicarProduto(produto);
		retorno = ResponseEntity.status(201).body(gravado);
		return retorno;
	}
	
	@GetMapping()
	public ResponseEntity<Object> listarProdutos() {
		ResponseEntity<Object> retorno = ResponseEntity.notFound().build();
		
		try {
			List<Produto> lista = produtoService.obterLista();
			if(!lista.isEmpty()) {
				retorno = ResponseEntity.ok().body(lista);
			}
		}catch(Exception e) {	
		}
		return retorno;
	}
	
	@GetMapping(path = "{id}")
	public ResponseEntity<Object> listarPorId(@PathVariable int id) {
		ResponseEntity<Object> retorno = ResponseEntity.notFound().build();
		
		try {
			Produto produto = produtoService.findById(id);
				retorno = ResponseEntity.ok().body(produto);
		}catch(Exception e) {	
		}
		return retorno;
	}
	
	@PutMapping(path = "{id}")
	public ResponseEntity<Object> atualizarProduto(@PathVariable int id, @RequestBody Produto produto) {
		ResponseEntity<Object> retorno = ResponseEntity.badRequest().build();
		
		if(produto != null && id > 0) {
			Produto produtoGravado = produtoService.findById(id);
			if(produtoGravado != null) {
				try {
					produto.setId(id);
					produtoGravado = produtoService.publicarProduto(produto);
					retorno = ResponseEntity.ok().body(produtoGravado);
				}catch(Exception e) {
				}
			}
		}
		return retorno;
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public void deletarProduto(@PathVariable int id) {
		Produto produtoDeletado = produtoService.findById(id);
		if(produtoDeletado != null) {
			try {
				 produtoService.excluir(id);
			}catch(Exception e) {
			}
		}
	}

}
