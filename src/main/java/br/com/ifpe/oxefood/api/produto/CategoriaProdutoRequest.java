package br.com.ifpe.oxefood.api.produto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import br.com.ifpe.oxefood.modelo.produto.CategoriaProduto;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaProdutoRequest {

    private String descricao;

    public CategoriaProduto build() {

        return CategoriaProduto.builder()
        .descricao(descricao)
        .build();

    }

    public Long getIdCategoriaProduto() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getIdCategoriaProduto'");
    }

}
