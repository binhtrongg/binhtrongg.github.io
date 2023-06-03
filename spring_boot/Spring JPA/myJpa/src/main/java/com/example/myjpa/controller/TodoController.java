package com.example.myjpa.controller;

import com.example.myjpa.entity.Todo;
import com.example.myjpa.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class TodoController {
    TodoRepository todoRepository;

    @GetMapping("/")
    public String getIndex(Model model){
        model.addAttribute("todos",todoRepository.findAll());
        return "index";
    }
    @PostMapping("api/todos")
    public ResponseEntity<?> creatTodo(@RequestBody Todo todo){
        Todo newTodo=new Todo(null,todo.getTitle(),false);
        todoRepository.save(newTodo);
        return new ResponseEntity<>(newTodo, HttpStatus.CREATED);
    }

    @PutMapping("api/todos/{id}")
    public ResponseEntity<?>updateTodo(@PathVariable Integer id,@RequestBody Todo todo){
//        kiểm tra id
        Todo todoUpdated=todoRepository.findById(id).orElseThrow(()->{
            throw new RuntimeException("not found");
        });
//        cập nhật
        todoUpdated.setTitle(todo.getTitle());
        todoUpdated.setStatus(todo.getStatus());
        todoRepository.save(todoUpdated);
        return ResponseEntity.ok(todoUpdated);
    }

    @PostMapping("api/todos{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable Integer id){
        Todo deletedTodo=todoRepository.findById(id).orElseThrow(()->{
            throw new RuntimeException("not found");
        });
        todoRepository.delete(deletedTodo);
        return ResponseEntity.noContent().build();
    }
}
