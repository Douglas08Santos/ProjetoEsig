package br.com.domain.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.domain.model.TodoItem;
import br.com.domain.util.HibernateUtil;

@Named("itemMB")
@ManagedBean
@SessionScoped
public class TodoItemMB{

	private TodoItem tarefa;	
	private List<TodoItem> tarefas;
	
	
	public TodoItemMB() {
		tarefa = new TodoItem();
	}

	public TodoItem getTarefa() {
		return tarefa;
	}
	
	public void setTarefa(TodoItem tarefa) {
		this.tarefa = tarefa;
	}
	public List<TodoItem> getTarefas() {
		return tarefas;
	}
	public void setTarefas(List<TodoItem> tarefas) {
		this.tarefas = tarefas;
	}
	
	public void adicionar() {
		EntityManager em = HibernateUtil.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		tarefa = em.merge(tarefa);
		em.persist(tarefa);
		transaction.commit();
		em.close();
		tarefa = new TodoItem();
		atualizar();
		
	}
	
	public void remover() {
		EntityManager em = HibernateUtil.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		tarefa = em.merge(tarefa);
		em.remove(tarefa);
		transaction.commit();
		em.close();
		tarefa = new TodoItem();
		atualizar();
	}

	public void atualizar() {
		EntityManager em = HibernateUtil.getEntityManager();
		String sqlQuery = "select * from tarefa";
		Query query = em.createNativeQuery(sqlQuery, TodoItem.class);
		this.tarefas = query.getResultList();
		em.close();
	}
	
	public void mensagem() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("OK", "OK"));
		System.out.println("mensagem inserida");
	}
	
	
	
}
