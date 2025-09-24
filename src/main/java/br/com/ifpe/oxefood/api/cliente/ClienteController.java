package br.com.ifpe.oxefood.api.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import br.com.ifpe.oxefood.modelo.cliente.ClienteService;

// end point de cliente (rotas)
// http://localhost:8080/api/cliente/

@RestController
@RequestMapping("/api/cliente") // url para acessar funções
@CrossOrigin
public class ClienteController {

   @Autowired
   private ClienteService clienteService;

  //@PostMapping(path="/cadastrar") para acessar outro post
   @PostMapping
   public ResponseEntity<Cliente> save(@RequestBody ClienteRequest request) {

       Cliente cliente = clienteService.save(request.build());
       return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
   }

    @GetMapping // listagem
    public List<Cliente> listarTodos() {
        return clienteService.listarTodos();
    }

    @GetMapping("/{id}")// passar na url
    public Cliente obterPorID(@PathVariable Long id) {
        return clienteService.obterPorID(id);
    }

     @PutMapping("/{id}")
 public ResponseEntity<Cliente> update(@PathVariable("id") Long id, @RequestBody ClienteRequest request) {

       clienteService.update(id, request.build());
       return ResponseEntity.ok().build();
 }

}
