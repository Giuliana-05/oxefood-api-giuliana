package br.com.ifpe.oxefood.modelo.entregador;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EntregadorService {
    
    @Autowired // injetar uma depedencia auto / inicializar um atributo de uma classe
   private EntregadorRepository repository;

   @Transactional // criar um bloco transacional 
   public Entregador save(Entregador entregador) {

       entregador.setHabilitado(Boolean.TRUE);
       return repository.save(entregador);
   }

}
