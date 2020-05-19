package br.com.unip.aps.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Endereco implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Rua não pode está em branco")
    @Size(min = 2,max = 40, message = "Rua deve ter entre 2 e 30 caracteres")
    private String rua;

    private String complemento;

    @NotBlank(message = "Estado não pode está em branco")
    @Size(min = 2,max = 30, message = "Estado deve ter entre 2 e 30 caracteres")
    private String estado;

    @NotBlank(message = "Cidade não pode está em branco")
    @Size(min = 2,max = 30, message = "Cidade deve ter entre 2 e 30 caracteres")
    private String cidade;

    @NotBlank(message = "Cep não pode está em branco")
    @Pattern(regexp = "^\\d{5}\\d{3}$", message = "Cep não pode conter letras")
    private String cep;

    public Endereco() {
    }

    public Endereco(String rua, String complemento, String estado, String cidade, String cep) {
        this.rua = rua;
        this.complemento = complemento;
        this.estado = estado;
        this.cidade = cidade;
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Endereco)) return false;

        Endereco endereco = (Endereco) o;

        return new EqualsBuilder()
                .append(id, endereco.id)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("rua", rua)
                .append("complemento", complemento)
                .append("estado", estado)
                .append("cidade", cidade)
                .append("cep", cep)
                .toString();
    }
}
