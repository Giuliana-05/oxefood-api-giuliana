package br.com.ifpe.oxefood.api.produto;

import org.hibernate.validator.constraints.Length;

import br.com.ifpe.oxefood.modelo.produto.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {

    private Long idCategoria;

   @NotNull(message = "O titulo é de preenchimento obrigatório")
   @NotEmpty(message = "O titulo é de preenchimento obrigatório")
   @Length(max = 100, message = "O Nome deverá ter no máximo {max} caracteres")
    private String titulo;

    @NotBlank(message = "O CPF é de preenchimento obrigatório")
    private String codigoProduto;

    private String descricao;

    private Double valorUnitario;

    private String tempoEntregaMin;

    private String tempoEntregaMax;

    public Produto build(){

        return Produto.builder()
        .titulo(titulo)
        .codigoProduto(codigoProduto)
        .descricao(descricao)
        .valorUnitario(valorUnitario)
        .tempoEntregaMin(tempoEntregaMin)
        .tempoEntregaMax(tempoEntregaMax)
        .build();

    }
    
}
