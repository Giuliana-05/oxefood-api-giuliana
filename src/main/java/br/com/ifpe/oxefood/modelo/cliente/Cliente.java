package br.com.ifpe.oxefood.modelo.cliente;

import java.time.LocalDate;

import org.hibernate.annotations.SQLRestriction;
import jakarta.persistence.Table;
import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Cliente") // sera criado uma tabela msm nome da classe
@SQLRestriction("habilitado = true") // serve para filtrar o registro da entidade
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends EntidadeAuditavel  {
  
   @Column // determinar que esse atributo é coluna
   private String nome;

   @Column
   private LocalDate dataNascimento;

   @Column
   private String cpf;

   @Column
   private String foneCelular;

   @Column
   private String foneFixo;

}

