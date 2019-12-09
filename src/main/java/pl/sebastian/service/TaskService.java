package pl.sebastian.service;

import pl.sebastian.model.Task;

import java.util.List;

public interface TaskService {

    List<Task> getAllTasks();

    Task save(Task task);

    Task findById(Long id);

    Task update(Task task);

    void delete(Long id);

//    @Query("SELECT t from Task t WHERE t.status=true")
//    List<Task> findTaskByStatus();
}
