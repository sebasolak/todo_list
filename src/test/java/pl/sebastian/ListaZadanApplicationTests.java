//package pl.sebastian;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import pl.sebastian.model.Task;
//import pl.sebastian.repository.TaskRepository;
//import pl.sebastian.service.TaskService;
//import pl.sebastian.service.TaskServiceImpl;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import static org.mockito.Mockito.*;
//
//@SpringBootTest
//class ListaZadanApplicationTests {
//
//
//    private Task task = new Task();
//
//    @Autowired
//    private TaskService service;
//
//    @Autowired
//    TaskServiceImpl serviceImpl;
//
//    @MockBean
//    private TaskRepository repository;
//
//
//
//    @Test
//    void getListStatusDefaultTest() {
//
//        when(repository.findTaskByStatus()).thenReturn((List<Task>) Stream
//                .of(task, task, task).collect(Collectors.toList()));
//        assert serviceImpl.listStatus().size() == 3;
//    }
//
//    @Test
//    void getListStatusTest() {
//
//        task.setStatus(true);
//        when(repository.findTaskByStatus()).thenReturn((List<Task>) Stream
//                .of(task, task, task, task, task).collect(Collectors.toList()));
//        assert serviceImpl.listStatus().size()==5;
//    }
//
//    @Test
//    void getListStatusFalseTest() {
//
//        task.setStatus(false);
//        when(repository.findTaskByStatusFalse()).thenReturn((List<Task>) Stream
//                .of(task,task,task).collect(Collectors.toList()));
//        assert serviceImpl.listStatusFalse().size()==3;
//    }
//
//    @Test
//    void getListMergeStatusTrueAndFalseTest() {
//
//        Task task=new Task();
//        Task task2=new Task();
//        task.setStatus(true);
//        task2.setStatus(false);
//        when(repository.findTaskByStatus()).thenReturn((List<Task>) Stream
//                .of(task, task).collect(Collectors.toList()));
//        when(repository.findTaskByStatusFalse()).thenReturn((List<Task>) Stream
//                .of(task2,task2,task2).collect(Collectors.toList()));
//        assert serviceImpl.listStatus().size()+serviceImpl.listStatusFalse().size()==5;
//
//    }
//
//    @Test
//    void getStatusStringTest() {
//        task.setStatus(true);
//        assert task.getStatus().equals("Wykonane");
//
//    }
//
//    @Test
//    void getStatusStringFalseTest() {
//        task.setStatus(false);
//        assert task.getStatus().equals("Niewykonane");
//    }
//
//
//    @Test
//    void getTaskTest() {
//        when(repository.findAll()).thenReturn((Iterable<Task>) Stream
//                .of(task, task).collect(Collectors.toList()));
//        assert service.getAllTasks().size() == 2;
//    }
//
//    @Test
//    void saveTaskTest() {
//        task.setStatus(false);
//        task.setTaskName("Napisać testy");
//        task.setTaskDescription("Napisać testy jednostkowe");
//        when(repository.save(task)).thenReturn(task);
//
//        assert task.equals(service.save(task));
//    }
//
//    @Test
//    void deleteTaskTest() {
//        task.setStatus(true);
//        task.setTaskName("Prezenty");
//        task.setTaskDescription("Zakup prezentów świątecznych");
//
//        service.delete(task.getId());
//
//        verify(repository, times(1)).deleteById(task.getId());
//    }
//
//    @Test
//    void updateTaskTest() {
//
//        when(serviceImpl.update(task)).thenReturn(task);
//        assert task.equals(service.update(task));
//
//    }
//
//    @Test
//    void findAllTest() {
//
//        List<Task>tasks=new ArrayList<>();
//        when(repository.findAll()).thenReturn(tasks);
//        List<Task>returned=service.getAllTasks();
//        verify(repository,times(1)).findAll();
//        verifyNoMoreInteractions(repository);
//
//        assert tasks.equals(returned);
//
//    }
//
//    @Test
//    void findByIdTest() {
//
//        when(repository.findById(task.getId())).thenReturn(Optional.ofNullable(task));
//
//        Task returned=service.findById(task.getId());
//
//        verify(repository,times(1)).findById(task.getId());
//        verifyNoMoreInteractions(repository);
//
//        assert task.equals(returned);
//    }
//
//
//
//}
