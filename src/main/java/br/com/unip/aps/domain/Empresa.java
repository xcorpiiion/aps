package br.com.unip.aps.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

import java.io.Serializable;

@Entity
public class Empresa implements Serializable {

	private static final Long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank(message = "Nome não pode está em branco")
	@Size(min = 2, max = 60, message = "Nome deve possuir entre 2 e 60 caracteres")
	@Column(nullable = false, length = 60)
	private String nome;
	
	@Email(message = "O email digitado é invalido")
	@Column(nullable = false)
	private String email;

	@Size(min = 8, max = 30, message = "Senha deve ter no minimo 8 caracteres e no maximo 30 caracteres")
	@Column(nullable = false, length = 30)
	private String senha;

	@CNPJ
	private String cnpj;

	@OneToOne
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;

	@OneToOne
	@JoinColumn(name = "id_telefone")
	private Telefone telefone;

	private boolean teste;

	private boolean isLogado;

	public Empresa() {
	}

	public Empresa(String nome, String email, String senha, String cnpj, Endereco endereco, Telefone telefone) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public boolean isLogado() {
		return isLogado;
	}

	public void setLogado(boolean logado) {
		isLogado = logado;
	}

	public boolean isTeste() {
		return teste;
	}

	public void setTeste(boolean teste) {
		this.teste = teste;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (!(o instanceof Empresa)) return false;

		Empresa cliente = (Empresa) o;

		return new EqualsBuilder()
				.append(id, cliente.id)
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
		return ReflectionToStringBuilder.toString(this);
	}
	
}
