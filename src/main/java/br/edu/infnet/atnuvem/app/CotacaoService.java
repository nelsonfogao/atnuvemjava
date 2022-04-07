package br.edu.infnet.atnuvem.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.atnuvem.domain.Cotacao;
import br.edu.infnet.atnuvem.infra.CotacaoRepository;

@Service
public class CotacaoService {
	
	@Autowired
	private CotacaoRepository cotacaoRepository;
	
	
	public Cotacao publicarCotacao(Cotacao cotacao) {
		return cotacaoRepository.save(cotacao);
	}

	public List<Cotacao> obterLista() {
		return (List<Cotacao>) cotacaoRepository.findAll(); 
	}
	public Cotacao findById(Integer id) {
		return cotacaoRepository.findById(id).orElse(null);
	}
	
	public void excluir(Integer id) {
		cotacaoRepository.deleteById(id);
	}
}
