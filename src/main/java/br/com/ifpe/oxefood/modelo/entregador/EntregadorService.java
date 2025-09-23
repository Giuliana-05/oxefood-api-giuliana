package br.com.ifpe.oxefood.modelo.entregador;

import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.modelo.entregador.Entregador;



@Service
public class EntregadorService {
    
    @Autowired // injetar uma depedencia auto / inicializar um atributo de uma classe
   private EntregadorRepository repository;

   @Transactional // criar um bloco transacional 
   public Entregador save(Entregador entregador) {

       entregador.setHabilitado(Boolean.TRUE);
       return repository.save(entregador);
   }

   public List<Entregador> listarTodos() {
  
        return repository.findAll();// select * from cliente
    }

    public Entregador obterPorID(Long id) {

        return repository.findById(id).get(); // select * from cliente wher id =?
    }

}
