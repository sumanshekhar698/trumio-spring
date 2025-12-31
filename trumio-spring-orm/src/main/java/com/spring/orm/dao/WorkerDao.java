package com.spring.orm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.orm.entities.Worker;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class WorkerDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(readOnly = true)
	public Worker getWorkerById(int id) {
		return sessionFactory.getCurrentSession().get(Worker.class, id);
	}

	@Transactional(readOnly = true)
	public void loadTasks(int id) {
		Worker worker = sessionFactory.getCurrentSession().get(Worker.class, id);

		// Triggers lazy collection initialization
		System.out.println(worker.getTasks().size());
	}
}
