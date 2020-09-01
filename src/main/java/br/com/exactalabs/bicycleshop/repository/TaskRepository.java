package br.com.exactalabs.bicycleshop.repository;

import br.com.exactalabs.bicycleshop.entity.Subtask;
import br.com.exactalabs.bicycleshop.entity.Task;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Collection;

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

    public void insert(Task task) {
        try {
            this.entityManager.getTransaction().begin();

            this.entityManager.persist(task);

            this.entityManager.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        }
    }

    public Task update(Task task) {
        this.entityManager.getTransaction().begin();

        var taskUpdated = this.entityManager.merge(task);

        this.entityManager.getTransaction().commit();

        return taskUpdated;
    }

    public Collection<Task> findAll() {
        return this.entityManager
                .createQuery("SELECT t FROM Task t", Task.class)
                .getResultList();
    }


    public void remove(Task task) {
        this.entityManager.getTransaction().begin();

        this.entityManager.remove(task);

        this.entityManager.getTransaction().commit();
    }


}
