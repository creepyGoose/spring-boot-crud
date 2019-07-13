package br.com.treinaweb.twgerenciadortarefas.modelos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tar_tarefas")
public class Tarefa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tar_id")
	private Long id;

	@Column(name = "tar_titulo", length = 50, nullable = false)
	@NotNull(message = "Título é obrigatório")
	@Length(max = 50, min = 3, message = "O título deve conter entre 3 e 50 caracteres")
	private String titulo;

	@Column(name = "tar_desc", length = 100, nullable = true)
	@Length(max = 100, message = "A descrição deve conter até 100 caracters")
	private String descricao;

	@Column(name = "tar_data_exp", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataExp;

	@Column(name = "tar_ready", nullable = false)
	private Boolean concluida = false;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usr_id")
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataExp() {
		return dataExp;
	}

	public void setDataExp(Date dataExp) {
		this.dataExp = dataExp;
	}

	public Boolean getConcluida() {
		return concluida;
	}

	public void setConcluida(Boolean concluida) {
		this.concluida = concluida;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
