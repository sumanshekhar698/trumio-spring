package com.spring.orm.service;

import com.opencsv.CSVReader;
import com.spring.orm.entities.Worker;
import com.spring.orm.entities.Task;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStreamReader;
import java.util.*;

@Service
public class WorkerCsvLoaderService {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public void loadDataFromCsv() {

		// Prevent duplicate workers
		Map<String, Worker> workerMap = new HashMap<>();

		try (CSVReader reader = new CSVReader(new InputStreamReader(
				Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("data/workers.csv"))))) {

			String[] line;
			reader.readNext(); // Skip header

			while ((line = reader.readNext()) != null) {

				String workerName = line[0];
				String taskName = line[1];

				// 1️ Get or create Worker
				Worker worker = workerMap.get(workerName);
				if (worker == null) {
					worker = new Worker();
					worker.setName(workerName);
					worker.setTasks(new ArrayList<>());
					workerMap.put(workerName, worker);
				}

				// 2️ Create Task
				Task task = new Task();
				task.setTaskName(taskName);
				task.setWorker(worker); // owning side

				worker.getTasks().add(task); // inverse side
			}

			// 3️ Persist workers (tasks cascade automatically)
			for (Worker worker : workerMap.values()) {
				sessionFactory.getCurrentSession().persist(worker);
			}

			System.out.println("CSV Import Successful. Workers saved: " + workerMap.size());

		} catch (Exception e) {
			throw new RuntimeException("CSV import failed", e);
		}
	}
}
