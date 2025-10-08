package br.com.ifpe.oxefood.modelo.cliente;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import br.com.ifpe.oxefood.util.entity.EntidadeNegocio;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;

public class EnderecoCliente extends EntidadeAuditavel{

   @JsonIgnore
   @ManyToOne
   private Cliente cliente;

   @Column
   private String rua;

   @Column
   private String numero;

   @Column
   private String bairro;

   @Column
   private String cep;

   @Column
   private String cidade;

   @Column
   private String estado;

   @Column
   private String complemento;

   public static Object builder() {
    throw new UnsupportedOperationException("Unimplemented method 'builder'");
   }

   public void setCliente(Cliente cliente2) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setCliente'");
   }

   public Object getComplemento() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getComplemento'");
   }

   public void setComplemento(Object complemento2) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setComplemento'");
   }

   public Object getEstado() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getEstado'");
   }

   public void setEstado(Object estado2) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setEstado'");
   }

   public Object getCidade() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getCidade'");
   }

   public void setCidade(Object cidade2) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setCidade'");
   }

   public Object getCep() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getCep'");
   }

   public void setCep(Object cep2) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setCep'");
   }

   public Object getBairro() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getBairro'");
   }

   public void setBairro(Object bairro2) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setBairro'");
   }

   public Object getNumero() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getNumero'");
   }

   public void setNumero(Object numero2) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setNumero'");
   }

   public Object getRua() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getRua'");
   }

   public void setRua(Object rua2) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setRua'");
   }

   public EntidadeNegocio getCliente() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getCliente'");
   }

    
}
