package com.example.task.controller;

import com.example.task.model.request.TaskRequest;
import com.example.task.model.response.TaskReponse;
import com.example.task.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping
@AllArgsConstructor
public class TaskController {
    TaskService taskService;


    @GetMapping("/")
    public String getALl(Model model) {
        List<TaskReponse> tasks = taskService.getTasks();
        model.addAttribute("tasks", tasks);
        return "index";
    }

    @GetMapping("/api/v1/tasks/status")
    public ResponseEntity<?> Status() {
        return ResponseEntity.ok(taskService.getStatus());
    }

    @PostMapping("/api/v1/tasks")
    public ResponseEntity<?> create(@RequestBody @Valid TaskRequest createRequest) {
        taskService.saveTask(createRequest);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/api/v1/tasks/{id}")
    public ResponseEntity<?> Detail(@PathVariable Integer id) {
        return ResponseEntity.ok(taskService.getDetail(id));
    }

    @PutMapping("/api/v1/tasks")
    public ResponseEntity<?> update(@RequestBody @Valid TaskRequest updateRequest) {
        taskService.updatetask(updateRequest);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/api/v1/tasks/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        taskService.delete(id);
        return ResponseEntity.ok(null);
    }
}
