package br.com.ifpe.oxefood.modelo.cliente;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

   @Autowired // injetar uma depedencia auto / inicializar um atributo de uma classe
   private ClienteRepository repository;

   @Transactional // criar um bloco transacional 
   public Cliente save(Cliente cliente) {

       cliente.setHabilitado(Boolean.TRUE);
       return repository.save(cliente);
   }

}
