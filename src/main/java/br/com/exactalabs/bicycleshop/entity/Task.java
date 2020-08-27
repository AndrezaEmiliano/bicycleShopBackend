package br.com.exactalabs.bicycleshop.entity;

import org.hibernate.annotations.Columns;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collection;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome não pode ser nulo.")
    @Column(name = "description")
    private String name;

    private boolean done;

    @OneToMany
    @JoinColumn(name = "parent_task_id")
    private Collection<Subtask> subtasks;

    public Task() {}

    public Task(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Collection<Subtask> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(Collection<Subtask> subtasks) {
        this.subtasks = subtasks;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", done=" + done +
                '}';
    }

}
