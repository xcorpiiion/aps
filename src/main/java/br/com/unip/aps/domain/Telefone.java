package br.com.unip.aps.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Telefone implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Telefone não pode está em branco")
    @Pattern(regexp = "(([0-9]{8})|([0-9]{9}))", message = "O Telefone informado não é valido")
    private String telefone;

    @NotBlank(message = "Ramal não pode está em branco")
    @Size(min = 5, max = 10, message = "Ramal deve ter o tamanho entre 5 e 10")
    private String ramal;

    public Telefone() {
    }

    public Telefone(String telefone, String ramal) {
        this.telefone = telefone;
        this.ramal = ramal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRamal() {
        return ramal;
    }

    public void setRamal(String ramal) {
        this.ramal = ramal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Telefone)) return false;

        Telefone telefone = (Telefone) o;

        return new EqualsBuilder()
                .append(id, telefone.id)
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
                .append("telefone", telefone)
                .append("ramal", ramal)
                .toString();
    }
}
