package br.com.ifpe.oxefood.api.cidade;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.cidade.Cidade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CidadeRequest {

    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFundacao;

    private Integer qtdPopulacao;

    private Boolean ehCapital;

    private String estado;

    public Cidade build(){

        return Cidade.builder()
            .nome(nome)
            .dataFundacao(dataFundacao)
            .ehCapital(ehCapital)
            .estado(estado)
            .qtdPopulacao(qtdPopulacao)
            .build();
    }
    
}
