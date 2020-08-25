package br.com.exactalabs.bicycleshop.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String name;

    private boolean done;

    @OneToMany
    @JoinColumn(name = "parent_task_id")
    private Collection<Subtask> subtasks;

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
