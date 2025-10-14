package br.com.ifpe.oxefood.modelo.cidade;

import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
@Service
public class CidadeService {

   @Autowired 
   private CidadeRepository repository;

   @Autowired
   private CidadeRepository cidadeRepository;

   @Transactional 
   public Cidade save(Cidade cidade) {

       cidade.setHabilitado(Boolean.TRUE);
       return repository.save(cidade);
   }

   public List<Cidade> listarTodos() {
  
        return repository.findAll();
    }

    public Cidade obterPorID(Long id) {

        return repository.findById(id).get(); 
    }

    @Transactional  
   public void update(Long id, Cidade cidadeAlterado) {

      Cidade cidade = repository.findById(id).get();
      cidade.setNome(cidadeAlterado.getNome());
      cidade.setEstado(cidadeAlterado.getEstado());
      cidade.setQtdPopulacao(cidadeAlterado.getQtdPopulacao());
      cidade.setEhCapital(cidadeAlterado.getEhCapital());
      cidade.setDataFundacao(cidadeAlterado.getDataFundacao());
    
      repository.save(cidade);
  }

  @Transactional
   public void delete(Long id) {

       Cidade cidade = repository.findById(id).get();
       cidade.setHabilitado(Boolean.FALSE);

       repository.save(cidade);
   }

   
}
