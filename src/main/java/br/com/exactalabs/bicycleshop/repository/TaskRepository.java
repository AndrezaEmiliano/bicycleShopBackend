package br.com.exactalabs.bicycleshop.repository;

import br.com.exactalabs.bicycleshop.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByDone(boolean done);

    List<Task> findByNameLikeOrderByNameAsc(String name);

    @Query("SELECT t.name FROM Task t")
    List<String> findAllTasksName();

    List<Task> findBySubtasksDone(boolean done);

}
