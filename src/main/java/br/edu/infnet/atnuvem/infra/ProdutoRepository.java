package br.edu.infnet.atnuvem.infra;

import org.springframework.data.repository.CrudRepository;

import br.edu.infnet.atnuvem.domain.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Integer>{
	
}

