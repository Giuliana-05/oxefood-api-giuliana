package br.com.ifpe.oxefood.modelo.produto;



import org.hibernate.annotations.SQLRestriction;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Produto") // sera criado uma tabela msm nome da classe
@SQLRestriction("habilitado = true") // serve para filtrar o registro da entidade
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto extends EntidadeAuditavel {

   @ManyToOne
   private CategoriaProduto categoria;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column
    private String codigoProduto;

    @Column
    private String descricao;

    @Column
    private Double valorUnitario;

    @Column
    private String tempoEntregaMin;

    @Column
    private String tempoEntregaMax;

    @Column
    private String imagem;

    
}
