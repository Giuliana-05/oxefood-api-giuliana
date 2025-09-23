package br.com.ifpe.oxefood.api.produto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {

    private String titulo;

    private String codigoProduto;

    private String descricao;

    private String valorUnitario;

    private String tempoEntregaMin;

    private String tempoEntregaMax;

    public Produto build(){

        return Produto.builder()
        .titulo(titulo)
        .codigoProduto(codigoProduto)
        .descricao(descricao)
        .valorUniatrio(valorUnitario)
        .tempoEntregaMin(tempoEntregaMin)
        .tempoEntregaMax(tempoEntregaMax)
        .build();

    }
    
}
