package br.com.ifpe.oxefood.modelo.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.ifpe.oxefood.util.Util;
import br.com.ifpe.oxefood.util.exception.ProdutoException;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;

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

    public List<Produto> filtrar(String codigo, String titulo, Long idCategoria) {

       List<Produto> listaProdutos = repository.findAll();

       if ((codigo != null && !"".equals(codigo)) &&
           (titulo == null || "".equals(titulo)) &&
           (idCategoria == null)) {
               listaProdutos = repository.consultarPorCodigo(codigo);
       } else if (
           (codigo == null || "".equals(codigo)) &&
           (titulo != null && !"".equals(titulo)) &&
           (idCategoria == null)) {    
               listaProdutos = repository.findByTituloContainingIgnoreCaseOrderByTituloAsc(titulo);
       } else if (
           (codigo == null || "".equals(codigo)) &&
           (titulo == null || "".equals(titulo)) &&
           (idCategoria != null)) {
               listaProdutos = repository.consultarPorCategoria(idCategoria); 
       } else if (
           (codigo == null || "".equals(codigo)) &&
           (titulo != null && !"".equals(titulo)) &&
           (idCategoria != null)) {
               listaProdutos = repository.consultarPorTituloECategoria(titulo, idCategoria); 
       }

       return listaProdutos;
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

   @Transactional
  public Produto saveImage(Long id, MultipartFile imagem) {

   Produto produto = obterPorID(id);

     String imagemUpada = Util.fazerUploadImagem(imagem);

     if (imagemUpada != null) {
     	produto.setImagem(imagemUpada);
     }

     return save(produto);
}



}
