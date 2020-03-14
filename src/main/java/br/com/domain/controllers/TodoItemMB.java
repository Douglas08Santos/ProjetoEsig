package br.com.domain.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.domain.model.TodoItem;
import br.com.domain.util.HibernateUtil;

@Named("itemMB")
@ManagedBean
@SessionScoped
public class TodoItemMB{

	private TodoItem tarefa;	
	private List<TodoItem> tarefas;
	
	
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

	private void atualizar() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
