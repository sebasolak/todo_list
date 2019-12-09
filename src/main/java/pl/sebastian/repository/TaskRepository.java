package pl.sebastian.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.sebastian.model.Task;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {

@Query("SELECT t from Task t WHERE t.status=true")
List<Task> findTaskByStatus();


@Query("SELECT t from Task t WHERE t.status=false")
List<Task> findTaskByStatusFalse();


}


