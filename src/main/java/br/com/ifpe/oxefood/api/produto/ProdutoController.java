package br.com.ifpe.oxefood.api.produto;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.api.produto.ProdutoRequest;
import br.com.ifpe.oxefood.api.produto.ProdutoRequest;
import br.com.ifpe.oxefood.modelo.produto.Produto;
import br.com.ifpe.oxefood.modelo.produto.Produto;
import br.com.ifpe.oxefood.modelo.produto.ProdutoService;
import br.com.ifpe.oxefood.modelo.produto.Produto;
import br.com.ifpe.oxefood.modelo.produto.ProdutoService;

// end point de cliente (rotas)
// http://localhost:8080/api/cliente/

@RestController
@RequestMapping("/api/produto") // url para acessar funções
@CrossOrigin
public class ProdutoController {
    
    @Autowired
   private ProdutoService produtoService;

  //@PostMapping(path="/cadastrar") para acessar outro post
   @PostMapping
   public ResponseEntity<Produto> save(@RequestBody ProdutoRequest request) {

       Produto produto = produtoService.save(request.build());
       return new ResponseEntity<Produto>(produto, HttpStatus.CREATED);
   }

   @GetMapping // listagem
    public List<Produto> listarTodos() {
        return produtoService.listarTodos();
    }

    @GetMapping("/{id}")// passar na url
    public Produto obterPorID(@PathVariable Long id) {
        return produtoService.obterPorID(id);
    }
    

}
