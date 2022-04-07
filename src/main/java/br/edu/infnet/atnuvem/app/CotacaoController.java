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

import br.edu.infnet.atnuvem.domain.Cotacao;

@RestController
@RequestMapping(path = {"/cotacoes"})
public class CotacaoController {
	
	@Autowired
	private CotacaoService cotacaoService;
	
	@PostMapping
	public ResponseEntity<Object> publicarCotacao(@RequestBody Cotacao cotacao) {
		ResponseEntity<Object> retorno = ResponseEntity.badRequest().build();
		
		Cotacao gravado = cotacaoService.publicarCotacao(cotacao);
		retorno = ResponseEntity.status(201).body(gravado);
		return retorno;
	}
	
	@GetMapping()
	public ResponseEntity<Object> listarCotacoes() {
		ResponseEntity<Object> retorno = ResponseEntity.notFound().build();
		
		try {
			List<Cotacao> lista = cotacaoService.obterLista();
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
			Cotacao cotacao = cotacaoService.findById(id);
				retorno = ResponseEntity.ok().body(cotacao);
		}catch(Exception e) {	
		}
		return retorno;
	}
	
	@PutMapping(path = "{id}")
	public ResponseEntity<Object> atualizarCotacao(@PathVariable int id, @RequestBody Cotacao cotacao) {
		ResponseEntity<Object> retorno = ResponseEntity.badRequest().build();
		
		if(cotacao != null && id > 0) {
			Cotacao cotacaoGravado = cotacaoService.findById(id);
			if(cotacaoGravado != null) {
				try {
					cotacao.setId(id);
					cotacaoGravado = cotacaoService.publicarCotacao(cotacao);
					retorno = ResponseEntity.ok().body(cotacaoGravado);
				}catch(Exception e) {
				}
			}
		}
		return retorno;
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public void deletarCotacao(@PathVariable int id) {
		Cotacao cotacaoDeletado = cotacaoService.findById(id);
		if(cotacaoDeletado != null) {
			try {
				cotacaoService.excluir(id);
			}catch(Exception e) {
			}
		}
	}

}
