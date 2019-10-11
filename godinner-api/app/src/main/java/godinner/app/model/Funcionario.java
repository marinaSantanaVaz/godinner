package godinner.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import godinner.app.model.Endereco;

@Entity
@Table(name = "tbl_funcionario")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_funcionario")
	private Integer id;

	@Column(name = "nome")
	@NotNull
	@Size(min = 3, max = 45)
	private String nome;

	@NotNull
	@Size(min = 10, max = 100)
	private String email;

	@NotNull
	@Size(min = 6, max = 255)
	private String senha;

	@NotNull
	@Size(min = 13, max = 14)
	private String cpf;

	@Size(max = 13)
	private String telefone;

	@Column(name = "foto_perfil")
	@Size(max = 255)
	private String fotoPerfil;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}

	@Override
	public String toString() {
		return "Restaurante [id=" + id + ", email=" + email + ", senha=" + senha + ", nome=" + nome
				+ ", cpf=" + cpf + ", telefone=" + telefone + ", fotoPerfil=" + fotoPerfil + "]";
	}
}