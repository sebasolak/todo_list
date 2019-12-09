package pl.sebastian.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.sebastian.model.Task;
import pl.sebastian.service.TaskService;
import pl.sebastian.service.TaskServiceImpl;

import java.util.List;

@Controller
public class TaskController {

    @Autowired private TaskService taskService;
    @Autowired private TaskServiceImpl service;

    @RequestMapping("/")
    public String tasks(Model model) {
        List<Task>tasks=taskService.getAllTasks();
        model.addAttribute("tasks",tasks);
        model.addAttribute("task",new Task());

        model.addAttribute("title","Tasks");
        model.addAttribute("isAdd",true);
        return "task";
    }

    @PostMapping(value="/save")
    public String save(@ModelAttribute Task task, RedirectAttributes redirectAttributes, Model model) {
        Task dbTask=taskService.save(task);
        if(dbTask!=null) {
            redirectAttributes.addFlashAttribute("successmessage","Zapisanie zostało zapisane");
            return "redirect:/";
        } else {
            model.addAttribute("errormessage", "Zapisanie zadania nie powiodło się, spróbój jeszcze raz");
            model.addAttribute("task",task);
            return "task";
        }

    }

    @RequestMapping(value = "/getTask/{id}")
    public String getTask(@PathVariable Long id, Model model) {
        Task task=taskService.findById(id);
        List<Task>tasks=taskService.getAllTasks();
        model.addAttribute("tasks",tasks);
        model.addAttribute("task",task);
        model.addAttribute("title","Edit Task");
        model.addAttribute("isAdd",false);
        return "task";
    }


    @PostMapping(value="/update")
    public String update(@ModelAttribute Task task, RedirectAttributes redirectAttributes, Model model) {
        Task dbTask=taskService.update(task);
        if(dbTask!=null) {
            redirectAttributes.addFlashAttribute("successmessage","Zadanie zostało zaktualizowane");

            return "redirect:/";
        } else {
            model.addAttribute("errormessage", "Aktualizacja zadania nie powiodło się, spróbój jeszcze raz");
            model.addAttribute("task",task);
            return "task"; //bylo task
        }

    }

    @RequestMapping(value = "/deleteTask/{id}")
    public String deleteTask(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        taskService.delete(id);
        redirectAttributes.addFlashAttribute("successmessage","Zadanie zostało usunięte");
        return "redirect:/";
    }

    @RequestMapping(value = "/done")//bylo requestmapping
    public String listTaskDone(Model model) {
        List<Task>tasks=service.listStatus();
        model.addAttribute("tasks",tasks);
        model.addAttribute("task",new Task());
        model.addAttribute("title","Tasks");
        model.addAttribute("isAdd",true);
        return "done";//bylo done
    }

    @RequestMapping(value = "/incomplete")//bylo requestmapping
    public String listTaskIncomplete(Model model) {
        List<Task>tasks=service.listStatusFalse();
       model.addAttribute("tasks",tasks);
        model.addAttribute("task",new Task());
        model.addAttribute("title","Tasks");
        model.addAttribute("isAdd",true);
        return "incomplete";//bylo incomplete
    }

    @RequestMapping(value = "/getTask/done")
    public String getTaskDone(Model model) {
        List<Task>tasks=service.listStatus();
        model.addAttribute("tasks",tasks);
        model.addAttribute("task",new Task());
        model.addAttribute("title","Tasks");
        model.addAttribute("isAdd",true);
        model.addAttribute("errormessage", "Zadanie nie zostało zaktualizowane");//tu sproboj
        return "done";
    }

    @RequestMapping(value = "/getTask/incomplete")
    public String getTaskIncomplete(Model model, RedirectAttributes redirectAttributes) {

        List<Task>tasks=service.listStatusFalse();
        model.addAttribute("tasks",tasks);
        model.addAttribute("task",new Task());
        model.addAttribute("title","Tasks");
        model.addAttribute("isAdd",true);
          model.addAttribute("errormessage", "Zadanie nie zostało zaktualizowane");//tu sproboj
        return "incomplete";
    }

}
