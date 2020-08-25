package br.com.exactalabs.bicycleshop.repository;

import br.com.exactalabs.bicycleshop.entity.Task;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class TaskRepository {

    private final EntityManager entityManager;

    public TaskRepository() {
        this.entityManager = Persistence
                .createEntityManagerFactory("br.com.exactalabs.bicycleshop")
                .createEntityManager();
    }

    public Task findById(Long id) {

        return this.entityManager.find(Task.class, id);

    }

}
