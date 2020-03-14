package br.com.domain.model;

import java.io.Serializable;
import java.sql.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.domain.enums.Status;
/*
 * Os itens do Todo terá as infos de:
 * - id inteiro para salva no banco
 * - nome para descreve-lo
 * - data para fazer uma ordenação caso necessario
 * - status para salvar o status da tarefa
 * 		+ concluida
 * 		+ naoconcluida
 * 		+ com prioridade
 * 		+ sem prioridade
 * 
 */
@ManagedBean
@SessionScoped
@Entity
public class TodoItem implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nome;
	private Date data;
	private Boolean finalizado;
	private Boolean prioridade;
	
	public Boolean getFinalizado() {
		return finalizado;
	}
	public void setFinalizado(Boolean finalizado) {
		this.finalizado = finalizado;
	}
	public Boolean getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(Boolean prioridade) {
		this.prioridade = prioridade;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	
	
	
	

	
	
	
	
	
}
