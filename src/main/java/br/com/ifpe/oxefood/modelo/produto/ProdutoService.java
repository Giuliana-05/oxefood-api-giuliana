package br.com.ifpe.oxefood.modelo.produto;

import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.util.exception.ProdutoException;

@Setter
@Getter
@Service 
public class ProdutoService { 

    @Autowired
    private ProdutoRepository repository;

    @Transactional
    public Produto save(Produto produto){

        if (produto.getValorUnitario() < 10) {
	    throw new ProdutoException(ProdutoException.MSG_VALOR_MINIMO_PRODUTO);
	}

        produto.setHabilitado(Boolean.TRUE);
        return repository.save(produto);

    }

    public List<Produto> listarTodos() {
  
        return repository.findAll();// select * from cliente
    }

    public Produto obterPorID(Long id) {

        return repository.findById(id).get(); // select * from cliente wher id =?
    }

    @Transactional // confirma as alteração no final do banco 
   public void update(Long id, Produto produtoAlterado) {

      Produto produto = repository.findById(id).get();
      produto.setCategoria(produtoAlterado.getCategoria());
      produto.setTitulo(produtoAlterado.getTitulo());
      produto.setDescricao(produtoAlterado.getDescricao());
      produto.setValorUnitario(produtoAlterado.getValorUnitario());
      produto.setCodigoProduto(produtoAlterado.getCodigoProduto());
      produto.setTempoEntregaMin(produtoAlterado.getTempoEntregaMin());
      produto.setTempoEntregaMin(produtoAlterado.getTempoEntregaMax());
	    
      repository.save(produto);
  }

  @Transactional
   public void delete(Long id) {

       Produto produto = repository.findById(id).get();
       produto.setHabilitado(Boolean.FALSE);

       repository.save(produto);
   }


}
