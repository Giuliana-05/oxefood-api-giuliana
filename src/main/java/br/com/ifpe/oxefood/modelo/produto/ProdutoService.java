package br.com.ifpe.oxefood.modelo.produto;

import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.modelo.produto.Produto; 

@Service 
public class ProdutoService { 
    @Autowired
    private ProdutoRepository repository;

    @Transactional
    public Produto save(Produto produto){
        produto.setHabilitado(Boolean.TRUE);
        return repository.save(produto);
    }

    public List<Produto> listarTodos() {
  
        return repository.findAll();// select * from cliente
    }

    public Produto obterPorID(Long id) {

        return repository.findById(id).get(); // select * from cliente wher id =?
    }

}
