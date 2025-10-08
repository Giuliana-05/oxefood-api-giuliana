package br.com.ifpe.oxefood.api.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.Setter;
import lombok.Getter;

import br.com.ifpe.oxefood.modelo.produto.CategoriaProdutoService;
import br.com.ifpe.oxefood.modelo.produto.CategoriaProduto;

@Getter
@Setter
@RestController
@RequestMapping("/api/categoriaProduto") // url para acessar funções
@CrossOrigin
public class CategoriaProdutoController {
    
    @Autowired
    private CategoriaProdutoService categoriaProdutoService;

    @PostMapping
    public ResponseEntity<CategoriaProduto> save (@RequestBody CategoriaProdutoRequest request){

       CategoriaProduto categoriaProdutoNovo = request.build();
       categoriaProdutoNovo.setCategoria(categoriaProdutoService.obterPorID(request.getIdCategoriaProduto()));
       CategoriaProduto categoriaProduto = categoriaProdutoService.save(categoriaProdutoNovo);
       return new ResponseEntity<CategoriaProduto>(categoriaProduto, HttpStatus.CREATED);
    }

    @GetMapping // listagem
    public List<CategoriaProduto> listarTodos() {
        return categoriaProdutoService.listarTodos();
    }

    @GetMapping("/{id}")// passar na url
    public CategoriaProduto obterPorID(@PathVariable Long id) {
        return categoriaProdutoService.obterPorID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaProduto> update(@PathVariable("id") Long id, @RequestBody CategoriaProdutoRequest request) {

    CategoriaProduto categoriaProduto = request.build();
       categoriaProduto.setCategoria(categoriaProdutoService.obterPorID(request.getIdCategoriaProduto()));
       categoriaProdutoService.update(id, categoriaProduto);
       return ResponseEntity.ok().build();
 }

 @DeleteMapping("/{id}") // requisição tipo delete passando o id
    public ResponseEntity<Void> delete(@PathVariable Long id) {

       categoriaProdutoService.delete(id);
       return ResponseEntity.ok().build();
   }

}
