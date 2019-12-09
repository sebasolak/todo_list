package pl.sebastian.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sebastian.repository.TaskRepository;
import pl.sebastian.model.Task;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    @Autowired private TaskRepository taskRepository;

   private String pattern = "yyyy-MM-dd HH:mm:ss";
   private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);


    @Override
    public List<Task> getAllTasks() {

        return (List<Task>)taskRepository.findAll();
    }

    @Override
    public Task save(Task task) {

//        if(task.getCreatedDate() == null)
            task.setCreatedDate(new Date());


          String date = simpleDateFormat.format(task.getCreatedDate());
          if(task.getFinalDate()==null)
           task.setFinalDate(date);

        return taskRepository.save(task);
    }

    @Override
    public Task findById(Long id) {
        Optional<Task>task=taskRepository.findById(id);
        if(task.isPresent()){
            return task.get();
        }else {
            return null;
        }


    }

    @Override
    public Task update(Task task) {


      if(task.getCreatedDate()==null)
           task.setCreatedDate(new Date());

      task.setCreatedDate(task.getCreatedDate());

  String date = simpleDateFormat.format(task.getCreatedDate());
          if(task.getFinalDate()==null)
           task.setFinalDate(date);
          else
              task.setFinalDate(task.getFinalDate());

        return taskRepository.save(task);
    }

    @Override
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

   public List<Task>listStatus() {
        return taskRepository.findTaskByStatus();
   }

   public List<Task>listStatusFalse() {
        return taskRepository.findTaskByStatusFalse();
   }
}
